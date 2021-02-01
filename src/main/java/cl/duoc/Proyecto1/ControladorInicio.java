
package cl.duoc.Proyecto1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import cl.duoc.Proyecto1.domain.Persona;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Johana
 */

@Controller
@Slf4j
public class ControladorInicio { //trabaja con tecnología de Servlets
    //Thymeleaf
    //Spring + MVC + Thymeleaf
   
    
    @Value("${index.variable}")
    private String variable;
    
    /**
     * 
     * @param modelo es un objeto de tipo Model, que es
     * muy similar a trabajar con HttpServletRequest y HttpServletResponse, pero
     * es una dependencia de Spring que permite codificar menos.
     * @return 
     */
    @GetMapping("/")
    public String inicio(Model modelo){
        
        /**
         * protected void doGet(HttpServletRequest peticion, HttpServletResponse respuesta)
         */
         //SLF4J 
         /**
          * permite imprimir mensajes en la consola de Spring.
          */
         String mensaje = "Hola desde Thymeleaf";
         
         modelo.addAttribute("mensaje",mensaje);
         modelo.addAttribute("variable",variable);
         
         Persona p=new Persona();
         p.setNombre("Johana");
         p.setApellido("Estefo");
         p.setEmail("jestefo@gmail.com");
         p.setTelefono("12345678");
         
         Persona p2 = new Persona();
         p2.setNombre("Juan");
         p2.setApellido("Perez");
         p2.setEmail("jperez@gmail.com");
         p2.setTelefono("4657468");
         
         List personas = Arrays.asList(p,p2);
         //List personas= new ArrayList();
         modelo.addAttribute("personas",personas);
         
         //modelo.addAttribute("p",p);
         
         return "index";
    }
}
