/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import calendar.Tree;
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

}
