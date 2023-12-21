/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import java.time.LocalDate;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Connexion;

public class Employe {
    private int id;
    private String nom;
    private String prenom;
    private int idgenre;
    private Date date_naissance;
    private int idniveau_etude;

    public Employe(String string, String string1, String string2, String string3, String string4, double aDouble){}
    // Constructeur
    public Employe(int id, String nom, String prenom, int idgenre, Date dateNaissance, int idniveau_etude) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.idgenre = idgenre;
        this.date_naissance = date_naissance;
        this.idniveau_etude =idniveau_etude;
    }

    public Employe(int i, String nom, String prenom, int idgenre, LocalDate dateNaissance, int niveau) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Getters et setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getIdgenre() {
        return idgenre;
    }

    public void setIdgenre(int idgenre) {
        this.idgenre = idgenre;
    }

    public Date getDateNaissance() {
        return date_naissance;
    }

    public void setDateNaissance(Date date_naissance) {
        LocalDate dateNaissanceLocal = date_naissance.toLocalDate();
        LocalDate date18AnsPlusTard = LocalDate.now().minusYears(18);

        if (dateNaissanceLocal.isBefore(date18AnsPlusTard)) {
            this.date_naissance = date_naissance;
        } else {
            throw new IllegalArgumentException("L'employé doit avoir plus de 18 ans.");
        }
    }

    public int getIdniveauEtude() {
        return idniveau_etude;
    }

    public void setIdniveauEtude(int idniveau_etude) {
        this.idniveau_etude = idniveau_etude;
    }
    
     public static Employe insererEmploye(int id, String nom, String prenom, int idgenre, Date date_naissance, int idniveauEtude) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Connection co = Connexion.connect();
            Statement stm;
            stm = co.createStatement();
            String insertQuery = "INSERT INTO employe (id, nom, prenom, idgenre, date_naissance, idniveau_etude)  VALUES (?, ?, ?, ?, ?, ?)";
            preparedStatement = co.prepareStatement(insertQuery);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, nom);
            preparedStatement.setString(3, prenom);
            preparedStatement.setInt(4, idgenre);
            preparedStatement.setDate(5, date_naissance);
            preparedStatement.setInt(6, idniveauEtude);

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
     
     
     public static Vector<Employe> getEmploye() throws ClassNotFoundException {
        Vector<Employe> result = new Vector<>();

        try {
            Connection co = Connexion.connect();
            Statement stm = co.createStatement();
            ResultSet rs = stm.executeQuery("select * from employe");

            while (rs.next()) {
                Employe e = new Employe(
                        rs.getString("id"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("idgenre"),
                        rs.getString("date_naissance"),
                        rs.getDouble("idniveau_etude")
                );
                result.add(e);
            }

            co.close();
        } catch (SQLException ex) {
            ex.printStackTrace(); // Gérer les exceptions de manière appropriée dans votre application
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); // Gérer les exceptions de manière appropriée dans votre application
        }

        return result;
    }
       public static void main(String args[]) throws ClassNotFoundException{
       Vector<Employe> man = getEmploye() ;
       System.out.println(man.get(1).getId() + " " + man.get(3).getNom()+ " " + man.get(2).getPrenom()+ " " + man.get(4).getIdgenre() + " " + man.get(6).getDateNaissance() + " " + man.get(3).getIdniveauEtude());
   }
        
     
//    public static void main(String[] args) throws ParseException{
//        Employe emp = new Employe();
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        java.sql.Date date = null;
//        
//        java.util.Date utilDate = dateFormat.parse("2003-11-02");
//        date = new java.sql.Date(utilDate.getTime());
//
//    Employe.insererEmploye(8,"Razafindrakoto","Linda",1,date,3);
//        
//    }

    // Méthode toString pour l'affichage
//    @Override
//    public String toString() {
//        return "Employe{" +
//                "id=" + id +
//                ", nom='" + nom + '\'' +
//                ", prenom='" + prenom + '\'' +
//                ", idgenre=" + idgenre +
//                ", dateNaissance=" + dateNaissance +
//                ", idniveauEtude=" + idniveauEtude +
//                '}';
//    }
    
    
//    public static void main(String[] args) {
//        // Création d'un objet Employe
//        Employe employe = new Employe(1, "Ravelojaona", "Toky", 1, Date.valueOf("2010-01-01"), 1);
//
//        // Affichage des informations avant modification
//        System.out.println("Informations de l'employé avant modification :");
//        System.out.println(employe);
//
//        // Tentative de modification de la date de naissance
//        try {
//            employe.setDateNaissance(Date.valueOf("2009-01-01"));
//            System.out.println("Date de naissance modifiée avec succès.");
//        } catch (IllegalArgumentException e) {
//            System.out.println("Erreur : " + e.getMessage());
//        }
//
//        // Affichage des informations après modification
//        System.out.println("Informations de l'employé après modification :");
//        System.out.println(employe);
//    }
}