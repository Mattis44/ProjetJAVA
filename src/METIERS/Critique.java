package METIERS;

public class Critique {
    
    private int note;
    private String commentaire;
    private Utilisateur unUtilisateur;
    private Resto unResto;

    public Critique(Resto unResto, int note, String commentaire, Utilisateur unUtilisateur) {
        this.note = note;
        this.commentaire = commentaire;
        this.unUtilisateur = unUtilisateur;
    }

    public Resto getUnResto() {
        return unResto;
    }

    public void setUnResto(Resto unResto) {
        this.unResto = unResto;
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
