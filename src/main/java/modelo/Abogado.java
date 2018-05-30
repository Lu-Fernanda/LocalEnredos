
package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;


@Entity
@Table(name = "abogado")
@XmlRootElement
public class Abogado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 50)
    @Column(name = "entidad")
    private String entidad;
    @Size(max = 25)
    @Column(name = "nombreEntidad")
    private String nombreEntidad;
    @Size(max = 30)
    @Column(name = "tarjetaProfesional")
    private String tarjetaProfesional;
    @Size(max = 50)
    @Column(name = "areaEspecializacion")
    private String areaEspecializacion;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cc")
    private Integer cc;
    @Size(max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 30)
    @Column(name = "correo")
    private String correo;
    @OneToMany(mappedBy = "idAbogado", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    private List<Datoscaso> datoscasoList;

    public Abogado() {
    }

    public Abogado(Integer cc) {
        this.cc = cc;
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public String getNombreEntidad() {
        return nombreEntidad;
    }

    public void setNombreEntidad(String nombreEntidad) {
        this.nombreEntidad = nombreEntidad;
    }

    public String getTarjetaProfesional() {
        return tarjetaProfesional;
    }

    public void setTarjetaProfesional(String tarjetaProfesional) {
        this.tarjetaProfesional = tarjetaProfesional;
    }

    public String getAreaEspecializacion() {
        return areaEspecializacion;
    }

    public void setAreaEspecializacion(String areaEspecializacion) {
        this.areaEspecializacion = areaEspecializacion;
    }

    public Integer getCc() {
        return cc;
    }

    public void setCc(Integer cc) {
        this.cc = cc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public List<Datoscaso> getDatoscasoList() {
        return datoscasoList;
    }

    public void setDatoscasoList(List<Datoscaso> datoscasoList) {
        this.datoscasoList = datoscasoList;
    }
    
    public void addCaso(Datoscaso dato){
        dato.setIdAbogado(this);
        this.datoscasoList.add(dato);
    }
    @Override
    public String toString() {
        return "modelo.Abogado[ cc=" + cc + " ]";
    }
    
}
