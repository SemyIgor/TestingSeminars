package seminars.third.coverage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
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
        assertThat(someService.firstLast6(new int[]{4, 5, 12, 4, 6, 6})).isTrue();
    }

/*    void multipleThreeNotFiveReturnsFizz(int n) {
        // assertEquals...
    }*/

}