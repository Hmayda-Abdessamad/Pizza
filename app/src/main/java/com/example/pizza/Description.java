package com.example.pizza;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pizza.classes.Produit;
import com.example.pizza.service.ProduitService;

public class Description extends AppCompatActivity {
  ProduitService ps=ProduitService.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("La Recette");
        Intent intent = getIntent();
        Produit pizza = ps.findById(Integer.parseInt(intent.getStringExtra("id")));
        TextView nom = findViewById(R.id.nom);
        ImageView image = findViewById(R.id.image);
        TextView ingredients = findViewById(R.id.ingredients);
        TextView descreption = findViewById(R.id.description);

        nom.setText(pizza.getNom());
        descreption.setText(pizza.getDescription());
        ingredients.setText(pizza.getDetailsIngred());
        image.setImageResource(pizza.getPhoto());
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = getIntent();
        Produit pizza = ps.findById(Integer.parseInt(intent.getStringExtra("id")));
        switch (item.getItemId()){
            case R.id.share:
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, pizza.getNom()+"\n---------descreption---------\n"+pizza.getDescription()+"\n---------ingredients---------\n"+pizza.getDetailsIngred());
                sendIntent.setType("text/plain");
                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}