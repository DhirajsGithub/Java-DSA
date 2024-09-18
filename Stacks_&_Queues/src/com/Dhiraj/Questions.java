package com.Dhiraj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Questions {
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            a.add(i);
        }
        List<Integer> b = new ArrayList<>();
        for (int i = 6; i < 10; i++) {
            b.add(i);
        }

//        System.out.println(twoStacks(10, a, b));
        System.out.println(minInsertions("()))"));

    }

//    https://www.hackerrank.com/challenges/game-of-two-stacks/problem
    public static int twoStacks(int maxSum, List<Integer> a, List<Integer> b) {
        // Write your code here
        return twoStacks(maxSum, a, b, 0, 0);
    }
    private static int twoStacks(int x, List<Integer> a, List<Integer> b, int sum, int count){
        if(sum > x){
            return count;
        }
        if(a.size()==0 || b.size()==0){

            return count;
        }
        int templ = a.remove(0);
        int left = twoStacks(x, a, b, sum+templ, count+1);
        int tempR = b.remove(0);
        int right = twoStacks(x, a, b, sum+tempR, count + 1);
        return Math.max(left, right);
    }


//    https://leetcode.com/problems/valid-parentheses/description/
    public static boolean isValid(String s) {
        if(s.length()==1){
            return false;
        }
        HashMap<Character, Character> hs = new HashMap<>();
        hs.put('(', ')');
        hs.put('[', ']');
        hs.put('{', '}');
        if(hs.containsValue(s.charAt(0))){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(hs.containsKey(c)){
                stack.push(c);
            }
            else if(hs.containsValue(c) && !stack.isEmpty() && c == hs.get(stack.peek())){
                stack.pop();
            }else{
                return false;
            }
        }
        return stack.isEmpty();
    }


//    https://leetcode.com/problems/minimum-add-to-make-parentheses-valid
    public static int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()){
            if(c == ')'){       // note we are comparing ')' with '('  adding '(' in stack
                if(!stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                }else{
                    stack.push(c);
                }
            }else{
                stack.push(c);
            }
        }
        return stack.size();
    }

    //https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/
    public static int minInsertions(String s) {
        int ans = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '('){
                stack.push('(');
            }else{
                if(i+1<s.length() && s.charAt(i) == ')' && s.charAt(i+1) == ')' && !stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                    i++;
                }else if(s.charAt(i) == ')' && !stack.isEmpty() && stack.peek() == '('){
                    ans++;
                    stack.pop();
                }else if(i+1<s.length() && s.charAt(i) == ')' && s.charAt(i+1) == ')'){
                    ans++;
                    i++;
                }else{
                    ans += 2;
                }
            }
        }
        return ans + stack.size()*2;
    }
}



//https://leetcode.com/problems/implement-queue-using-stacks/description/
class MyQueue {

    Stack<Integer> first;
    Stack<Integer> second;

    public MyQueue() {
        first = new Stack<>();
        second = new Stack<>();
    }

    public void push(int x) {
        first.push(x);
    }

    public int pop() {
        while (!first.isEmpty()){
            second.push(first.pop());
        }
        int popped = second.pop();
        while (!second.isEmpty()){
            first.push(second.pop());
        }
        return popped;
    }

    public int peek() {
        while (!first.isEmpty()){
            second.push(first.pop());
        }
        int pekked = second.peek();
        while (!second.isEmpty()){
            first.push(second.pop());
        }
        return pekked;
    }

    public boolean empty() {
        return first.isEmpty();
    }
}


/*
When to use stacks & queues :
- If you are dealing with ordering, you are putting stuff in order and wanna get it back in order.
- brainstorming - I want to store ans till here and will get back to this answer later
 */