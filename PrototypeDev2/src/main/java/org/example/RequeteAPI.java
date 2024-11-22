package org.example;

import io.javalin.Javalin;
import io.javalin.http.Context;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class RequeteAPI {
    static String FILE_PATH = "src/main/resources/requetes.json";

    public RequeteAPI() {
    }


    static void getRequetes(Context ctx) {
        try {
            ArrayList<RequeteTravail> requetes = readRequetesFromFile();
            ctx.json(requetes);
        } catch (IOException var2) {
            ctx.status(500).result("Erreur lors de la lecture des requêtes.");
        }
    }

    static void addRequete(Context ctx) {
        try {
            RequeteTravail requete = ctx.bodyAsClass(RequeteTravail.class);
            ArrayList<RequeteTravail> requetes = readRequetesFromFile();
            requetes.add(requete);
            writeRequetesToFile(requetes);
            ctx.status(201).json(requete);
        } catch (IOException var3) {
            ctx.status(500).result("Erreur lors de l'ajout de la requête.");
        }
    }

    // Lire les requêtes depuis le fichier JSON en utilisant org.json
    static ArrayList<RequeteTravail> readRequetesFromFile() throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(FILE_PATH)));
        JSONArray jsonArray = new JSONArray(content);
        ArrayList<RequeteTravail> requetes = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            RequeteTravail requete = new RequeteTravail(
                    jsonObject.getString("titreTravail"),
                    jsonObject.getString("descriptionDetaillee"),
                    jsonObject.getString("typeTravaux"),
                    jsonObject.getString("dateDebutEsperee")
            );
            requetes.add(requete);
        }

        return requetes;
    }

    // Écrire les requêtes dans le fichier JSON en utilisant org.json
    static void writeRequetesToFile(ArrayList<RequeteTravail> requetes) throws IOException {
        JSONArray jsonArray = new JSONArray();
        for (RequeteTravail requete : requetes) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("titreTravail", requete.getTitreTravail());
            jsonObject.put("descriptionDetaillee", requete.getDescriptionDetaillee());
            jsonObject.put("typeTravaux", requete.getTypeTravaux());
            jsonObject.put("dateDebutEsperee", requete.getDateDebutEsperee());
            jsonArray.put(jsonObject);
        }

        Files.write(Paths.get(FILE_PATH), jsonArray.toString(4).getBytes());  // Formatage avec une indentation de 4
    }
}
