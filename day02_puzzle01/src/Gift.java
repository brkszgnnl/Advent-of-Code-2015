import java.util.Arrays;

public class Gift {
    private int length;
    private int width;
    private int height;
    private int[] surfaceAreas;

    public Gift(String input) {
        String[] result = input.split("x");

        this.length = Integer.parseInt(result[0]);
        this.width = Integer.parseInt(result[1]);
        this.height = Integer.parseInt(result[2]);

        surfaceAreas = new int[3];
        surfaceAreas[0] = length * width;
        surfaceAreas[1] = height * width;
        surfaceAreas[2] = length * height;
    }

    private int getSmallestSurfaceArea(){
        return Arrays.stream(surfaceAreas)
                .min()
                .getAsInt();
    }

    public int getWrapperSizeNeeded(){
        int wrapperSize = 0;
        for(int surfaceArea : surfaceAreas){
            wrapperSize += 2 * surfaceArea;
        }

        wrapperSize += getSmallestSurfaceArea();

        return wrapperSize;
    }
}
