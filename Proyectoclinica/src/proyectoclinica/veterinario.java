/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoclinica;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
/**
 *
 * @author Male
 */
public class veterinario extends persona
{
   private String experiencia;
   private String trabajosant; 
//   DefaultTableModel model;
    Conexion cnx=new Conexion();
  
    
    public veterinario(int idpersona,String nombre,String apellido,int ci,String sexo,int celular,String direccion,String experiencia,String trabajosant)
    {
    super(idpersona,nombre,apellido,ci,sexo,celular,direccion);
    this.experiencia = experiencia;
    this.trabajosant = trabajosant;
    }
    public veterinario()
    {
       super();
        this.experiencia ="";
        this.trabajosant="";
        
    }
     public veterinario(int idpersona,String nombre,String apellido)
    {
    super(idpersona,nombre,apellido);

    } 
    

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public String getTrabajosant() {
        return trabajosant;
    }

    public void setTrabajosant(String trabajosant) {
        this.trabajosant = trabajosant;
    }
    public void guardarveterinario(){
        int  idpersona = super.getIdpersona();
        String nombre = super.getNombre();
        String apellido = super.getApellido();
        int ci = super.getCi();
        String sexo = super.getSexo();
        int celular = super.getCelular();
        String direccion = super.getDireccion();
        String experiencia = this.getExperiencia();
        String trabajosant = this.getTrabajosant();
        
        
        
        ResultSet rs = cnx.EjecutarConsulta("SELECT idpersonal FROM personal WHERE idpersonal='" + idpersona + "';");
        try {
            String persona, veterinario;
            if(rs.next()){  //boolean
                persona = "UPDATE personal SET nombrepersonal='"+nombre+"', apellidopersonal='"+apellido+"', cipersonal='"+ci+"', celularpersonal='"+celular+"', direccionpersonal='"+direccion+"',sexopersonal='"+sexo+"' WHERE idpersonal= '"+idpersona+"';";
                veterinario = "UPDATE veterinario SET experiencia='"+experiencia+"', trabajosant='"+trabajosant+"' WHERE idpersonal = '"+idpersona+"';";
                
            }else{
                persona = "INSERT INTO personal (idpersonal, cipersonal, nombrepersonal, apellidopersonal, \n" +
                            "celularpersonal, sexopersonal, direccionpersonal) \n" +
                            "VALUES ('"+idpersona+"','"+ci+"', '"+nombre+"', '"+apellido+"', '"+celular+"', '"+sexo+"','"+direccion+"');";
               veterinario = "INSERT INTO veterinario (idpersonal, experiencia, trabajosant) \n" +
                                "VALUES ('"+idpersona+"', '"+experiencia+"', '"+trabajosant+"');";
            } 
          cnx.EjecutarComando(persona+veterinario);       
        } 
        catch (SQLException ex) {
        System.out.println(ex.getMessage());
        }
    }
    
    public void mostrarDatosEnTabla(JTable mitabla, String idpersona){
        try {
            String consulta = "SELECT p.idpersonal, p.cipersonal, p.nombrepersonal, p.apellidopersonal, p.sexopersonal,\n" +
                                "	p.celularpersonal, p.direccionpersonal, m.experiencia, m.trabajosant\n" +
                                "FROM  personal p, veterinario m\n" +
                                "WHERE p.idpersonal=m.idpersonal;";
            
            String [] titulos = {"idpersona","ci", "nombre", "apellido", "sexo", "celular" ,"direccion","experiencia","trabajos anteriores"};

            ModeloMostrarDatos modelo = new ModeloMostrarDatos();
            modelo.mostrar(titulos, mitabla, cnx, consulta);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al mostrar datos en la tabla!\n" + ex.getMessage(), "Tarea fallida!", JOptionPane.WARNING_MESSAGE);
        }
    } 
    public void Eliminarveterinario(int idpersona){
        String comando = "DELETE FROM personal WHERE idpersonal = '"+idpersona+"';";
        cnx.EjecutarComando(comando);
    }
   /* public void buscarParaEdicion(int idpersona){
        try {            
            String consulta = "SELECT p.*, v.experiencia, v.trabajosant FROM  personal p, veterinario v WHERE p.idpersonal=v.idpersonal AND p.idpersonal='" +idpersona+ "';";
            ResultSet rs=cnx.EjecutarConsulta(consulta); 
            ResultSetMetaData datos=rs.getMetaData();  
            int num_columnas=datos.getColumnCount();
            if(rs.next()){
                String resultadoEncontrado []=new String[num_columnas]; 
                    try{
                       
                        resultadoEncontrado[0]=rs.getString("idnombre");
                        resultadoEncontrado[1]=rs.getString("nombre");
                        resultadoEncontrado[2]=rs.getString("apellido");
                        resultadoEncontrado[3]=rs.getString("ci");
                        resultadoEncontrado[4]=rs.getString("sexo");
                        resultadoEncontrado[5]=rs.getString("celular");
                        resultadoEncontrado[6]=rs.getString("direccion");
                        resultadoEncontrado[7]=rs.getString("experiencia");
                        resultadoEncontrado[8]=rs.getString("trabajosant");
                    }catch(SQLException e){
                        JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
                    }
                super.setIdpersona(Integer.parseInt(resultadoEncontrado [0]));
                super.setNombre(resultadoEncontrado[1] );
                super.setApellido(resultadoEncontrado[2] );
                super.setCi(Integer.parseInt(resultadoEncontrado[3] ));
                super.setSexo(resultadoEncontrado[4]);
                super.setCelular(Integer.parseInt(resultadoEncontrado[5] ));
                super.setDireccion(resultadoEncontrado[6] );
                this.setExperiencia(resultadoEncontrado[7] );
                this.setTrabajosant(resultadoEncontrado[8] );
            }
        } catch (SQLException ex) {
            Logger.getLogger(veterinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
    
    public void buscarveterinarioPorid(JTextField jtextfield, int idpersona){
        try {
            String consulta = "SELECT p.nombrepersonal FROM personal p, veterinario v WHERE p.idpersonal=v.idpersonal AND v.idpersonal='"+idpersona+"';";
            ResultSet rs = cnx.EjecutarConsulta(consulta);
            if( rs.next() )
                jtextfield.setText(rs.getString("nombrepersonal"));
            else
                JOptionPane.showMessageDialog(null, "No existe el veterinario con id: " + idpersona);
        } catch (SQLException ex) {
            System.out.println("Error al buscar veterinario!\n" + ex.getMessage());
        }
    }
      public void ListarVeterinario(JComboBox<veterinario> comboveterinario){
        try{
            ResultSet rs = cnx.EjecutarConsulta("SELECT vet.idpersonal,per.nombrepersonal,per.apellidopersonal FROM veterinario vet,personal per where vet.idpersonal=per.idpersonal;");
            comboveterinario.addItem(new veterinario(0, "titulo","titulo"));
            while(rs.next()){
                comboveterinario.addItem(new veterinario(
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
      

}

