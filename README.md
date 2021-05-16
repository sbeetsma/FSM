# FSM
2. Finite State Machine & Testing
Implementatie van een generieke Finite State Machine.

Run src/com/Main.java.

Classes:
src/com/Nodes.java node class, een node kan 0..* overgangen hebben van elk character met elke bestaande node.

src/com/FSM.java FSM class, heeft een startNode FSM krijgt een tekstInvoer van characters bijv: AABCB. en gaat van node naar node startend bij de startNode. als een overgang niet bestaat stopt de FSM.

UnitTests:
test/com/FSMTest.java
 
test/com/NodeTest.java
