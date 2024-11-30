package usecase.keyword;

/**
 * The Input Data of the Keyword Search Use Case.
 */
public class KeywordInputData {
    private String keyword;

    public KeywordInputData(String keyword) {
        this.keyword = keyword;
    }

    public String getKeyword() {
        return keyword;
    }
}
