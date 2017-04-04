
package co.edu.uniandes.csw.paseos.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author jma.lovera10
 */
@Entity
public class FotoEntity implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /**
     * Valor codificado de la foto
     */
    private byte[] valor;
    
    /**
     * Formato de la foto
     */
    private String formato;
    
    @ManyToOne
    private VisitaEntity visita;

    /**
     * Método que obtiene el id
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * Método que establece el id de la foto
     * @param id de la foto
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Método que obtiene el valor codificado
     * @return valor de la foto
     */
    public byte[] getValor() {
        return valor;
    }

    /**
     * Método que establece el valor codificado de la foto
     * @param valor de la foto
     */
    public void setValor(byte[] valor) {
        this.valor = valor;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public VisitaEntity getVisita() {
        return visita;
    }

    public void setVisita(VisitaEntity visita) {
        this.visita = visita;
    }
    
}
