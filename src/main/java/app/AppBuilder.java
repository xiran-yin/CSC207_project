package app;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class AppBuilder {

    private final JPanel cardPanel = new JPanel();
    private final CardLayout cardLayout = new CardLayout();

    private HomeView homeView;
    private RandomRecipeView randomRecipeView;
    private RecipeDetailView recipeDetailView;
    private SearchResultView searchResultView;

    public JFrame build() {
        final JFrame application = new JFrame("Recipes Generator");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        application.add(cardPanel);

        viewManagerModel.setState(signupView.getViewName());
        viewManagerModel.firePropertyChanged();

        return application;
    }
}