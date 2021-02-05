
package cl.duoc.Proyecto1.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import cl.duoc.Proyecto1.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

import cl.duoc.Proyecto1.domain.Persona;
/**
 *
 * @author Johana
 */

@Controller
@Slf4j
public class ControladorInicio { //trabaja con tecnología de Servlets
    
    @Autowired //enlazando a controladorInicio
    //con personaService
    //para que trabajen en conjunto
    private PersonaService personaService;
    
    @GetMapping("/")
    public String inicio(Model modelo){
        var personas = personaService.listarPersonas();
        modelo.addAttribute("personas",personas);
         return "index";
    }
    /**
     * Desde index, se presionará un link para 
     * llevarnos a la pagina de modificar.html, 
     * cuando presione el link en la url mostrará
     * la palabra "agregar" en vez del nombre del archivo
     * @param persona
     * @return 
     */
    @GetMapping("/agregar")
    public String agregar(Persona persona){
        return "modificar";
    }
    /**
     * al presionar guardar en el formulario, 
     * considerando que el boton debe ser un submit,
     * enviará los datos a procesarse en personaService,
     * para poder almacenar el objeto de persona.
     * @param persona
     * @return 
     */
    @PostMapping("/guardar")
    public String guardar(Persona persona){
        personaService.guardar(persona);
        return "redirect:/";
    }
    
    //editar
    /**
     * Se crea un método que se llama Editar
     * el editar lo que hace es:
     * buscar al objeto de persona y añadirla al modelo.
     * la consulta sql que hace por detrás de la
     * codificación es un SELECT BY ID
     * select nombre,apellido,email,telefono 
     * from persona where id=?;(Esto lo hace el CrudRepository)
     * cuando encuentra a la persona, entonces, la edita
     * tomando su ID y luego lo envía a la vista dentro del
     * modificar.html
     */
    @GetMapping("/editar/{idPersona}")
    public String editar(Persona persona,Model modelo){
        persona = personaService.encontrarPersona(persona);
        modelo.addAttribute("persona",persona);
        return "modificar";
    }
    //eliminar
    @GetMapping("/eliminar")
    public String eliminar(Persona persona){
        personaService.eliminar(persona);
        return "redirect:/";
    } 
}
