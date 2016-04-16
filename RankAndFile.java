import java.util.*;

/**
 * Created by shubhamgoyal on 4/15/16.
 */
public class RankAndFile {


    public static LinkedHashMap sortHashMapByValuesD(HashMap passedMap) {
        List mapKeys = new ArrayList(passedMap.keySet());
        List mapValues = new ArrayList(passedMap.values());
        Collections.sort(mapValues);
        Collections.sort(mapKeys);

        LinkedHashMap sortedMap = new LinkedHashMap();

        Iterator valueIt = mapValues.iterator();
        while (valueIt.hasNext()) {
            Object val = valueIt.next();
            Iterator keyIt = mapKeys.iterator();

            while (keyIt.hasNext()) {
                Object key = keyIt.next();
                String comp1 = passedMap.get(key).toString();
                String comp2 = val.toString();

                if (comp1.equals(comp2)){
                    passedMap.remove(key);
                    mapKeys.remove(key);
                    sortedMap.put((Integer) key, (Integer) val);
                    break;
                }

            }

        }
        return sortedMap;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int q = 1; q <= t; q++)
        {
            int k = sc.nextInt();

            int[][] data = new int[2 * k - 1][k];

            HashMap<Integer, Integer > myMap = new HashMap<>();
            for(int i = 0; i < 2 * k - 1; i++)
            {
                data[i][0] = sc.nextInt();
                myMap.put(i  , data[i][0] );

                for(int j = 1; j < k; j++)
                {
                    data[i][j] = sc.nextInt();
                }
//                data[i][k - 1] = sc.nextInt();
//                if(data[i][k - 1] > max)
//                {
//                    max = data[i][k - 1];
//                    n = i;
//                }
            }

//            for(int i = 0; i < 2*k - 1; i++)
//            {
//                for(int j = 0; j < k; j++)
//                {
//                    System.out.print(data[i][j] + " ");
//                }
//                System.out.println();
//            }

            Map result2 = sortHashMapByValuesD(myMap);

            int[][] result = new int[k][k];
            int index = 0;
            int previous = 0;
            for(Object i : result2.keySet())
            {

                int e = (Integer) result2.get(i);
                int f = (Integer) i;
                if( e > previous)
                {
                    for(int j = 0; j < k; j++ )
                    {
                        result[index][j] = data[f][j];
                    }
                    index++;
                }



            }

        }
    }
}
