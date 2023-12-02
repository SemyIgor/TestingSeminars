package seminars.fourth.card;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class PaymentFormTest {

    /**
     * 4.2. Используя библиотеку Mockito, напишите модульные тесты для проверки функциональности
     * формы оплаты на сайте.
     * * Вместо реальной кредитной карты используйте мок-объект.
     * Создайте класс `CreditCard` с методами `getCardNumber()`, `getCardHolder()`,
     * `getExpiryDate()`, `getCvv()`, `charge(double amount)`.
     * Создайте класс `PaymentForm` с методом `pay(double amount)`.
     * В тестовом классе, создайте мок-объект для класса `CreditCard`.
     * Определите поведение мок-объекта с помощью метода `when()`.
     * Создайте объект класса `PaymentForm`, передайте ему мок-объект в качестве аргумента.
     * Вызовите метод `pay()` и убедитесь, что мок-объект вызывает метод `charge()`
     */

    @Test
    void testPaymentForm(){
        CreditCard creditCard = mock(CreditCard.class);
//        Здесь должен быть метод when, но, поскольку у метода charge() кредитной карты
//        нет возвращаемого результата, мы не можем применить метод when
        PaymentForm paymentForm = new PaymentForm(creditCard);

        paymentForm.pay(1000);

//        Под verify первым идёт объект-заглушка, затем (не обязательно) times() - количество повторений,
//        которое важно для многопоточных методов (как ограничитель), так и для случаев, когда точно известно
//        требуемое количество повторений.
        verify(creditCard, times(1)).charge(1000);
    }



}