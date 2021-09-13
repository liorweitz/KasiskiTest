import hashFunctions.HashFunction;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * This Class is responsible for finding occurring subsequences in @param text and the distance
 * between them.
 * The idea for the reduced complexity is to assign for each sequence of certain length a unique hashcode
 * and check for duplication.
 * dists param is for storing the distances between all occurrences in text field.
 */
public class OccurrencesCounter {
    private LinkedList<Integer> dists;
    private HashFunction hashFunc;
    private int allegedKeyLength;
    private String text;

    public OccurrencesCounter(HashFunction func){
        dists=new LinkedList<>();
        this.hashFunc=func;
    }

    public void setText(String text){
        this.text=text;
    }

    public void countOccurrences(){
        for (int i=2; i<=text.length()/2;i++){
            dists.addAll(count(i));
        }
    }

    private void FindMostCommonDivider() {
        
    }

    /**
     * The method generate unique hash code for eace sequence of length len and store it in hash map
     * with the hash code as key and list - of Text indexes the sequence begins at - as value.
     * then, it iterates over the map, looking for lists bigger than 1. and adds the subtraction of
     * following indexes in a list, this subtraction is, effectively, the distance between the occurring
     * sequences in Text for given sequence length.
     * @param len
     * @return LinkedList with distances between occurances for given sequence length @param len.
     */
    private LinkedList<Integer> count(int len) {
        char[] charArr = textToArray();
        HashMap<Integer, LinkedList<Integer>> seqToIndex = new HashMap<>();
        for (int i = 0; i <= text.length() - len + 1; i++) {
            Integer hashCode = hashFunc.hash(text.substring(i, i + len));
            if (seqToIndex.containsKey(hashCode)) {
                seqToIndex.get(hashCode).add(i);
            } else {
                LinkedList<Integer> l = new LinkedList();
                l.add(i);
                seqToIndex.put(hashCode, l);
            }
        }
        LinkedList<Integer> dists = new LinkedList();
        for (Map.Entry<Integer, LinkedList<Integer>> entry : seqToIndex.entrySet()) {
            LinkedList<Integer> l = entry.getValue();
            if (l.size() > 1) {
                for (int i = 0; i < l.size() - 1; i++) {
                    dists.add(l.get(i + 1) - l.get((i)));
                }
            }
        }
        return dists;
    }

//    private int findMinDist(LinkedList<Integer> l) {
//        int minDist=Integer.MAX_VALUE;
//        for (int i=0;i<l.size()-1;i++){
//            if (minDist>(l.get(i+1))-l.get(i)){
//                minDist
//            }
//        }
//    }

    public LinkedList<Integer> getDists(){
        return dists;
    }

    private char[] textToArray() {
        char[] charArr=new char[text.length()];
        for (int i=0;i<text.length();i++){
            charArr[i]=text.charAt(i);
        }
        return charArr;
    }
}
