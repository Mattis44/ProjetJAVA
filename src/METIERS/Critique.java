package METIERS;


public class Critique {
    
    private int note;
    private String commentaire;
    private Utilisateur unUtilisateur;

    public Critique(int note, String commentaire, Utilisateur unUtilisateur) {
        this.note = note;
        this.commentaire = commentaire;
        this.unUtilisateur = unUtilisateur;
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
