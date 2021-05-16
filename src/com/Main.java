package com;

public class Main {
    public static void main(String[] args) {
        // nodes maken
        Node s0 = new Node("s0");
        Node s1 = new Node("s1");
        Node s2 = new Node("s2");
        Node s3 = new Node("s3");

        // overgangen beschreven op canvas
        s0.addOvergang('A',s2);
        s0.addOvergang('B',s1);

        s1.addOvergang('A',s1);
        s1.addOvergang('B',s2);

        s2.addOvergang('B',s3);

        s3.addOvergang('A', s3);
        s3.addOvergang('B', s0);

        // fsm1 voorbeeld van canvas
        FSM fsm1 = new FSM(s0);
        fsm1.run("BAAB");
        System.out.println(fsm1);

        // extra nodes met overgang(en)
        Node s4 = new Node("s4");
        s4.addOvergang('D', s0);

        // extra overgangen
        s0.addOvergang('C', s3);
        s1.addOvergang('C', s0);
        s2.addOvergang('A', s3);
        s2.addOvergang('C', s3);
        s3.addOvergang('C', s4);

        // fsm 2
        FSM fsm2 = new FSM(s0);
        fsm2.run("ABBCCD");
        System.out.println(fsm2);

        // fsm 3 (foutmelding want node 4 heeft geen pad A)
        FSM fsm3 = new FSM(s0);
        fsm3.run("ABBCCAD");
        System.out.println(fsm3);

    }
}
