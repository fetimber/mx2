package net.huimin.common.helper;

import java.util.Comparator;
import java.util.Hashtable;

public class NameComparator implements Comparator<Hashtable<String, Object>> {
	public int compare(Hashtable<String, Object> a, Hashtable<String, Object> b) {
		String is_dir = "is_dir";
		String filetype = "filetype";
		if (((Boolean) a.get(is_dir)) && !((Boolean) b.get(is_dir))) {
			return -1;
		} else if (!((Boolean) a.get(is_dir)) && ((Boolean) b.get(is_dir))) {
			return 1;
		} else {
			return ((String) a.get(filetype)).compareTo((String) b
					.get(filetype));
		}
	}
}