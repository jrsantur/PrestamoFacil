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
public abstract class EstadoPrestamo {
    
    protected  Prestamo prestamo; 
    
    public EstadoPrestamo(Prestamo prestamo){
        this.prestamo = prestamo; 
    }
    
    
   
    
}
