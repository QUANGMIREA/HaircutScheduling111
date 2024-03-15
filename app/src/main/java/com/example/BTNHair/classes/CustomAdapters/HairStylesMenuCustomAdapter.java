package com.example.BTNHair.classes.CustomAdapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.BTNHair.R;
import com.example.BTNHair.activities.MainActivity;
import com.example.BTNHair.classes.DataModels.HairStyleDataModel;

import java.util.ArrayList;

public class HairStylesMenuCustomAdapter extends RecyclerView.Adapter<HairStylesMenuCustomAdapter.MyViewHolder>{

    MainActivity mainActivity;
    private final ArrayList<HairStyleDataModel> dataSet;
    public HairStylesMenuCustomAdapter(ArrayList<HairStyleDataModel> data, MainActivity Activity)
    {
        this.dataSet = data;
        mainActivity = Activity;
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        TextView textViewHairStyle;
        TextView textViewPrice;
        ImageView imageViewIcon;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.cardView = (CardView) itemView.findViewById(R.id.available_card_view);
            this.textViewHairStyle = (TextView) itemView.findViewById(R.id.textViewHairStyle);
            this.textViewPrice = (TextView) itemView.findViewById(R.id.textViewHour);
            this.imageViewIcon = (ImageView) itemView.findViewById(R.id.imageViewHairStyle);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.appoitment_main_cards, parent, false);

        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        TextView textViewHairStyle = holder.textViewHairStyle;
        TextView textViewDescription = holder.textViewPrice;
        ImageView imageView = holder.imageViewIcon;
        CardView cardView = holder.cardView;

        String hairStyle = dataSet.get(position).getHairStyle();
        textViewHairStyle.setText(hairStyle);

        String price = dataSet.get(position).getPrice();
        textViewDescription.setText(price);

        int img = dataSet.get(position).getImage();
        imageView.setImageResource(img);

        HairStyleDataModel hairStyleDataModel = new HairStyleDataModel(hairStyle, price, img);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.setSelectAppointmentsFragment(hairStyleDataModel);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}