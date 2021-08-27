package proyectoclinica;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AtencionDetalle {
    int nroatencion ;
    int codervicio ;
    int preciounitario ;
    DefaultTableModel model;
    
    private final Conexion cnx = new Conexion();

    public int getNroatencion() {
        return nroatencion;
    }

    public void setNroatencion(int nroatencion) {
        this.nroatencion = nroatencion;
    }

    public int getCodervicio() {
        return codervicio;
    }

    public void setCodervicio(int codervicio) {
        this.codervicio = codervicio;
    }

    public int getPreciounitario() {
        return preciounitario;
    }

    public void setPreciounitario(int preciounitario) {
        this.preciounitario = preciounitario;
    }

    
    
    public AtencionDetalle() {
    }

    public AtencionDetalle(int id_atencion, int id_servicio, int precio_unitario) {
        this.nroatencion = id_atencion;
        this.codervicio = id_servicio;
        this.preciounitario = precio_unitario;
    }
    
    public void guardarAtencionDetalle(){
        String comando = "INSERT detalleservicio (nroatencion,codervicio,preciounitario) VALUES ("+nroatencion+","+codervicio+","+preciounitario+")";
        cnx.EjecutarComando(comando);
    }
    public void Insertar(int nroaten,int codser, int precioun){
     
      this.setNroatencion(nroaten);
      this.setCodervicio(codser);
      this.setPreciounitario(precioun);
    
      cnx.EjecutarComando("insert into detalleservicio values("+nroatencion+","+codervicio+","+preciounitario+");");
     
   }  
    
    public void mostrarDetalleEnTabla(JTable mitabla, String id_atencion){
        try {
            String consulta = "SELECT * FROM detalleservicio WHERE nroatencion="+nroatencion+";";
            
            String [] titulos = {"ID_ATENCION","ID_SERVICIO", "PRECION_UNIT"};

            ModeloMostrarDatos modelo = new ModeloMostrarDatos();
            modelo.mostrar(titulos, mitabla, cnx, consulta);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al mostrar datos en la tabla!\n" + ex.getMessage(), "Tarea fallida!", JOptionPane.WARNING_MESSAGE);
        }
    } 
      public void Buscardetalle (JTable detalle,String nroatencion)
    {
        try {
         //   u.IdUsuario,c.CIPersonal,c.Nombre,c.Apellido,c.FechaNac,c.FechaIng,c.Celular,u.Contraseña
            String [] titulos = {"NRO ATENCION","CODIGO SERVICIO","PRECIO"};
            String[] Registros = new String[15];
           model = new DefaultTableModel(null, titulos);
            ResultSet rs=cnx.EjecutarConsulta("SELECT * FROM detalleservicio WHERE nroatencion="+nroatencion+"; ");
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
            detalle.setModel(model);
          } catch (SQLException ex)
            {
              Logger.getLogger(AtencionDetalle.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
          public void mostrarrdetalle (JTable detalle,String nroatencion)
    {
        try {
         //   u.IdUsuario,c.CIPersonal,c.Nombre,c.Apellido,c.FechaNac,c.FechaIng,c.Celular,u.Contraseña
            String [] titulos = {"NRO ATENCION","CODIGO SERVICIO","PRECIO"};
            String[] Registros = new String[15];
           model = new DefaultTableModel(null, titulos);
            ResultSet rs=cnx.EjecutarConsulta("SELECT * FROM detalleservicio ; ");
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
            detalle.setModel(model);
          } catch (SQLException ex)
            {
              Logger.getLogger(AtencionDetalle.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
}