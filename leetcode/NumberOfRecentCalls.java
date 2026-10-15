/**
 * NumberOfRecentCalls
 */
class NumberOfRecentCalls {
    Deque<Integer> requests;
    public RecentCounter() {
        requests = new ArrayDeque<>();
    }
    
    public int ping(int t) {
        requests.push(t);
        int window_start = t - 3000;

        while(!requests.isEmpty() && window_start > requests.peekLast()){
            requests.pollLast();
        }
        
        return requests.size();
    }
}