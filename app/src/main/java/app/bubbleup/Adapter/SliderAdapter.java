package app.bubbleup.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.ArrayList;

import app.bubbleup.R;

public class SliderAdapter extends SliderViewAdapter<SliderAdapter.SliderViewHolder> {

    ArrayList<Integer> slider;
    Context context;

    public SliderAdapter(ArrayList<Integer> slider, Context context) {
        this.slider = slider;
        this.context = context;
    }


    @Override
    public SliderAdapter.SliderViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_slider, parent, false);
        return new SliderAdapter.SliderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SliderAdapter.SliderViewHolder viewHolder, int position) {

        Glide.with(context).load(slider.get(position)).into(viewHolder.slider);

    }

    @Override
    public int getCount() {
        return slider.size();
    }

    public class SliderViewHolder extends ViewHolder {

        ImageView slider;

        public SliderViewHolder(View itemView) {
            super(itemView);

            slider = itemView.findViewById(R.id.slider);
        }
    }
}




