
package DAO;


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import conexion.conexion;
import java.awt.Component;
import java.awt.HeadlessException;
import java.awt.Image;
import java.sql.PreparedStatement;
import java.awt.Toolkit;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.ResultSetMetaData;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import login.login;
import java.sql.Connection;


public class Trabajador {
    
    conexion conexion;
    
    private int id_admin, buscar_contraseña = 0, id_producto;
    private String nombre, cedula, email, password, rol;
    private long telefono;
    private Image foto;

    public Trabajador(int id_admin, String nombre, String cedula, String email, String password, String rol, long telefono,int id_producto,Image foto) throws ClassNotFoundException {
        this.conexion = new conexion();
        this.id_admin = id_admin;
        this.nombre = nombre;
        this.cedula = cedula;
        this.email = email;
        this.password = password;
        this.rol = rol;
        this.id_producto = id_producto;
        this.foto=foto;
        this.telefono = telefono;
    }
    
    
    public Trabajador() throws ClassNotFoundException{
        this.conexion = new conexion();
        
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public Image getFoto() {
        return foto;
    }

    public void setFoto(Image foto) {
        this.foto = foto;
    }


    public conexion getConexion() {
        return conexion;
    }

    public void setConexion(conexion conexion) {
        this.conexion = conexion;
    }

    public int getId_admin() {
        return id_admin;
    }

    public void setId_admin(int id_admin) {
        this.id_admin = id_admin;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public int getBuscar_contraseña() {
        return buscar_contraseña;
    }

    public void setBuscar_contraseña(int buscar_contraseña) {
        this.buscar_contraseña = buscar_contraseña;
    }
    
    
    //Metodo para el inicio de sesion
    
    public int Iniciar_sesion(String email, String password) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        
        ResultSet rs;
        
        int id_admin;
        int resultado = 0;
        
        String SQL = "SELECT id_admin FROM Tb_admin WHERE email = ? AND password = ? ";
        
        try {
            rs = conexion.Listar(SQL, email, password);
        
            if(rs.next()){
                
                login.id_admin_actual = rs.getInt("id_admin");
                
                resultado = 1;
                
                this.email = rs.getString(1);
                
                
               
                    
                
            } 
            
        } catch (SQLException e) {
            
            System.out.println("Error al iniciar sesion " + e);
            
        }
 
            
            return resultado;
        
    }
    // la parte del inventario
    
    // metodo para agregar categoria
    public int agregarCategoria(String categoria)throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        ResultSet rs;
        
        int respuesta = 0;
        
         String SQL = "SELECT * FROM Tb_categoria WHERE nombre='"+categoria+"'";
         
       
         
        try {
            
            rs = conexion.Listar(SQL);
            
            
            if(rs.next()){
                
                JOptionPane.showMessageDialog(null, "nombre ya existe");
                
                respuesta = 1;
                
                
                return respuesta;
                
            }else{
                
                 SQL = "INSERT INTO Tb_categoria (nombre)values('"+categoria+"')";
                 
                 
                conexion.Ejecutar(SQL);
                
                respuesta=0;
                
                JOptionPane.showMessageDialog(null, "categoria creada");
                
                return respuesta;
                
                
            }
        } catch (Exception e) {
            
        }
        return respuesta;
        
        
    }
    // metodo para llenar la tabla
    public void llenarTablaCategoria(JTable tablaCategoria){
         int cc;
         
        ResultSet rs;
        
        String SQL = "SELECT * FROM tb_categoria";
        
        try {
            
            rs=conexion.Listar(SQL);
            
            ResultSetMetaData RSMD=rs.getMetaData();
            
            cc = RSMD.getColumnCount();
            
            DefaultTableModel DFT = (DefaultTableModel)tablaCategoria.getModel();
            
            DFT.setRowCount(0);
            
            while(rs.next()){
                
                Vector v2=new Vector();
                
                v2.add(rs.getString("id_categoria"));
                
                v2.add(rs.getString("nombre"));
                
                DFT.addRow(v2);
                
            }
            
            
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            
            System.out.println("ERROR " + e);
            
        }
        
    }
    
    // metodo para actualizar la categoria
    public void actualizarCategoria(String id,String nombre){
        
        
        
        String SQL="UPDATE Tb_categoria SET nombre='"+nombre+"' where id_categoria="+id;
        
        try {
            
            conexion.Ejecutar(SQL);
            
           
            
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            
        }
        
    }
    
    
    // metodo para eliminar categoria
    
    public void eliminarCategoria(String id){
        
        
        String SQL = "DELETE FROM Tb_categoria WHERE id_categoria=" + id;
        
        try {
            
            conexion.Ejecutar(SQL);
            
            System.out.println(SQL);
            
        } catch (Exception e) {
            
            System.out.println("ERROR " + e);
            
        }
        
    }
    // metodo para eliminar producto
    public void eliminarProducto(String id){
        String SQL = "DELETE FROM Tb_producto WHERE id_producto=" + id;
        
        try {
            
            conexion.Ejecutar(SQL);
            
            System.out.println(SQL);
            
        } catch (Exception e) {
            
            System.out.println("ERROR " + e);
            
        }
        
    }
     // llenamos la tabla de los productos
    public void llenarTablaProducto(JTable tablaProducto){
        System.out.println("LLENAR TABLA");
        int cc;
        ResultSet rs;
        String SQL = "SELECT p.id_producto, p.nombre, p.precio, p.cantidad, c.nombre AS categoria FROM tb_producto p INNER JOIN tb_categoria c ON p.id_categoria = c.id_categoria;";
        try {
            rs = conexion.Listar(SQL);
            ResultSetMetaData RSMD=rs.getMetaData();
            
            cc=RSMD.getColumnCount();
            
            DefaultTableModel DFT = (DefaultTableModel)tablaProducto.getModel();
            
            DFT.setRowCount(0);
            
             while(rs.next()){
                
                Vector v2=new Vector();
                
                v2.add(rs.getString("id_producto"));
                
                v2.add(rs.getString("nombre"));
                
                v2.add(rs.getString("precio"));
                
                v2.add(rs.getString("cantidad"));
                
                v2.add(rs.getString("categoria"));
                
                DFT.addRow(v2);
                
            }
            
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
        }
    }
    // metodo para llenar un combobox con las categoria de la base de datos
    public void comboBox(JComboBox<String> combo){
        
        ResultSet rs;
        
        String SQL="select nombre from tb_categoria";
        try {
            combo.removeAllItems();
            rs=conexion.Listar(SQL);
            
            
            combo.addItem("Categorias...");
            while(rs.next()){
                
                combo.addItem(rs.getString(1));
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
        }
        
    }
    // metodo para filtar la tabla productos
    public void llenarTablaProductoFiltar(JTable tablaProducto ,String nombre){
        System.out.println("LLENAR TABLA");
        int cc;
        String SQL;
        ResultSet rs;
        if(nombre.equals("Categorias...")){
            SQL = "SELECT p.id_producto, p.nombre, p.precio, p.cantidad, c.nombre AS categoria FROM tb_producto p INNER JOIN tb_categoria c ON p.id_categoria = c.id_categoria;";
        
        }else{
            SQL = "SELECT p.id_producto, p.nombre, p.precio, p.cantidad, c.nombre AS categoria FROM tb_producto p INNER JOIN tb_categoria c ON p.id_categoria = c.id_categoria where c.nombre = '"+nombre+"'";
      
        }
          try {
            rs = conexion.Listar(SQL);
            ResultSetMetaData RSMD=rs.getMetaData();
            
            cc=RSMD.getColumnCount();
            
            DefaultTableModel DFT = (DefaultTableModel)tablaProducto.getModel();
            
            DFT.setRowCount(0);
            
             while(rs.next()){
                
                Vector v2=new Vector();
                
                v2.add(rs.getString("id_producto"));
                
                v2.add(rs.getString("nombre"));
                
                v2.add(rs.getString("precio"));
                
                v2.add(rs.getString("cantidad"));
                
                v2.add(rs.getString("categoria"));
                
                DFT.addRow(v2);
                
            }
            
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
        }
    }
    
    
    //Metodo para que cuando se seleccione una opcion del combo box se llene la tabla con la informacion que contenga dicha categoria
    
    public void Tabla_productos_categoria(JTable imagenesTabla, String nombre) {
    ResultSet rs;
    String SQL;

    if (nombre.equals("Categorias...")) {
        SQL = "SELECT p.id_producto, p.nombre, p.foto FROM tb_producto p "
            + "INNER JOIN Tb_categoria c ON p.id_categoria = c.id_categoria";
    } else {
        SQL = "SELECT p.id_producto, p.nombre, p.foto FROM tb_producto p "
            + "INNER JOIN Tb_categoria c ON p.id_categoria = c.id_categoria "
            + "WHERE c.nombre = '" + nombre + "'";
    }

    try {
        rs = conexion.Listar(SQL);
        System.out.println(SQL);

        DefaultTableModel DFT = new DefaultTableModel() {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 2) return Icon.class; // Imagen
                return Object.class;
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Para evitar edición directa
            }
        };

        // Columnas: ID (oculta), Nombre, Imagen
        DFT.addColumn("ID");
        DFT.addColumn("Nombre");
        DFT.addColumn("Imagen");

        while (rs.next()) {
            Vector<Object> v2 = new Vector<>();
            v2.add(rs.getString("id_producto")); // ID
            v2.add(rs.getString("nombre"));      // Nombre

            byte[] imagen = rs.getBytes("foto");
            ImageIcon icono = null;
            if (imagen != null) {
                Image img = new ImageIcon(imagen).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
                icono = new ImageIcon(img);
            }

            v2.add(icono); // Imagen
            DFT.addRow(v2);
        }

        imagenesTabla.setModel(DFT);
        imagenesTabla.setRowHeight(45);

        // Ocultar la columna de ID (columna 0)
        imagenesTabla.getColumnModel().getColumn(0).setMinWidth(0);
        imagenesTabla.getColumnModel().getColumn(0).setMaxWidth(0);
        imagenesTabla.getColumnModel().getColumn(0).setWidth(0);

    } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
        System.out.println("ERROR " + e);
    }
}

     //Metodo para restar el stock al seleccionar una cantidad de productos
     
     public void Restar_Stock(List<Object[]> productos) {
    String SQL = "UPDATE Tb_producto SET cantidad = cantidad - ? WHERE id_producto = ?";
    
    try {
        Connection con = new conexion().getConnection(); // Usamos el método que ya creaste
        PreparedStatement ps = con.prepareStatement(SQL);

        for (Object[] producto : productos) {
            int cantidad = (Integer) producto[2];
            int id_producto = (Integer) producto[4];

            ps.setInt(1, cantidad);
            ps.setInt(2, id_producto);
            ps.addBatch(); // opcional, puedes usar ps.executeUpdate() directo si prefieres
        }

        ps.executeBatch(); // ejecuta todo de una
        ps.close();
        con.close();

    } catch (ClassNotFoundException | SQLException e) {
        System.out.println("Error al restar stock: " + e.getMessage());
    }
}

     
     
     
     
     //Metodo para pagar

     public String Pagar(int id_admin, int id_cliente, double total, List<Object[]> productos) {
         
    conexion cn = null;
    
    Connection con = null;
    
    PreparedStatement psFactura = null;
    
    PreparedStatement psDetalle = null;
    
    ResultSet rsFacturaId = null;

    try {
        
        cn = new conexion();
        
        con = cn.getConnection();
        String sqlr="SELECT nombre from Tb_cliente where id_cliente ="+id_cliente;
        rsFacturaId=conexion.Listar(sqlr);
        String nombre2="";
        if(rsFacturaId.next()){
            nombre2 =rsFacturaId.getString("nombre");
        }
        

        
        String sqlFactura = "INSERT INTO Tb_factura (id_cliente, id_admin, total, fecha,nombre) VALUES (?, ?, ?, NOW(),?)";
        
        psFactura = con.prepareStatement(sqlFactura, PreparedStatement.RETURN_GENERATED_KEYS);
        
        psFactura.setInt(1, id_cliente);
        
        psFactura.setInt(2, id_admin);
        
        psFactura.setDouble(3, total);
        psFactura.setString(4, nombre2);
        
        psFactura.executeUpdate();

        rsFacturaId = psFactura.getGeneratedKeys();
        
        int id_factura = 0;

        if (rsFacturaId.next()) {
            
            id_factura = rsFacturaId.getInt(1);
            System.out.println("ID FACTURA GENERADA: " + id_factura);
            
        } else {
            
            return "Error al obtener el id de la factura";
            
        }

        
        String SQL_detalle = "INSERT INTO Tb_detalles_factura (nombre, precio_unitario, total, cantidad, id_factura, id_producto) VALUES (?, ?, ?, ?, ?, ?)";
        
        psDetalle = con.prepareStatement(SQL_detalle);

        for (Object[] producto : productos) {
            
            System.out.println("Insertando detalle: Nombre=" + producto[0] + 
                   ", Precio=" + producto[1] + 
                   ", Total=" + producto[3] + 
                   ", Cantidad=" + producto[2] + 
                   ", id_producto=" + producto[4]);
            
            
            psDetalle.setString(1, (String) producto[0]); 
            
            psDetalle.setDouble(2, (Double) producto[1]); 
            
            psDetalle.setDouble(3, (Double) producto[3]); 
            
            psDetalle.setInt(4, (Integer) producto[2]); 
            
            psDetalle.setInt(5, id_factura);     
            
            psDetalle.setInt(6, (Integer) producto[4]); 
            
            psDetalle.addBatch();
        }

        psDetalle.executeBatch();

        return "Factura registrada correctamente.";

    } catch (Exception e) {
        System.out.println(e);
        return "Error al registrar la factura: " + e.getMessage();
        
    } finally {
        
        try {
            
            if (rsFacturaId != null) rsFacturaId.close();
            
            if (psDetalle != null) psDetalle.close();
            
            if (psFactura != null) psFactura.close();
            
            if (con != null) con.close();
            
        } catch (Exception ex) {
            
            System.out.println("Error al cerrar recursos: " + ex.getMessage());
            
        }
    }
}
     
     
     
     
     public int obtenerUltimoIdFactura() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
         
    int idFactura = 0;
    
    try {
        
        ResultSet rs = conexion.Listar("SELECT MAX(id_factura) AS id FROM Tb_factura");
        
        if (rs.next()) {
            idFactura = rs.getInt("id");
            
        }
        
    } catch (Exception e) {
        
        System.out.println("Error al obtener ID de factura: " + e.getMessage());
        
    }
    
    return idFactura;
    
     }
     
     
    // metodo para filtar las busquedas en la tabla de producto
     
    public void filtarTabla(JTable tablaEstudiante,String buscar){
        int cc;
        
        ResultSet rs;
        
        //Consulta para actualizar una tabla al realizar una modificacion
        
        String SQL = "SELECT p.id_producto, p.nombre, p.precio, p.cantidad, c.nombre AS categoria FROM tb_producto p INNER JOIN tb_categoria c ON p.id_categoria = c.id_categoria WHERE p.id_producto LIKE '" + buscar + "%' OR p.nombre LIKE '" + buscar + "%'";

        
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
                
                v2.add(rs.getString("id_producto"));
                
                v2.add(rs.getString("nombre"));
                
                v2.add(rs.getString("precio"));
                
                v2.add(rs.getString("cantidad"));
                
                v2.add(rs.getString("categoria"));
                
                DFT.addRow(v2);
                
            }
            
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            
            System.out.println("ERROR " + e);
            
        }
        
    }
    
 
    
    //Metodo para guardar el producto
    
    
    
public void guardarProductoConImagen(String nombre, byte[] imagen, Double precio, int cantidad, String categoria) {
    try {
        
        
        String sqlCategoria = "SELECT id_categoria FROM tb_categoria WHERE nombre = ?";
        
        ResultSet rs = conexion.Listar(sqlCategoria, categoria);

        if (rs.next()) {
            
            int id_categoria = rs.getInt("id_categoria");

            
            
            String sql = "INSERT INTO tb_producto(nombre, foto, precio, cantidad, id_categoria) VALUES (?, ?, ?, ?, ?)";
            
            conexion.EjecutarConImagen(sql, nombre, imagen, precio, cantidad, id_categoria);

            JOptionPane.showMessageDialog(null, "Producto guardado correctamente");

        } else {
            JOptionPane.showMessageDialog(null, "Categoría no encontrada");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al guardar el producto: " + e.getMessage());
    }
    }


     public void llenarTablaImagenes(JTable imagenesTabla) {
    System.out.println("LLENAR TABLA CON IMÁGENES DESDE BLOB");
    String SQL = "SELECT id_producto,nombre, foto FROM tb_producto;";

    try {
        ResultSet rs = conexion.Listar(SQL);
        DefaultTableModel modelo = (DefaultTableModel) imagenesTabla.getModel();
        modelo.setRowCount(0); // Limpiar tabla

        while (rs.next()) {
            String id = rs.getString("id_producto");
            byte[] imagenBytes = rs.getBytes("foto");
            

            ImageIcon icono = null;

            if (imagenBytes != null && imagenBytes.length > 0) {
                Image img = Toolkit.getDefaultToolkit().createImage(imagenBytes);
                Image imagenEscalada = img.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
                icono = new ImageIcon(imagenEscalada);
            }

            modelo.addRow(new Object[]{id, icono});
        }

        imagenesTabla.setRowHeight(80);
        imagenesTabla.getColumnModel().getColumn(0).setPreferredWidth(40);
        imagenesTabla.getColumnModel().getColumn(1).setPreferredWidth(80);

        
        imagenesTabla.getColumnModel().getColumn(1).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                            boolean hasFocus, int row, int column) {
                JLabel lbl = new JLabel();
                lbl.setHorizontalAlignment(JLabel.CENTER);
                if (value instanceof ImageIcon) {
                    lbl.setIcon((ImageIcon) value);
                }
                return lbl;
            }
        });

    } catch (Exception e) {
        e.printStackTrace();
    }
}
     
     public Image mostarRuta(String id){
         ResultSet rs;
         String SQL="SELECT * FROM Tb_producto WHERE id_producto ="+id;
         try {
             rs=conexion.Listar(SQL);
             if(rs.next()){
                 String nombre= rs.getString("nombre");
                 String precio = rs.getString("precio");
                 byte [] imageBytes =rs.getBytes("foto");
                 Image foto = null;
                 if(imageBytes != null){
                     try {
                         ImageIcon imagenIcon =new ImageIcon(imageBytes);
                         foto=imagenIcon.getImage();
                         return foto;
                        
                     } catch (Exception e) {
                     }
                 }
             }
         } catch (Exception e) {
         }
        return null;
         
     }
     public void  mostarImagen( JLabel nombre,JLabel precio,JLabel fotoo){
         ResultSet rs;
         String SQL="select * from Tb_producto where id_producto = " + this.id_producto;
         try {
             rs=conexion.Listar(SQL);
             if(rs.next()){
                 nombre.setText(rs.getString("nombre"));
                 precio.setText(rs.getString("precio"));
                 Image imagen= this.foto;
                 ImageIcon originalIcon =new ImageIcon(imagen);
                 int lblwidth =fotoo.getWidth();
                 int lblheight =fotoo.getHeight();
                 Image scaledImage =originalIcon.getImage().getScaledInstance(lblwidth, lblheight, Image.SCALE_SMOOTH);
                 fotoo.setIcon(new ImageIcon(scaledImage));
             }
             else {
                 
                
             }
         } catch (Exception e) {
         }
         
     }
     public int validarCantidad(int id,String producto){
         System.out.println("id "+id+" " +producto);
         ResultSet rs;
         String SQL ="select * from Tb_producto where id_producto ="+id+"";
         int resultado=0;
         try {
             rs=conexion.Listar(SQL);
             if(rs.next()){
                 int cantidadTotal =Integer.parseInt(rs.getString("cantidad"));
                 int cantidad=Integer.parseInt(producto);
                 if(cantidad > cantidadTotal){
                     JOptionPane.showMessageDialog(null, "solo hay "+cantidadTotal+" productos en existencia porfavor ingrese otra cantidad");
                     resultado =1;
                     return resultado;
                 }else{
                     return resultado;
                 }
             }
         } catch (HeadlessException | ClassNotFoundException | IllegalAccessException | InstantiationException | NumberFormatException | SQLException e) {
         }
        return 0;
     }
     
     public void generarFactura(int id_factura) {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    String cliente = "", atendidoPor = "", fecha = "";
    double totalGeneral = 0;

    // Para guardar el PDF en el escritorio
    String rutaEscritorio = System.getProperty("user.home") + "/Desktop/";
    String archivo = rutaEscritorio + "factura_" + id_factura + ".pdf";

    try {
        // 1. Conectarse
        con = new conexion().getConnection();

        // 2. Obtener info de factura
        String sqlFactura = "SELECT f.fecha, f.nombre AS cliente, a.nombre AS admin " +
                            "FROM Tb_factura f " +
                            
                            "LEFT JOIN Tb_admin a ON f.id_admin = a.id_admin " +
                            "WHERE f.id_factura = ?";
        ps = con.prepareStatement(sqlFactura);
        ps.setInt(1, id_factura);
        rs = ps.executeQuery();
        if (rs.next()) {
            fecha = rs.getString("fecha");
            cliente = rs.getString("cliente") != null ? rs.getString("cliente") : "N/A";
            atendidoPor = rs.getString("admin") != null ? rs.getString("admin") : "N/A";
        }

        // 3. Crear documento
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(archivo));
        document.open();

        // Agregar logo
        try {
            com.itextpdf.text.Image logo = com.itextpdf.text.Image.getInstance("src/iconos/logo.png");
            logo.scaleAbsolute(80, 80); // Tamaño del logo
            logo.setAlignment(com.itextpdf.text.Element.ALIGN_LEFT);
            document.add(logo);
        } catch (Exception e) {
            System.err.println("❗ Error al cargar el logo: " + e.getMessage());
        }

        // Título
        Paragraph titulo = new Paragraph("Velocity S.A\n\n");
        titulo.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(titulo);

        // Info empresa
        Paragraph info = new Paragraph("Dirección: SENA CALLE 30\n" +
                "Correo: velocity@gmail.com | Tel:3002152461\n\n");
        info.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(info);

        // Datos cliente y vendedor
        document.add(new Paragraph("Fecha: " + fecha));
        document.add(new Paragraph("Señor(es): " + cliente));
        document.add(new Paragraph("Atendido por: " + atendidoPor));
        document.add(new Paragraph("--------------------------------------------------------------\n"));

        // Tabla productos
        PdfPTable tabla = new PdfPTable(4); // columnas
        tabla.setWidthPercentage(100);
        tabla.addCell("Cant.");
        tabla.addCell("Descripción");
        tabla.addCell("P/U");
        tabla.addCell("Total");

        String sqlProductos = "SELECT nombre, precio_unitario, cantidad FROM Tb_detalles_factura WHERE id_factura = ?";
        ps = con.prepareStatement(sqlProductos);
        ps.setInt(1, id_factura);
        rs = ps.executeQuery();
        while (rs.next()) {
            int cantidad = rs.getInt("cantidad");
            String nombre = rs.getString("nombre");
            double precio = rs.getDouble("precio_unitario");
            double total = cantidad * precio;

            tabla.addCell(String.valueOf(cantidad));
            tabla.addCell(nombre);
            tabla.addCell(String.format("$ %.2f", precio));
            tabla.addCell(String.format("$ %.2f", total));

            totalGeneral += total;
        }

        document.add(tabla);

        // Total
        document.add(new Paragraph("\nTotal General: $" + String.format("%.2f", totalGeneral)));

        // Observaciones
        document.add(new Paragraph("\nOBSERVACIONES"));
        document.add(new Paragraph("Gracias por su compra. Para más información, contáctenos."));

        // Firma
        document.add(new Paragraph("\n\n_______________________\nFirma del cliente"));

        // Servicio a domicilio
        Paragraph domicilio = new Paragraph("\n Gracias Por Su Compra ");
        domicilio.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(domicilio);

        document.close();

        JOptionPane.showMessageDialog(null, "✅ Factura generada en el escritorio");

    } catch (DocumentException | HeadlessException | FileNotFoundException | ClassNotFoundException | SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "❌ Error al generar la factura");
    }
}
     
     
   public  int agruparProductosPorId(List<Object[]> productos) {
       
    List<Object[]> agrupados = new ArrayList<>();
    int hh=0;

    for (Object[] prod : productos) {
        String nombre = (String) prod[0];
        Double precio = (Double) prod[1];
        Integer cantidad = (Integer) prod[2];
        Double total = (Double) prod[3];
        Integer id_producto = (Integer) prod[4];

        boolean encontrado = false;

        for (Object[] agr : agrupados) {
            if (((Integer) agr[4]).equals(id_producto)) {
                agr[2] = (Integer) agr[2] + cantidad;  // Sumar cantidades
                

                    
                encontrado = true;
                break;
            }
        }
        


        if (!encontrado) {
            agrupados.add(new Object[]{nombre, precio, cantidad, total, id_producto});
        }
    }
        for (Object[] agru : agrupados) {
    System.out.println(agru[0] + " " + agru[1] + " " + agru[2] + " " + agru[3] + " " + agru[4]);

    Integer id = ((Number) agru[4]).intValue();
    String cant = String.valueOf(agru[2]);

    System.out.println("id: " + id + " cant: " + cant);

    int reto = validarCantidad(id, cant);
    System.out.println("reto: " + reto);

    if (reto == 1) {
        return id;
    }
}

    

    return hh;
}
    public void editarProducto(String id,String nombre,String precio,String cantidad,String categoria){
        ResultSet rs;
        String sqlCategoria = "SELECT id_categoria FROM tb_categoria WHERE nombre = '"+categoria+"'";
        System.out.println(sqlCategoria);
        try {
            rs=conexion.Listar(sqlCategoria);
            if(rs.next()){
                int id_categoria = rs.getInt("id_categoria");
                String SQL="UPDATE Tb_producto SET nombre = '"+nombre+"' ,precio= "+precio+" ,cantidad= "+cantidad+",id_categoria ="+id_categoria;
                System.out.println(SQL);
                conexion.Ejecutar(SQL);
                JOptionPane.showMessageDialog(null, "Producto Editado con exito");
            }
        } catch (HeadlessException | ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar producto "+e);
        }
        
        
    }
    

     
     
     

    
}

