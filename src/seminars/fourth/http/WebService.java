package seminars.fourth.http;

public class WebService {
    final HttpClient httpClient;
    public WebService(HttpClient httpClient){
        this.httpClient = httpClient;
    }

    public String sendRequest(String request){
        return httpClient.get(request);
    }
}
