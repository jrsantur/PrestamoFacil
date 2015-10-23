/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prestamofacil.Controller;

import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import prestamofacil.entidades.Prestamo;
import prestamofacil.util.NewHibernateUtil;

/**
 *
 * @author Junior
 */
public class PrestamoManager {
     Transaction trns;   
   Session session ;    
    
    public void insert(Prestamo prestamo){
        
        session = NewHibernateUtil.getSessionFactory().openSession();
        
        try {
            trns = session.beginTransaction();
            session.save(prestamo);
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
    
    public void update(Prestamo prestamo){
        session = NewHibernateUtil.getSessionFactory().openSession();
        try{
            trns = session.beginTransaction();
            session.update(prestamo);
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
    
    public void delete(int  prestamoID){
        
        session = NewHibernateUtil.getSessionFactory().openSession();
                
        try {
            trns = session.beginTransaction();
            Prestamo prestamo = (Prestamo) session.load(Prestamo.class, new Integer(prestamoID));
            session.delete(prestamoID);
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
    
    public ArrayList<Prestamo> getPrestamos(){
        
        ArrayList<Prestamo> allPrestamo = new ArrayList<Prestamo>();
        session = NewHibernateUtil.getSessionFactory().openSession();
        
        try{
            trns = session.beginTransaction();
            allPrestamo = (ArrayList<Prestamo>) session.createQuery("from Prestamo").list();
        }catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        
        return allPrestamo; 
    }
    
    public Prestamo getPrestamoById(int prestamoID) {
        Prestamo prestamo = null;
        session = NewHibernateUtil.getSessionFactory().openSession();
       
        try {
            trns = session.beginTransaction();
            String queryString = "from Prestamo where id = :id";
            Query query = (Query) session.createQuery(queryString);
            query.setInteger("id", prestamoID);
            prestamo = (Prestamo) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return prestamo;
    }
}
