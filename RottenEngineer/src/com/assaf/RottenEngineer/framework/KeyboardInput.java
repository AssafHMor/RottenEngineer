package com.assaf.RottenEngineer.framework;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.assaf.RottenEngineer.window.ObjectHandler;

public class KeyboardInput extends KeyAdapter{
	
	ObjectHandler objectHandler;
	
	public KeyboardInput(ObjectHandler handler) {
		this.objectHandler = handler;
	}

	public void keyPressed (KeyEvent e){
		int key = e.getKeyCode();
		
		for  (int i = 0; i<objectHandler.object.size();i++){
			GameObject tempObject = objectHandler.object.get(i);
			if (tempObject.getId() == ObjectId.Player){
				if(key == KeyEvent.VK_RIGHT) tempObject.setVelocityX(5);
				if(key == KeyEvent.VK_LEFT) tempObject.setVelocityX(-5);
				if(key == KeyEvent.VK_SPACE && !tempObject.isJumping()){
					
					tempObject.setY(-10);
				}
			}
		}
		if (key == KeyEvent.VK_ESCAPE){
			System.exit(1);
		}
		
	}
	public void keyReleased (KeyEvent e){
		int key = e.getKeyCode();
		
		for  (int i = 0; i<objectHandler.object.size();i++){
			GameObject tempObject = objectHandler.object.get(i);
			if (tempObject.getId() == ObjectId.Player){
				if(key == KeyEvent.VK_RIGHT) tempObject.setVelocityX(0);
				if(key == KeyEvent.VK_LEFT) tempObject.setVelocityX(0);	
			}
		}
	}
}
