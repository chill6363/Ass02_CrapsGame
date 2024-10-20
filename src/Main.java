import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random gen = new Random();
        boolean keepCrapping = false;
        boolean keepCrappingPoint = false;
        boolean replay;
        String trash;
        int crap1, crap2, crapTotal, pointValue;
        System.out.println("Welcome to Craps! Starting the game...");
        while(!keepCrapping) {
            keepCrappingPoint = false;
            System.out.print("Press Enter to roll. ");
            in.nextLine();
            crap1 = gen.nextInt(6) + 1;
            crap2 = gen.nextInt(6) + 1;
            crapTotal = crap1 + crap2;
            System.out.println("Die 1: " + crap1);
            System.out.println("Die 2: " + crap2);
            System.out.println("Total: " + crapTotal);
            if (crapTotal == 2 || crapTotal == 3 || crapTotal == 12 || crapTotal == 7 || crapTotal == 11){ //IF WIN OR LOSS
                if (crapTotal == 2 || crapTotal == 3 || crapTotal == 12){   //IF LOSS
                    System.out.println("You got craps! You lose!");
                }
                else{   //IF WIN
                    System.out.println("You got a natural! You win!");
                }
                System.out.println("Would you like to play again?");
                do { //play again while loop, looks for invalid inputs
                    System.out.print("Input Y/N: ");
                    replay = false;
                    if (in.hasNext("y") || (in.hasNext("Y"))) {
                        System.out.println("Restarting game...");
                        System.out.println();
                        System.out.println();
                        replay = true;
                        //in.nextLine();
                    } else if (in.hasNext("n") || (in.hasNext("N"))) {
                        keepCrapping = true;
                        System.out.println("Thank you for playing!");
                        replay = true;
                        //in.nextLine();
                    } else {
                        trash = in.nextLine();
                        System.out.println("Invalid input of: " + trash);
                    }
                } while (!replay);
            }
            else{   //Point is set, rolling continues
                pointValue = crapTotal;
                System.out.println("The point value is now " + pointValue + ". Roll until a 7 or the point value is met.");
                while (!keepCrappingPoint){ //Point loop. Loops until either 7 or point is rolled, asks player to play again
                    System.out.print("Press Enter to roll.");
                    in.nextLine();
                    crap1 = gen.nextInt(6) + 1;
                    crap2 = gen.nextInt(6) + 1;
                    crapTotal = crap1 + crap2;
                    System.out.println("Die 1: " + crap1);
                    System.out.println("Die 2: " + crap2);
                    System.out.println("Total: " + crapTotal);
                    if (crapTotal == 7 || crapTotal == pointValue){
                        if(crapTotal == 7) {
                            System.out.println("You rolled a 7! You lose!");
                        }
                        else{
                            System.out.println("You rolled the point! You win!");
                        }
                        keepCrappingPoint = true;
                        System.out.print("Would you like to play again? ");
                        do{ //play again while loop, looks for invalid inputs
                            System.out.print("Input Y/N: ");
                            replay = false;
                            if (in.hasNext("y") || (in.hasNext("Y"))) {
                                System.out.println("Restarting game...");
                                System.out.println();
                                System.out.println();
                                replay = true;
                                //in.nextLine();
                            }
                            else if (in.hasNext("n") || (in.hasNext("N"))) {
                                keepCrapping = true;
                                System.out.println("Thank you for playing!");
                                replay = true;
                                //in.nextLine();
                            }
                            else{
                                trash = in.nextLine();
                                System.out.println("Invalid input of: " + trash);
                            }
                        } while(!replay);

                    }
                }
            }
        }
    }
}
