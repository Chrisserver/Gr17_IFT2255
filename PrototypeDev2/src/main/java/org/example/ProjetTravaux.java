package org.example;

import java.util.ArrayList;
import java.util.List;

public class ProjetTravaux {
    private String titre;
    private String description;
    private String typeTravaux;
    private ArrayList<String> quartiersAffectes;
    private ArrayList<String> ruesAffectees;
    private String dateDebut;
    private String dateFin;
    private String horaireTravaux;
    private String id;
    private ArrayList<Entrave> entraves;

    public ProjetTravaux(String id, String titre, String description, String typeTravaux, ArrayList<String> quartiersAffectes, ArrayList<String> ruesAffectees, String dateDebut, String dateFin, String horaireTravaux) {
        this.titre = titre;
        this.description = description;
        this.typeTravaux = typeTravaux;
        this.quartiersAffectes = quartiersAffectes;
        this.ruesAffectees = ruesAffectees;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.horaireTravaux = horaireTravaux;
        this.id = id;
        this.entraves = new ArrayList();
    }

    public String getTitre() {
        return this.titre;
    }

    public String getDescription() {
        return this.description;
    }

    public String getTypeTravaux() {
        return this.typeTravaux;
    }

    public ArrayList<String> getQuartiersAffectes() {
        return this.quartiersAffectes;
    }

    public ArrayList<String> getRuesAffectees() {
        return this.ruesAffectees;
    }

    public String getDateDebut() {
        return this.dateDebut;
    }

    public String getDateFin() {
        return this.dateFin;
    }

    public String getHoraireTravaux() {
        return this.horaireTravaux;
    }

    public String getId() {
        return this.id;
    }

    public List<Entrave> getEntraves() {
        return this.entraves;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTypeTravaux(String typeTravaux) {
        this.typeTravaux = typeTravaux;
    }

    public void setQuartiersAffectes(ArrayList<String> quartiersAffectes) {
        this.quartiersAffectes = quartiersAffectes;
    }

    public void setRuesAffectees(ArrayList<String> ruesAffectees) {
        this.ruesAffectees = ruesAffectees;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public void setHoraireTravaux(String horaireTravaux) {
        this.horaireTravaux = horaireTravaux;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void ajouterEntrave(Entrave entrave) {
        if (entrave != null) {
            this.entraves.add(entrave);
        }

    }

    public String toString() {
        String var10000 = this.titre;
        return "ProjetTravaux{titre='" + var10000 + "', description='" + this.description + "', typeTravaux='" + this.typeTravaux + "', quartiersAffectes=" + String.valueOf(this.quartiersAffectes) + ", ruesAffectees=" + String.valueOf(this.ruesAffectees) + ", dateDebut='" + this.dateDebut + "', dateFin='" + this.dateFin + "', horaireTravaux='" + this.horaireTravaux + "', id='" + this.id + "', entraves=" + String.valueOf(this.entraves) + "}";
    }
}
