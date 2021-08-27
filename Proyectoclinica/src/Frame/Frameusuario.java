/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import proyectoclinica.HeaderTable;
import proyectoclinica.PlaceHolder;
import proyectoclinica.persona;
import proyectoclinica.usuario;
import proyectoclinica.veterinario;
/**
 *
 * @author Male
 */

public class Frameusuario extends javax.swing.JFrame {

    /**
     * Creates new form Frameusuario
     */
      private PlaceHolder placeholder;
   // private final Class formularioEmisor;
    public Frameusuario() {
        initComponents();
       //this.formularioEmisor =component.getClass();
        this.setLocationRelativeTo(null); //Mostrar esta ventana centrado al formulario principal
       this.mostrarDatos();
        this.repintarHeaderTabla();
        this.ponerPlaceHolders(); 
        
//        this.habilitarBotonEnviarDatos();
    }
    private void ponerPlaceHolders(){
        placeholder = new PlaceHolder("Buscar por id", jTextFieldid, Color.GRAY);
    }
    
    private void repintarHeaderTabla(){
        JTableHeader jtableHeader = jTable1.getTableHeader();
        jtableHeader.setDefaultRenderer(new HeaderTable());
        jTable1.setTableHeader(jtableHeader);
    }
    
    private void fijarAnchoColumnasTabla(){
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(15);//ID
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(20);//username
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(25);//idpersonal
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(25);//nombremedico
    }
    
    private void nuevo(){
        this.limpiarTodo();
        jTextFieldid.requestFocus();
    }
     private void guardar() {
        if (this.validarCamposLlenos()){
            String username = jTextFielusername.getText();
            String password = jPassword.getText();
            int iduser = Integer.parseInt(jTextFieldid.getText());
            int idpersonal = Integer.parseInt(jTextFieldidpersonal.getText());

            usuario user = new usuario(iduser,username, password,  idpersonal);

            user.guardarusuario(jTextFieldid.getText());

          //  if (registroSatisfactorio) {
              //  JOptionPane.showMessageDialog(null, "Se guardó correctamente :)");
                this.limpiarCampos();
                this.mostrarDatos();
          //  }else
          //      JOptionPane.showMessageDialog(null, "No se pudo guardar, verifique que los datos sean correctos!");
        //}else
         //   JOptionPane.showMessageDialog(null, "Complete todos los campos");*/
    }}

 private void mostrarDatos(){
        usuario usu;
          usu = new usuario();
        usu.mostrarUsuario(jTable1);
        this.fijarAnchoColumnasTabla();
    }
    
    private void eliminar(){
        if(!jTextFieldid.getText().equals("0")){
            int res = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar este registro?");
            if (res == JOptionPane.YES_OPTION) {
                usuario usuario = new usuario();
                usuario.eliminarUsuario(jTextFieldid.getText());
                /*if (estadoEjecucion)
                    JOptionPane.showMessageDialog(null, "Se eliminó correctamente!");
                else
                    JOptionPane.showMessageDialog(null, "No se pudo eliminar, pruebe más tarde.");*/

                this.mostrarDatos();
            }
        }
    }
    
   /* private void buscarPorid(){
        persona per = new persona();
        per.mostrarDatosEnTabla(jTable1, jTextFieldid.getText());
        this.fijarAnchoColumnasTabla();
    }*/
    
    private void limpiarTodo(){
        this.limpiarCampos();
        this.limpiarTabla();
    }
    
    private void limpiarCampos(){
        jTextFieldid.setText("0");
        jTextFielusername.setText("");
        jPassword.setText("");
       // jTextFieldNombreMedico.setText("");
        jTextFieldidpersonal.setText("");
      //  jComboBoxPrivilegio.setSelectedIndex(0);
    }
    
    private void limpiarTabla(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("USERNAME");
        model.addColumn("PASSWORD");
        model.addColumn("IDPERSONAL");
        jTable1.setModel(model);
        this.fijarAnchoColumnasTabla();
    }
    
   private boolean validarCamposLlenos(){
        //if(jCheckBox1.isSelected())
    return !jTextFielusername.getText().isEmpty() 
    && !jTextFieldidpersonal.getText().isEmpty()
    && !jTextFieldid.getText().isEmpty()
    && !jPassword.getText().isEmpty();
       /* else
     return !jTextFieldUsername.getText().isEmpty() 
    && !jTextFieldIdMedico.getText().isEmpty() 
    && jComboBoxPrivilegio.getSelectedIndex()!=0;*/
    }
    
    private void buscarusuarioporid(){
        usuario user = new usuario();
        user.mostrarDatosEnTablaid(jTable1, Integer.parseInt(jTextFieldid.getText()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldid = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldidpersonal = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFielusername = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPassword = new javax.swing.JPasswordField();
        jButton6 = new javax.swing.JButton();
        jLabelpasword = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 48)); // NOI18N
        jLabel2.setText("USUARIO");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 340, 50));

        jLabel3.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 24)); // NOI18N
        jLabel3.setText("IDUSUARIO");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));
        getContentPane().add(jTextFieldid, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 140, 30));

        jLabel4.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 24)); // NOI18N
        jLabel4.setText("IDPERSONAL");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));
        getContentPane().add(jTextFieldidpersonal, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 140, 30));

        jLabel5.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 24)); // NOI18N
        jLabel5.setText("USERNAME");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 130, 20));

        jLabel6.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 36)); // NOI18N
        jLabel6.setText("PASSWORD");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 90, -1, -1));

        jTextFielusername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFielusernameActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFielusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 140, 30));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID USUARIO", "USER NAME", "PASSWORD", "ID PERSONAL"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable1MouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 570, 160));

        jButton1.setText("NUEVO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 440, 120, 40));

        jButton2.setText("GUARDAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 440, 110, 40));

        jButton3.setText("MOSTRAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 440, 130, 40));

        jButton4.setText("ELIMINAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 440, 110, 40));

        jButton5.setText("SALIR");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, 90, 30));

        jPassword.setText("jPasswordField1");
        jPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordActionPerformed(evt);
            }
        });
        getContentPane().add(jPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 140, 180, 40));

        jButton6.setText("BUSCAR");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, 70, 30));

        jLabelpasword.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 24)); // NOI18N
        jLabelpasword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fonof usuarioo.png"))); // NOI18N
        getContentPane().add(jLabelpasword, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -1, 630, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.nuevo();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.guardar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.mostrarDatos();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.eliminar();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        // TODO add your handling code here:
        if( jTable1.getSelectedRowCount()>0 ){
          jTextFieldid.setText( jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString().trim());
          jTextFielusername.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString().trim());
          jPassword.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString().trim());
          jTextFieldidpersonal.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString().trim());
            
       
            
        }
        
    }//GEN-LAST:event_jTable1MouseReleased

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        this.buscarusuarioporid();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTextFielusernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFielusernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFielusernameActionPerformed

    private void jPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordActionPerformed
 /* private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {                                      
        if( jTable1.getSelectedRowCount()>0 ){
          jTextFieldid.setText( jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString().trim());
          jTextFielusername.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString().trim());
          //jPassword.setText(jTable1¡.getValueAt(jTablet1.getSelectedRow(), 2).toString().trim());
          jTextFieldidpersonal.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString().trim());
            
       
            
        }
    }*/
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
            java.util.logging.Logger.getLogger(Frameusuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frameusuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frameusuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frameusuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frameusuario().setVisible(true);
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelpasword;
    private javax.swing.JPasswordField jPassword;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldid;
    private javax.swing.JTextField jTextFieldidpersonal;
    private javax.swing.JTextField jTextFielusername;
    // End of variables declaration//GEN-END:variables
}
