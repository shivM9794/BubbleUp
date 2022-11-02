package app.bubbleup.DashboardSection;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

import app.bubbleup.Adapter.OnSiteAdapter;
import app.bubbleup.Adapter.SliderAdapter;
import app.bubbleup.Adapter.TopServicesAdapter;
import app.bubbleup.BottomNavigationSection.BookingActivity;
import app.bubbleup.BottomNavigationSection.OffersActivity;
import app.bubbleup.LoginSection.LoginActivity;
import app.bubbleup.Model.ServiceModel;
import app.bubbleup.Model.SliderModel;
import app.bubbleup.R;
import app.bubbleup.SideNavigationSection.About_UsActivity;
import app.bubbleup.SideNavigationSection.ComplaintActivity;
import app.bubbleup.SideNavigationSection.ProfileActivity;
import app.bubbleup.SideNavigationSection.ServicesActivity;
import me.ibrahimsn.lib.OnItemSelectedListener;
import me.ibrahimsn.lib.SmoothBottomBar;

public class DashboardActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    SmoothBottomBar bottomNavigationView;
    ImageView imageView;
    SliderView sliderView;
    RecyclerView recyclerTopServices, recyclerOnsite;
    TopServicesAdapter topServicesAdapter;
    OnSiteAdapter onSiteAdapter;
    Button logout_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        initViews();
        navigationdrawer();
        animateDrawer();
        topLaundaryServices();
        onSiteServices();
        sliderImage();


        bottomNavigationView.setOnItemSelectedListener((OnItemSelectedListener) (int i) -> {
            switch (i) {

                case 1:
                    Intent intent1 = new Intent(getApplicationContext(), BookingActivity.class);
                    startActivity(intent1);
                    break;
                case 2:
                    Intent intent2 = new Intent(getApplicationContext(), OffersActivity.class);
                    startActivity(intent2);
                    break;


            }

            return true;
        });
    }

    private void sliderImage() {

        ArrayList<Integer> slider = new ArrayList<>();
        slider.add(R.drawable.laundary1);
        slider.add(R.drawable.laundary1);
        slider.add(R.drawable.laundary1);
        slider.add(R.drawable.laundary1);
        SliderAdapter sliderAdapter = new SliderAdapter(slider, getApplicationContext());
        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);
        sliderView.setScrollTimeInSec(3);
        sliderView.setAutoCycle(true);
        sliderView.startAutoCycle();
    }

    private void onSiteServices() {
        recyclerOnsite.setHasFixedSize(true);
        recyclerOnsite.setLayoutManager(new GridLayoutManager(this, 2));
        ArrayList<ServiceModel> serviceModels = new ArrayList<>();
        serviceModels.add(new ServiceModel("Sofa Set Cleaning", R.drawable.sofa, "sds"));
        serviceModels.add(new ServiceModel("Carpet Cleaning", R.drawable.carpet, "sds"));
        serviceModels.add(new ServiceModel("Full House Cleaning", R.drawable.full_home, "sds"));
        serviceModels.add(new ServiceModel("Flooring", R.drawable.flooring, "sds"));
        serviceModels.add(new ServiceModel("Car Cleaning", R.drawable.car, "sds"));
        onSiteAdapter = new OnSiteAdapter(this, serviceModels);
        recyclerOnsite.setAdapter(onSiteAdapter);
    }

    private void topLaundaryServices() {
        recyclerTopServices.setHasFixedSize(true);
        recyclerTopServices.setLayoutManager(new GridLayoutManager(this, 2));
        ArrayList<ServiceModel> serviceModels = new ArrayList<>();
        serviceModels.add(new ServiceModel("Washing", R.drawable.washing_machine, "dss"));
        serviceModels.add(new ServiceModel("Steam Iron", R.drawable.stem_iron, "dss"));
        serviceModels.add(new ServiceModel("Dry Cleaning", R.drawable.dry_cleaning, "dss"));
        topServicesAdapter = new TopServicesAdapter(this, serviceModels);
        recyclerTopServices.setAdapter(topServicesAdapter);

    }

    private void initViews() {

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        imageView = findViewById(R.id.idMenu);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        recyclerTopServices = findViewById(R.id.recyclerTopServices);
        recyclerOnsite = findViewById(R.id.recyclerOnsite);
        logout_btn = findViewById(R.id.logout_btn);
        sliderView = findViewById(R.id.slider_image);
    }

    private void navigationdrawer() {

        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.partner);


        imageView.setOnClickListener(v -> {
            if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START);
            } else {
                drawerLayout.openDrawer(GravityCompat.START);


            }

        });

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else
            super.onBackPressed();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.partner:
                Intent intent = new Intent(getApplicationContext(), ComplaintActivity.class);
                startActivity(intent);
                break;

            case R.id.services:
                Intent intent1 = new Intent(getApplicationContext(), ServicesActivity.class);
                startActivity(intent1);
                break;

            case R.id.share_society_app:
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareSubject = "Bubble Up";
                String shareBodyText = "https://play.google.com/store/apps/details?id=com.secondwarranty.app";
                sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBodyText);
                sharingIntent.putExtra(Intent.EXTRA_SUBJECT, shareSubject);
                startActivity(Intent.createChooser(sharingIntent, "Share using"));
                break;

            case R.id.rate:
//                Intent intent2 = new Intent(getApplicationContext(), ResidentCommittee.class);
//                startActivity(intent2);
                break;

            case R.id.pickup:
                Intent intent3 = new Intent(getApplicationContext(), WashingActivity.class);
                startActivity(intent3);
                break;

            case R.id.about_us:
                Intent intent4 = new Intent(getApplicationContext(), About_UsActivity.class);
                startActivity(intent4);
                break;

            case R.id.profile:
                Intent intent5 = new Intent(getApplicationContext(), ProfileActivity.class);
                startActivity(intent5);
                break;


        }
        return true;
    }

    final float END_SCALE = 0.8f;

    private void animateDrawer() {

        RelativeLayout contentView = findViewById(R.id.layoutToolbar);

        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {

            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

                final float diffScaledOffset = slideOffset * (1 - END_SCALE);
                final float offsetScale = 1 - diffScaledOffset;
                contentView.setScaleX(offsetScale);
                contentView.setScaleY(offsetScale);

                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = contentView.getWidth() * diffScaledOffset / 2;
                final float xTranslation = xOffset - xOffsetDiff;
                contentView.setTranslationX(xTranslation);

            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });

    }

    public void logout_button(View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(DashboardActivity.this);
        builder.setTitle("Bubble Up");
        builder.setMessage("Are you sure you want to exit ?");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", (dialog, which) -> {
            Intent intent1 = new Intent(getApplicationContext(), LoginActivity.class);
            intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent1);
            finish();

        });
        builder.setNegativeButton("No", (dialog, which) -> {

        });
        builder.create().show();
    }
}

