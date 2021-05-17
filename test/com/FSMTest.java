package com;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FSMTest {
    @Test
    // test run met een tekstinvoer van characters
    void run() {
        // nodes maken
        Node n1 = new Node("n1");
        Node n2 = new Node("n2");
        Node n3 = new Node("n3");
        // overgangen
        n1.addOvergang('A', n2);
        n2.addOvergang('B', n3);
        n3.addOvergang('A', n1);

        FSM fsm1 = new FSM(n1);
        fsm1.run("ABA");
        // start node + pad van tekstinvoer zal 4 lang moeten zijn
        assertEquals(4, fsm1.getPadLengte());
        // run een nieuwe tekstinvoer vanaf de huidige node
        fsm1.run("AAB");
        // alleen de eerste overgang A bestaat. Dus padlengte is 4 + 1
        assertEquals(5, fsm1.getPadLengte());
    }
    // test run met overgangen op gewichten
    @Test
    void run_gewichten() {
        // nodes maken
        Node n1 = new Node("n1");
        Node n2 = new Node("n2");
        Node n3 = new Node("n3");
        // overgangen
        n1.addGewichtOvergang(n2,1);
        n1.addGewichtOvergang(n3,1);

        n2.addGewichtOvergang(n1,1);
        n2.addGewichtOvergang(n3,1);

        n3.addGewichtOvergang(n1,1);
        n3.addGewichtOvergang(n2,1);

        FSM fsm1 = new FSM(n1);
        fsm1.run("10");
        // start node + aantal stappen (tekstinvoer naar int) zal 11 lang moeten zijn
        assertEquals(11, fsm1.getPadLengte());
        // run extra stappen vanaf de huidige nodge
        fsm1.run("4");
        // padlengte is startnode 1 + 10stappen + 4stappen
        assertEquals(15, fsm1.getPadLengte());
    }

    @Test
    void equals() {
        // nodes maken
        Node n1 = new Node("n1");
        // overgangen
        n1.addOvergang('A', n1);

        FSM fsm1 = new FSM(n1);
        FSM fsm2 = new FSM(n1);

        // niet hetzelfde pad afgelopen
        fsm1.run("A");
        assertNotEquals(fsm1, fsm2);
        // wel hetzelfde pad afgelopen
        fsm2.run("A");
        assertEquals(fsm1, fsm2);
    }
    // als er maar 1 mogelijk pad is met de bestaande gewichten moeten 2 fsm's hetzelfde zijn na evenveel stappen
    @Test
    void equals_gewichten() {
        // nodes maken
        Node n1 = new Node("n1");
        Node n2 = new Node("n2");
        Node n3 = new Node("n3");
        // overgangen
        n1.addGewichtOvergang(n2,1);
        n2.addGewichtOvergang(n3,1);
        n3.addGewichtOvergang(n1,1);

        FSM fsm1 = new FSM(n1);
        FSM fsm2 = new FSM(n1);

        // niet hetzelfde pad afgelopen
        fsm1.run("99");
        assertNotEquals(fsm1, fsm2);
        // wel hetzelfde pad afgelopen
        fsm2.run("99");
        assertEquals(fsm1, fsm2);
    }
}