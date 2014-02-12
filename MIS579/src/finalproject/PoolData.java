/* Copyright 2014 Caterpillar Inc. All rights reserved. 
 * The work contains Caterpillar’s proprietary information, 
 * which may constitute a trade secret and/or be confidential. 
 * Copyright notice is precautionary only and does not imply publication.
 * 
 *  
 * Create By : wolffml
 * Create On : Feb 10, 2014
 */
package finalproject;

import java.util.HashMap;

public class PoolData {

	public static HashMap<String, PoolData> poolMap; // = new HashMap<String, PoolData>();
	static {
		poolMap = new HashMap<String, PoolData>();
		PoolData pd = new PoolData(20,10,5);
		poolMap.put("Rectangle", pd);
		pd = new PoolData(15,15,5);
		poolMap.put("Square", pd);
	}
	
	private int length;
	private int width;
	private int depth;
	
	public PoolData(int length, int width, int depth) {
		super();
		this.length = length;
		this.width = width;
		this.depth = depth;
	}
	
	public PoolData(){
		super();
	}
	
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
}

