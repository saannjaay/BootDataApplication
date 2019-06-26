/**
 * 
 */
package org.com.data.model;

/**
 * @author sanjsingh
 *
 */
public class Count {

	private int count;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Count(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "Count [count=" + count + "]";
	}

}
