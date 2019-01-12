package academy.softserve.movieuniverse.dto.movie;

public enum SortingFields {
    ID("id"), NAME("movieName"), YEAR("year");

    private String fieldName;

    SortingFields(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }
}
