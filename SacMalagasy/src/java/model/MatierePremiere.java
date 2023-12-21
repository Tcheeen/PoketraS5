/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Connexion;

/**
 *
 * @author Toky_Ravelojaona
 */
public class MatierePremiere {
   private String idmatiere;
   private String nommatiere;
   private int quantitematiere;
   private double prix;
    
     // Constructeur par défaut
    public MatierePremiere() {
    }

    // Constructeur avec paramètres
    public MatierePremiere(String idmatiere, String nommatiere, int quantitematiere, double prix) {
        this.idmatiere = idmatiere;
        this.nommatiere = nommatiere;
        this.quantitematiere = quantitematiere;
        this.prix = prix;
    }
    
     public String getIdmatiere() {
        return idmatiere;
    }

    public void setIdmatiere(String idmatiere) {
        this.idmatiere = idmatiere;
    }

    public String getNommatiere() {
        return nommatiere;
    }

    public void setNommatiere(String nommatiere) {
        this.nommatiere = nommatiere;
    }

    public int getQuantiteMatiere() {
        return quantitematiere;
    }

    public void setQunatiteMatiere(int quantitematiere) {
        this.quantitematiere = quantitematiere;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
    
     public static MatierePremiere insererMatierePremiere(String idmatiere, String nommatiere, int quantitematiere, double prix) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Connection co = Connexion.connect();
            Statement stm;
            stm = co.createStatement();
            String insertQuery = "INSERT INTO  matierepremiere (idmatiere, nommatiere, quantitematiere, prix) VALUES (?, ?, ?, ?)";
            preparedStatement = co.prepareStatement(insertQuery);
            preparedStatement.setString(1, idmatiere);
            preparedStatement.setString(2, nommatiere);
            preparedStatement.setInt(3, quantitematiere);
            preparedStatement.setDouble(4, prix);

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            // Gérer les erreurs
        } catch (ClassNotFoundException ex) {
           Logger.getLogger(Materiels.class.getName()).log(Level.SEVERE, null, ex);
       } finally {
            // Fermer la connexion et les ressources
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // Gérer les erreurs de fermeture
            }
        }
        return null;
    }
     
//       public static void main(String[] args){
//       MatierePremiere m = insererMatierePremiere("M2","Raphia",11,100.90);
//        System.out.println(m);
//   }
}
