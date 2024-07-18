# Currency Converter

The Currency Converter is a Java console application that allows users to view available currencies, convert amounts between currencies, and display or update exchange rates.

## Features

- **Display Available Currencies**: View a list of supported currencies.
- **Currency Exchange**: Convert an amount from one currency to another.
- **Display Exchange Rate**: View the current exchange rate between two currencies.
- **Update Exchange Rate**: Developers can update exchange rates after authentication.

## How to Use

1. **Display Available Currencies**:
    - Run the program and select option 1 to view the list of supported currencies.

2. **Convert Currency**:
    - Select option 2.
    - Enter the currency code you have.
    - Enter the currency code you want to convert to.
    - Enter the amount to convert.
    - The converted amount will be displayed.

3. **Display Exchange Rate**:
    - Select option 3.
    - Enter the currency code you have.
    - Enter the currency code you want to convert to.
    - The exchange rate will be displayed.

4. **Update Exchange Rate**:
    - Select option 4.
    - Enter your developer ID and password.
    - Enter the base currency code.
    - Enter the currency code you want to convert to.
    - Enter the new exchange rate.

5. **Exit**:
    - Select option 5 to exit the program.

## Developer Credentials

- **ID**: SARVESH0019, Password: A6SARVESH
- **ID**: ANKUSH0016, Password: A6ANKUSH
- **ID**: ADITI0001, Password: A6ADITI
- **ID**: RAJVI0008, Password: A6RAJVI
- **ID**: JAYDIP0014, Password: A6JAYDIP

## How to Run

1. Ensure you have Java installed on your system.
2. Clone the repository or download the source code.
3. Compile the `CurrencyConverter.java` file using the command:
    ```sh
    javac CurrencyConverter.java
    ```
4. Run the compiled program using the command:
    ```sh
    java org.example.CurrencyConverter
    ```

## Example

```sh
PRESS 1 TO DISPLAY AVAILABLE CURRENCIES.
PRESS 2 TO EXCHANGE CURRENCY.
PRESS 3 TO DISPLAY EXCHANGE RATE.
PRESS 4 TO UPDATE EXCHANGE RATE(ONLY FOR DEVELOPERS).
PRESS 5 TO EXIT THE PROGRAM.
ENTER YOUR CHOICE: 2
ENTER THE RESPECTIVE CURRENCY CODE  YOU HAVE: USD
ENTER THE CURRENCY CODE YOU WANT TO CONVERT INTO: EUR
ENTER THE AMOUNT YOU WANT TO CONVERT: 100
CONVERTED AMOUNT = 91.32
