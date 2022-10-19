package com.example.pizza.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.widget.ImageViewCompat;

import com.example.pizza.R;
import com.example.pizza.classes.Produit;

import java.util.List;

public class PizzaAdapter extends BaseAdapter {
    private List<Produit> pizzas;
    private LayoutInflater inflater;


    public PizzaAdapter(Activity activity,List<Produit> pizzas) {
        this.pizzas = pizzas;
        inflater= (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return pizzas.size();
    }

    @Override
    public Object getItem(int i) {
        return pizzas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return pizzas.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null)
            view=inflater.inflate(R.layout.produit_item,null);
        TextView nom =view.findViewById(R.id.nom);
        TextView duree=view.findViewById(R.id.duree);
        ImageView image=view.findViewById(R.id.image);
        TextView id=view.findViewById(R.id.id);
        TextView nbr=view.findViewById(R.id.nbr);

        nom.setText(pizzas.get(i).getNom());
        duree.setText(pizzas.get(i).getDuree());
        image.setImageResource(pizzas.get(i).getPhoto());
        id.setText(pizzas.get(i).getId()+"");
        nbr.setText(pizzas.get(i).getNbrIngredients()+"");

        return view;
    }
}
