package hashFunctions;

public class BaseHashFuncion implements HashFunction {
    /**
     * this class is hash function to be used by occurancesCounter. it gives unique hashcode for a string
     * thus allowing to identify occuring sequences in a text.
     * @param base is the size of the alphabet.
     * @param alphabetStartingIndex is the index of the first letter in the unicode
     */
    private int base;
    private int alphabetStartingIndex;

    public BaseHashFuncion(int base, int index){
        this.base=base;
        this.alphabetStartingIndex=index;
    }

    /**
     *
     * @param word
     * @return
     */
    @Override
    public Integer hash(String word) {
        int wordLenth=word.length();
        int hash=0;
        for (int i=0; i<wordLenth;i++){
            hash+=(word.charAt(i)-alphabetStartingIndex)*(base^i);
        }
        return hash;
    }
}
