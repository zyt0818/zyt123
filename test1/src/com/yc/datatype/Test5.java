package com.yc.datatype;

import java.util.BitSet;

/**
 * 一个网站要计算活跃用户（即过去的一周每天都登录的用户）
 * 
 * @author 张娅婷
 *
 */
public class Test5 {
	public static void main(String[] args) {
		// 周一
		BitSet monbs = new BitSet();
		monbs.set(0, true);
		monbs.set(1, true);
		monbs.set(2, true);
		monbs.set(3, true);
		// 周er
		BitSet  tue= new BitSet();
		tue.set(0, true);
		tue.set(1, true);
		tue.set(2, true);
		tue.set(3, true);
		tue.and(tue);
		System.out.println(monbs);
	}

}
