import java.util.Scanner;

public class Barcode {

    public static void main(String[] args) {
        System.out.println(binaryConverter(5));
    }

    public static void run() {
        System.out.println("Welcome to Nirayka's Postal- to Bar-Code Converter!");
        boolean entering = true;
        while (entering) {
            System.out.println("Please type in the postal code that you'd like to convert, and hit enter.");
            Scanner scan = new Scanner(System.in);
            String postalString = scan.nextLine();
            if (isPostalCodeValid(postalString)) {
                int postalInt = Integer.parseInt(postalString);
                runIndividual(postalInt);
            } else if (postalString.toLowerCase().equals("esc")) {
                System.out.println("You have chosen to exit the program.");
                entering = false;
            } else {
                System.out.println("You have entered an invalid option.");
            }
        }
    }

    public static boolean isPostalCodeValid(String postalCode) {
        if (isNumeric(postalCode)) {
            if (postalCode.length() == 5) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNumeric(String postalCode) {
        if (postalCode == null) {
            return false;
        }
        try {
            int thisInt = Integer.parseInt(postalCode);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static void runIndividual(int postalInt) {

    }


    public static String binaryConverter(int input) { // got to fix this, must convert EACH INDIVIDUAL DIGIT to binary
        
    }


    public static String initialBarcodeConverter(String binary) {
        String initialBarcode = "";
        for (int i = 0; i < binary.length(); i++) {
            String bar = "";
            char thisDigitChar = binary.charAt(i);
            String thisDigit = String.valueOf(thisDigitChar);
            if (thisDigit.equals("0")) {
                bar = ":";
            } else if (thisDigit.equals("1")) {
                bar = "|";
            }
            initialBarcode += bar;
        }
        return initialBarcode;
    }

    public static String addCorrectionDigit(int postalInt) {
        String correctionBars = "";
        int sum = 0;
        while (postalInt != 0) {
            sum = sum + postalInt % 10;
            postalInt = postalInt / 10;
        }
        int remainder = sum % 10;
        if (remainder != 0) {
            correctionBars += initialBarcodeConverter(binaryConverter(remainder));
        }
        return correctionBars;
    }


}
