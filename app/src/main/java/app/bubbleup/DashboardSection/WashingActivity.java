
package app.bubbleup.DashboardSection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

import app.bubbleup.Adapter.ClothListAdapter;
import app.bubbleup.Model.ClothModel;
import app.bubbleup.R;

public class WashingActivity extends AppCompatActivity {

    ImageView back_arrow;
    RecyclerView recyclerWashing;
    ClothListAdapter clothListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_washing);
        back_arrow = findViewById(R.id.back_arrow);
        back_arrow.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(),DashboardActivity.class);
            startActivity(intent);
        });
        recyclerWashing = findViewById(R.id.recyclerWashing);
        clothList();
    }

    private void clothList() {
        recyclerWashing.setHasFixedSize(true);
        recyclerWashing.setLayoutManager(new GridLayoutManager(this,3));
        ArrayList<ClothModel> clothModels = new ArrayList<>();
        clothModels.add(new ClothModel("Shirts",R.drawable.shirt));
        clothModels.add(new ClothModel("Sarees",R.drawable.saree));
        clothModels.add(new ClothModel("Suit(3 Pic)",R.drawable.three_piece_suits));
        clothModels.add(new ClothModel("Lehnga(2 Pic)",R.drawable.two_lehenga));
        clothModels.add(new ClothModel("Lehnga(3 Pic)",R.drawable.three_lehenga));
        clothModels.add(new ClothModel("Jeans",R.drawable.jeans));
        clothModels.add(new ClothModel("Pant",R.drawable.pant));
        clothModels.add(new ClothModel("T-shirts",R.drawable.tshirt));
        clothModels.add(new ClothModel("Gown",R.drawable.gown));
        clothModels.add(new ClothModel("Kurta",R.drawable.kurta));
        clothModels.add(new ClothModel("Shawal",R.drawable.shawl));
        clothModels.add(new ClothModel("Cardigan",R.drawable.cardigan));
        clothModels.add(new ClothModel("Coat Long",R.drawable.coat_long));
        clothModels.add(new ClothModel("Jacket",R.drawable.jacket));
        clothModels.add(new ClothModel("Leather Jacket",R.drawable.leather_jacket));
        clothModels.add(new ClothModel("Track Suit",R.drawable.tack_suit));
        clothListAdapter = new ClothListAdapter(this,clothModels);
        recyclerWashing.setAdapter(clothListAdapter);
    }
}