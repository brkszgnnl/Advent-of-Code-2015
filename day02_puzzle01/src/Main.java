import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> input = null;
        try {
            input = readInput();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(getTotalWrapperSizeNeeded(input));
    }

    private static int getTotalWrapperSizeNeeded(List<String> input) {
        int totalSize = 0;
        for(String line : input){
            Gift gift = new Gift(line);
            totalSize += gift.getWrapperSizeNeeded();
        }

        return totalSize;
    }

    private static List<String> readInput() throws IOException {
        return Files.readAllLines(Paths.get("src\\input"));
    }
}
