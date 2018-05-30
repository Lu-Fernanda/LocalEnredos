
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


@Entity
@Table(name = "usuario")
@XmlRootElement
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 50)
    @Column(name = "apellido")
    private String apellido;
    @Size(max = 50)
    @Column(name = "tipoDocumento")
    private String tipoDocumento;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cc")
    private Integer cc;
    @Column(name = "edad")
    private Integer edad;
    @Size(max = 20)
    @Column(name = "celular")
    private String celular;
    @Size(max = 10)
    @Column(name = "telefono")
    private String telefono;
    @Size(max = 30)
    @Column(name = "correo")
    private String correo;
    @Column(name = "estrato")
    private Integer estrato;
    @Size(max = 50)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 25)
    @Column(name = "barrio")
    private String barrio;
    @Size(max = 25)
    @Column(name = "tipoCasa")
    private String tipoCasa;
    @Size(max = 25)
    @Column(name = "localidad")
    private String localidad;
    @Size(max = 25)
    @Column(name = "reciboPublico")
    private String reciboPublico;
    @Column(name = "nHijos")
    private Integer nHijos;
    @Size(max = 25)
    @Column(name = "salud")
    private String salud;
    @Column(name = "trabajo")
    private Boolean trabajo;
    @Column(name = "nPersonas")
    private Integer nPersonas;
    @Size(max = 25)
    @Column(name = "tipoTrabajo")
    private String tipoTrabajo;
    @Size(max = 25)
    @Column(name = "ingresos")
    private String ingresos;
    @Size(max = 25)
    @Column(name = "contactoAdicional")
    private String contactoAdicional;
    @Column(name = "numTel")
    private Integer numTel;
    @Column(name = "notificacion")
    private Boolean notificacion;
    @Column(name = "estado")
    private Integer estado;
    @OneToMany(mappedBy = "idUsuario", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    private List<Datoscaso> datoscasoList;

    public Usuario() {
    }

    public Usuario(Integer cc) {
        this.cc = cc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Integer getCc() {
        return cc;
    }

    public void setCc(Integer cc) {
        this.cc = cc;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Integer getEstrato() {
        return estrato;
    }

    public void setEstrato(Integer estrato) {
        this.estrato = estrato;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getTipoCasa() {
        return tipoCasa;
    }

    public void setTipoCasa(String tipoCasa) {
        this.tipoCasa = tipoCasa;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getReciboPublico() {
        return reciboPublico;
    }

    public void setReciboPublico(String reciboPublico) {
        this.reciboPublico = reciboPublico;
    }

    public Integer getNHijos() {
        return nHijos;
    }

    public void setNHijos(Integer nHijos) {
        this.nHijos = nHijos;
    }

    public String getSalud() {
        return salud;
    }

    public void setSalud(String salud) {
        this.salud = salud;
    }

    public Boolean getTrabajo() {
        return trabajo;
    }

    public void setTrabajo(Boolean trabajo) {
        this.trabajo = trabajo;
    }

    public Integer getNPersonas() {
        return nPersonas;
    }

    public void setNPersonas(Integer nPersonas) {
        this.nPersonas = nPersonas;
    }

    public String getTipoTrabajo() {
        return tipoTrabajo;
    }

    public void setTipoTrabajo(String tipoTrabajo) {
        this.tipoTrabajo = tipoTrabajo;
    }

    public String getIngresos() {
        return ingresos;
    }

    public void setIngresos(String ingresos) {
        this.ingresos = ingresos;
    }

    public String getContactoAdicional() {
        return contactoAdicional;
    }

    public void setContactoAdicional(String contactoAdicional) {
        this.contactoAdicional = contactoAdicional;
    }

    public Integer getNumTel() {
        return numTel;
    }

    public void setNumTel(Integer numTel) {
        this.numTel = numTel;
    }

    public Boolean getNotificacion() {
        return notificacion;
    }

    public void setNotificacion(Boolean notificacion) {
        this.notificacion = notificacion;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Integer getnHijos() {
        return nHijos;
    }

    public void setnHijos(Integer nHijos) {
        this.nHijos = nHijos;
    }

    public Integer getnPersonas() {
        return nPersonas;
    }

    public void setnPersonas(Integer nPersonas) {
        this.nPersonas = nPersonas;
    }

    public List<Datoscaso> getDatoscasoList() {
        return datoscasoList;
    }

    public void setDatoscasoList(List<Datoscaso> datoscasoList) {
        this.datoscasoList = datoscasoList;
    }
    
   public void addCaso(Datoscaso dato){
        dato.setIdUsuario(this);
        this.datoscasoList.add(dato);
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cc != null ? cc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.cc == null && other.cc != null) || (this.cc != null && !this.cc.equals(other.cc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Usuario[ cc=" + cc + " ]";
    }
    
}
