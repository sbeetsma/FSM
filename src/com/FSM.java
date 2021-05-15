package com;

import java.util.ArrayList;

public class FSM {
    private Node huidigeNode;
    private ArrayList<Node> nodePad =  new ArrayList<>();

    public FSM(Node startNode) {
        this.huidigeNode = startNode;
        this.nodePad.add(startNode);
    }

    public void run(String TekstInvoer){
        for (int i = 0; i < TekstInvoer.length(); i++){
            char c = TekstInvoer.charAt(i);
            Node volgendeNode = huidigeNode.getOvergang(c);
            if(volgendeNode == null){
                System.out.println("Foutmelding: " + huidigeNode.getNaam() + " heeft geen pad " + c);
                break;
            }
            this.huidigeNode = volgendeNode;
            this.nodePad.add(huidigeNode);

        }
        }

    public ArrayList<String> getNodePad() {
        ArrayList<String> NodeNamen = new ArrayList<>();
        for (Node node : nodePad) {
            NodeNamen.add(node.getNaam());
        }
        return NodeNamen;
    }
}
