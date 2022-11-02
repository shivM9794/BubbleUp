package app.bubbleup.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import app.bubbleup.Model.OfferModel;
import app.bubbleup.R;

public class OfferAdapter extends RecyclerView.Adapter<OfferAdapter.ViewHolder> {

    Context context;
    ArrayList<OfferModel> offerModels = new ArrayList<>();

    public OfferAdapter(Context context, ArrayList<OfferModel> offerModels) {
        this.context = context;
        this.offerModels = offerModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.offers,parent,false);
        return new OfferAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        OfferModel offerModel = offerModels.get(position);
        holder.imageView.setImageResource(offerModel.getImage());

    }

    @Override
    public int getItemCount() {
        return offerModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
