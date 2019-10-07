import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        int n = 0;
        for (int i = 1; i <= 100; i++)
            n = n + i;
        System.out.println(n);
    }

    public int romanToInt(String s) {
        int rt = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        String code = "MDCLXVI";
        //char[] code={'I','V','X','L','C', 'D', 'M'};
        int[] value={1,5,10,50,100,500,1000};

//        List<int> list = new ArrayList<int>();
        char[] chars = s.toCharArray();
        int len = chars.length;
        int i ;
        for (i = 0; i < len - 1; i++) {
            int cur = map.get(chars[i]);
            int next = map.get(chars[i+1]);
            if( cur > next ){
                rt += cur;
            }else{
                rt = rt - cur + next;
                i++;
            }
        }
        if(i<len)
            rt += map.get(chars[len-1]);
        return rt;
    }

    public int romanToInt2(String s) {
        char[] ch = new char[s.length()];
        int[] num = new int[ch.length];
        int res=0;
        ch = s.toCharArray();
        for(int i = 0; i<ch.length; ++i){
            switch (ch[i]) {
                case 'I': num[i] = 1; break;
                case 'V': num[i] = 5; break;
                case 'X': num[i] = 10; break;
                case 'L': num[i] = 50; break;
                case 'C': num[i] = 100; break;
                case 'D': num[i] = 500; break;
                case 'M': num[i] = 1000; break;
                default:
                    return -1;
            }
        }
        for(int i=0; i<num.length; ++i){
            if (i+1==num.length || num[i]>=num[i+1]) {
                res+= num[i];
            }else {
                res += num[i+1]-num[i];
                ++i;
            }
        }
        return res;
    }

    public String intToRoman(int num) {
        return "";
    }
}