package com;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {
    // Test overgang toevoegen met character
    @Test
    void addOvergang() {
        Node n1 = new Node ("n1");
        Node n2 = new Node ("n2");
        assertEquals(0, n1.getOvergangen().size());
        n1.addOvergang('A', n2);
        assertEquals(1, n1.getOvergangen().size());
        n1.addOvergang('B', n1);
        assertEquals(2, n1.getOvergangen().size());
    }
    // Test overgang toevoegen met alleen gewicht
    @Test
    void addGewichtOvergang() {
        Node n1 = new Node ("n1");
        Node n2 = new Node ("n2");
        assertEquals(0, n1.getOvergangen().size());
        n1.addGewichtOvergang(n2,1);
        assertEquals(1, n1.getGewichtOvergangen().size());
        n1.addGewichtOvergang(n1,1);
        assertEquals(2, n1.getGewichtOvergangen().size());
    }

    // Test ophalen van overgangen
    @Test
    void getOvergang() {
        Node n1 = new Node ("n1");
        Node n2 = new Node ("n2");
        n1.addOvergang('A', n1);
        n1.addOvergang('B', n2);
        assertEquals(n1, n1.getOvergang('A'));
        assertEquals(n2, n1.getOvergang('B'));
    }
}