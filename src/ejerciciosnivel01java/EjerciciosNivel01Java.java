package ejerciciosnivel01java;

import java.util.Arrays;

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
         String palabraSinEspacios = "";
         String primMitad;
         String segMitad;
          // Le quito los espacios a la cadena
         for(int i=0; i<str.length(); i++){
             if(str.charAt(i)!= ' '){
                 palabraSinEspacios += str.charAt(i); 
             }         
         }
         if (palabraSinEspacios.length()%2==0){
                primMitad = palabraSinEspacios.substring(0, palabraSinEspacios.length()/2-1);
                segMitad = palabraSinEspacios.substring(palabraSinEspacios.length()/2+1, palabraSinEspacios.length());
         } else {
            //Guardo las dos mitades de la cadena que tienen que tener los mismos caracteres
            primMitad = palabraSinEspacios.substring(0, palabraSinEspacios.length()/2);
            segMitad = palabraSinEspacios.substring(palabraSinEspacios.length()/2+1, palabraSinEspacios.length());
         }
         String segMitadI = "";
         
            //Le doy la vuelta al segundo substring
        for(int i= segMitad.length()-1; i>=0; i--){
            segMitadI += segMitad.charAt(i);
        }
            //Los comparo
        if(primMitad.equals(segMitadI)){
            return true;
        }
        return false;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EjerciciosNivel01Java ejercicio = new EjerciciosNivel01Java();

    //    System.out.println("El número máximo es " + ejercicio.maximo(ejercicio.listaNumeros));
    //    System.out.println("El números máximos son " + Arrays.toString(ejercicio.maximos(ejercicio.listaNumeros)));
    //    System.out.println("El números máximos son " + Arrays.toString(ejercicio.maximos(ejercicio.listaNumerosI)));

        System.out.println("¿Es \"ACASO HUBO BUHOS ACA\" un palíndromo? -> " + ejercicio.palindromo("ACASO HUBO BUHOS ACA"));
        System.out.println("¿Es \"DABALE ARROZ A LA ZORRA EL ABAD\" un palíndromo? -> " + ejercicio.palindromo("DABALE ARROZ A LA ZORRA EL ABAD"));
        System.out.println("¿Es \"LIGAR ES AGIL\" un palíndromo? -> " + ejercicio.palindromo("LIGAR ES AGIL"));
        System.out.println("¿Es \"LIGAR ES SER AGIL\" un palíndromo? -> " + ejercicio.palindromo("LIGAR ES SER AGIL"));
        System.out.println("¿Es \"TACCAT\" un palíndromo? -> " + ejercicio.palindromo("TACCAT"));
        System.out.println("¿Es \"a bali su flan anal fusilaba\" un palíndromo? -> " + ejercicio.palindromo("a bali su flan anal fusilaba"));
        System.out.println("¿Es \"lavan esa base naval\" un palíndromo? -> " + ejercicio.palindromo("lavan esa base naval"));
    }

}
