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
public class Estudiante extends Persona {
    
    private String carrera;
    private String  materias;

    public Estudiante(String carrera, String nombre, String edad) {
        super(nombre, edad);
        this.carrera = carrera;
        
    }

    public Estudiante(String carrera, String nombre, String edad, String materias) {
        super(nombre, edad);
        this.carrera = carrera;
        this.materias = materias;
    }
    
    

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getMaterias() {
        return materias;
    }

    public void setMaterias(String materias) {
        this.materias = materias;
    }

    @Override
    public String toString() {
        return " Nombre estudiante:"+ nombre + " " + "Edad estudiante:" + edad+ " " + "Carrera:" + carrera +" "+"Materias: " + materias;
    }
    

    
    

   
    
    
    
}
