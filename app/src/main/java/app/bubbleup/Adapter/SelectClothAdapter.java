package app.bubbleup.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import app.bubbleup.Model.SelectClothModel;
import app.bubbleup.R;

public class SelectClothAdapter extends RecyclerView.Adapter<SelectClothAdapter.ViewHolder> {

    Context context;
    ArrayList<SelectClothModel> selectClothModels = new ArrayList<>();
    int minteger = 1;
    TextView displayInteger;

    public SelectClothAdapter(Context context, ArrayList<SelectClothModel> selectClothModels) {
        this.context = context;
        this.selectClothModels = selectClothModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.select_clothes,parent,false);
        return new SelectClothAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        SelectClothModel selectClothModel = selectClothModels.get(position);
        holder.image_view.setImageResource(selectClothModel.getImage());
        holder.tv_name.setText(selectClothModel.getName());
        holder.tv_delivery.setText(selectClothModel.getDelivery());
        holder.tv_time.setText(selectClothModel.getTime());
        holder.increase.setOnClickListener(view -> {
            increaseInteger();
        });
        holder.decrease.setOnClickListener(view -> decreaseInteger());

    }

    private void decreaseInteger() {

        if (minteger > 1) {
            minteger = minteger - 1;
            display(minteger);

           // Toast.makeText(context, "Order Placed " + "Quanity " + minteger, Toast.LENGTH_SHORT).show();
        }
    }

    private void increaseInteger() {

        minteger = minteger + 1;
        display(minteger);
    }

    private void display(int number) {

        //TextView displayInteger = (TextView) findViewById(R.id.integer_number);
        displayInteger.setText("" + number);
    }

    @Override
    public int getItemCount() {
        return selectClothModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image_view;
        TextView tv_name,tv_delivery,tv_time,integer_number;
        Button decrease,increase;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image_view = itemView.findViewById(R.id.image_view);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_delivery = itemView.findViewById(R.id.tv_delivery);
            tv_time = itemView.findViewById(R.id.tv_time);
            integer_number = itemView.findViewById(R.id.integer_number);
            decrease = itemView.findViewById(R.id.decrease);
            increase = itemView.findViewById(R.id.increase);
        }
    }
}
