package com.example.pizza.service;

import android.util.Log;

import com.example.pizza.classes.Produit;
import com.example.pizza.dao.IDao;

import java.util.ArrayList;
import java.util.List;

public class ProduitService implements IDao<Produit> {
    private static final String TAG="ProduitService";
    private static ProduitService service_instance;
    private List<Produit> produits ;

    private ProduitService() {
        this.produits=new ArrayList<>();
    }

    @Override
    public boolean create(Produit o) {
        Log.d(TAG,"Creat :"+o.getId()+"");
        return produits.add(o);

    }

    @Override
    public boolean update(Produit o) {
        for (Produit p:produits){
            if(p.getId()==o.getId()){
                p.setNom(o.getNom());
                p.setNbrIngredients(o.getNbrIngredients());
                p.setPhoto(o.getPhoto());
                p.setDuree(o.getDuree());
                p.setDetailsIngred(o.getDetailsIngred());
                p.setDescription(o.getDescription());
                p.setPreparation(o.getPreparation());
                return true;

            }
        }
        return false;
    }

    @Override
    public boolean delete(Produit o) {
        Log.d(TAG,"delete :"+o.getId()+"");
        return produits.remove(o);
    }

    @Override
    public List<Produit> findAll() {
        Log.d(TAG,"Find all");
        return produits;
    }

    @Override
    public Produit findById(int id) {
        for(Produit pizza:produits){
            if(pizza.getId() == id){
                return pizza;
            }
        }
        return null;
    }


    public static ProduitService getInstance(){
        if(service_instance==null){
            service_instance = new ProduitService();
        }
        return service_instance;
    }

}
