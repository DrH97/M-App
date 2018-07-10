package com.example.m_app.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.example.m_app.GlideApp;
import com.example.m_app.R;
import com.example.m_app.Utils;
import com.example.m_app.activity.PlaceActivity;
import com.example.m_app.model.Place;

import java.util.ArrayList;
import java.util.List;

public class PlacesAdapter extends RecyclerView.Adapter<PlacesAdapter.MyViewHolder>
implements Filterable {

    private static final String TAG = PlacesAdapter.class.getSimpleName();

    private Utils utils;

    private Context context;

    private List<Place> placeList;
    private List<Place> filteredPlaceList;
    private List<String> favourites;

    public PlacesAdapter(Context context, List<Place> placeList) {
        this.context = context;
        this.placeList = placeList;
        this.filteredPlaceList = placeList;

        utils = new Utils(context);
        this.favourites = utils.getFavourites();

//        setFavourites();
    }

    public void setFavourites() {

        if (utils.getFavourites() != null) {
            for (Place place : filteredPlaceList) {
                if (utils.getFavourites().contains(place.getId().toString()))
                    place.setFavourite(true);
            }
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView image, smallerImage, viewArrow, favourite, share;
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

            favourite = itemView.findViewById(R.id.card_place_favourite);
            share = itemView.findViewById(R.id.card_place_share);

            favourite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    setFavourite(getAdapterPosition());
                }
            });

            favourites = utils.getFavourites();

            setFavourites();

            share.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sharePlace(getAdapterPosition());
                }
            });
        }
    }

    private void sharePlace(int adapterPosition) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, "Check out this awesome place from M-App: " + filteredPlaceList.get(adapterPosition).getTitle());
        context.startActivity(intent);
    }

    private void setFavourite(int adapterPosition) {
//        Toast.makeText(context, filteredPlaceList.get(adapterPosition).isFavourite() + "", Toast.LENGTH_SHORT).show();
        if (filteredPlaceList.get(adapterPosition).isFavourite()){
            filteredPlaceList.get(adapterPosition).setFavourite(false);
            utils.removeFavourite(filteredPlaceList.get(adapterPosition).getId());
        } else {
            filteredPlaceList.get(adapterPosition).setFavourite(true);
            utils.setFavourite(filteredPlaceList.get(adapterPosition).getId());
        }

        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.place_card, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        final Place place = filteredPlaceList.get(position);
        holder.title.setText(place.getTitle());
        holder.location.setText(place.getLocation());
        holder.description.setText(place.getDescription());

        holder.price.setText("FREE");

        if (place.getPrice() != null && place.getPrice() != 0.0)
            holder.price.setText(place.getPrice().toString());

//        if (favourites != null) {
//            if (favourites.contains(place.getId().toString())) {
//                place.setFavourite(true);
//            }
////                holder.favourite.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_favorite_accent_24dp));
//        }

        if (place.isFavourite())
            holder.favourite.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_favorite_accent_24dp));
        else
            holder.favourite.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_favorite_border_white_24dp));

        GlideApp.with(context)
                .load(place.getImage())
                .placeholder(R.drawable.gf_small)
                .transition(DrawableTransitionOptions.withCrossFade())
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .into(holder.image);


        GlideApp.with(context)
                .load(place.getImage())
                .placeholder(R.drawable.bc_small)
                .apply(RequestOptions.circleCropTransform())
                .transition(DrawableTransitionOptions.withCrossFade())
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
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
                intent.putExtra("location", place.getLocation());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return filteredPlaceList.size();
    }


    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    filteredPlaceList = placeList;
                } else {
                    List<Place> filteredPlaces = new ArrayList<>();

                    for (Place row : placeList) {

                        if (row.getTitle().toLowerCase().contains(charString.toLowerCase())
                                || row.getDescription().toLowerCase().contains(charString.toLowerCase())
                                || row.getLocation().toLowerCase().contains(charString.toLowerCase())) {

                            filteredPlaces.add(row);

                        }
                    }

                    filteredPlaceList = filteredPlaces;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = filteredPlaceList;

                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                filteredPlaceList = (ArrayList<Place>) filterResults.values;

                notifyDataSetChanged();
            }
        };
    }

}
