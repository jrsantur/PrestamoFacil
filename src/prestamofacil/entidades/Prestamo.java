
package prestamofacil.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "prestamo")
public class Prestamo implements Serializable {
    
    @Id
    private int idPrestamo;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idCliente")    
    private Cliente  idCliente; 
        
    @Column(name = "monto")
    private double monto_prestado;
    
    @Column(name = "interes")
    private double interes; 
    
    @Column(name = "monto_subtotal")
    private double monto_subtotal;
    
    @Column(name = "monto_total")
    private double monto_total;
    
    @Column(name = "deuda")
    private double deuda; 
    
    @Column(name = "mora")
    private double mora;
    
    @Column(name = "cuotas")
    private int cuotas;
    
    @Column(name = "cuotas_totales")
    private int cuotas_totales; 
    
    @Column(name = "tipo´pago")
    private String tipo_pago; 
    
    @Column(name = "fecha_prestamo")
    private Date fecha_prestamo; 
    
    @Column(name = "fecha_inicio_cobro")
    private Date fecha_inicio_cobro; 
    
    @Column(name = "fecha_fin_prestamo")
    private Date fecha_fin_prestamo; 
        
    @Column(name = "estado")
    private String estado;     
    


    


   
    
    
}