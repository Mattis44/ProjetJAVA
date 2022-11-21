package DAO;

import java.sql.*;

public class JDBC {

    // Instance du singleton Jdbc
    private static JDBC singleton = null;
    // Paramètre de la connexion
    private String serveurBd = "193.26.14.51:3306";
    private String nomBd = "resto";
    private String loginSgbd = "user_resto";
    private String mdpSgbd = "ziG7@l1#sAE4";
    // Connexion
    private Connection connexion = null; // java.sql.Connection

    private JDBC() {
    }

    /**
     * @param serveur : adresse du serveur + port (fini par un /, sauf pour
     * Oracle ; BD pour embarquée : chemin accès répertoire )
     * @param base : nom de la BD ou du DSN pour ODBC
     * @param login : utilisateur autorisé du SGBD (ou schéma Oracle)
     * @param mdp : son mot de passe
     */
    private JDBC(String serveur, String base, String login, String mdp) {
        this.serveurBd = serveur;
        this.nomBd = base;
        this.loginSgbd = login;
        this.mdpSgbd = mdp;
    }

    public static JDBC creer(String serveur, String base, String login, String mdp) {
        if (singleton == null) {
            singleton = new JDBC(serveur, base, login, mdp);
        }
        return singleton;
    }

    public static JDBC getInstance() {
        return singleton;
    }

    public void connecter() throws SQLException {
        connexion = DriverManager.getConnection(serveurBd + nomBd, loginSgbd, mdpSgbd);
        connexion.setAutoCommit(true);
    }

    public void deconnecter() throws SQLException {
        connexion.close();
    }

    public static java.sql.Date utilDateToSqlDate(java.util.Date uneDate) {
        return (new java.sql.Date(uneDate.getTime()));
    }

    /*
     * *************************************
     * ACCESSEURS 
     * **************************************
     */

    public String getServeurBd() {
        return serveurBd;
    }

    public void setServeurBd(String serveurBd) {
        this.serveurBd = serveurBd;
    }

    public String getNomBd() {
        return nomBd;
    }

    public void setNomBd(String nomBd) {
        this.nomBd = nomBd;
    }

    public String getLoginSgbd() {
        return loginSgbd;
    }

    public void setLoginSgbd(String loginSgbd) {
        this.loginSgbd = loginSgbd;
    }

    public String getMdpSgbd() {
        return mdpSgbd;
    }

    public void setMdpSgbd(String mdpSgbd) {
        this.mdpSgbd = mdpSgbd;
    }

    public Connection getConnexion() {
        return connexion;
    }

    public void setConnexion(Connection connexion) {
        this.connexion = connexion;
    }
}