package com.siliconincorporated.velox.questions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import com.siliconincorporated.velox.util.Util;

public class QuestionLoader {
	private static ArrayList<Question> question = new ArrayList<>();
	
	public static void reload(){
		System.out.println("Reloading");
		Scanner sc = null;
		try {
			sc = new Scanner(new File("res/Questions.Velox"));
		} catch (FileNotFoundException e) {
			System.err.println("FILE NOT FOUND EXCCPTION");
		}
		
		while(sc.hasNextLine()){
			String[] questionPieces = sc.nextLine().split("[|]");
			question.add(new Question(questionPieces[0],
					      new AnswerChoice(questionPieces[1], true),
					      new AnswerChoice(questionPieces[2], false),
					      new AnswerChoice(questionPieces[3], false),
					      new AnswerChoice(questionPieces[4], false)));
		}
		question = Util.randomize(question);
	}
	
	public static Question getQuestion(){
		if(question.isEmpty()) reload();
		return question.remove(0);
	}
	
}
