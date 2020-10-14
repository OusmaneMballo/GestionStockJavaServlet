package DAO;

import Entities.Categorie;
import Util.HibernateUtil;
import org.hibernate.Session;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class CategorieDAO implements ICategorie {

    Session session;
    public CategorieDAO(){
        session= HibernateUtil.getSession();
    }

    @Override
    public List<Categorie> findAll() {

        return session.createQuery("SELECT c from Categorie c", Categorie.class).list();
    }

    @Override
    public int add(Categorie c) {
        try {
                session.save(c);
                return 1;
        }catch (Exception exception){
            exception.getStackTrace();
        }
        return 0;
    }

    @Override
    public Categorie findByCategorie(Categorie c) {
        return session.find(Categorie.class,c);
    }

    @Override
    public Categorie findById(int id) {
        return session.find(Categorie.class, id);
    }

    @Override
    public void edit(Categorie c) {
        try {
            session.update(c);
        }catch (Exception exception){
            exception.getStackTrace();
        }
    }

    @Override
    public void delete(Categorie c) {
        try{
            session.delete(c);
        }catch (Exception exception){
            exception.getStackTrace();
        }
    }
}
