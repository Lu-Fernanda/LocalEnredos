
package ModeloDTO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import modelo.*;

@XmlRootElement(name = "Usuario")
@XmlAccessorType(XmlAccessType.FIELD)

public class UsuarioDTO {
    
    private int cc;
    private int edad;
    private String nombre;
    private String apellido;
    private String tipoDocumento;
    private String celular;
    private String telefono;
    private String correo;
    private int estrato;
    private String direccion;
    private String barrio;
    private String tipoCasa;
    private String localidad;
    private String reciboPublico;
    private int nHijos;
    private String salud;
    private Boolean trabajo;
    private int nPersonas;
    private String tipoTrabajo;
    private String ingresos;    
    private String contactoAdicional;
    private Integer numTel;
    private Boolean notificacion;
    private int estado;
    private List<DatosCasoDTO> datoscaso= new ArrayList<DatosCasoDTO>();

    public UsuarioDTO(Usuario usuario){
        this.cc= usuario.getCc();
        this.edad = usuario.getEdad();
        this.nombre = usuario.getNombre();
        this.apellido = usuario.getApellido();
        this.tipoDocumento = usuario.getTipoDocumento();
        this.celular = usuario.getCelular();
        this.telefono = usuario.getTelefono();
        this.correo = usuario.getCorreo();
        this.estrato = usuario.getEstrato();
        this.direccion = usuario.getDireccion();
        this.barrio = usuario.getBarrio();
        this.tipoCasa = usuario.getTipoCasa();
        this.localidad = usuario.getLocalidad();
        this.reciboPublico = usuario.getReciboPublico();
        this.nHijos = usuario.getNHijos();
        this.salud = usuario.getSalud();
        this.trabajo = usuario.getTrabajo();
        this.nPersonas = usuario.getNPersonas();
        this.tipoTrabajo = usuario.getTipoTrabajo();
        this.ingresos = usuario.getIngresos();
        this.contactoAdicional = usuario.getContactoAdicional();
        this.numTel = usuario.getNumTel();
        this.notificacion = usuario.getNotificacion();
        this.estado = usuario.getEstado();
    }

    public UsuarioDTO() {
    }
    
       

    public int getCc() {
        return cc;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public void setCc(int cc) {
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

    public int getEstrato() {
        return estrato;
    }

    public void setEstrato(int estrato) {
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

    public int getnHijos() {
        return nHijos;
    }

    public void setnHijos(int nHijos) {
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

    public int getnPersonas() {
        return nPersonas;
    }

    public void setnPersonas(int nPersonas) {
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

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public List<DatosCasoDTO> getDatoscaso() {
        return datoscaso;
    }

    public void setDatoscaso(List<DatosCasoDTO> datoscaso) {
        this.datoscaso = datoscaso;
    }

     public List<DatosCasoDTO> list_DatosCaso(List<Datoscaso> list_Casos) {
        for (Datoscaso datos : list_Casos) {
            DatosCasoDTO dTO = new DatosCasoDTO(datos);
            this.datoscaso.add(dTO);
        }
        return this.datoscaso;
    }
    
}
