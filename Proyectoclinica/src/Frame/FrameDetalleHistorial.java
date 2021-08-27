/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import javax.swing.JOptionPane;
import javax.swing.table.JTableHeader;
import proyectoclinica.Conexion;
import proyectoclinica.HeaderTable;
import proyectoclinica.historial;

/**
 *
 * @author Male
 */
public class FrameDetalleHistorial extends javax.swing.JFrame {

    /**
     * Creates new form FrameHistorial
     */
   historial dethis;
    Conexion cnx= new Conexion();
    public FrameDetalleHistorial() {
        dethis= new historial();
        
        
        initComponents();
        this.repintarHeaderTabla();
    }
    public void Limpiar ()
    {            
       N_HIST.setText("");
        CIPRO.setText("");
        fechahist.setText("");
        DESCRIPHIST.setText("");
         
    }
     private void repintarHeaderTabla(){
        JTableHeader jtableHeader = tabledetallehist.getTableHeader();
        jtableHeader.setDefaultRenderer(new HeaderTable());
        tabledetallehist.setTableHeader(jtableHeader);}       

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BUSCARHIST = new javax.swing.JButton();
        FECHAHIST = new javax.swing.JScrollPane();
        fechahist = new javax.swing.JTextPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        CIPRO = new javax.swing.JTextPane();
        jLabel10 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        N_HIST = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        DESCRIPHIST = new javax.swing.JTextArea();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabledetallehist = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BUSCARHIST.setText("BUSCAR");
        BUSCARHIST.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BUSCARHISTActionPerformed(evt);
            }
        });
        getContentPane().add(BUSCARHIST, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 120, 90, 30));

        FECHAHIST.setViewportView(fechahist);

        getContentPane().add(FECHAHIST, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 70, 150, 30));

        jScrollPane5.setViewportView(CIPRO);

        getContentPane().add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 70, 180, 30));

        jLabel10.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 24)); // NOI18N
        jLabel10.setText("CI PROPIETARIO:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, -1, 30));

        jButton6.setText("SELECCIONAR");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 150, 150, 30));

        jScrollPane3.setViewportView(N_HIST);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 40, -1));

        DESCRIPHIST.setColumns(20);
        DESCRIPHIST.setRows(5);
        jScrollPane2.setViewportView(DESCRIPHIST);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 300, 170));

        jButton5.setText("SALIR");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 20, 80, 30));

        tabledetallehist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabledetallehist);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 190, 810, 380));

        jButton3.setText("MODIFICAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 110, 30));

        jButton2.setText("MOSTRAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 440, 90, 30));

        jLabel9.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 24)); // NOI18N
        jLabel9.setText("DESCRIPCION");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 180, 20));

        jLabel7.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 24)); // NOI18N
        jLabel7.setText("FECHA/HISTORIAL");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 70, -1, -1));

        jLabel3.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 24)); // NOI18N
        jLabel3.setText("NRO HISTORIAL");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, 20));

        jLabel2.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 48)); // NOI18N
        jLabel2.setText("HISTORIAL CLINICO");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/historial2.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1180, 590));

        pack();
    }// </editor-fold>//GEN-END:initComponents
        


    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
  dethis.Actualizarhist(Integer.parseInt(N_HIST.getText()), DESCRIPHIST.getText(),fechahist.getText());
      dethis.Buscardetahis(tabledetallehist, "");
      JOptionPane.showMessageDialog(rootPane, "Los datos se han actualizado con exito");  
Limpiar();      // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
 int fmod = tabledetallehist.getSelectedRow();
       if (fmod >= 0) {
           N_HIST.setText(tabledetallehist.getValueAt(fmod, 0).toString());
           fechahist.setText(tabledetallehist.getValueAt(fmod, 1).toString());
           DESCRIPHIST.setText(tabledetallehist.getValueAt(fmod, 2).toString());
          
            
        } else {
            JOptionPane.showMessageDialog(this, "No ha seleccionado ");
        }         // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
dethis.Buscardetahis(tabledetallehist, "");        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void BUSCARHISTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BUSCARHISTActionPerformed
        dethis.BuscarHISTCI(tabledetallehist,CIPRO.getText());
    }//GEN-LAST:event_BUSCARHISTActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(FrameHistorial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameHistorial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameHistorial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameHistorial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameDetalleHistorial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BUSCARHIST;
    private javax.swing.JTextPane CIPRO;
    private javax.swing.JTextArea DESCRIPHIST;
    private javax.swing.JScrollPane FECHAHIST;
    private javax.swing.JTextPane N_HIST;
    private javax.swing.JTextPane fechahist;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable tabledetallehist;
    // End of variables declaration//GEN-END:variables
}
