import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class GiftTest {

    @Test
    void verifyConstructorWhenInputNull(){
        String input = null;
        assertThrows(NullPointerException.class, () -> new Gift(input));
    }

    @Test
    void verifyConstructorWhenInputEmpty(){
        String input = "";
        assertThrows(EmptyInputException.class, () -> new Gift(input));
    }

    @Test
    void verifyConstructorWhenInputWrongFormatWithInteger1(){
        String input = "10";
        Exception exception = assertThrows(WrongDimensionException.class, () -> new Gift(input));
        Assertions.assertEquals(WrongDimensionException.lessDimensions, exception.getMessage());
    }

    @Test
    void verifyConstructorWhenInputWrongFormatWithInteger2(){
        String input = "10x10";
        Exception exception = assertThrows(WrongDimensionException.class, () -> new Gift(input));
        Assertions.assertEquals(WrongDimensionException.lessDimensions, exception.getMessage());
    }

    @Test
    void verifyConstructorWhenInputWrongFormatWithInteger3(){
        String input = "10x10x10x10";
        Exception exception = assertThrows(Exception.class, () -> new Gift(input));
        Assertions.assertEquals(WrongDimensionException.moreDimensions, exception.getMessage());
    }

    @Test
    void getWrapperSize1() throws NumberFormatException, WrongDimensionException, EmptyInputException {
        Gift gift = new Gift("2x3x4");
        int actualWrapperSize = gift.getWrapperSize();
        int expectedWrapperSize = 58;
        Assertions.assertEquals(expectedWrapperSize, actualWrapperSize);
    }

    @Test
    void getWrapperSize2() throws NumberFormatException, WrongDimensionException, EmptyInputException {
        Gift gift = new Gift("1x1x10");
        int actualWrapperSize = gift.getWrapperSize();
        int expectedWrapperSize = 43;
        Assertions.assertEquals(expectedWrapperSize, actualWrapperSize);
    }

    @Test
    void getRibbonSize1() throws NumberFormatException, WrongDimensionException, EmptyInputException {
        Gift gift = new Gift("2x3x4");
        int actualRibbonSize = gift.getRibbonSize();
        int expectedRibbonSize = 34;
        Assertions.assertEquals(expectedRibbonSize, actualRibbonSize);
    }

    @Test
    void getRibbonSize2() throws NumberFormatException, WrongDimensionException, EmptyInputException {
        Gift gift = new Gift("1x1x10");
        int actualRibbonSize = gift.getRibbonSize();
        int expectedRibbonSize = 14;
        Assertions.assertEquals(expectedRibbonSize, actualRibbonSize);
    }
}