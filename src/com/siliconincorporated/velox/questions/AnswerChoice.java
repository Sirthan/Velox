package com.siliconincorporated.velox.questions;

public class AnswerChoice {
	private String answerText;
	private boolean isCorrect;
	
	public AnswerChoice(String answerText, boolean isCorrect){
		this.answerText = answerText;
		this.isCorrect = isCorrect;
	}
	
	public boolean isCorrect(){
		return isCorrect;
	}
	
	public String getText(){
		return answerText;
	}
}
