/***
1172 Hard
***/

class DinnerPlates {
    Map<Integer, Stack> map;
    int leftPoint;
    int rightPoint;
    int cap;
    public DinnerPlates(int capacity) {
        map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        map.put(0, stack);
        leftPoint = 0;
        rightPoint = 0;
        cap = capacity;
    }
    
    public void push(int val) {
        Stack<Integer> left = map.get(leftPoint);
        while (left != null && left.size() == cap) {
            leftPoint++;
            left = map.get(leftPoint);
        }
        
        if (left == null) {
            left = new Stack<>();
            map.put(leftPoint, left);
        }
        
        left.push(val);
        
        rightPoint = Math.max(leftPoint, rightPoint);
        
    }
    
    public int pop() {
        Stack<Integer> right = map.get(rightPoint);
        while (right != null && right.size() == 0) {
            rightPoint--;
            right = map.get(rightPoint);
        }
        
        if (right == null) {
            leftPoint = 0;
            rightPoint = 0;
            return -1;
        }
        
        int val = right.pop();
        leftPoint = Math.min(leftPoint, rightPoint);
        return val;
    }
    
    public int popAtStack(int index) {
        if (map.containsKey(index) && map.get(index).size() > 0) {
            Stack<Integer> stack = map.get(index);
            int val = stack.pop();
            leftPoint = Math.min(index, leftPoint);
            return val;
        }
        return -1;
    }
}

/**
 * Your DinnerPlates object will be instantiated and called as such:
 * DinnerPlates obj = new DinnerPlates(capacity);
 * obj.push(val);
 * int param_2 = obj.pop();
 * int param_3 = obj.popAtStack(index);
 */