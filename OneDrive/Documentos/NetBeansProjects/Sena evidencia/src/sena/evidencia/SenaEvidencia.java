/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sena.evidencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Stive
 */



public class SenaEvidencia {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String empleados = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3306/evidencia";
        Connection conexion;
        Statement statement;
        ResultSet rs;
        
        try {
            conexion = DriverManager.getConnection(url, empleados, password);
            statement = conexion.createStatement();
            rs = statement.executeQuery("select * from empleados");
            while(rs.next()){
                System.out.println(rs.getString("apellidopat"));
            
            }
            //insertar datos
            statement.execute("INSERT INTO `empleados` (`ID empleados`, `Nombres`, `Apellidopat`, `Apellidomat`, `teléfono`) VALUES (NULL, 'juan', 'lopez', 'lunares', '3209012343');");
            System.out.println("");
            
            rs = statement.executeQuery("select * from empleados");
            while(rs.next()){
                System.out.println(rs.getString("apellidopat"));
            
            }
          
            //actualizar datos
            
            statement.execute("UPDATE `empleados` SET `Apellidomat` = 'hernandez' WHERE `empleados`.`ID empleados` = 7;");
            System.out.println("");
            
            rs = statement.executeQuery("select * from empleados");
            while(rs.next()){
                System.out.println(rs.getString("apellidopat"));
            
            }
            
            //eliminar
            
            statement.execute("DELETE FROM empleados WHERE `empleados`.`ID empleados` = 5");
            System.out.println("");
            
            rs = statement.executeQuery("select * from empleados");
            while(rs.next()){
                System.out.println(rs.getString("apellidopat"));
            
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SenaEvidencia.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
}
