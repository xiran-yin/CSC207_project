package app;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import interface_adapter.calories.CaloriesController;
import interface_adapter.cuisine_type.CuisineTypeController;
import interface_adapter.diet_level.DietLevelController;
import interface_adapter.keyword.KeywordController;
import interface_adapter.random.RandomController;
import view.CalorieSearchView;
import view.CuisineSearchView;
import view.DietSearchView;
import view.HomeView;
import view.KeywordSearchView;
import view.RandomSearchView;
import view.RecipeChoiceView;

/**
 * The Main Frame for your program.
 */
public class MainFrame extends JFrame {
    public static final int WIDTH1 = 800;
    public static final int HEIGHT1 = 600;
    private JPanel mainPanel;
    private CardLayout cardLayout;

    public MainFrame(KeywordController keywordController,
                     CuisineTypeController cuisineTypeController,
                     RecipeChoiceView recipeChoiceView,
                     CaloriesController caloriesController,
                     RandomController randomController,
                     DietLevelController dietLevelController) {
        setTitle("Recipe Finder");
        setSize(WIDTH1, HEIGHT1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Initialize CardLayout and Main Panel
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Set the background color.
        final Color lightGreen = new Color(102, 204, 0);
        setBackground(lightGreen);

        final HomeView homeView = new HomeView(this);

        // Add views to the main panel
        mainPanel.add(homeView, "HomeView");
        addView("KeywordSearchView", new KeywordSearchView(keywordController, this));
        addView("CuisineSearchView", new CuisineSearchView(cuisineTypeController, this));
        addView("RecipeChoiceView", recipeChoiceView);
        addView("CalorieSearchView", new CalorieSearchView(this, caloriesController));
        addView("RandomSearchView", new RandomSearchView(this, randomController));
        addView("DietSearchView", new DietSearchView(this, dietLevelController));

        // Add main panel to the frame
        add(mainPanel, BorderLayout.CENTER);

        // Start with HomeView
        showView("HomeView");

        setVisible(true);
    }

    // Method to navigate between views

    /**
     * Show each view.
     * @param viewName niew name for each view
     */
    public void showView(String viewName) {
        System.out.println("Switching to view: " + viewName);
        cardLayout.show(mainPanel, viewName);
    }

    private void addView(String viewName, JPanel view) {
        mainPanel.add(view, viewName);
    }

}
