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
 * @author CPD
 */

public class tipopersonal {
    
    private int id_tipopersonal;
    private String descripcion;
    Conexion cnx=new Conexion();
    DefaultTableModel model;

    public tipopersonal(int id_tipopersonal, String descripcion) {
        this.id_tipopersonal = id_tipopersonal;
        this.descripcion = descripcion;
    }
    public tipopersonal() {
        this.id_tipopersonal = 0;
        this.descripcion = "";
           
    }


    public int getId_tipopersonal() {
        return id_tipopersonal;
    }

    public void setId_tipopersonal(int id_tipopersonal) {
        this.id_tipopersonal = id_tipopersonal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
  public void Insertartiper(int id,String descripcionti){
     
      this.setId_tipopersonal(id);
      this.setDescripcion(descripcionti);
      cnx.EjecutarComando("insert into tipopersonal values("+id_tipopersonal+",'"+descripcion+"');");
     
   }    
 public void Buscar (JTable tipopersonal,String Valor)
    {
        try {
         //   u.IdUsuario,c.CIPersonal,c.Nombre,c.Apellido,c.FechaNac,c.FechaIng,c.Celular,u.Contraseña
            String [] titulos = {"ID_TIPOPERSONAL","DESCRIPCION"};
            String[] Registros = new String[15];
            model = new DefaultTableModel(null, titulos);
            ResultSet rs=cnx.EjecutarConsulta("SELECT id_tipopersonal,descripcion FROM tipopersonal ; ");
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
            tipopersonal.setModel(model);
          } catch (SQLException ex)
            {
              Logger.getLogger(Propietario.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
