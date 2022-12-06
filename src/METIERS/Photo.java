package METIERS;

/**
 * Classe représentant les Photos des restaurants
 * @author marce
 */

public class Photo {
    
    private int id;  // numéro d'identification de la photo
    private String chemin; // nom du fichier avec l'extension

    public Photo(int id, String chemin) {
        this.id = id;
        this.chemin = chemin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChemin() {
        return chemin;
    }

    public void setChemin(String chemin) {
        this.chemin = chemin;
    }

    @Override
    public String toString() {
        return "Photo{" + "id=" + id + ", chemin=" + chemin + '}';
    }
    
    
    
    
    
}
