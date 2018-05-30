
package ServiceRest;

import Facade.FacadeDatosCaso;
import Facade.FacadeDiligencia;
import ModeloDTO.UsuarioDTO;
import Facade.FacadeUsuario;
import ModeloDTO.DiligenciaDTO;
import exception.ConexionException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import modelo.Datoscaso;
import modelo.Diligencia;
import modelo.Usuario;

@Path("/tramite")
public class ServiceDiligencia {
    
    //Agregar tramite al sistema
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public DiligenciaDTO registroDiligencia(DiligenciaDTO dil) throws ConexionException {
        
        FacadeDiligencia facade = null;
        DiligenciaDTO dto = null;

        facade = new FacadeDiligencia();
        Diligencia dilJPA = new Diligencia();
        
        dilJPA.setDiligencias(dil.getDiligencias());
        dilJPA.setDescripcion(dil.getDescripcion());
        dilJPA.setFechaLimite(dil.getFechaLimite());
        
        FacadeDatosCaso fd= new FacadeDatosCaso();
        Datoscaso dato= fd.get(dil.getIdProceso2());
        dilJPA.setIdProceso2(dato);

        facade.save(dilJPA);

        return dto;
    }
    
    
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<DiligenciaDTO> getDiligencia_JSON() throws ConexionException {
        List<DiligenciaDTO> dilDTO = new ArrayList<DiligenciaDTO>();
        FacadeDiligencia facade = null;

        facade = new FacadeDiligencia();
        List<Diligencia> diligencia = facade.findAll();
        
        for (Diligencia d : diligencia) {
            DiligenciaDTO dto = new DiligenciaDTO(d);
            dilDTO.add(dto);
        }

        return dilDTO;
    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public DiligenciaDTO getDiligencia(@PathParam("id") String id) throws ConexionException {
        FacadeDiligencia facade = null;
        DiligenciaDTO dto = null;

        facade = new FacadeDiligencia();
        Diligencia dil = facade.get(Integer.parseInt(id));
        dto = new DiligenciaDTO(dil);
        return dto;
    }   
}
