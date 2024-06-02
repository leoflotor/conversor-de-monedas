import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("*******************************************");

        System.out.println("Welcome to the currency exchange converter!");

        List<Exchange> exchanges = new ArrayList<>();

        int exit = 0;
        while (exit != 1) {

            System.out.println("\n*******************************************");
            System.out.println("""
                    Select one currency exchange from the list below:
                    1) USD =>> ARS
                    2) ARS =>> USD
                    3) USD =>> BRL
                    4) BRL =>> USD
                    5) USD =>> COP
                    6) COP =>> USD
                    7) Exit
                    8) Show exchanges log

                    USD: United States Dollar
                    ARS: Argentine Peso
                    BRL: Brazilian Real
                    COP: Colombian Peso
                    """);

            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter currency exchange option: ");

            try {
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
                        fromCurrency = null;
                        toCurrency = null;
                        break;
                }

                if (exchangeOption >=1 && exchangeOption <= 6) {
                    CurrencyExchangeRequest request = new CurrencyExchangeRequest();
                    CurrencyExchangeRate exchangeRate = request.currencyExchange(fromCurrency, toCurrency);

                    System.out.println("The current exchange rate is: " + exchangeRate.conversion_rate());

                    System.out.println("How much " + fromCurrency + " do you want to convert? ");
                    Double total = Double.valueOf(scanner.nextLine());

                    double newTotal = total * exchangeRate.conversion_rate();

                    System.out.println("The exchange from " +
                            total +
                            " [" + fromCurrency + "]" +
                            " is " +
                            newTotal +
                            " [" + toCurrency + "]");

                    Exchange exchange = new Exchange(fromCurrency,toCurrency,total,newTotal);
                    exchanges.add(exchange);
                } else if (exchangeOption == 7) {
                    System.out.println("Thank you for using the currency exchange converter!\n");
                } else if (exchangeOption == 8) {
                    exchanges.forEach(System.out::println);
                } else {
                    System.out.println("The selected option (" + exchangeOption + ") is invalid!");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("The selected option " + e.getMessage().toLowerCase() + ", is invalid!");
            }
        }
    }
}
