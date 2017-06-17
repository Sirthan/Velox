package com.siliconincorporated.velox.questions;

import java.util.ArrayList;
import java.util.Arrays;

import com.siliconincorporated.velox.util.Util;

public class Question {
	private String question;
	private ArrayList<AnswerChoice> answerChoices;
	
	public Question(String question, AnswerChoice... choices){
		this.question = question;
		answerChoices = Util.randomize(new ArrayList<>(Arrays.asList(choices)));
	}
	
	public String getText(){
		return question;
	}
	
	public ArrayList<AnswerChoice> getAnswerChoices(){
		return answerChoices;
	}
	
	public boolean isCorrect(int index){
		return answerChoices.get(index).isCorrect();
	}
	
	public String getCorrectAnswer(){
		for(AnswerChoice ac : answerChoices){
			if(ac.isCorrect()) return ac.getText();
		}
		return null;
	}
}
