class Twitter {
    int count = 0;
    HashMap<Integer,List<int[]>> tweetMap;
    HashMap<Integer, HashSet<Integer>> followMap;
    public Twitter() {
        tweetMap = new HashMap<>();
        followMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId, new ArrayList<>());
        tweetMap.get(userId).add(new int[]{count++, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
       HashSet<Integer> followees = new HashSet<>();
       
        if (followMap.containsKey(userId)) {
            followees = followMap.get(userId);
        }
        followees.add(userId);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        
        Iterator<Integer> it = followees.iterator();
        while (it.hasNext()) {
            int user = it.next();
            List<int []> tweets = tweetMap.get(user);
            if (tweets != null) {
                for (int i = 0; i < tweets.size(); i++) {
                    minHeap.add(tweets.get(i));
                }   
            }
            
        }
        List<Integer> tweetList = new ArrayList<>();
        while(minHeap.size() > 0 && tweetList.size() < 10) {
            tweetList.add(minHeap.poll()[1]);
        }
        return tweetList;
    }
    
    public void follow(int followerId, int followeeId) {
        if (followerId != followeeId) {
            followMap.putIfAbsent(followerId, new HashSet<>());
            followMap.get(followerId).add(followeeId);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        followMap.getOrDefault(followerId, new HashSet<>()).remove(followeeId);
    }
}
