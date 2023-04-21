/**
 * La clase Factory es una factoría para la creación de diferentes implementaciones de mapas.
 */

import java.util.Map;
import java.util.TreeMap;
import java.util.ArrayList; //Import Arraylist
public class Factory extends Main {


    public static traductor make_map(int e) 
    {
        switch (e) {
            case 1: //HashMap
                ArbolSplay arbol=new ArbolSplay();
                traductor trans = new traductor(arbol,"Ingles", "Español");
                return trans;
            case 2: //TreeMap
                AVLTree arbol2=new AVLTree();
                traductor trans2 = new traductor(arbol2,"Ingles", "Español");
                return trans2;
            default:
                throw new IllegalArgumentException("Dato invalido");
        }
    }
}