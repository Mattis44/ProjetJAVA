/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLEURS;

import METIERS.Critique;
import VUES.login_frame;
import VUES.main_frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author mattis
 */
public class Ctrlmain implements WindowListener, ActionListener {
 
    private main_frame vue;
    
    public Ctrlmain(main_frame vue) throws SQLException {
        this.vue = vue;
        
        this.vue.addWindowListener(this);
        
        afficherMain();
    }
    
    public final void afficherMain() throws  SQLException {
        ArrayList<Critique> listMessages = null;
        try {
            listMessages = DAO.critiqueDAO.getAll();
            System.out.println(listMessages.toString());
            getVue().getModeleTable().setRowCount(0);
            String[] titresColonnes = {"Utilisateur", "Restaurant", "Date", "Message", "Masquer"};
            getVue().getModeleTable().setColumnIdentifiers(titresColonnes);
            String[] ligneDonnees = new String[5];
            for (Critique unMsg : listMessages) {
                ligneDonnees[0] = unMsg.getUnUtilisateur().getEmail();
                ligneDonnees[1] = unMsg.getUnResto().getNom();
                ligneDonnees[2] = unMsg.getDate().toString();
                ligneDonnees[3] = unMsg.getCommentaire();
                if (unMsg.isMasquer()) {
                    ligneDonnees[4] = "Oui";
                } else {
                    ligneDonnees[4] = "Non";
                }
                getVue().getModeleTable().addRow(ligneDonnees);
            }
        } catch (SQLException ex) {
            System.out.println("Erreur DAO getAll()");
        }
    }
    
    public main_frame getVue() {
        return vue;
    }
    
    public void setVue(main_frame vue) {
        this.vue = vue;
    }

    private void quitterApp(){
        int rep = JOptionPane.showConfirmDialog(null, "Quitter l'application\nEtes-vous sûr(e) ?", "Resto", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if (rep == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }
    
    @Override
    public void windowOpened(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosing(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosed(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowIconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowActivated(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
