package org.example;

public class Probleme {
    private String nomResident;
    private String adresseCourriel;
    private String adresseResidence;
    private String typeProbleme;
    private String descriptionProbleme;

    public Probleme(String nomResident, String adresseCourriel, String adresseResidence, String typeProbleme, String descriptionProbleme) {
        this.nomResident = nomResident;
        this.adresseCourriel = adresseCourriel;
        this.adresseResidence = adresseResidence;
        this.typeProbleme = typeProbleme;
        this.descriptionProbleme = descriptionProbleme;
    }

    public String getNomResident() {
        return this.nomResident;
    }

    public String getAdresseCourriel() {
        return this.adresseCourriel;
    }

    public String getAdresseResidence() {
        return this.adresseResidence;
    }

    public String getTypeProbleme() {
        return this.typeProbleme;
    }

    public String getDescriptionProbleme() {
        return this.descriptionProbleme;
    }

    public void setNomResident(String nomResident) {
        this.nomResident = nomResident;
    }

    public void setAdresseCourriel(String adresseCourriel) {
        this.adresseCourriel = adresseCourriel;
    }

    public void setAdresseResidence(String adresseResidence) {
        this.adresseResidence = adresseResidence;
    }

    public void setTypeProbleme(String typeProbleme) {
        this.typeProbleme = typeProbleme;
    }

    public void setDescriptionProbleme(String descriptionProbleme) {
        this.descriptionProbleme = descriptionProbleme;
    }

    public String toString() {
        return "Problème signalé:\nNom du résident: " + this.nomResident + "\nAdresse courriel: " + this.adresseCourriel + "\nAdresse residence" + this.adresseResidence + "\ntypeProbleme" + this.typeProbleme + "\ndescriptionProbleme" + this.descriptionProbleme;
    }
}
