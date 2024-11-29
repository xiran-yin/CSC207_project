package usecase.diet_level;

public class DietLevelInputData {
    private final String keyword;
    private final String dietLevel;

    public DietLevelInputData(String keyword, String dietLevel) {
        this.keyword = keyword;
        this.dietLevel = dietLevel;
    }

    public String getKeyword() { return keyword; }

    public String getDietLevel() { return dietLevel; }
}
