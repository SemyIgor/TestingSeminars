package seminars.fourth.http;

public class WebService {
    final HttpClient httpClient;
    public WebService(HttpClient httpClient){
        this.httpClient = httpClient;
    }

    public String sendRequest(String request){
        String requestResult = httpClient.get(request);
        return requestResult;
    }
}
