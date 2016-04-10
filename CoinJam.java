import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

/**
 * Created by shubhamgoyal on 4/9/16.
 */
public class CoinJam {

    public static long  isPrime(long num){

        if(num > 2 && num % 2 == 0)
        {
           // primeMap.put(num, Long.valueOf(2));
            return 2;
        }

        for(long i = 3; i*i<= num; i += 2)
        {
            if(num % i == 0)
            {
                //primeMap.put(num, i);
                return i;
            }
        }

       // primeMap.put(num, Long.valueOf(-1));
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CoinJam cj = new CoinJam();
        int t = sc.nextInt();

        for(int j = 1; j <= t; j++)
        {
            System.out.println("Case #" + j+":");
            int n = sc.nextInt();
            int k = sc.nextInt();
            long first = (long) Math.pow(2, n-1) + 1;
            long last = (long) (Math.pow(2, n)) - 1;
            int count = 0;
            for(long i = first; i <= last; i += 2)
            {
                StringBuilder result = new StringBuilder();
                boolean flag = false;
                int limit = 3;
                String output1 = Long.toString(i, 2);
                long div2 = isPrime(i);
                if(div2 != -1)
                {
                    result.append(div2 + " ");
                    while (limit <= 10)
                    {
                        long out = 2;
                        try
                        {
                            out = Long.valueOf(output1, limit);
                        }
                        catch (Exception e)
                        {
                            continue;
                        }

                        long divLimit = isPrime(out);
                        if (divLimit == -1)
                        {
                            flag = true;
                            break;
                        }
                        result.append(divLimit + " ");
                        limit++;
                    }
                }
                else
                {
                    flag = true;
                }

                if(flag == false)
                {
                    System.out.println( output1 + " "+ result.toString());
                    count++;

                    if(count == k)
                    {
                       break;
                    }
                }
            }
        }
    }
}
