package com;

import java.util.HashMap;
import java.util.Map;

public class Node {
    // dictionary overgangen
    private Map<Character, Node> overgangen = new HashMap<>();
    final String naam;

    public Node(String naam) {
        this.naam = naam;
    }

    public void addOvergang(char c, Node node){
        overgangen.put(c, node);
    }
    // krijg value op een gegeven key in de overgangen dictionary
    public Node getOvergang(char c){
        return overgangen.get(c);
    }

    public String getNaam() {
        return this.naam;
    }

    public int getAantalOvergangen(){
        return overgangen.size();
    }
}