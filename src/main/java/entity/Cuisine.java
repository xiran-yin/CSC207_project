package entity;

import java.util.Collections;
import java.util.Set;

public class Cuisine {

    // Enum defining all possible cuisines
    public enum CuisineType {
        ASIAN,
        FRENCH,
        BRITISH,
        ITALIAN,
        MEDITERRANEAN
    }

    // Static constant: all possible cuisine types
    public static final Set<CuisineType> POSSIBLE_CUISINES =
            Collections.unmodifiableSet(Set.of(CuisineType.values()));

    // Instance variable: specific cuisine type for a recipe
    private final String cuisineType;

    // Constructor
    public Cuisine(String cuisineType) {
        if (cuisineType == null || cuisineType.isEmpty()) {
            throw new IllegalArgumentException("Cuisine type cannot be null or empty.");
        }
        this.cuisineType = cuisineType.toUpperCase(); // Normalize input
    }

    // Getter for the cuisine type
    public String getCuisineType() {
        return cuisineType;
    }

    // Access the possible cuisines (static)
    public static Set<CuisineType> getPossibleCuisines() {
        return POSSIBLE_CUISINES;
    }

    @Override
    public String toString() {
        return cuisineType.substring(0, 1).toUpperCase() + cuisineType.substring(1).toLowerCase();
    }
}
