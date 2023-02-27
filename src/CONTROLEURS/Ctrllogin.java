/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLEURS;

import VUES.login_frame;
import VUES.main_frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JOptionPane;

/**
 *
 * @author mattis
 */
public class Ctrllogin implements WindowListener, ActionListener {
 
    private login_frame vueLogin;
    private main_frame vueMain;
    
    public Ctrllogin(login_frame vue) {
        
        this.vueLogin = vueLogin;
        this.vueMain = vueMain;
        this.vueLogin.addWindowListener(this);
        this.vueMain.addWindowListener(this);
    }
    
    public void afficherLogin(){
        vueLogin.setVisible(true);
        vueMain.setVisible(false);
    }
    
    public void afficherMain(){
        vueLogin.setVisible(false);
        vueMain.setVisible(true);
    }

    private void quitterApp(){
        int rep = JOptionPane.showConfirmDialog(null, "Quitter l'application\nEtes-vous sûr(e) ?", "Resto", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (rep == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }
    
    @Override
    public void windowOpened(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void windowClosing(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void windowClosed(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void windowIconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void windowActivated(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
