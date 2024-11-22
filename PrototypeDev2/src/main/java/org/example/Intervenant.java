package org.example;

public class Intervenant {
    private String nomComplet;
    private String courriel;
    private String motDePasse;
    private String type;
    private String identifiantVille;

    public Intervenant(String nomComplet, String courriel, String motDePasse, String type, String identifiantVille) {
        this.nomComplet = nomComplet;
        this.courriel = courriel;
        this.motDePasse = motDePasse;
        this.type = type;
        this.identifiantVille = identifiantVille;
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

    public String getType() {
        return this.type;
    }

    public String getIdentifiantVille() {
        return this.identifiantVille;
    }
}
