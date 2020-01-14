package codigo;

import java.util.Arrays;
import java.util.regex.*;

/**
 *
 * @author Alejandro Serrano
 */
public class EjerciciosNivel01Java {

    int[] listaNumeros = {50, 31, 27, 5, 99};
    int[] listaNumerosI = {99, 5, 27, 31, 50};

    public int maximo(int[] lista) {
        int auxiliar = lista[0];
        for (int i = 0; i < lista.length; i++) {
            if (auxiliar < lista[i]) {
                auxiliar = lista[i];
            }
        }
        return auxiliar;
    }

    public int[] maximos(int[] lista) {
        int[] arrayMaximos = {0, 0};
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] > arrayMaximos[0]) {
                arrayMaximos[1] = arrayMaximos[0];
                arrayMaximos[0] = lista[i];
            } else if (lista[i] > arrayMaximos[1]) {
                arrayMaximos[1] = lista[i];
            }
        }
//        if (lista[0] != arrayMaximos[0] && lista[0] > arrayMaximos[1]) {
//            arrayMaximos[1] = lista[0];
//        }
        return arrayMaximos;
    }

    public boolean palindromo(String str) {
        String palabraSoloLetras = "";
        String primMitad;
        String segMitad;
        // Le quito los espacios a la cadena
        for (int i = 0; i < str.length(); i++) {
            String s = String.valueOf(str.charAt(i));
            if (Pattern.matches("[a-zA-Z]", s)) {
                palabraSoloLetras += str.charAt(i);
            }
        }
        String palabraSoloLetrasUC = palabraSoloLetras.toUpperCase();
        if (palabraSoloLetrasUC.length() % 2 == 0) {
            primMitad = palabraSoloLetrasUC.substring(0, palabraSoloLetrasUC.length() / 2 - 1);
            segMitad = palabraSoloLetrasUC.substring(palabraSoloLetrasUC.length() / 2 + 1, palabraSoloLetrasUC.length());
        } else {
            //Guardo las dos mitades de la cadena que tienen que tener los mismos caracteres
            primMitad = palabraSoloLetrasUC.substring(0, palabraSoloLetrasUC.length() / 2);
            segMitad = palabraSoloLetrasUC.substring(palabraSoloLetrasUC.length() / 2 + 1, palabraSoloLetrasUC.length());
        }
        String segMitadI = "";

        //Le doy la vuelta al segundo substring
        for (int i = segMitad.length() - 1; i >= 0; i--) {
            segMitadI += segMitad.charAt(i);
        }
        //Los comparo
        if (primMitad.equals(segMitadI)) {
            return true;
        }
        return false;
    }

    public boolean isograma(String str) {
        String strTUC = str.toUpperCase();
        boolean esIsograma = true;

        for (int i = 0; i < strTUC.length(); i++) {
            // Pregunto si es índice del caracter de la posición i
            // a partir de la posición siguiente
            char letraComparada = strTUC.charAt(i);
            if (strTUC.indexOf(letraComparada, i + 1) != -1 && Character.isLetter(letraComparada)) {
                esIsograma = false;
            }
        }
        return esIsograma;
    }

    public void calendario(int miPrimeritoDia) {
        int diasMesAnterior = miPrimeritoDia % 7;
        String[] diasMes = new String[35];
        // Relleno el array con "XX"
        for (int i = 0; i < 35; i++) {
            diasMes[i] = "XX";
        }
        // Relleno el array con los números de los días
        for (int j = 1; j <= 31; j++) {
            if (diasMesAnterior + j <= 35) {
                if (j < 10) {
                    // le resto 1 para empezar en la posición 0 del array
                    diasMes[j - 1 + diasMesAnterior] = "0" + j;
                } else {
                    diasMes[j - 1 + diasMesAnterior] = "" + j;
                }
            }
        }
        // imprimo el calendario
        int auxiliar = 0;
        for (int k = 0; k < 5; k++) { //con 5 filas
            for (int l = 0; l < 7; l++) { // y 7 columnas
                System.out.print(diasMes[auxiliar] + " ");
                auxiliar++;
            }
            System.out.println("");
        }
    }

    public boolean anagrama(String str1, String str2) {
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        boolean esAnagrama = true;

        if (str1.length() == str2.length()) {
            
            for (int i = 0; i < str1.length(); i++) {
                int numCoincidencias = 0;
                for (int j = 0; j < str1.length(); j++){                    
                    if(str1.charAt(i) == str2.charAt(j)){
                        numCoincidencias++;
                    }                    
                    if(numCoincidencias != 1){
                        esAnagrama = false;
                    }
                }
            }
        } else {
            esAnagrama = false;
        }
        return esAnagrama;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EjerciciosNivel01Java ejercicio = new EjerciciosNivel01Java();

//        System.out.println("El número máximo es " + ejercicio.maximo(ejercicio.listaNumeros));
//        System.out.println("El números máximos son " + Arrays.toString(ejercicio.maximos(ejercicio.listaNumeros)));
        System.out.println("El números máximos son " + Arrays.toString(ejercicio.maximos(ejercicio.listaNumerosI)));
        //cabronorba
        System.out.println("¿Es \"amoroma\" un palíndromo? -> " + ejercicio.palindromo("amoroma")); 
//        System.out.println("¿Es \"¿ACASO HUBO BUHOS ACA?\" un palíndromo? -> " + ejercicio.palindromo("¿ACASO HUBO BUHOS ACA?"));
//        System.out.println("¿Es \"DABALE ARROZ A LA ZORRA EL ABAD\" un palíndromo? -> " + ejercicio.palindromo("DABALE ARROZ A LA ZORRA EL ABAD"));
//        System.out.println("¿Es \"LIGAR ES AGIL\" un palíndromo? -> " + ejercicio.palindromo("LIGAR ES AGIL"));
//        System.out.println("¿Es \"LIGAR ES SER AGIL\" un palíndromo? -> " + ejercicio.palindromo("LIGAR ES SER AGIL"));
//        System.out.println("¿Es \"TACCAT\" un palíndromo? -> " + ejercicio.palindromo("TACCAT"));
//        System.out.println("¿Es \"a bali su flan anal fusilaba\" un palíndromo? -> " + ejercicio.palindromo("a bali su flan anal fusilaba"));
//        System.out.println("¿Es \"lavan esa base naval\" un palíndromo? -> " + ejercicio.palindromo("lavan esa base naval"));
//        System.out.println("¿Es \"Yo dono rosas, oro no doy -> " + ejercicio.palindromo("Yo dono rosas, oro no doy"));
//        System.out.println("¿Es isograma aeiou? " + ejercicio.isograma("aeiou"));
//        System.out.println("¿Es isograma aeiaou? " + ejercicio.isograma("aeiaou"));
//        System.out.println("¿Es isograma trabajo? " + ejercicio.isograma("trabajo"));
//        System.out.println("¿Es isograma trabuco? " + ejercicio.isograma("trabuco"));
//        System.out.println("¿Es isograma ligar es ser agil? " + ejercicio.isograma("ligar es ser agil"));
//        System.out.println("¿Es isograma ligar? " + ejercicio.isograma("ligar es: "));

        System.out.println("");

        ejercicio.calendario(40);
        
        System.out.println("¿Son anagramas \"abc\" y \"acb\"? " + ejercicio.anagrama("abc", "acb"));
        
        

    }

}
