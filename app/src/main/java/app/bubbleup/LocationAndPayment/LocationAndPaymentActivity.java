package app.bubbleup.LocationAndPayment;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.List;
import java.util.Locale;

import app.bubbleup.DashboardSection.SelectDateTimeActivity;
import app.bubbleup.R;
import cn.pedant.SweetAlert.SweetAlertDialog;

public class LocationAndPaymentActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapLongClickListener, LocationListener {

    ImageView back_arrow;
    Location currentLocation;
    FusedLocationProviderClient fusedLocationProviderClient;
    private static final int REQUEST_CODE = 101;
    private GoogleMap googleMap;
    private Geocoder geocoder;
    private Button button;
    LocationManager locationManager;
    TextView tvLocality, txt_addNewAddress;
    private static final String TAG = null;
    RadioButton cod, online_payment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_and_payment);
        initViews();

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(getApplicationContext());
        fetchLastLocation();

        tvLocality = findViewById(R.id.tvLocality);

        locationManager = (LocationManager) getApplicationContext().getSystemService(Context.LOCATION_SERVICE);
        locationEnabled();
        getLocation();

    }

    private void initViews() {
        back_arrow = findViewById(R.id.back_arrow);
        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SelectDateTimeActivity.class);
                startActivity(intent);
            }
        });

        txt_addNewAddress = findViewById(R.id.txt_addNewAddress);
        txt_addNewAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNewAddress();
            }
        });

//        Checkout.preload(getApplicationContext());
          cod = findViewById(R.id.cod);
          cod.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  successMessage();

              }
          });
//        online_payment = findViewById(R.id.online_payment);
//        online_payment.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                makepayment();
//            }
//        });

    }

    public void successMessage() {
        new SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE).setTitleText("Congrats!").setContentText("You Pickup has been scheduled!").show();

    }

//    private void makepayment() {
//        Checkout checkout = new Checkout();
//
//        checkout.setKeyID("rzp_test_JuiYmArGmYBP4F");
//
//        checkout.setImage(R.drawable.splash_icon);
//
//        final Activity activity = this;
//
//
//        try {
//            JSONObject options = new JSONObject();
//
//            options.put("name", "Bubble Up");
//            options.put("description", "Reference No. #123456");
//            options.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.png");
////                options.put("order_id", "order_DBJOWzybf0sJbb");//from response of step 3.
//            options.put("theme.color", "#3399cc");
//            options.put("currency", "INR");
//            options.put("amount", "55400");//pass amount in currency subunits
//            options.put("prefill.email", "gaurav.kumar@example.com");
//            options.put("prefill.contact", "9407106470");
//            JSONObject retryObj = new JSONObject();
//            retryObj.put("enabled", true);
//            retryObj.put("max_count", 4);
//            options.put("retry", retryObj);
//
//            checkout.open(activity, options);
//
//        } catch (Exception e) {
//            Log.e(TAG, "Error in starting Razorpay Checkout", e);
//        }
//    }

    private void addNewAddress() {

        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(LocationAndPaymentActivity.this, R.style.BottomSheetDialogTheme);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.add_new_address, (LinearLayout) findViewById(R.id.bottomSheetContainer));
        //EditText forgot_et_email = bottomSheetView.findViewById(R.id.forgot_et_email);
        bottomSheetView.findViewById(R.id.sub_btn).setOnClickListener(v -> {

            bottomSheetDialog.dismiss();
            Intent submit = new Intent(getApplicationContext(), LocationAndPaymentActivity.class);
            startActivity(submit);

            // String mail = forgot_et_email.getText().toString();

            // otp_sent(mail);
            finish();
        });
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }


    private void locationEnabled() {

        LocationManager lm = (LocationManager) getApplicationContext().getSystemService(Context.LOCATION_SERVICE);
        boolean gps_enabled = false;
        boolean network_enabled = false;
        try {
            gps_enabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            network_enabled = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!gps_enabled && !network_enabled) {
            new AlertDialog.Builder(getApplicationContext())
                    .setTitle("Enable GPS Service")
                    .setMessage("We need your GPS location to show Near Places around you.")
                    .setCancelable(false)
                    .setPositiveButton("Enable", new
                            DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                                    startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                                }
                            })
                    .setNegativeButton("Cancel", null)
                    .show();
        }
    }

    @SuppressLint("MissingPermission")
    private void getLocation() {

        try {
            locationManager = (LocationManager) getApplicationContext().getSystemService(Context.LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 5, 5, (LocationListener) this);
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

    private void fetchLastLocation() {

        if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions((Activity) getApplicationContext(), new String[]
                    {Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE);
            return;
        }
        @SuppressLint("MissingPermission") Task<Location> task = fusedLocationProviderClient.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location != null) {
                    currentLocation = location;
//                    Toast.makeText(getActivity(), currentLocation.getLatitude()
//                            + "" + currentLocation.getLongitude(), Toast.LENGTH_SHORT).show();
                    SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map_own);
                    supportMapFragment.getMapAsync(LocationAndPaymentActivity.this);

                }
            }
        });
    }


    @Override
    public void onLocationChanged(@NonNull Location location) {

        try {
            Geocoder geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());
            List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);

            tvLocality.setText(addresses.get(0).getAddressLine(0));

        } catch (Exception e) {
        }

    }

    @Override
    public void onMapLongClick(@NonNull LatLng latLng) {

        Log.d(TAG, "onMapLongClick: " + latLng.toString());

    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

        LatLng latLng = new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude());
        MarkerOptions markerOptions = new MarkerOptions().position(latLng)
                .draggable(true)
                .title("Current Location");

        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(latLng, 18);
        googleMap.animateCamera(cameraUpdate);
        googleMap.addMarker(markerOptions);
//        googleMap.addMarker(new MarkerOptions().position(latLng).title("Current Location"));
        googleMap.setOnMapLongClickListener(this);

    }
}