package cl.duoc.Proyecto1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import cl.duoc.Proyecto1.domain.Usuario;

public interface UsuarioDAO extends JpaRepository<Usuario,Long>{
    //clase hereda de clase
    //clase implementa una interface
    //interface hereda de interface
    
    Usuario findByUsername(String username);
}
