package tracy.algorithm.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * User: tracy
 * Date: 14-8-12
 * 约瑟夫环问题
 */
public class Josephus {

    public static int simple(int n,int k){
        if(n==1){
            return 0;
        }
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<n;i++){
            list.add(i);
        }
        List<Integer> next = new ArrayList<Integer>();

        while(list.size()>1){
            int len = list.size();
            int counter = 0;
            for(int i=1;i<k;i++){
                counter++;
                if(counter==len){
                    counter=0;
                }
            }

            int start = counter+1;
            if(start==len){//移除的是最后一个
                for(int i=0;i<len-1;i++){
                    next.add(list.get(i));
                }
            }else if(start==1){//移除的是第一个
                for(int i=1;i<len;i++){
                    next.add(list.get(i));
                }
            }else{//移除的中间的元素
                for(int i=start;i<len;i++){
                    next.add(list.get(i));
                }
                for(int i=0;i<counter;i++){
                    next.add(list.get(i));
                }
            }
            list = next;
            next = new ArrayList<Integer>();
        }
        return list.get(0);
    }


    public static int math(int n,int k){
        if(n <= 0 || k < 0)
            return -1;

        // if there are only one integer in the circle initially,
        // of course the last remaining one is 0
        int lastInteger = 0;

        /*
        第一个人出列后的序列为：
        0 1 3 4 5 6 7 8 9
        即:
        3 4 5 6 7 8 9 0 1（*）
        我们把该式转化为:
        0 1 2 3 4 5 6 7 8 (**)
        则你会发现: （(**)+3）%10则转化为(*)式了
        所以可以从n=1开始，返回的是0，然后递推“0”在n=2时对应的值
         */

        // find the last remaining one in the circle with n integers
        for (int i = 2; i <= n; i ++)
            lastInteger = (lastInteger + k) % i;

        return lastInteger;
    }

    public static void main(String[] args) {
        System.out.println(simple(7,4)+","+math(7,4));
    }
}
