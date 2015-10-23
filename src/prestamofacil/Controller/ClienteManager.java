/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prestamofacil.Controller;

/**
 *
 * @author Junior
 */

import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import prestamofacil.entidades.Cliente;
import prestamofacil.gui.Splash;
import prestamofacil.util.NewHibernateUtil;



public class ClienteManager {
    
   Transaction trns;   
   Session session  ;   
   
   
   public ClienteManager(){
       this.session  = Splash.session;
   }
  
    
    public void insert(Cliente cliente){
        
        //session = NewHibernateUtil.getSessionFactory().openSession();
        
        try {
            trns = session.beginTransaction();
            session.save(cliente);
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
    
    public void update(Cliente cliente){
        //session = NewHibernateUtil.getSessionFactory().openSession();
        try{
            trns = session.beginTransaction();
            session.update(cliente);
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
    
    public void delete(String clienteID){
        
        //session = NewHibernateUtil.getSessionFactory().openSession();
                
        try {
            trns = session.beginTransaction();
            Cliente cliente = (Cliente) session.load(Cliente.class, new String(clienteID));
            session.delete(clienteID);
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
    
    public ArrayList<Cliente> getClientes(){
        
        ArrayList<Cliente> allCliente = new ArrayList<Cliente>();
        //session = NewHibernateUtil.getSessionFactory().openSession();
        
        try{
            trns = session.beginTransaction();
            allCliente = (ArrayList<Cliente>) session.createQuery("from Cliente").list();
        }catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        
        return allCliente; 
    }
    
    public Cliente getClienteById(String clienteID) {
        Cliente cliente = null;
        //session = NewHibernateUtil.getSessionFactory().openSession();
       
        try {
            trns = session.beginTransaction();
            String queryString = "from Cliente where dni = :dni";
            Query query = (Query) session.createQuery(queryString);
            query.setString("dni", clienteID);
            cliente = (Cliente) query.uniqueResult();
         
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return cliente;
    }
    
    
    public boolean isExists(String dni){
        Cliente cliente = null;
        Boolean exists = false;  
        //session = NewHibernateUtil.getSessionFactory().openSession();
       
        try {
            trns = session.beginTransaction();
            String queryString = "from Cliente where dni = :dni";
            Query query = (Query) session.createQuery(queryString);
            query.setString("dni", dni);
            cliente = (Cliente) query.uniqueResult();
            if(cliente != null){
                exists = true; 
            }
        } catch (RuntimeException e) {
            e.printStackTrace();           
        } finally {
            session.flush();
            session.close();           
        }
        return exists; 
        
    }
    
    
}
