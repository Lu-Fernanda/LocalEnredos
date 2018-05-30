
package Facade;

import exception.ConexionException;
import genericdao.ServiceImpl;
import genericdao.SingletonConnection;
import javax.persistence.EntityManager;
import modelo.Usuario;

public class FacadeUsuario extends ServiceImpl<Usuario> {
    
     public FacadeUsuario() throws ConexionException {
        super(Usuario.class);
        try{
            System.out.println("hola mundo");
             EntityManager em = SingletonConnection.getConnection();
            System.out.println("conexion!!");
            super.setEntityManager(em);
        }catch(Exception e){
            System.out.println(e.getMessage());
           throw new ConexionException("Problemas en la realizacion de conexion con la base de datos");
        }
    }
}
