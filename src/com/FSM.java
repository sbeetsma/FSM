package com;

import java.util.*;
import java.util.stream.Collectors;

public class FSM {
    private Node huidigeNode;
    private ArrayList<Node> nodePad =  new ArrayList<>();

    public FSM(Node startNode) {
        this.huidigeNode = startNode;
        this.nodePad.add(startNode);
    }
    // als tekstinvoer geparsed kan worden naar een int run de fsm gebasseerd op de overgangen en hun gewichten. en staat de tekstinvoer voor het (max) aantal stappen
    // anders op overgangen en hun character dan staat de lengte van de tekstinvoer voor het (max) aantal stappen
    public void run(String tekstInvoer){
        // try string naar int
        try{
            // lijst waar nodes inkomen het aantal dat een node voorkomt hangt af van de gewichten van de huidige node
            // als een node een gewicht van 2 deze 2 keer wordt toegevoegd
            ArrayList<Node> nodeGewichten = new ArrayList<>();
            for (int i = 0; i < Integer.parseInt(tekstInvoer.trim()); i++){
                // entries uit hashmap
                Set<Map.Entry<Node, Integer>> entries = huidigeNode.getGewichtOvergangen().entrySet();
                // elk gewicht heeft een key(Node) en een value(Integer)
                for (Map.Entry<Node, Integer> gewichten : entries) {
                    // voeg de node toe aan de nodeGewichten lijst zovaak als het gewicht
                    for (int j = 0; j < gewichten.getValue(); j++) {
                        nodeGewichten.add(gewichten.getKey());
                    }
                }
                // als er geen gewichten zijn loopt het pad dood.
                if (nodeGewichten.size() == 0){
                    System.out.println("Foutmelding: " + huidigeNode.getNaam() + " heeft geen gewichten");
                    break;
                }
                // kies een random node uit de lijst nodeGewichten hoe hoger het gewicht hoe hoger de kans dat deze gekozen wordt.
                this.huidigeNode = nodeGewichten.get(new Random().nextInt(nodeGewichten.size()));
                this.nodePad.add(huidigeNode);
                // clear de lijst zodat deze leeg is voor de volgende gewichten
                nodeGewichten.clear();
            }
        }
        catch (NumberFormatException nfe){
            for (int i = 0; i < tekstInvoer.length(); i++){
                char c = tekstInvoer.charAt(i);
                // vraag de volgendeNode op door te kijken welke overgang hoort bij de huidige node en het huidige character.
                Node volgendeNode = huidigeNode.getOvergang(c);
                // als de overgang niet bestaat geef foutmelding en break de loop
                if(volgendeNode == null){
                    System.out.println("Foutmelding: " + huidigeNode.getNaam() + " heeft geen pad " + c);
                    break;
                }
                // anders bestaat de overgang wel dus de huidigeNode wordt de volgende en wordt toegevoegd aan nodePad
                this.huidigeNode = volgendeNode;
                this.nodePad.add(huidigeNode);

            }
        }
        }

    public int getPadLengte(){
        return nodePad.size();
    }

    @Override
    public String toString() {
        return nodePad.stream().map(Node::getNaam).collect(Collectors.joining(", ")) + "\n";
    }

    // fsm is gelijk aan een ander als nodePad hetzelfde is
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FSM)) return false;

        FSM fsm = (FSM) o;

        return nodePad.equals(fsm.nodePad);
    }

    @Override
    public int hashCode() {
        return nodePad.hashCode();
    }
}
