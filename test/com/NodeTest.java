package com;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {
    // Test overgangen toevoegen
    @Test
    void addOvergang() {
        Node n1 = new Node ("n1");
        Node n2 = new Node ("n2");
        assertEquals(0, n1.getAantalOvergangen());
        n1.addOvergang('A', n2);
        assertEquals(1, n1.getAantalOvergangen());
        n1.addOvergang('B', n1);
        assertEquals(2, n1.getAantalOvergangen());
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