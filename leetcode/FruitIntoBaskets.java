/**
 * FruitIntoBaskets
 */
public class FruitIntoBaskets {
     public int totalFruit(int[] fruits) {
        int b = 0;
        int result = 0;
        int baskets = 2;
        Map<Integer, Integer> window_state = new HashMap();

        for(int e = 0; e < fruits.length; ++e){
            window_state.put(fruits[e], window_state.getOrDefault(fruits[e], 0) + 1);

            while(window_state.size() > baskets){
                window_state.computeIfPresent(fruits[b], (k, v) -> (v - 1 > 0) ? --v : null);
                ++b;
            }

            result = Math.max(result, e - b + 1);
        }

        return result;
    }
}