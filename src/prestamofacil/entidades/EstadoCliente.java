/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prestamofacil.entidades;

/**
 *
 * @author Junior
 */
public abstract class EstadoCliente {
    
    Cliente cliente; 
    
    public EstadoCliente(Cliente cliente){
        this.cliente = cliente; 
    }
    
    public abstract void generarPrestamo(Cliente cliente); 
    public abstract boolean denegarPrestamo(Cliente cliente); 
    
    
    
    
}
