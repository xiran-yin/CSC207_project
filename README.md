# CSC207_project Recipe Generator
This is a project for a recipe generator which can help the users find the recipes they want.

## Basic informations
| Name of Authors     | GitHub username                                      | Usecases                  |
|-----------|------------------------------------------------------|--------------------------------|
| EMMA YIMING CHEN | [@EmmaYimingChen](https://github.com/EmmaYimingChen) | Calories |
|     Beryl Guo    | [@GBeryl](https://github.com/GBeryl)                 | Cuisine |
|    Ruohan Wang   | [@RuohanW1](https://github.com/RuohanW1)             | Diet |
|     Xiran Yin    | [@xiran-yin](https://github.com/xiran-yin)           | Random |


### User Stories: 
- Team story – Karen needs a recipe. She runs the recipe generator program. She then chooses the recipe from one of the suggestions.[Team story]
- Karen hasn't decided what to cook today, and she is planning to use this program to help her decide what to eat.  She runs this program and gets some random recipes. She chose one of the recipes from these random recipes she likes for this meal.[Xiran’s story]
- Karen has some ingredients and wants to cook Asian food. She runs the recipe generator program with ingredient keywords and filters Asian food specifically. She gets a list of Asian foods with various calories and diet types. She chooses from the suggestions. [Beryl’s story] 
- Karen is losing weight, she wants to get foods with low fat and low carb. She runs the recipe generator program with food keywords and filters the diet level with Low-Fat and Low-Carb. She chooses from the lists. [Ruohan’s story]
- Karen is controlling her calorie intake. She runs the recipe generator program with food keywords and filters the results based on a calorie range. The program provides her with a list of recipes that fit her choices. [Emma’s story]

The team usecase is search by keywords :)

### Beryl's Story (Cuisine and Ingredient-based Filtering)
-Task: Implement the functionality for filtering Asian recipes based on ingredient keywords.
-Interactor: The Recipe Search Interactor that handles API requests.
-Controller: RecipeSearchController to manage user input (ingredients, cuisine type).
-Presenter: RecipeSearchPresenter to display the results.

-User Input Data
  These are the pieces of data that the user (Karen) provides in the search interface:
  Ingredient Keywords: A set of ingredients the user wants to search for in recipes (e.g., "chicken", "tomato", "garlic").
  Cuisine Type: The user selects a cuisine type to filter recipes by (e.g., "Asian"). This can be a dropdown menu or a set of checkboxes where users can choose one or more types.

### Xiran's Story (Random Recipe)
-Task: Implement the case when the user is not choosing anything but generating the recipe, show 5 random recipes.
-Interactor: Base on the random recipes from our API, has the method which generates 5 random recipes.
-Controller: Use the RecipeSearchInteractor to randomly generate 5 recipes.
-Presenter: use view model to display the results.

### Emma's Story (Calories)
-Task: Implement the case when the user is restricting the range of calories of the recipe.
-Interactor: Base on the recipes from our API, has the method which generates recipes with suitable calories.
-Controller: Use the RecipeSearchInteractor to generate some recipes.
-Presenter: use view model to display the results.

### Ruohan's Story (Diet)
-Task: Implement the case when the user is restricting the fat and carb of the recipe.
-Interactor: Base on the recipes from our API, has the method which generates recipes with suitable ingridients(e.g. low fat and carb).
-Controller: Use the RecipeSearchInteractor to generate some recipes.
-Presenter: use view model to display the results.



## Principles of Universal Design
Principle 1: Equitable Use
Principle 2: Flexibility in Use
Principle 3: Simple and Intuitive Use
Principle 4: Perceptible Information
Principle 5: Tolerance for Error
Principle 6: Low Physical Effort
Principle 7: Size and Space for Approach and Use

## Principle 1: Equitable Use

This application embodies the principle of **Equitable Use** by ensuring it is free for all users, regardless of their financial situation. Users can interact with the app in multiple ways, including:

1. **Keyword Search**: Ideal for users who have specific ingredients in mind or dietary needs.
2. **Filter by Diet or Cuisine**: Supports users with particular preferences or restrictions.
3. **Random Recipe Generator**: Allows users seeking inspiration or variety to find recipes easily.

These features cater to a diverse range of user needs, providing an inclusive experience that avoids discrimination or exclusion.

### Technical Implementation

To run the application:
1. Clone the repository from GitHub.
2. Open the project in an IDE (e.g., IntelliJ IDEA, Eclipse).
3. Navigate to `main.java` and click **Run**.
4. Access the graphical interface to explore recipes through various filters or options.

This simple setup ensures that users of varying technical skills can use the app effectively, promoting equitable access to its features.

### Future Improvements
To further enhance equitable use, future updates could include:
- **Accessibility Features**: Adding text-to-speech support for visually impaired users.
- **Multi-language Support**: Expanding the app's language options to reach a global audience.
- **Offline Mode**: Allowing users in areas with limited internet connectivity to access saved recipes.

