package seminars.third.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class TestDrivenDevelopment {

    private MoodAnalyser moodAnalyser;

    @BeforeEach
    void setUp(){moodAnalyser = new MoodAnalyser();}

    //3.5. Red-Green-Refactor

    @Test
    void goodMood(){
        assertThat(moodAnalyser.analyzeMood("Отличное настроение")).isEqualTo("Happy");
    }

    @Test
    void  badMood(){
        assertThat(moodAnalyser.analyzeMood("Ужасное настроение")).isEqualTo("Unhappy");
    }

    @Test
    void normalMood(){
        assertThat(moodAnalyser.analyzeMood("Нормальное настроение")).isEqualTo("Normal");
    }
}