package seminars.fourth.http;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
class WebServiceTest {

    @Test
    void testWebService(){
        HttpClient httpClientMock = mock(HttpClient.class);
        WebService webService = new WebService(httpClientMock);
        when(httpClientMock.get(anyString())).thenReturn("Request OK");

        String result = webService.sendRequest("Request URL");

        verify(httpClientMock).get("Request URL");
        assertThat(result).isEqualTo("Request OK");
    }

}
