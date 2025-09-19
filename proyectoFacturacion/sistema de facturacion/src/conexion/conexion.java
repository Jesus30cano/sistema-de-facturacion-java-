
package conexion;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class conexion {
    
    private static final String login = "root";
    
    private static final String password = "admim";
    
    private static final String url = "jdbc:mysql://localhost:3306/DB_Sistema_Facturacion";
    
    Connection activa=null;
    
    String driver ="com.mysql.cj.jdbc.Driver";
    
    
    public  conexion() throws ClassNotFoundException{
        
        try{
            
            Class.forName(driver);
            
            activa = DriverManager.getConnection(url, login, password);
            
            if(activa != null){
                
                System.out.println("conexion exitosa");
               
            }
            
        }catch(SQLException e){
            
            System.out.println("ERROR " + e);
           
        }
            
        
    }
    
     public Connection getConnection() {
        return activa;
    }
    
     
     public void desconectar() {
        activa = null;
        
         if (activa!=null) {
             
                JOptionPane.showMessageDialog(null, "no se pudo cerrar la conexion");
                
         }
        
    }
     
      public ResultSet Listar (String Cad, String... parametros) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        
         try {
            // Carga el controlador JDBC que se utilizará para conectar con la base de datos MySQL
            Class.forName(driver);
            
            // Establece la conexión con la base de datos usando la URL, el usuario y la contraseña.)
            Connection cn = DriverManager.getConnection(url, login, this.password); 
            
            // Preparar la consulta SQL
            PreparedStatement ps = cn.prepareStatement(Cad);
            
            for (int i = 0; i < parametros.length; i++){
                
                ps.setString(i + 1, parametros[i]);
            } 
            // Ejecutar la consulta y obtiene los datos            
            return ps.executeQuery();
            
            
      
        } catch (SQLException  e ) {
            javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }
    // metodo para ejecutar una instrucción SQL (INSERT, UPDATE o DELETE)
    public String Ejecutar (String Cad) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
        
         try {
            // Carga el controlador JDBC que se utilizará para conectar con la base de datos MySQL
            Class.forName(driver);
            
            // Establece la conexión con la base de datos usando la URL, el usuario y la contraseña.
            Connection cn = DriverManager.getConnection(url, login, password);
            
            // Preparar la consulta SQL
            PreparedStatement ps = cn.prepareStatement(Cad);
            
            /* por medio de executeUpdate se ejecuta las instrucciones SQL 
            que modifican el contenido de la base de datos*/
            int r = ps.executeUpdate();
            return "registro grabado con exito";
            
        
        } catch (SQLException  e) {
            
            JOptionPane.showMessageDialog(null, e.getMessage());
            
            return "Error" + e.getMessage();
            
        }
    }
    
    
    
    //Metodo para ejecutar la consulta con una imagen
    
   public void EjecutarConImagen(String sql, String nombre, byte[] foto, double precio, int cantidad, int id_categoria)
           
        throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
    
    
     Connection cn = DriverManager.getConnection(url, login, password);
     
    PreparedStatement ps = null;

    try {
        ps = cn.prepareStatement(sql);
        
        ps.setString(1, nombre);
        
        ps.setBytes(2, foto);
        
        ps.setDouble(3, precio);
        
        ps.setInt(4, cantidad);
        
        ps.setInt(5, id_categoria);

        ps.executeUpdate(); 
    } finally {
        if (ps != null) ps.close();
        if (cn != null) cn.close();
    }
}

}
