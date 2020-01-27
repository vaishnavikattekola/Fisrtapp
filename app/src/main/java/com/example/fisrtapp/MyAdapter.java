package com.example.fisrtapp;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.programmingViewHolder> {

    private final List<ModelClass.Datum> dataClassList;
    Activity activity;

    private int[] images;

    public MyAdapter(Activity activity, List<ModelClass.Datum> dataClassList) {
        this.dataClassList = dataClassList;
        this.activity = activity;
    }


    @NonNull
    @Override
    public programmingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item_layout, parent, false);
        return new programmingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull programmingViewHolder holder, final int position) {

        Glide.with(activity)
                .load(dataClassList.get(position).getLogo())
                .into(holder.logo);
        holder.description.setText(dataClassList.get(position).getDescription());
        holder.title.setText(dataClassList.get(position).getName());
        holder.linear.setOnClickListener(new View.OnClickListener() {
            View view;
            Intent intent;

            @Override
            public void onClick(View v) {
                this.view = view;
                intent = new Intent(activity, DetailsActivity.class);

                intent.putExtra("image", dataClassList.get(position).getLogo());
                intent.putExtra("title", dataClassList.get(position).getName());
                intent.putExtra("description", dataClassList.get(position).getDescription());

                activity.startActivity(intent);


            }
        });

    }

    @Override
    public int getItemCount() {
        return dataClassList.size();
    }

    public static class programmingViewHolder extends RecyclerView.ViewHolder {
        private ImageView logo;
        private TextView title;
        private TextView description;
        private LinearLayout linear;

        public programmingViewHolder(@NonNull View itemView) {
            super(itemView);
            logo = itemView.findViewById(R.id.image);
            title = itemView.findViewById(R.id.textTitle);
            description = itemView.findViewById(R.id.description);
            linear = itemView.findViewById(R.id.linear);
        }

        private void setData(int images, String titleText, String bodyText) {
            logo.setImageResource(images);
            title.setText(titleText);
            description.setText(bodyText);

        }
    }
}


