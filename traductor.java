import java.util.ArrayList; //Import Arraylist
public class traductor {
    private String traduccion1;
    private String name1;
    private String valores[];
    private ArrayList<String>  traducciones;
    private ArbolSplay arbol;
    private AVLTree arbol2;
    private Boolean bandera=true;
    public traductor(ArbolSplay arbol, String n1,String n2)
    {
        this.arbol=arbol;
        name1=n1;
        bandera=true;
    }
    public traductor(AVLTree arbol, String n1,String n2)
    {
        this.arbol2=arbol;
        name1=n1;
        bandera=false;
    }
    public void traducir(String oracion)
    {
        traduccion1="";
        valores= oracion.split(" ");
        if (bandera)
        {
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
        else
        {
            for (String i : valores)
            {
                if (arbol2.containsKey(i))
                {
                    traducciones=arbol2.search(i);
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
    public boolean getArbol()
    {
       return bandera; 
    }
    public ArbolSplay getsplay()
    {
       return arbol; 
    }
    public AVLTree getAVL()
    {
       return arbol2; 
    }
    
}
