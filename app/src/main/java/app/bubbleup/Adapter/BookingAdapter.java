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

import app.bubbleup.Model.BookingModel;
import app.bubbleup.R;

public class BookingAdapter extends RecyclerView.Adapter<BookingAdapter.ViewHolder> {

    Context context;
    ArrayList<BookingModel> bookingModels = new ArrayList<>();

    public BookingAdapter(Context context, ArrayList<BookingModel> bookingModels) {
        this.context = context;
        this.bookingModels = bookingModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bookings,parent,false);
        return new BookingAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        BookingModel bookingModel = bookingModels.get(position);
        holder.image_view.setImageResource(bookingModel.getImg());
        holder.tv_name.setText(bookingModel.getName());
        holder.tv_address.setText(bookingModel.getPickup());
        holder.tv_time.setText(bookingModel.getDelivered());

    }

    @Override
    public int getItemCount() {
        return bookingModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image_view;
        TextView tv_name,tv_address,tv_time;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image_view = itemView.findViewById(R.id.image_view);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_address = itemView.findViewById(R.id.tv_address);
            tv_time = itemView.findViewById(R.id.tv_time);
        }
    }
}
