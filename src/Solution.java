public class Solution {
    public static void main(String[] args) {
        double[] a = {5,-2,7};
        ArrayVectorImpl array = new ArrayVectorImpl(a);
        array.set(5,12);
        for (int i = 0; i < array.getSize(); i++) {
            System.out.println(array.get(i));
        }
    }
}
