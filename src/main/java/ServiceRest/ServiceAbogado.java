
package ServiceRest;

import Facade.FacadeAbogado;
import Facade.FacadeUsuario;
import ModeloDTO.AbogadoDTO;
import ModeloDTO.UsuarioDTO;
import exception.ConexionException;
import genericdao.DaoAut;
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
import modelo.Abogado;
import modelo.Usuario;

@Path("/abogado")
public class ServiceAbogado {
  
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    
     public AbogadoDTO registroAbogado(AbogadoDTO abogado) throws ConexionException {
        
        FacadeAbogado facade = null;
        AbogadoDTO dto = null;

        facade = new FacadeAbogado();
        Abogado abogJPA = new Abogado();
        
        abogJPA.setEntidad(abogado.getEntidad());
        abogJPA.setNombreEntidad(abogado.getNombreEntidad());
        abogJPA.setTarjetaProfesional(abogado.getTarjetaProfesional());
        abogJPA.setAreaEspecializacion(abogado.getAreaEspecializacion());
        abogJPA.setCc(abogado.getCc());
        abogJPA.setNombre(abogado.getNombre());      
        abogJPA.setCorreo(abogado.getCorreo());
        
        DaoAut dao= new DaoAut();
        dao.VerCorreo(abogado.getCorreo());
        facade.save(abogJPA);

        return dto;
    }
     
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<AbogadoDTO> getAbogado_JSON() throws ConexionException {
       
        FacadeAbogado facade = new FacadeAbogado();
        List<Abogado> abogados = facade.findAll();
        List<AbogadoDTO> usuDTO = new ArrayList<AbogadoDTO>();
        for (Abogado abog : abogados) {
            AbogadoDTO dto = new AbogadoDTO(abog);
            dto.list_DatosCaso(abog.getDatoscasoList());            
            usuDTO.add(dto);
        }
        return usuDTO;
    }
    
    @GET
    @Path("/{cc}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public AbogadoDTO getEmployee(@PathParam("cc") String cc) throws ConexionException {
        FacadeAbogado facade = null;
        AbogadoDTO dto = null;

        facade = new FacadeAbogado();
        Abogado abog = facade.get(Integer.parseInt(cc));
        dto = new AbogadoDTO(abog);
        dto.list_DatosCaso(abog.getDatoscasoList());
        return dto;
    }

}
