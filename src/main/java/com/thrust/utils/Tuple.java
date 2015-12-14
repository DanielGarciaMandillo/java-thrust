package com.thrust.utils;

/**
 * Created by Admin on 7/12/15.
 */
public class Tuple<A, B> {
	public final A _1;
	public final B _2;
	
	private Tuple(A a, B b) {
		_1 = a;
		_2 = b;
	}
	
	public static <A, B> Tuple<A, B> of(A a, B b) {
		return new Tuple<>(a, b);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((_1 == null) ? 0 : _1.hashCode());
		result = prime * result + ((_2 == null) ? 0 : _2.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tuple other = (Tuple) obj;
		if (_1 == null) {
			if (other._1 != null)
				return false;
		} else if (!_1.equals(other._1))
			return false;
		if (_2 == null) {
			if (other._2 != null)
				return false;
		} else if (!_2.equals(other._2))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Tuple{" +
				"_1=" + _1 +
				", _2=" + _2 +
				'}';
	}
}
