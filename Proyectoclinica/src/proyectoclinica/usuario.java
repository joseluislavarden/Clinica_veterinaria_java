/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoclinica;

/**
 *
 * @author Male
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import proyectoclinica.Conexion;
import proyectoclinica.ModeloMostrarDatos;
public class usuario 
{
    private int iduser;
    private String username;
    private String password;
    private int idpersonal;
    Conexion cnx = new Conexion();
    

public usuario()
{
iduser=0;
username="";
password="";
idpersonal=0;
}
public usuario(int iduser,String username,String password,int idpersonal){
    this.iduser=iduser;
    this.username=username;
    this.password=password;
    this.idpersonal=idpersonal;
}

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdpersonal() {
        return idpersonal;
    }

    public void setIdpersonal(int idpersonal) {
        this.idpersonal = idpersonal;
    }

    public Conexion getCnx() {
        return cnx;
    }

    public void setCnx(Conexion cnx) {
        this.cnx = cnx;
    }
    public boolean esConexionNull(){
        return cnx.getConnection()==null;
    }
    
    public void desconectar(){
        cnx.desconectar();
    }
 public void mostrarUsuario(JTable jtable){
        try {
            String[] tituloEncabezado = {"IDUSER", "USERNAME", "PASSWORD", "IDPERSONAL"};
            String consulta = "SELECT iduser, username, password,p.idpersonal\n" +
                                "FROM usuario u, personal p\n" +
                                "WHERE u.idpersonal=p.idpersonal;";
            ModeloMostrarDatos modelo = new ModeloMostrarDatos();
            modelo.mostrar(tituloEncabezado, jtable, cnx, consulta);
        } catch (SQLException ex) {
            System.out.println("Error al mostrar datos de usuario!\n" + ex.getMessage());
        }
    }
 public void guardarusuario(String iduser){
        try {
            String consulta = "SELECT iduser FROM usuario WHERE iduser='"+iduser+"'";
            ResultSet rs = cnx.EjecutarConsulta(consulta);
            
            String comando;
            if(rs.next())
                comando = "UPDATE usuario SET username='"+this.username+"', password=md5('"+this.password+"') WHERE iduser='"+iduser+"';";
            else
                comando = "INSERT INTO usuario (username, password, idpersonal) " + 
                            "VALUES ('"+this.username+"', md5('"+this.password+"'), '"+this.idpersonal+"');";
             cnx.EjecutarComando(comando);
        } 
        catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
    }
 public void eliminarUsuario(String iduser){
        cnx.EjecutarComando("DELETE FROM usuario WHERE iduser='"+iduser+"'");
    }
 
  public String[] validarIngresoAlSistema(String username, String pass){
        String[] respuesta = new String[3];
        try {
            String consulta = "SELECT u.iduser, p.idpersonal, u.username,u.password  FROM usuario u , personal p \n" +
                    "WHERE u.idpersonal=p.idpersonal \n" +
                    "AND u.username='"+username+"' AND u.password=md5('"+pass+"');";
            ResultSet rs = cnx.EjecutarConsulta(consulta);
            if(rs.next()){
                respuesta[0] = rs.getString("iduser");
                respuesta[1] = rs.getString("username");
                respuesta[2] = rs.getString("password");
                return respuesta;
            }else
                return null;
        } catch (SQLException ex) {
            System.out.println("Ha surgido un error inesperado, intente más tarde!\n"+ex.getMessage());
            return null;
        }
    }
    
    public void verificarUsuarioCambiarPassword(String usuario, String pass){
        String respuesta;
        try {
            String consulta = "SELECT idpersonal FROM usuario\n" +
                    "WHERE idpersonal='"+usuario+"' AND password=md5('"+pass+"');"; //va a verificar solo por el id personal que es fk. Si en caso tiene varias cuentas de usuario seguirá funcionando.
            ResultSet rs = cnx.EjecutarConsulta(consulta);
            rs.next();
              /*  respuesta = rs.getString("iduser");
                return respuesta;
            }else
                return null;}*/
             }  catch (SQLException ex) {
            System.out.println("Ha surgido un error inesperado, intente más tarde!\n"+ex.getMessage());
            //return null;
        }
    }
    
    public void mostrarDatosEnTablaid(JTable mitabla,int iduser){
        try {
            String consulta = "SELECT iduser, username, password, p.idpersonal\n" +
                                "FROM  personal p,usuario u \n" +
                                "WHERE p.idpersonal=u.idpersonal AND u.iduser="+iduser+";";
            
            String [] titulos = {"ID USER","USER NAME", "PASSWORD", "ID PERSONAL"};
             ModeloMostrarDatos modelo = new ModeloMostrarDatos();
            modelo.mostrar(titulos, mitabla, cnx, consulta);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al mostrar datos en la tabla!\n" + ex.getMessage(), "Tarea fallida!", JOptionPane.WARNING_MESSAGE);
        }
    } 
}
