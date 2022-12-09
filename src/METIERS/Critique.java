package METIERS;

import java.sql.Date;


/**
 * Classe représentant les critiques des utilisateurs du site R3sto.fr
 * 
 */

public class Critique {
    
    private int note;
    private String commentaire;
    private Utilisateur unUtilisateur;
    private Resto unResto;
    private boolean masquer;
    private Date date;

    /**
     * Constructeur avec les 4 attributs
     * @param unResto : identifiant BDD de la table resto
     * @param note
     * @param commentaire
     * @param unUtilisateur 
     */
    public Critique(Resto unResto, int note, String commentaire, Utilisateur unUtilisateur, boolean masquer, Date date) {
        this.unResto = unResto;
        this.note = note;
        this.commentaire = commentaire;
        this.unUtilisateur = unUtilisateur;
        this.masquer = masquer;
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    public Resto getUnResto() {
        return unResto;
    }

    public void setUnResto(Resto unResto) {
        this.unResto = unResto;
    }

    public boolean isMasquer() {
        return masquer;
    }

    public void setMasquer(boolean masquer) {
        this.masquer = masquer;
    }
    
    
    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Utilisateur getUnUtilisateur() {
        return unUtilisateur;
    }

    public void setUnUtilisateur(Utilisateur unUtilisateur) {
        this.unUtilisateur = unUtilisateur;
    }

    @Override
    public String toString() {
        return "Critique{" + "note=" + note + ", commentaire=" + commentaire + ", unUtilisateur=" + unUtilisateur + '}';
    }
    
    
    
}
