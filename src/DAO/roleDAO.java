package DAO;

import METIERS.Role;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class roleDAO {
    
    public static ArrayList<Role> getAll() throws SQLException{
        ArrayList<Role> lesRoles = new ArrayList<Role>();
        Role unRole;
        ResultSet rs;
        PreparedStatement pstmt;
        JDBC jdbc = JDBC.getInstance();
        String request = "SELECT * FROM role";
        
        pstmt = jdbc.getConnexion().prepareStatement(request);
        rs = pstmt.executeQuery();
        
        while(rs.next()){
            int id = rs.getInt("id");
            String libelle = rs.getString("libelle");
            unRole = new Role (id, libelle);
            lesRoles.add(unRole);
        }
        return lesRoles;
    }
    
    
    public static Role getOneById(int id) throws SQLException{
        Role unRole = null;
        ResultSet rs = null;
        PreparedStatement pstmt;
        JDBC jdbc = JDBC.getInstance();
        
        String request = "SELECT * FROM role WHERE id = ?";
        pstmt = jdbc.getConnexion().prepareStatement(request);
        pstmt.setInt(1, id);
        rs = pstmt.executeQuery();
        if(rs.next()){
            unRole = new Role(rs.getInt("id"), rs.getString("libelle"));
        }
        return unRole;
    }
    
}
