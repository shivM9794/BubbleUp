package app.bubbleup.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import app.bubbleup.Model.PopularShopModel;
import app.bubbleup.Model.ShopModel;
import app.bubbleup.R;

public class PopularShopAdapter extends RecyclerView.Adapter<PopularShopAdapter.ViewHolder> {

    Context context;
    ArrayList<PopularShopModel> popularShopModels = new ArrayList<>();

    public PopularShopAdapter(Context context, ArrayList<PopularShopModel> popularShopModels) {
        this.context = context;
        this.popularShopModels = popularShopModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.popular_shoplist,parent,false);
        return new PopularShopAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        PopularShopModel popularShopModel = popularShopModels.get(position);
        holder.imageView.setImageResource(popularShopModel.getImage());
        holder.tv_name.setText(popularShopModel.getName());

    }

    @Override
    public int getItemCount() {
        return popularShopModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView tv_name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            tv_name = itemView.findViewById(R.id.tv_name);
        }
    }
}
