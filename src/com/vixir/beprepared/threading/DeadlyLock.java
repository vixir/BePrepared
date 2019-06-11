package com.vixir.beprepared.threading;

import java.util.*;

public class DeadlyLock {

    public static void main(String[] args) {
        int A[] = {1, 3, 4, 5, 1, 1, 1, 5};
        HashMap<Integer, Integer> countMap = new HashMap<>();
        int n = A.length;
        int sol = 0;
        for (int i = 0; i < n; i++) {
            Integer integer = countMap.getOrDefault(A[i], 0);
            integer++;
            if (integer > sol) {
                sol = integer;
            }
        }
        System.out.println(sol);
    }

}

class Friend {

    Friend friend = null;
    String name;

    public Friend(String name) {
        this.name = name;
    }

    public void setFriend(Friend friend) {
        this.friend = friend;
    }

    public synchronized void bow() {
        System.out.println(this.name + " bows " + friend.name);

        friend.bowBack();
    }

    public synchronized void bowBack() {
        System.out.println(friend.name + " bows back " + this.name);
    }

}