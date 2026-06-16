public class RgbToHex {
    public static String rgb(int r, int g, int b) {
        r = Math.max(0, Math.min(255, r));
        g = Math.max(0, Math.min(255, g));
        b = Math.max(0, Math.min(255, b));
        
        return String.format("%02X%02X%02X", r, g, b);
    }
}
