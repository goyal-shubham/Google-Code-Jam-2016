import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by shubhamgoyal on 4/9/16.
 */
public class RevengeofthePancakes {

    public static char[] flip(int start, int end, char c, char[] s)
    {
        for(int i = 0 ;  i < end; i++)
        {
            s[i] = c;
        }
        return s;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        PrintWriter writer = new PrintWriter("output.txt");
        for(int j = 1; j <= t; j++)
        {
            String s = sc.nextLine();
            writer.print("Case #" + j+": ");
            System.out.print("Case #" + j +": ");
            int i = 0;
            int count = 0;
            char[] c = s.toCharArray();
            while( i != s.length())
            {
                if(c[i] == '+')
                {
                    while(i < c.length && c[i] == '+')
                    {
                        i++;
                    }
                    if(i == s.length())
                    {
                        break;
                    }
                    count++;
                    c = flip(0 , i , '-' , c);
                }
                else
                {
                    while(i < c.length && c[i] == '-' )
                    {
                        i++;
                    }
                    count++;
                    c = flip(0 , i , '+' , c);
                }
                i = 0;
            }
            writer.println(count);

            System.out.println(count);
        }
        writer.close();

    }
}
