package com.nit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import com.nit.bean.AdminDTO;
import com.nit.bean.Student;
import com.nit.util.DriverConnection;

public class StudentDao {
	Connection con = null;
	ResultSet rs = null;
	public boolean isValidUser(AdminDTO admin){
		boolean flag = false;
		try{
			con = DriverConnection.getConn();
			PreparedStatement pst = con.prepareStatement("select username,password from admin where username=? and password=?");
			pst.setString(1,admin.getUsername());
			pst.setString(2,admin.getPassword());
			
			rs= pst.executeQuery();
			while(rs.next()){
				flag=true;
			}
			return flag;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return flag;
	}
	public Collection getStudentData(){
		try{
			con = DriverConnection.getConn();
			Statement stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from student");
			ArrayList al = new ArrayList();
			while(rs.next()){
				Student sobj = new Student();
				sobj.setSno(rs.getInt(1));
				sobj.setName(rs.getString(2));
				sobj.setMarks(rs.getInt(3));
				
			}
			return al;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

}
