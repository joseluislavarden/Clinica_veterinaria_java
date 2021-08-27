/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import proyectoclinica.PlaceHolder;
import proyectoclinica.ModeloMostrarDatos;
import proyectoclinica.HeaderTable;
import proyectoclinica.veterinario;


/**
 *
 * @author Male
 */
public class Frameveterinario extends javax.swing.JFrame {

    /**
     * Creates new form Framepersona
     */
    private PlaceHolder placeholder;
    public Frameveterinario() {
        
        initComponents();
        this.setLocationRelativeTo(null); //Mostrar venta centrado al centro del formulario principal
        this.mostrarDatos();
        this.repintarHeaderTabla();
        this.ponerPlaceHolders();    
    }
    private void ponerPlaceHolders(){
        placeholder = new PlaceHolder("Buscar por idpersonal", jTextPaneid, Color.GRAY);
    }
    
    private void repintarHeaderTabla(){
        JTableHeader jtableHeader = jTabletabla.getTableHeader();
        jtableHeader.setDefaultRenderer(new HeaderTable());
        jTabletabla.setTableHeader(jtableHeader);
    }
       private void fijarAnchoColumnasTabla(){
        jTabletabla.getColumnModel().getColumn(0).setPreferredWidth(30);//id
        jTabletabla.getColumnModel().getColumn(1).setPreferredWidth(120);//nombre
        jTabletabla.getColumnModel().getColumn(2).setPreferredWidth(120);//apellido
        jTabletabla.getColumnModel().getColumn(3).setPreferredWidth(30);//CI
        jTabletabla.getColumnModel().getColumn(4).setPreferredWidth(25);//sexo
        jTabletabla.getColumnModel().getColumn(5).setPreferredWidth(30);//celular
        jTabletabla.getColumnModel().getColumn(6).setPreferredWidth(100);//direccion
    }
    

    //Funciones y procedimientos
    private void nuevo(){
        this.limpiarTodo();
        jTextPaneid.requestFocus();
    }
    
    private void guardarveterinario() {
        if (this.validarCamposLlenos()){
            int idpersona = Integer.parseInt(jTextPaneid.getText());
            String nombre = jTextPanenombres.getText();
            String apellido = jTextPaneapellidos.getText();
            int ci= Integer.parseInt(jTextPaneci.getText());
            String sexo = jComboBox1sexo.getSelectedItem().toString().substring(0, 1);
            int celular = Integer.parseInt(jTextpanecelular.getText());
            String direccion = jTextPanedireccion.getText();
            String experiencia = jTextPaneexperiencia.getText();
            String trabajosant = jTextPanetrabajosante.getText();

            veterinario vet = new veterinario(idpersona, nombre, apellido, ci, sexo, celular, direccion, experiencia, trabajosant);
            

            vet.guardarveterinario();
            /*boolean registroSatisfactorio = vet.guardarveterinario();

            if (registroSatisfactorio) {
                JOptionPane.showMessageDialog(null, "Se guardó correctamente :)");
                this.limpiarCampos();
                this.mostrarDatos();
            }else
                JOptionPane.showMessageDialog(null, "No se pudo guardar, verifique que los datos sean correctos!");
        }else
            JOptionPane.showMessageDialog(null, "Complete todos los campos");
    }*/}}

    private void mostrarDatos() {
        veterinario vet= new veterinario();
        vet.mostrarDatosEnTabla(jTabletabla, "");
        this.fijarAnchoColumnasTabla();
    }
    private void Eliminarveterinario(){
        if(!jTextPaneid.getText().isEmpty()){
            int res = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar este registro?");
            if (res == JOptionPane.YES_OPTION) {
                veterinario vet = new veterinario();
                vet.Eliminarveterinario(Integer.parseInt(jTextPaneid.getText()));
                /*boolean estadoEjecucion = vet.Eliminarveterinario(Integer.parseInt(jTextPaneid.getText()));
                if (estadoEjecucion)
                    JOptionPane.showMessageDialog(null, "Se eliminó correctamente!");
                else
                    JOptionPane.showMessageDialog(null, "No se pudo eliminar, pruebe más tarde.");

                this.mostrarDatos();*/
            }
        }
    }
    
    private void buscarPorid(){
        veterinario vet = new veterinario();
        vet.mostrarDatosEnTabla(jTabletabla, jTextPaneid.getText());
        this.fijarAnchoColumnasTabla();
    }
    
    private void limpiarTodo(){
        this.limpiarCampos();
        this.limpiarTabla();
    }
    
    private void limpiarCampos(){
        jTextPaneid.setText("");
        jTextPanenombres.setText("");
        jTextPaneapellidos.setText("");
        jTextPaneci.setText("");
        jComboBox1sexo.setSelectedIndex(0);
        jTextpanecelular.setText("");
        jTextPanedireccion.setText("");
        jTextPaneexperiencia.setText("");
        jTextPanetrabajosante.setText("");
      //  jDateChooserFechaNac.setDate(new Date());   
    }
    
    private void limpiarTabla(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("idpersona");
        model.addColumn("ci");
        model.addColumn("nombres");
        model.addColumn("apellidos");
        model.addColumn("sexo");
        model.addColumn("celular");
        model.addColumn("direccion");
        model.addColumn("experiencia");
        model.addColumn("trabajos anteriores");
        jTabletabla.setModel(model);
        this.fijarAnchoColumnasTabla();
    }
    
    private boolean validarCamposLlenos(){
       /* if( !jTextFieldEmail.getText().isEmpty() )
            if( !this.esEmailValido() )
                JOptionPane.showMessageDialog(null, "Verifique que el correo sea válido!");*/
        
        return (!jTextPaneid.getText().isEmpty() 
                && !jTextPanenombres.getText().isEmpty()
                && !jTextPaneapellidos.getText().isEmpty()
                 && !jTextPaneci.getText().isEmpty()
               // && this.esEmailValido()
                && !jTextpanecelular.getText().isEmpty()
                && !jTextPanedireccion.getText().isEmpty()
                && !jTextPaneexperiencia.getText().isEmpty()
                && !jTextPanetrabajosante.getText().isEmpty()
               // && !this.esJDatechooserVacio()
                && jComboBox1sexo.getSelectedIndex() != 0);
    }

  /*  private boolean esJDatechooserVacio(){
        
        try {
            jDateChooserFechaNac.getDate().toString();
            return false;
        }catch(Exception e){
            return true;
        }
    }*/
    
    /*private boolean esEmailValido(){
        short arroba = 0;
        short punto = 0;
        String val = jTextFieldEmail.getText();
        for (int i = 0; i < val.length(); i++) {
            if(val.charAt(i) == '@')
                arroba++;
            if(val.charAt(i) == '.')
                punto++;
        }
        return arroba==1 && punto>0;
    }*/
                                                                     

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTextPanetrabajosante = new javax.swing.JTextPane();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTextPaneexperiencia = new javax.swing.JTextPane();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextPanedireccion = new javax.swing.JTextPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextpanecelular = new javax.swing.JTextPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextPaneci = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextPaneapellidos = new javax.swing.JTextPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabletabla = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPaneid = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextPanenombres = new javax.swing.JTextPane();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jComboBox1sexo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton5.setText("SALIR");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 540, 90, 40));

        jButton4.setText("ELIMINAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 470, 120, 40));

        jButton3.setText("MOSTRAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 470, 120, 40));

        jButton2.setText("GUADAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 470, 120, 40));

        jButton1.setText("NUEVO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 470, 100, 40));

        jScrollPane9.setViewportView(jTextPanetrabajosante);

        getContentPane().add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 450, 210, 100));

        jScrollPane8.setViewportView(jTextPaneexperiencia);

        getContentPane().add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 390, 180, 50));

        jScrollPane7.setViewportView(jTextPanedireccion);

        getContentPane().add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 340, 180, 30));

        jScrollPane6.setViewportView(jTextpanecelular);

        getContentPane().add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 280, 140, 30));

        jScrollPane5.setViewportView(jTextPaneci);

        getContentPane().add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, 140, 30));

        jScrollPane4.setViewportView(jTextPaneapellidos);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, 140, 30));

        jTabletabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "id perosnal", "ci", "nombre", "apellido", "sexo", "celular", "direccion", "experiencia", "trabajos anteriores"
            }
        ));
        jTabletabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTabletablaMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTabletabla);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 110, 750, 290));

        jScrollPane2.setViewportView(jTextPaneid);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, 140, 30));

        jScrollPane3.setViewportView(jTextPanenombres);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 140, 30));

        jLabel11.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 24)); // NOI18N
        jLabel11.setText("TRABAJOS ANTERIORES");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 260, 60));

        jLabel10.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 24)); // NOI18N
        jLabel10.setText("EXPERIENCIA");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, -1, -1));

        jLabel9.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 24)); // NOI18N
        jLabel9.setText("DIRECCION");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 140, 20));

        jLabel8.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 24)); // NOI18N
        jLabel8.setText("SEXO");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 70, -1));

        jLabel7.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 24)); // NOI18N
        jLabel7.setText("CELULAR");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 110, 20));

        jLabel6.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 24)); // NOI18N
        jLabel6.setText("CI");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 30, -1));

        jLabel5.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 24)); // NOI18N
        jLabel5.setText("ID PERSONAL");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 150, -1));

        jLabel4.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 24)); // NOI18N
        jLabel4.setText("APELLIDOS");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 130, 20));

        jLabel2.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 60)); // NOI18N
        jLabel2.setText("VETERINARIO");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 30, 410, 40));

        jLabel3.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 24)); // NOI18N
        jLabel3.setText("NOMBRES");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 170, 20));

        jButton6.setText("BUSCAR");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 40, 120, 40));

        jComboBox1sexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "seleccione:", "Femenino", "Masculino" }));
        getContentPane().add(jComboBox1sexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, 130, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/1200 xd.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 1200, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.guardarveterinario();
        this.mostrarDatos();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.mostrarDatos();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.Eliminarveterinario();
        this.mostrarDatos();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.nuevo();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        this.buscarPorid();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTabletablaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabletablaMouseReleased
        if( jTabletabla.getSelectedRowCount()>0 ){
           // int idpersona = Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
           // veterinario vet = new veterinario();
            //vet.buscarParaEdicion(idpersona);
            
            jTextPaneid.setText( jTabletabla.getValueAt(jTabletabla.getSelectedRow(), 0).toString().trim());
            jTextPaneci.setText(jTabletabla.getValueAt(jTabletabla.getSelectedRow(), 1).toString().trim());
            jTextPanenombres.setText(jTabletabla.getValueAt(jTabletabla.getSelectedRow(), 2).toString().trim());
            jTextPaneapellidos.setText(jTabletabla.getValueAt(jTabletabla.getSelectedRow(), 3).toString().trim());
            if(jTabletabla.getValueAt(jTabletabla.getSelectedRow(), 4).toString().trim().equals("F")) jComboBox1sexo.setSelectedIndex(1); else jComboBox1sexo.setSelectedIndex(2);
            jTextpanecelular.setText(jTabletabla.getValueAt(jTabletabla.getSelectedRow(), 5).toString().trim());
            jTextPanedireccion.setText(jTabletabla.getValueAt(jTabletabla.getSelectedRow(), 6).toString().trim());
            jTextPaneexperiencia.setText(jTabletabla.getValueAt(jTabletabla.getSelectedRow(), 7).toString().trim());
            jTextPanetrabajosante.setText(jTabletabla.getValueAt(jTabletabla.getSelectedRow(), 8).toString().trim());
            //jDateChooserFechaNac.setDate(new Date(med.getFecha_nac().replace('-', '/')));
            
            //jTextFieldCI.setEditable(false);
        }
    }//GEN-LAST:event_jTabletablaMouseReleased

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
            java.util.logging.Logger.getLogger(Frameveterinario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frameveterinario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frameveterinario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frameveterinario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frameveterinario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1sexo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable jTabletabla;
    private javax.swing.JTextPane jTextPaneapellidos;
    private javax.swing.JTextPane jTextPaneci;
    private javax.swing.JTextPane jTextPanedireccion;
    private javax.swing.JTextPane jTextPaneexperiencia;
    private javax.swing.JTextPane jTextPaneid;
    private javax.swing.JTextPane jTextPanenombres;
    private javax.swing.JTextPane jTextPanetrabajosante;
    private javax.swing.JTextPane jTextpanecelular;
    // End of variables declaration//GEN-END:variables
}
