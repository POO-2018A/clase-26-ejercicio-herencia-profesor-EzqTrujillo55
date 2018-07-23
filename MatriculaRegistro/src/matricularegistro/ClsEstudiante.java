/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matricularegistro;
import java.io.Serializable;
/**
 *
 * @author Ezq
 */
public class ClsEstudiante implements Serializable{
    
    private String nombre;
    private int id;

    public ClsEstudiante(int id, String nombre) {
        this.nombre = nombre;
        this.id = id;
    }

    public ClsEstudiante() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return  nombre ;
    }
    
    
    
}
