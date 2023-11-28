import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        String input = readInput();
        SantaHelper helper = new SantaHelper(input);

        try {
            System.out.println("Answer for Puzzle #1 = " + helper.getDestinationFloor());
            System.out.println("Answer for Puzzle #2 = " + helper.getFirstBasementPosition());
        } catch (Exception e) {
            logException(e);
        }
    }

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

    private static String readInput(){
        try {
            return new String(Files.readAllBytes(Paths.get("src\\input")));
        } catch (IOException e) {
            logException(e);
            throw new RuntimeException(e);
        }
    }
}
