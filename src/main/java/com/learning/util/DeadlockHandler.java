package com.learning.util;

import java.lang.management.ThreadInfo;
import java.util.List;

public interface DeadlockHandler {
	List<String> handleDeadlock(final ThreadInfo[] deadlockedThreads);
}
