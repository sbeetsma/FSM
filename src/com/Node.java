package com;

import java.util.HashMap;
import java.util.Map;

public class Node {
    final String naam;
    // hashmap met overgangen
    private Map<Character, Node> overgangen = new HashMap<>();
    // hashmap met overgangen en hun gewichten(kans)
    private Map<Node, Integer> gewichtOvergangen = new HashMap<>();

    public Node(String naam) {
        this.naam = naam;
    }

    public void addOvergang(char c, Node node){
        overgangen.put(c, node);
    }

    public void addGewichtOvergang(Node node, Integer gewicht){
        gewichtOvergangen.put(node, gewicht);
    }

    // krijg value op een gegeven key in de overgangen dictionary
    public Node getOvergang(char c){
        return overgangen.get(c);
    }

    public String getNaam() {
        return this.naam;
    }

    public Map<Character, Node> getOvergangen() {
        return overgangen;
    }

    public Map<Node, Integer> getGewichtOvergangen() {
        return gewichtOvergangen;
    }

    }

