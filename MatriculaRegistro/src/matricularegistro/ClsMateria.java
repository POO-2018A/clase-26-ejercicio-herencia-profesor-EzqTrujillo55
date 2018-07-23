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
public class ClsMateria implements Serializable {
    
    private String nMateria;
    private int id; 

    public ClsMateria(int id , String nMateria) {
        
        this.id= id;
        this.nMateria = nMateria;
    }

    public ClsMateria() {
    }
    
    

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public String getnMateria() {
        return nMateria;
    }

    public void setnMateria(String nMateria) {
        this.nMateria = nMateria;
    }

    @Override
    public String toString() {
        return nMateria ; 
    }

  
    
    
    
    
}
