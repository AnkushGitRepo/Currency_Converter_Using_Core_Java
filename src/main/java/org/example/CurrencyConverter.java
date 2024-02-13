package org.example;
import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BackendWork newObj = new BackendWork();
        // Printing Welcome Message
        System.out.println("\n                                       *---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*");
        System.out.println("                                       *--------------------------WELCOME TO---------------------------*");
        System.out.println("                                       *------------------CURRENCY CONVERTER SYSTEM--------------------*");
        System.out.println("                                       *---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*\n");

        // Creating a do-while loop to ask what user want again. Until user choice to exit the program (Press 5).
        boolean loop = true;
        do{
            // Displaying Options to User.
            System.out.println("\nPRESS 1 TO DISPLAY AVAILABLE CURRENCIES.");
            System.out.println("PRESS 2 TO EXCHANGE CURRENCY.");
            System.out.println("PRESS 3 TO DISPLAY EXCHANGE RATE.");
            System.out.println("PRESS 4 TO UPDATE EXCHANGE RATE(ONLY FOR DEVELOPERS).");
            System.out.print("PRESS 5 TO EXIT THE PROGRAM.\nENTER YOUR CHOICE: ");
            int choice = scanner.nextInt(); //User is asked for choice.

            switch (choice) {
                case 1:
                    // Case 1: To Display The List OF Currencies.
                    System.out.println("\nList of Currencies:");
                    System.out.println(" 1. US Dollar (USD)                           6. Australian Dollar (AUD)              11. Singapore Dollar (SGD)  ");
                    System.out.println(" 2. Euro (EUR)                                7. Canadian Dollar (CAD)                12. Swedish Krona (SEK)     ");
                    System.out.println(" 3. Japanese Yen (JPY)                        8. Swiss Franc (CHF)                    13. South Korean Won (KRW)  ");
                    System.out.println(" 4. British Pound Sterling (GBP)              9. Hong Kong Dollar (HKD)               14. Norwegian Krone (NOK)   ");
                    System.out.println(" 5. Chinese Yuan (CNY)                       10. Indian Rupee (INR)                   15. New Zealand Dollar (NZD)");
                    break;

                case 2:
                    // Case 2: To Exchange The Currencies
                    System.out.print("\nENTER THE RESPECTIVE CURRENCY CODE  YOU HAVE:      ");
                    String baseCurrency = scanner.next().toUpperCase();
                    System.out.print("ENTER THE CURRENCY CODE YOU WANT TO CONVERT INTO:  ");
                    String toConvertCurrency = scanner.next().toUpperCase();
                    System.out.print("ENTER THE AMOUNT YOU WANT TO CONVERT:              ");
                    double baseAmount = scanner.nextDouble();

                    double convertedAmount = newObj.convert(baseAmount, baseCurrency, toConvertCurrency);
                    System.out.println("CONVERTED AMOUNT = " + convertedAmount);
                    break;

                case 3:
                    // Case 3: To Display The Exchange Rate.
                    System.out.print("\nENTER THE RESPECTIVE CURRENCY CODE  YOU HAVE:      ");
                    String baseCurrencyForRate = scanner.next().toUpperCase();
                    System.out.print("ENTER THE CURRENCY CODE YOU WANT TO CONVERT INTO:  ");
                    String toConvertCurrencyForRate = scanner.next().toUpperCase();
                    int sourceIndex = BackendWork.getCurrencyIndex(baseCurrencyForRate);
                    int ConvertCurrencyForRate = BackendWork.getCurrencyIndex(toConvertCurrencyForRate);
                    double exchangeRate = BackendWork.exchangeRates[sourceIndex][ConvertCurrencyForRate];
                    System.out.println("EXCHANGE RATE OF " + baseCurrencyForRate + " TO " + toConvertCurrencyForRate + " is : " + exchangeRate);
                    break;

                case 4:
                    // Case 4: To Update Exchange Rate.
                    System.out.print("\nENTER YOUR DEVELOPER ID: "); // Asking Developer to enter ID
                    String developerID = scanner.next();
                    int countID = 0;
                    // Creating a loop which iterate through User-Details Array (devDetails). After user enter his ID we are going to check that ID in devDetails array.
                    for(int i = 0 ; i < BackendWork.devDetails.length; i++) {
                        if (developerID.equals(BackendWork.devDetails[i][0])){
                            System.out.print("ENTER YOUR DEVELOPER PASSWORD: "); // Asking Developer to enter Password. If ID is correct.
                            String developerPass = scanner.next();
                            int countPASS = 0;
                            for(int j = 0; j < 2; j++){
                                // Checking if enter password for that ID is correct or not.
                                if(developerPass.equals(BackendWork.devDetails[i][1])){
                                    newObj.changeExchangeRate();
                                    break;
                                }
                                else{;
                                    newObj.wrongPass(countPASS);
                                    countPASS++;
                                }
                            }
                        }
                        else{
                            newObj.wrongID(countID);
                            countID++;
                        }
                    }
                    break;

                case 5:
                    // Case 5: To Exit The Program
                    System.out.println("\n              HAVE A GREAT DAY!              ");
                    System.out.println("THANK YOU FOR USING CURRENCY CONVERTER SYSTEM\n                  EXITING...\n");
                    loop = false;
                    break;

                default:
                    // default: To Tackle Invalid Choice (Number)
                    System.out.println("INVALID CHOICE, PLEASE TRY AGAIN...\n");
                    break;
            }
        }while(loop);
    }
}

class BackendWork {
    static Scanner scanner = new Scanner(System.in);
    static double[][] exchangeRates = {
            // USD-0   EUR-1   JPY-2   GBP-3   CNY-4   AUD-5   CAD-6   CHF-7   HKD-8   INR-9   SGD-10   SEK-11   KRW-12   NOK-13   NZD-14
            {1.0000, 0.9132, 120.72, 0.7841, 6.7072, 0.6687, 1.3407, 1.0627, 7.8053, 83.22, 1.4056, 8.9064, 1195.06, 8.0517, 0.6054},  //USD 0
            {1.0950, 1.0000, 131.65, 0.8586, 7.3202, 0.7309, 1.4681, 1.1700, 8.7170, 93.93, 1.5892, 10.2205, 1379.25, 9.2502, 0.7066}, //EUR 1
            {0.0082, 0.0076, 1.0000, 0.0065, 0.0550, 0.0054, 0.0109, 0.0087, 0.0651, 0.7005, 0.0119, 0.0760, 10.23, 0.0684, 0.0051},   // JPY 2
            {1.2754, 1.1646, 152.21, 1.0000, 8.5255, 0.8464, 1.6907, 1.3496, 10.0620, 108.17, 1.8403, 11.8592, 1590.87, 10.6501, 0.8099},  // GBP 3
            {0.1500, 0.1369, 18.285, 0.1179, 1.0000, 0.1000, 0.2000, 0.1600, 1.1964, 12.80, 0.2182, 1.3951, 188.30, 1.2675, 0.0952},       // CNY 4
            {1.4955, 1.3710, 183.53, 1.1825, 10.0000, 1.0000, 2.0000, 1.6000, 12.0000, 128.00, 2.1820, 13.9510, 1883.00, 12.6750, 0.9524}, // AUD 5
            {0.7461, 0.6801, 91.40, 0.5870, 5.0000, 0.5000, 1.0000, 0.8000, 6.0000, 64.00, 1.0910, 6.9755, 941.50, 6.3375, 0.4762},        // CAD 6
            {0.9422, 0.8614, 115.32, 0.7489, 6.4003, 0.6402, 1.2803, 1.0242, 7.6020, 81.36, 1.3792, 8.8595, 1191.50, 8.0187, 0.6038},  // CHF 7
            {0.0078, 0.0071, 0.9526, 0.0062, 0.0528, 0.0053, 0.0106, 0.0085, 0.0631, 0.6763, 0.0115, 0.0740, 9.94, 0.0668, 0.0050},   //HKD 8
            {0.0136, 0.0124, 1.6725, 0.0109, 0.0928, 0.0093, 0.0186, 0.0148, 0.1104, 1.1805, 0.0201, 0.1295, 17.43, 0.1170, 0.0088},    // INR 9
            {0.2000, 0.1826, 24.53, 0.1590, 1.3542, 0.1354, 0.2707, 0.2166, 1.6124, 17.27, 0.2937, 1.8866, 254.40, 1.7119, 0.1288},   // SGD 10
            {0.6678, 0.6094, 81.72, 0.5298, 4.5186, 0.4519, 0.9037, 0.7229, 5.3695, 57.48, 0.9794, 6.2881, 847.10, 5.7001, 0.4285},   // SEK 11
            {0.3729, 0.3404, 45.66, 0.2962, 2.5246, 0.2525, 0.5049, 0.4039, 2.9942, 32.09, 0.5456, 3.5048, 473.00, 3.1837, 0.2398},   // KRW 12
            {1.1783, 1.0754, 144.36, 0.9380, 7.9973, 0.7997, 1.5993, 1.2794, 9.4979, 101.74, 1.7292, 11.0973, 1496.40, 10.0576, 0.7571},  // NOK 13
            {0.1291, 0.1177, 15.80, 0.1026, 0.8753, 0.0875, 0.1751, 0.1401, 1.0415, 11.16, 0.1897, 1.2186, 164.40, 1.1044, 0.0831},   // NZD 14
    };

    static String[][] devDetails = {{"SARVESH0019", "A6SARVESH"}, {"ANKUSH0016", "A6ANKUSH"}, {"ADITI0001", "A6ADITI"}, {"RAJVI0008", "A6RAJVI"}, {"JAYDIP0014", "A6JAYDIP"}};


    // THIS METHOD IS GOING TO BE USE FOR GETTING INDEX OF CURRENCIES
    static int getCurrencyIndex(String currencyIndex) {
        switch (currencyIndex) {
            case "USD": return 0;
            case "EUR": return 1;
            case "JPY": return 2;
            case "GBP": return 3;
            case "CNY": return 4;
            case "AUD": return 5;
            case "CAD": return 6;
            case "CHF": return 7;
            case "HKD": return 8;
            case "INR": return 9;
            case "SGD": return 10;
            case "SEK": return 11;
            case "KRW": return 12;
            case "NOK": return 13;
            case "NZD": return 14;
        }
        return -1;
    }

    // THIS METHOD IS GOING TO USE IN CONVERSION OF ANY CURRENCY
    double convert(double baseAmount, String baseCurrency, String toConvertCurrency) {
        int sourceCurrencyIndex = getCurrencyIndex(baseCurrency);
        int toConvertCurrencyIndex = getCurrencyIndex(toConvertCurrency);
        System.out.println("CURRENT EXCHANGE RATE OF "+baseCurrency+"-"+toConvertCurrency+" IS "+exchangeRates[sourceCurrencyIndex][toConvertCurrencyIndex]);
        return baseAmount * exchangeRates[sourceCurrencyIndex][toConvertCurrencyIndex];
    }

    // THIS METHOD IS GOING TO USE FOR CHANGE THE EXCHANGE RATES
    void changeExchangeRate() {
        // Asking User to enter base and toConvert currency. After that we are calling the getCurrencyIndex Method to get the index of the currency.
        System.out.print("ENTER THE BASE CURRENCY CODE THAT YOU HAVE      : ");
        String baseCurrency = scanner.next().toUpperCase();
        System.out.print("ENTER THE CURRENCY CODE YOU WANT TO CONVERT INTO: ");
        String toConvertCurrency = scanner.next().toUpperCase();

        int indexOfBase = getCurrencyIndex(baseCurrency);
        int indexOfToConvert = getCurrencyIndex(toConvertCurrency);

        // Printing the Current Exchange Rate and Asking User to update the exchange rate with new values.
        System.out.println("CURRENT EXCHANGE RATE OF " + baseCurrency + "-" + toConvertCurrency + " IS " + exchangeRates[indexOfBase][indexOfToConvert] + "\n");
        System.out.print("PLEASE ENTER THE NEW EXCHANGE RATE: ");
        exchangeRates[indexOfBase][indexOfToConvert] = scanner.nextDouble();
    }

    //THIS TWO METHOD WILL ALWAYS CHECK, IS THE LOOP FULL TRAVERSED OR NOT. BEFORE PRINTING WRONG ID OR WRONG PASSWORD.
    void wrongPass(int count){
        if(count == 1){
            System.out.println("INVALID DEVELOPER PASSWORD! PLEASE TRY AGAIN");
        }
    }
    void wrongID(int count){
        if(count == 4){
            System.out.println("INVALID DEVELOPER ID! PLEASE TRY AGAIN");
        }
    }
}
