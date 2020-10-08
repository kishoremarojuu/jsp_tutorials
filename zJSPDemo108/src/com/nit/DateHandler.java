package com.nit;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;


public class DateHandler extends TagSupport{
	public int doStartTag() throws JspException{
		Date today = new Date();
		DateFormat dft = DateFormat.getDateInstance(DateFormat.LONG);
		String Date = dft.format(today);
		try{
			JspWriter out=pageContext.getOut();
			out.println(Date);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return SKIP_BODY;
		
	}

	
}
