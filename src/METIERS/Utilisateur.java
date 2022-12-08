package METIERS;

import java.util.ArrayList;

/**
 * Classe représentant les utilisateurs du site R3sto.fr
 * 
 */
public class Utilisateur {
    
    private int id; // identifiant des utilisateurs
    private String email; //email de l'utilisateur
    private String mdp; // mot de passe de l'utilisateur
    private String pseudo; // pseudo de l'utilisateur
    private Role unRole; // role d'accès au information - donnée
    private ArrayList lesRestosAimes;

    /**
     * Constructeur de la 
     * @param id
     * @param email
     * @param mdp
     * @param pseudo
     * @param unRole 
     */

    public Utilisateur(int id, String email, String mdp, String pseudo, Role unRole) {
        this.id = id;
        this.email = email;
        this.mdp = mdp;
        this.pseudo = pseudo;
        this.unRole = unRole;
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

    public Role getRole() {
        return unRole;
    }

    public void setRole(Role unRole) {
        this.unRole = unRole;
    }
    
    

    public void setLesRestosAimes(ArrayList lesRestosAimes) {
        this.lesRestosAimes = lesRestosAimes;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "id=" + id + ", email=" + email + ", mdp=" + mdp + ", pseudo=" + pseudo + ", lesRestosAimes=" + lesRestosAimes + '}';
    }
    
    
    
    
    
}
