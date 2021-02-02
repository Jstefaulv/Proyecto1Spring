
package cl.duoc.Proyecto1.web;

import cl.duoc.Proyecto1.dao.PersonaDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import cl.duoc.Proyecto1.domain.Persona;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Johana
 */

@Controller
@Slf4j
public class ControladorInicio { //trabaja con tecnología de Servlets
    
    @Autowired
    private PersonaDAO personaDAO;
    
    @GetMapping("/")
    public String inicio(Model modelo){
        
        var personas = personaDAO.findAll();
        modelo.addAttribute("personas",personas);
         return "index";
    }
}
