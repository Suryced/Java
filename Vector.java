public class Vector
{
    private final double[] coords;

    public Vector(double[] a)
    {
        coords = new double[a.length];
        for (int i = 0; i < a.length; i++)
            coords[i] = a[i];
    }

    public Vector plus(Vector that)
    {
        double[] result = new double[coords.length];
        for (int i = 0; i < coords.length; i++)
        {
            result[i] = this.coords[i] + that.coords[i];
        }
        return new Vector(result);
    }

    public Vector minus(Vector that)
    {
        double[] result = new double[coords.length];
        for (int i = 0; i < coords.length; i++)
        {
            result[i] = this.coords[i] - that.coords[i];
        }
        return new Vector(result);
    }

    public Vector scale(double alpha)
    {
        double[] result = new double[coords.length];
        for (int i = 0; i < coords.length; i++)
        {
            result[i] = alpha * coords[i];
        }
        return new Vector(result);
    }

    public double dot(Vector that)
    {
        double sum = 0.0;
        for (int i = 0; i < coords.length; i++)
        {
            sum += this.coords[i] * that.coords[i];
        }
        return sum;
    }

    public double magnitude()
    { return Math.sqrt(this.dot(this)); }
    public Vector direction()
    { return this.scale(1/this.magnitude()); }
    public double cartesian(int i)
    { return coords[i]; }

}