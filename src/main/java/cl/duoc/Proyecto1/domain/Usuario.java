package cl.duoc.Proyecto1.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name="usuario")
public class Usuario implements Serializable {
    private static final long serialVersionUID=1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idUsuario;//id_usuario
    
    private String username;
    private String password;
    
    @OneToMany //uno a muchos
    //@ManyToMany - muchos a muchos
    @JoinColumn(name="id_usuario")
    private List<Rol> roles;
   
}
