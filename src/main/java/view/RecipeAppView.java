package view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

//Interface haven't implemented
import interface_adapter.recipe.RecipeController;
import interface_adapter.recipe.RecipeState;
import interface_adapter.recipe.RecipeViewModel;

/**
 * The View for a user to search suitable recipe.
 */
public class RecipeView extends JFrame {
    private JComboBox<Cuisine> cuisineComboBox;
    private JComboBox<Diet> dietComboBox;
    private JTextField caloriesTextField;
    private JTextArea resultArea;

    public RecipeView() {
        setTitle("Recipe Generator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel filterPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        filterPanel.setBorder(BorderFactory.createTitledBorder("Filter Options"));

        filterPanel.add(new JLabel("Cuisine:"));
        cuisineComboBox = new JComboBox<>(Cuisine.values());
        filterPanel.add(cuisineComboBox);

        filterPanel.add(new JLabel("Diet:"));
        dietComboBox = new JComboBox<>(Diet.values());
        filterPanel.add(dietComboBox);

        filterPanel.add(new JLabel("Calories:"));
        caloriesTextField = new JTextField();
        filterPanel.add(caloriesTextField);

        JButton generateButton = new JButton("Generate Recipe");
        filterPanel.add(generateButton);

        resultArea = new JTextArea(8, 30);
        resultArea.setEditable(false);
        resultArea.setBorder(BorderFactory.createTitledBorder("Recipe Suggestions"));

        setLayout(new BorderLayout());
        add(filterPanel, BorderLayout.NORTH);
        add(new JScrollPane(resultArea), BorderLayout.CENTER);

        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onGenerateRecipe();
            }
        });
    }

    private void onGenerateRecipe() {
        Cuisine selectedCuisine = (Cuisine) cuisineComboBox.getSelectedItem();
        Diet selectedDiet = (Diet) dietComboBox.getSelectedItem();
        int calories;

        try {
            calories = Integer.parseInt(caloriesTextField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number for calories.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String recipeResult = RecipeController.generateRecipe(selectedCuisine, selectedDiet, calories);
        resultArea.setText(recipeResult);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RecipeView view = new RecipeView();
            view.setVisible(true);
        });
    }
}

public class RecipeController {
    public static String generateRecipe(Cuisine cuisine, Diet diet, int calories) {
        return "Recipe: Spicy Tofu Stir Fry\nCuisine: " + cuisine + "\nDiet: " + diet + "\nCalories: " + calories;
    }
}
