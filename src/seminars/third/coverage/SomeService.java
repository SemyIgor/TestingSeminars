package seminars.third.coverage;

public class SomeService {

    /**
     * 3.1. Метод возвращает Fizz для чисел кратных 3, Buzz для кратных 5, и FizzBuzz для кратных 3 и 5 одновременно
     */
    public String fizzBuzz(int i) {

        if(i%15==0) return "FizzBuzz";
        if(i%5==0) return "Buzz";
        if(i%3==0) return "Fizz";

        return ""+i; // возвращает строку с введенным числом
    }

    /**
     * 3.2. Метод возвращает true для массивов, которые начинаются или заканчиваются 6, и false - если 6 нет ни в начале ни в конце массива
     */
    public boolean firstLast6(int[] nums) {
        return (nums[0] == 6) || (nums[nums.length - 1] == 6);
    }


    /**
     * 3.3. Метод подсчета скидки
     */

    public static double calculatingDiscount(double purchaseAmount, int discountAmount){
        if(purchaseAmount < 0) throw new RuntimeException("Negative purchase amount");
        if(discountAmount < 0) throw new IllegalStateException("Negative discount");
        else if (discountAmount > 100) throw new IllegalStateException("Too much discount");
        else return purchaseAmount * (1.0 - discountAmount / 100.0);

    }

    /**
     * 3.4. Метод принимает на вход 3 числа (int a, b, c). Нужно вернуть их сумму.
     * Однако, если одно из значений равно 13, то оно не учитывается в сумме.
     * Так, например, если b равно 13, то считается сумма только a и c.
     */
    public static int luckySum(int a, int b, int c){
        return ((a==13) ? 0 : a) +
               ((b==13) ? 0 : b) +
               ((c==13 ? 0 : c));
    }

}