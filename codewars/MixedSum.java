public class MixedSum {
    public int sum(List<?> mixed) {	
        int totalSum = 0;
        
        for (Object obj : mixed) {
             if (obj instanceof Integer)  totalSum += (Integer) obj;
             else if (obj instanceof String) totalSum += Integer.parseInt((String) obj);
        }
        
        return totalSum;
    }
}