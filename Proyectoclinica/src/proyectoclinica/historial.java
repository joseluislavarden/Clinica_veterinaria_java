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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hp
 */

public class historial {
    private int nrohistorial;
    private String descripcionhistorial;
    private String fechahistorial;
    private int idanimal;
    DefaultTableModel model;
    Conexion cnx=new Conexion();


    
    public historial(int nhis, String deshit, String fechahist, int idan) {
        this.nrohistorial = nhis;
        this.descripcionhistorial = deshit;
        this.fechahistorial = fechahist;
        this.idanimal= idan;
   
      
    }
     public historial() {
        this.nrohistorial = 0;
        this.descripcionhistorial = "";
        this.fechahistorial = "";
        this.idanimal = 0;
      
         
    }

    public int getNrohistorial() {
        return nrohistorial;
    }

    public void setNrohistorial(int nrohistorial) {
        this.nrohistorial = nrohistorial;
    }

    public String getDescripcionhistorial() {
        return descripcionhistorial;
    }

    public void setDescripcionhistorial(String descripcionhistorial) {
        this.descripcionhistorial = descripcionhistorial;
    }

    public String getFechahistorial() {
        return fechahistorial;
    }

    public void setFechahistorial(String fechahistorial) {
        this.fechahistorial = fechahistorial;
    }

    public int getIdanimal() {
        return idanimal;
    }

    public void setIdanimal(int idanimal) {
        this.idanimal = idanimal;
    }
  

 

      
    public void Insertar(int nrhist, String deshist, String fechahist, int idan){
  
      this.setNrohistorial(nrhist);
      this.setDescripcionhistorial(deshist);
      this.setFechahistorial(fechahist);
      this.setIdanimal(idan);
      cnx.EjecutarComando("insert into historico_animal values("+nrohistorial+",'"+descripcionhistorial+"','"+fechahistorial+"',"+idanimal+");");
     
   }  
    
   public void Eliminar(int nrhist, String deshist, String fechahist, int idan)
   {
      this.setNrohistorial(nrhist);
      this.setDescripcionhistorial(deshist);
      this.setFechahistorial(fechahist);
      this.setIdanimal(idan);
     
      
      cnx.EjecutarComando("delete from historico_animal where nro_historial="+nrohistorial+";");
     
   }
   
   public void Actualizarhist(int nrhis, String deshist, String fechahist,int idan)
    {
   
     this.setNrohistorial(nrhis);
      this.setDescripcionhistorial(deshist);
      this.setFechahistorial(fechahist);
      this.setIdanimal(idan);
   
      cnx.EjecutarComando("update historico_animal set nro_historial="+nrohistorial +",descripcion='"+descripcionhistorial+"',fecha='"+fechahistorial+"',id_animal="+idanimal+" where nro_historial="+nrohistorial+";");
    }

    /*public void BuscarHISTCI (JTable hist,String Valor)
    {
        try {
         //   u.IdUsuario,c.CIPersonal,c.Nombre,c.Apellido,c.FechaNac,c.FechaIng,c.Celular,u.Contraseña
            String [] titulos = {"N° HISTORIAL","FECHA","DESCRIPCION","MASCOTA","TIPO","RAZA","NOMBRE PROPIETARIO","APELLIDO PROPIETARIO","CI",};
            String[] Registros = new String[15];
            model = new DefaultTableModel(null, titulos);
            ResultSet rs=cnx.EjecutarConsulta("SELECT h.NRO_HISTORIAL,h.FECHA,h.DESCRIPCION,an.NOMBREANIMAL,an.DESCRIPCIONANIMAL,r.DESCRIPCIONRAZA,p.NOMBREPRO,apellidopro,p.cipro FROM HISTORIALCLINICO h,PROPIETARIO p,RAZA r,ANIMAL an WHERE  h.idanimal=an.idanimal and p.idpropietario=an.idpropietario and r.idraza=an.idraza and p.cipro="+Valor+";");
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
            hist.setModel(model);
          } catch (SQLException ex)
            {
              Logger.getLogger(Propietario.class.getName()).log(Level.SEVERE, null, ex);
            }
    }*/
    public void Buscarihist (JTable HIST,String valor)
    {
        try {
         //   u.IdUsuario,c.CIPersonal,c.Nombre,c.Apellido,c.FechaNac,c.FechaIng,c.Celular,u.Contraseña
            String [] titulos = {"N° HISTORIAL","FECHA","DESCRIPCION","ID ANIMAL"};
            String[] Registros = new String[15];
            model = new DefaultTableModel(null, titulos);
            ResultSet rs=cnx.EjecutarConsulta("SELECT NRO_HISTORIAL,FECHA,DESCRIPCION,ID_ANIMAL FROM HISTORICO_ANIMAL");
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
            HIST.setModel(model);
          } catch (SQLException ex)
            {
              Logger.getLogger(Propietario.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
  /*  public void Buscardetahis(JTable dethis,String valor)
    {
        try {
         //   u.IdUsuario,c.CIPersonal,c.Nombre,c.Apellido,c.FechaNac,c.FechaIng,c.Celular,u.Contraseña
            String [] titulos = {"N° HISTORIAL","FECHA","DESCRIPCION","MASCOTA","TIPO","RAZA","NOMBRE PROPIETARIO","APELLIDO PROPIETARIO","CI",};
            String[] Registros = new String[15];
            model = new DefaultTableModel(null, titulos);
            ResultSet rs=cnx.EjecutarConsulta("SELECT h.NROHISTORIAL,h.FECHAHISTORIAL,h.DESCRIPCIONHISTORIAL,an.NOMBREANIMAL,an.DESCRIPCIONANIMAL,r.DESCRIPCIONRAZA,p.NOMBREPRO,apellidopro,p.cipro FROM HISTORIALCLINICO h,PROPIETARIO p,RAZA r,ANIMAL an WHERE  h.idanimal=an.idanimal and p.idpropietario=an.idpropietario and r.idraza=an.idraza");
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
            dethis.setModel(model);
          } catch (SQLException ex)
            {
              Logger.getLogger(Propietario.class.getName()).log(Level.SEVERE, null, ex);
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