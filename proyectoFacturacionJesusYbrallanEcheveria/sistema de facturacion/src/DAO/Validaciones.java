
package DAO;

import javax.swing.JOptionPane;




public class Validaciones {
    
    //metodo para validar el campo
    
    public String soloNumeros(String valor){
        
        //condicional para  permitir solo numeros
        
        if (!valor.matches("[0-9]*")) {
            
        JOptionPane.showMessageDialog(null, " Solo se permiten números", "ERROR", JOptionPane.ERROR_MESSAGE);
        return ""; 
        
    }
    return valor; 
            
    }
    
    public String soloLetras(String valor) {
        
        //Condicional para solo permitir letras
        
    if (!valor.matches("[a-zA-Z ]*")) {
        
        JOptionPane.showMessageDialog(null, " Solo se permiten letras", "ERROR", JOptionPane.ERROR_MESSAGE);
        
        return "";
        
    }
    
    return valor;
}
    
    public String soloLetrasNumeros(String valor) {
        
        //Condicional para solo permitir numeros y letras
        
    if (!valor.matches("[a-zA-Z0-9 ]*")) {
        
        JOptionPane.showMessageDialog(null, " Solo se permiten letras, números y espacios", "ERROR", JOptionPane.ERROR_MESSAGE);
        
        return "";
        
    }
    return valor;
}
    
    
}
