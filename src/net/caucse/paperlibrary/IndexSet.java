package net.caucse.paperlibrary;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class IndexSet<T> implements Set<T> {
	private HashMap<T, Integer> typeKey;
	private HashMap<Integer, T> indexKey;
	
	private int index = 0;
	
	public IndexSet() {
		typeKey = new HashMap<T, Integer>();
		indexKey = new HashMap<Integer, T>();
	}
	
	public Integer getIndex(T obj) {
		return typeKey.get(obj);
	}
	
	public T getAsIndex(int index) {
		return indexKey.get(index);
	}
	
	@Override
	public boolean add(T obj) {
		if (typeKey.containsKey(obj))
			return false;
		typeKey.put(obj, index);
		indexKey.put(index++, obj);
		return true;
	}
	
	public int addReturnIndex(T obj) {
		if (add(obj))
			return index-1;
		if (typeKey.containsKey(obj))
			return typeKey.get(obj);
		return -1;
	}
	
	@Override
	public boolean addAll(Collection<? extends T> c) {
		boolean changed = false;
		for (T obj : c) {
			changed |= add(obj);
		}
		return changed;
	}
	
	@Override
	public void clear() {
		typeKey.clear();
		indexKey.clear();
		index = 0;
	}

	@Override
	public boolean contains(Object o) {
		return typeKey.containsKey(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		for (Object o : c) {
			if (!typeKey.containsKey(o))
				return false;
		}
		return true;
	}

	@Override
	public boolean isEmpty() {
		return typeKey.isEmpty();
	}

	@Override
	public Iterator<T> iterator() {
		return typeKey.keySet().iterator();
	}
	
	@Override
	public boolean remove(Object obj) {
		try {
			int idx = typeKey.remove(obj);
			indexKey.remove(idx);
			return true;
		} catch (NullPointerException e) {
			return false;
		}
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		boolean changed = false;
		for (Object obj : c) {
			changed |= remove(obj);
		}
		return changed;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		HashSet<T> removeSet = new HashSet<T>();
		for (T obj : typeKey.keySet()) {
			if (!c.contains(obj)) {
				removeSet.add(obj);
			}
		}
		return removeAll(removeSet);
	}

	@Override
	public int size() {
		return typeKey.size();
	}

	@Override
	public Object[] toArray() {
		return typeKey.keySet().toArray();
	}

	@SuppressWarnings("hiding")
	@Override
	public <T> T[] toArray(T[] a) {
		return typeKey.keySet().toArray(a);
	}
}
