class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] boxed = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            boxed[i] = arr[i];
        }
        
        java.util.Arrays.sort(boxed, (a, b) -> {
            int bitsA = Integer.bitCount(a);
            int bitsB = Integer.bitCount(b);
            if (bitsA != bitsB) {
                return bitsA - bitsB;
            }
            return a - b;
        });
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = boxed[i];
        }
        
        return arr;
    }
}
