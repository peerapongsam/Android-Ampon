package com.peerapongsam.labs.ampon;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends BaseAdapter {

    private List<Product> products = new ArrayList<>();

    public void setProducts(List<Product> products) {
        this.products = products;
        notifyDataSetChanged();
    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public int getCount() {
        if (products == null) return 0;
        return products.size();
    }

    @Override
    public Product getItem(int position) {
        return products.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView;
        ProductViewHolder holder;
        if (convertView == null) {
            itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
            holder = new ProductViewHolder(itemView);
            itemView.setTag(holder);
        } else {
            itemView = convertView;
            holder = (ProductViewHolder) convertView.getTag();
        }

        final Product product = getItem(position);
        holder.bindValue(product);
        holder.setOnAddClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                product.qty = product.qty + 1;
                notifyDataSetChanged();
            }
        });
        holder.setOnRemoveClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (product.qty > 0) {
                    product.qty = product.qty - 1;
                    notifyDataSetChanged();
                }
            }
        });
        return itemView;
    }
}
