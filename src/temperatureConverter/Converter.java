package temperatureConverter;

import static util.util.getInput;

public class Converter {

    public static void entConverter(){
        System.out.println("\t\t\t---Welcome to the 'Temperature Converter'---");
        while (true){
            int choose=getInput("""
                1:Celsius to Fahrenheit
                2:Fahrenheit to Celsius
                3:Exit
                """,Integer.class);
            while (choose<1 || choose>3){
                choose=getInput("You can choose 1 or 2", Integer.class);
            }

            switch (choose){
                case 1:
                    System.out.println("--------------");
                    double celsius=getInput("Enter the celsius value:", Double.class);
                    System.out.println(celsiusToFahrenheit(celsius));
                    System.out.println("--------------");
                    break;
                case 2:
                    System.out.println("--------------");
                    double fahrenheit=getInput("Enter the fahrenheit value:", Double.class);
                    System.out.println(fahrenheitToCelsius(fahrenheit));
                    System.out.println("--------------");
                    break;
                case 3:
                    return;
            }
        }
    }

    public static Double celsiusToFahrenheit(Double celsius){
        return ((celsius * 9) / 5) + 32;
    }

    public static Double fahrenheitToCelsius(Double fahrenheit){
        return (fahrenheit-32)*5/9;
    }

}
