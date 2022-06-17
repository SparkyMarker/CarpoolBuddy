package com.example.carpoolbuddy;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class vehicleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    protected TextView textTypeView;
    protected TextView textNameView;
    protected TextView textModelView;
    protected TextView textCapacityView;
    protected TextView textBasePriceView;
    private OnNoteListener onNoteListener;

    public vehicleViewHolder(@NonNull View itemView, OnNoteListener onNoteListener) {
        super(itemView);

        this.onNoteListener = onNoteListener;

        textNameView = itemView.findViewById(R.id.textName);
        textTypeView = itemView.findViewById(R.id.textType);
        textModelView = itemView.findViewById(R.id.textModel);
        textCapacityView = itemView.findViewById(R.id.textCapacity);
        textBasePriceView = itemView.findViewById(R.id.textBasePrice);

        itemView.setOnClickListener(this);

    }

    public void setTextTypeView(String s) {
        this.textTypeView.setText(s);
    }


    public void setTextNameView(String s) {
        this.textNameView.setText(s);
    }


    public void setTextModelView(String s) {
        this.textModelView.setText(s);
    }


    public void setTextCapacityView(int s) {
        this.textCapacityView.setText(""+s);
    }


    public void setTextBasePriceView(int s) {
        this.textBasePriceView.setText(""+s);
    }

    @Override
    public void onClick(View view) {
        onNoteListener.onNoteClick(getAdapterPosition());
    }
    public interface OnNoteListener{
        void onNoteClick(int position);
    }
}
