package util;

import java.util.Scanner;

public class util {

    public static final Scanner sc = new Scanner(System.in);

    public static <T> T getInput(String text, Class<T> type) {

        System.out.print(text);

        while (true) {
            String input = sc.nextLine();
            try {
                if (type == Integer.class) {
                    return type.cast(Integer.parseInt(input));
                } else if (type == Double.class) {
                    return type.cast(Double.parseDouble(input));
                } else if (type == Boolean.class) {
                    return type.cast(Boolean.parseBoolean(input));
                }  else {
                    return type.cast(input);
                }
            }catch (Exception e){
                System.out.println("Try again,invalid input..");
            }
        }


    }
}
