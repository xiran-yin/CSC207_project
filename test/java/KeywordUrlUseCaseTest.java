package myproject;

import org.junit.jupiter.api.Test;
import usecase.KeyWord.KeywordUrlUseCase;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static usecase.KeyWord.KeywordUrlUseCase.GetKeywordFoods;

public class KeywordUrlUseCaseTest {

//    @Test
//    public void testGetKeywordURL() {
//        // Arrange
//        KeywordUrlUseCase useCase = new KeywordUrlUseCase();
//        String keyword = "chicken";
//
//        // Expected URL based on the input keyword and the constants in KeywordUseCase
//        String expectedUrl = "https://api.edamam.com/api/recipes/v2?type=public&q=chicken&app_id=7e6602a1&app_key=a6c9d7096dd6346a6aecc6c4bcdc3824";
//
//        // Act
//        String actualUrl = useCase.GetKeywordURL(keyword);
//
//        // Assert
//        assertEquals(expectedUrl, actualUrl, "The generated URL should match the expected URL.");
//    }

    @Test
    public void testGetKeywordRecipe() {
        KeywordUrlUseCase useCase = new KeywordUrlUseCase();
        String keyword = "chicken";
        List<String> actualFoods = GetKeywordFoods(keyword);
        List<String> expectedFoods = new ArrayList<>();
        expectedFoods.add("Shredded chicken");
        expectedFoods.add("Rotisserie Chicken Recipe");
        expectedFoods.add("Teriyaki Chicken");
        expectedFoods.add("Chicken Paprikash");
        expectedFoods.add("Baked Chicken");
        assertEquals(expectedFoods, actualFoods);

    }
}