package onboarding;

import java.util.ArrayList;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        ArrayList<Character> list = new ArrayList<Character>();
        Character before,after;
        int k=0;
        for(int i=0 ; i< cryptogram.length(); i++){
            char C = cryptogram.charAt(i);
            list.add(C);
        }
        while(k != list.size()){
            for(k=1; k< list.size();k++){
                before = list.get(k-1);
                after = list.get(k);
                if(before.equals(after)){
                    list.remove(k-1);
                    list.remove(k-1);
                    k=1;
                    break;
                }
            }
            if(list.size() == 0) break;
        }
        System.out.println("list = "+list);
        for(char a : list){
            answer += a;
        }
        return answer;
    }
}
