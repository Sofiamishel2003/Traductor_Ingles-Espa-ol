import java.util.ArrayList;

public class ArbolSplay {
    private SplayNode root;

    // Clase privada para representar un nodo del árbol
    private class SplayNode {
        String key;
        ArrayList<String> value;
        SplayNode left;
        SplayNode right;
        SplayNode parent;

        public SplayNode(String key, ArrayList<String> value) {
            this.key = key;
            this.value = value;
        }
    }

    // Función para insertar una clave y un valor en el árbol (elementos únicos)
    public void insert(String key, ArrayList<String> value) {
        SplayNode node = root;
        SplayNode parent = null;
        while (node != null) {
            parent = node;
            if (key.compareTo(node.key) < 0) {
                node = node.left;
            } else if (key.compareTo(node.key) > 0) {
                node = node.right;
            } else {
                // La clave ya existe, actualizamos el valor asociado y terminamos
                node.value = value;
                return;
            }
        }
        // La clave no existe, creamos un nuevo nodo y lo insertamos
        SplayNode newNode = new SplayNode(key, value);
        newNode.parent = parent;
        if (parent == null) {
            root = newNode;
        } else if (key.compareTo(parent.key) < 0) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
        splay(newNode);
    }
	private SplayNode findNode(String key) {
		SplayNode current = root;
		while (current != null) {
			int cmp = key.compareTo(current.key);
			if (cmp < 0) {
				current = current.left;
			} else if (cmp > 0) {
				current = current.right;
			} else {
				return current;
			}
		}
		return null;
	}
    // Función para buscar una clave en el árbol y realizar la operación splay en el nodo encontrado
	public ArrayList<String> search(String key) {
		SplayNode node = findNode(key);
		if (node == null) {
			return null;
		} else {
			splay(node);
			return node.value;
		}
	}

    // Función auxiliar para realizar la operación splay en un nodo
    private void splay(SplayNode x) {
        while (x.parent != null) {
            if (x.parent.parent == null) {
                if (x == x.parent.left) {
                    rotateRight(x.parent);
                } else {
                    rotateLeft(x.parent);
                }
            } else if (x == x.parent.left && x.parent == x.parent.parent.left) {
                rotateRight(x.parent.parent);
                rotateRight(x.parent);
            } else if (x == x.parent.right && x.parent == x.parent.parent.right) {
                rotateLeft(x.parent.parent);
                rotateLeft(x.parent);
            } else if (x == x.parent.right && x.parent == x.parent.parent.left) {
                rotateLeft(x.parent);
                rotateRight(x.parent);
            } else {
                rotateRight(x.parent);
                rotateLeft(x.parent);
            }
        }
        root = x;
    }
    private void rotateRight(SplayNode x) {
        SplayNode y = x.left;
        x.left = y.right;
        if (y.right != null) {
            y.right.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.right = x;
        x.parent = y;
    }

    private void rotateLeft(SplayNode x) {
        SplayNode y = x.right;
        x.right = y.left;
        if (y.left != null) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }
	public boolean containsKey(String key) {
		SplayNode node = findNode(key);
		if (node == null) {
			return false;
		} else {
			splay(node);
			return true;
		}
	}
}

    // Funciones auxiliares para realizar rotaciones en el árbol
