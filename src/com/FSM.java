package com;

import java.util.ArrayList;

public class FSM {
    private Node huidigeNode;
    private ArrayList<Node> nodePad =  new ArrayList<>();

    public FSM(Node StartNode) {
        this.huidigeNode = StartNode;
        this.nodePad.add(StartNode);
    }

    public void run(String TekstInvoer){
        for (int i = 0; i < TekstInvoer.length(); i++){
            char c = TekstInvoer.charAt(i);

            if(c == 'A'){
                if(huidigeNode.getOvergangA() == null){
                    System.out.println("Foutmelding: " + huidigeNode.getNaam() + " heeft geen pad A");
                    break;
                }
                this.huidigeNode = huidigeNode.getOvergangA();
                this.nodePad.add(huidigeNode);
            }else if(c == 'B'){
                if(huidigeNode.getOvergangB() == null){
                    System.out.println("Foutmelding: " + huidigeNode.getNaam() + " heeft geen pad B");
                    break;
                }
                this.huidigeNode = huidigeNode.getOvergangB();
                this.nodePad.add(huidigeNode);
            }
        }
        }

    public ArrayList<String> getNodePad() {
        ArrayList<String> NodeNamen = new ArrayList<>();
        for (int i = 0; i < nodePad.size(); i++)
        {
            NodeNamen.add(nodePad.get(i).getNaam());
        }
        return NodeNamen;
    }
}
