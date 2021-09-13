import hashFunctions.BaseHashFuncion;
import hashFunctions.HashFunction;

import java.util.LinkedList;

public class main {
    public static void main (String [] args) {
        HashFunction func=new BaseHashFuncion(26,97);
        OccurrencesCounter occurrencesCounter=new OccurrencesCounter(func);
        occurrencesCounter.setText("ththlazy");
        occurrencesCounter.countOccurrences();
        LinkedList<Integer> dist=occurrencesCounter.getDists();

    }
}
