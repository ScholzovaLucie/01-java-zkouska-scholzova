package calendar;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.BiConsumer;

public class Tree<E extends Comparable<? super E>> implements Iterable<E> {

    @Override
    public Iterator<E> iterator() {
        List<E> list = new ArrayList<>();
        BiConsumer<BiConsumer, Node<E>> cf = (f, c) -> {
           if (c.left != null) {
                f.accept(f, c.left);
            }
            list.add(c.data);

            
            if (c.right != null) {
                f.accept(f, c.right);
            }
        };

        cf.accept(cf, root);
        return list.iterator();
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

    

    public Tree() {
    }
    
    private Node<E> root;

    public void add(E data) {
        if (root == null) {
            root = new Node<>(data);
            return;
        }

        Node<E> parent = null;
        Node<E> traveller = root;
        boolean leftDirection = false;

        while (traveller != null) {
            parent = traveller;
            if (data.compareTo(traveller.data) < 0) {
                traveller = traveller.left;
                leftDirection = true;
            } else {
                traveller = traveller.right;
                leftDirection = false;
            }
        }

        if (leftDirection) {
            parent.left = new Node<>(data);
        } else {
            parent.right = new Node<>(data);
        }
    }

    public void erase(E data) {
        Node<E> parent = null;
        Node<E> traveller = root;
        boolean leftDirection = false;

        while (traveller.data.compareTo(data) != 0) {
            parent = traveller;
            if (data.compareTo(traveller.data) < 0) {
                traveller = traveller.left;
                leftDirection = true;
            } else {
                traveller = traveller.right;
                leftDirection = false;
            }
        }

        if (traveller.right == null && traveller.left == null) {
            if (leftDirection) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        } else if (traveller.left != null) {
            Node<E> subparent = traveller;
            Node<E> removal = traveller.left;

            while (removal.right != null) {
                subparent = removal;
                removal = removal.right;
            }

            traveller.data = removal.data;
            if (subparent != traveller) {
                subparent.left = removal.left;
            } else {
                subparent.right = removal.left;
            }
        } else if (traveller.right != null) {
            Node<E> subparent = traveller;
            Node<E> removal = traveller.right;

            while (removal.left != null) {
                subparent = removal;
                removal = removal.left;
            }

            traveller.data = removal.data;
            if (subparent == traveller) {
                subparent.right = removal.right;
            } else {
                subparent.left = removal.right;
            }
        }
    }

    public boolean contaix(E data) {
        Node<E> traveller = root;

        while (traveller != null) {
            if (data.compareTo(traveller.data) == 0) {
                return true;
            }

            if (data.compareTo(traveller.data) < 0) {
                traveller = traveller.left;
            } else {
                traveller = traveller.right;
            }
        }

        return false;
    }

    public E get(E data) {
        Node<E> traveller = root;

        while (traveller != null) {
            if (data.compareTo(traveller.data) == 0) {
                return traveller.data;
            }

            if (data.compareTo(traveller.data) < 0) {
                traveller = traveller.left;
            } else {
                traveller = traveller.right;
            }
        }

        return null;
    }

    @Override
    public String toString() {
        return "Tree{" + "root=" + root + '}';
    }

}
