
package cl.duoc.Proyecto1.service;

import cl.duoc.Proyecto1.dao.PersonaDAO;
import cl.duoc.Proyecto1.domain.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonaServiceImplementation implements PersonaService {

    @Autowired
    private PersonaDAO personaDAO;
    
    @Override
    @Transactional(readOnly = true)
    public List<Persona> listarPersonas() {
        return (List<Persona>)personaDAO.findAll();
    }

    @Override
    @Transactional
    public void guardar(Persona persona) {
        personaDAO.save(persona);
    }

    @Override
    @Transactional
    public void eliminar(Persona persona) {
        personaDAO.delete(persona);
    }

    @Override
    @Transactional(readOnly=true)
    public Persona encontrarPersona(Persona persona) {
        return personaDAO.findById(persona.getIdPersona()).orElse(persona);
    }
    
}
