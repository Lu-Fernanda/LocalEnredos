
package genericdao;

import java.util.List;

public interface Service<T> 
{
    T get(Object id);
    void save(T object);
    T update(T object);
    void delete(T object);
    List<T> findAll();
    List<T> findByProperty(String prop, Object val);
}
