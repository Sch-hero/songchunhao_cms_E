package com.songchunhao.comon;

/**
 * 
 * @宋春浩
 *
 * 2019年10月28日
 */
public class CmsAssertJson {
	
	/**
	 *  断言处理
	 * @param expression
	 * @param msg
	 */
	public static void Assert(boolean expression,String msg) {
		if(!expression)
			throw new CmsExceptionView(msg);
	}
	

}
