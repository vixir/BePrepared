package com.vixir.beprepared.threading;

public class DeadlyLock {

	public static void main(String[] args) throws InterruptedException {
		Friend one = new Friend("one");
		Friend two = new Friend("two");
		one.setFriend(two);
		two.setFriend(one);
		Thread t1 = new Thread(() -> one.bow());
		Thread t2 = new Thread(() -> two.bow());
		t1.start();
		t2.start();
		t1.join();
		t2.join();
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