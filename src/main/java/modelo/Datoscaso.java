/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author blue
 */
@Entity
@Table(name = "datoscaso")
@XmlRootElement
public class Datoscaso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "tipoCaso")
    private String tipoCaso;
    @Column(name = "abogadoAnterior")
    private Boolean abogadoAnterior;
    @Size(max = 30)
    @Column(name = "informacionCaso")
    private String informacionCaso;
    @Column(name = "estado")
    private Boolean estado;
    @JoinColumn(name = "idUsuario", referencedColumnName = "cc")
    @ManyToOne(fetch=FetchType.LAZY)
    private Usuario idUsuario;
    @JoinColumn(name = "idAbogado", referencedColumnName = "cc")
    @ManyToOne(fetch=FetchType.LAZY)
    private Abogado idAbogado;
    @JoinColumn(name = "archivoAdicional", referencedColumnName = "id")
    @ManyToOne(fetch=FetchType.LAZY)
    private Archivo archivoAdicional;
    @OneToMany(mappedBy = "idProceso2", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    private List<Diligencia> diligenciaList;
    @OneToMany(mappedBy = "idProceso1", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    private List<Informe> informeList;

    public Datoscaso() {
    }

    public Datoscaso(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Abogado getIdAbogado() {
        return idAbogado;
    }

    public void setIdAbogado(Abogado idAbogado) {
        this.idAbogado = idAbogado;
    }

    public Archivo getArchivoAdicional() {
        return archivoAdicional;
    }

    public void setArchivoAdicional(Archivo archivoAdicional) {
        this.archivoAdicional = archivoAdicional;
    }

    public List<Diligencia> getDiligenciaList() {
        return diligenciaList;
    }

    public void setDiligenciaList(List<Diligencia> diligenciaList) {
        this.diligenciaList = diligenciaList;
    }
    
      public void addDiligencia(Diligencia diligencia){
        diligencia.setIdProceso2(this);
        this.diligenciaList.add(diligencia);
    }

    public List<Informe> getInformeList() {
        return informeList;
    }

    public void setInformeList(List<Informe> informeList) {
        this.informeList = informeList;
    }

     public void addInforme(Informe inf){
        inf.setIdProceso1(this);
        this.informeList.add(inf);
    }
      

    @Override
    public String toString() {
        return "modelo.Datoscaso[ id=" + id + " ]";
    }
    
}
