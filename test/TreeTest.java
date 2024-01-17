/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import calendar.Tree;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author st64176
 */
public class TreeTest {
    private Tree<Integer> tree;
    
    public TreeTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        tree = new Tree<>();
    }
    
    @AfterEach
    public void tearDown() {
    }

     @Test
    void testAddToEmptyTree() {
        tree.add(42);
        assertTrue(tree.contains(42));
    }

    @Test
    void testAddToNonEmptyTreeLeftBranch() {
        tree.add(50);
        tree.add(30);
        assertTrue(tree.contains(50));
        assertTrue(tree.contains(30));
    }

    @Test
    void testAddToNonEmptyTreeRightBranch() {
        tree.add(30);
        tree.add(50);
        assertTrue(tree.contains(30));
        assertTrue(tree.contains(50));
    }

    @Test
    void testEraseLeaf() {
        tree.add(42);
        tree.erase(42);
        assertFalse(tree.contains(42));
    }

    @Test
    void testEraseRoot() {
        tree.add(42);
        tree.add(24);
        tree.erase(42);
        assertFalse(tree.contains(42));
        assertTrue(tree.contains(24));
    }

    @Test
    void testEraseInternalNode() {
        tree.add(50);
        tree.add(30);
        tree.add(70);
        tree.erase(50);
        assertFalse(tree.contains(50));
        assertTrue(tree.contains(30));
        assertTrue(tree.contains(70));
    }

    @Test
    void testIteratorEmptyTree() {
        assertFalse(tree.iterator().hasNext());
    }

    
    @Test
    void testIteratorOverEmptyTree() {
        Iterator<Integer> iterator = tree.iterator();
        assertFalse(iterator.hasNext(), "Iterator over an empty tree should not have next elements.");
    }

    @Test
    void testIteratorOverNonEmptyTree() {
        tree.add(50);
        tree.add(30);
        tree.add(70);
        
        List<Integer> expectedElements = List.of(30, 50, 70);
        List<Integer> actualElements = new ArrayList<>();

        Iterator<Integer> iterator = tree.iterator();
        while (iterator.hasNext()) {
            actualElements.add(iterator.next());
        }

        assertEquals(expectedElements, actualElements, "Iterator should traverse the tree in-order.");
    }

    @Test
    void testIteratorOverNonEmptyTreeWithAdditions() {
        tree.add(50);
        tree.add(30);
        tree.add(70);
        tree.add(40);
        tree.add(60);

        List<Integer> expectedElements = List.of(30, 40, 50, 60, 70);
        List<Integer> actualElements = new ArrayList<>();

        Iterator<Integer> iterator = tree.iterator();
        while (iterator.hasNext()) {
            actualElements.add(iterator.next());
        }

        assertEquals(expectedElements, actualElements, "Iterator should traverse the modified tree in-order.");
    }
}
