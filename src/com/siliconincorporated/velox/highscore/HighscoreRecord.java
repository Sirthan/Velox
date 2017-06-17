package com.siliconincorporated.velox.highscore;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class HighscoreRecord implements Serializable{
	
	private static final long serialVersionUID = 8737242650733697806L;
	private ArrayList<Score> scores;
	
	public HighscoreRecord(Score... scores){
		this.scores = new ArrayList<>(Arrays.asList(scores));
	}
	
	public void addScore(Score score){
		this.scores.add(score);
		Collections.sort(scores);
		clip();
	}
	
	private void clip(){
		while(scores.size() > 10){
			scores.remove(scores.size() - 1);
		}
	}
	
	public boolean isHighscore(int score){
		return scores.size() < 10 || scores.get(scores.size() - 1).getScore() < score;
	}
	
	public void save(){
		try {
	         FileOutputStream fileOut =
	         new FileOutputStream("res/highscores.Velox");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(this);
	         out.close();
	         fileOut.close();
	         System.out.printf("Serialized data is saved in res/highscores.Velox");
	      }catch(IOException i) {
	         i.printStackTrace();
	      }
	}
	
	public static HighscoreRecord load(){
		HighscoreRecord ret = new HighscoreRecord();
		try {
	         FileInputStream fileIn = new FileInputStream("res/highscores.Velox");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         ret = (HighscoreRecord) in.readObject();
	         in.close();
	         fileIn.close();
	      }catch(IOException i) {
	      }catch(ClassNotFoundException c) {
	         System.out.println("No save data found");
	      }
		return ret;
	}
	
	public Score[] getScores(){
		Score[] scoreArr = new Score[scores.size()];
		for(int i = 0; i < scoreArr.length; i++){
			scoreArr[i] = scores.get(i);
		}
		return scoreArr;
	}
}
