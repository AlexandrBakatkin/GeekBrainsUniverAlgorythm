import java.util.ArrayList;

public class BackPack {
    private ArrayList<Obj> obj;
    private ArrayList<Obj> bestItems;
    private int maxWeight;
    private int maxCost = 0;
    private int count;


    public BackPack(ArrayList<Obj> objList, int maxWeight) {
        this.maxWeight = maxWeight;
        this.obj = objList;
    }

    private int weight(ArrayList<Obj> list){
        int weight = 0;
        for (Obj o: list) {
            weight = weight + o.getWeight();
        }
        return weight;
    }

    private int cost(ArrayList<Obj> list){
        int cost = 0;
        for (Obj o: list) {
            cost = cost + o.getCost();
        }
        return cost;
    }

    private void bestSet(ArrayList<Obj> items) {
        if (bestItems == null) {
            if (weight(items) <= maxWeight) {
                bestItems = items;
                maxCost = cost(items);
            }
        } else {
            if (weight(items) <= maxWeight && cost(items) > maxCost) {
                bestItems = items;
                maxCost = cost(items);
            }
        }
    }

    public void calcBestSet(ArrayList<Obj> items) {
        if (items.size() > 0) {
            bestSet(items);
            count++;
        }

        for (int i = 0; i < items.size(); i++) {
            ArrayList<Obj> list = new ArrayList<>(items);
            list.remove(i);
            calcBestSet(list);
        }
    }

    public ArrayList<Obj> getBestSet() {
        return bestItems;
    }

    public int getBestPrice() {
        return maxCost;
    }

    public int getCount(){
        return count;
    }
}