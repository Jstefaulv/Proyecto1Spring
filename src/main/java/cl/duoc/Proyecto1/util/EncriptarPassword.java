
package cl.duoc.Proyecto1.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class EncriptarPassword {
    public static void main(String[] args) {
        var password="123456";
        System.out.println(""+encriptarPassword(password));
    }
    public static String encriptarPassword(String password){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
}
