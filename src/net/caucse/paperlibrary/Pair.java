package net.caucse.paperlibrary;
public class Pair<E> {
	
	private E first;
	private E second;
	
	public Pair(E a, E b) {
		set(a,b);
	}

	public E getFirst() {
		return first;
	}

	public E getSecond() {
		return second;
	}

	public void set(E a, E b) {
		first = a; second = b;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Pair) {
			@SuppressWarnings("unchecked")
			Pair<E> p = (Pair<E>)obj;
			return first.equals(p.getFirst()) && second.equals(p.getSecond());
		}
		return false;
	}
	
	public boolean equalsNoOrder(Pair<E> pair) {
		return (first.equals(pair.getSecond()) && second.equals(pair.getSecond())) || this.equals(pair);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pair [first=").append(first).append(", second=")
				.append(second).append("]");
		return builder.toString();
	}
}