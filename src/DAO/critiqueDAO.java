package DAO;

import METIERS.Critique;
import METIERS.Resto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import METIERS.Utilisateur;


public class critiqueDAO {
    
    public static ArrayList<Critique> getAll() throws SQLException{
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
            
            // Creating Utilisateur object
            
            Utilisateur unUtilisateur = DAO.utilisateurDAO.getOneById(idU);
            Resto unResto = DAO.restoDAO.getOneById(idR);
            
            uneCritique = new Critique (unResto, note, commentaire, unUtilisateur);
            lesCritiques.add(uneCritique);
            } 
        return lesCritiques;
        }
    
    
    public static Critique getOneByIdR(int id) throws SQLException{
        Critique uneCritique = null;
        ResultSet rs = null;
        PreparedStatement pstmt;
        JDBC jdbc = JDBC.getInstance();
        
        String request = "SELECT * FROM critique WHERE idR = ?";
        pstmt = jdbc.getConnexion().prepareStatement(request);
        pstmt.setInt(1, id);
        rs = pstmt.executeQuery();
        if(rs.next()){
            uneCritique = new Critique(DAO.restoDAO.getOneById(rs.getInt("idR")), rs.getInt("note"), rs.getString("commentaire"), DAO.utilisateurDAO.getOneById(rs.getInt("idU")));
        }
        return uneCritique;
    }
    
    
    }
    
   
    

