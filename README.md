# FSM
2. Finite State Machine & Testing
Implementatie van een generieke Finite State Machine.

Run src/com/Main.java.

Classes:
src/com/Nodes.java node class, een node kan 0..* overgangen hebben elke overgang heeft een character of een weging en een node waarnaar deze overgang gaat.

src/com/FSM.java FSM class, heeft een startNode FSM krijgt een tekstInvoer van characters bijv: AABCB. en gaat van node naar node startend bij de startNode. en kiest een volgende overgang gebasseerd op het huidige character. Als voor de tekstinvoer een getal(als string) wordt meegegeven zal de FSM overgangen kiezen gebasseerd op de gewichten van de huidige node zovaak als het getal dat meegegeven is.

UnitTests:
test/com/FSMTest.java tests: run (met character overgangen), run (met gewicht overgangen), equals, equals (met gewichten, als er maar 1 mogelijk pad)
test/com/NodeTest.java tests: addOvergang, addGewichtOvergang, getOvergang
 
