public class CurrencyConverter {
    private String[] currencies;
    private double[] exchangeRates;

    public CurrencyConverter() {
        currencies = new String[] { 
        "PHP", "USD", "EUR", "GBP", "JPY", "CAD", "AFN", "BYR", 
        "COP", "KPW", "KRW", "SEK", "SAR", "SGD", "PKR", "MMK", "LBP", "KZT", "DOP", "BND", 
        "GNF", "MYR", "IDR", "ILS", "HKD", "INR", "LRD", "RUB", "AED", "VND", "YER"
        };
         
        exchangeRates = new double[] { 
        1.0, 0.018, 0.016, 0.014, 2.58, 0.024, 1.31, 0.045, 
        71.33, 15.886, 23.40, 0.19, 0.066, 0.024, 5.39, 36.94, 263.71, 8.01, 1.00, 0.024,
        150.67, 0.082, 267.87, 0.067, 0.14, 1.45, 3.26, 1.71, 0.064, 422.50, 4.39
        };
    }

    public double convert(double amount, String inputAmount, String toConvert) {
        int fromIndex = -1;
        int toIndex = -1;

        for (int i = 0; i < currencies.length; i++) {
            if (currencies[i].equalsIgnoreCase(inputAmount)) {
                fromIndex = i;
            }
            if (currencies[i].equalsIgnoreCase(toConvert)) {
                toIndex = i;
            }
        }

        if (fromIndex != -1 && toIndex != -1) {
            double fromRate = exchangeRates[fromIndex];
            double toRate = exchangeRates[toIndex];
            return amount * (toRate / fromRate);
        } else {
            System.out.println("Invalid currency.");
            return -1.0;
        }
    }

    public void printCurrencies() {
        System.out.println("Available Currencies:");
        for (String currency : currencies) {
            System.out.println(currency);
        }
    }
}
