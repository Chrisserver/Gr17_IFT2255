import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class ProjectManager {
    private ArrayList<ProjetTravaux> projets = new ArrayList<>();
    private HttpClientApi api = new HttpClientApi();
    private String ressourceIdTravaux = "cc41b532-f12d-40fb-9f55-eb58c9a2b12b";// ID du JSON contenant les travaux
    private String ressourceIdEntraves = "a2bc8014-488c-495d-941b-e7ae1999d1bd";
    private ArrayList<String> TypesTravaux = new ArrayList<>();

    // Constructeur
    public ProjectManager() {
        createProjects();
        associerEntravesProjets();
    }

    public JSONArray parseur(String ressourceId){
        ApiResponse apiResponse = api.getData(ressourceId);
        String jsonData = apiResponse.getBody();
        JSONObject root = new JSONObject(jsonData);
        return root.getJSONArray("records");
    }

    // Méthode pour parseur et créer les projets
    public void createProjects() {

        try {
            JSONArray records = parseur(ressourceIdTravaux);
            for (int i = 0; i < records.length(); i++) {
                JSONObject record = records.getJSONObject(i);

                // Extraction des données
                String titre = record.getString("reason_category")+"sur les lieux:"+record.getString("reason_category");
                String description = "Identifiant du travail:"+record.getString("currentstatus")+" Catégorie d'intervenant:"+record.getString("submittercategory")+" Nom de l'intervenant:"+record.getString("organizationname");
                String typeTravaux = record.getString("reason_category");
                if(!TypesTravaux.contains(typeTravaux)){
                    TypesTravaux.add(typeTravaux);
                }
                String quartier = record.getString("boroughid");
                String idRequest = record.getString("id");
                ArrayList<String> quartiersAffectes = new ArrayList<>();
                quartiersAffectes.add(quartier);

                String rue = record.optString("occupancy_name", "Non spécifié");
                ArrayList<String> ruesAffectees = new ArrayList<>();
                ruesAffectees.add(rue);

                String dateDebut = record.optString("duration_start_date", "Non spécifié");
                String dateFin = record.optString("duration_end_date", "Non spécifié");
                String horaireTravaux = "Non spécifié";

                // Création de l'objet ProjetTravaux
                ProjetTravaux projet = new ProjetTravaux(idRequest,titre, description, typeTravaux, quartiersAffectes, ruesAffectees, dateDebut, dateFin, horaireTravaux);

                // Ajout à la liste
                projets.add(projet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // Méthode pour afficher tous les projets
    public void afficherTousLesProjets() {
        if (projets.isEmpty()) {
            System.out.println("Aucun projet disponible.");
        } else {
            System.out.println("Liste des projets :");
            for (ProjetTravaux projet : projets) {
                System.out.println(projet);
            }
        }
    }

    public void associerEntravesProjets() {
        try {
            JSONArray entravesArray = parseur(ressourceIdEntraves);

            for (int i = 0; i < entravesArray.length(); i++) {
                JSONObject entraveJson = entravesArray.getJSONObject(i);

                // Extraction des données de l'entrave
                String idRequest = entraveJson.getString("id_request");
                String streetId = entraveJson.getString("streetid");
                String shortName = entraveJson.getString("shortname");
                String streetImpactType = entraveJson.optString("streetimpacttype", "Non spécifié");

                // Création de l'objet Entrave
                Entrave entrave = new Entrave(idRequest, streetId, shortName, streetImpactType);

                // Recherche du projet correspondant
                for (ProjetTravaux projet : projets) {
                    if (projet.getId().equals(idRequest)) {
                        // Ajout de l'entrave au projet
                        projet.ajouterEntrave(entrave);
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void addProjet(ProjetTravaux Projet){
        projets.add(Projet);
    };

    public void removeProjet(ProjetTravaux Projet){
        if(projets.contains(Projet)){
         projets.remove(Projet);}
}

    public String GenerateId() {
        // Générer un UUID aléatoire
        String uuid = UUID.randomUUID().toString();

        // Vérifier l'unicité de l'UUID par rapport aux projets existants
        for (ProjetTravaux projet : projets) {
            if (projet.getId().equals(uuid)) {
                // Si le UUID existe déjà, générer un autre
                return GenerateId();
            }
        }
        return uuid;
    }

    public ArrayList<ProjetTravaux> getProjets(){
        return projets;
    };




}
