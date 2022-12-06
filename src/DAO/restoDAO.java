package DAO;

import METIERS.Resto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class restoDAO {
    
    public static ArrayList<Resto> getAll() throws SQLException{
        ArrayList<Resto> lesRestos = new ArrayList<Resto>();
        Resto unResto;
        ResultSet rs;
        PreparedStatement pstmt;
        JDBC jdbc = JDBC.getInstance();
        String request = "SELECT * FROM resto";
        
        pstmt = jdbc.getConnexion().prepareStatement(request);
        rs = pstmt.executeQuery();
        
        while(rs.next()){
            int id = rs.getInt("idR");
            String nom = rs.getString("nomR");
            String numAdr = rs.getString("numAdrR");
            String voieAdr = rs.getString("voieAdrR");
            String cp = rs.getString("cpR");
            String ville = rs.getString("villeR");
            float latitudeDeg = rs.getFloat("latitudeDegR");
            float longitudeDeg = rs.getFloat("longitudeDegR");
            String desc = rs.getString("descR");
            String horaires = rs.getString("horairesR");
            unResto = new Resto (id, nom, numAdr, voieAdr, cp, ville, latitudeDeg, longitudeDeg, desc, horaires);
            lesRestos.add(unResto);
        }
        return lesRestos;
    }
    
    public static Resto getOneById(int id) throws SQLException{
        Resto unResto = null;
        ResultSet rs = null;
        PreparedStatement pstmt;
        JDBC jdbc = JDBC.getInstance();
        
        String request = "SELECT * FROM resto WHERE idR = ?";
        pstmt = jdbc.getConnexion().prepareStatement(request);
        pstmt.setInt(1, id);
        rs = pstmt.executeQuery();
        if(rs.next()){
            unResto = new Resto(rs.getInt("idR"), rs.getString("nomR"), rs.getString("numAdrR"), rs.getString("voieAdrR"), rs.getString("cpR"), rs.getString("villeR"), rs.getFloat("atitudeDegR"), rs.getFloat("longitudeDegR"), rs.getString("descR"), rs.getString("horairesR"));
        }
        return unResto;
    }
    
    
}
