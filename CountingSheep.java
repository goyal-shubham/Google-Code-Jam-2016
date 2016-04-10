import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/**
 * Created by shubhamgoyal on 4/9/16.
 */
public class CountingSheep {

    public static int[] intToString(int a)
    {
        String temp = Integer.toString(a);
        int[] a1 = new int[temp.length()];
        for (int i = 0; i < temp.length(); i++)
        {
            a1[i] = temp.charAt(i) - '0';
        }
        return a1;
    }

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        PrintWriter writer = new PrintWriter("output.txt");
        for(int j = 1; j <= t; j++)
        {
            writer.print("Case #" + j +": ");
            System.out.print("Case #" + j +": ");
            int n = sc.nextInt();
            if(n == 0)
            {
                writer.println(" INSOMNIA");
                System.out.println("INSOMNIA");
                continue;
            }

            boolean[] result = new boolean[10];
            int count = 0;
            int i = 1;
            int num = n;
            while(count != 10)
            {
                int[] a1 = intToString(num);
                for(int a : a1)
                {
                    if(result[a] == true)
                    {
                        continue;
                    }
                    else
                    {
                        result[a] = true;
                        count++;
                    }
                }
                i++;
                num = i * n;

            }
            System.out.println(n * (i-1));
            writer.println((n * i-1));
        }
        writer.close();

    }
}
