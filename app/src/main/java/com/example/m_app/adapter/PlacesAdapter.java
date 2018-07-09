package com.example.m_app.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.m_app.R;
import com.example.m_app.activity.PlaceActivity;
import com.example.m_app.model.Place;

import java.util.List;

public class PlacesAdapter extends RecyclerView.Adapter<PlacesAdapter.MyViewHolder> {

    private static final String TAG = PlacesAdapter.class.getSimpleName();

    private Context context;

    private List<Place> placeList;

    public PlacesAdapter(Context context, List<Place> placeList) {
        this.context = context;
        this.placeList = placeList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView image, smallerImage, viewArrow;
        public TextView title, location, description, price;
        public CardView card;

        public MyViewHolder(View itemView) {
            super(itemView);
            card = itemView.findViewById(R.id.place_card);
            title = itemView.findViewById(R.id.card_place_title);
            location = itemView.findViewById(R.id.card_place_location);
            description = itemView.findViewById(R.id.card_place_desc);
            price = itemView.findViewById(R.id.card_place_price);
            image = itemView.findViewById(R.id.card_place_image);
            smallerImage = itemView.findViewById(R.id.card_place_thumb_image);
            viewArrow = itemView.findViewById(R.id.card_place_view);

        }

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.place_card, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final Place place = placeList.get(position);
        holder.title.setText(place.getTitle());
        holder.location.setText(place.getLocationId().toString());
        holder.description.setText(place.getDescription());
        holder.price.setText(place.getPrice().toString());

        Glide.with(context)
                .load(R.drawable.gf)
                .into(holder.image);

        Glide.with(context)
                .load(R.drawable.bc)
                .into(holder.smallerImage);


        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, PlaceActivity.class);
                intent.putExtra("title", place.getTitle());
                intent.putExtra("id", place.getId());
                intent.putExtra("desc", place.getDescription());
                intent.putExtra("price", place.getPrice());
                intent.putExtra("image", place.getImage());
                intent.putExtra("location", place.getLocationId());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return placeList.size();
    }

}
