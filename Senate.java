import java.util.*;
import java.util.stream.IntStream;

/**
 * Created by shubhamgoyal on 5/8/16.
 */
public class Senate
{
    static class ValueAndIndex implements Comparable<ValueAndIndex> {
         int value;
         char index;

        ValueAndIndex(int value, char index) {
            this.value = value;
            this.index = index;
        }

        @Override public int compareTo(ValueAndIndex other) {
            // compare on value;
            if (this.value < other.value) {
                return -1;
            } else if (this.value > other.value) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int q = 1; q <= t; q++)
        {
            int n = sc.nextInt();
            ValueAndIndex[] a = new ValueAndIndex[n];
            int total = 0;
            Map < Integer, Integer> myMap = new HashMap<>();

            for(int i = 0; i < n ; i++)
            {
                a[i] = new ValueAndIndex( sc.nextInt(), (char) (i + 65));
                total += a[i].value;
            }

            int max = total / 2;
            Arrays.sort(a);
//            for(int i = 0; i < n; i++)
//            {
//                System.out.println(a[i].value + " " + a[i].index) ;
//            }

            StringBuilder sb = new StringBuilder();
            int i = n - 1;
            while(i - 1 >= 0)
            {
                sb.append(a[i].index);
                a[i].value--;
                total--;
                max = total / 2;

                if (a[i].value - 1 > max)
                {
                    sb.append(a[i].index);
                    total--;
                    max = total / 2;

                    a[i].value--;


                }
                else if (a[i - 1].value > max)
                {
                    sb.append(a[i - 1].index);
                    total--;
                    max = total / 2;

                    a[i - 1].value--;


                }
                sb.append(" ");
                if(a[i].value == 0)
                {
                    i--;
                }

            }
            while(total != 0)
            {
                sb.append(a[0].index);
                sb.append(" ");
                total--;
            }
            System.out.print("Case #" + q+": ");
            System.out.println(sb);
        }
    }
}
