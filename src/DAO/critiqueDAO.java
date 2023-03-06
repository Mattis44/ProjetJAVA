package DAO;

import METIERS.Critique;
import METIERS.Resto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import METIERS.Utilisateur;
import java.sql.Date;


public class critiqueDAO {
    
    public static ArrayList<Critique> getAll(boolean is_admin) throws SQLException{
        ArrayList<Critique> lesCritiques = new ArrayList<Critique>();
        Critique uneCritique;
        ResultSet rs;
        PreparedStatement pstmt;
        JDBC jdbc = JDBC.getInstance();
        String request = "SELECT * FROM critiquer";
        
        pstmt = jdbc.getConnexion().prepareStatement(request);
        rs = pstmt.executeQuery();
        
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
    
   
    

