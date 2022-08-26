package com.example.ocs.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ocs.Domain.CategoryDomain;
import com.example.ocs.Domain.FoodDomain;
import com.example.ocs.R;

import java.util.ArrayList;

public class DItemsAdapter extends RecyclerView.Adapter<DItemsAdapter.ViewHolder> {
    ArrayList<FoodDomain> foodDomains;

    public DItemsAdapter(ArrayList<FoodDomain> foodDomains) {
        this.foodDomains = foodDomains;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_daily_items, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemName.setText(foodDomains.get(position).getTitle());
        holder.fee.setText(String.valueOf(foodDomains.get(position).getFee()));
        String picUrl = "";



        int drawableResourceId = holder.itemView.getContext().getResources().
                getIdentifier(foodDomains.get(position).getPic(),"drawable", holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .load(holder.itemPic);
    }


    @Override
    public int getItemCount() {
        return foodDomains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView itemName;
        ImageView itemPic;
        TextView fee;
        ConstraintLayout mainLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.item_title);
            itemPic = itemView.findViewById(R.id.item_pic);
            fee = itemView.findViewById(R.id.fee);
            mainLayout = itemView.findViewById(R.id.item_mlayout);
        }
    }
}
