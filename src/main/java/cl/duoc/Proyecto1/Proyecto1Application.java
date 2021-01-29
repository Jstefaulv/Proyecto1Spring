package cl.duoc.Proyecto1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Proyecto1Application {

        /**
         * esta es la clase principal de la app, que se crea por si sola
         * cuando se necesita levantar el servidor de Spring.
         * No se modifica, no se elimina.
         * @param args 
         */
	public static void main(String[] args) {
		SpringApplication.run(Proyecto1Application.class, args);
	}

}
