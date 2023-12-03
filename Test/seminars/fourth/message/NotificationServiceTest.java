package seminars.fourth.message;


import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class NotificationServiceTest {

    @Test
    void testSendMessage(){
        MessageService messageServiceMock = mock(MessageService.class);
        NotificationService notificationService = new NotificationService(messageServiceMock);

        notificationService.sendNotification("Сообщение", "Получатель");
        verify(messageServiceMock).sendMessage("Сообщение", "Получатель");
    }
}