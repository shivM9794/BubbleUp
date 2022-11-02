package app.bubbleup.DashboardSection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.card.MaterialCardView;

import app.bubbleup.LocationAndPayment.LocationAndPaymentActivity;
import app.bubbleup.R;

public class SelectDateTimeActivity extends AppCompatActivity {

    ImageView back_arrow;
    Button proceedBtn;
    MaterialCardView card1, card2, card3, card_time1, card_time2, card_time3, card_time4;
    TextView text_month_day,text_month_day1,text_month_day2,time_slot1,time_slot2,time_slot3,time_slot4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_date_time);
        initViews();
    }

    private void initViews() {

        back_arrow = findViewById(R.id.back_arrow);
        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ShopSelectionActivity.class);
                startActivity(intent);
            }
        });

        proceedBtn = findViewById(R.id.proceedBtn);
        proceedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LocationAndPaymentActivity.class);
                startActivity(intent);
            }
        });

        text_month_day = findViewById(R.id.text_month_day);
        text_month_day1 = findViewById(R.id.text_month_day1);
        text_month_day2 = findViewById(R.id.text_month_day2);
        time_slot1 = findViewById(R.id.time_slot1);
        time_slot2 = findViewById(R.id.time_slot2);
        time_slot3= findViewById(R.id.time_slot3);
        time_slot4 = findViewById(R.id.time_slot4);
        card1 = findViewById(R.id.card1);
        card2 = findViewById(R.id.card2);
        card3 = findViewById(R.id.card3);
        card_time1 = findViewById(R.id.card_time1);
        card_time2 = findViewById(R.id.card_time2);
        card_time3 = findViewById(R.id.card_time3);
        card_time4 = findViewById(R.id.card_time4);

        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                card1.setStrokeColor(getResources().getColor(R.color.yellow_stroke));
                card2.setStrokeColor(getResources().getColor(R.color.gray_color));
                card3.setStrokeColor(getResources().getColor(R.color.gray_color));
               // schedule_date = dates1;
            }
        });

        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                card1.setStrokeColor(getResources().getColor(R.color.gray_color));
                card2.setStrokeColor(getResources().getColor(R.color.yellow_stroke));
                card3.setStrokeColor(getResources().getColor(R.color.gray_color));
                //schedule_date = dates2;
            }
        });

        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                card1.setStrokeColor(getResources().getColor(R.color.gray_color));
                card2.setStrokeColor(getResources().getColor(R.color.gray_color));
                card3.setStrokeColor(getResources().getColor(R.color.yellow_stroke));
               // schedule_date = dates3;
            }
        });

        card_time1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                card_time1.setStrokeColor(getResources().getColor(R.color.yellow_stroke));
                card_time2.setStrokeColor(getResources().getColor(R.color.gray_color));
                card_time3.setStrokeColor(getResources().getColor(R.color.gray_color));
                card_time4.setStrokeColor(getResources().getColor(R.color.gray_color));
                //schedule_time = time_slot1.getText().toString();
            }
        });
        card_time2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                card_time1.setStrokeColor(getResources().getColor(R.color.gray_color));
                card_time2.setStrokeColor(getResources().getColor(R.color.yellow_stroke));
                card_time3.setStrokeColor(getResources().getColor(R.color.gray_color));
                card_time4.setStrokeColor(getResources().getColor(R.color.gray_color));
                //schedule_time = time_slot2.getText().toString();
            }
        });
        card_time3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                card_time1.setStrokeColor(getResources().getColor(R.color.gray_color));
                card_time2.setStrokeColor(getResources().getColor(R.color.gray_color));
                card_time3.setStrokeColor(getResources().getColor(R.color.yellow_stroke));
                card_time4.setStrokeColor(getResources().getColor(R.color.gray_color));
                //schedule_time = time_slot3.getText().toString();
            }
        });
        card_time4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                card_time1.setStrokeColor(getResources().getColor(R.color.gray_color));
                card_time2.setStrokeColor(getResources().getColor(R.color.gray_color));
                card_time3.setStrokeColor(getResources().getColor(R.color.gray_color));
                card_time4.setStrokeColor(getResources().getColor(R.color.yellow_stroke));
                //schedule_time = time_slot4.getText().toString();
            }
        });
    }
}