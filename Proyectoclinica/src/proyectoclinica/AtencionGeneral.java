/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoclinica;
import proyectoclinica.AtencionDetalle;

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

public class AtencionGeneral {
    private int nroatencion;
    private String fechaatencion;
    private int total;
    private int idpersonalvet;
    private int idpersonalasis;
    private int nrohistorial;
    DefaultTableModel model;
    Conexion cnx=new Conexion();
 

    
    public AtencionGeneral(int nroatencio, String fechaaten, int total, int idpervet, int idperasis, int nrohist) {
        this.nroatencion = nroatencio;
        this.fechaatencion = fechaaten;
        this.total = total;
        this.idpersonalvet=idpervet;
        this.idpersonalasis= idperasis;
        this.nrohistorial=nrohist;
   
      
    }
     public AtencionGeneral() {
        this.nroatencion = 0;
        this. fechaatencion = "";
        this.total = 0;
        this.idpersonalvet = 0;
        this.idpersonalasis = 0;
        this.nrohistorial = 0;
 
        
    }

    public int getNroatencion() {
        return nroatencion;
    }

    public void setNroatencion(int nroatencion) {
        this.nroatencion = nroatencion;
    }

    public String getFechaatencion() {
        return fechaatencion;
    }

    public void setFechaatencion(String fechaatencion) {
        this.fechaatencion = fechaatencion;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getIdpersonalvet() {
        return idpersonalvet;
    }

    public void setIdpersonalvet(int idpersonalvet) {
        this.idpersonalvet = idpersonalvet;
    }

    public int getIdpersonalasis() {
        return idpersonalasis;
    }

    public void setIdpersonalasis(int idpersonalasis) {
        this.idpersonalasis = idpersonalasis;
    }

    public int getNrohistorial() {
        return nrohistorial;
    }

    public void setNrohistorial(int nrohistorial) {
        this.nrohistorial = nrohistorial;
    }

   

      
    public void Insertar(int nraten,String atenfecha,int totals, int idvet, int idasis, int nrohist){
     
      this.setNroatencion(nraten);
      this.setFechaatencion(atenfecha);
      this.setTotal(totals);
      this.setIdpersonalvet(idvet);
      this.setIdpersonalasis(idasis);
      this.setNrohistorial(nrohist);
      cnx.EjecutarComando("insert into atenciongeneral values("+nroatencion+",'"+fechaatencion+"',"+total+","+idpersonalvet+","+idpersonalasis+","+nrohistorial+");");
     
   }  
    
 public void Eliminar(int nraten,String atenfecha,int totals, int idvet, int idasis, int nrohist)
   {
      this.setNroatencion(nraten);
      this.setFechaatencion(atenfecha);
      this.setTotal(totals);
      this.setIdpersonalvet(idvet);
      this.setIdpersonalasis(idasis);
      this.setNrohistorial(nrohist);
       cnx.EjecutarComando("delete from detalleservicio where nroatencion="+nraten+";");
      cnx.EjecutarComando("delete from atenciongeneral where nroatencion="+nraten+";");
       
     
   }
 public void Actualizar(int nraten,String atenfecha,int totals, int idvet, int idasis, int nrohist)
    {
   
      this.setNroatencion(nraten);
      this.setFechaatencion(atenfecha);
      this.setTotal(totals);
      this.setIdpersonalvet(idvet);
      this.setIdpersonalasis(idasis);
      this. setNrohistorial(nrohist);
  
      cnx.EjecutarComando("update atenciongeneral set nratencion='"+nraten +"',fechaantencion='"+atenfecha+"',total='"+totals+"',idpersonalvet='"+idvet+"',idpersonalasis='"+idasis+"',nrohistorial='"+nrohist+" where nroatencion='"+nraten+"';");
    }
    public void Buscar (JTable aten,String Valor)
    {
        try {
         //   u.IdUsuario,c.CIPersonal,c.Nombre,c.Apellido,c.FechaNac,c.FechaIng,c.Celular,u.Contraseña
            String [] titulos = {"N° ATENCION","FECHA","TOTAL","ID VETERINARIO","ID ASISTENTE","N° HISTORIAL"};
            String[] Registros = new String[15];
            model = new DefaultTableModel(null, titulos);
            ResultSet rs=cnx.EjecutarConsulta("SELECT nroatencion,fechaatencion,total,idpersonalvet,idpersonalasis,nrohistorial FROM atenciongeneral ; ");
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
            aten.setModel(model);
          } catch (SQLException ex)
            {
              Logger.getLogger(AtencionGeneral.class.getName()).log(Level.SEVERE, null, ex);
            }
    }


   
         
    public String Pci ()
    {
        return "SELECT max(perci) from persona";
    }
     public  String verCI()
    {
        return "select CI from cliente;";
    }
   
 
    
    
}
