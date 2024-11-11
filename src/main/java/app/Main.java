package app;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        final AppBuilder recipe = new AppBuilder();
        final JFrame recipeView = recipe.build();
    }
}