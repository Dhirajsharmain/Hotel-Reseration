package bridgelabz.test;

import bridgelabz.HotelReservationMain;
import org.junit.Assert;
import org.junit.Before;

public class HotelReservationTest {

    public HotelReservationMain hotelReservationMain;

    @Before
    public void setup(){
        hotelReservationMain = new HotelReservationMain();
    }

    public void givenHotel_shouldReturnTrue(){
        boolean result = hotelReservationMain.addHotel();
        Assert.assertTrue(result);
    }
}
