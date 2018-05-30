
package Facade;

import exception.ConexionException;
import genericdao.ServiceImpl;
import genericdao.SingletonConnection;
import javax.persistence.EntityManager;
import modelo.Usuario;
import modelo.Datoscaso;

public class FacadeDatosCaso extends ServiceImpl<Datoscaso> {
    
     public FacadeDatosCaso() throws ConexionException {
        super(Datoscaso.class);
        try{
             EntityManager em = SingletonConnection.getConnection();
            super.setEntityManager(em);
        }catch(Exception e){
           throw new ConexionException("Problemas en la realizacion de conexion con la base de datos");
        }
    }
}
