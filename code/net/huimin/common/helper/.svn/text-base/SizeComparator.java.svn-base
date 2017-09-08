package net.huimin.common.helper;

import java.util.Comparator;
import java.util.Hashtable;

public class SizeComparator implements Comparator<Hashtable<String, Object>> {
	public int compare(Hashtable<String, Object> a, Hashtable<String, Object> b) {
		String is_dir = "is_dir";
		String filesize = "filesize";
		if (((Boolean) a.get(is_dir)) && !((Boolean) b.get(is_dir))) {
			return -1;
		} else if (!((Boolean) a.get(is_dir)) && ((Boolean) b.get(is_dir))) {
			return 1;
		} else {
			if (((Long) a.get(filesize)) > ((Long) b.get(filesize))) {
				return 1;
			} else if (((Long) a.get(filesize)) < ((Long) b.get(filesize))) {
				return -1;
			} else {
				return 0;
			}
		}
	}
}