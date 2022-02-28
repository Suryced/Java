import java.awt.Color;

public class Grayscale
{
    public static void main(String[] args) 
    { // show image in greyscale
        Picture picture = new Picture(args[0]);
        for (int col = 0; col < picture.width(); col++) 
        {
            for (int row = 0; row < picture.height(); row++) 
            {
                Color color = picture.get(col, row);
                Color gray = Luminance.toGray(color);
                picture.set(col, row, gray);
            }
        }
        picture.show();
    }
}