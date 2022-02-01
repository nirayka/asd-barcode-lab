import java.util.Scanner;

public class Barcode {

    public static void main(String[] args) {
        System.out.println(binaryConverter(12));
        /*
        System.out.println("Welcome to Nirayka's Postal- to Bar-Code Converter!");
        boolean entering = true;
        while (true) {
            System.out.println("Please enter the postal code that you'd like to convert to a barcode.");
            Scanner scan = new Scanner(System.in);
            int postalCode = scan.nextInt();
            int length = String.valueOf(postalCode);
            if (length > 5 || length < 5) {

            } */
        }

        public static int binaryConverter(int decimal) {
            return(Integer.parseInt(Integer.toBinaryString(decimal)));
        }


    }
