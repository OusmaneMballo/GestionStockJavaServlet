package DAO;

import Entities.Categorie;
import Entities.Produit;

import javax.ejb.Local;
import java.util.List;

@Local
public interface IProduit{

    public List<Produit> findAll();
    public int add(Produit p);
    public Produit findById(int id);
    public List<Produit> findByCategorie(Categorie c);
    public void edit(Produit p);
    public void delete(Produit p);

}