
package ServiceRest;

import Facade.FacadeArchivo;
import genericdao.DaoAut;
import ModeloDTO.UsuarioDTO;
import Facade.FacadeUsuario;
import ModeloDTO.ArchivoDTO;
import exception.ConexionException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import modelo.Archivo;
import modelo.Usuario;
import static org.eclipse.persistence.expressions.ExpressionOperator.today;

@Path("/archivo")
public class ServiceArchivo {
    
   
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public ArchivoDTO registroArchivo(ArchivoDTO arr) throws ConexionException {
        
        java.util.Date today = new java.util.Date();
           
        FacadeArchivo facade = null;
        ArchivoDTO dto = null;

        facade = new FacadeArchivo();
        Archivo arrJPA = new Archivo();
        
        arrJPA.setFName(arr.getfName());
        arrJPA.setTipo(arr.getTipo());
        arrJPA.setSize(arr.getSize());
        arrJPA.setDate(new java.sql.Timestamp(today.getTime()));
        
        facade.save(arrJPA);

        return dto;
    }
}
