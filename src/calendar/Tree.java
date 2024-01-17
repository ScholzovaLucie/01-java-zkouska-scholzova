package calendar;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.BiConsumer;

public class Tree<E extends Comparable<? super E>> implements Iterable<E> {

    private Node<E> root;

    public Tree() {
    }

    private static class Node<E> {

        public Node<E> left;
        public Node<E> right;
        public E data;

        public Node() {
        }

        public Node(E data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" + "left=" + left + ", right=" + right + ", data=" + data + '}';
        }

    }

    @Override
    public Iterator<E> iterator() {
        List<E> list = new ArrayList<>();
        BiConsumer<BiConsumer, Node<E>> traverse = (consumer, node) -> {
           if (node.left != null) {
                consumer.accept(consumer, node.left);
            }
            list.add(node.data);

            
            if (node.right != null) {
                consumer.accept(consumer, node.right);
            }
        };

        traverse.accept(traverse, root);
        return list.iterator();
    }

    @Override
    public String toString() {
        return "Tree{" + "root=" + root + '}';
    }

    public void add(E data) {
        if (root == null) {
            root = new Node<>(data);
            return;
        }

        Node<E> parent = null;
        Node<E> current = root;
        boolean isLeft = false;

        while (current != null) {
            parent = current;
            if (data.compareTo(current.data) < 0) {
                current = current.left;
                isLeft = true;
            } else {
                current = current.right;
                isLeft = false;
            }
        }

        if (parent != null){
            if (isLeft) {
                parent.left = new Node<>(data);
            } else {
                parent.right = new Node<>(data);
            } 
        }
        
    }

    public void erase(E data) {
        removeNode(root, data);
    }
    
    private Node<E> removeNode(Node<E> current, E data) {
        Node<E> parent = null;
        boolean isLeft = false;

        while (current.data.compareTo(data) != 0) {
            parent = current;
            if (data.compareTo(current.data) < 0) {
                current = current.left;
                isLeft = true;
            } else {
                current = current.right;
                isLeft = false;
            }
        }

        if (current.right == null && current.left == null) {
            removeLeafNode(parent, isLeft);
        } else if (current.left != null) {
            removeNodeWithLeftChild(current);
        } else if (current.right != null) {
            removeNodeWithRightChild(current);
        }

        return parent;
    }
    
    private void removeLeafNode(Node<E> parent, boolean isLeft) {
        if (isLeft) {
            parent.left = null;
        } else {
            parent.right = null;
        }
}
    
    private void removeNodeWithLeftChild(Node<E> current) {
        Node<E> subparent = current;
        Node<E> removal = current.left;

        while (removal.right != null) {
            subparent = removal;
            removal = removal.right;
        }

        current.data = removal.data;
        if (subparent != current) {
            subparent.left = removal.left;
        } else {
            subparent.right = removal.left;
        }
    }

    private void removeNodeWithRightChild(Node<E> current) {
        Node<E> subparent = current;
        Node<E> removal = current.right;

        while (removal.left != null) {
            subparent = removal;
            removal = removal.left;
        }

        current.data = removal.data;
        if (subparent == current) {
            subparent.right = removal.right;
        } else {
            subparent.left = removal.right;
        }
    }

    public boolean contains(E data) {
        Node<E> current = root;

        while (current != null) {
            if (data.compareTo(current.data) == 0) {
                return true;
            }

            if (data.compareTo(current.data) < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return false;
    }

    public E get(E data) {
        Node<E> current = root;

        while (current != null) {
            if (data.compareTo(current.data) == 0) {
                return current.data;
            }

            if (data.compareTo(current.data) < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return null;
    }

}
