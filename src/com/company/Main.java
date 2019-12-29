package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}

class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        boolean[] dp = new boolean[n];
        boolean[] visited = new boolean[n];
        boolean hasZero = false;
        for (int num : arr) {
            if (num == 0) {
                hasZero = true;
                break;
            }
        }
        if (!hasZero)
            return false;
        return dfs(arr, start, dp, visited);
    }

    private boolean dfs(int[] arr, int start, boolean[] dp, boolean[] visited) {
        if (start < 0 || start >= arr.length)
            return false;

        if (visited[start])
            return dp[start];

        if (arr[start] == 0) {
            visited[start] = true;
            dp[start] = true;
            return dp[start];
        }

        visited[start] = true;
        if (start - arr[start] >= 0 && !visited[start - arr[start]]) {
            dp[start] = dp[start] || dfs(arr, start - arr[start], dp, visited);
        }
        if (start + arr[start] < arr.length && !visited[start + arr[start]]) {
            dp[start] = dp[start] || dfs(arr, start + arr[start], dp, visited);
        }
        // System.out.println("start: " + start + " ,Res is: " + dp[start]);
        return dp[start];
    }
}

class Solution {
    public static boolean canReach(int[] arr, int start) {
        int n = arr.length;
        HashSet<Integer> visited = new HashSet<>(); // visited set
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()) {
            int i = q.poll();
            if (arr[i] == 0) return true; // found then return it
            if (visited.contains(i)) continue; // already visited than continue
            visited.add(i);
            if (i + arr[i] < n)
                q.add(i + arr[i]);
            if (i - arr[i] >= 0)
                q.add(i - arr[i]);
        }
        return false;// not found
    }
}