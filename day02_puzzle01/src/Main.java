import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    private static void logException(Exception e){
        StringBuilder str = new StringBuilder();

        str.append(e.toString());
        str.append(System.getProperty("line.separator"));

        str.append("Stack Trace:");

        for(StackTraceElement el : e.getStackTrace()){
            str.append(System.getProperty("line.separator"));
            str.append("\t=> ");
            str.append(el);
        }

        logger.log(Level.WARNING, str.toString());
    }
    public static void main(String[] args) {

        try {
            List<String> input = readInput();
            System.out.println(getTotalProperWrapperSize(input));
            System.out.println(getTotalCheapWrapperSize(input));
        } catch (Exception e) {
            logException(e);
        }
    }

    private static int getTotalProperWrapperSize(List<String> input) throws WrongDimensionException, EmptyInputException {
        int totalSize = 0;
        for(String line : input){
            Gift gift = new Gift(line);
            totalSize += gift.getWrapperSize();
        }

        return totalSize;
    }

    private static int getTotalCheapWrapperSize(List<String> input) throws WrongDimensionException, EmptyInputException {
        int totalSize = 0;
        for(String line : input){
            Gift gift = new Gift(line);
            totalSize += gift.getRibbonSize();
        }

        return totalSize;
    }

    private static List<String> readInput() throws IOException {
        return Files.readAllLines(Paths.get("src\\input"));
    }
}
