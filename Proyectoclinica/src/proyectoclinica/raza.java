/*
 * To change this template, choose Tools | Templates
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
 * @author hp
 */

public class raza {
    private int idraza;
    private int idtipoAni;
    private String descripcionraza;
    DefaultTableModel model;
    Conexion cnx=new Conexion();
 

     public raza(int idraza,int idTipoAn, String descripcionraza) {
        this.idraza = idraza;
        this.idtipoAni=idTipoAn;
        this.descripcionraza = descripcionraza;
       
      
    }
     public raza() {
        this.idraza = 0;
        this.idtipoAni=0;
        this.descripcionraza = "";
           
    }
        
   
    
  /*  @Override
    public String toString(){
        if(this.idraza != 0 && !this.descripcionraza.equals("titulo"))
            return this.idraza+" || "+this.descripcionraza;
        else
            return "seleccione una raza:"; 
    }*/
    
    
     
    
    public int GetIdraza() {
        return idraza;
    }

    public void SetIdraza(int idraza) {
        this.idraza = idraza;
    }

    public int getIdtipoAni() {
        return idtipoAni;
    }

    public void setIdtipoAni(int idtipoAni) {
        this.idtipoAni = idtipoAni;
    }

    public String GetDescripcionraza() {
        return descripcionraza;
    }

    public void SetDescripcionraza(String descripcionraza) {
        this.descripcionraza= descripcionraza;
    }

    
      
    public void Insertar(int idraza,int idtipoan,String descripcionraza){
     
      this.SetIdraza(idraza);
      this.SetDescripcionraza(descripcionraza);
      
      cnx.EjecutarComando("insert into raza values("+idraza+","+idtipoan+",'"+descripcionraza+"');");
     
   } 
    
   public void Eliminar(int id,String descripcion)
   {
      this.SetIdraza(id);
      this.SetDescripcionraza(descripcion);
      cnx.EjecutarComando("delete from raza where idraza="+idraza+";");
     
   }
 
   public void Actualizar(int id,String des)
    {
   
      this.SetIdraza(id);
      this.SetDescripcionraza(des);
      cnx.EjecutarComando("update raza set idraza="+idraza +",descripcionraza='"+descripcionraza+"' where idraza="+idraza+";");
    }

    public void Buscar (JTable raza,String Valor)
    {
        try {
         //   u.IdUsuario,c.CIPersonal,c.Nombre,c.Apellido,c.FechaNac,c.FechaIng,c.Celular,u.Contraseña
            String [] titulos = {"ID RAZA","NOMBRE RAZA","TIPO ANIMAL","ID TIPO ANIMAL"};
            String[] Registros = new String[15];
            model = new DefaultTableModel(null, titulos);
            ResultSet rs=cnx.EjecutarConsulta("SELECT r.id_raza,r.descripcion_raza,t.descripcion_tipoanimal,r.id_tipoanimal FROM raza r, tipoanimal t where r.id_tipoanimal=t.id_tipoanimal ; ");
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
            raza.setModel(model);
          } catch (SQLException ex)
            {
              Logger.getLogger(raza.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
   /* public void ListarRaza(JComboBox<raza> desplegable){
        try{
            ResultSet rs = cnx.EjecutarConsulta("SELECT idraza, descripcionraza FROM raza ORDER BY idraza; ");
            desplegable.addItem(new raza(0, "titulo"));
            while(rs.next()){
                desplegable.addItem(new raza(
                        Integer.parseInt(rs.getString("idraza")),
                        rs.getString("descripcionraza"))
                );
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al mostrar raza \n"+e);
        }
    
    
    
   
         
   /* public String Pci ()
    {
        return "SELECT max(idraza) from raza";
    }
     public  String verCI()
    {
        return "select CI from cliente;";
    }*/

    


   
 
    
    
}
