
package ModeloDTO;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import modelo.Datoscaso;
import modelo.Diligencia;



@XmlRootElement(name = "Diligencia")
@XmlAccessorType(XmlAccessType.FIELD)
public class DiligenciaDTO {
    
    private Integer id;
    private String diligencias;
    private String descripcion;
    private Date fechaLimite;
    private DatosCasoDTO idProceso2;

    public DiligenciaDTO() {
    }

    public DiligenciaDTO(Diligencia diligencia) {
        this.id = diligencia.getId();
        this.diligencias = diligencia.getDiligencias();
        this.descripcion = diligencia.getDescripcion();
        this.fechaLimite = diligencia.getFechaLimite();
        this.idProceso2 = new DatosCasoDTO(diligencia.getIdProceso2());
    }
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDiligencias() {
        return diligencias;
    }

    public void setDiligencias(String diligencias) {
        this.diligencias = diligencias;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(Date fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public DatosCasoDTO getIdProceso2() {
        return idProceso2;
    }

    public void setIdProceso2(DatosCasoDTO idProceso2) {
        this.idProceso2 = idProceso2;
    }

 

   
    
    
}
