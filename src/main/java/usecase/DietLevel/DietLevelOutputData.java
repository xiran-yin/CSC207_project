package usecase.DietLevel;

public class DietLevelOutputData {

    private final String keyword;
    private final boolean useCaseFailed;

    public DietLevelOutputData(String keyword, boolean useCaseFailed) {
        this.keyword = keyword;
        this.useCaseFailed = useCaseFailed;
    }

    public String getKeyword() { return keyword; }
    public boolean isUseCaseFailed() { return useCaseFailed; }
}
