import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("*******************************************");

        System.out.println("Welcome to the currency exchange converter!\n");

        int exit = 0;
        while (exit != 1) {

            System.out.println("*******************************************");
            System.out.println("Select one currency exchange from the list below:\n" +
                    "1) USD =>> ARS\n" +
                    "2) ARS =>> USD\n" +
                    "3) USD =>> BRL\n" +
                    "4) BRL =>> USD\n" +
                    "5) USD =>> COP\n" +
                    "6) COP =>> USD\n" +
                    "7) Exit \n\n" +
                    "USD: United States Dollar\n" +
                    "ARS: Argentine Peso\n" +
                    "BRL: Brazilian Real\n" +
                    "COP: Colombian Peso\n");

            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter currency exchange option: ");
            int exchangeOption = Integer.parseInt(scanner.nextLine());

            String fromCurrency;
            String toCurrency;
            switch (exchangeOption) {
                case 1:
                    fromCurrency = "USD";
                    toCurrency = "ARS";
                    break;
                case 2:
                    fromCurrency = "ARS";
                    toCurrency = "USD";
                    break;
                case 3:
                    fromCurrency = "USD";
                    toCurrency = "BRL";
                    break;
                case 4:
                    fromCurrency = "BRL";
                    toCurrency = "USD";
                    break;
                case 5:
                    fromCurrency = "USD";
                    toCurrency = "COP";
                    break;
                case 6:
                    fromCurrency = "COP";
                    toCurrency = "USD";
                    break;
                case 7:
                    exit = 1;
                    fromCurrency = null;
                    toCurrency = null;
                    break;
                default:
                    throw new IllegalStateException("Unexpected currency exchange option: " + exchangeOption);
            }

            if (exchangeOption != 7) {
                CurrencyExchangeRequest request = new CurrencyExchangeRequest();
                CurrencyExchangeRate exchange = request.currencyExchange(fromCurrency, toCurrency);

                System.out.println("The current exchange rate is: " + exchange.conversion_rate() + "\n");

                System.out.println("How much " + fromCurrency + " do you want to convert? ");
                Double total = Double.valueOf(scanner.nextLine());

                double newTotal = total * exchange.conversion_rate();

                System.out.println("The exchange from " +
                        total +
                        " [" + fromCurrency + "]" +
                        " is " +
                        newTotal +
                        " [" + toCurrency + "]" + "\n");
            } else {
                System.out.println("Thank you for using the currency exchange converter!\n");
            }
        }
    }
}
