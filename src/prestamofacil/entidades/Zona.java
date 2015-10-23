
package prestamofacil.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Junior
 */
@Entity
@Table(name = "zona")

public class Zona implements Serializable {
    
    @Id
    private int idZona;
    @Column(name = "abreviatura")
    private String  abreviatura; 
    @Column(name = "descripcion")
    private String descripcion;

    public Zona() {
    }

    public Zona(int idZona, String abreviatura, String descripcion) {
        this.idZona = idZona;
        this.abreviatura = abreviatura; 
        this.descripcion = descripcion;
    }

    /**
     * @return the idZona
     */
    public int getIdZona() {
        return idZona;
    }

    /**
     * @param idZona the idZona to set
     */
    public void setIdZona(int idZona) {
        this.idZona = idZona;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the abreviatura
     */
    public String getAbreviatura() {
        return abreviatura;
    }

    /**
     * @param abreviatura the abreviatura to set
     */
    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }
   
    
}
