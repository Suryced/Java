public class StockQuote
{
    private static String readHTML(String symbol)
    { // Return HTML corresponding to stock symbol.
        In page = new In("https://finance.yahoo.com/quote/"+symbol+"?ltr=1");
        return page.readAll();
    }

    public static double priceOf(String symbol) 
    { // Return current stock price for symbol.
        String html = readHTML(symbol);
        // System.out.println(html);
        int p       = html.indexOf("data-pricehint", 0);
        int from    = html.indexOf(">", p);
        int to      = html.indexOf("</fin-streamer>", from);
        // System.out.println("p = " + p + " from = " + from + " to = " + to);
        String price = html.substring(from + 1, to);
        return Double.parseDouble(price.replaceAll(",",""));
    }

    public static void main(String[] args)
    {
        String symbol = args[0];
        double price = priceOf(symbol);
        System.out.println(price);
    }
}