package app.bubbleup.DashboardSection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

import app.bubbleup.Adapter.SelectClothAdapter;
import app.bubbleup.LocationAndPayment.LocationAndPaymentActivity;
import app.bubbleup.Model.SelectClothModel;
import app.bubbleup.R;

public class ShopSelectionActivity extends AppCompatActivity {

    ImageView back_arrow;
    RecyclerView recyclerSelectClothes;
    SelectClothAdapter selectClothAdapter;
    Button proceed_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_selection);
        initViews();
        selectClothes();
    }

    private void selectClothes() {
        recyclerSelectClothes.setHasFixedSize(true);
        recyclerSelectClothes.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        ArrayList<SelectClothModel> selectClothModels = new ArrayList<>();
        selectClothModels.add(new SelectClothModel(R.drawable.shirt,"Shirts","Will be delivered within 2 days","₹ 20 per shirt"));
        selectClothModels.add(new SelectClothModel(R.drawable.pant,"Pant","Will be delivered within 2 days","₹ 20 per pant"));
        selectClothAdapter = new SelectClothAdapter(this,selectClothModels);
        recyclerSelectClothes.setAdapter(selectClothAdapter);
    }

    private void initViews() {
        back_arrow = findViewById(R.id.back_arrow);
        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),WashingActivity.class);
                startActivity(intent);
            }
        });

        recyclerSelectClothes = findViewById(R.id.recyclerSelectClothes);
        proceed_btn = findViewById(R.id.proceed_btn);
        proceed_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SelectDateTimeActivity.class);
                startActivity(intent);

            }
        });
    }
}