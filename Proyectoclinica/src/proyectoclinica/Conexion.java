/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoclinica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author hp
 */
public class Conexion {
    private String bd="clinica_veterinaria";//nombre de la base de datos creado en postgre SQL
    //private String url="jdbc:postgresql://192.168.1.1:5432/"+bd;//libreria + ubicacion del servidor local de las base de datos de SQLpostgree
    private String url="jdbc:postgresql://127.0.0.1:5433/"+bd;//libreria + ubicacion del servidor local de las base de datos de SQLpostgree
    
    private String usuario="postgres";
    private String contra="2504";
    private Connection cnx=null; //
    
    public Conexion()
    {
        Conectar();
        
    }
    
    public void Conectar()
      
    {
        try {                                           //captura la exepciones de errores
            Class.forName("org.postgresql.Driver");
            cnx= DriverManager.getConnection(url, usuario, contra);
        } catch (Exception e) { 
            System.out.println("error"+e.getMessage()); //muestra los errores
        }
    }
        public void desconectar(){
        if(getConnection()!=null){
            try {
                cnx.close();
            } catch (SQLException ex) {
                System.out.println("Problemas al desconectar !!!\n" + ex.getMessage());
            }
        }
    }
    public Connection getConnection()
    {
        return cnx; 
    }
     public void EjecutarComando(String Comando) {
     try {
         Statement Cmd = cnx.createStatement();
     Cmd.execute(Comando);
     }
     catch (Exception err) {
     System.out.println("Error al intentar ejecutar comando: " + err);
     }
   }

   public ResultSet EjecutarConsulta(String Consulta) {
     ResultSet res = null;
     try {
     Statement stmt = cnx.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
     res = stmt.executeQuery(Consulta);
     }
     catch (Exception err) {
     System.out.println("Error al intentar ejecutar consulta: " + err);
     }
     return res;
   }

}  