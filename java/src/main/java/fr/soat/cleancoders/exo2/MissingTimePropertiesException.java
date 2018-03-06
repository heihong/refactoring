package fr.soat.cleancoders.exo2;

public class MissingTimePropertiesException extends Exception {

    private String message;

    MissingTimePropertiesException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
