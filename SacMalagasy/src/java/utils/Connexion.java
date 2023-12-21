/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;
import java.sql.*;
/**
 *
 * @author ASUS
 */

public class Connexion {
    public static Connection connect() throws SQLException, ClassNotFoundException{
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            throw ex;
        }
        Connection co = DriverManager.getConnection("jdbc:postgresql://localhost:5432/poketra","postgres","toky144");
        return co;
    }
//    public static Connection connect() throws SQLException{
//        Connection co = DriverManager.getConnection("jdbc:mysql://localhost:3306/foncier","root","root");
//        return co;
//    }

}
