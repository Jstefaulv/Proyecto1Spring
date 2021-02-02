
package cl.duoc.Proyecto1.domain;


import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

/**
 *
 * @author Johana
 */
@Data //lo que crea los getter,setter, toString, etc. Automáticamente.
@Entity //reconoce la clase como entidad
@Table(name="persona") //para que no tenga errores en reconocer la tabla en la bdd
public class Persona  implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idPersona; //idPersona es la identidad de la tabla/entidad de persona en bdd
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
}
