package com.example.textadventuregame.view;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.textadventuregame.R;
import com.example.textadventuregame.model.items.Item;

import java.util.ArrayList;
import java.util.List;


public class InventoryRecyclerViewAdapter extends RecyclerView.Adapter<InventoryRecyclerViewAdapter.MyViewHolder> {
    List<Item> items;
    Context context;
    public InventoryRecyclerViewAdapter(Context context, List<Item> items) {
        this.context = context;
        this.items = items;
    }
    @NonNull
    @Override
    public InventoryRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.inventory_item, parent, false);
        return new InventoryRecyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InventoryRecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.itemName.setText(items.get(position).getName());
        holder.itemName.setTextSize(15);
        holder.itemBonus.setText(items.get(position).getBonusesDesc());
        holder.itemBonus.setTextSize(15);
        String imageFileName = items.get(position).getImageFileName();
        int imageResourceId = context.getResources().getIdentifier(imageFileName, "drawable", context.getPackageName());
        holder.itemImage.setImageResource(imageResourceId);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView itemImage;
        TextView itemName;
        TextView itemBonus;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.itemImage);
            itemName = itemView.findViewById(R.id.itemName);
            itemBonus = itemView.findViewById(R.id.itemBonus);
        }
    }

}
