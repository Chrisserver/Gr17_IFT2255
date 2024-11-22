package org.example;

public class ApiResponse {
    private final int statusCode;
    private final String message;
    private final String body;

    public ApiResponse(int statusCode, String message, String body) {
        this.statusCode = statusCode;
        this.message = message;
        this.body = body;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public String getMessage() {
        return this.message;
    }

    public String getBody() {
        return this.body;
    }

    public String toString() {
        return "Status Code: " + this.statusCode + ", Message: " + this.message + ", Body: " + this.body;
    }
}
