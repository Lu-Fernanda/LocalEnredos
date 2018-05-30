
package ModeloDTO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import modelo.*;

@XmlRootElement(name = "DatosCaso")
@XmlAccessorType(XmlAccessType.FIELD)
public class DatosCasoDTO {
    
    private int id;
    private String tipoCaso;
    private Boolean abogadoAnterior;
    private String informacionCaso;
    private ArchivoDTO archivoAdicional;
    private Boolean estado;
    private UsuarioDTO idUsuario;
    private AbogadoDTO idAbogado;
    List<InformeDTO> list_inf;
    List<DiligenciaDTO> list_dil;
    
    public DatosCasoDTO() {
    }

    public DatosCasoDTO(Datoscaso datos) {
        this.id = datos.getId();
        this.tipoCaso = datos.getTipoCaso();
        this.abogadoAnterior = datos.getAbogadoAnterior();
        this.informacionCaso = datos.getInformacionCaso();
        this.archivoAdicional = new ArchivoDTO(datos.getArchivoAdicional());
        this.estado = datos.getEstado();
        this.idUsuario = new UsuarioDTO(datos.getIdUsuario());
        this.idAbogado = new AbogadoDTO(datos.getIdAbogado());
        this.list_inf= new ArrayList<InformeDTO>();
        this.list_dil= new ArrayList<DiligenciaDTO>();
        
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoCaso() {
        return tipoCaso;
    }

    public void setTipoCaso(String tipoCaso) {
        this.tipoCaso = tipoCaso;
    }

    public Boolean getAbogadoAnterior() {
        return abogadoAnterior;
    }

    public void setAbogadoAnterior(Boolean abogadoAnterior) {
        this.abogadoAnterior = abogadoAnterior;
    }

    public String getInformacionCaso() {
        return informacionCaso;
    }

    public void setInformacionCaso(String informacionCaso) {
        this.informacionCaso = informacionCaso;
    }

    public ArchivoDTO getArchivoAdicional() {
        return archivoAdicional;
    }

    public void setArchivoAdicional(ArchivoDTO archivoAdicional) {
        this.archivoAdicional = archivoAdicional;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public UsuarioDTO getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(UsuarioDTO idUsuario) {
        this.idUsuario = idUsuario;
    }

    public AbogadoDTO getIdAbogado() {
        return idAbogado;
    }

    public void setIdAbogado(AbogadoDTO idAbogado) {
        this.idAbogado = idAbogado;
    }

    public void setList_inf(List<InformeDTO> list_inf) {
        this.list_inf = list_inf;
    }
    public void setList_dil(List<DiligenciaDTO> list_dil) {
        this.list_dil = list_dil;
    }
    
    public List<DiligenciaDTO> list_Diligencia(List<Diligencia> list_dil) {
        for (Diligencia dili: list_dil) {
            DiligenciaDTO dTO = new DiligenciaDTO(dili);
            this.list_dil.add(dTO);
        }
        return this.list_dil;
    }

 public List<InformeDTO> list_Informe(List<Informe> list_inf) {
        for (Informe inf: list_inf) {
            InformeDTO dTO = new InformeDTO(inf);
            this.list_inf.add(dTO);
        }
        return this.list_inf;
    }


}
