import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        String input = readInput();
        System.out.println(getFloor(input));
    }

    public static int getFloor(String input){
        int floor = 0;

        char[] ch = input.toCharArray();
        for (char c : ch) {
            if (c == '(') {
                floor++;
            } else {
                floor--;
            }
        }

        return floor;
    }

    public static String readInput(){
        try {
            return new String(Files.readAllBytes(Paths.get("src\\input")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
