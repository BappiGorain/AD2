import java.util.ArrayList;
import java.util.Collections;

class knapsack implements Comparable<knapsack>
{
    float weight;
    float cost;
    float cpw;
    knapsack(float weight, float cost, float cpw)
    {
        this.weight = weight;
        this.cost = cost;
        this.cpw = cpw;
    }

    @Override
    public int compareTo(knapsack item)
    {
        if(this.cpw > item.cpw)
        {
            return +1;
        }
        else if(this.cpw < item.cpw)
        {
            return -1;
        }
        else
        {
            return 0;
        }
    }

    
}

public class Fractional_Knapsack
{
        public static void main(String[] args) {
        float weight[] = { 2, 4, 3, 6, 6 };
        float cost[] = { 32, 28, 15, 24, 28 };
        float capacity = 11;

        ArrayList<knapsack> list = new ArrayList<>();
        
        for(int i=0;i<weight.length;i++)
        {
            
            list.add(new knapsack(weight[i], cost[i], cost[i]/weight[i]));
        }

        Collections.sort(list, Collections.reverseOrder());

        float max_profit = 0f;

        for(int i=0;i<list.size() && capacity > 0;i++)
        {
            if(list.get(i).weight <= capacity)
            {
                max_profit += list.get(i).cost;
                capacity = capacity - list.get(i).weight;
                System.out.println("Used Weight -> " + list.get(i).weight + " -> cost/weight -> " + list.get(i).cost/list.get(i).weight + " -> put -> " + list.get(i).cost);
            }
            else 
            {
                max_profit += capacity * list.get(i).cpw;
                System.out.println("Used Weight -> " + capacity + " -> cost/weight -> " + list.get(i).cost/list.get(i).weight + " -> put -> " + capacity * list.get(i).cpw);
                break;
            }
        }

        System.out.println("Max Profit: " + max_profit);
        
    }
}
