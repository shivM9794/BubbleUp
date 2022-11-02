package app.bubbleup.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import app.bubbleup.DashboardSection.ShopSelectionActivity;
import app.bubbleup.Model.ShopModel;
import app.bubbleup.R;

public class ShopSelectionAdapter extends RecyclerView.Adapter<ShopSelectionAdapter.ViewHolder> {

    Context context;
    ArrayList<ShopModel> shopModels = new ArrayList<>();

    public ShopSelectionAdapter(Context context, ArrayList<ShopModel> shopModels) {
        this.context = context;
        this.shopModels = shopModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shop_list,parent,false);
        return new ShopSelectionAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ShopModel shopModel = shopModels.get(position);
        holder.tv_address.setText(shopModel.getAddress());
        holder.tv_name.setText(shopModel.getName());
        holder.tv_time.setText(shopModel.getTime());
        holder.image_view.setImageResource(shopModel.getImage());
        holder.clickable_ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ShopSelectionActivity.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return shopModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv_name,tv_address,tv_time;
        ImageView image_view;
        LinearLayout clickable_ll;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_name = itemView.findViewById(R.id.tv_name);
            tv_address = itemView.findViewById(R.id.tv_address);
            tv_time = itemView.findViewById(R.id.tv_time);
            image_view = itemView.findViewById(R.id.image_view);
            clickable_ll = itemView.findViewById(R.id.clickable_ll);
        }
    }
}
