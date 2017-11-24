package main;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

// LeetCode 341
// using stack
public class LC528FlattenNestedListIteratorB implements Iterator<Integer> {
    private Stack<NestedInteger> stack = new Stack<>();

    public LC528FlattenNestedListIteratorB(List<NestedInteger> nestedList) {
        // Initialize your data structure here.
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    // @return {int} the next element in the iteration
    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }


    // @return {boolean} true if the iteration has more element or false
    @Override
    public boolean hasNext() {
        // Write your code here
        while (!stack.isEmpty()) {
            NestedInteger peek = stack.peek();
            if (peek.isInteger()) {
                return true;
            }
            NestedInteger pop = stack.pop();
            for (int i = pop.getList().size() - 1; i >= 0; i--) {
                stack.push(pop.getList().get(i));
            }

        }
        return false;
    }


    interface NestedInteger {

        public boolean isInteger();

        public Integer getInteger();

        public List<NestedInteger> getList();
    }
}
