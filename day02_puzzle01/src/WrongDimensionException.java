public class WrongDimensionException extends Exception{

    public static String lessDimensions = "The number of dimensions must be at least 3.";
    public static String moreDimensions = "The number of dimensions cannot exceed 3.";

    public WrongDimensionException(String errorMessage){
        super(errorMessage);
    }

    public static WrongDimensionException forLessThanThreeDimensions() {
        return new WrongDimensionException(lessDimensions);
    }

    public static WrongDimensionException forMoreThanThreeDimensions() {
        return new WrongDimensionException(moreDimensions);
    }
}
