import java.util.Scanner;

public class Barcode {

    public static void main(String[] args) {
        System.out.println(initialBarcodeConverter556s("010011"));
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

        public static String binaryConverter(int decimal) {
            return(Integer.toBinaryString(decimal));
        }

        public static String initialBarcodeConverter(String binary) {
            String initialBarcode = "";
            for (int i = 0; i < 5; i++) {
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
    public static String initialBarcodeConverter2(String binary) {
        String initialBarcode = "";
            String bar = "";
            char thisDigitChar = binary.charAt(1);
            String thisDigit = String.valueOf(thisDigitChar);
        if (thisDigit.equals("0")) {
            bar = ":";
        } else if (thisDigit.equals("1")) {
            bar = "|";
        }
        return bar;
    }


    }
