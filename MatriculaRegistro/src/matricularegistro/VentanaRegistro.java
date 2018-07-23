/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matricularegistro;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ezq
 */
public class VentanaRegistro extends javax.swing.JFrame {

    ArrayList<Object> listaMaterias = new ArrayList<>(); 
    ArrayList <Object> listaProfes = new ArrayList<>(); 
    ArrayList <Object> listaEsts = new ArrayList<>(); 
    int cont = 0;
    int cont2 = 0; 
    int cont3 =0; 
    ClsControlador controller = new ClsControlador();
    
    
    
    public VentanaRegistro() {
        initComponents();
        listaMaterias = controller.extraerObjetos("materias.dat"); //El arraylist lee el archivo
        listaProfes = controller.extraerObjetos("profes.dat"); 
        listaEsts = controller.extraerObjetos("ests.dat"); 
        llenarCombo(); //Se ejecuta el método llenarCombo
        llenarGrid(); //Se ejecuta el método llenarGrid
        llenarCombo2();
        llenarGrid2();
        llenarCombo3();
        llenarGrid3(); 
        if(listaMaterias.size() > 0){ //Si el arraylist tiene elementos, se crea un nuevo objeto, y de este se obtiene el numero. 
            ClsMateria ultima = (ClsMateria) listaMaterias.get(listaMaterias.size()-1);
            cont = ultima.getid(); //Se asigna ese numero a un contador
        }
        
       
        btnmodMateria.setEnabled(false); //El boton modificar y eliminar estan deshabilitados ya que aún no se han ingresado materias
        btnelMateria.setEnabled(false);
        btnmodProfe.setEnabled(false);
        btnelProfe.setEnabled(false);
        btnmodEst.setEnabled(false);
        btnelEst.setEnabled(false);
    
    
    }
    
     public void llenarCombo(){
        if(listaMaterias.size() > 0  ){ //si el arraylist tiene algo
            cbxMaterias.setEnabled(true); //el combobox se activa para ser desplegado
            
            listaMaterias = controller.extraerObjetos("materias.dat"); //el arraylist lee lo que esta en el archivo
            cbxMaterias.setModel(new javax.swing.DefaultComboBoxModel(listaMaterias.toArray())); //el combobox obtiene el contenido del arraylist
        }else{ //si el arraylist no tiene algo
            cbxMaterias.setEnabled(false);  //el combobox no se activa para ser desplegado
        }
    }
    
    public void llenarGrid(){
        if(listaProfes.size() > 0){ //si el arraylist tiene algo
            ClsMateria matr = new ClsMateria(); //creamos un objeto de tipo clsmateria
            DefaultTableModel model = (DefaultTableModel) tblMaterias.getModel(); //establecemos un modelo para la tabla
            for(int i = 0; i < listaMaterias.size(); i ++){
                matr = (ClsMateria) listaMaterias.get(i); //iteramos por el tamañao del arraylist y asignamos el objeto de cada posicion
                Object materiasG [] = {matr.getid(), matr.getnMateria()}; //almacenamos dentro de un arregl ode materias los datos de las materias por cada posicion
                model.insertRow(i, materiasG); //insertamos en la posicion indicada de la tabla lo que esta dentro del arreglo previamente llenado
            }
        }
    }
    
     public void limpiar(){ //Vacía los campos de texto 
        txtnMateria.setText(null);
        btnRegMateria.setEnabled(true);
    }
     
       public void llenarCombo2(){
        if(listaProfes.size() > 0){ //si el arraylist tiene algo
             //el combobox se activa para ser desplegado
            cbxProfes.setEnabled(true); 
            listaProfes = controller.extraerObjetos("profes.dat"); //el arraylist lee lo que esta en el archivo
            cbxProfes.setModel(new javax.swing.DefaultComboBoxModel(listaProfes.toArray())); //el combobox obtiene el contenido del arraylist
        }else{ //si el arraylist no tiene algo
            cbxProfes.setEnabled(false);  //el combobox no se activa para ser desplegado
        }
    }
    
    public void llenarGrid2(){
        if(listaProfes.size() > 0){ //si el arraylist tiene algo
            ClsProfesor profe = new ClsProfesor(); //creamos un objeto de tipo clsmateria
            DefaultTableModel model = (DefaultTableModel) tblProfes.getModel(); //establecemos un modelo para la tabla
            for(int i = 0; i < listaProfes.size(); i ++){
                profe = (ClsProfesor) listaProfes.get(i); //iteramos por el tamañao del arraylist y asignamos el objeto de cada posicion
                Object profesG [] = {profe.getId(), profe.getnProfesor(), profe.getProfesion()}; //almacenamos dentro de un arregl ode materias los datos de las materias por cada posicion
                model.insertRow(i, profesG); //insertamos en la posicion indicada de la tabla lo que esta dentro del arreglo previamente llenado
            }
        }
    }
    
     public void limpiar2(){ //Vacía los campos de texto 
        txtnProfesor.setText(null);
        txtProfesion.setText(null); 
        btnRegProfe.setEnabled(true);
    }
     
    public void llenarCombo3(){
        if(listaEsts.size() > 0){ //si el arraylist tiene algo
          
            cbxEsts.setEnabled(true); 
            listaEsts = controller.extraerObjetos("ests.dat"); //el arraylist lee lo que esta en el archivo
            cbxEsts.setModel(new javax.swing.DefaultComboBoxModel(listaEsts.toArray())); //el combobox obtiene el contenido del arraylist
        }else{ //si el arraylist no tiene algo
            cbxEsts.setEnabled(false);  //el combobox no se activa para ser desplegado
        }
    }
    
    public void llenarGrid3(){
        if(listaEsts.size() > 0){ //si el arraylist tiene algo
            ClsEstudiante est = new ClsEstudiante(); //creamos un objeto de tipo clsmateria
            DefaultTableModel model = (DefaultTableModel) tblEsts.getModel(); //establecemos un modelo para la tabla
            for(int i = 0; i < listaEsts.size(); i ++){
               // est = (ClsEstudiante) listaEsts.get(i); //iteramos por el tamañao del arraylist y asignamos el objeto de cada posicion
                Object estsG [] = {est.getId(), est.getNombre()}; //almacenamos dentro de un arregl ode materias los datos de las materias por cada posicion
                model.insertRow(i, estsG); //insertamos en la posicion indicada de la tabla lo que esta dentro del arreglo previamente llenado
            }
        }
    }
    
     public void limpiar3(){ //Vacía los campos de texto 
        txtNombre.setText(null);
        btnRegEst.setEnabled(true);
    }
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane6 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtnMateria = new javax.swing.JTextField();
        btnRegMateria = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMaterias = new javax.swing.JTable();
        cbxMaterias = new javax.swing.JComboBox<>();
        btnmodMateria = new javax.swing.JButton();
        btnelMateria = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtnProfesor = new javax.swing.JTextField();
        btnRegProfe = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProfes = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtProfesion = new javax.swing.JTextField();
        cbxProfes = new javax.swing.JComboBox<>();
        btnmodProfe = new javax.swing.JButton();
        btnelProfe = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnRegEst = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblEsts = new javax.swing.JTable();
        cbxEsts = new javax.swing.JComboBox<>();
        btnmodEst = new javax.swing.JButton();
        btnelEst = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Materia: ");

        btnRegMateria.setText("Registrar materia");
        btnRegMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegMateriaActionPerformed(evt);
            }
        });

        tblMaterias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N°", "Materia"
            }
        ));
        jScrollPane1.setViewportView(tblMaterias);

        cbxMaterias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMateriasActionPerformed(evt);
            }
        });

        btnmodMateria.setText("Modificar materia");
        btnmodMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodMateriaActionPerformed(evt);
            }
        });

        btnelMateria.setText("Eliminar materia");
        btnelMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnelMateriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtnMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRegMateria)
                        .addGap(18, 18, 18)
                        .addComponent(cbxMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnmodMateria)
                        .addGap(18, 18, 18)
                        .addComponent(btnelMateria)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtnMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegMateria)
                    .addComponent(cbxMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnmodMateria)
                    .addComponent(btnelMateria))
                .addGap(118, 118, 118))
        );

        jTabbedPane6.addTab("Registro materias", jPanel1);

        jLabel2.setText("Nombre:");

        btnRegProfe.setText("Registrar profesor");
        btnRegProfe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegProfeActionPerformed(evt);
            }
        });

        tblProfes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N°", "Nombre", "Profesión"
            }
        ));
        jScrollPane2.setViewportView(tblProfes);

        jLabel3.setText("Profesión:");

        cbxProfes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxProfesActionPerformed(evt);
            }
        });

        btnmodProfe.setText("Modificar profesor");
        btnmodProfe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodProfeActionPerformed(evt);
            }
        });

        btnelProfe.setText("Eliminar profesor");
        btnelProfe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnelProfeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtProfesion))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtnProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(btnRegProfe)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxProfes, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnmodProfe)
                                .addGap(28, 28, 28)
                                .addComponent(btnelProfe))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtnProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtProfesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegProfe)
                    .addComponent(cbxProfes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnmodProfe)
                    .addComponent(btnelProfe))
                .addContainerGap(117, Short.MAX_VALUE))
        );

        jTabbedPane6.addTab("Registro profesores", jPanel2);

        jLabel4.setText("Nombre:");

        btnRegEst.setText("Registrar estudiante");
        btnRegEst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegEstActionPerformed(evt);
            }
        });

        tblEsts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N°", "Nombre"
            }
        ));
        jScrollPane3.setViewportView(tblEsts);

        cbxEsts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEstsActionPerformed(evt);
            }
        });

        btnmodEst.setText("Modificar Estudiante");
        btnmodEst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodEstActionPerformed(evt);
            }
        });

        btnelEst.setText("Eliminar Estudiante");
        btnelEst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnelEstActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRegEst)
                        .addGap(18, 18, 18)
                        .addComponent(cbxEsts, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnmodEst)
                                .addGap(54, 54, 54)
                                .addComponent(btnelEst))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegEst)
                    .addComponent(cbxEsts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnmodEst)
                    .addComponent(btnelEst))
                .addGap(177, 177, 177))
        );

        jTabbedPane6.addTab("Registro Estudiantes", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegMateriaActionPerformed
        // TODO add your handling code here:
        System.out.println("registra");
        cont++; //Cada vez que damos en el boton registrar, el contador aumenta en uno
        ClsMateria materia = new ClsMateria( cont , txtnMateria.getText());  //creamos un objeto de clase materia 
        listaMaterias.add(materia);  //añadimos ese objeto a nuestro arraylist de materias
        controller.escribirObjeto("materias.dat" , listaMaterias);  //el arraylist envia su contenido al archivo
        listaMaterias = controller.extraerObjetos("materias.dat"); //el arraylist recoge el contenido del archivo
        limpiar(); 
        llenarCombo(); //ejecuta el metodo llenarCombo
        Object materiasG [] = { materia.getid() , materia.getnMateria()}; //dentro de un arreglo de materias, asignamos lo obtenido del objeto
        DefaultTableModel model = (DefaultTableModel) tblMaterias.getModel(); //asignamos un modelo a la tabla
        model.addRow(materiasG);  //agregamos una fila a la tabla que contendrá lo obtenido del arreglo de materias. 
    }//GEN-LAST:event_btnRegMateriaActionPerformed

    private void btnmodMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodMateriaActionPerformed
        // TODO add your handling code here:
        ClsMateria materiaSeleccionada = (ClsMateria)cbxMaterias.getSelectedItem(); //Segun lo seleccionado en el combobox
        materiaSeleccionada.setnMateria(txtnMateria.getText()); //Asignamos dichos datos en el textfield
       
        Object materiasG [] = {materiaSeleccionada.getid(),materiaSeleccionada.getnMateria()}; //Inicializamos un arreglo de materias con lo modificado
        DefaultTableModel model = (DefaultTableModel) tblMaterias.getModel(); //Asignamos un modelo a la tabla
        model.removeRow(cbxMaterias.getSelectedIndex()); //Eliminamos la fila de lo seleccionado
        listaMaterias.remove(cbxMaterias.getSelectedIndex()); //Eliminamos lo seleccionado del arraylist
        model.insertRow(cbxMaterias.getSelectedIndex(), materiasG); //Agregamos una nueva columna con lo almacenado en el arreglo de materias
        listaMaterias.add(cbxMaterias.getSelectedIndex(), materiaSeleccionada); //agregamos al arraylist
        controller.escribirObjeto("materias.dat", listaMaterias); //el arraylist envia lo obtenido al archivo
        llenarCombo(); //se ejecuta el metodo llenarcombo
        limpiar();
        btnmodMateria.setEnabled(false); //los botones modificar y eliminar estan deshabilitados 
        btnelMateria.setEnabled(false);
    }//GEN-LAST:event_btnmodMateriaActionPerformed

    private void btnelMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnelMateriaActionPerformed
        // TODO add your handling code here:
          ClsMateria materiaSeleccionada = (ClsMateria)cbxMaterias.getSelectedItem(); //Segun lo seleccionado en el combobox
        DefaultTableModel model = (DefaultTableModel) tblMaterias.getModel(); //asignamos modelo a la tabla
        model.removeRow(cbxMaterias.getSelectedIndex()); //removemos la fila de lo obtenido en el combobox
        listaMaterias.remove(materiaSeleccionada); //removemos lo obtenido de nuestro arraylist
        controller.escribirObjeto("materias.dat", listaMaterias); //el arraylist almacena su contenido en el archivo
        llenarCombo(); //se ejecuta el metodo llenar combo
        limpiar();
        btnmodMateria.setEnabled(false); //los botones modificar y eliminar estan deshabilitados 
        btnelMateria.setEnabled(false);
        
    }//GEN-LAST:event_btnelMateriaActionPerformed

    private void cbxMateriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMateriasActionPerformed
        // TODO add your handling code here:
         ClsMateria materiaSeleccionada = (ClsMateria)cbxMaterias.getSelectedItem();
        txtnMateria.setText(materiaSeleccionada.getnMateria());
        btnmodMateria.setEnabled(true);
        btnelMateria.setEnabled(true);
        btnRegMateria.setEnabled(false);
    }//GEN-LAST:event_cbxMateriasActionPerformed

    private void btnRegProfeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegProfeActionPerformed
        // TODO add your handling code here:
        System.out.println("registra");
        cont2= cont2+1; //Cada vez que damos en el boton registrar, el contador aumenta en uno
        ClsProfesor profe = new ClsProfesor( cont , txtnProfesor.getText() , txtProfesion.getText());  //creamos un objeto de clase profesor
        listaProfes.add(profe);  //añadimos ese objeto a nuestro arraylist de profesores
        controller.escribirObjeto("profes.dat" , listaProfes);  //el arraylist envia su contenido al archivo
        listaProfes = controller.extraerObjetos("profes.dat"); //el arraylist recoge el contenido del archivo
        limpiar2(); 
        llenarCombo2(); //ejecuta el metodo llenarCombo
        Object profesG [] = { profe.getId() , profe.getnProfesor(), profe.getProfesion()}; //dentro de un arreglo de profesores, asignamos lo obtenido del objeto
        DefaultTableModel model = (DefaultTableModel) tblProfes.getModel(); //asignamos un modelo a la tabla
        model.addRow(profesG);  //agregamos una fila a la tabla que contendrá lo obtenido del arreglo de profesores
    }//GEN-LAST:event_btnRegProfeActionPerformed

    private void btnmodProfeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodProfeActionPerformed
        // TODO add your handling code here:
         ClsProfesor profSeleccionado = (ClsProfesor)cbxMaterias.getSelectedItem(); //Segun lo seleccionado en el combobox
        profSeleccionado.setnProfesor(txtnProfesor.getText()); //Asignamos dichos datos en el textfield
        profSeleccionado.setProfesion(txtProfesion.getText()); 
        Object profesG [] = {profSeleccionado.getId(),profSeleccionado.getnProfesor(), profSeleccionado.getProfesion()}; //Inicializamos un arreglo de profesores con lo modificado
        DefaultTableModel model = (DefaultTableModel) tblProfes.getModel(); //Asignamos un modelo a la tabla
        model.removeRow(cbxProfes.getSelectedIndex()); //Eliminamos la fila de lo seleccionado
        listaProfes.remove(cbxProfes.getSelectedIndex()); //Eliminamos lo seleccionado del arraylist
        model.insertRow(cbxProfes.getSelectedIndex(), profesG); //Agregamos una nueva columna con lo almacenado en el arreglo de profesores
        listaProfes.add(cbxProfes.getSelectedIndex(), profSeleccionado); //agregamos al arraylist
        controller.escribirObjeto("profes.dat", listaProfes); //el arraylist envia lo obtenido al archivo
        llenarCombo2(); //se ejecuta el metodo llenarcombo2
        limpiar2();
        btnmodProfe.setEnabled(false); //los botones modificar y eliminar estan deshabilitados 
        btnelProfe.setEnabled(false);
    }//GEN-LAST:event_btnmodProfeActionPerformed

    private void btnelProfeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnelProfeActionPerformed
        // TODO add your handling code here:
          ClsProfesor profSeleccionado = (ClsProfesor)cbxProfes.getSelectedItem(); //Segun lo seleccionado en el combobox
        DefaultTableModel model = (DefaultTableModel) tblProfes.getModel(); //asignamos modelo a la tabla
        model.removeRow(cbxProfes.getSelectedIndex()); //removemos la fila de lo obtenido en el combobox
        listaProfes.remove(profSeleccionado); //removemos lo obtenido de nuestro arraylist
        controller.escribirObjeto("profes.dat", listaProfes); //el arraylist almacena su contenido en el archivo
        llenarCombo2(); //se ejecuta el metodo llenar combo2
        limpiar2();
        btnmodProfe.setEnabled(false); //los botones modificar y eliminar estan deshabilitados 
        btnelProfe.setEnabled(false);
        
    }//GEN-LAST:event_btnelProfeActionPerformed

    private void btnRegEstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegEstActionPerformed
        // TODO add your handling code here:
      
        cont3++; //Cada vez que damos en el boton registrar, el contador aumenta en uno
        ClsEstudiante est = new ClsEstudiante( cont , txtNombre.getText());  //creamos un objeto de clase materia 
        listaEsts.add(est);  //añadimos ese objeto a nuestro arraylist de materias
        controller.escribirObjeto("ests.dat" , listaMaterias);  //el arraylist envia su contenido al archivo
        listaEsts = controller.extraerObjetos("ests.dat"); //el arraylist recoge el contenido del archivo
     //   llenarCombo3();
        limpiar3(); 
         
        Object estsG [] = { est.getId() , est.getNombre()}; //dentro de un arreglo de materias, asignamos lo obtenido del objeto
        DefaultTableModel model = (DefaultTableModel) tblEsts.getModel(); //asignamos un modelo a la tabla
        model.addRow(estsG);  //agregamos una fila a la tabla que contendrá lo obtenido del arreglo de materias. 
    }//GEN-LAST:event_btnRegEstActionPerformed

    private void btnmodEstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodEstActionPerformed
        // TODO add your handling code here:
         ClsEstudiante estSelec = (ClsEstudiante)cbxEsts.getSelectedItem(); //Segun lo seleccionado en el combobox
        estSelec.setNombre(txtNombre.getText()); //Asignamos dichos datos en el textfield
       
        Object estsG [] = {estSelec.getId(),estSelec.getNombre()}; //Inicializamos un arreglo de materias con lo modificado
        DefaultTableModel model = (DefaultTableModel) tblEsts.getModel(); //Asignamos un modelo a la tabla
        model.removeRow(cbxEsts.getSelectedIndex()); //Eliminamos la fila de lo seleccionado
        listaEsts.remove(cbxEsts.getSelectedIndex()); //Eliminamos lo seleccionado del arraylist
        model.insertRow(cbxEsts.getSelectedIndex(), estsG); //Agregamos una nueva columna con lo almacenado en el arreglo de materias
        listaEsts.add(cbxEsts.getSelectedIndex(), estSelec); //agregamos al arraylist
        controller.escribirObjeto("ests.dat", listaEsts); //el arraylist envia lo obtenido al archivo
       // llenarCombo3(); //se ejecuta el metodo llenarcombo
        limpiar3();
        btnmodEst.setEnabled(false); //los botones modificar y eliminar estan deshabilitados 
        btnelEst.setEnabled(false);
    }//GEN-LAST:event_btnmodEstActionPerformed

    private void btnelEstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnelEstActionPerformed
        // TODO add your handling code here:
         ClsEstudiante estSelec = (ClsEstudiante)cbxEsts.getSelectedItem(); //Segun lo seleccionado en el combobox
        DefaultTableModel model = (DefaultTableModel) tblEsts.getModel(); //asignamos modelo a la tabla
        model.removeRow(cbxEsts.getSelectedIndex()); //removemos la fila de lo obtenido en el combobox
        listaEsts.remove(estSelec); //removemos lo obtenido de nuestro arraylist
        controller.escribirObjeto("ests.dat", listaEsts); //el arraylist almacena su contenido en el archivo
    //    llenarCombo3(); //se ejecuta el metodo llenar combo2
        limpiar3();
        btnmodEst.setEnabled(false); //los botones modificar y eliminar estan deshabilitados 
        btnelEst.setEnabled(false);
    }//GEN-LAST:event_btnelEstActionPerformed

    private void cbxEstsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxEstsActionPerformed
        // TODO add your handling code here:
        ClsEstudiante estSelec = (ClsEstudiante)cbxEsts.getSelectedItem();
        txtNombre.setText(estSelec.getNombre());
        btnmodEst.setEnabled(true);
        btnelEst.setEnabled(true);
        btnRegEst.setEnabled(false);
    }//GEN-LAST:event_cbxEstsActionPerformed

    private void cbxProfesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxProfesActionPerformed
        // TODO add your handling code here:
        ClsProfesor profSelec = (ClsProfesor)cbxProfes.getSelectedItem();
        txtnProfesor.setText(profSelec.getnProfesor());
        txtProfesion.setText(profSelec.getProfesion());
        btnmodEst.setEnabled(true);
        btnelEst.setEnabled(true);
        btnRegEst.setEnabled(false);
    }//GEN-LAST:event_cbxProfesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaRegistro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegEst;
    private javax.swing.JButton btnRegMateria;
    private javax.swing.JButton btnRegProfe;
    private javax.swing.JButton btnelEst;
    private javax.swing.JButton btnelMateria;
    private javax.swing.JButton btnelProfe;
    private javax.swing.JButton btnmodEst;
    private javax.swing.JButton btnmodMateria;
    private javax.swing.JButton btnmodProfe;
    private javax.swing.JComboBox<String> cbxEsts;
    private javax.swing.JComboBox<String> cbxMaterias;
    private javax.swing.JComboBox<String> cbxProfes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane6;
    private javax.swing.JTable tblEsts;
    private javax.swing.JTable tblMaterias;
    private javax.swing.JTable tblProfes;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtProfesion;
    private javax.swing.JTextField txtnMateria;
    private javax.swing.JTextField txtnProfesor;
    // End of variables declaration//GEN-END:variables
}
