package MAIN;

import DAO.JDBC;
import METIERS.Role;
import VUES.login_frame;
import VUES.main_frame;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Game_K
 */
public class main {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JDBC.creer("jdbc:mysql://193.26.14.51/", "resto", "user_resto", "ziG7@l1#sAE4");
        try {
            JDBC.getInstance().connecter();
            // instanciation contrôleur et vue sur la liste des adresses
            login_frame vueLogin = new login_frame();
            Role r = new Role(0, "");
            main_frame vueMaint = new main_frame(r);
            // afficher la vue initiale
            vueLogin.setVisible(true);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Main - échec de connexion");
        }

    }
    
}
