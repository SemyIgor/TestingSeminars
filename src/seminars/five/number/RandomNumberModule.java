package seminars.five.number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RandomNumberModule {
    public List <Integer> numbersList = new ArrayList<>();

    public List<Integer> numberListGenerator(){
        List<Integer> numberList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            numberList.add(random.nextInt(100));
        }
        return numberList;
//        return new ArrayList<>(Arrays.asList(13, 80, 93, 90, 46, 56, 97, 88, 81, 14));
    }
}
