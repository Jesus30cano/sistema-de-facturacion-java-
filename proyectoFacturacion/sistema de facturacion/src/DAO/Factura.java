
package DAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import conexion.conexion;
import java.sql.ResultSetMetaData;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class Factura {
    conexion conexion;
    private String Cedula;
    private int id;

    public Factura(String Cedula,int id)throws ClassNotFoundException {
        this.conexion = new conexion();
        this.Cedula = Cedula;
        this.id= id;
    }

    public Factura()throws ClassNotFoundException {
        this.conexion = new conexion();
    }

    public String getCedula() {
        return Cedula;
    }

    public void setIdCliente(String idCliente) {
        this.Cedula = Cedula;
    }

    public conexion getConexion() {
        return conexion;
    }

    public void setConexion(conexion conexion) {
        this.conexion = conexion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
    public int buscarCliente(String cedula) throws ClassNotFoundException{
        ResultSet rs;
        
        int resultado = 0;
        
        String SQL = "SELECT * FROM Tb_cliente WHERE cedula = ? ";
        
        
        try {
            rs = conexion.Listar(SQL, cedula);
        
            if(rs.next()){
                
                resultado = 1;
                
                this.Cedula = rs.getString(3);
                
                
               
                 
                
            } else{
               resultado = 0;
               
            }
            
        } catch (SQLException e) {
            
            System.out.println("no se encontro el usuario" + e);
            
        } catch (InstantiationException ex) {
            Logger.getLogger(Factura.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Factura.class.getName()).log(Level.SEVERE, null, ex);
        }
 
            
            return resultado;
    }
    public void llenarTablaFactura(JTable tablaCategoria,String vali){
         int cc;
         String SQL;
        ResultSet rs;
        if(!vali.equals("")){
            SQL = "SELECT id_factura, nombre, fecha FROM tb_factura where id_factura like '"+vali+"%' or nombre like '"+vali+"%'";
        
        }else{
            SQL = "SELECT id_factura, nombre, fecha FROM tb_factura ";
        
        }
        try {
            
            rs=conexion.Listar(SQL);
            
            ResultSetMetaData RSMD=rs.getMetaData();
            
            cc = RSMD.getColumnCount();
            
            DefaultTableModel DFT = (DefaultTableModel)tablaCategoria.getModel();
            
            DFT.setRowCount(0);
            
            while(rs.next()){
                
                Vector v2=new Vector();
                
                v2.add(rs.getString("id_factura"));
                
                v2.add(rs.getString("nombre"));
                v2.add(rs.getString("fecha"));
                
                DFT.addRow(v2);
                
            }
            
            
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            
            System.out.println("ERROR " + e);
            
        }
        
    }
    
    public void mostar_factura(JTable tablaCategoria,String id,JLabel cliente,JLabel atendido,JLabel total,JLabel fecha ){
        int cc;
        
        String SQL;
        ResultSet rs;
        SQL="SELECT cantidad,nombre,precio_unitario,total FROM Tb_detalles_factura WHERE id_factura ="+id;
        try {
            
            rs=conexion.Listar(SQL);
            
            ResultSetMetaData RSMD=rs.getMetaData();
            
            cc = RSMD.getColumnCount();
            
            DefaultTableModel DFT = (DefaultTableModel)tablaCategoria.getModel();
            
            DFT.setRowCount(0);
            
            while(rs.next()){
                
                Vector v2=new Vector();
                
                v2.add(rs.getString("cantidad"));
                
                v2.add(rs.getString("nombre"));
                v2.add(rs.getString("precio_unitario"));
                v2.add(rs.getString("total"));
                
                DFT.addRow(v2);
                
            }
            
            
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            
            System.out.println("ERROR " + e);
            
        }
        SQL="select f.nombre as cliente,a.nombre as vendedor, f.total,f.fecha from tb_factura f inner join tb_admin a on f.id_admin =a.id_admin where f.id_factura ="+id;
        try {
            rs= conexion.Listar(SQL);
            if(rs.next()){
                cliente.setText(rs.getString("cliente"));
                atendido.setText(rs.getString("vendedor"));
                total.setText(rs.getString("total"));
                fecha.setText(rs.getString("fecha"));
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
        }
        
        
    }
    
    
    
    
}
