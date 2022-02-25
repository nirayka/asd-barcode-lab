import java.util.Scanner;

public class Barcode {

    public static void run() {
        System.out.println("Welcome to Nirayka's Postal- to Bar-Code Converter!");
        boolean entering = true;
        while (entering) {
            System.out.println("Please type in the postal code that you'd like to convert and hit enter.\nIf you'd like to exit the program, type in esc and hit enter.");
            Scanner scan = new Scanner(System.in);
            String postalString = scan.nextLine();
            if (isPostalCodeValid(postalString)) {
                System.out.println("The converted barcode is as follows -- " + runIndividual(postalString));
            } else if (postalString.toLowerCase().equals("esc")) {
                System.out.println("You have chosen to exit the program.");
                entering = false;
            } else {
                System.out.println("You have entered an invalid postal code or invalid option.\nNote that the postal code must be numeric and five digits in length.");
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
            Double.parseDouble(postalCode);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static String runIndividual(String postalString) {
        String binaryString = binaryConverter(postalString);
        String initialBarcode = initialBarcodeConverter(binaryString);
        String correctionDigit = addCorrectionDigit(postalString);
        String almostFinalBarcode = initialBarcode + correctionDigit;
        String finalBarcode = finishBarcode(almostFinalBarcode);
        return finalBarcode;
    }

    public static String binaryConverter(String input) {
        String binaryString = "";
        for (int i = 0; i < 5; i++) {
            String thisDigitInBinary = binaryDigit(input.charAt(i));
            binaryString += thisDigitInBinary;
        }
        return binaryString;
    }

    public static String binaryDigit(Character charInput) {
        String input = charInput.toString();
        switch (input) {
            case "0":
                return "11000";
            case "1":
                return "00011";
            case "2":
                return "00101";
            case "3":
                return "00110";
            case "4":
                return "01001";
            case "5":
                return "01010";
            case "6":
                return "01100";
            case "7":
                return "10001";
            case "8":
                return "10010";
            case "9":
                return "10100";
            default:
                return "x";
        }
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

    public static String addCorrectionDigit(String postalString) {
        int postalInt = Integer.parseInt(postalString);
        String correctionBars = "";
        int sum = 0;
        while (postalInt != 0) {
            sum = sum + postalInt % 10;
            postalInt = postalInt / 10;
        }
        int remainder = 10 - (sum % 10);
        if (remainder != 0) {
            String strRemainder = Integer.toString(remainder);
            Character charRemainder = strRemainder.charAt(0);
            correctionBars += initialBarcodeConverter(binaryDigit(charRemainder));
        }
        return correctionBars;
    }

    public static String finishBarcode(String almostFinishedBarcode) {
        String finalBarcode = "|" + almostFinishedBarcode + "|";
        return finalBarcode;
    }

}