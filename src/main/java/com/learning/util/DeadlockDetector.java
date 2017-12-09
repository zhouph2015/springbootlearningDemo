package com.learning.util;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author Peter Zhou
 *
 */
public class DeadlockDetector {
	private final DeadlockHandler deadlockHandler;
	private final long period;
	private final TimeUnit unit;
	private final ThreadMXBean mbean = ManagementFactory.getThreadMXBean();
	private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

	private List<String> monitoringInfo = new ArrayList<String>();

	final Runnable deadlockCheck = new Runnable() {
		@Override
		public void run() {
			long[] deadlockedThreadIds = DeadlockDetector.this.mbean.findDeadlockedThreads();

			if (deadlockedThreadIds != null) {
				ThreadInfo[] threadInfos = DeadlockDetector.this.mbean.getThreadInfo(deadlockedThreadIds);

				monitoringInfo = DeadlockDetector.this.deadlockHandler.handleDeadlock(threadInfos);
			}
		}
	};

	public DeadlockDetector(final DeadlockHandler deadlockHandler, final long period, final TimeUnit unit) {
		this.deadlockHandler = deadlockHandler;
		this.period = period;
		this.unit = unit;
	}

	public void start() {
		this.scheduler.scheduleAtFixedRate(this.deadlockCheck, this.period, this.period, this.unit);
	}

	public List<String> monitoringDeadlock() {
		return monitoringInfo;
	}
}
