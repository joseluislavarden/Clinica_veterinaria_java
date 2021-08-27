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

public class persona 
{
    Conexion cnx=new Conexion();
    DefaultTableModel model;
    private int idpersonal;
    private String pernombre;
    private String perapellido;
    private int celular;
    private String direccion;
    private String perci;
    private String correo;
    private int idtipopersonal;
  
public  persona(int idpersona, String nombre,String apellido,int celular,String direccion,String ci,String correo, int tipopersonal)
{
    this.idpersonal= idpersona;
    this.pernombre= nombre;
    this.perapellido=apellido;
    this.celular=celular;
    this.direccion=direccion;
    this.perci=ci;
    this.correo=correo;
    this.idtipopersonal=tipopersonal;
    
}    
public  persona()
{
    this.idpersonal= 0;
    this.pernombre= "";
    this.perapellido="";
    this.celular=0;
    this.direccion="";
    this.perci="";
    this.correo="";
    this.idtipopersonal=0;
    
}    
/*public  persona(int idpersona, String nombre,String apellido)
{
    this.idpersonal= idpersona;
    this.nombre= nombre;
    this.apellido=apellido;
  
    
} 
  @Override
    public String toString(){
        if(this.idpersonal != 0 && !this.nombre.equals("titulo")&&!this.apellido.equals("titulo"))
            return this.idpersonal+" || "+this.nombre +"||"+this.apellido;
        else
            return "seleccione un asistente:"; 
    }
public persona()
{
   this.idpersonal= 0;
    this.nombre="";
    this.apellido="";
    
} */

    public int getIdpersonal() {
        return idpersonal;
    }

    public void setIdpersonal(int idpersonal) {
        this.idpersonal = idpersonal;
    }

    public String getPernombre() {
        return pernombre;
    }

    public void setPernombre(String pernombre) {
        this.pernombre = pernombre;
    }

    public String getPerapellido() {
        return perapellido;
    }

    public void setPerapellido(String perapellido) {
        this.perapellido = perapellido;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPerci() {
        return perci;
    }

    public void setPerci(String perci) {
        this.perci = perci;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getIdtipopersonal() {
        return idtipopersonal;
    }

    public void setIdtipopersonal(int idtipopersonal) {
        this.idtipopersonal = idtipopersonal;
    }
public void Insertarpersonal(int idpersonal,String nombre,String apellido,int cel,String dir, String ci, String corr,int idtipoper ){
     
      this.setIdpersonal(idpersonal);
      this.setPernombre(nombre);
      this.setPerapellido(apellido);
      this.setCelular(cel);
      this.setDireccion(dir);
      this.setPerci(ci);
      this.setCorreo(corr);
      this.setIdtipopersonal(idtipoper);
      
      cnx.EjecutarComando("insert into personal values("+idpersonal+",'"+nombre+"','"+apellido+"',"+cel+",'"+dir+"','"+ci+"','"+corr+"',"+idtipoper+");");
}
 public void Buscarpersonal (JTable per,String Valor)
    {
        try {
         //   u.IdUsuario,c.CIPersonal,c.Nombre,c.Apellido,c.FechaNac,c.FechaIng,c.Celular,u.Contraseña
            String [] titulos = {"ID_PERSONAL","NOMBRE","APELLIDO","CELULAR","DIRECCION","CARNET","CORREO","ID_TIPOPERSONAL"};
            String[] Registros = new String[15];
            model = new DefaultTableModel(null, titulos);
            ResultSet rs=cnx.EjecutarConsulta("SELECT idpersonal ,pernombre ,perapellido ,percelular ,perdireccion ,perci ,correo,id_tipopersonal  FROM personal ; ");
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
            per.setModel(model);
          } catch (SQLException ex)
            {
              Logger.getLogger(Propietario.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
  /*public void ListarAsistente(JComboBox<persona> comboasistente){
        try{
            ResultSet rs = cnx.EjecutarConsulta("SELECT asis.idpersonal,per.nombrepersonal,per.apellidopersonal FROM asistente asis,personal per where asis.idpersonal=per.idpersonal;");
            comboasistente.addItem(new persona(0, "titulo","titulo"));
            while(rs.next()){
                comboasistente.addItem(new persona(
                        Integer.parseInt(rs.getString("idpersonal")),
                        rs.getString("nombrepersonal"), 
                        rs.getString("apellidopersonal")
                )
                );
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al mostrar asistente \n"+e);
        }
    }   
*/

}
