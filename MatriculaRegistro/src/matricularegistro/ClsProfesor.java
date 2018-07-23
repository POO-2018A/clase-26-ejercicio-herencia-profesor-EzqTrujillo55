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
public class ClsProfesor implements Serializable {
    
    private String nProfesor;
    private String profesion; 
    private int id; 
    
    public ClsProfesor(int id , String nProfesor, String profesion) {
        this.id = id; 
        this.nProfesor = nProfesor;
        this.profesion = profesion;
    }

    public ClsProfesor() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getnProfesor() {
        return nProfesor;
    }

    public void setnProfesor(String nProfesor) {
        this.nProfesor = nProfesor;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    @Override
    public String toString() {
        return  nProfesor;
    }

  
    
    
}
