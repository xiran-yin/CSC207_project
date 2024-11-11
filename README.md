# CSC207_project

## Basic informations
| name      | GitHub username                                      |                   |
|-----------|------------------------------------------------------|--------------------------------|
| EMMA YIMING CHEN | [@EmmaYimingChen](https://github.com/EmmaYimingChen) |  |
|     Beryl Guo    | [@GBeryl](https://github.com/GBeryl)                 |  |
|    Ruohan Wang   | [@RuohanW1](https://github.com/RuohanW1)             |  |
|     Xiran Yin    | [@xiran-yin](https://github.com/xiran-yin)           |  |


User Stories: 
Team story – Karen needs a recipe. She runs the recipe generator program. She then chooses the recipe from one of the suggestions.[Team story]
Karen hasn't decided what to cook today, and she is planning to use this program to help her decide what to eat.  She runs this program and gets some random recipes. She chose one of the recipes from these random recipes she likes for this meal.[Xiran’s story]
Karen has some ingredients and wants to cook Asian food. She runs the recipe generator program with ingredient keywords and filters Asian food specifically. She gets a list of Asian foods with various calories and diet types. She chooses from the suggestions. [Beryl’s story] 
Karen is losing weight, she wants to get foods with low fat and low carb. She runs the recipe generator program with food keywords and filters the diet level with Low-Fat and Low-Carb. She chooses from the lists. [Ruohan’s story]
Karen is controlling her calorie intake. She runs the recipe generator program with food keywords and filters the results based on a calorie range. The program provides her with a list of recipes that fit her choices. [Emma’s story]

Use case:
Input keywords/choose filters for the recepies -> top 5 results based on the keywords and filters.

Diet Type:
- Task: Implement the function of filtering food types based on ingredient keywords
- Interactor: The Recipe Search Interactor that handles API requests.
- Controller: RecipeSearchController to manage user input (ingredients, diet type).
- Presenter: RecipeSearchPresenter to display 5 results.

- User Input Data:
  - Ingredient Keywords(ingredient they want to use, e.g. "chicken", "potato").
  - Diet Type:
    - Can be selected by "Low fat", "Low Carb" or "Balance".
    - "Low fat" and "Low Carb" can be selected at the same time.
