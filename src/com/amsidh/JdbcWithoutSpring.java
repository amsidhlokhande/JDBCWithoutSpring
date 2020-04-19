/**
 * 
 */
package com.amsidh;

import com.amsidh.mvc.dtos.Vechile;
import com.amsidh.mvc.dtos.VechileDaoImpl;



/**
 * @author amsidhlokhande
 *
 */
public class JdbcWithoutSpring {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	Vechile vechile=new VechileDaoImpl().getVechileByVechileId(1);
	System.out.println(vechile.getVechileType());

	}

}
