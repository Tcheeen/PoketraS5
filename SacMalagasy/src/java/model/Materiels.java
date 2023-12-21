/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Connexion;

/**
 *
 * @author Toky_Ravelojaona
 */
public class Materiels {

  
   private String idmateriel; 
   private String taille;
   private String matierePremiere;
   private String typeMatiere;
   private String look;
   //private double prixUnitaire;
   private int quantite;
   
   public Materiels(){}
   
     // Constructeur
   public Materiels(String idmateriel,String taille, String matierePremiere, String typeMatiere, String look,int quantite) {
       this.idmateriel = idmateriel;
       this.taille = taille;
       this.matierePremiere = matierePremiere;
       this.typeMatiere = typeMatiere;
       this.look = look;
     //  this.prixUnitaire = prixUnitaire;
       this.quantite = quantite;
   }
   
   public String getIdMateriel(){
       return idmateriel;
   }

   // Getters et Setters
   public String getTaille() {
       return taille;
   }

   public void setTaille(String taille) {
       this.taille = taille;
   }

   public String getMatierePremiere() {
       return matierePremiere;
   }

   public void setMatierePremiere(String matierePremiere) {
       this.matierePremiere = matierePremiere;
   }

   public String getType() {
       return typeMatiere;
   }

   public void setType(String typeMatiere) {
       this.typeMatiere = typeMatiere;
   }

   public String getLook() {
       return look;
   }

   public void setLook(String look) {
       this.look = look;
   }

//   public double getPrixUnitaire() {
//       return prixUnitaire;
//   }
//
//   public void setPrixUnitaire(double prixUnitaire) {
//       this.prixUnitaire = prixUnitaire;
//   }

   public int getQuantite() {
       return quantite;
   }

   public void setQuantite(int quantite) {
       this.quantite = quantite;
   }
   
    public static Materiels insererMateriels(String idmateriel,String taille,String matierePremiere, String typeMatiere, String look, int quantite) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Connection co = Connexion.connect();
            Statement stm;
            stm = co.createStatement();
            String insertQuery = "INSERT INTO entana (idmateriel, taille, matierePremiere, typeMatiere,look, quantite) VALUES (?, ?, ?, ?, ?, ?)";
            preparedStatement = co.prepareStatement(insertQuery);
            preparedStatement.setString(1, idmateriel);
            preparedStatement.setString(2, taille);
            preparedStatement.setString(3, matierePremiere);
            preparedStatement.setString(4, typeMatiere);
            preparedStatement.setString(5, look);
           // preparedStatement.setDouble(6, prixUnitaire);
            preparedStatement.setInt(6, quantite);

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
    
    public static Vector<Materiels> getMateriels() throws ClassNotFoundException{
        Vector<Materiels> result = new Vector<>();
        
        try {
            Connection co = Connexion.connect();
            Statement stm = co.createStatement();
            ResultSet rs = stm.executeQuery("select * from entana");
            while(rs.next()){
                Materiels m = new Materiels(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6));
                result.add(m);
            }
            co.close();
        } catch (SQLException ex) {
            Materiels m = new Materiels("tay","huhuohh","huhuohh2","yuea","tyb",1);
            result.add(m);
            result.add(m);
        }
        
        return result;
    }
    
     public static Vector<Materiels> getMatierePremiereLuxe() throws ClassNotFoundException {
        Vector<Materiels> result = new Vector<>();

        try {
            Connection co = Connexion.connect();
            Statement stm = co.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM entana WHERE look = 'luxe';");

            while (rs.next()) {
                Materiels m = new Materiels(
                        rs.getString("idmateriel"),
                        rs.getString("taille"),
                        rs.getString("matierepremiere"),
                        rs.getString("typematiere"),
                        rs.getString("look"),
//                        rs.getDouble("prixunitaire"),
                        rs.getInt("quantite")
                );
                result.add(m);
            }

            co.close();
        } catch (SQLException ex) {
            ex.printStackTrace(); // Gérer les exceptions de manière appropriée dans votre application
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); // Gérer les exceptions de manière appropriée dans votre application
        }

        return result;
    }
     
//      public static Vector<Materiels> getPremiereLuxe() throws ClassNotFoundException {
//        Vector<Materiels> result = new Vector<>();
//
//        try {
//            Connection co = Connexion.connect();
//            Statement stm = co.createStatement();
//            ResultSet rs = stm.executeQuery("SELECT * FROM entana WHERE look = 'luxe';");
//
//            while (rs.next()) {
//                Materiels m = new Materiels(
//                        rs.getString("idmateriel"),
//                        rs.getString("taille"),
//                        rs.getString("matierepremiere"),
//                        rs.getString("typematiere"),
//                        rs.getString("look"),
////                        rs.getDouble("prixunitaire"),
//                        rs.getInt("quantite")
//                );
//                result.add(m);
//            }
//
//            co.close();
//        } catch (SQLException ex) {
//            ex.printStackTrace(); // Gérer les exceptions de manière appropriée dans votre application
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace(); // Gérer les exceptions de manière appropriée dans votre application
//        }
//
//        return result;
//    }
      
       public static Vector<Materiels> getListeMatiereP(String matierepremiere) throws ClassNotFoundException{
        Vector<Materiels> result = new Vector<>();
        try {
            Connection co = Connexion.connect();
            Statement stm = co.createStatement();
            ResultSet rs = stm.executeQuery("select * from entana where matierepremiere = '"+ matierepremiere+"'");
            while(rs.next()){
                Materiels m = new Materiels(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6));
                result.add(m);
            }
            co.close();
        } catch (SQLException ex) {
            Materiels m= new Materiels("huhuohh","huhuohh2","safa","safas","sfaf",3);
            result.add(m);
            result.add(m);
        }
        
        return result;
    }
//    
//    public static void main(String[] args){
//        Materiels m = insererMateriels("S2","Petite","Rafia","Sacamain","Normal",2);
//        System.out.println(m);
//    }
        
//    public static void main(String args[]) throws ClassNotFoundException{
//       Vector<Materiels> man = getListeMatiereP("Cuire");
//       System.out.println(man.get(0).getTaille() + " " + man.get(0).getType()+ " " + man.get(0).getLook() + " " + man.get(0).getQuantite());
//   }
}
