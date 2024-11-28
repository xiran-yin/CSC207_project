//package view;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionListener;
//
//public class HomeViewBuilder {
//    private final MainFrame mainFrame;
//    private BoxLayout layout;
//    private Color backgroundColor;
//    private JButton randomRecipeButton;
//    private JButton keywordSearchButton;
//    private JButton cuisineSearchButton;
//    private JButton dietSearchButton;
//    private JButton calorieSearchButton;
//
//    public HomeViewBuilder(MainFrame mainFrame) {
//        this.mainFrame = mainFrame;
//        this.layout = new BoxLayout(new JPanel(), BoxLayout.Y_AXIS); // default layout
//        this.backgroundColor = Color.WHITE; // default background color
//    }
//
//    public HomeViewBuilder setLayout(BoxLayout layout) {
//        this.layout = layout;
//        return this;
//    }
//
//    public HomeViewBuilder setBackgroundColor(Color backgroundColor) {
//        this.backgroundColor = backgroundColor;
//        return this;
//    }
//
//    public HomeViewBuilder addRandomRecipeButton(ActionListener actionListener) {
//        this.randomRecipeButton = createStyledButton("Random Recipe", actionListener);
//        return this;
//    }
//
//    public HomeViewBuilder addKeywordSearchButton(ActionListener actionListener) {
//        this.keywordSearchButton = createStyledButton("Search by Keyword", actionListener);
//        return this;
//    }
//
//    public HomeViewBuilder addCuisineSearchButton(ActionListener actionListener) {
//        this.cuisineSearchButton = createStyledButton("Search by Cuisine Type", actionListener);
//        return this;
//    }
//
//    public HomeViewBuilder addDietSearchButton(ActionListener actionListener) {
//        this.dietSearchButton = createStyledButton("Search by Diet Label", actionListener);
//        return this;
//    }
//
//    public HomeViewBuilder addCalorieSearchButton(ActionListener actionListener) {
//        this.calorieSearchButton = createStyledButton("Search by Calories", actionListener);
//        return this;
//    }
//
//    public HomeView build() {
//        HomeView homeView = new HomeView(mainFrame);
//        homeView.setLayout(layout);
//        homeView.setBackground(backgroundColor);
//
//        // Add buttons to home view
//        homeView.add(randomRecipeButton);
//        homeView.add(Box.createVerticalStrut(20));
//        homeView.add(keywordSearchButton);
//        homeView.add(Box.createVerticalStrut(20));
//        homeView.add(cuisineSearchButton);
//        homeView.add(Box.createVerticalStrut(20));
//        homeView.add(dietSearchButton);
//        homeView.add(Box.createVerticalStrut(20));
//        homeView.add(calorieSearchButton);
//
//        return homeView;
//    }
//
//    private JButton createStyledButton(String text, ActionListener actionListener) {
//        JButton button = new JButton(text);
//        button.setAlignmentX(Component.CENTER_ALIGNMENT);
//        button.setBackground(new Color(102, 204, 0));
//        button.setPreferredSize(new Dimension(400, 65));
//        button.setMaximumSize(new Dimension(400, 65));
//        button.setOpaque(true);
//        button.setBorderPainted(false);
//        button.setForeground(Color.WHITE);
//        button.setFont(new Font("Arial", Font.BOLD, 20));
//        button.addActionListener(actionListener);
//        return button;
//    }
//}