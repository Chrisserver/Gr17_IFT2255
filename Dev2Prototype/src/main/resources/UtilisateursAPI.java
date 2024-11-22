package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Javalin;
import io.javalin.http.Context;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UtilisateursAPI {
    private static final String RESIDENTS_FILE_PATH = "resources/Residents.json";
    private static final String INTERVENANTS_FILE_PATH = "resources/Intervenants.json";
    private static ObjectMapper objectMapper = new ObjectMapper();

    public UtilisateursAPI() {
    }

    public static void main(String[] args) {
        Javalin app = Javalin.create().start(7002);
        app.get("/residents", UtilisateursAPI::getResidents);
        app.post("/residents", UtilisateursAPI::addResident);
        app.get("/intervenants", UtilisateursAPI::getIntervenants);
        app.post("/intervenants", UtilisateursAPI::addIntervenant);
    }

    private static void getResidents(Context ctx) {
        try {
            List<Resident> residents = readResidentsFromFile();
            ctx.json(residents);
        } catch (IOException var2) {
            ctx.status(500).result("Erreur lors de la lecture des résidents.");
        }

    }

    private static void addResident(Context ctx) {
        try {
            Resident resident = (Resident)ctx.bodyAsClass(Resident.class);
            ArrayList<Resident> residents = readResidentsFromFile();
            residents.add(resident);
            writeResidentsToFile(residents);
            ctx.status(201).json(resident);
        } catch (IOException var3) {
            ctx.status(500).result("Erreur lors de l'ajout du résident.");
        }

    }

    private static void getIntervenants(Context ctx) {
        try {
            ArrayList<Intervenant> intervenants = readIntervenantsFromFile();
            ctx.json(intervenants);
        } catch (IOException var2) {
            ctx.status(500).result("Erreur lors de la lecture des intervenants.");
        }

    }

    private static void addIntervenant(Context ctx) {
        try {
            Intervenant intervenant = (Intervenant)ctx.bodyAsClass(Intervenant.class);
            ArrayList<Intervenant> intervenants = readIntervenantsFromFile();
            intervenants.add(intervenant);
            writeIntervenantsToFile(intervenants);
            ctx.status(201).json(intervenant);
        } catch (IOException var3) {
            ctx.status(500).result("Erreur lors de l'ajout de l'intervenant.");
        }

    }

    private static ArrayList<Resident> readResidentsFromFile() throws IOException {
        return (ArrayList)objectMapper.readValue(new File("resources/Residents.json"), objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, Resident.class));
    }

    private static void writeResidentsToFile(ArrayList<Resident> residents) throws IOException {
        objectMapper.writeValue(new File("resources/Residents.json"), residents);
    }

    private static ArrayList<Intervenant> readIntervenantsFromFile() throws IOException {
        return (ArrayList)objectMapper.readValue(new File("resources/Intervenants.json"), objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, Intervenant.class));
    }

    private static void writeIntervenantsToFile(ArrayList<Intervenant> intervenants) throws IOException {
        objectMapper.writeValue(new File("resources/Intervenants.json"), intervenants);
    }
}
