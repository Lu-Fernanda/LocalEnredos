/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDTO;

import java.util.Date;
import javax.servlet.http.Part;
import modelo.Archivo;

/**
 *
 * @author blue
 */
public class ArchivoDTO {
    
    private int id;
    private String fName;
    private  String tipo;
    private int size;
    private Date date;

    public ArchivoDTO() {
    }

    public ArchivoDTO(Archivo arc){
        this.id = arc.getId();
        this.fName = arc.getFName();
        this.tipo = arc.getTipo();
        this.size = arc.getSize();
        this.date = arc.getDate();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
}
