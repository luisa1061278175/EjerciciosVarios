package co.edu.uniquindio.recursividad;

public class SumarNumeros {
    //sumar numeros hasta n

    public static void main(String[] args) {
        //hasta 5 empezando en 1

        System.out.println(sumarN(5));
    }

    public static int sumarN(int n){
        //caso base
        //Cuando se rompe
        if (n==0) {
            return 0;

        }
        return  n+ sumarN(n-1);
    }
}
