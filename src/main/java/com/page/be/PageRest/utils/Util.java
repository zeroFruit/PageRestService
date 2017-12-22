package com.page.be.PageRest.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Util {
	public static <T> List<T> union(List<T> l1, List<T> l2) {
		Set<T> set = new HashSet<T>();
        set.addAll(l1);
        set.addAll(l2);
        return new ArrayList<T>(set);
	}
}
