#CSC207 Project: Recipe Generator

This is a free, open-source Recipe Generator implemented in Java. The program is designed to provide recipes that meet users’ specific dietary requirements, preferences, or restrictions. Whether you’re managing calorie intake, adhering to ingredient restrictions, seeking low-carb or high-protein options, or exploring a specific cuisine type, this app can help. Plus, it doesn’t require a login for accessibility.

## Table of Contents
- [Introduction](#introduction)
- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
- [Examples and Tutorials](#examples)
- [Contributing](#contributing)
- [License](license)
- [Contact](#contact)


## Introduction
The Recipe Generator was created to solve a common problem: deciding what to cook while accommodating specific dietary preferences or restrictions.

### Purpose of the Project
- To make meal planning easier for users with varying dietary needs and preferences.
- To provide a user-friendly interface with versatile options, including calorie filtering, cuisine selection, or a random recipe generator for inspiration.
- To promote healthy eating habits by offering recipes tailored to specific requirements.

### Who is it For?
This project is ideal for:
- People on a diet (e.g., low-fat, low-carb, or high-protein).
- Individuals with ingredient restrictions (e.g., allergies or preferences).
- Users who want to explore new cuisines.
- Anyone looking for quick recipe suggestions without logging in.


## Features
The Recipe Generator provides the following functionalities:
### 1.Random Recipe Generator
- Generate 5 random recipes at the click of a button. Perfect for users seeking inspiration.
(Implemented by Xiran Yin)
### 2.Calorie-Based Recipe Search
- Search recipes within a specific calorie range to suit your health goals.
(Implemented by Emma Yiming Chen)
### 3.Cuisine-Based Recipe Search
- Filter recipes by specific cuisines (e.g., Asian, Italian, etc.) based on your preferences.
(Implemented by Beryl Guo)
### 4.Dietary-Based Search
- Get recipes that are low-fat, low-carb, or meet other specific dietary needs.
(Implemented by Ruohan Wang)
### 5.Keyword Search
- Enter keywords for ingredients to find recipes that match.


## Future Enhancements
- Multi-language support for a global audience.
- Accessibility features, including text-to-speech.
- Offline mode to save recipes for areas with limited internet connectivity.

## Installation
To set up the Recipe Generator, follow these steps:

### Prerequisites
- Java Development Kit (JDK) 17 or later.
- An Integrated Development Environment (IDE) like IntelliJ IDEA or Eclipse.

### Steps to Install
1. Clone this repository from GitHub.
2. Open the project in your preferred IDE.
3. Build the project to ensure all dependencies are resolved.
4. Navigate to the src/main/java directory.
5. Run the Main.java file to start the application.


## Usage

#### 1.Launching the App
Open the graphical user interface (GUI) by running the program.
#### 2.Using Features
Select options from the menu:
- Random Recipes: Displays 5 random recipe suggestions.
- Calorie Filter: Input a calorie range to get tailored recipes.
- Cuisine Filter: Choose a cuisine type (e.g., Asian, Italian).
- Diet Filter: Filter recipes based on low-fat, low-carb, etc.
- Keyword Search: Search by ingredients like “chicken” or “tomato.”
#### 3.Output
The program will generate a list of recipes based on your selection, displayed directly in the GUI.




# CSC207_project Recipe Generator
This is a free recipe generator implemented in Java.
It is designed to meet the needs of users with specific dietary requirements or preferences, such as controlling calorie intake, adhering to ingredient restrictions, require low-carb, high-protein diets, or catering to particular cuisine type, without login. 

## Basic informations
| Name of Authors     | GitHub username                                      | Usecases                  |
|-----------|------------------------------------------------------|--------------------------------|
| EMMA YIMING CHEN | [@EmmaYimingChen](https://github.com/EmmaYimingChen) | Calories |
|     Beryl Guo    | [@GBeryl](https://github.com/GBeryl)                 | Cuisine |
|    Ruohan Wang   | [@RuohanW1](https://github.com/RuohanW1)             | Diet |
|     Xiran Yin    | [@xiran-yin](https://github.com/xiran-yin)           | Random |


## Table of Contents
- [Introduction](#introduction)
- [Installation](#installation)
- [Usage](#usage)
- [Contributing](#contributing)
- [Contact](#contact)

  
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

