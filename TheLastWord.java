import java.util.Scanner;

/**
 * Created by shubhamgoyal on 4/15/16.
 */
public class TheLastWord {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CoinJam cj = new CoinJam();
        int t = sc.nextInt();
        sc.nextLine();
        for(int j = 1; j <= t; j++)
        {
            String s = sc.nextLine();
            StringBuilder out = new StringBuilder();
            char c = s.charAt(0);
            int current = c;

            out.append(c);

            for(int i = 1; i < s.length(); i++)
            {
                c = s.charAt(i);
                int p = c;
                if(p < current)
                {
                    out.append(c);
                }
                else
                {
                    out.insert(0 ,c);
                    current = p;
                }
            }
            System.out.print("Case #" + j+": ");
            System.out.println(out);

        }
    }
}
