package com.example.hamburgerhelper.IngredientsSource;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hamburgerhelper.R;

import java.util.ArrayList;

public class IngredientsListAdapter extends RecyclerView.Adapter<IngredientsListAdapter.ViewHolder> {

        private ArrayList<Ingredients> mIngredients;

        public IngredientsListAdapter(ArrayList<Ingredients> ingredients){
            mIngredients = ingredients;
        }

        public IngredientsListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.ingredients_list_layout, parent, false);
            return new ViewHolder(view);
        }

        public void onBindViewHolder(IngredientsListAdapter.ViewHolder viewHolder, int position) {
            viewHolder.in_name.setText(mIngredients.get(position).getName());
            viewHolder.in_icon.setImageResource(mIngredients.get(position).getIconId());

        }

        public int getItemCount() {
            return mIngredients.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            TextView in_name;
            ImageView in_icon;

            ViewHolder(View itemView) {
                super(itemView);
                in_name = itemView.findViewById(R.id.in_tv_name);
                in_icon = itemView.findViewById(R.id.in_iv_icon);
            }

        }

}
