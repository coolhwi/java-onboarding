package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int left_max, right_max;

        if(isNotBookPage(pobi) || isNotTwoElements(pobi) || isNotSidePage(pobi)) return -1;
        if(isNotBookPage(crong) || isNotTwoElements(crong) || isNotSidePage(crong)) return -1;
        //이제 정상 값이 들어온것이다.
        left_max = input_value(pobi);
        right_max = input_value(crong);

        if(left_max > right_max) answer = 1;
        else if (left_max == right_max) {
            answer = 0;
        } else answer = 2;

        return answer;
    }
    static int input_value(List<Integer> check){
        int num;
        int left = check.get(0);
        int right = check.get(1);
        String l_size = String.valueOf(left);
        String r_size = String.valueOf(right);
        int[] l_arr = new int[l_size.length()];
        int[] r_arr = new int[r_size.length()];

        //왼쪽 오른쪽 각 자리 배열에 넣기
        System.out.println("=============");
        System.out.println("left = "+ left);
        System.out.println("=============");
        System.out.println("right = " + right);
        num=left;
        for(int i=0; i<l_size.length(); i++){
            l_arr[i] = num%10;
            num = num/10;
        }
        num=right;
        for(int i=0; i<r_size.length(); i++){
            r_arr[i] = num%10;
            num = num/10;
        }

        System.out.println("l_arr");
        for(int i=0; i<l_size.length(); i++){
            System.out.print(l_arr[i]+" ");
        }
        System.out.println("");
        System.out.println("r_arr");
        for(int i=0; i<r_size.length(); i++){
            System.out.print(r_arr[i]+" ");
        }


        return find_max(l_arr,r_arr);
    }

    static int find_max(int[] left,int[] right){
        int sum=0, mul=1;
        int l_max,r_max;
        for(int i=0; i< left.length ; i++){
            sum += left[i];
            mul *= left[i];
        }
        System.out.println("===========find_max=============");

        System.out.println("l_sum ="+sum);
        System.out.println("l_mul ="+ mul);

        if(sum > mul) l_max= sum;
        else l_max = mul;

        sum=0;
        mul=1;
        for(int i=0; i< right.length ; i++){
            sum += right[i];
            mul *= right[i];
        }

        System.out.println("r_sum ="+sum);
        System.out.println("r_mul ="+ mul);

        if(sum > mul) r_max= sum;
        else r_max = mul;

        System.out.println("=============================");
        System.out.println("===========max_value=============");
        System.out.println("l_max = "+l_max);
        System.out.println("r_max = "+r_max);

        if(r_max > l_max) return r_max;
        else return l_max;
    }

    static boolean isNotBookPage(List<Integer> check){
        return 1 > check.get(0) || check.get(0)>400 || 1>check.get(1) || check.get(1) > 400;
    }
    static boolean isNotTwoElements(List<Integer> check){
        return check.size() != 2;
    }
    static boolean isNotSidePage(List<Integer> check){
        return check.get(0) != check.get(1) -1;
    }

}