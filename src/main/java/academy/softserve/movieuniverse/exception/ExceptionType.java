package academy.softserve.movieuniverse.exception;

public enum ExceptionType {

    SAVE("Can't save: "), UPDATE("Can't update: "), DELETE("Can't delete "), SELECT("Can't find ");

    private String message;

    ExceptionType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
