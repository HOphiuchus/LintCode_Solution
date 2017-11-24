package main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// LeetCode 341
public class LC528FlattenNestedListIteratorA implements Iterator<Integer> {
    int idx = 0;
    private List<Integer> nestedList = new ArrayList<>();

    public LC528FlattenNestedListIteratorA(List<NestedInteger> nestedList) {
        // Initialize your data structure here.
        flatten(nestedList);
    }

    // @return {int} the next element in the iteration
    @Override
    public Integer next() {
        return nestedList.get(idx++);
    }

    private void flatten(List<NestedInteger> nestedIntegerList) {
        Iterator<NestedInteger> iterator = nestedIntegerList.iterator();
        while (iterator.hasNext()) {
            NestedInteger nestedInteger = iterator.next();
            if (nestedInteger.isInteger()) {
                nestedList.add(nestedInteger.getInteger());
            } else {
                flatten(nestedInteger.getList());
            }
        }
    }

    // @return {boolean} true if the iteration has more element or false
    @Override
    public boolean hasNext() {
        // Write your code here
        return idx < nestedList.size();
    }


    interface NestedInteger {

        public boolean isInteger();

        public Integer getInteger();

        public List<NestedInteger> getList();
    }
}
