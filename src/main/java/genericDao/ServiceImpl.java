/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genericdao;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author fabian.giraldo
 */
public class ServiceImpl<T> implements Service<T>  {
  
    protected EntityManager entityManager;
    protected Class type;
    protected String entity;
      
    public ServiceImpl(Class<T> entityClass){
       this.type = entityClass;
    }
    
    public T get(Object id){
        return (T) entityManager.find(type, id);
    }

    public void delete(T object){
        if(!entityManager.getTransaction().isActive())
             entityManager.getTransaction().begin();
        entityManager.remove(object);
        
        try {
             entityManager.flush();
             entityManager.clear();
             
          } catch (PersistenceException exception) {
             throw new RuntimeException(exception);
          }
        
        entityManager.getTransaction().commit();
     
    }

    public List<T> findAll(){
         
        Query query = 
             entityManager.createQuery("select x from " + 
                                                      getEntityName() + " x ");
        query.setHint("javax.persistence.cache.storeMode", "REFRESH");
        query.setHint("eclipselink.refresh", "true");
        return (List<T>) query.getResultList();
    }

    public List<T> findByProperty(String prop, Object val){
        Query query = 
            entityManager.createQuery("select x from " + 
                                                     getEntityName() + 
                                                   " x where x." + prop + " = ?1");
        query.setParameter(1, val);
        return (List<T>) query.getResultList();
    }

    public void save(T object){
        if(!entityManager.getTransaction().isActive())
             entityManager.getTransaction().begin();
             entityManager.persist(object);
        try {
             entityManager.flush();
             entityManager.clear();
             
          } catch (PersistenceException exception) {
             throw new RuntimeException(exception);
          }
        
        entityManager.getTransaction().commit();
    }

    public T update(T object){
         if(!entityManager.getTransaction().isActive())
             entityManager.getTransaction().begin();
        T t = entityManager.merge(object);
        
        try {
             entityManager.flush();
           
        } catch (PersistenceException exception) {
             throw new RuntimeException(exception);
        }
        
        entityManager.getTransaction().commit();
        
        
        return t;
    }
   
    public void setEntityManager(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public Class getType(){
        return type;
    }

    public void setType(Class type){
        this.type = type;
    }
    
 
    public String getEntityName(){
        if (entity == null) {
            Entity entityAnn = (Entity) type.getAnnotation(Entity.class);
            if (entityAnn != null && !entityAnn.name().equals("")){
                entity = entityAnn.name();
            } else{
                entity = type.getSimpleName();
            }
        }
        
        return entity;
    }

}
