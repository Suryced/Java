public class Split 
{
    public static void main(String[] args)
    {   // Split file by column into n files.
        String name = args[0];
        int n = Integer.parseInt(args[1]);
        String delimiter = ",";
        // Create output streams.
        Out[] out = new Out[n];
        for (int i = 0; i < n; i++)
        {
            out[i] = new Out(name + i + ".txt");
        }
        In in = new In(name + ".csv");
        while (in.hasNextLine())
        {   // Read a line and write fields to output streams.
            String line = in.readLine();
            String[] fields = line.split(delimiter);
            for (int i = 0; i < n; i++)
            {
                out[i].println(fields[i]);
            }
        }
    }
}