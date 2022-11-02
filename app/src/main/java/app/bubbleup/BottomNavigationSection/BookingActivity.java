package app.bubbleup.BottomNavigationSection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

import app.bubbleup.Adapter.BookingAdapter;
import app.bubbleup.DashboardSection.DashboardActivity;
import app.bubbleup.Model.BookingModel;
import app.bubbleup.R;

public class BookingActivity extends AppCompatActivity {

    ImageView back_arrow;
    RecyclerView recyclerMyBookings;
    BookingAdapter bookingAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        initViews();
        myBookings();
    }

    private void myBookings() {
        recyclerMyBookings.setHasFixedSize(true);
        recyclerMyBookings.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        ArrayList<BookingModel> bookingModels = new ArrayList<>();
        bookingModels.add(new BookingModel(R.drawable.shirt,"Shirt","Pickup done 28 Aug 2022 at 10 Am","Delivered on 30 Aug 22 at 7 Pm"));
        bookingModels.add(new BookingModel(R.drawable.jacket,"Jacket","Pickup done 28 Aug 2022 at 10 Am","Delivered on 30 Aug 22 at 7 Pm"));
        bookingModels.add(new BookingModel(R.drawable.saree,"Saree","Pickup done 28 Aug 2022 at 10 Am","Delivered on 30 Aug 22 at 7 Pm"));
        bookingAdapter = new BookingAdapter(this,bookingModels);
        recyclerMyBookings.setAdapter(bookingAdapter);
    }

    private void initViews() {

        back_arrow = findViewById(R.id.back_arrow);
        back_arrow.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
            startActivity(intent);
            finish();
        });

        recyclerMyBookings = findViewById(R.id.recyclerMyBookings);
    }
}