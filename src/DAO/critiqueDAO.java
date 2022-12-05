package DAO;

import METIERS.Critique;
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
            
            
            uneCritique = new Critique (idR, note, commentaire, unUtilisateur);
            lesCritiques.add(uneCritique);
            } 
        return lesCritiques;
        }
    
    
    
    }
    
   
    

