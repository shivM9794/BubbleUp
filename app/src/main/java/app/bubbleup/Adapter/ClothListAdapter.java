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

import app.bubbleup.DashboardSection.ClothSelectionActivity;
import app.bubbleup.DashboardSection.ShopSelectionActivity;
import app.bubbleup.DashboardSection.WashingActivity;
import app.bubbleup.Model.ClothModel;
import app.bubbleup.R;

public class ClothListAdapter extends RecyclerView.Adapter<ClothListAdapter.ViewHolder> {

    Context context;
    ArrayList<ClothModel> clothModels = new ArrayList<>();

    public ClothListAdapter(Context context, ArrayList<ClothModel> clothModels) {
        this.context = context;
        this.clothModels = clothModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.washing_adapter,parent,false);
        return new ClothListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ClothModel clothModel = clothModels.get(position);
        holder.clothImg.setImageResource(clothModel.getImage());
        holder.clothName.setText(clothModel.getName());
        holder.clickable_ll.setOnClickListener(view -> {
            Intent intent = new Intent(context, ShopSelectionActivity.class);
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return clothModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView clothImg;
        TextView clothName;
        LinearLayout clickable_ll;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            clothImg = itemView.findViewById(R.id.clothImg);
            clothName = itemView.findViewById(R.id.clothName);
            clickable_ll = itemView.findViewById(R.id.clickable_ll);
        }
    }
}
