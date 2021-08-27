/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoclinica;

/**
 *
 * @author josel
 */
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

public class Animal {
    private int idanimal;
    private String annombre;
    private String color;
    private String fecha;
    private int cipropietario;
    private int idraza;
    private int tipoanimal;
    DefaultTableModel model;
    Conexion cnx=new Conexion();

    public Animal(int idanimal, String annombre, String color, String fecha, int cipropietario, int idraza, int tipoanimal) {
        this.idanimal = idanimal;
        this.annombre = annombre;
        this.color = color;
        this.fecha = fecha;
        this.cipropietario = cipropietario;
        this.idraza = idraza;
        this.tipoanimal = tipoanimal;
    }
   
     public Animal() {
        this.idanimal = 0;
        this.annombre = "";
        this.color = "";
        this.fecha = "";
        this.cipropietario = 0;
        this.idraza = 0;
        this.tipoanimal=0;
 
        
    }

    public int getIdanimal() {
        return idanimal;
    }

    public void setIdanimal(int idanimal) {
        this.idanimal = idanimal;
    }

    public String getAnnombre() {
        return annombre;
    }

    public void setAnnombre(String annombre) {
        this.annombre = annombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCipropietario() {
        return cipropietario;
    }

    public void setCipropietario(int cipropietario) {
        this.cipropietario = cipropietario;
    }

    public int getIdraza() {
        return idraza;
    }

    public void setIdraza(int idraza) {
        this.idraza = idraza;
    }

    public int getTipoanimal() {
        return tipoanimal;
    }

    public void setTipoanimal(int tipoanimal) {
        this.tipoanimal = tipoanimal;
    }

   
    public void Insertar(int idan,String noman,String col, String fech, int cipro, int idrz,int tipoan){
     
      this.setIdanimal(idan);
      this.setAnnombre(noman);
      this.setColor(col);
      this.setFecha(fech);
      this.setCipropietario(cipro);
      this.setIdraza(idrz);
      this.setTipoanimal(tipoan);
      cnx.EjecutarComando("insert into animal_mascota values("+idanimal+",'"+annombre+"','"+color+"','"+fecha+"',"+cipropietario+","+idraza+","+tipoanimal+");");
     
   }  
    
   public void Eliminar(int idan,String nombrean,String col,String fech, int cipro, int idrz,int tipoan)
   {
        this.setIdanimal(idan);
      this.setAnnombre(nombrean);
      this.setColor(col);
      this.setFecha(fech);
      this.setCipropietario(cipro);
      this.setIdraza(idrz);
      this.setTipoanimal(tipoan);

      cnx.EjecutarComando("delete from animal_mascota where id_animal="+idanimal+";");
     
   }
   
   public void Actualizar(int idan,String nombrean,String col,String fech, int cipro, int idrz,int tipoan)
    {
  this.setIdanimal(idan);
      this.setAnnombre(nombrean);
      this.setColor(col);
      this.setFecha(fech);
      this.setCipropietario(cipro);
      this.setIdraza(idrz);
      this.setTipoanimal(tipoan);
      
      cnx.EjecutarComando("update animal_mascota set id_animal="+idanimal +",annombre='"+annombre+"',color='"+color+"',fecha='"+fecha+"',ci_propietario="+cipropietario+",id_raza="+idraza+",id_tipoanimal="+tipoanimal+" where id_animal="+idanimal+";");
    }

    public void Buscar (JTable ani,String Valor)
    {
        try {
         //   u.IdUsuario,c.CIPersonal,c.Nombre,c.Apellido,c.FechaNac,c.FechaIng,c.Celular,u.Contraseña
            String [] titulos = {"ID ANIMAL","NOMBRE MASCOTA","COLOR","FECHA NACIMIENTO","PROPIETARIO","RAZA","TIPO ANIMAL"};
            
            String[] Registros = new String[15];
            model = new DefaultTableModel(null, titulos);
            ResultSet rs=cnx.EjecutarConsulta("SELECT id_animal,annombre,color,fecha,ci_propietario,id_raza,id_tipoanimal FROM animal_mascota ; ");
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
   
         
    public String Pci ()
    {
        return "SELECT max(perci) from persona";
    }
     public  String verCI()
    {
        return "select CI from cliente;";
    }
   
 
    
    
}
