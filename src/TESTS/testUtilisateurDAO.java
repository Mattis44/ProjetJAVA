package TESTS;


import DAO.JDBC;
import METIERS.Utilisateur;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;


public class testUtilisateurDAO {
    
    public static void main(String[] args) throws NoSuchAlgorithmException{
        
        
        java.sql.Connection cnx = null;
        
        try {
            test0_Connexion();
            System.out.println("Test0 effectué : connexion\n");
            test1_getAll();
            System.out.println("Test1 effectué : sélection multiple\n");
            test2_Login("spep", "spep");
            System.out.println("Test3 effectué : Login utilisateur");
            
            
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e);
        } finally {
            try {
                if (cnx != null) {
                    cnx.close();
                }
            } catch (SQLException e) {
                System.err.println("Erreur de fermeture de la connexion JDBC : " + e);
            }
        }
        
        
        
        
    }
    
    
    
    public static void test0_Connexion() throws  SQLException {
        JDBC.creer("jdbc:mysql://193.26.14.51/", "resto", "user_resto", "ziG7@l1#sAE4");
        JDBC.getInstance().connecter();
        Connection cnx = JDBC.getInstance().getConnexion();
    }
    
    public static void test1_getAll() throws SQLException { 
        ArrayList<Utilisateur> lesUtilisateurs = DAO.utilisateurDAO.getAll();
        System.out.println("Les Utilisateurs lus : " + lesUtilisateurs.toString());
        }
    
    public static void test2_Login(String mailU, String mdpU) throws SQLException, NoSuchAlgorithmException {
        Utilisateur unUtilisateur = DAO.utilisateurDAO.getOneByLogin(mailU, mdpU);
        System.out.println("Un Login : " + unUtilisateur);
    }
    
}
