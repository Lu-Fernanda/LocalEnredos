
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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "diligencia")
@XmlRootElement
public class Diligencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 30)
    @Column(name = "diligencias")
    private String diligencias;
    @Size(max = 90)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "fechaLimite")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaLimite;
    @JoinColumn(name = "idProceso2", referencedColumnName = "id")
    @ManyToOne(fetch=FetchType.LAZY)
    private Datoscaso idProceso2;

    public Diligencia() {
    }

    public Diligencia(Integer id) {
        this.id = id;
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

    public Datoscaso getIdProceso2() {
        return idProceso2;
    }

    public void setIdProceso2(Datoscaso idProceso2) {
        this.idProceso2 = idProceso2;
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
        if (!(object instanceof Diligencia)) {
            return false;
        }
        Diligencia other = (Diligencia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Diligencia[ id=" + id + " ]";
    }
    
}
