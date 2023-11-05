package convertidor;
import java.util.Scanner;
public class Convertidor {
	    public static String decimalaBinario(int decimal) {
	        if (decimal == 0) {
	            return "0";
	        } else if (decimal == 1) {
	            return "1";
	        } else {
	            int residuo = decimal % 2;
	            int cociente = decimal / 2;
	            String resultadoRecursivo = decimalaBinario(cociente);
	            return resultadoRecursivo + residuo;
	        }
	    }
	    
	    public static String hexadecimalaBinario(String hexadecimal) {
	        String binario = "";
	        int len = hexadecimal.length();

	        for (int i = 0; i < len; i++) {
	            char hexaChar = hexadecimal.charAt(i);
	            int hexaValor = Character.digit(hexaChar, 16);
	            String parteBinaria = Integer.toBinaryString(hexaValor);
	            binario += String.format("%4s", parteBinaria).replace(' ', '0');
	        }
	        return binario;
	    }
	    
	    public static int hexadecimalaDecimal(String hexadecimal) {
	        int decimal = 0;
	        hexadecimal = hexadecimal.toUpperCase();
	        int len = hexadecimal.length();
	        
	        for (int i = 0; i < len; i++) {
	            char hexaChar = hexadecimal.charAt(i);
	            int hexaValor = Character.digit(hexaChar, 16);

	            if (hexaValor == -1) {
	                throw new IllegalArgumentException("Carácter no válido en el número hexadecimal: " + hexaChar);
	            }

	            decimal = decimal * 16 + hexaValor;
	        }
	        return decimal;
	    }
	    
	    public static String decimalaHexadecimal(int decimal) {
	        if (decimal == 0) {
	            return "0";
	        }

	        StringBuilder hex = new StringBuilder();
	        
	        while (decimal > 0) {
	            int residuo = decimal % 16;
	            char digitoHexa = (char) (residuo < 10 ? '0' + residuo : 'A' + residuo - 10);
	            hex.insert(0, digitoHexa);
	            decimal /= 16;
	        }
	        return hex.toString();
	    }
	    
	    public static int binarioaDecimal(String binario) {
	        int decimal = 0;
	        int poten = 0;

	        for (int i = binario.length() - 1; i >= 0; i--) {
	            char bit = binario.charAt(i);
	            if (bit == '1') {
	                decimal += Math.pow(2, poten);
	            }
	            poten++;
	        }
	        return decimal;
	    }

	    public static void main(String[] args) {
	    	Scanner scanner = new Scanner(System.in);
	        boolean continuar = true;

	        while (continuar) {
	            System.out.println("Menú de Conversiones:");
	            System.out.println("1. Decimal a Binario");
	            System.out.println("2. Hexadecimal a Binario");
	            System.out.println("3. Hexadecimal a Decimal");
	            System.out.println("4. Decimal a Hexadecimal");
	            System.out.println("5. Binario a Decimal");
	            System.out.println("6. Salir");

	            System.out.print("Selecciona una opción (1-6): ");
	            int opcion = scanner.nextInt();

	            switch (opcion) {
	                case 1:
	                    System.out.print("Ingresa un número decimal: ");
	                    int decimal = scanner.nextInt();
	                    String binario = decimalaBinario(decimal);
	                    System.out.println("Binario: " + binario);
	                    break;
	                case 2:
	                    System.out.print("Ingresa un número hexadecimal: ");
	                    String hexadecimal = scanner.next();
	                    String binarioHex = hexadecimalaBinario(hexadecimal);
	                    System.out.println("Binario: " + binarioHex);
	                    break;
	                case 3:
	                    System.out.print("Ingresa un número hexadecimal: ");
	                    String hex = scanner.next();
	                    int decimalHex = hexadecimalaDecimal(hex);
	                    System.out.println("Decimal: " + decimalHex);
	                    break;
	                case 4:
	                    System.out.print("Ingresa un número decimal: ");
	                    int dec = scanner.nextInt();
	                    String hexDecimal = decimalaHexadecimal(dec);
	                    System.out.println("Hexadecimal: " + hexDecimal);
	                    break;
	                case 5:
	                    System.out.print("Ingresa un número binario: ");
	                    String bin = scanner.next();
	                    int decimalBin = binarioaDecimal(bin);
	                    System.out.println("Decimal: " + decimalBin);
	                    break;
	                case 6:
	                    continuar = false;
	                    break;
	                default:
	                    System.out.println("Opción no válida. Por favor, selecciona una opción válida.");
	            }
	        }

	        scanner.close();
	        System.out.println("¡Hasta luego!");
	    }
}