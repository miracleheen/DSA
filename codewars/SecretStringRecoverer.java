public class SecretStringRecoverer {
    public String recoverSecret(char[][] triplets) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();

        for (char[] triplet : triplets) {
            for (char c : triplet) {
                graph.computeIfAbsent(c, ignored -> new HashSet<>());
                inDegree.putIfAbsent(c, 0);
            }
        }

        for (char[] triplet : triplets) {
            addEdge(triplet[0], triplet[1], graph, inDegree);
            addEdge(triplet[1], triplet[2], graph, inDegree);
        }

        Deque<Character> queue = new ArrayDeque<>();

        for (Map.Entry<Character, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.add(entry.getKey());
            }
        }

        StringBuilder result = new StringBuilder();

        while (!queue.isEmpty()) {
            char current = queue.remove();

            result.append(current);

            for (char next : graph.get(current)) {
                int degree = inDegree.merge(next, -1, Integer::sum);

                if (degree == 0) {
                    queue.add(next);
                }
            }
        }

        return result.toString();
    }

    private static void addEdge(
            char from,
            char to,
            Map<Character, Set<Character>> graph,
            Map<Character, Integer> inDegree) {

        if (graph.get(from).add(to)) {
            inDegree.merge(to, 1, Integer::sum);
        }
    }
}