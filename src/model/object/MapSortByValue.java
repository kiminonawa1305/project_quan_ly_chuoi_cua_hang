package model.object;

import java.util.*;
import java.util.Map.Entry;

public class MapSortByValue {

	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
		List<Entry<K, V>> list = new ArrayList<>(map.entrySet());
		list.sort(Entry.comparingByValue(new Comparator<V>() {

			@Override
			public int compare(V o1, V o2) {
				return  - o1.compareTo(o2);
			}
		}));

		Map<K, V> result = new LinkedHashMap<>();
		for (Entry<K, V> entry : list) {
			result.put(entry.getKey(), entry.getValue());
		}

		return result;
	}
}
