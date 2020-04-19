/**
 * 
 */
package com.amsidh.mvc.dtos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author amsidhlokhande
 *
 */
public class VechileDaoImpl {

	public Vechile getVechileByVechileId(Integer vechileId)
	{
		
		Vechile vechile=null;
		Connection con=null;
		try
		{
			Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
			con=DriverManager.getConnection("jdbc:derby://localhost:1527/db;create=true");
			
			PreparedStatement pst=con.prepareStatement("SELECT * FROM VECHILE WHERE VECHILEID=?");
			pst.setInt(1, vechileId);
			ResultSet rst=pst.executeQuery();
			while(rst.next())
			{
				vechile=new Vechile(vechileId,rst.getString("VECHILETYPE"));
			}

			rst.close();
			pst.close();
			
		}catch(Exception ex)
		{
			throw new RuntimeException();
		}finally
		{
			try
			{
				con.close();
			}catch(SQLException sqlex)
			{
				
			}
		}
		
		return vechile;
	}
}
