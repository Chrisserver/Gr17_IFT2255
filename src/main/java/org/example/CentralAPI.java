package org.example;

import io.javalin.Javalin;

public class CentralAPI {
    public static void main(String[] args) {
        Javalin app = Javalin.create().start(7000);  // Démarre le serveur sur le port 7000

        // Lancer l'API des utilisateurs
        app.get("/residents", UtilisateursAPI::getResidents);
        app.post("/residents", UtilisateursAPI::addResident);
        app.get("/intervenants", UtilisateursAPI::getIntervenants);
        app.post("/intervenants", UtilisateursAPI::addIntervenant);

        // Lancer l'API des requêtes
        app.get("/requetes", RequeteAPI::getRequetes);
        app.post("/requetes", RequeteAPI::addRequete);
    }
}
