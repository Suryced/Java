import java.awt.Color;

public class Luminance
{
    public static double intensity(Color color)
    { // monochrome luminance
        int r = color.getRed();
        int g = color.getGreen();
        int b = color.getBlue();
        return .299*r + .587*g + .114*b;
    }

    public static Color toGray(Color color) 
    {
        int y = (int) Math.round(intensity(color));
        Color gray = new Color(y, y, y);
        return gray;
    }

    public static boolean areCompatible(Color a, Color b) 
    {
        return Math.abs(intensity(a) - intensity(b)) >= 128.0;
    }

    public static void main(String[] args) 
    {
        int[] a = new int[6];
        for (int i = 0; i < a.length; i++) 
        {
            a[i] = Integer.parseInt(args[i]);
        }
        Color c1 = new Color(a[0], a[1], a[2]);
        Color c2 = new Color(a[3], a[4], a[5]);
        System.out.println(areCompatible(c1, c2));
    }
}