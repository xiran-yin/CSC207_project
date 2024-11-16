import api.RecipeDataBase;
import api.getRecipeDataBase;
import entity.Recipe;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RecipeDataBaseTest {

    @Test
    public void testGetAllRecipes() throws Exception {
        // Arrange
        RecipeDataBase recipeDataBase = new getRecipeDataBase(); // Replace with your implementation
        String keyword = "fish";

        // Act
        List<Recipe> recipes = recipeDataBase.getAllRecipes(keyword, null, null, 0, 0);

        // Assert
        assertNotNull(recipes);
        assertTrue(recipes.size() > 0, "Should return a list of recipes");
        recipes.forEach(recipe -> {
            System.out.println(recipe.toString());
            assertNotNull(recipe.getLabel(), "Recipe label should not be null");
        });
    }
}
