package METIERS;

import java.util.ArrayList;


public class Utilisateur {
    
    private int id;
    private String email;
    private String mdp;
    private String pseudo;
    private ArrayList lesRestosAimes;

    public Utilisateur(int id, String email, String mdp, String pseudo) {
        this.id = id;
        this.email = email;
        this.mdp = mdp;
        this.pseudo = pseudo;
        this.lesRestosAimes = new ArrayList();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public ArrayList getLesRestosAimes() {
        return lesRestosAimes;
    }

    public void setLesRestosAimes(ArrayList lesRestosAimes) {
        this.lesRestosAimes = lesRestosAimes;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "id=" + id + ", email=" + email + ", mdp=" + mdp + ", pseudo=" + pseudo + ", lesRestosAimes=" + lesRestosAimes + '}';
    }
    
    
    
}
