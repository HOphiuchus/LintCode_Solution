package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// LeetCode 380
public class LC657InsertDeleteGetRandom {
    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();

    /*
     * @param val: a value to the set
     * @return: true if the set did not already contain the specified element or false
     */
    public boolean insert(int val) {
        // write your code here
        if (map.containsKey(val)) {
            return false;
        } else {
            map.put(val, map.size());
            list.add(val);
            return true;
        }
    }

    /*
     * @param val: a value from the set
     * @return: true if the set contained the specified element or false
     */
    public boolean remove(int val) {
        // write your code here
        if (map.containsKey(val)) {
            int value = map.remove(val);
            if(value<list.size()-1){
                int lastone = list.get(list.size()-1);
                list.set(value,lastone);
                map.put(lastone,value);
            }
            list.remove(list.size()-1);
            return true;
        } else {
            return false;
        }
    }


    /*
     * @return: Get a random element from the set
     */
    public int getRandom() {
        // write your code here
        int rand = (int) (Math.random() * map.size());
        return list.get(rand);
    }
}
