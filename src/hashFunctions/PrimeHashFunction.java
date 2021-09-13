package hashFunctions;

public class PrimeHashFunction implements HashFunction {

    private int prime;

    public PrimeHashFunction(int alphabetSize){
        findBiggerPrime(alphabetSize);
    }

    private void findBiggerPrime(int alphabetSize) {
    }

    @Override
    public Integer hash(String substring) {
        int len=substring.length();
        Integer hashCode=0;
        for (int i=0;i<len;i++){
            hashCode=hashCode*31+substring.charAt(i);
        }
        return hashCode;
    }
}
