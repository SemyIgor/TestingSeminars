package seminars.five;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import seminars.five.number.MaxNumberModule;
import seminars.five.number.RandomNumberModule;
import seminars.five.order.OrderService;
import seminars.five.order.PaymentService;
import seminars.five.user.UserRepository;
import seminars.five.user.UserService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTest {
    //5.1.

//    Проверка генерации списка случайных чисел
    @Test
    void testRandom(){
        RandomNumberModule randomNumberModule = new RandomNumberModule();
        List<Integer> testedList =
                randomNumberModule.numberListGenerator();

        System.out.println(testedList);

        assertThat(testedList.size()).isEqualTo(10);
        assertThat(randomNumberModule.numberListGenerator()).hasSize(10);
    }

//    Проверка поиска наибольшего числа в списке
    @Test
    void testMax(){
//        ===================== Работа с классом ===============================
//        RandomNumberModule randomNumberModule = new RandomNumberModule();
//        MaxNumberModule maxNumberModule = new MaxNumberModule(randomNumberModule);
//        Создаём список с использованием нашего метода:
//        List<Integer> testedList = randomNumberModule.numberListGenerator();

//        System.out.println(testedList);
//        System.out.println(maxNumberModule
//                .getMaxNumber(randomNumberModule));
//        System.out.println(testedList);

//        Поскольку мы не можем знать, какой список будет сгенерирован рандомно, то
//        в методе RandomNumberModule.numberListGenerator() отключаем "родной" return numberList,
//        и добавляем return new ArrayList<>(Arrays.asList(13, 80, 93, 90, 46, 56, 97, 88, 81, 14));
//        Далее, проверяем, что максимальное число найдено верно и равно 97.
//        assertThat(maxNumberModule.getMaxNumber(randomNumberModule)).isEqualTo(97);
//        ------------------------------------------------------------------------

//        ====================== Работа со списком ===========================
        List<Integer> testedList = new  ArrayList<>(Arrays.asList(13, 80, 93, 90, 46, 56, 97, 88, 81, 14));
        /*MaxNumberModule maxNumberModule = new MaxNumberModule(testedList); // Если класс с параметром*/
        MaxNumberModule maxNumberModule = new MaxNumberModule(); // Если класс создаётся без параметров

        assertThat(maxNumberModule.getMaxNumber(testedList)).isEqualTo(97);
//        ------------------------------------------------------------------------
    }

//    Проверка взоимодействия двух модулей между собой
    @Test
    void testMaxInRandom(){
        RandomNumberModule randomNumberModule = new RandomNumberModule();
        MaxNumberModule maxNumberModule = new MaxNumberModule();

        List<Integer> generatedList = randomNumberModule.numberListGenerator();
        int maxNumber = maxNumberModule.getMaxNumber(generatedList);

        assertThat(maxNumber).isEqualTo(Collections.max(generatedList));
    }

    //5.2.

    @ParameterizedTest
    @ValueSource(ints={1, 100, -10})
    void testUserIntegration(int id){
        UserRepository userRepository = new UserRepository();
        UserService userService = new UserService(userRepository);

//        int id = 3;
        String result = userRepository.getUserById(id);

        assertEquals("select username from users where id= " + id, result);
    }

    //5.3.
    @Test
    void testOrderService(){
        PaymentService paymentService = new PaymentService();
        OrderService orderService = new OrderService(paymentService);

        boolean result = orderService.placeOrder("10", 3);

//        assertThat(result).isTrue(); // первый вариант
        assertTrue(result); // второй вариант
    }
}