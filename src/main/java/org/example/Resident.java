package org.example;

public class Resident {
    private String nomComplet;
    private String courriel;
    private String motDePasse;
    private String dateDeNaissance;
    private String telephone;
    private String adresseResidentielle;

    public Resident(String nomComplet, String courriel, String motDePasse, String dateDeNaissance, String telephone, String adresseResidentielle) {
        this.nomComplet = nomComplet;
        this.courriel = courriel;
        this.motDePasse = motDePasse;
        this.dateDeNaissance = dateDeNaissance;
        this.telephone = telephone;
        this.adresseResidentielle = adresseResidentielle;
    }

    public String getNomComplet() {
        return this.nomComplet;
    }

    public String getCourriel() {
        return this.courriel;
    }

    public String getMotDePasse() {
        return this.motDePasse;
    }

    public String getDateDeNaissance() {
        return this.dateDeNaissance;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public String getAdresseResidentielle() {
        return this.adresseResidentielle;
    }
}
