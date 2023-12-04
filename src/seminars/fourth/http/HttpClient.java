package seminars.fourth.http;

public class HttpClient {
    public String get(String url){
        if(url.equals("Request VK")) return "URL VK is OK";
        return "No such URL";
    }
}
