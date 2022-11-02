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

import app.bubbleup.DashboardSection.WashingActivity;
import app.bubbleup.Model.ServiceModel;
import app.bubbleup.R;

public class OnSiteAdapter extends RecyclerView.Adapter<OnSiteAdapter.ViewHolder> {

    Context context;
    ArrayList<ServiceModel> serviceModels = new ArrayList<>();

    public OnSiteAdapter(Context context, ArrayList<ServiceModel> serviceModels) {
        this.context = context;
        this.serviceModels = serviceModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.top_laundary_services,parent,false);
        return new OnSiteAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ServiceModel serviceModel = serviceModels.get(position);
        holder.imageView.setImageResource(serviceModel.getImage());
        holder.tv_name.setText(serviceModel.getName());
        holder.clickable_ll.setOnClickListener(view -> {
            Intent intent = new Intent(context, WashingActivity.class);
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return serviceModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView tv_name;
        LinearLayout clickable_ll;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            tv_name = itemView.findViewById(R.id.tv_name);
            clickable_ll = itemView.findViewById(R.id.clickable_ll);
        }
    }
}
