package seminars.first.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorTests {

    private Calculator calculator;

    @BeforeEach
    void setup(){calculator = new Calculator();}

    // Проверка арифметического калькулятора:
    @Test
    void testSumOperation(){assertThat(calculator.calculate(2, 6, '+')).isEqualTo(8);}

    @Test
    void testSubOperation(){assertThat(calculator.calculate(2, 2, '-')).isEqualTo(0);}

    @Test
    void testMulOperation(){assertThat(calculator.calculate(2, 7, '*')).isEqualTo(14);}

    @Test
    void testDivOperation(){assertThat(calculator.calculate(100, 50, '/')).isEqualTo(2);}

    @Test
    void testRootOperation(){assertThat(calculator.calculate(625, 4, '^')).isEqualTo(5);}

//    Проверка деления на нуль
    @Test
    void testDivZeroOperation(){assertThatThrownBy(() -> calculator.calculate(100, 0, '/'))
            .isInstanceOf(ArithmeticException.class).hasMessage("Ошибка - деление на 0");}


//    Проверка ошибки извлечения корня из отрицательного числа
    @Test
    void testRootNegativeOperation(){assertThatThrownBy(() -> calculator.calculate(-625, 4, '^'))
            .isInstanceOf(AssertionError.class).hasMessage("Root of a negative number");}

//    Проверка ошибки ввода операнда
    @Test
    void testIncorrectOperatorOperation(){assertThatThrownBy(() -> calculator.calculate(625, 4, '_'))
            .isInstanceOf(IllegalStateException.class).hasMessage("Ошибка! Неверно указан оператор");}

//        Проверка расчёта дисконта

    @ParameterizedTest
    @CsvSource({
            "2000, 15, 1700",
            "2000, 0, 2000",
            "2000, 100, 0"
    })
    void discountPositiveTest(double purchaseAmount, int discountAmount, double expected){
        assertThat(calculator.calculatingDiscount(purchaseAmount, discountAmount)).isEqualTo(expected);
    }

//  ===========  Этот блок уже выполнен в параметризованном тесте ========================================
    @Test
    void testDiscountOperation(){assertThat(calculator.calculatingDiscount(2000, 15)).isEqualTo(1700);}

    @Test
    void testDiscountZeroOperation(){assertThat(calculator.calculatingDiscount(2000, 0)).isEqualTo(2000);}

    @Test
    void testDiscountMaxOperation(){assertThat(calculator.calculatingDiscount(2000, 100)).isEqualTo(0);}
//  ----------- Конец блока -------------------------------------------------------------------------------

//        Проверка заграничных условий расчёта дисконта

    @Test
    void testPurchaseAmauntNegative(){assertThatThrownBy(() -> calculator.calculatingDiscount(-2000, 20))
            .isInstanceOf(RuntimeException.class).hasMessage("Negative purchase amount");}

    @Test
    void testDiscountNegative(){assertThatThrownBy(() -> calculator.calculatingDiscount(100, -20))
            .isInstanceOf(IllegalStateException.class).hasMessage("Negative discount");}

    @Test
    void testDiscountOverMaxOperation(){assertThatThrownBy(() -> calculator.calculatingDiscount(100, 120))
            .isInstanceOf(IllegalStateException.class).hasMessage("Too much discount");}

    public static void tests() {


//        Архаичный, но любопытный вариант проверки заграничных условий расчёта дисконта
        try {
            Calculator.calculatingDiscount(100, 20);
        } catch (IllegalStateException e) {
            if(e.getMessage().equals("Negative discount")) {
                throw new AssertionError("Отрицательная скидка недопустима");
            } else if (e.getMessage().equals("Too much discount")) {
                throw new AssertionError("Скидка больше стоимости - это вредительство");
            }
        }
    }
}

