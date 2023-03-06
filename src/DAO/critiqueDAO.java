package DAO;

import METIERS.Critique;
import METIERS.Resto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import METIERS.Utilisateur;
import java.sql.Date;



/**
 * Récupère toutes les critiques depuis la base de données triées par date décroissante
 * retourne une liste de critiques tiées par date décroissante.
 * @throws SQLException en cas d'erreur lors de la communication avec la base de données.
 * @author marce
 */
public class critiqueDAO {
    
    public static ArrayList<Critique> getAll() throws SQLException{
        ArrayList<Critique> lesCritiques = new ArrayList<Critique>();  // Initialisation de la liste de critiques à retourner
        Critique uneCritique; // Variable temporaire pour stocker chaque critique
        ResultSet rs; // Variable pour stocker le résultat de la requête SQL
        PreparedStatement pstmt; // Requête SQL précompilée
        JDBC jdbc = JDBC.getInstance(); // Connection à la base de données
        String request = "SELECT * FROM critiquer ORDER BY critiquer.date DESC";
        
        pstmt = jdbc.getConnexion().prepareStatement(request);
        rs = pstmt.executeQuery();
        // Parcours du résultat et création d'un objet Critique pour chaque ligne
        while(rs.next()){
            int idR = rs.getInt("idR");
            int note = rs.getInt("note");
            String commentaire = rs.getString("commentaire");
            int idU = rs.getInt("idU");
            boolean masquer = rs.getBoolean("masquer");
            Date date = rs.getDate("date");
            
            // Creating Utilisateur object
            
            Utilisateur unUtilisateur = DAO.utilisateurDAO.getOneById(idU);
            Resto unResto = DAO.restoDAO.getOneById(idR);
            
            uneCritique = new Critique (unResto, note, commentaire, unUtilisateur, masquer, date);
            if (is_admin) {
                lesCritiques.add(uneCritique);
            } else {
                if (!masquer) {
                    lesCritiques.add(uneCritique);
                }
            }
            
        } 
        return lesCritiques;
    }
    
    public static void setMasquerById(int idR, int idU, int value) throws SQLException{
        PreparedStatement pstmt;
        JDBC jdbc = JDBC.getInstance();
        
       String request = "UPDATE critiquer SET masquer = ? WHERE idR = ? AND idU = ?";
       pstmt = jdbc.getConnexion().prepareStatement(request);
        pstmt.setInt(1, value);
        pstmt.setInt(2, idR);
        pstmt.setInt(3, idU);
        pstmt.executeUpdate();
    }
    
    public static Critique getOneByIdUAndIdR(int idU, int idR) throws SQLException{
        Critique uneCritique = null;
        ResultSet rs = null;
        PreparedStatement pstmt;
        JDBC jdbc = JDBC.getInstance();
        
        String request = "SELECT * FROM critique WHERE idR = ? AND idU = ?";
        pstmt = jdbc.getConnexion().prepareStatement(request);
        pstmt.setInt(1, idU);
        pstmt.setInt(2, idR);
        rs = pstmt.executeQuery();
        if(rs.next()){
            uneCritique = new Critique(DAO.restoDAO.getOneById(rs.getInt("idR")), rs.getInt("note"), rs.getString("commentaire"), DAO.utilisateurDAO.getOneById(rs.getInt("idU")), rs.getBoolean("masquer"), rs.getDate("date"));
        }
        return uneCritique;
    }

    public static void setMasquerById(int id, int id0, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    
    
    }
    
   
    

