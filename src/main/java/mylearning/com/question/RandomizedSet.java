package mylearning.com.question;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class RandomizedSet {

    /*
     Implement the RandomizedSet class:

    RandomizedSet() Initializes the RandomizedSet object.
    bool insert(int val) Inserts an item val into the set if not present.
    Returns true if the item was not present, false otherwise.
    bool remove(int val) Removes an item val from the set if present.
    Returns true if the item was present, false otherwise.
    int getRandom() Returns a random element from the current set of
    elements (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.
    You must implement the functions of the class such that each
    function works in average O(1) time complexity.

    Input
    ["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
    [[], [1], [2], [2], [], [1], [2], []]
    Output
    [null, true, false, true, 2, true, false, 2]
   */

    HashSet<Integer> randomIntSet;

    public RandomizedSet() {
        this.randomIntSet = new HashSet<>();
    }

    public boolean insert(int val) {
        if (randomIntSet.contains(val)) {
            return false;
        }
        randomIntSet.add(val);
        return true;
    }

    public boolean remove(int val) {

        if (randomIntSet.contains(val)) {
            randomIntSet.remove(val);
            return true;
        }

        return false;
    }
    public int getRandom() {
        Random random = new Random();
        List<Integer> list = new ArrayList<>(randomIntSet);

        return list.get(random.nextInt(randomIntSet.size()));
    }

    public static void main(String[] args) {

        RandomizedSet obj = new RandomizedSet();
        boolean param_1 = obj.insert(1);
        boolean param_2 = obj.remove(2);
        boolean param_3 = obj.insert(2);
        int param_4 = obj.getRandom();
        boolean param_5 = obj.remove(1);
        boolean param_6 = obj.insert(2);
        int param_7 = obj.getRandom();

        System.out.println( param_1 +" "+param_2 +" "+param_3 +" "+param_4 +" "+param_5 +" "+param_6 +" "+param_7 +" ");

    }

}
