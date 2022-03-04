//This is a program that will prompt user for input, and will convert the resulting number into gallons and US dollars.
import java.util.*;
import java.text.DecimalFormat;

public class Convert {
    public static void main(String[] args) throws Exception {
    
        double liters;             
        double literPrice;
        double total;
        double galConvert;
        double exRate;
        double finalTotalGal;
        String keepConverting;
        keepConverting="Y";     //Initial value for keepConverting
        DecimalFormat f = new DecimalFormat("##.##");   //Playing around, seeing how this works. 
        Scanner sc = new Scanner(System.in);    //Start of the scanner prompting input from user.

        while (keepConverting.toUpperCase().equals("Y")){
            System.out.println("Enter number of liters: ");
            liters = sc.nextDouble();

            System.out.println("Enter price per liter in Euros: ");
            literPrice = sc.nextDouble();

            sc.nextLine(); //Keep this here, otherwise won't be able to answer prompt to continue.

            //Formulas
            total= literPrice*liters;   //get the initial total for liters and price.
            galConvert = liters/3.785;  //Conversion from liters entered by user into gallons.
            exRate = literPrice*1.09;   //Conversion from Euros to US dollars, exchange rate is up to date as of 3/04/2022.
            finalTotalGal = (exRate*total)/galConvert; //Final total gallons.

            //Results
            System.out.println("\nThe total price in Euros is "+f.format(total));
            System.out.println("The total price in US dollars is "+f.format(exRate*total));
            System.out.println("\nYou purchased " +f.format(galConvert)+ " gallons");
            System.out.println("You paid " +f.format(finalTotalGal)+ " per gallon.");
            
            System.out.print("\nDo you want to continue? [Y/N]: " );
            keepConverting=sc.nextLine();

            if(keepConverting.toUpperCase().equals("N")){
                System.out.println("Goodbye!");
                System.exit(0);
            }
        }
    }
}