package com;

public class Main {
    public static void main(String[] args) {
        // nodes maken
        Node s0 = new Node("s0");
        Node s1 = new Node("s1");
        Node s2 = new Node("s2");
        Node s3 = new Node("s3");
        // overgangen instellen
        s0.setOvergangA(s2);
        s0.setOvergangB(s1);

        s1.setOvergangA(s1);
        s1.setOvergangB(s2);

        //s2.setOvergangA(s2);
        s2.setOvergangB(s3);

        s3.setOvergangA(s3);
        s3.setOvergangB(s0);

        Proces P1 = new Proces(s0);
        P1.f("AABB");
        System.out.println(P1.getNodePad());
        // fout gegaan op de 2e A van de tekstinvoer huidige node is s2
        P1.f("BAAB");
        // zou vanaf node s2 verder moeten gaan en bij node s0 moeten uitkomen
        System.out.println(P1.getNodePad());

        // nieuw proces die een pad doorloopt zonder foutmeldingen
        Proces P2 = new Proces(s0);
        P2.f("BBBBABABBABBAB");
        System.out.println(P2.getNodePad());

    }
}
