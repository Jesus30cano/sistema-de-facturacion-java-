
package DAO;

import conexion.conexion;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.sql.ResultSetMetaData;
import java.util.Vector;
import javax.swing.JComboBox;




public class Cliente {
    
    private conexion conexion;
    
    
    private int id;
    private String nombre, cedula;
    private Long telefono;
    

    public Cliente(String nombre, String cedula, Long telefono) throws ClassNotFoundException {
        
        this.conexion = new conexion();
        
        this.nombre = nombre;
        
        this.cedula = cedula;
        
        this.telefono = telefono;
        
    }
    
    
    
    public Cliente() throws ClassNotFoundException{
        
        this.conexion = new conexion();
        
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public conexion getConexion() {
        return conexion;
    }

    public void setConexion(conexion conexion) {
        this.conexion = conexion;
    }
    
    
    
    
    //Metodo para registrar un cliente
    
    
    
    public void Registrar_cliente( String nombre, String cedula, Long telefono) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
       
        
        
        //Consulta para insertar los datos en la tabla
        
        String SQL = "INSERT INTO Tb_cliente (nombre, cedula, telefono) VALUES('"+ nombre + "','" + cedula + "'," + telefono + ")";
        
        System.out.println(SQL);
        
        //LLamado al metodo de conexion para el tipo de consulta en este caso un insert 
        
        conexion.Ejecutar(SQL);
        
        
        
       
    }
    
    //Metodo para buscar el id del cliente
    
    public int buscarIdCliente(String cedula) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        
        
        ResultSet rs;
        
        int id_cliente = 0 ;
        
        //Consulta para buscar el id de cliente mediante el numero de cedula, nos permite validar que un usuario exista o no
        
        String SQL = "SELECT id_cliente FROM tb_cliente where cedula = '" + cedula + "'";
        
        //LLamado al metodo para ejecutar la consulta en este caso un select
        
        rs = conexion.Listar(SQL);
        
        //condicional para que cuando encuentre registros asigne el id en la variable tipo entero y si no le asigna 0
        
            if(rs.next()){
                
                id_cliente = rs.getInt("id_cliente");
                
            } else{
                
               id_cliente = 0;
               
            }
            
            return id_cliente;
        
    }
    
    // metodo para actualizar los datos de una tabla 
    
    public  void actualizarTabla(JTable tablaEstudiante){
        
        int cc;
        
        ResultSet rs;
        
        //consulta para traer todos kos datos del cliente
        
        String SQL="SELECT * FROM tb_cliente";
        
        
        try {
            
            //LLamado al metodo para ejecutar la consulta en este caso un select
            
            rs=conexion.Listar(SQL);
            
            ResultSetMetaData RSMD = rs.getMetaData();
            
            cc = RSMD.getColumnCount();
            
            DefaultTableModel DFT = (DefaultTableModel)tablaEstudiante.getModel();
            
            DFT.setRowCount(0);
            
            
            //ciclo para llenar la tabla con los registros encontrados en la consulta
            
            while(rs.next()){
                
                Vector v2=new Vector();
                
                v2.add(rs.getString("id_cliente"));
                
                v2.add(rs.getString("nombre"));
                
                v2.add(rs.getString("cedula"));
                
                v2.add(rs.getString("telefono"));
                
                DFT.addRow(v2);
            }
            
            
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            
            System.out.println("ERROR " + e);
            
        }
        
        
    }
    
    
    //metodo para actualizar clientes
    
    public void actualizarCliente(int id,String nombre,String cedula,Long telefono)throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        
        
        
        //Consulta para editar los datos de los clientes
        
        String SQL = "UPDATE Tb_cliente SET nombre='"+nombre+"', cedula='"+cedula+"', telefono= "+telefono+" WHERE id_cliente="+id;
        
        System.out.println(SQL);
        
        //LLamado al metodo para ejecutar la consulta en este caso un update
        conexion.Ejecutar(SQL);
        
    }
    
    
    //metodo para eliminar usuarios
    public void eliminarCliente(String cedula) throws SQLException,ClassNotFoundException,InstantiationException, IllegalAccessException {
        
        
        //consulta para eliminar un cliente 
        
        String SQL="delete from Tb_cliente where cedula='"+cedula+"'";
        
        System.out.println(SQL);
        
        //LLamado al metodo para ejecutar la consulta en este caso un delete
        conexion.Ejecutar(SQL);
        
    }
    
    
    //metodo para actualizar la tabla segun las busqueda
    public  void actualizarTablaBusqueda(JTable tablaEstudiante,String buscar){
        
        int cc;
        
        ResultSet rs;
        
        //Consulta para actualizar una tabla al realizar una modificacion
        
        String SQL = "SELECT * FROM tb_cliente WHERE cedula LIKE '" + buscar + "%' OR nombre LIKE '" + buscar + "%'";

        
        try {
            
            //Llamado al metodo par ejecutar la consulta en este caso un select
            rs=conexion.Listar(SQL);
            
            
            ResultSetMetaData RSMD=rs.getMetaData();
            
            cc=RSMD.getColumnCount();
            
            DefaultTableModel DFT = (DefaultTableModel)tablaEstudiante.getModel();
            
            DFT.setRowCount(0);
            
            //ciclo para llenar la tabla
            while(rs.next()){
                
                Vector v2=new Vector();
                
                v2.add(rs.getString("id_cliente"));
                
                v2.add(rs.getString("nombre"));
                
                v2.add(rs.getString("cedula"));
                
                v2.add(rs.getString("telefono"));
                
                DFT.addRow(v2);
                
            }
            
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            
            System.out.println("ERROR " + e);
            
        }
        
        
    }
    
   
    
    
}
