package entity;

import java.util.Collections;
import java.util.Set;

/**
 * The representation of Diet for our application.
 */
public class Diet {

    /**
     * Enum of all possible Diet labels.
     */
    public enum DietLabels {
        LOW_FAT, LOW_CARB, BALANCED, HIGH_FIBER, LOW_SODIUM, HIGH_PROTEIN
    }

    public static final Set<DietLabels> POSSIBLE_DIET_LABELS =
            Collections.unmodifiableSet(Set.of(DietLabels.values()));

    private final String[] dietLabels;

    public Diet(String[] dietLabels) {
        this.dietLabels = dietLabels;
    }

    public String[] getDietLabels() {
        return dietLabels;
    }

    @Override
    public String toString() {
        final String result;
        if (dietLabels == null || dietLabels.length == 0) {
            result = null;
        }
        else {
            result = String.join(", ", dietLabels);
        }
        return result;
    }
}
