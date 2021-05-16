package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class FSM {
    private Node huidigeNode;
    private ArrayList<Node> nodePad =  new ArrayList<>();

    public FSM(Node startNode) {
        this.huidigeNode = startNode;
        this.nodePad.add(startNode);
    }

    public void run(String tekstInvoer){
        for (int i = 0; i < tekstInvoer.length(); i++){
            char c = tekstInvoer.charAt(i);
            Node volgendeNode = huidigeNode.getOvergang(c);
            if(volgendeNode == null){
                System.out.println("Foutmelding: " + huidigeNode.getNaam() + " heeft geen pad " + c);
                break;
            }
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
