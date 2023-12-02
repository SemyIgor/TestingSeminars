package seminars.fourth.weather;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class WeatherReporterTest {

    @Test
    void weatherTest(){
        WeatherService serviceMock = mock(WeatherService.class); // Заглушка
        WeatherReporter weatherReporter = new WeatherReporter(serviceMock); // Проверяемый класс

//        Следующее читается как: когда вызовется метод на нашем классе-заглушке,
//        выдать температуру 25 (градусов).
        when(serviceMock.getCurrentTemperature()).thenReturn(25);

        String result = weatherReporter.generateReport(); // Сохраним результат вызова в переменную

        assertEquals("Текущая температура: " + 25 + " градусов.", result);
    }
}