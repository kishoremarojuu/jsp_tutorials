package com.tvnit;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;


public class GreetingHandler extends TagSupport {
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public int doStartTag() throws JspException{
		try{
			JspWriter out= pageContext.getOut();
			out.println("hai"+name+"you are"+age+"years old");
			
		}catch(Exception e){
			e.printStackTrace();
		}

		return SKIP_BODY;

		
	}
}
