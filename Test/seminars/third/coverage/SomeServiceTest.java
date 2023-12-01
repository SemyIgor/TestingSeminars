package seminars.third.coverage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//import static org.junit.jupiter.api.Assertions.*;

class SomeServiceTest {
   // 3.1.

    private SomeService someService;

    @BeforeEach
    void setUp(){ someService = new SomeService(); }

    @Test
    void testReturnFizz(){
        assertThat(someService.fizzBuzz(3)).isEqualTo("Fizz");
    }

    @Test
    void testReturnBuzz(){
        assertThat(someService.fizzBuzz(5)).isEqualTo("Buzz");
    }

    @Test
    void  testReturnFizzBuzz(){
        assertThat(someService.fizzBuzz(15)).isEqualTo("FizzBuzz");
    }

    @Test
    void testReturnValueString(){
        assertThat(someService.fizzBuzz(11)).isEqualTo("11");
    }

    // 3.2

    @Test
    void firstLast6(){
        assertThat(someService.firstLast6(new int[]{6, 4, 5, 12, 4})).isTrue();
    }

//  3.3

    @ParameterizedTest
    @CsvSource({
            "2000, 15, 1700",
            "2000, 0, 2000",
            "2000, 100, 0"
    })
    void discountPositiveTest(double purchaseAmount, int discountAmount, double expected){
        assertThat(someService.calculatingDiscount(purchaseAmount, discountAmount)).isEqualTo(expected);
    }

    //        Проверка заграничных условий расчёта дисконта

    @Test
    void testPurchaseAmauntNegative(){assertThatThrownBy(() -> someService.calculatingDiscount(-2000, 20))
            .isInstanceOf(RuntimeException.class).hasMessage("Negative purchase amount");}

    @Test
    void testDiscountNegative(){assertThatThrownBy(() -> someService.calculatingDiscount(100, -20))
            .isInstanceOf(IllegalStateException.class).hasMessage("Negative discount");}

    @Test
    void testDiscountOverMaxOperation(){assertThatThrownBy(() -> someService.calculatingDiscount(100, 120))
            .isInstanceOf(IllegalStateException.class).hasMessage("Too much discount");}

    // 3.4
    @ParameterizedTest
    @CsvSource({"10, 20, 30, 60", "13, 20, 30, 50", "10, 13, 30, 40", "10, 20, 13, 30"})
    void testLuckySum(int a, int b, int c, int sum){assertThat(someService.luckySum(a, b, c))
            .isEqualTo(sum);}

}