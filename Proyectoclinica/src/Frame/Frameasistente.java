/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

/**
 *
 * @author Male
 */
import java.awt.Color;
import proyectoclinica.PlaceHolder;
import proyectoclinica.ModeloMostrarDatos;
import proyectoclinica.HeaderTable;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import proyectoclinica.asistente;
public class Frameasistente extends javax.swing.JFrame {

    /**
     * Creates new form Frameasistente
     */
    
    public Frameasistente() {
        initComponents();
        this.setLocationRelativeTo(null); //Mostrar venta centrado al centro del formulario principal
        this.mostrarDatos();
        this.repintarHeaderTabla();
        this.ponerPlaceHolders(); 

    }
     private void ponerPlaceHolders(){
        PlaceHolder placeholder = new PlaceHolder("Buscar por idpersonal", jTextFieldid, Color.GRAY);
    }
      private void repintarHeaderTabla(){
        JTableHeader jtableHeader = jTable1.getTableHeader();
        jtableHeader.setDefaultRenderer(new HeaderTable());
        jTable1.setTableHeader(jtableHeader);
    }
     private void fijarAnchoColumnasTabla(){
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(30);//id
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(120);//nombre
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(120);//apellido
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(30);//CI
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(25);//sexo
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(30);//celular
        jTable1.getColumnModel().getColumn(6).setPreferredWidth(100);//direccion
    }
    private void nuevo(){
        this.limpiarTodo();
        jTextFieldid.requestFocus();
    }
     private void limpiarCampos(){
        jTextFieldid.setText("");
        jTextFieldnombre.setText("");
        jTextFieldapellidos.setText("");
        jTextFieldci.setText("");
        jComboBoxsexo.setSelectedIndex(0);
        jTextFieldcelular.setText("");
        jTextFielddireccion.setText("");
      //  jDateChooserFechaNac.setDate(new Date());   
    }
     private void mostrarDatos() {
        asistente vet= new asistente();
        vet.mostrarDatosEnTabla(jTable1, "");
        this.fijarAnchoColumnasTabla();
    }
     
    private void limpiarTodo(){
    this.limpiarCampos();
    this.limpiarTabla();
    }
      private void limpiarTabla(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("CI");
        model.addColumn("NOMBRES");
        model.addColumn("APELLIDOS");
        model.addColumn("SEXO");
        model.addColumn("CELULAR");
        model.addColumn("DIRECCION");
        jTable1.setModel(model);
        this.fijarAnchoColumnasTabla();
    }
        private boolean validarCamposLlenos(){
       /* if( !jTextFieldEmail.getText().isEmpty() )
            if( !this.esEmailValido() )
                JOptionPane.showMessageDialog(null, "Verifique que el correo sea válido!");*/
        
        return (!jTextFieldid.getText().isEmpty() 
                && !jTextFieldnombre.getText().isEmpty()
                && !jTextFieldapellidos.getText().isEmpty()
                 && !jTextFieldci.getText().isEmpty()
               // && this.esEmailValido()
                && !jTextFieldcelular.getText().isEmpty()
                && !jTextFielddireccion.getText().isEmpty()
              
               // && !this.esJDatechooserVacio()
                && jComboBoxsexo.getSelectedIndex() != 0);
    }
         private void buscarPorid(){
        asistente as = new asistente();
        as.buscarasistentePorid(jTextFieldid, ERROR);
        as.mostrarDatosEnTabla(jTable1, jTextFieldid.getText());
        this.fijarAnchoColumnasTabla();
    }
      private void Eliminarasistente(){
        if(!jTextFieldid.getText().isEmpty()){
            int res = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar este registro?");
            if (res == JOptionPane.YES_OPTION) {
                asistente as = new asistente();
                as.Eliminarasistente(Integer.parseInt(jTextFieldid.getText()));
                /*boolean estadoEjecucion = vet.Eliminarveterinario(Integer.parseInt(jTextPaneid.getText()));
                if (estadoEjecucion)
                    JOptionPane.showMessageDialog(null, "Se eliminó correctamente!");
                else
                    JOptionPane.showMessageDialog(null, "No se pudo eliminar, pruebe más tarde.");

                this.mostrarDatos();*/
            }
        }
    } 
      private void guardarasistente() {
        if (this.validarCamposLlenos()){
            int idpersona = Integer.parseInt(jTextFieldid.getText());
            String nombre = jTextFieldnombre.getText();
            String apellido = jTextFieldapellidos.getText();
            int ci= Integer.parseInt(jTextFieldci.getText());
            String sexo = jComboBoxsexo.getSelectedItem().toString().substring(0, 1);
            int celular = Integer.parseInt(jTextFieldcelular.getText());
            String direccion = jTextFielddireccion.getText();
            asistente as = new asistente(idpersona, nombre, apellido, ci, sexo, celular, direccion);
            

            as.guardarasistente();
        }}
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldid = new javax.swing.JTextField();
        jTextFieldnombre = new javax.swing.JTextField();
        jTextFieldapellidos = new javax.swing.JTextField();
        jTextFieldci = new javax.swing.JTextField();
        jTextFieldcelular = new javax.swing.JTextField();
        jTextFielddireccion = new javax.swing.JTextField();
        jComboBoxsexo = new javax.swing.JComboBox<>();
        jButton6 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID ", "CI", "NOMBRES", "APELLIDOS", "SEXO", "CELULAR", "DIRECCION"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable1MouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 170, 790, 240));

        jButton1.setText("NUEVO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 470, 140, 40));

        jButton2.setText("GUARDAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 470, 130, 40));

        jButton3.setText("MOSTRAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 470, 130, 40));

        jButton4.setText("ELIMINAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 470, 130, 40));

        jButton5.setText("SALIR");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 470, 130, 40));

        jLabel9.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 60)); // NOI18N
        jLabel9.setText("ASISTENTE");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 60, 430, 60));

        jLabel8.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 24)); // NOI18N
        jLabel8.setText("DIRECCION");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 130, 30));

        jLabel7.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 24)); // NOI18N
        jLabel7.setText("CELULAR");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, -1, -1));

        jLabel6.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 24)); // NOI18N
        jLabel6.setText("SEXO");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 90, -1));

        jLabel5.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 24)); // NOI18N
        jLabel5.setText("CI");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 60, -1));

        jLabel4.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 24)); // NOI18N
        jLabel4.setText("APELLIDOS");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 130, -1));

        jLabel3.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 24)); // NOI18N
        jLabel3.setText("ID PERSONAL");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 180, 40));

        jLabel2.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 24)); // NOI18N
        jLabel2.setText("NOMBRES");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 140, 30));

        jTextFieldid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldidActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldid, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 130, 30));

        jTextFieldnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldnombreActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 130, 30));
        getContentPane().add(jTextFieldapellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, 130, 30));
        getContentPane().add(jTextFieldci, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, 120, 30));
        getContentPane().add(jTextFieldcelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, 130, 30));
        getContentPane().add(jTextFielddireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 410, 130, 30));

        jComboBoxsexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "seleccione:", "Femenino", "Masculino" }));
        getContentPane().add(jComboBoxsexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, 120, 30));

        jButton6.setText("BUSCAR");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 100, 90, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/1200 xd.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.nuevo();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTextFieldidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldidActionPerformed

    private void jTextFieldnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldnombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldnombreActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.guardarasistente();
        this.mostrarDatos();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.mostrarDatos();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.Eliminarasistente();
        this.mostrarDatos();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        this.buscarPorid();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseReleased

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
            java.util.logging.Logger.getLogger(Frameasistente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frameasistente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frameasistente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frameasistente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frameasistente().setVisible(true);
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
    private javax.swing.JComboBox<String> jComboBoxsexo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldapellidos;
    private javax.swing.JTextField jTextFieldcelular;
    private javax.swing.JTextField jTextFieldci;
    private javax.swing.JTextField jTextFielddireccion;
    private javax.swing.JTextField jTextFieldid;
    private javax.swing.JTextField jTextFieldnombre;
    // End of variables declaration//GEN-END:variables
}
