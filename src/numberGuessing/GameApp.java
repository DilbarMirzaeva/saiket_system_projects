package numberGuessing;

import static util.util.getInput;

public class GameApp {
    public static void main(String[] args) {
        System.out.println("\t\t\t----Number Guessing----");
        String name=getInput("Please enter your name:",String.class);
        System.out.println("Welcome "+name+",in this game, you have to try to guess a random number between 0 and 1000.\nLET'S GO!!!");
        int random= (int) (Math.random() * 1001);
        guessRandom(random);
    }

    public static void guessRandom(int random){
        int attempts=0;
        int num=getInput("Guess the number : ",Integer.class);

        while (true){
            if(num==random){
                attempts++;
                System.out.println(">>>>>>>> Congratulations!! You are right <<<<<<<<<<"+"\n"+"Your attempt(s) : "+attempts);
                return;
            } else if (num>random) {
                System.out.println("This number is \u001B[31mlarge\u001B[0m, try again:");
                num = getInput("", Integer.class);
                attempts++;
            } else  {
                System.out.println("This number is \u001B[31msmall\u001B[0m, try again:");
                num = getInput("", Integer.class);
                attempts++;
            }
        }
    }
}
