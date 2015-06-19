package com.github.slowrookie.constant;

/**
 * 权限类型枚举（使用枚举代替硬编码的常量） 
 * 
 * @author 刘佳兴
 */
public enum RoleType {
	
	MENU(0, "菜单"),
	
	PAGEELEMENT(1, "页面元素")
	
	;
	
	private final int value;
	
	private final String text;
	
	private RoleType(int value, String text){
		this.value = value;
		this.text = text;
	}
	
	public int value() {
		return this.value;
	}
	
	public String text() {
		return this.text;
	}

	@Override
	public String toString() {
		return Integer.toString(this.value);
	}
	
}
