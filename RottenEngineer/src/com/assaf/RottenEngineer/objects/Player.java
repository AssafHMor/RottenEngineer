package com.assaf.RottenEngineer.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.assaf.RottenEngineer.framework.GameObject;
import com.assaf.RottenEngineer.framework.ObjectId;
import com.assaf.RottenEngineer.window.ObjectHandler;

public class Player extends GameObject{

	private float width = 36, height = 96;
	private float gravity = 0.2f;
	private final float MAX_SPEED = 10;
	private ObjectHandler obbjectHandler;

	public Player(float x, float y, ObjectId id,ObjectHandler handler) {
		super(x, y, id);
		this.obbjectHandler = handler;
	}

	public void tick(LinkedList<GameObject> object) {
		x += velocityX;
		y += velocityY;
		if (jumping || falling){
			velocityY += gravity;
			if (velocityY>MAX_SPEED)
				velocityY = MAX_SPEED;
		}
		collision(object);
		
	}
	private void collision (LinkedList<GameObject> object){
		for (int i=0;i< obbjectHandler.object.size();i++){
			GameObject tempObject = obbjectHandler.object.get(i);
			if(tempObject.getId() == ObjectId.Test){
				if(getBounds().intersects(tempObject.getBounds())){
					y = tempObject.getY()-height;
					velocityY = 0;
					jumping = false;
					falling = false;
				}
				else
					falling = true;
			}		
		}
	}
	

	public void render(Graphics graphic) {
		graphic.setColor(Color.red);
		graphic.fillRect((int)x, (int)y, (int)width, (int)height);
		Graphics2D graphics2d = (Graphics2D) graphic;
		graphic.setColor(Color.white);
		graphics2d.draw(getBoundsRight());
		graphics2d.draw(getBoundsLeft());
		graphics2d.draw(getBoundsTop());
		graphics2d.draw(getBounds());
	}

	public Rectangle getBoundsRight() {
		return new Rectangle((int) ((int)x+width-2),(int)y+3,(int)2,(int)height-6);
	}
	public Rectangle getBoundsLeft() {
		return new Rectangle((int)x,(int)y+3,(int)2,(int)height-6);
	}
	public Rectangle getBoundsTop() {
		return new Rectangle((int) ((int)x+(width/2)-((width/2)/2)),(int)y,(int)width/2,(int)height/2);
	}
	public Rectangle getBounds() {
		return new Rectangle((int) ((int)x+(width/2)-((width/2)/2)),(int)((int)y+(height/2)),(int)width/2,(int)height/2);
	}


}