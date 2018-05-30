
package Facade;

import exception.ConexionException;
import genericdao.ServiceImpl;
import genericdao.SingletonConnection;
import javax.persistence.EntityManager;
import modelo.Abogado;
import modelo.Usuario;

public class FacadeAbogado extends ServiceImpl<Abogado> {
    
     public FacadeAbogado() throws ConexionException {
        super(Abogado.class);
        try{
             EntityManager em = SingletonConnection.getConnection();
            super.setEntityManager(em);
        }catch(Exception e){
           throw new ConexionException("Problemas en la realizacion de conexion con la base de datos");
        }
    }
}
