package seminars.third.tdd;

public class MoodAnalyser {

    public String analyzeMood(String message) {
        if(message.toLowerCase().contains("отличное")) return "Happy";
        if(message.toLowerCase().contains("ужасное")) return "Unhappy";
        else return "Normal";
    }

}