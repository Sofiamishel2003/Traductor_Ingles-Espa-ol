import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.Scanner;
import java.util.Map;

public class Main {
    public static void main(String[] args)
    {
        String[] values;
        String key;
        String value;
        Scanner in = new Scanner(System.in);
        archivos file =new archivos();
        ArrayList<String> lineas= file.read_file("Spanish.txt");
        //Creación de
        ArbolSplay arbol=new ArbolSplay();
        for (String str : lineas) //para agregar los significados provenientes del archivo a cada arbol de cada idioma
        {
            //lista de valores
            ArrayList<String> lista = new ArrayList();
            values = str.split(",");
            lista.add(values[1]);
            lista.add(values[2]);
            arbol.insert(values[0], lista);
        }
        int e=0;
        while (e!=5)
        {
            System.out.println("Bienvenido al traductor \n Escoge una opcion\n 1.Traducir\n 2.Salir");
            e=in.nextInt();
            switch (e)
            {
                case 1:
                    System.out.println("La traducción es: ");
                    archivos archivito =new archivos();
                    ArrayList<String> lineas_lectura= archivito.read_file("texto.txt"); //lee las lineas para traducir
                    int cont=0;
                    for (String i : lineas_lectura)
                    {
                        cont+=1;
                        System.out.println("Traducciones de la linea No."+cont+"-----------");
                        String sinsignos = i.replaceAll("[.,;]", "");
                        traductor gringo = new traductor(arbol, "Ingles", "Español");
                        gringo.traducir(sinsignos);
                    }
                    break;
                case 2:
                    System.out.println("Se salió");
                    break;
                default:
                    System.out.println("Opcion ingresada invalida");
                    break;
            }
        }
    }
}