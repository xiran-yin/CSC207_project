package entity;

import java.util.Collections;
import java.util.Set;

/**
 * The representation of Cuisine for our application.
 */
public class Cuisine {

    /**
     * Enum defining all possible cuisines.
     */
    public enum CuisineType {
        ASIAN,
        FRENCH,
        BRITISH,
        ITALIAN,
        MEDITERRANEAN
    }

    public static final Set<CuisineType> POSSIBLE_CUISINES =
            Collections.unmodifiableSet(Set.of(CuisineType.values()));

    private final String cuisineType;

    public Cuisine(String cuisineType) {
        if (cuisineType == null || cuisineType.isEmpty()) {
            throw new IllegalArgumentException("Cuisine type cannot be null or empty.");
        }
        this.cuisineType = cuisineType.toUpperCase();
    }

    /**
     * Getter for the cuisine type.
     * @return the cuisine type
     */
    public String getCuisineType() {
        return cuisineType;
    }

    public static Set<CuisineType> getPossibleCuisines() {
        return POSSIBLE_CUISINES;
    }

    @Override
    public String toString() {
        return cuisineType.substring(0, 1).toUpperCase() + cuisineType.substring(1).toLowerCase();
    }
}
