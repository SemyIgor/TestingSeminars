package seminars.fourth.hotel;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class BookingServiceTest {

    private HotelService mockHotelService;
    private BookingService bookingService;

    @BeforeEach
    void setUp(){
        mockHotelService = mock(HotelService.class);
        bookingService = new BookingService(mockHotelService);

    }

    @Test
    void testEvenNumber(){
        when(mockHotelService.isRoomAvailable(18)).thenReturn(true);
        boolean result = bookingService.bookRoom(18);

        assertTrue(result);
    }

    @Test
    void testOddNumber(){
        when(mockHotelService.isRoomAvailable(19)).thenReturn(false);
        boolean resultNegative = bookingService.bookRoom(19);

        assertFalse(resultNegative);
    }

}