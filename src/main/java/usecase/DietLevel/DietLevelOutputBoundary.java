package usecase.DietLevel;

public interface DietLevelOutputBoundary {

    void prepareSuccessView(DietLevelOutputData outputData);

    void prepareErrorView(DietLevelOutputData outputData);
}
