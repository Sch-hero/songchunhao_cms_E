package com.sch.comon;

import java.io.Serializable;

/**
 * 
 * @宋春浩
 *
 * 2019年10月22日
 */
public class ResultMsg implements Serializable{

	/**
	 * 随机数
	 */
	private static final long serialVersionUID = 2577605941130152031L;

	int result;
	String errorMsg;
	Object data;
	
	
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	/**
	 * @param result
	 * @param errorMsg
	 * @param data
	 */
	public ResultMsg(int result, String errorMsg, Object data) {
		super();
		this.result = result;
		this.errorMsg = errorMsg;
		this.data = data;
	}
	
	
}
