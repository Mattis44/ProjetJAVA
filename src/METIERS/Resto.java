
package METIERS;

import java.util.ArrayList;

/**
 * Classe représentant les Restaurants du site R3sto.fr
 * @author marce
 */

public class Resto {
    
    
    private int id; // identifiant du resto
    private String nom; // nom du resto
    private String numAdr; // numéro de la rue
    private String voieAdr; // nom de la rue
    private String cp; // code postal
    private String ville; // nom de la ville
    private float latitudeDeg; // coordonnées latitude
    private float longitudeDeg; // coordonnées longitude
    private String desc; // description du site web
    private String horaires; // horaire d'ouverture
    private ArrayList<Photo> lesPhotos;
    private ArrayList<Critique> lesCritiques;

    
    /**
     * Constructeur de la classe Resto
     * @param id
     * @param nom
     * @param numAdr
     * @param voieAdr
     * @param cp
     * @param ville
     * @param latitudeDeg
     * @param longitudeDeg
     * @param desc
     * @param horaires 
     */
    
    public Resto(int id, String nom, String numAdr, String voieAdr, String cp, String ville, float latitudeDeg, float longitudeDeg, String desc, String horaires) {
        this.id = id;
        this.nom = nom;
        this.numAdr = numAdr;
        this.voieAdr = voieAdr;
        this.cp = cp;
        this.ville = ville;
        this.latitudeDeg = latitudeDeg;
        this.longitudeDeg = longitudeDeg;
        this.desc = desc;
        this.horaires = horaires;
        this.lesPhotos = new ArrayList<Photo>();
        this.lesCritiques = new ArrayList<Critique>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNumAdr() {
        return numAdr;
    }

    public void setNumAdr(String numAdr) {
        this.numAdr = numAdr;
    }

    public String getVoieAdr() {
        return voieAdr;
    }

    public void setVoieAdr(String voieAdr) {
        this.voieAdr = voieAdr;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public float getLatitudeDeg() {
        return latitudeDeg;
    }

    public void setLatitudeDeg(float latitudeDeg) {
        this.latitudeDeg = latitudeDeg;
    }

    public float getLongitudeDeg() {
        return longitudeDeg;
    }

    public void setLongitudeDeg(float longitudeDeg) {
        this.longitudeDeg = longitudeDeg;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getHoraires() {
        return horaires;
    }

    public void setHoraires(String horaires) {
        this.horaires = horaires;
    }

    public ArrayList<Photo> getLesPhotos() {
        return lesPhotos;
    }

    public void setLesPhotos(ArrayList<Photo> lesPhotos) {
        this.lesPhotos = lesPhotos;
    }

    public ArrayList<Critique> getLesCritiques() {
        return lesCritiques;
    }

    public void setLesCritiques(ArrayList<Critique> lesCritiques) {
        this.lesCritiques = lesCritiques;
    }

    @Override
    public String toString() {
        return "resto{" + "id=" + id + ", nom=" + nom + ", numAdr=" + numAdr + ", voieAdr=" + voieAdr + ", cp=" + cp + ", ville=" + ville + ", latitudeDeg=" + latitudeDeg + ", longitudeDeg=" + longitudeDeg + ", desc=" + desc + ", horaires=" + horaires + ", lesPhotos=" + lesPhotos + ", lesCritiques=" + lesCritiques + '}';
    }
    
    
    
    
    
    
    
    
    
    
}
