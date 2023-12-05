package seminars.five.number;

import java.util.List;

import static java.lang.Integer.MIN_VALUE;

public class MaxNumberModule {
//    Этот класс использует в конструкторе элемент класса RandomNumberModule,
//    который, в свою очередь, возвращает сгенерированный рандомный список
/*    RandomNumberModule randomNumberModule = new RandomNumberModule();

    public MaxNumberModule(RandomNumberModule randomNumberModule){
        this.randomNumberModule = randomNumberModule;
    }
    int maxNumber;
    List<Integer> randomNumbers = randomNumberModule.numberListGenerator();
    public int getMaxNumber(RandomNumberModule randomNumberModule){
        int maxNumber = MIN_VALUE;
        for (int number : randomNumbers
             ) {
            if(number >= maxNumber){maxNumber = number;}
        }
        return maxNumber;
    }*/
//    Этот класс работает не с классом RandomNumberModule, а с готовым списком
    private List<Integer> list;
//    Конструктор класса, получающего список извне:
/*    public MaxNumberModule(List<Integer> list){
        this.list = list;
    }*/

    public int getMaxNumber(List<Integer> list){
        int maxNumber = MIN_VALUE;
        for (int number : list
        ) {
            if(number >= maxNumber){maxNumber = number;}
        }
        return maxNumber;
    }

}
