public class SantaHelper {
    private final String input;

    public SantaHelper(String input) {
        this.input = input;
    }

    public int getDestinationFloor() throws Exception {
        int floor = 0;

        char[] ch = input.toCharArray();
        for (char c : ch) {
            if (c == '(') {
                floor++;
            }
            else if(c == ')') {
                floor--;
            }
            else{
                throw new Exception("Unexpected char in the input string!");
            }
        }

        return floor;
    }

    public int getFirstBasementPosition() throws Exception {

        char[] ch = input.toCharArray();

        int position = 0;
        int floor = 0;
        for (; position < ch.length; position++){

            if (ch[position] == '(') {
                floor++;
            } else {
                floor--;
            }

            if(floor == -1)
                break;
        }
        if(position == ch.length)
            throw new Exception("Basement is never reached!");

        return position + 1;
    }
}
