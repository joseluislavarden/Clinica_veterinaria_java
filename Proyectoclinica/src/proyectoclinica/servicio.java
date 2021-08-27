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
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Male
 */
public class servicio
{
    private int codservicio;
    private String descripcion;
    private int precio;
    DefaultTableModel model;
    Conexion cnx=new Conexion();
    
 public servicio(int codservicio,String descripcion,int precio)
 {
     this.codservicio=codservicio;
     this.descripcion=descripcion;
     this.precio=precio;
     
 }  
@Override
    public String toString(){
        if(this.codservicio != 0 && !this.descripcion.equals("titulo")&&this.precio !=0)
            return this.codservicio+" || "+this.descripcion +"||"+this.precio;
        else
            return "seleccione un servicio:"; 
    } 
public servicio()
{
 this.codservicio=0;
 this.descripcion="";
 this.precio=0;
} 

    public int getCodservicio() {
        return codservicio;
    }

    public void setCodservicio(int codservicio) {
        this.codservicio = codservicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }


public void Insertarservicio(int codservicio,String descripcion,int precio){
     
      this.setCodservicio(codservicio);
      this.setDescripcion(descripcion);
      this.setPrecio(precio);
      
      cnx.EjecutarComando("insert into servicio values("+codservicio+",'"+descripcion+"','"+precio+"');");
     
   }
 public void Eliminarservicio(int codservicio,String descripcion,int precio)
   {
      this.setCodservicio(codservicio);
      this.setDescripcion(descripcion);
      this.setPrecio(precio);
      cnx.EjecutarComando("delete from servicio where cod_servicio="+codservicio+";");
     
   }
  public void Actualizar(int codservicio,String descripcion,int precio)
    {
   
      this.setCodservicio(codservicio);
      this.setDescripcion(descripcion);
      this.setPrecio(precio);
      cnx.EjecutarComando("update servicio set cod_servicio="+codservicio +",descripcion='"+descripcion+"',precio="+precio+" WHERE COD_SERVICIO="+codservicio+";");
      
    }
    public void BuscarIDser (JTable servicio,String Valor)
    {
        try {
         //   u.IdUsuario,c.CIPersonal,c.Nombre,c.Apellido,c.FechaNac,c.FechaIng,c.Celular,u.Contraseña
            String [] titulos = {"CODIGO SERVICIO","DESCRIPCION","PRECIO"};
            String[] Registros = new String[15];
            model = new DefaultTableModel(null, titulos);
            ResultSet rs;
           rs = cnx.EjecutarConsulta("SELECT cod_servicio,descripcion,precio FROM servicio WHERE cod_servicio="+Valor+"; ");
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
            servicio.setModel(model);
          } catch (SQLException ex)
            {
              Logger.getLogger(servicio.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    public void Buscar (JTable servicio,String Valor)
    {
        try {
         //   u.IdUsuario,c.CIPersonal,c.Nombre,c.Apellido,c.FechaNac,c.FechaIng,c.Celular,u.Contraseña
            String [] titulos = {"CODIGO","DESCRIPCION","PRECIO"};
            String[] Registros = new String[15];
            model = new DefaultTableModel(null, titulos);
            ResultSet rs;
           rs = cnx.EjecutarConsulta("SELECT cod_servicio,descripcion,precio FROM servicio;");
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
            servicio.setModel(model);
          } catch (SQLException ex)
            {
              Logger.getLogger(servicio.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
      public void ListarServicio(JComboBox<servicio> comboservicio){
        try{
            ResultSet rs = cnx.EjecutarConsulta("select* from servicio ;");
            comboservicio.addItem(new servicio(0, "titulo",0));
            while(rs.next()){
                comboservicio.addItem(new servicio(
                        Integer.parseInt(rs.getString("cod_servicio")),
                        rs.getString("descripcion"), 
                        Integer.parseInt(rs.getString("precio"))
                )
                );
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al mostrar servicio \n"+e);
        }
    }   
}
