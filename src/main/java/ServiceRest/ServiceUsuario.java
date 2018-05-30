
package ServiceRest;

import genericdao.DaoAut;
import ModeloDTO.UsuarioDTO;
import Facade.FacadeUsuario;
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
import modelo.Usuario;

@Path("/inscripcion")
public class ServiceUsuario {
    
    //Agregar usuario al sistema
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public UsuarioDTO registroUsuario(UsuarioDTO usu) throws ConexionException {
        
        FacadeUsuario facade = null;
        UsuarioDTO dto = null;

        facade = new FacadeUsuario();
        Usuario usuJPA = new Usuario();
        
        usuJPA.setNombre(usu.getNombre());
        usuJPA.setApellido(usu.getApellido());
        usuJPA.setTipoDocumento(usu.getTipoDocumento());
        usuJPA.setCc(usu.getCc());
        usuJPA.setEdad(usu.getEdad());
        usuJPA.setCelular(usu.getCelular());
        usuJPA.setTelefono(usu.getTelefono());
        usuJPA.setCorreo(usu.getCorreo());
        usuJPA.setEstrato(usu.getEstrato());
        usuJPA.setDireccion(usu.getDireccion());        
        usuJPA.setBarrio(usu.getBarrio());
        usuJPA.setTipoCasa(usu.getTipoCasa());
        usuJPA.setLocalidad(usu.getLocalidad());
        usuJPA.setReciboPublico(usu.getReciboPublico());
        usuJPA.setNHijos(usu.getnHijos());
        usuJPA.setSalud(usu.getSalud());
        usuJPA.setTrabajo(usu.getTrabajo());
        usuJPA.setNPersonas(usu.getnPersonas());
        usuJPA.setTipoTrabajo(usu.getTipoTrabajo());
        usuJPA.setIngresos(usu.getIngresos());
        usuJPA.setContactoAdicional(usu.getContactoAdicional());
        usuJPA.setNumTel(usu.getNumTel());
        usuJPA.setNotificacion(usu.getNotificacion());
        usuJPA.setEstado(usu.getEstado());

        facade.save(usuJPA);

        return dto;
    }

    //Traer todos los usuarios que estan inscritos en el sistema
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<UsuarioDTO> getUsuario_JSON() throws ConexionException {
        List<UsuarioDTO> usuDTO = new ArrayList<UsuarioDTO>();
        FacadeUsuario facade = null;

        facade = new FacadeUsuario();
        List<Usuario> usuarios = facade.findAll();
        
        for (Usuario usu : usuarios) {
            UsuarioDTO dto = new UsuarioDTO(usu);
            usuDTO.add(dto);
        }

        return usuDTO;
    }

    //Traer una persona especifica
    @GET
    @Path("/{cc}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public UsuarioDTO getEmployee(@PathParam("cc") String cc) throws ConexionException {
        FacadeUsuario facade = null;
        UsuarioDTO dto = null;

        facade = new FacadeUsuario();
        Usuario usu = facade.get(Integer.parseInt(cc));
        dto = new UsuarioDTO(usu);
        dto.list_DatosCaso(usu.getDatoscasoList());
        return dto;
    }
}
