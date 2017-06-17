package com.siliconincorporated.velox.highscore;

import java.io.Serializable;

public class Score implements Comparable<Score>, Serializable{
	
	private static final long serialVersionUID = -7397530801280049750L;
	private String name;
	private int scoreNum;
	
	public Score(String name, int score){
		if(name.length() > 3){
			name = name.substring(0, 3);
		} 
		this.name = name;
		this.scoreNum = score;
	}
	
	@Override
	public int compareTo(Score o) {
		return o.getScore() - getScore();
	}
	
	public String getName(){
		return name;
	}
	
	public int getScore(){
		return scoreNum;
	}
	
	public String toString(){
		return String.format("%-30s %-9d", name, scoreNum);
	}
}
