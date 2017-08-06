package controller;

import java.awt.Color;

public class ColorAdapter {
	private String colorName;
	private Color color;
	
	
	public ColorAdapter(String colorName, Color color){
		this.colorName = colorName; 
		this.color = color;
	}
	
	public Color getColor(){
		return color;
	}
	
	public void setColor(Color color){
		this.color = color;
	}
	
	public String getName(){
		return colorName;
	}
	
	public void setName(String colorName){
		this.colorName = colorName;
	}
	
	public String toString(){
		return colorName;
	}
	
	
}
//created 7/26
/*This Implements an AdapterPattern 
 * we can now assign a String name, and also
 * allow for functionality to be added later
 */