package controller;

import java.awt.Color;

public class ColorAdapter {
	private Color color;
	private String colorName;
	
	
	public ColorAdapter(Color color, String colorName){
		this.color = color;
		this.colorName = colorName; 
	}
	
	public Color getColor(){
		return color;
	}
	
	public void setColor(Color color){
		this.color = color;
	}
}
//created 7/26
/*This Implements an AdapterPattern 
 * we can now assign a String name, and also
 * allow for functionality to be added later
 */