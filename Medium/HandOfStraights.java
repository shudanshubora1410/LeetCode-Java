class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        
        java.util.TreeMap<Integer, Integer> count = new java.util.TreeMap<>();
        for (int card : hand) {
            count.put(card, count.getOrDefault(card, 0) + 1);
        }
        
        while (!count.isEmpty()) {
            int first = count.firstKey();
            
            for (int i = 0; i < groupSize; i++) {
                int card = first + i;
                if (!count.containsKey(card)) {
                    return false;
                }
                
                int freq = count.get(card);
                if (freq == 1) {
                    count.remove(card);
                } else {
                    count.put(card, freq - 1);
                }
            }
        }
        
        return true;
    }
}
