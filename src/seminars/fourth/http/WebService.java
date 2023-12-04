package seminars.fourth.http;

public class WebService {
    private HttpClient httpClient;
    public WebService(HttpClient httpClient){
        this.httpClient = httpClient;
    }

    public String sendRequest(String request){
        String res = httpClient.get("Request URL");
        return res;
    }
}
