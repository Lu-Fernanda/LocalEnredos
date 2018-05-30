
package Facade;

import exception.ConexionException;
import genericdao.ServiceImpl;
import genericdao.SingletonConnection;
import javax.persistence.EntityManager;
import modelo.Abogado;
import modelo.Diligencia;
import modelo.Usuario;

public class FacadeDiligencia extends ServiceImpl<Diligencia> {
    
     public FacadeDiligencia() throws ConexionException {
        super(Diligencia.class);
        try{
             EntityManager em = SingletonConnection.getConnection();
            super.setEntityManager(em);
        }catch(Exception e){
           throw new ConexionException("Problemas en la realizacion de conexion con la base de datos");
        }
    }
}
