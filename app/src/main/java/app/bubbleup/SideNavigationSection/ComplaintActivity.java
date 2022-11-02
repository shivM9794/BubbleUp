package app.bubbleup.SideNavigationSection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.card.MaterialCardView;

import app.bubbleup.DashboardSection.DashboardActivity;
import app.bubbleup.R;

public class ComplaintActivity extends AppCompatActivity {

    ImageView back_arrow;
    MaterialCardView materialCardView1, materialCardView2, materialCardView3, materialCardView4,
            materialCardView_et1, materialCardView_et2, materialCardView_et3, materialCardView_et4;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint);
        initViews();
    }

    private void initViews() {

        back_arrow = findViewById(R.id.back_arrow);
        back_arrow.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
            startActivity(intent);
        });

        materialCardView1 = findViewById(R.id.service_experience);
        materialCardView2 = findViewById(R.id.materialCard2);
        materialCardView3 = findViewById(R.id.materialCard3);
        materialCardView4 = findViewById(R.id.materialCard4);
        materialCardView_et1 = findViewById(R.id.et_cardView1);
        materialCardView_et2 = findViewById(R.id.et_cardView2);
        materialCardView_et3 = findViewById(R.id.et_cardView3);
        materialCardView_et4 = findViewById(R.id.et_cardView4);
        submit = findViewById(R.id.btn_submit);


        materialCardView1.setOnClickListener(v -> {
            materialCardView_et1.setVisibility(View.VISIBLE);
            materialCardView_et2.setVisibility(View.GONE);
            materialCardView_et3.setVisibility(View.GONE);
            materialCardView_et4.setVisibility(View.GONE);
            submit.setVisibility(View.VISIBLE);
        });
        materialCardView2.setOnClickListener(v -> {
            materialCardView_et2.setVisibility(View.VISIBLE);
            materialCardView_et1.setVisibility(View.GONE);
            materialCardView_et3.setVisibility(View.GONE);
            materialCardView_et4.setVisibility(View.GONE);
            submit.setVisibility(View.VISIBLE);
        });
        materialCardView3.setOnClickListener(v -> {
            materialCardView_et3.setVisibility(View.VISIBLE);
            materialCardView_et1.setVisibility(View.GONE);
            materialCardView_et2.setVisibility(View.GONE);
            materialCardView_et4.setVisibility(View.GONE);
            submit.setVisibility(View.VISIBLE);
        });
        materialCardView4.setOnClickListener(v -> {
            materialCardView_et4.setVisibility(View.VISIBLE);
            materialCardView_et1.setVisibility(View.GONE);
            materialCardView_et2.setVisibility(View.GONE);
            materialCardView_et3.setVisibility(View.GONE);
            submit.setVisibility(View.VISIBLE);
        });
    }

    public void submitQuery(View view) {

        Toast.makeText(getApplicationContext(), "Response submitted successfully " , Toast.LENGTH_SHORT).show();
    }
}