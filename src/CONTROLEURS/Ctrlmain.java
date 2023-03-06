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
            // Récupération de la liste des critiques depuis la base de données
            listMessages = DAO.critiqueDAO.getAll();
            // Affichage de la liste de critiques dans la console
            System.out.println(listMessages.toString());
            // Réinitialisation du moèdle de table
            getVue().getModeleTable().setRowCount(0);
            // Définition des titres des colonnes du modèle de table
            String[] titresColonnes = {"Utilisateur", "Restaurant", "Date", "Message", "Masquer"};
            // Définition des colonnes du modèle de table
            getVue().getModeleTable().setColumnIdentifiers(titresColonnes);
            // Initialisation du tableau de données pour chaque ligne de la table
            String[] ligneDonnees = new String[5];
            // Parcours de la liste de critiques
            for (Critique unMsg : listMessages) {
                // Ajout des données de la critique dans le tableau de données
                ligneDonnees[0] = unMsg.getUnUtilisateur().getEmail();
                ligneDonnees[1] = unMsg.getUnResto().getNom();
                ligneDonnees[2] = unMsg.getDate().toString();
                ligneDonnees[3] = unMsg.getCommentaire();
                // Si la critique est masquée, le champ "Masquer" est emplir avec "OUI"
                if (unMsg.isMasquer()) {
                    ligneDonnees[4] = "Oui";
                } else {
                    ligneDonnees[4] = "Non";
                }
                // Ajout de la ligne de données dans le modèle de table
                getVue().getModeleTable().addRow(ligneDonnees);
            }
        } catch (SQLException ex) {
            // Affichage d'un message d'erreur en cas d'exception SQL lors de la récupération des critiques depuis la base de données
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
