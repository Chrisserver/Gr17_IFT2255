package org.example;

public class RequeteTravail {
    private String titreTravail;
    private String descriptionDetaillee;
    private String typeTravaux;
    private String dateDebutEsperee;

    public RequeteTravail(String titreTravail, String descriptionDetaillee, String typeTravaux, String dateDebutEsperee) {
        this.titreTravail = titreTravail;
        this.descriptionDetaillee = descriptionDetaillee;
        this.typeTravaux = typeTravaux;
        this.dateDebutEsperee = dateDebutEsperee;
    }

    public String getTitreTravail() {
        return this.titreTravail;
    }

    public void setTitreTravail(String titreTravail) {
        this.titreTravail = titreTravail;
    }

    public String getDescriptionDetaillee() {
        return this.descriptionDetaillee;
    }

    public void setDescriptionDetaillee(String descriptionDetaillee) {
        this.descriptionDetaillee = descriptionDetaillee;
    }

    public String getTypeTravaux() {
        return this.typeTravaux;
    }

    public void setTypeTravaux(String typeTravaux) {
        this.typeTravaux = typeTravaux;
    }

    public String getDateDebutEsperee() {
        return this.dateDebutEsperee;
    }

    public void setDateDebutEsperee(String dateDebutEsperee) {
        this.dateDebutEsperee = dateDebutEsperee;
    }

    public void afficherRequete() {
        System.out.println("Détails de la requête de travail résidentiel:");
        System.out.println("Titre du travail: " + this.titreTravail);
        System.out.println("Description détaillée: " + this.descriptionDetaillee);
        System.out.println("Type de travaux: " + this.typeTravaux);
        System.out.println("Date de début espérée: " + this.dateDebutEsperee);
    }
}
