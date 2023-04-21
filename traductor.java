import java.util.ArrayList; //Import Arraylist
public class traductor {
    private String traduccion1;
    private String name1;
    private String valores[];
    private ArrayList<String>  traducciones;
    private ArbolSplay arbol;
    public traductor(ArbolSplay arbol, String n1,String n2)
    {
        this.arbol=arbol;
        name1=n1;
    }
    public void traducir(String oracion)
    {
        traduccion1="";
        valores= oracion.split(" ");
        for (String i : valores)
        {
            if (arbol.containsKey(i))
            {
                traducciones=arbol.search(i);
                traduccion1+=traducciones.get(0)+" ";
            }
            else
            {
                traduccion1+="*"+i+"* ";
            }
        }
        System.out.println("La traduccion en "+name1+" es:");
        System.out.println(traduccion1);
    }
    
}
