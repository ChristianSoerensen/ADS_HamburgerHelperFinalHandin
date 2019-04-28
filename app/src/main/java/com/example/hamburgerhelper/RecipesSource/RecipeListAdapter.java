package com.example.hamburgerhelper.RecipesSource;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hamburgerhelper.R;

import java.util.ArrayList;

public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.ViewHolder> {

    private ArrayList<Recipes> mRecipes;

    public RecipeListAdapter(ArrayList<Recipes> recipes){
        mRecipes = recipes;
    }

    public RecipeListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recipe_list_layout, parent, false);
        return new ViewHolder(view);
    }

    public void onBindViewHolder(RecipeListAdapter.ViewHolder viewHolder, int position) {
        viewHolder.name.setText(mRecipes.get(position).getName());
        viewHolder.icon.setImageResource(mRecipes.get(position).getIconId());

    }

    public int getItemCount() {
        return mRecipes.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        ImageView icon;

        ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_name);
            icon = itemView.findViewById(R.id.iv_icon);
        }

    }

}