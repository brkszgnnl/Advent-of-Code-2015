public class Gift {

    private final int length;
    private final int width;
    private final int height;
    private final int[] surfaceAreas;

    public Gift(String input) throws NumberFormatException, WrongDimensionException, EmptyInputException {
        if(input == null)
            throw new NullPointerException("Input is null!");
        else if (input.isEmpty()) {
            throw new EmptyInputException("Input string is empty!");
        }

        String[] result = input.split("x");
        if(result.length < 3)
            throw WrongDimensionException.forLessThanThreeDimensions();
        else if(result.length > 3)
            throw WrongDimensionException.forMoreThanThreeDimensions();

        length = Integer.parseInt(result[0]);
        width = Integer.parseInt(result[1]);
        height = Integer.parseInt(result[2]);

        surfaceAreas = new int[3];
        surfaceAreas[0] = length * width;
        surfaceAreas[1] = height * width;
        surfaceAreas[2] = length * height;
    }

    private int getSmallestSurfaceArea() throws IllegalArgumentException{
        int smallestSurfaceArea = surfaceAreas[0];
        for (int i = 1; i < surfaceAreas.length; i++) {
            if (surfaceAreas[i] < smallestSurfaceArea) {
                smallestSurfaceArea = surfaceAreas[i];
            }
        }

        return smallestSurfaceArea;
    }

    private int getTotalSurfaceArea(){
        int totalSurfaceArea = 0;
        for(int surfaceArea : surfaceAreas){
            totalSurfaceArea += 2 * surfaceArea;
        }
        return totalSurfaceArea;
    }

    public int getWrapperSize() {
        return getTotalSurfaceArea() + getSmallestSurfaceArea();
    }

    private int getVolume(){
        return length * width * height;
    }

    private int getSmallestCircumference() {
        int largestDimension = Math.max(length, Math.max(width, height));
        return 2 * ((length + width + height) - largestDimension);

    }

    public int getRibbonSize() throws IllegalArgumentException{
        return getVolume() + getSmallestCircumference();
    }
}
