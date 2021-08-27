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
 * @author hp
 */

public class TipoAnimal {
    private int id_tipoanimal;
    private String descripcion_tipoanimal;
    DefaultTableModel model;
    Conexion cnx=new Conexion();
 

     public TipoAnimal(int id, String descripcion) {
        this.id_tipoanimal = id;
        this.descripcion_tipoanimal = descripcion;
       
      
    }
     public TipoAnimal() {
        this.id_tipoanimal = 0;
        this.descripcion_tipoanimal = "";
           
    }
        
   
    
    /*@Override
    public String toString(){
        if(this.id_tipoanimal != 0 && !this.descripcion_tipoanimal.equals("titulo"))
            return this.id_tipoanimal+" || "+this.descripcion_tipoanimal;
        else
            return "seleccione una raza:"; 
    }*/
    
    
     
    
    public int GetId_tipoanimal() {
        return id_tipoanimal;
    }

    public void SetId_tipoanimal(int id) {
        this.id_tipoanimal = id;
    }

    public String GetDescripcion_tipoanimal() {
        return descripcion_tipoanimal;
    }

    public void SetDescripcion_tipoanimal(String descripcion) {
        this.descripcion_tipoanimal= descripcion;
    }

    
      
    public void Insertar(int idtipoAn,String descripciontipAn){
     
      this.SetId_tipoanimal(idtipoAn);
      this.SetDescripcion_tipoanimal(descripciontipAn);
      
      cnx.EjecutarComando("insert into tipoanimal values("+idtipoAn+",'"+descripciontipAn+"');");
     
   } 
    
   public void Eliminar(int id,String descripcion)
   {
      this.SetId_tipoanimal(id);
      this.SetDescripcion_tipoanimal(descripcion);
      cnx.EjecutarComando("delete from raza where idraza="+id_tipoanimal+";");
     
   }
 
   public void Actualizar(int id,String des)
    {
   
      this.SetId_tipoanimal(id);
      this.SetDescripcion_tipoanimal(des);
      cnx.EjecutarComando("update tipoanimal set idraza="+id_tipoanimal +",descripcionraza='"+descripcion_tipoanimal+"' where idraza="+id_tipoanimal+";");
    }

    public void Buscar (JTable tipoanimal,String Valor)
    {
        try {
         //   u.IdUsuario,c.CIPersonal,c.Nombre,c.Apellido,c.FechaNac,c.FechaIng,c.Celular,u.Contraseña
            String [] titulos = {"ID TIPOANIMAL","DESCRIPCION"};
            String[] Registros = new String[15];
            model = new DefaultTableModel(null, titulos);
            ResultSet rs=cnx.EjecutarConsulta("SELECT id_tipoanimal,descripcion_tipoanimal FROM tipoanimal ; ");
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
            tipoanimal.setModel(model);
          } catch (SQLException ex)
            {
              Logger.getLogger(raza.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    /*public void ListarRaza(JComboBox<raza> desplegable){
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
    }
    
    */
   
         
   /* public String Pci ()
    {
        return "SELECT max(idraza) from raza";
    }
     public  String verCI()
    {
        return "select CI from cliente;";
    }*/

    


   
 
    
    
}
