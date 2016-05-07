import java.util.Scanner;

/**
 * Created by shubhamgoyal on 4/30/16.
 */
public class CloseMatch
{

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        for(int j = 1; j <= n; j++)
        {

            String s = sc.nextLine();
            String[] data = s.split(" ");
            char[] c1 = data[0].toCharArray();
            char[] c2 = data[1].toCharArray();
            int a1 = 0, a2 = 0;
            for(int i = 0; i < c1.length; i++)
            {

                if(c1[i] == '?')
                {
                    if(c2[i] == '?')
                    {
                        if(a1 == a2)
                        {
                            c1[i] = '0';
                            c2[i] = '0';
                        }
                        else if(a1 > a2)
                        {
                            c1[i] = '0';
                            c2[i] = '9';
                        }
                        else
                        {
                            c1[i] = '9';
                            c2[i] = '0';
                        }
                    }
                    else
                    {
                        if(a1 == a2)
                        {
                            c1[i] = c2[i];
                        }
                        else if(a1 > a2)
                        {
                            c1[i] = '0';
                        }
                        else
                        {
                            c1[i] = '9';
                        }
                    }
                }
                else
                {
                    if(c2[i] == '?')
                    {
                        if(a1 == a2)
                        {
                            c2[i] = c1[i];
                        }
                        else if(a1 > a2)
                        {
                            c2[i] = '9';
                        }
                        else
                        {
                            c2[i] = '0';
                        }
                    }

                }
                a1 = a1 * 10 + Character.getNumericValue(c1[i]);
                a2 = a2 * 10 + Character.getNumericValue(c2[i]);

            }

            String n1 = String.valueOf(c1);
            String n2 = String.valueOf(c2);
            System.out.print("Case #" + j+": ");
            System.out.println(n1 + " " + n2);
        }
    }
}
