import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GiftTest {

    @Test
    void getWrapperSizeNeeded1() {
        Gift gift = new Gift("2x3x4");
        int actualWrapperSizeNeeded = gift.getWrapperSizeNeeded();
        int expectedWrapperSizeNeeded = 58;
        Assertions.assertEquals(expectedWrapperSizeNeeded, actualWrapperSizeNeeded);
    }

    @Test
    void getWrapperSizeNeeded2() {
        Gift gift = new Gift("1x1x10");
        int actualWrapperSizeNeeded = gift.getWrapperSizeNeeded();
        int expectedWrapperSizeNeeded = 43;
        Assertions.assertEquals(expectedWrapperSizeNeeded, actualWrapperSizeNeeded);
    }
}