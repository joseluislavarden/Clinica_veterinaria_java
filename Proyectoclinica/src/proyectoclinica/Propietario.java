/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoclinica;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hp
 */

public class Propietario {
    private int cipropietario;
    private String nombrepro;
    private String apellidopro;
    private String celularpro;
    private String correo;
    private String direccionpro;
    DefaultTableModel model;
    Conexion cnx=new Conexion();
 

    
    public Propietario(int cipro , String nombpro, String apellpro, String celpro,String procorreo, String dirpro) {
        
        this.cipropietario= cipro;
        this.nombrepro = nombpro;
        this.apellidopro= apellpro;
        this.celularpro=celpro;
        this.correo=procorreo;
        this.direccionpro=dirpro;
      
    }
     public Propietario() {
        this.cipropietario = 0;
        this.nombrepro = "";
        this.apellidopro = "";
        this.celularpro = "";
        this.correo = "";
        this.direccionpro = "";
        

 
        
    }

    public int getCipropietario() {
        return cipropietario;
    }

    public void setCipropietario(int cipropietario) {
        this.cipropietario = cipropietario;
    }

    public String getNombrepro() {
        return nombrepro;
    }

    public void setNombrepro(String nombrepro) {
        this.nombrepro = nombrepro;
    }

    public String getApellidopro() {
        return apellidopro;
    }

    public void setApellidopro(String apellidopro) {
        this.apellidopro = apellidopro;
    }

    public String getCelularpro() {
        return celularpro;
    }

    public void setCelularpro(String celularpro) {
        this.celularpro = celularpro;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccionpro() {
        return direccionpro;
    }

    public void setDireccionpro(String direccionpro) {
        this.direccionpro = direccionpro;
    }

    public void Insertar(int ci,String nombre, String apellido, String cel, String direccion,String corr){
     
      this.setCipropietario(ci);
      this.setNombrepro(nombre);
      this.setApellidopro(apellido);
      this.setCelularpro(cel);
      this.setCorreo(corr);
      this.setDireccionpro(direccion);
   
      cnx.EjecutarComando("insert into propietario values("+cipropietario+",'"+nombrepro+"','"+apellidopro+"','"+celularpro+"','"+correo+"','"+direccionpro+"');");
     
   }  
    
   public void Eliminar(int cipro,String nombre,String apellido, String cel, String dir,String corr)
   {
      this.setCipropietario(cipro);
      this.setNombrepro(nombre);
      this.setApellidopro(apellido);
      this.setCelularpro(cel);
      this.setCorreo(corr);    
      this.setDireccionpro(dir);
      
      
      cnx.EjecutarComando("delete from propietario where ci_propietario="+cipropietario+";");
     
   }
   
   public void Actualizar(int  ci,String nombre, String apellido,  String cel, String dir,String corr)
    {
   
      this.setCipropietario(ci);
      this.setNombrepro(nombre);
      this.setApellidopro(apellido);
      this.setCelularpro(cel);
       this.setCorreo(corr);
      this.setDireccionpro(dir);
     
      cnx.EjecutarComando("update propietario set ci_propietario="+cipropietario+",nombre='"+nombrepro+"',apellido='"+apellidopro+"',celular='"+celularpro+"',correo='"+correo+"',direccion='"+direccionpro+"' where ci_propietario="+cipropietario+";");
    }

    public void Buscar (JTable pro,String Valor)
    {
        try {
         //   u.IdUsuario,c.CIPersonal,c.Nombre,c.Apellido,c.FechaNac,c.FechaIng,c.Celular,u.Contraseña
            String [] titulos = {"CARNET","NOMBRE","APELLIDO","CELULAR","CORREO","DIRECCION"};
            String[] Registros = new String[15];
            model = new DefaultTableModel(null, titulos);
            ResultSet rs=cnx.EjecutarConsulta("SELECT ci_propietario,nombre,apellido,celular,correo,direccion FROM propietario ; ");
            ResultSetMetaData datos = rs.getMetaData();
            int nc=datos.getColumnCount();
            int i=0;
            int e=0;
            while (rs.next()) {
                Object f []= new Object [nc];
                for(i=0;i<nc;i++){
                    f[i]=rs.getObject(i+1);          
                }
                model.addRow(f);
            }
            pro.setModel(model);
          } catch (SQLException ex)
            {
              Logger.getLogger(Propietario.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    /*public void Buscaridpro (JTable ani,String cipro)
    {
        try {
         //   u.IdUsuario,c.CIPersonal,c.Nombre,c.Apellido,c.FechaNac,c.FechaIng,c.Celular,u.Contraseña
            String [] titulos = {"ID  PROPIETARIO","CI","NOMBRE","APELLIDO","CELULAR","DIRECCION"};
            String[] Registros = new String[15];
            model = new DefaultTableModel(null, titulos);
            ResultSet rs=cnx.EjecutarConsulta("SELECT *from propietario where CIPRO="+cipro+"; ");
            ResultSetMetaData datos = rs.getMetaData();
            int nc=datos.getColumnCount();
            int i=0;
            int e=0;
            while (rs.next()) {
                Object f []= new Object [nc];
                for(i=0;i<nc;i++){
                    f[i]=rs.getObject(i+1);          
                }
                model.addRow(f);
            }
            ani.setModel(model);
          } catch (SQLException ex)
            {
              Logger.getLogger(Propietario.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    public void buscarPROPIETARIOPorid(JTextField jtextfield,String cipro){
        try {
            String consulta = "SELECT p.cipro,p.idpropietario,p.nombrepro FROM propietario p WHERE p.cipro='"+cipro+"';";
            ResultSet rs = cnx.EjecutarConsulta(consulta);
            if( rs.next() )
                jtextfield.setText(rs.getString("idpropietario"));
            else
                JOptionPane.showMessageDialog(null, "No existe el propietario con id: " + cipro);
        } catch (SQLException ex) {
            System.out.println("Error al buscar propietario!\n" + ex.getMessage());
        }
    }
      public void buscarPROPIETARIOnombre(JTextField jtextfield,String cipro){
        try {
            String consulta = "SELECT p.cipro,p.idpropietario,p.nombrepro FROM propietario p WHERE p.cipro='"+cipro+"';";
            ResultSet rs = cnx.EjecutarConsulta(consulta);
            if( rs.next() )
                jtextfield.setText(rs.getString("nombrepro"));
            else
                JOptionPane.showMessageDialog(null, "No existe el propietario con id: " + cipro);
        } catch (SQLException ex) {
            System.out.println("Error al buscar propietario!\n" + ex.getMessage());
        }
    }
      
       public void buscarNumeroHistorial(JTextField jtextfield,String cipro){
        try {
            String consulta = "SELECT p.cipro,p.idpropietario,p.nombrepro,his.nrohistorial FROM propietario p, animal an, historialclinico his WHERE p.idpropietario=an.idpropietario and an.idanimal=his.idanimal and p.cipro='"+cipro+"';";
            ResultSet rs = cnx.EjecutarConsulta(consulta);
            if( rs.next() )
                jtextfield.setText(rs.getString("nrohistorial"));
            else
                JOptionPane.showMessageDialog(null, "No existe el historial con id: " + cipro);
        } catch (SQLException ex) {
            System.out.println("Error al buscar historial!\n" + ex.getMessage());
        }
    }
*/
  

   
         
    public String Pci ()
    {
        return "SELECT max(perci) from persona";
    }
     public  String verCI()
    {
        return "select CI from cliente;";
    }
   
 
    
    
}

