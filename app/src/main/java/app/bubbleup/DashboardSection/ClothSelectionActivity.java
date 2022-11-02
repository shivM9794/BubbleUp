package app.bubbleup.DashboardSection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

import app.bubbleup.Adapter.PopularShopAdapter;
import app.bubbleup.Adapter.ShopSelectionAdapter;
import app.bubbleup.Model.PopularShopModel;
import app.bubbleup.Model.ShopModel;
import app.bubbleup.R;

public class ClothSelectionActivity extends AppCompatActivity {

    ImageView back_arrow;
    RecyclerView recyclerShopList,recyclerPopularShopList;
    ShopSelectionAdapter shopSelectionAdapter;
    PopularShopAdapter popularShopAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cloth_selection);

        initViews();
        selectShop();
        popularShop();
    }

    private void popularShop() {
        recyclerPopularShopList.setHasFixedSize(true);
        recyclerPopularShopList.setLayoutManager(new GridLayoutManager(this,3));
        ArrayList<PopularShopModel> popularShopModels = new ArrayList<>();
        popularShopModels.add(new PopularShopModel("Tumble Dry",R.drawable.laundary_gaur));
        popularShopModels.add(new PopularShopModel("Tumble Dry",R.drawable.popular_laundary1));
        popularShopModels.add(new PopularShopModel("Tumble Dry",R.drawable.popular_laundary2));
        popularShopModels.add(new PopularShopModel("Tumble Dry",R.drawable.popular_laundary3));
        popularShopModels.add(new PopularShopModel("Tumble Dry",R.drawable.popular_laundary4));
        popularShopModels.add(new PopularShopModel("Tumble Dry",R.drawable.popular_laundary5));
        popularShopAdapter = new PopularShopAdapter(this,popularShopModels);
        recyclerPopularShopList.setAdapter(popularShopAdapter);
    }

    private void selectShop() {
        recyclerShopList.setHasFixedSize(true);
        recyclerShopList.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        ArrayList<ShopModel> shopModels = new ArrayList<>();
        shopModels.add(new ShopModel("XYZ Laundary Center","EK Murti Chauraha","From 8:00 Am to 10:00 Pm",R.drawable.laundary_shop));
        shopModels.add(new ShopModel("New Laundary Center","Sector 62","From 8:00 Am to 10:00 Pm",R.drawable.laundary_shop));
        shopModels.add(new ShopModel("Lovely Laundary Center","Sector 63","From 8:00 Am to 10:00 Pm",R.drawable.laundary_shop));
        shopModels.add(new ShopModel("Happy Laundary Center","Near Sky Gardens","From 8:00 Am to 10:00 Pm",R.drawable.laundary_shop));
        shopModels.add(new ShopModel("Prince Laundary Center","Near Gaur City ","From 8:00 Am to 10:00 Pm",R.drawable.laundary_shop));
        shopModels.add(new ShopModel("XYZ Laundary Center","EK Murti Chauraha","From 8:00 Am to 10:00 Pm",R.drawable.laundary_shop));
        shopSelectionAdapter = new ShopSelectionAdapter(this,shopModels);
        recyclerShopList.setAdapter(shopSelectionAdapter);
    }

    private void initViews() {

        back_arrow = findViewById(R.id.back_arrow);
        back_arrow.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(),WashingActivity.class);
            startActivity(intent);
        });

        recyclerShopList = findViewById(R.id.recyclerShopList);
        recyclerPopularShopList = findViewById(R.id.recyclerPopularShopList);
    }
}