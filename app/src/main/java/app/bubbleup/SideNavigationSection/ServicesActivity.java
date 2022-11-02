package app.bubbleup.SideNavigationSection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

import app.bubbleup.Adapter.OurServiceAdapter;
import app.bubbleup.DashboardSection.DashboardActivity;
import app.bubbleup.Model.Service;
import app.bubbleup.R;

public class ServicesActivity extends AppCompatActivity {

    ImageView back_arrow;
    RecyclerView recyclerService;
    OurServiceAdapter ourServiceAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

        initViews();
        serviceWeOffer();
    }

    private void serviceWeOffer() {
        recyclerService.setHasFixedSize(true);
        recyclerService.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        ArrayList<Service> services = new ArrayList<>();
        services.add(new Service(R.drawable.dry_cleaning,"Dry Cleaning","We have an expert team of dry cleaners"));
        services.add(new Service(R.drawable.laundary1,"Laundary","We have an expert team of  cleaners"));
        services.add(new Service(R.drawable.stem_iron,"Steam Iron","We have an modern steam iron"));
        services.add(new Service(R.drawable.washing,"Washing","We have an expert team of washers"));
        ourServiceAdapter = new OurServiceAdapter(this,services);
        recyclerService.setAdapter(ourServiceAdapter);
    }

    private void initViews() {
        back_arrow = findViewById(R.id.back_arrow);
        back_arrow.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
            startActivity(intent);
        });
        recyclerService = findViewById(R.id.recyclerService);
    }
}