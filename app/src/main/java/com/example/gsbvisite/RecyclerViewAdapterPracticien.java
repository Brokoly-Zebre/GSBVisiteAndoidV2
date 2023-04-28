package com.example.gsbvisite;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapterPracticien extends RecyclerView.Adapter<RecyclerViewAdapterPracticien.RecyclerViewHolder> {

    private ArrayList<Practicien> practicien;

    public class RecyclerViewHolder extends RecyclerView.ViewHolder{

        TextView textViewPrenom;
        TextView textViewNom;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNom = itemView.findViewById(R.id.textViewNom);
            textViewPrenom = itemView.findViewById(R.id.textViewPrenom);
        }
    }


    @NonNull
    @Override
    public RecyclerViewAdapterPracticien.RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        RecyclerViewHolder viewHolder;
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view, parent,false);
        viewHolder = new RecyclerViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterPracticien.RecyclerViewHolder holder, int position) {

        holder.textViewNom.setText(practicien.get(position).getNom());
        holder.textViewPrenom.setText(practicien.get(position).getPrenom());
    }

    @Override
    public int getItemCount() {
        return practicien.size();
    }
    public long getItemId(int positon){
        return super.getItemId(positon);
    }
}
