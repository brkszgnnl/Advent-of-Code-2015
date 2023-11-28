import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SantaHelperTest {

    @Test
    void checkDestinationFloorWhenUnexpectedChar() {
        String input = "a";
        SantaHelper helper = new SantaHelper(input);
        Exception exception = assertThrows(Exception.class, helper::getDestinationFloor);
        assertEquals("Unexpected char in the input string!", exception.getMessage());
    }

    @Test
    void checkDestinationFloor0_Test1() throws Exception {
        String input = "(())";
        SantaHelper helper = new SantaHelper(input);
        int actualFloor = helper.getDestinationFloor();
        int expectedFloor = 0;
        Assertions.assertEquals(expectedFloor, actualFloor);
    }
    @Test
    void checkDestinationFloor0_Test2() throws Exception {
        String input = "()()";
        SantaHelper helper = new SantaHelper(input);
        int actualFloor = helper.getDestinationFloor();
        int expectedFloor = 0;
        Assertions.assertEquals(expectedFloor, actualFloor);
    }
    @Test
    void checkDestinationFloor3_Test1() throws Exception {
        String input = "(((";
        SantaHelper helper = new SantaHelper(input);
        int actualFloor = helper.getDestinationFloor();
        int expectedFloor = 3;
        Assertions.assertEquals(expectedFloor, actualFloor);
    }
    @Test
    void checkDestinationFloor3_Test2() throws Exception {
        String input = "(()(()(";
        SantaHelper helper = new SantaHelper(input);
        int actualFloor = helper.getDestinationFloor();
        int expectedFloor = 3;
        Assertions.assertEquals(expectedFloor, actualFloor);
    }
    @Test
    void checkDestinationFloor3_Test3() throws Exception {
        String input = "))(((((";
        SantaHelper helper = new SantaHelper(input);
        int actualFloor = helper.getDestinationFloor();
        int expectedFloor = 3;
        Assertions.assertEquals(expectedFloor, actualFloor);
    }
    @Test
    void checkDestinationFloorNegative1_Test1() throws Exception {
        String input = "())";
        SantaHelper helper = new SantaHelper(input);
        int actualFloor = helper.getDestinationFloor();
        int expectedFloor = -1;
        Assertions.assertEquals(expectedFloor, actualFloor);
    }
    @Test
    void checkDestinationFloorNegative1_Test2() throws Exception {
        String input = "))(";
        SantaHelper helper = new SantaHelper(input);
        int actualFloor = helper.getDestinationFloor();
        int expectedFloor = -1;
        Assertions.assertEquals(expectedFloor, actualFloor);
    }
    @Test
    void checkDestinationFloorNegative3_Test1() throws Exception {
        String input = ")))";
        SantaHelper helper = new SantaHelper(input);
        int actualFloor = helper.getDestinationFloor();
        int expectedFloor = -3;
        Assertions.assertEquals(expectedFloor, actualFloor);
    }
    @Test
    void checkDestinationFloorNegative3_Test2() throws Exception {
        String input = ")())())";
        SantaHelper helper = new SantaHelper(input);
        int actualFloor = helper.getDestinationFloor();
        int expectedFloor = -3;
        Assertions.assertEquals(expectedFloor, actualFloor);
    }

    @Test
    void checkFirstBasementPositionWhenInputEmpty() {
        String input = "";
        SantaHelper helper = new SantaHelper(input);
        Exception exception = assertThrows(Exception.class, helper::getFirstBasementPosition);
        assertEquals("Basement is never reached!", exception.getMessage());
    }

    @Test
    void checkFirstBasementPositionWhenBasementNeverReached() {
        String input = "(((";
        SantaHelper helper = new SantaHelper(input);
        Exception exception = assertThrows(Exception.class, helper::getFirstBasementPosition);
        assertEquals("Basement is never reached!", exception.getMessage());
    }

    @Test
    void checkFirstBasementPosition1() throws Exception {
        String input = ")";
        SantaHelper helper = new SantaHelper(input);
        int actualPosition = helper.getFirstBasementPosition();
        int expectedPosition = 1;
        Assertions.assertEquals(expectedPosition, actualPosition);
    }

    @Test
    void checkFirstBasementPosition5() throws Exception {
        String input = "()())";
        SantaHelper helper = new SantaHelper(input);
        int actualPosition = helper.getFirstBasementPosition();
        int expectedPosition = 5;
        Assertions.assertEquals(expectedPosition, actualPosition);
    }
}