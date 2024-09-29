package src;

import java.time.LocalDate;
import java.util.List;

public class ProjetTravaux {
    private String titre;
    private String description;
    private String typeTravaux;
    private List<String> quartiersAffectes;
    private List<String> ruesAffectees;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private String horaireTravaux;

    public ProjetTravaux(String titre, String description, String typeTravaux, List<String> quartiersAffectes, List<String> ruesAffectees, LocalDate dateDebut, LocalDate dateFin, String horaireTravaux) {
        this.titre = titre;
        this.description = description;
        this.typeTravaux = typeTravaux;
        this.quartiersAffectes = quartiersAffectes;
        this.ruesAffectees = ruesAffectees;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.horaireTravaux = horaireTravaux;
    }

    // Getters
    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }

    public String getTypeTravaux() {
        return typeTravaux;
    }

    public List<String> getQuartiersAffectes() {
        return quartiersAffectes;
    }

    public List<String> getRuesAffectees() {
        return ruesAffectees;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public String getHoraireTravaux() {
        return horaireTravaux;
    }

    // Setters
    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTypeTravaux(String typeTravaux) {
        this.typeTravaux = typeTravaux;
    }

    public void setQuartiersAffectes(List<String> quartiersAffectes) {
        this.quartiersAffectes = quartiersAffectes;
    }

    public void setRuesAffectees(List<String> ruesAffectees) {
        this.ruesAffectees = ruesAffectees;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public void setHoraireTravaux(String horaireTravaux) {
        this.horaireTravaux = horaireTravaux;
    }
}
