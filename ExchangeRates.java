import java.util.InputMismatchException;
import java.util.Scanner;

public class ExchangeRates {
    public static CurrencyConverter converter;
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        CurrencyConverter converter = new CurrencyConverter();
        boolean flag = true;
        

        System.out.println("==============================");
        System.out.println("| PHP Exchange rates program |");
        System.out.println("==============================");
        
        while(flag){
        char choice;

        try{
        System.out.print("Enter the amount in PHP: ");
        double amountPHP = in.nextDouble();
        
        in.nextLine();
        converter.printCurrencies();

        System.out.println("-------------------------------------------------");
        System.out.print("Choose a currency: ");
        System.out.println("(Type the currency to convert)");
        System.out.println("-------------------------------------------------");
        String targetCurrency = in.nextLine();

        double convertedAmount = converter.convert(amountPHP, "PHP", targetCurrency);

        if (convertedAmount != -1.0) {
            System.out.println("=================================================");
            System.out.println("Entered amount: " + amountPHP + " PHP");
            System.out.println("Converted amount: " + convertedAmount + " " + targetCurrency.toUpperCase());
            System.out.println("=================================================");
        }
        }catch (InputMismatchException e){
            System.out.println("Invalid Input");
            break;
        }


        System.out.println("\nConvert again?");
        System.out.print("(Y/N): ");

        choice = in.next().toUpperCase().charAt(0);
        switch(choice){
            case 'N':
            System.out.println("Program Exit...");
            flag = false;
            break;
            case 'Y':
            System.out.println("");
            continue;
            default:
            System.out.println("Invalid Input\nTerminating Program...");
            flag = false;
            break;
        }

    }

        in.close();
    }
}