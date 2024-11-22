package org.example;

import java.time.LocalDateTime;

public class Notification {
    private LocalDateTime date_envoi;
    private String message;

    public Notification(String message) {
        this.message = message;
        this.date_envoi = LocalDateTime.now();
    }

    public String getMessage() {
        return this.message;
    }

    public LocalDateTime getDateEnvoi() {
        return this.date_envoi;
    }

    public String toString() {
        String var10000 = this.message;
        return "Notification envoyée :\n message: " + var10000 + "\nsDate d'envoi : " + String.valueOf(this.date_envoi);
    }
}
