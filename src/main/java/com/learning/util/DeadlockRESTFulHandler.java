package com.learning.util;

import java.lang.management.ThreadInfo;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Peter Zhou
 *
 */

public class DeadlockRESTFulHandler implements DeadlockHandler {

	@Override
	public List<String> handleDeadlock(final ThreadInfo[] deadlockedThreads) {
		List<String> results = new ArrayList<String>();
		if (deadlockedThreads != null) {
			StringBuilder info = new StringBuilder();
			info.append("Sorry, Deadlock detected!");

			for (ThreadInfo threadInfo : deadlockedThreads) {

				if (threadInfo != null) {

					for (Thread thread : Thread.getAllStackTraces().keySet()) {

						if (thread.getId() == threadInfo.getThreadId()) {
							info.append(threadInfo.toString().trim());
							for (StackTraceElement ste : thread.getStackTrace()) {
								info.append(ste.toString().trim());
							}
						}
					}
				}
			}
			results.add(info.toString());
		} else {
			results.add("Great! NO deadlock detected!");
		}
		return results;
	}
}
