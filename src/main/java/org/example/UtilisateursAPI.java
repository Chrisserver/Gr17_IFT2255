package org.example;

import org.json.JSONArray;
import org.json.JSONObject;
import io.javalin.Javalin;
import io.javalin.http.Context;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class UtilisateursAPI {
    private static final String RESIDENTS_FILE_PATH = "src/main/resources/Residents.json";
    private static final String INTERVENANTS_FILE_PATH = "src/main/resources/Intervenants.json";

    public UtilisateursAPI() {
    }

    static void getResidents(Context ctx) {
        try {
            ArrayList<Resident> residents = readResidentsFromFile();
            ctx.json(residents);
        } catch (IOException e) {
            ctx.status(500).result("Erreur lors de la lecture des résidents.");
        }
    }

    static void addResident(Context ctx) {
        try {
            Resident resident = ctx.bodyAsClass(Resident.class);
            ArrayList<Resident> residents = readResidentsFromFile();
            residents.add(resident);
            writeResidentsToFile(residents);
            ctx.status(201).json(resident);
        } catch (IOException e) {
            ctx.status(500).result("Erreur lors de l'ajout du résident.");
        }
    }

    static void getIntervenants(Context ctx) {
        try {
            ArrayList<Intervenant> intervenants = readIntervenantsFromFile();
            ctx.json(intervenants);
        } catch (IOException e) {
            ctx.status(500).result("Erreur lors de la lecture des intervenants.");
        }
    }

    static void addIntervenant(Context ctx) {
        try {
            Intervenant intervenant = ctx.bodyAsClass(Intervenant.class);
            ArrayList<Intervenant> intervenants = readIntervenantsFromFile();
            intervenants.add(intervenant);
            writeIntervenantsToFile(intervenants);
            ctx.status(201).json(intervenant);
        } catch (IOException e) {
            ctx.status(500).result("Erreur lors de l'ajout de l'intervenant.");
        }
    }

    // Lire les résidents à partir du fichier JSON
    private static ArrayList<Resident> readResidentsFromFile() throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(RESIDENTS_FILE_PATH)));
        JSONArray jsonArray = new JSONArray(content);
        ArrayList<Resident> residents = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            Resident resident = new Resident(
                    jsonObject.getString("nomComplet"),
                    jsonObject.getString("courriel"),
                    jsonObject.getString("motDePasse"),
                    jsonObject.getString("dateDeNaissance"),
                    jsonObject.getString("telephone"),
                    jsonObject.getString("adresseResidentielle")
            );
            residents.add(resident);
        }

        return residents;
    }

    // Écrire les résidents dans le fichier JSON
    private static void writeResidentsToFile(ArrayList<Resident> residents) throws IOException {
        JSONArray jsonArray = new JSONArray();
        for (Resident resident : residents) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("nomComplet", resident.getNomComplet());
            jsonObject.put("courriel", resident.getCourriel());
            jsonObject.put("motDePasse", resident.getMotDePasse());
            jsonObject.put("dateDeNaissance", resident.getDateDeNaissance());
            jsonObject.put("telephone", resident.getTelephone());
            jsonObject.put("adresseResidentielle", resident.getAdresseResidentielle());
            jsonArray.put(jsonObject);
        }

        Files.write(Paths.get(RESIDENTS_FILE_PATH), jsonArray.toString(4).getBytes());
    }

    // Lire les intervenants à partir du fichier JSON
    static ArrayList<Intervenant> readIntervenantsFromFile() throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(INTERVENANTS_FILE_PATH)));
        JSONArray jsonArray = new JSONArray(content);
        ArrayList<Intervenant> intervenants = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            Intervenant intervenant = new Intervenant(
                    jsonObject.getString("nomComplet"),
                    jsonObject.getString("courriel"),
                    jsonObject.getString("motDePasse"),
                    jsonObject.getString("type"),
                    jsonObject.getString("identifiantVille")
            );
            intervenants.add(intervenant);
        }

        return intervenants;
    }

    // Écrire les intervenants dans le fichier JSON
    private static void writeIntervenantsToFile(ArrayList<Intervenant> intervenants) throws IOException {
        JSONArray jsonArray = new JSONArray();
        for (Intervenant intervenant : intervenants) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("nomComplet", intervenant.getNomComplet());
            jsonObject.put("courriel", intervenant.getCourriel());
            jsonObject.put("motDePasse", intervenant.getMotDePasse());
            jsonObject.put("type", intervenant.getType());
            jsonObject.put("id", intervenant.getIdentifiantVille());

            jsonArray.put(jsonObject);
        }

        Files.write(Paths.get(INTERVENANTS_FILE_PATH), jsonArray.toString(4).getBytes());
    }
}
