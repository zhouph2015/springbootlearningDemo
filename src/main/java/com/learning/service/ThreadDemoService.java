package com.learning.service;

import java.util.List;
import java.util.concurrent.TimeUnit;
import com.learning.util.DeadlockRESTFulHandler;
import com.learning.util.DeadlockDetector;

/**
 * @author Peter Zhou
 *
 */
public class ThreadDemoService {

	public static Object money = new Object();
	public static Object car = new Object();

	public List<String> monitoringDeadLock(int time) throws InterruptedException {
		DeadlockDetector deadlockDetector = new DeadlockDetector(new DeadlockRESTFulHandler(), 5, TimeUnit.SECONDS);
		deadlockDetector.start();

		sale(10000);
		List<String> response = deadlockDetector.monitoringDeadlock();

		return response;

	}

	public static void sale(long millsecond) throws InterruptedException {

		buyer buyer1 = new buyer(money, car);
		Thread t1 = new Thread(buyer1);
		t1.start();

		seller buyer2 = new seller(money, car);
		Thread t2 = new Thread(buyer2);
		t2.start();

		Thread.sleep(millsecond);

	}

}

class buyer implements Runnable {

	public buyer(Object money, Object car) {
		super();
		this.money = money;
		this.car = car;
	}

	public Object money;
	public Object car;

	@Override
	public void run() {
		sale();
	}

	public void sale() {
		synchronized (money) {
			System.out.println("I have money to buy car, give me car first");
			try {

				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (car) {
				System.out.println("I will not pay money without received car first");
			}
		}
		System.out.println("I received car, and payed money");
	}
}

class seller implements Runnable {

	public seller(Object money, Object car) {
		super();
		this.money = money;
		this.car = car;
	}

	public Object money;
	public Object car;

	@Override
	public void run() {
		sale();
	}

	public void sale() {
		synchronized (car) {
			try {
				System.out.println("I have a car to sale, pay me first");
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (money) {
			}

		}
		System.out.println("I received money, and transfered the car");
		;
	}
}
