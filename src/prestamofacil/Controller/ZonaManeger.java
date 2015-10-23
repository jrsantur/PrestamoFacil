package prestamofacil.Controller;

import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import prestamofacil.entidades.Zona;
import prestamofacil.util.NewHibernateUtil;

/**
 *
 * @author Junior
 */
public class ZonaManeger {
 
    Transaction trns;   
   Session session ;    
    
    public void insert(Zona zona){
        
        session = NewHibernateUtil.getSessionFactory().openSession();
        
        try {
            trns = session.beginTransaction();
            session.save(zona);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }         
    }
    
    public void update(Zona zona){
        session = NewHibernateUtil.getSessionFactory().openSession();
        try{
            trns = session.beginTransaction();
            session.update(zona);
            session.getTransaction().commit();
        }catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }   
    }
    
    public void delete(int idZona){
        
        session = NewHibernateUtil.getSessionFactory().openSession();
                
        try {
            trns = session.beginTransaction();
            Zona zona = (Zona) session.load(Zona.class, new Integer(idZona));
            session.delete(idZona);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }
    
    public ArrayList<Zona> getZonas(){
        
        ArrayList<Zona> allZonas = new ArrayList<Zona>();
        session = NewHibernateUtil.getSessionFactory().openSession();
        
        try{
            trns = session.beginTransaction();
            allZonas = (ArrayList<Zona>) session.createQuery("from Zona").list();
        }catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        
        return allZonas; 
    }
    
    public Zona getZonaById(int idZona) {
        Zona zona = null;
        session = NewHibernateUtil.getSessionFactory().openSession();
       
        try {
            trns = session.beginTransaction();
            String queryString = "from Zona where idZona = :idZona";
            Query query = (Query) session.createQuery(queryString);
            query.setInteger("idZona", idZona);
            zona = (Zona) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return zona;
    }
    
    
    
}
