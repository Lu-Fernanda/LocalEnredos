
package ServiceRest;

import Facade.FacadeDatosCaso;
import Facade.FacadeInforme;
import ModeloDTO.DatosCasoDTO;
import ModeloDTO.InformeDTO;
import exception.ConexionException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import modelo.Datoscaso;
import modelo.Informe;

/**
 *
 * @author Administrador
 */
@Path("/informes")
public class ServiceInforme {
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public InformeDTO addInforme(InformeDTO inf) throws ConexionException {
        
        FacadeInforme facade = null;
        InformeDTO dto = null;

        facade = new FacadeInforme();
        Informe infJPA = new Informe();
        infJPA.setId(inf.getId());
        infJPA.setFecha(inf.getFecha());
        infJPA.setNHoras(inf.getnHoras());
        infJPA.setInformes(inf.getInformes());
        infJPA.setFactura(inf.getFactura());
        infJPA.setComentarioUsuario(inf.getComentarioUsuario());
        infJPA.setArchivoAdjunto(inf.getArchivoAdjunto());
        
        FacadeDatosCaso fc= new FacadeDatosCaso();
        Datoscaso datos= fc.get(inf.getIdProceso1());
        infJPA.setIdProceso1(datos);
        
        facade.save(infJPA);

        return dto;
    }
    
      
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<InformeDTO> getInforme_JSON() throws ConexionException {
        List<InformeDTO> infDTO = new ArrayList<InformeDTO>();
        FacadeInforme facade = null;

        facade = new FacadeInforme();
        List<Informe> inff = facade.findAll();
        
        for (Informe inf : inff) {
            InformeDTO dto = new InformeDTO(inf);
            infDTO.add(dto);
        }
        return infDTO;
    }
    
    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public InformeDTO getInforme(@PathParam("id") String id) throws ConexionException {
        FacadeInforme facade = null;
        InformeDTO dto = null;

        facade = new FacadeInforme();
        Informe inf = facade.get(Integer.parseInt(id));
        dto = new InformeDTO(inf);
        
        return dto;
    }
}
