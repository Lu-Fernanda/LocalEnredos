package ModeloDTO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import modelo.Abogado;
import modelo.Datoscaso;

@XmlRootElement(name = "Abogado")
@XmlAccessorType(XmlAccessType.FIELD)
public class AbogadoDTO {

    private String entidad;
    private String nombreEntidad;
    private String tarjetaProfesional;
    private String areaEspecializacion;
    private int cc;
    private String nombre;
    private String correo;
    private List<DatosCasoDTO> datoscasoList;

    public AbogadoDTO() {
    }

    public AbogadoDTO(Abogado abogado) {
        this.entidad = abogado.getEntidad();
        this.nombreEntidad = abogado.getNombreEntidad();
        this.tarjetaProfesional = abogado.getTarjetaProfesional();
        this.areaEspecializacion = abogado.getAreaEspecializacion();
        this.cc = abogado.getCc();
        this.nombre = abogado.getNombre();
        this.correo = abogado.getCorreo();
        this.datoscasoList = new ArrayList<DatosCasoDTO>();
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

    public int getCc() {
        return cc;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setDatoscasoList(List<DatosCasoDTO> datoscasoList) {
        this.datoscasoList = datoscasoList;
    }

    public List<DatosCasoDTO> list_DatosCaso(List<Datoscaso> list_Casos) {
        for (Datoscaso datos : list_Casos) {
            DatosCasoDTO dTO = new DatosCasoDTO(datos);
            this.datoscasoList.add(dTO);
        }
        return this.datoscasoList;
    }
}
