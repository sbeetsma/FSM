package com;

import java.util.ArrayList;

public class Proces {
    private Node HuidigeNode;
    private ArrayList<Node> NodePad =  new ArrayList<>();

    public Proces(Node StartNode) {
        this.HuidigeNode = StartNode;
        this.NodePad.add(StartNode);
    }

    public void f(String TekstInvoer){
        for (int i = 0; i < TekstInvoer.length(); i++){
            char c = TekstInvoer.charAt(i);

            if(c == 'A'){
                if(HuidigeNode.getOvergangA() == null){
                    System.out.println("Foutmelding: " + HuidigeNode.getNaam() + " heeft geen pad A");
                    break;
                }
                this.HuidigeNode = HuidigeNode.getOvergangA();
                this.NodePad.add(HuidigeNode);
            }else if(c == 'B'){
                if(HuidigeNode.getOvergangB() == null){
                    System.out.println("Foutmelding: " + HuidigeNode.getNaam() + " heeft geen pad B");
                    break;
                }
                this.HuidigeNode = HuidigeNode.getOvergangB();
                this.NodePad.add(HuidigeNode);
            }
        }
        }

    public ArrayList<String> getNodePad() {
        ArrayList<String> NodeNamen = new ArrayList<>();
        for (int i = 0; i < NodePad.size(); i++)
        {
            NodeNamen.add(NodePad.get(i).getNaam());
        }
        return NodeNamen;
    }
}
