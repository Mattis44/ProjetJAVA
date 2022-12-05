/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import METIERS.Utilisateur;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author mattis
 */
public class utilisateurDAO {
    
    private int id;
    private String mail;
    private String password;
    private String pseudo;
    private int Role;
    
    public static ArrayList<Utilisateur> getAll() throws SQLException{
        ArrayList<Utilisateur> lesUtilisateurs = new ArrayList<Utilisateur>();
        Utilisateur unUtilisateur;
        ResultSet rs;
        PreparedStatement pstmt;
        JDBC jdbc = JDBC.getInstance();
        String request = "SELECT * FROM utilisateur";
        
        pstmt = jdbc.getConnexion().prepareStatement(request);
        rs = pstmt.executeQuery();
        
        while(rs.next()){
            int id = rs.getInt("idU");
            String mail = rs.getString("mailU");
            String mdp = rs.getString("mdpU");
            String pseudo = rs.getString("pseudoU");
            int role = rs.getInt("roleU");
            unUtilisateur = new Utilisateur (id, mail, mdp, pseudo, role);
            lesUtilisateurs.add(unUtilisateur);
        }
        return lesUtilisateurs;        
    }
    
    
    public static Utilisateur getOneById(int id) throws SQLException{
        Utilisateur unUtilisateur = null;
        ResultSet rs = null;
        PreparedStatement pstmt;
        JDBC jdbc = JDBC.getInstance();
        
        String request = "SELECT * FROM utilisateur WHERE idU = ?";
        pstmt = jdbc.getConnexion().prepareStatement(request);
        pstmt.setInt(1, id);
        rs = pstmt.executeQuery();
        if(rs.next()){
            unUtilisateur = new Utilisateur(rs.getInt("idU"), rs.getString("mailU"), rs.getString("mdpU"), rs.getString("pseudoU"), rs.getInt("roleU"));
        }
        return unUtilisateur;
    }
    
    public static Utilisateur getOneByLogin(String mailU, String mdpU) throws SQLException, NoSuchAlgorithmException{
        
        Utilisateur unUtilisateur = null;
        ResultSet rs = null;
        PreparedStatement pstmt;
        JDBC jdbc = JDBC.getInstance();
        
        
        String request = "SELECT * FROM utilisateur WHERE mailU = ? AND mdpU = ?";
        pstmt = jdbc.getConnexion().prepareStatement(request);
        pstmt.setString(1, mailU);
        pstmt.setString(2, getHash(mdpU).toString());
        
        rs = pstmt.executeQuery();
        if(rs.next()){
            unUtilisateur = new Utilisateur(rs.getInt("idU"), rs.getString("mailU"), rs.getString("mdpU"), rs.getString("pseudoU"), rs.getInt("roleU"));
        }
        return unUtilisateur;
    }
    
    public static String getHash(String text) throws NoSuchAlgorithmException{
        
        MessageDigest crypt = MessageDigest.getInstance("SHA-256");
        crypt.update(text.getBytes(StandardCharsets.UTF_8));
        byte[] bytes = crypt.digest();
        BigInteger bi = new BigInteger(1, bytes);
        String digest = String.format("%0" + (bytes.length << 1) + "x", bi);
        
        System.out.println(digest);
        
        return digest;
    }
}
