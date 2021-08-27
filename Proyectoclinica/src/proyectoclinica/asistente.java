/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoclinica;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
/**
 *
 * @author Male
 */
public class asistente extends persona
{
  DefaultTableModel model;
  Conexion cnx=new Conexion();
public asistente(int idpersona,String nombre,String apellido,int ci,String sexo,int celular,String direccion)
{
super(idpersona,nombre,apellido,ci,sexo,celular,direccion);    
}
public asistente(){ 
        super();
 }


  

public void guardarasistente()
{
 int  idpersona = super.getIdpersona();
        String nombre = super.getNombre();
        String apellido = super.getApellido();
        int ci = super.getCi();
        String sexo = super.getSexo();
        int celular = super.getCelular();
        String direccion = super.getDireccion();
        ResultSet rs = cnx.EjecutarConsulta("SELECT idpersonal FROM personal WHERE idpersonal='" + idpersona + "';");
        try {
            String persona, asistente;
            if(rs.next()){  //boolean
                persona = "UPDATE personal SET nombrepersonal='"+nombre+"', apellidopersonal='"+apellido+"', cipersonal='"+ci+"', celularpersonal='"+celular+"', direccionpersonal='"+direccion+"',sexopersonal='"+sexo+"' WHERE idpersonal= '"+idpersona+"';";
                asistente  = "UPDATE asistente SET idpersonal='"+idpersona+"' WHERE idpersonal = '"+idpersona+"';";
                
            }else{
                persona = "INSERT INTO personal (idpersonal, cipersonal, nombrepersonal, apellidopersonal, \n" +
                            "celularpersonal, sexopersonal, direccionpersonal) \n" +
                            "VALUES ('"+idpersona+"','"+ci+"', '"+nombre+"', '"+apellido+"', '"+celular+"', '"+sexo+"','"+direccion+"');";
               asistente = "INSERT INTO asistente (idpersonal) \n" +
                                "VALUES ('"+idpersona+"');";
            } 
          cnx.EjecutarComando(persona+asistente);       
        } 
        catch (SQLException ex) {
        System.out.println(ex.getMessage());
        }
}
  public void mostrarDatosEnTabla(JTable mitabla, String idpersona){
        try {
            String consulta = "SELECT p.idpersonal, p.cipersonal, p.nombrepersonal, p.apellidopersonal, p.sexopersonal,\n" +
                                "p.celularpersonal, p.direccionpersonal\n" +
                                "FROM  personal p, asistente a\n" +
                                "WHERE p.idpersonal=a.idpersonal;";
            
            String [] titulos = {"ID","CI", "NOMBRES", "APELLIDOS", "SEXO", "CELULAR" ,"DIRECCION"};

            ModeloMostrarDatos modelo = new ModeloMostrarDatos();
            modelo.mostrar(titulos, mitabla, cnx, consulta);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al mostrar datos en la tabla!\n" + ex.getMessage(), "Tarea fallida!", JOptionPane.WARNING_MESSAGE);
        }
    } 
    public void Eliminarasistente(int idpersona){
        String comando = "DELETE FROM personal WHERE idpersonal = '"+idpersona+"';";
        cnx.EjecutarComando(comando);
    }
      public void buscarasistentePorid(JTextField jtextfield, int idpersona){
        try {
            String consulta = "SELECT p.nombrepersonal FROM personal p, asistente as WHERE p.idpersonal=as.idpersonal AND as.idpersonal='"+idpersona+"';";
            ResultSet rs = cnx.EjecutarConsulta(consulta);
            if( rs.next() )
                jtextfield.setText(rs.getString("nombrepersonal"));
            else
                JOptionPane.showMessageDialog(null, "No existe el asistente con id: " + idpersona);
        } catch (SQLException ex) {
            System.out.println("Error al buscar asistente!\n" + ex.getMessage());
        }
    }
 
}

  
