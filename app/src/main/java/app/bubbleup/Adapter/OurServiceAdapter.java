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

import app.bubbleup.Model.Service;
import app.bubbleup.R;

public class OurServiceAdapter extends RecyclerView.Adapter<OurServiceAdapter.ViewHolder> {

    Context context;
    ArrayList<Service> services = new ArrayList<>();

    public OurServiceAdapter(Context context, ArrayList<Service> services) {
        this.context = context;
        this.services = services;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.services_we_offer,parent,false);
        return new OurServiceAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Service service = services.get(position);
        holder.image_view.setImageResource(service.getImage());
        holder.tv_name.setText(service.getService_name());
        holder.tv_address.setText(service.getSub_cat());

    }

    @Override
    public int getItemCount() {
        return services.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image_view;
        TextView tv_name,tv_address;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image_view = itemView.findViewById(R.id.image_view);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_address = itemView.findViewById(R.id.tv_address);
        }
    }
}
