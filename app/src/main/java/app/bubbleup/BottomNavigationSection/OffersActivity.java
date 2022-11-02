package app.bubbleup.BottomNavigationSection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

import app.bubbleup.Adapter.OfferAdapter;
import app.bubbleup.DashboardSection.DashboardActivity;
import app.bubbleup.Model.OfferModel;
import app.bubbleup.R;

public class OffersActivity extends AppCompatActivity {

    ImageView back_arrow;
    RecyclerView recyclerMyOffers;
    OfferAdapter offerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offers);
        initViews();
        myOffers();
    }

    private void myOffers() {
        recyclerMyOffers.setHasFixedSize(true);
        recyclerMyOffers.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        ArrayList<OfferModel> offerModels = new ArrayList<>();
        offerModels.add(new OfferModel(R.drawable.refer_earn));
        offerAdapter = new OfferAdapter(this,offerModels);
        recyclerMyOffers.setAdapter(offerAdapter);

    }

    private void initViews() {

        back_arrow = findViewById(R.id.back_arrow);
        back_arrow.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
            startActivity(intent);
            finish();
        });

        recyclerMyOffers = findViewById(R.id.recyclerMyOffers);
    }
}