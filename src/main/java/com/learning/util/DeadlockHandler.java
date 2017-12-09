package com.learning.util;

import java.lang.management.ThreadInfo;
import java.util.List;

/**
 * @author Peter Zhou
 *
 */
public interface DeadlockHandler {
	List<String> handleDeadlock(final ThreadInfo[] deadlockedThreads);
}
