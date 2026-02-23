class Twitter {
    private java.util.Map<Integer, java.util.Set<Integer>> following;
    private java.util.Map<Integer, java.util.List<int[]>> tweets;
    private int timestamp;

    public Twitter() {
        following = new java.util.HashMap<>();
        tweets = new java.util.HashMap<>();
        timestamp = 0;
    }

    public void postTweet(int userId, int tweetId) {
        tweets.computeIfAbsent(userId, k -> new java.util.ArrayList<>()).add(new int[]{timestamp++, tweetId});
    }

    public java.util.List<Integer> getNewsFeed(int userId) {
        java.util.PriorityQueue<int[]> pq = new java.util.PriorityQueue<>((a, b) -> b[0] - a[0]);
        
        java.util.Set<Integer> followees = following.getOrDefault(userId, new java.util.HashSet<>());
        java.util.Set<Integer> users = new java.util.HashSet<>(followees);
        users.add(userId);
        
        for (int user : users) {
            java.util.List<int[]> userTweets = tweets.get(user);
            if (userTweets != null) {
                for (int[] tweet : userTweets) {
                    pq.offer(tweet);
                }
            }
        }
        
        java.util.List<Integer> result = new java.util.ArrayList<>();
        while (!pq.isEmpty() && result.size() < 10) {
            result.add(pq.poll()[1]);
        }
        
        return result;
    }

    public void follow(int followerId, int followeeId) {
        following.computeIfAbsent(followerId, k -> new java.util.HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (following.containsKey(followerId)) {
            following.get(followerId).remove(followeeId);
        }
    }
}
