package com;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class FSM {
    private Node huidigeNode;
    private ArrayList<Node> nodePad =  new ArrayList<>();

    public FSM(Node startNode) {
        this.huidigeNode = startNode;
        this.nodePad.add(startNode);
    }

    public void run(String tekstInvoer){
        // Voor elk character in de tekstinvoer
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

    public int getPadLengte(){
        return nodePad.size();
    }

    @Override
    public String toString() {
        return nodePad.stream().map(Node::getNaam).collect(Collectors.joining(", "));
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
