package com.example.marijus.enduiprototype.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.marijus.enduiprototype.R;
import com.example.marijus.enduiprototype.products.PlaceholderProduct;
import com.example.marijus.enduiprototype.products.Product;

import java.util.List;

/**
 * Created by Marijus on 22/03/2017.
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private List<PlaceholderProduct> products;

    public DataAdapter(List<PlaceholderProduct> products) {
        this.products = products;
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View productView = inflater.inflate(R.layout.item_view, parent, false);
        //View productView = inflater.inflate(R.layout.grid_view, parent, false);

        return new ViewHolder(productView);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder viewHolder, int position) {
        Product product = products.get(position);

        ImageView imageView = viewHolder.imageView;
        imageView.setImageResource(product.getImage());

        TextView nameView = viewHolder.nameView;
        nameView.setText(product.getName());

        TextView priceView = viewHolder.priceView;
        nameView.setText(product.getName());
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public void removeItem(int position) {
        products.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, products.size());
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView nameView;
        public TextView priceView;

        public ViewHolder(View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.item_image);
            nameView = (TextView) itemView.findViewById(R.id.item_name);
            priceView = (TextView) itemView.findViewById(R.id.item_price);
        }
    }
}
