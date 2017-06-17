package com.siliconincorporated.velox.util;

import java.awt.Font;
import java.util.ArrayList;

public class Util {
	public static final Font TITLE_SCREEN_BUTTON_TEXT = new Font("Constantia", Font.PLAIN, 30);
	public static final Font QUESTION_AREA_TEXT = new Font("Constantia", Font.PLAIN, 20);
	public static final Font QUESTION_ANSWER_TEXT = new Font("Constantia", Font.PLAIN, 16);
	public static final Font HIGHSCORE_TITLE_TEXT = new Font("Constantia", Font.PLAIN, 18);
	public static final Font HIGHSCORE_BUTTON_TEXT = new Font("Constantia", Font.PLAIN, 16);
	public static final Font HIGHSCORE_LIST_TEXT = new Font("Constantia", Font.PLAIN, 40);

	
	public static <E> ArrayList<E> randomize(ArrayList<E> list){
		ArrayList<E> randomized = new ArrayList<>();
		while(!list.isEmpty()){
			int takeIndex = randomNumber(0, list.size());
			randomized.add(list.remove(takeIndex));
		}
		return randomized;
	}
	
	public static int randomNumber(int min, int max){
		return (int) (min + Math.random() * (max-min));
	}
}
