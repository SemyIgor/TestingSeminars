package seminars.third.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MainHWTest {
//    evenOddNumber tests

    private MainHW mainHW;
    @BeforeEach
    void setUp(){mainHW = new MainHW();}

    @Test
    void testIfNumberIsEven(){assertThat(mainHW.evenOddNumber(18)).isTrue();}

    @Test
    void testIfNumberIsNotEven(){assertThat(mainHW.evenOddNumber(17)).isFalse();}

    @ParameterizedTest
    @CsvSource({
            "-10, false",
            "0, false",
            "10, false",
            "25, false",
            "26, true",
            "55, true",
            "99, true",
            "100, false",
            "101, false"
    })

    void testIfNumberIsBetween25And100(int n, boolean result){assertThat(mainHW.numberInInterval(n)).isEqualTo(result);}
}
