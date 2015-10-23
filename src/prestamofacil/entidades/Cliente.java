
package prestamofacil.entidades;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Junior
 */
@Entity
@Table(name = "cliente")

/*
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT u FROM Cliente u"),
    @NamedQuery(name = "Cliente.findByIdDni", query = "SELECT u FROM Cliente u WHERE u.dni = :dni"),
    @NamedQuery(name = "Cliente.findByNombres", query = "SELECT u FROM Cliente u WHERE u.nombres = :nombres"),
    @NamedQuery(name = "Cliente.findByApellidosPaterno", query = "SELECT u FROM Cliente u WHERE u.apellido_paterno = :apellido_paterno"),
    @NamedQuery(name = "Cliente.findByApellidosMaterno", query = "SELECT u FROM Cliente u WHERE u.apellido_materno = :apellido_materno"),
    @NamedQuery(name = "Cliente.findByDireccion", query = "SELECT u FROM Cliente u WHERE u.direccion = :direccion"),
    @NamedQuery(name = "Cliente.findByCliente", query = "SELECT u FROM Cliente u WHERE u.cliente = :cliente"),
    @NamedQuery(name = "Cliente.findByPass", query = "SELECT u FROM Cliente u WHERE u.pass = :pass"),
    @NamedQuery(name = "Cliente.updateScore" ,query="UPDATE Cliente set score=:score WHERE cliente=:cliente")
})
*/
public class Cliente implements Serializable {
    
    @Id
    private String dni; 
    
    @Column(name = "nombre" ,nullable = false , length = 50)
    private String nombre; 
    
    @Column(name = "apellidos"  ,nullable = false , length = 100)
    private String apellidos; 
       
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idZona")
    private Zona zona; 
    
    @Column(name = "direccion" ,nullable = false , length = 100)
    private String direccion;
    
    @Column(name = "telefono" ,nullable = true , length = 10)
    private String telefono; 
    
    @Column(name = "celular" ,nullable = true , length = 10)
    private String celular; 
    
    @Column(name = "celular_2" ,nullable = true , length = 10)
    private String celular2; 
    
    
    public Cliente() {
    }

    public Cliente(String dni, String nombre, String apellidos, Zona zona, String direccion, String telefono, String celular, String celular_2) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;       
        this.zona = zona;
        this.direccion = direccion;
        this.telefono = telefono;
        this.celular = celular;
        this.celular2 = celular_2; 
    }

    /**
     * @return the dni
     */
    public String getDni() {
        return dni;
    }

    /**
     * @param dni the dni to set
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido_paterno
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellido_paterno to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @return the apellido_materno
     */


    /**
     * @return the zona
     */
   
    public Zona getZona() {
        return zona;
    }

    /**
     * @param zona the zona to set
     */
    
    public void setZona(Zona zona) {
        this.zona = zona;
    }

    /**
     * @return the direccion
     */
    
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the celular
     */
    public String getCelular() {
        return celular;
    }

    /**
     * @param celular the celular to set
     */
    public void setCelular(String celular) {
        this.celular = celular;
    }
    
    
   
    
    
}
