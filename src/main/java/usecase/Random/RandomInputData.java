package usecase.Random;
import java.util.Random;

public class RandomInputData {
    final private String keyword;
    public RandomInputData() {
        Random random = new Random();
        int randomInt = random.nextInt(4);
        String[] stringList = {"Apple", "Banana", "Cherry", "pork", "beef", "chicken"};
        this.keyword = stringList[randomInt];}
    public String getKeyword() {return keyword;}
}
