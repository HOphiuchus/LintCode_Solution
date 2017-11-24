package main;

import java.util.Iterator;
import java.util.List;

// LeetCode 341
// it changes the original List
public class LC528FlattenNestedListIterator implements Iterator<Integer> {


    private final List<NestedInteger> nestedList;
    private boolean isPositionModified = true;
    private boolean hasNext = false;
    private Integer next;

    public LC528FlattenNestedListIterator(List<NestedInteger> nestedList) {
        // Initialize your data structure here.
        this.nestedList = nestedList;
    }

    // @return {int} the next element in the iteration
    @Override
    public Integer next() {
        // Write your code here
        if (hasNext()) {
            isPositionModified = true;
            return next;
        } else {
            return null;
        }

    }

    private Integer getNext(List<NestedInteger> nestedIntegerList) {
        Iterator<NestedInteger> iterator = nestedIntegerList.iterator();
        while (iterator.hasNext()) {
            NestedInteger nestedInteger = iterator.next();
            if (nestedInteger.isInteger()) {
                return nestedInteger.getInteger();
            } else {
                Integer i = getNext(nestedInteger.getList());
                if (i != null) {
                    return i;
                } else {
                    iterator.remove();
                }
            }
        }
        return null;
    }

    // @return {boolean} true if the iteration has more element or false
    @Override
    public boolean hasNext() {
        // Write your code here
        if (isPositionModified) {
            next = getNext(nestedList);
            if (next != null) {
                hasNext = true;
            } else {
                hasNext = false;
            }
            isPositionModified = false;
        }
        return hasNext;
    }


    interface NestedInteger {

        public boolean isInteger();

        public Integer getInteger();

        public List<NestedInteger> getList();
    }
}
