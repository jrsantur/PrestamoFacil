/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prestamofacil.entidades;

import java.util.Date;

/**
 *
 * @author Junior
 */
public class PrestamoSemanal extends Prestamo{
    
    public PrestamoSemanal(int idPrestamo, double monto, double interes, double monto_total, double mora, int cuotas, int cuotas_totales, String tipo_pago, Date fecha_prestamo, Date fecha_inico_cobro, Date fecha_fin_prestamo, String estado, Cliente idCliente) {
       // super(idPrestamo, monto, interes, monto_total, mora, cuotas, cuotas_totales, tipo_pago, fecha_prestamo, fecha_inico_cobro, fecha_fin_prestamo, estado, idCliente);
    }
    
    public void mostrarTipo(){
        System.err.println("Prestamo semanal");
    }
}
