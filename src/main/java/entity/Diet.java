public class Diet {
    private final boolean lowFat;
    private final boolean lowCarb;
    private final boolean balanced;

    public Diet(boolean lowFat, boolean lowCarb, boolean balanced) {
        this.lowFat = lowFat;
        this.lowCarb = lowCarb;
        this.balanced = balanced;
    }

    public boolean isLowFat() { return lowFat; }
    public boolean isLowCarb() { return lowCarb; }
    public boolean isBalanced() { return balanced; }
}