package co.edu.uniquindio.recursividad;

public class SumarNumArreglo {
    public static void main(String[] args) {

        int [] arreglo={1,1,2,3};
        System.out.println(sumarArreglo(arreglo));
    }


public static int sumarArreglo(int []arreglo){

        return sumarArreglo(arreglo,0);

}

    private static  int sumarArreglo(int []arreglo, int i){
        // caso base si el arreglo llego al final

    if (i==arreglo.length){
        return 0;

    }
    return arreglo[i] + sumarArreglo(arreglo,++i);
}

}
