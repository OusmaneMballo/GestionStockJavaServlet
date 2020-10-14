package DAO;

import Entities.Produit;
import Util.HibernateUtil;
import org.hibernate.Session;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class ProduitDAO implements IProduit {
    Session session;

    public ProduitDAO(){
        session= HibernateUtil.getSession();
    }

    @Override
    public List<Produit> findAll() {
        return session.createQuery("SELECT p from Produit p", Produit.class).list();
    }

    @Override
    public int add(Produit p) {
        try{
            session.save(p);
            return 1;
        }catch(Exception exception){
            exception.getStackTrace();
        }
        return 0;
    }

    @Override
    public Produit findById(int id) {
        return session.find(Produit.class, id);
    }

    @Override
    public Produit findByProduit(Produit p) {
        return null;
    }

    @Override
    public List<Produit> findByIdCategorie(int id) {

        return session.createQuery("select p from Produit p join p.categorie c where c.id=: id",
                Produit.class).setParameter("id", id).list();
    }

    @Override
    public void edit(Produit p) {
        try {
            session.update(p);
        }catch (Exception exception){
            exception.getStackTrace();
        }
    }

    @Override
    public void delete(Produit p) {
        try{
            session.delete(p);
        }catch (Exception exception){
            exception.getStackTrace();
        }
    }
}
