package usecase.cuisine_type;

/**
 * The Input Data of the Cuisine Search Use Case.
 */
public class CuisineTypeInputData {
    private final String keyword;
    private final String cuisine;

    public CuisineTypeInputData(String keyword, String cuisine) {
        this.keyword = keyword;
        this.cuisine = cuisine;
    }

    public String getKeyword() {
        return keyword;
    }

    public String getCuisine() {
        return cuisine;
    }
}
