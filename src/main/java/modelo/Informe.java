
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "informe")
@XmlRootElement
public class Informe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "nHoras")
    private Integer nHoras;
    @Size(max = 100)
    @Column(name = "informes")
    private String informes;
    @Lob
    @Size(max = 16777215)
    @Column(name = "factura")
    private String factura;
    @Size(max = 50)
    @Column(name = "comentarioUsuario")
    private String comentarioUsuario;
    @Size(max = 50)
    @Column(name = "archivoAdjunto")
    private String archivoAdjunto;
    @JoinColumn(name = "idProceso1", referencedColumnName = "id")
    @ManyToOne(fetch=FetchType.LAZY)
    private Datoscaso idProceso1;

    public Informe() {
    }

    public Informe(Integer id) {
        this.id = id;
    }

    public Informe(Integer id, Date fecha) {
        this.id = id;
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getNHoras() {
        return nHoras;
    }

    public void setNHoras(Integer nHoras) {
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

    public Datoscaso getIdProceso1() {
        return idProceso1;
    }

    public void setIdProceso1(Datoscaso idProceso1) {
        this.idProceso1 = idProceso1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Informe)) {
            return false;
        }
        Informe other = (Informe) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Informe[ id=" + id + " ]";
    }
    
}
