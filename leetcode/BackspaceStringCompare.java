class BackspaceStringCompare{
    public boolean backspaceCompare(String s, String t) {
        int n = s.length() - 1;
        int m = t.length() - 1;
        int skip_s = 0;
        int skip_t = 0;

        while(n >= 0 && m >= 0){
            if(s.charAt(n) == '#'){
                ++skip_s;
                --n;
                continue;
            }

            if(skip_s > 0){
                --skip_s;
                --n;
                continue;
            }

            if(t.charAt(m) == '#'){
                ++skip_t;
                --m;
                continue;
            }

            if(skip_t > 0){
                --skip_t;
                --m;
                continue;
            }

            if(s.charAt(n) != t.charAt(m)) return false;

            --n;
            --m;
        }

        while(n >= 0){
            if(s.charAt(n) == '#'){
                ++skip_s;
                --n;
            }else if(skip_s > 0){
                --skip_s;
                --n;
            }else{
                break;
            }
        }

        while(m >= 0){
            if(t.charAt(m) == '#'){
                ++skip_t;
                --m;
            }else if(skip_t > 0){
                --skip_t;
                --m;
            }else{
                break;
            }
        }

        return n <= 0 && m <= 0;
    }
}