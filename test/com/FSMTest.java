package com;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FSMTest {

    @Test
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
}