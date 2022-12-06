package METIERS;

public class Critique {
    
    private int note;
    private String commentaire;
    private Utilisateur unUtilisateur;
    private Resto unResto;
    private boolean masquer;

    public Critique(Resto unResto, int note, String commentaire, Utilisateur unUtilisateur, boolean masquer) {
        this.unResto = unResto;
        this.note = note;
        this.commentaire = commentaire;
        this.unUtilisateur = unUtilisateur;
        this.masquer = masquer;
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
