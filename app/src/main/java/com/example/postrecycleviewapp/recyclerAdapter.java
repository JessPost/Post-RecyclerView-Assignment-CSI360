package com.example.postrecycleviewapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.MyViewHolder> {

    private ArrayList<Animal> animalList;

    public recyclerAdapter(ArrayList<Animal> animalList) {
        this.animalList = animalList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView nameText;
        private TextView locationText;
        private ImageView imageView;

        public MyViewHolder(final View view) {
            super(view);

            nameText = view.findViewById(R.id.name);
            locationText = view.findViewById(R.id.location);
            imageView = view.findViewById(R.id.imageview);
        }
    }

    @NonNull
    @Override
    public recyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull recyclerAdapter.MyViewHolder holder, int position) {
        String name = animalList.get(position).getName();
        String location = animalList.get(position).getLocation();
        int image = animalList.get(position).getImage();

        holder.nameText.setText(name);
        holder.locationText.setText(location);
        holder.imageView.setImageResource(image);
    }

    @Override
    public int getItemCount() {
        return animalList.size();
    }
}
