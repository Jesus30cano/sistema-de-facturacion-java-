
package usuarios;
import DAO.Trabajador;
import conexion.conexion;
import java.awt.Image;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import login.login;
import java.sql.ResultSet;
import java.util.List;

public final class venta extends javax.swing.JFrame {

    
    Trabajador trabajador;
    panelcliente panel_cliente;
    login login;
    conexion conexion;
    
    private int id_producto;
    private int id_cliente;

    public venta() throws ClassNotFoundException {
        
        this.id_cliente = -1;
        
        
        
        this.trabajador = new Trabajador();
        
        this.panel_cliente = new panelcliente();
        
        this.login = new login();
        
        this.conexion = new conexion();
        
        
        
        initComponents();
        
        
        iniciar_tabla();
        
        trabajador.comboBox(boxCategoria);
        String aa="Categorias...";
        trabajador.Tabla_productos_categoria(imagenesTabla, aa);
        
        
        
    }
    
    public void setId_cliente(int id_cliente){
        
        this.id_cliente = id_cliente;
        
    }

    public void iniciar_tabla(){
        
        String[] titulos = {"Nombre producto",  "Precio", "Cantidad", "Total", "Id productos","N"};
        DefaultTableModel tabla = new DefaultTableModel(null, titulos);
        tabla_productos.setModel(tabla);
        
        tabla_productos.getColumnModel().getColumn(4).setMinWidth(0);
        tabla_productos.getColumnModel().getColumn(4).setMaxWidth(0);
        tabla_productos.getColumnModel().getColumn(4).setWidth(0);
        tabla_productos.getColumnModel().getColumn(5).setMinWidth(0);
        tabla_productos.getColumnModel().getColumn(5).setMaxWidth(0);
        tabla_productos.getColumnModel().getColumn(5).setWidth(0);
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jColorChooser1 = new javax.swing.JColorChooser();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btSalir = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        imagenesTabla = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        Bt_pagar = new javax.swing.JButton();
        boxCategoria = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_productos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                formComponentMoved(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(850, 650));

        jPanel2.setBackground(new java.awt.Color(51, 0, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/logo.png"))); // NOI18N

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("\"Este software es propiedad ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("de SolutionsJB.SA");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Todos los derechos reservados.");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Ventas");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/ventas.png"))); // NOI18N
        jLabel9.setText("jLabel9");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel8))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 216, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(22, 22, 22))
        );

        btSalir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btSalir.setText("Menu");
        btSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalirActionPerformed(evt);
            }
        });

        imagenesTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Imagen"
            }
        ));
        imagenesTabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imagenesTablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(imagenesTabla);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("productos");

        Bt_pagar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Bt_pagar.setText("Pagar");
        Bt_pagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bt_pagarActionPerformed(evt);
            }
        });

        boxCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Categorias..." }));
        boxCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxCategoriaActionPerformed(evt);
            }
        });

        tabla_productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabla_productos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_productosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabla_productos);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Bt_pagar)
                .addGap(84, 84, 84))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addComponent(jLabel6))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(boxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(boxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                        .addComponent(Bt_pagar)
                        .addGap(39, 39, 39))))
        );

        jTabbedPane1.addTab("Ventas", jPanel3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btSalir))
                    .addComponent(jTabbedPane1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btSalir)
                .addGap(4, 4, 4)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_formComponentMoved

    private void btSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalirActionPerformed
        menu menu=new menu();
        menu.setVisible(true);
        menu.setLocationRelativeTo(null);
        dispose();
        
    }//GEN-LAST:event_btSalirActionPerformed

    private void imagenesTablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imagenesTablaMouseClicked
        
        int fila=imagenesTabla.getSelectedRow();
        if(fila>=0){
            String idString= imagenesTabla.getValueAt(fila, 0).toString();
            int id = Integer.parseInt(idString);
            System.out.println("este panel venta "+id);
            
            Image imagen= trabajador.mostarRuta(idString);
            trabajador.setFoto(imagen);
            id_producto = id;
            trabajador.setId_producto(id);
            
            panelProducto panel;
            
            try {
                System.out.println("este id producto"+id_producto);
                panel = new panelProducto(trabajador, id_producto, this);
                 panel.setVisible(true);
                 panel.setLocationRelativeTo(null);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(venta.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
    }//GEN-LAST:event_imagenesTablaMouseClicked

     
    public void agregarProducto(String nombre, double precio, int cantidad, double total, int id_producto) {
        
        
    DefaultTableModel tabla = (DefaultTableModel) tabla_productos.getModel();
    int numero = tabla.getRowCount() + 1;
    
        
         Object[] fila = {nombre, precio, cantidad, total, id_producto,numero};
         tabla.addRow(fila);
         
         tabla_productos.setModel(tabla);
         
         
         
    }
    public void eliminarProductoPorId(int id_producto) {
    DefaultTableModel tabla = (DefaultTableModel) tabla_productos.getModel();

    for (int i = 0; i < tabla.getRowCount(); i++) {
        int idEnTabla = (int) tabla.getValueAt(i, 5); // la columna 4 es la del id_producto
        if (idEnTabla == id_producto) {
            tabla.removeRow(i);
            break; // sale después de eliminar el primero que encuentre
        }
    }

    tabla_productos.setModel(tabla);
}

    
    
    
    private void boxCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxCategoriaActionPerformed
       
 if (boxCategoria.getSelectedItem() != null) {
    String nombre = boxCategoria.getSelectedItem().toString();
    trabajador.Tabla_productos_categoria(imagenesTabla, nombre);
    // ... usar la selección
} else {
    System.out.println("No hay ningún ítem seleccionado en el comboBox.");
}
        
        
        
        
        
    }//GEN-LAST:event_boxCategoriaActionPerformed

    private void Bt_pagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bt_pagarActionPerformed
        
        
        
        int id_admin = login.id_admin_actual;
        System.out.println("este es el id del admin "+id_admin);
        
        
        
         try {
       
        conexion con = new conexion();
        Connection cn = con.getConnection();

         
        if(id_cliente == -1){
            
            JOptionPane.showMessageDialog(null, "Cliente no encontrado");
            return;
        }
        
        
             
             
        DefaultTableModel tabla = (DefaultTableModel) tabla_productos.getModel();
        
        
        List<Object[]> productos = new ArrayList<>();

        double total_factura = 0.0;

        
        for (int i = 0; i < tabla.getRowCount(); i++) {
            
            String nombre = tabla.getValueAt(i, 0).toString();
            
            String text_precio = tabla.getValueAt(i, 1).toString().replace(",", "");
            double precio_unidad = Double.parseDouble(text_precio);
            
            int cantidad = Integer.parseInt(tabla.getValueAt(i, 2).toString());
            
            String text_total = tabla.getValueAt(i, 3).toString().replace(",", "");
            double total = Double.parseDouble(text_total);
            
            id_producto = Integer.parseInt(tabla.getValueAt(i, 4).toString());

            productos.add(new Object[]{nombre, precio_unidad, cantidad, total, id_producto});
            
            total_factura += total;
            
        }

        
            tabla_productos.getColumnModel().getColumn(4).setMinWidth(0);
            tabla_productos.getColumnModel().getColumn(4).setMaxWidth(0);
            tabla_productos.getColumnModel().getColumn(4).setWidth(0);
            
            
        if (productos.isEmpty()) {
            
            JOptionPane.showMessageDialog(null, "No hay productos en la compra");
            
            return;
        }

        
     int gg=trabajador.agruparProductosPorId(productos);
     if(gg!=0){
         JOptionPane.showMessageDialog(null, "el producto con id "+gg+ " supera la existencia porfavor eliminar articulo");
         return;
     }
        
        String mensaje = trabajador.Pagar(id_admin, id_cliente, total_factura, productos);
        trabajador.Restar_Stock(productos);
        

        
        JOptionPane.showMessageDialog(null, mensaje);
        if(mensaje.equals("Factura registrada correctamente.")){
            int opcionFactura = JOptionPane.showConfirmDialog(null,"Factura registrada exitosamente.\n¿Desea imprimirla?","Impresión de Factura",JOptionPane.YES_NO_OPTION);

            System.out.println(opcionFactura);
            if(opcionFactura==0){
                int idUltimaFactura = trabajador.obtenerUltimoIdFactura();
                trabajador.generarFactura(idUltimaFactura);
                
            }
        }

        
        
        if (mensaje.toLowerCase().contains("correctamente")) {
            
            tabla.setRowCount(0);
        }

        
        
    } catch (Exception e) {
        
        e.printStackTrace();
        
        JOptionPane.showMessageDialog(null, "Error al realizar el pago: " + e.getMessage());
    }
        
    }//GEN-LAST:event_Bt_pagarActionPerformed

    private void tabla_productosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_productosMouseClicked
        int fila=tabla_productos.getSelectedRow();
        int mensajeEliminar = JOptionPane.showConfirmDialog(null, "Quiere Eliminar El Producto?", "Eliminar", JOptionPane.YES_NO_OPTION);
        if(mensajeEliminar==0){
            if(fila>=0){
                System.out.println("aca");
            String idString= tabla_productos.getValueAt(fila, 5).toString();
            System.out.println("este el id del producto33 "+idString);
            int id = Integer.parseInt(idString);
            System.out.println("este el id del producto "+id);
            eliminarProductoPorId(id);
           
        }
        }
        
    }//GEN-LAST:event_tabla_productosMouseClicked

  
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new venta().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(venta.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bt_pagar;
    public javax.swing.JComboBox<String> boxCategoria;
    private javax.swing.JButton btSalir;
    public javax.swing.JTable imagenesTabla;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    public javax.swing.JTable tabla_productos;
    // End of variables declaration//GEN-END:variables
}
