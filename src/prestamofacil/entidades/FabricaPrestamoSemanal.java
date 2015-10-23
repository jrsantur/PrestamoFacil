/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prestamofacil.entidades;

import prestamofacil.Controller.PrestamoManager;

/**
 *
 * @author Junior
 */
public class FabricaPrestamoSemanal implements FabricaPrestamo{


    PrestamoManager prestamoManager; 
    @Override
    public void crearPrestamo(Prestamo prestamo) {
        prestamoManager.insert(prestamo);
    }
    
    
}
