package seminars.fourth.database;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class DataProcessorTest {

    @Test
    void testDataReceivedTrue(){
//        ПОДГОТОВКА ДАННЫХ
//        Создаём объект - заглушку класса, соответствующего имитируемому объекту:
        Database databaseMock = mock(Database.class);
//        Создаём объект проверяемого класса, передавая в его конструктор
//        наш объект - заглушку:
        DataProcessor dataProcessor = new DataProcessor(databaseMock);
//        Описываем действия, которые должны происходить при вызове объекта - заглушки:
//        когда на объекте-заглушке вызовется метод query() с параметром
//        "anyString() - (любая строка), тогда возвращаем массив в виде следующих строк -
//        "Data1", "Data2", "Data3"
        when(databaseMock.query(anyString())).thenReturn(Arrays.asList("Data1", "Data2", "Data3"));

//        ВЫПОЛНЕНИЕ МЕТОДА ПРОВЕРЯЕМОГО КЛАССА
//        Создаём вызов метода объекта проверяемого класса, который создавался с использованием
//        объекта - заглушки и сохраняем результат в переменную:
        List<String> result = dataProcessor.processData("Запрос SQL");

//        НАЧАЛО ПРОВЕРКИ
//        Убеждаемся, что наша заглушка работает, причём только 1 раз:
//        (Mockito Verify methods are used to check that certain behavior happened.
//        We can use Mockito verify methods at the end of the testing method code
//        to make sure that specified methods are called.)
//        Важно! Аргументом verify должен быть объект - заглушка, а не результат работы
//        его метода. Поэтому, .query находится за пределами скобок assertThat.
        verify(databaseMock, times(1)).query("Запрос SQL");
//        Запускаем тест, который проверяет, что возвращаемый результат нашего вызова,
//        а это список из трёх строк, имеет длину 3 (элемента)
        assertThat(result).hasSize(3);
    }
}