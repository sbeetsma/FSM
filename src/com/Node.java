package com;

public class Node {
    private Node OvergangA;
    private Node OvergangB;
    final String Naam;

    public Node(String naam) {
        Naam = naam;
    }

    public Node getOvergangA() {
        return OvergangA;
    }

    public void setOvergangA(Node OvergangA) {
        this.OvergangA = OvergangA;
    }

    public Node getOvergangB() {
        return OvergangB;
    }

    public void setOvergangB(Node OvergangB) {
        this.OvergangB = OvergangB;
    }

    public String getNaam() {
        return Naam;
    }
}
