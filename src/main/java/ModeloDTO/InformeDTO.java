
package ModeloDTO;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import modelo.Datoscaso;
import modelo.Informe;



@XmlRootElement(name = "Informe")
@XmlAccessorType(XmlAccessType.FIELD)
public class InformeDTO {
    
    private int id;
    private Date fecha;
    private int nHoras;
    private String informes;
    private String factura;
    private String comentarioUsuario;
    private String archivoAdjunto;
    private DatosCasoDTO idProceso1;

    public InformeDTO() {
    }

    public InformeDTO(Informe inf) {
        this.id = inf.getId();
        this.fecha = inf.getFecha();
        this.nHoras = inf.getNHoras();
        this.informes = inf.getInformes();
        this.factura = inf.getFactura();
        this.comentarioUsuario = inf.getComentarioUsuario();
        this.archivoAdjunto = inf.getArchivoAdjunto();
        this.idProceso1 = new DatosCasoDTO(inf.getIdProceso1());
    }
    
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getnHoras() {
        return nHoras;
    }

    public void setnHoras(int nHoras) {
        this.nHoras = nHoras;
    }

    public String getInformes() {
        return informes;
    }

    public void setInformes(String informes) {
        this.informes = informes;
    }

    public String getFactura() {
        return factura;
    }

    public void setFactura(String factura) {
        this.factura = factura;
    }

    public String getComentarioUsuario() {
        return comentarioUsuario;
    }

    public void setComentarioUsuario(String comentarioUsuario) {
        this.comentarioUsuario = comentarioUsuario;
    }

    public String getArchivoAdjunto() {
        return archivoAdjunto;
    }

    public void setArchivoAdjunto(String archivoAdjunto) {
        this.archivoAdjunto = archivoAdjunto;
    }

    public DatosCasoDTO getIdProceso1() {
        return idProceso1;
    }

    public void setIdProceso1(DatosCasoDTO idProceso1) {
        this.idProceso1 = idProceso1;
    }


    
    
}
