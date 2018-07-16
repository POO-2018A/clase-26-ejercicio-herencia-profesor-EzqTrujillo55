/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matriculas;

/**
 *
 * @author Ezq
 */
public class Profesor extends Persona {
    
    private String profesion; 
    private String materia;

    public Profesor(String profesion, String materia, String nombre, String edad) {
        super(nombre, edad);
        this.profesion = profesion;
        this.materia = materia;
    }

    

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    @Override
    public String toString() {
        return " Nombre profesor:"+ nombre + " " + "Edad profesor:" + edad+ " " + "Profesión:" + profesion +" "+"Materia que dicta:" + materia;
    }
    
    
    
    
    
}
