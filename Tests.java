import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import org.junit.Test;

public class Tests {
  ArbolSplay arbol1 = new ArbolSplay();
  AVLTree arbol2 = new AVLTree();
  ArrayList<String> list = new ArrayList();
 
  @Test
  public void testInsert1() {
    list.add("perro");
    list.add("sustantivo");
    arbol1.insert("Dog", list);
    boolean resultado =arbol1.containsKey("Dog");
    assertEquals(true, resultado);
  }

  @Test
  public void testSearch1() {
    list.add("perro");
    list.add("sustantivo");
    arbol1.insert("Dog", list);
    ArrayList<String> resultado =arbol1.search("Dog");
    assertEquals("perro", resultado.get(0));
  }
  
  @Test
  public void testInsert2() {
    list.add("perro");
    list.add("sustantivo");
    arbol2.insert("Dog", list);
    boolean resultado =arbol2.containsKey("Dog");
    assertEquals(true, resultado);
  }

  @Test
  public void testSearch2() {
    list.add("perro");
    list.add("sustantivo");
    arbol2.insert("Dog", list);
    ArrayList<String> resultado =arbol2.search("Dog");
    assertEquals("perro", resultado.get(0));
  }

}