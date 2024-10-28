package br.com.arq.respository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class Dao {
 
    @Autowired
    private DataSource dataSource;
    
	 Connection con;
	 ResultSet rs;
	 PreparedStatement stmt;
	 
	 public void open() {
		 if (con==null) {
		 try {
			   this.con = dataSource.getConnection();

		 }
		 catch(Exception ex) {
			 ex.printStackTrace();
		 }
	 }
	}
	 
	 public void close() {
		 try {
			  con.close();
		 }
		 catch(Exception ex) {
			 ex.printStackTrace();
		 }
	}
	 
}
