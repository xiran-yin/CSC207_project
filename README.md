# CSC207_project

## Basic informations
| name      | GitHub username                                      | Usecases                  |
|-----------|------------------------------------------------------|--------------------------------|
| EMMA YIMING CHEN | [@EmmaYimingChen](https://github.com/EmmaYimingChen) | Calories |
|     Beryl Guo    | [@GBeryl](https://github.com/GBeryl)                 | Cuisine |
|    Ruohan Wang   | [@RuohanW1](https://github.com/RuohanW1)             | Diet |
|     Xiran Yin    | [@xiran-yin](https://github.com/xiran-yin)           | Random |


User Stories: 
- Team story – Karen needs a recipe. She runs the recipe generator program. She then chooses the recipe from one of the suggestions.[Team story]
- Karen hasn't decided what to cook today, and she is planning to use this program to help her decide what to eat.  She runs this program and gets some random recipes. She chose one of the recipes from these random recipes she likes for this meal.[Xiran’s story]
- Karen has some ingredients and wants to cook Asian food. She runs the recipe generator program with ingredient keywords and filters Asian food specifically. She gets a list of Asian foods with various calories and diet types. She chooses from the suggestions. [Beryl’s story] 
- Karen is losing weight, she wants to get foods with low fat and low carb. She runs the recipe generator program with food keywords and filters the diet level with Low-Fat and Low-Carb. She chooses from the lists. [Ruohan’s story]
- Karen is controlling her calorie intake. She runs the recipe generator program with food keywords and filters the results based on a calorie range. The program provides her with a list of recipes that fit her choices. [Emma’s story]

Beryl's Story (Cuisine and Ingredient-based Filtering)
-Task: Implement the functionality for filtering Asian recipes based on ingredient keywords.
-Interactor: The Recipe Search Interactor that handles API requests.
-Controller: RecipeSearchController to manage user input (ingredients, cuisine type).
-Presenter: RecipeSearchPresenter to display the results.

-User Input Data
  These are the pieces of data that the user (Karen) provides in the search interface:
  Ingredient Keywords: A set of ingredients the user wants to search for in recipes (e.g., "chicken", "tomato", "garlic").
  Cuisine Type: The user selects a cuisine type to filter recipes by (e.g., "Asian"). This can be a dropdown menu or a set of checkboxes where users can choose one or more types.

  Xiran's Story (Random Recipe)
-Task: Implement the case when the user is not choosing anything but generating the recipe, show 5 random recipes.
-Interactor: Base on the random recipes from our API, has the method which generates 5 random recipes.
-Controller: Use the RecipeSearchInteractor to randomly generate 5 recipes.
-Presenter: use view model to display the results.
