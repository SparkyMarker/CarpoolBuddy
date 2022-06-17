package com.example.carpoolbuddy;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recViewAdapter extends RecyclerView.Adapter<vehicleViewHolder> {

    private ArrayList<Vehicle> vehicleList;
    private vehicleViewHolder.OnNoteListener monNoteListener;
    private String selectedRole;


    public recViewAdapter(String selectedRole){
        this.selectedRole = selectedRole;
    }

    public recViewAdapter (ArrayList<Vehicle> vehicleList, vehicleViewHolder.OnNoteListener monNoteListener){
        this.monNoteListener = monNoteListener;
        this.vehicleList = vehicleList;
    }
    @NonNull
    @Override
    public vehicleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View myView = LayoutInflater.from(parent.getContext()).inflate(R.layout.rec_view,parent,false);
        vehicleViewHolder holder = new vehicleViewHolder(myView, monNoteListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull vehicleViewHolder holder, int position) {
        if(selectedRole.equals("Vehicle")){
            if(vehicleList.get(position).getVehicleType().toString() ==selectedRole){
                holder.setTextNameView(vehicleList.get(position).getOwner());
                holder.setTextCapacityView(vehicleList.get(position).getCapacity());
                holder.setTextTypeView(vehicleList.get(position).getVehicleType());
                holder.setTextModelView(vehicleList.get(position).getModel());
                holder.setTextBasePriceView((int) vehicleList.get(position).getBasePrice());
            }
        }
        if(selectedRole.equals("Car")){
            if(vehicleList.get(position).getVehicleType().toString() ==selectedRole){
                holder.setTextNameView(vehicleList.get(position).getOwner());
                holder.setTextCapacityView(vehicleList.get(position).getCapacity());
                holder.setTextTypeView(vehicleList.get(position).getVehicleType());
                holder.setTextModelView(vehicleList.get(position).getModel());
                holder.setTextBasePriceView((int) vehicleList.get(position).getBasePrice());
            }
        }
        if(selectedRole.equals("Segway")){
            if(vehicleList.get(position).getVehicleType().toString() ==selectedRole){
                holder.setTextNameView(vehicleList.get(position).getOwner());
                holder.setTextCapacityView(vehicleList.get(position).getCapacity());
                holder.setTextTypeView(vehicleList.get(position).getVehicleType());
                holder.setTextModelView(vehicleList.get(position).getModel());
                holder.setTextBasePriceView((int) vehicleList.get(position).getBasePrice());
            }
        }
        if(selectedRole.equals("Bycicle")){
            if(vehicleList.get(position).getVehicleType().toString() ==selectedRole){
                holder.setTextNameView(vehicleList.get(position).getOwner());
                holder.setTextCapacityView(vehicleList.get(position).getCapacity());
                holder.setTextTypeView(vehicleList.get(position).getVehicleType());
                holder.setTextModelView(vehicleList.get(position).getModel());
                holder.setTextBasePriceView((int) vehicleList.get(position).getBasePrice());
            }
        }
        if(selectedRole.equals("Helicopter")){
            if(vehicleList.get(position).getVehicleType().toString() ==selectedRole){
                holder.setTextNameView(vehicleList.get(position).getOwner());
                holder.setTextCapacityView(vehicleList.get(position).getCapacity());
                holder.setTextTypeView(vehicleList.get(position).getVehicleType());
                holder.setTextModelView(vehicleList.get(position).getModel());
                holder.setTextBasePriceView((int) vehicleList.get(position).getBasePrice());
            }
        }
    }

    @Override
    public int getItemCount() {
        return vehicleList.size();
    }


}
