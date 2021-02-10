package cl.duoc.Proyecto1.service;

import cl.duoc.Proyecto1.dao.UsuarioDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.duoc.Proyecto1.domain.Usuario;
import cl.duoc.Proyecto1.domain.Rol;

import java.util.ArrayList;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

@Service("userDetailsService")
@Slf4j //esto es para mostrar cosas en el log de la consola
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioDAO usuarioDAO;
    
    @Override
    @Transactional(readOnly=true)//Spring
    public UserDetails loadUserByUsername(String username) 
            throws UsernameNotFoundException {
      Usuario usuario = usuarioDAO.findByUsername(username);
      
      if(usuario == null){
          throw new UsernameNotFoundException(username);
      }
      var roles = new ArrayList<GrantedAuthority>();
      //roles - nivel de permiso que tiene el rol
      
      for(Rol rol:usuario.getRoles()){//foreach-for mejorado
          roles.add(new SimpleGrantedAuthority(rol.getNombre()));
      }
      //recorre los roles de los usuarios
      //usando la relación que existe entre Usuario/Rol
      //añade a la lista de Permisos el nombre del usuario.
      //Admin - permisos para todo
      //user - permisos limitados
      //guess - permisos aún más limitados
      
      return new User(usuario.getUsername(),
              usuario.getPassword(),
              roles);
      //retorna un usuario de Tipo SpringSecurity
      //nos entrega el usuario y clave.
    }
    
}
