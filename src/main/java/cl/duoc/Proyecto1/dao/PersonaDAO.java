
package cl.duoc.Proyecto1.dao;

import org.springframework.data.repository.CrudRepository;
import cl.duoc.Proyecto1.domain.Persona;

public interface PersonaDAO extends CrudRepository<Persona,Long>{
    
}
