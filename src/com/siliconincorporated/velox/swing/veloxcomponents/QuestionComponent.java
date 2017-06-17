package com.siliconincorporated.velox.swing.veloxcomponents;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.Timer;

import com.siliconincorporated.velox.highscore.HighscoreRecord;
import com.siliconincorporated.velox.highscore.Score;
import com.siliconincorporated.velox.questions.AnswerChoice;
import com.siliconincorporated.velox.questions.Question;
import com.siliconincorporated.velox.questions.QuestionLoader;
import com.siliconincorporated.velox.swing.veloxframe.VeloxFrame;
import com.siliconincorporated.velox.util.Util;

public class QuestionComponent extends JComponent{

	private JTextArea questionText;
	private JButton choiceA, choiceB, choiceC, choiceD;
	private JLabel timeText;
	private JLabel questionNumberText;
	private JLabel scoreText;
	
	private Question question;
	
	private int score = 0;
	private int time = 120;
	private int questionNumber = 1;
	
	private Timer timer;
	
	HighscoreRecord record;
	
	VeloxFrame handler;
	
	public QuestionComponent(VeloxFrame parent){
		
		QuestionLoader.reload();
		
		timeText = new JLabel("Time: " + time);
		timeText.setFont(Util.QUESTION_AREA_TEXT);
		timeText.setBounds(20, 20, 100, 20);
		add(timeText);
		
		questionNumberText = new JLabel("Question: " + questionNumber);
		questionNumberText.setFont(Util.QUESTION_AREA_TEXT);
		questionNumberText.setBounds(225, 20, 150, 20);
		add(questionNumberText);
		
		scoreText = new JLabel("Score: " + score);
		scoreText.setFont(Util.QUESTION_AREA_TEXT);
		scoreText.setBounds(450, 20, 150, 20);
		add(scoreText);
		
		questionText = new JTextArea();
		questionText.setBounds(20, 80, 560, 150);
		questionText.setLineWrap(true);
		questionText.setEditable(false);
		questionText.setFont(Util.QUESTION_AREA_TEXT);
		questionText.setBackground(getBackground());
		add(questionText);
		
		choiceA = new JButton();
		choiceA.setBounds(20, 250, 560, 100);
		choiceA.setFocusable(false);
		choiceA.setFont(Util.QUESTION_ANSWER_TEXT);
		choiceA.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(isCorrect(0)){
					questionNumber++;
					score += calculateScore();
					questionNumberText.setText("Question: " + questionNumber);
					scoreText.setText("Score: " + score);
					loadQuestion();
				} else {
					timer.stop();
					wrongAnswer();
				}
				
			}
		});
		add(choiceA);
		
		choiceB = new JButton();
		choiceB.setBounds(20, 370, 560, 100);
		choiceB.setFocusable(false);
		choiceB.setFont(Util.QUESTION_ANSWER_TEXT);
		choiceB.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(isCorrect(1)){
					questionNumber++;
					score += calculateScore();
					questionNumberText.setText("Question: " + questionNumber);
					scoreText.setText("Score: " + score);
					loadQuestion();
				} else {
					timer.stop();
					wrongAnswer();
				}
				
			}
		});
		add(choiceB);
		
		choiceC = new JButton();
		choiceC.setBounds(20, 490, 560, 100);
		choiceC.setFocusable(false);
		choiceC.setFont(Util.QUESTION_ANSWER_TEXT);
		choiceC.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(isCorrect(2)){
					questionNumber++;
					score += calculateScore();
					questionNumberText.setText("Question: " + questionNumber);
					scoreText.setText("Score: " + score);
					loadQuestion();
				} else {
					timer.stop();
					wrongAnswer();
				}
				
			}
		});
		add(choiceC);
		
		choiceD = new JButton();
		choiceD.setBounds(20, 610, 560, 100);
		choiceD.setFocusable(false);
		choiceD.setFont(Util.QUESTION_ANSWER_TEXT);
		choiceD.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(isCorrect(3)){
					questionNumber++;
					score += calculateScore();
					questionNumberText.setText("Question: " + questionNumber);
					scoreText.setText("Score: " + score);
					loadQuestion();
				} else {
					timer.stop();
					wrongAnswer();
				}
				
			}
		});
		add(choiceD);
		
		timer = new Timer(1000, new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				time--;
				timeText.setText("Time: " + time);
				if(time == 0){
					outOfTime();
				}
			}
			
		});
		timer.setInitialDelay(2000);
		timer.start(); 
		
		record = HighscoreRecord.load();
		
		handler = parent;
		
		loadQuestion();
		
	}

	private void loadQuestion() {
		question = QuestionLoader.getQuestion();
		questionText.setText(question.getText());
		ArrayList<AnswerChoice> choices = question.getAnswerChoices();
		choiceA.setText("<html><center>" + choices.get(0).getText() + "</html></center>");
		choiceB.setText("<html><center>" + choices.get(1).getText() + "</html></center>");
		choiceC.setText("<html><center>" + choices.get(2).getText() + "</html></center>");
		choiceD.setText("<html><center>" + choices.get(3).getText() + "</html></center>");
	}
	
	private int calculateScore() {
		return time * 10;
	}
	
	private boolean isCorrect(int index){
		return question.isCorrect(index);
	}
	
	private void wrongAnswer(){
		JOptionPane.showMessageDialog(handler, "Wrong answer!\nQuestion: " + question.getText() + "\nCorrect Answer: " + question.getCorrectAnswer());
		checkHighscore();
	}
	
	private void outOfTime(){
		JOptionPane.showMessageDialog(handler, "Out of time!\nQuestion: " + question.getText() + "\nCorrect Answer: " + question.getCorrectAnswer());
		checkHighscore();
	}
	
	private void checkHighscore() {
		if(record.isHighscore(score)){
			String name = JOptionPane.showInputDialog(handler, "New Highscore! Enter your initials(No more than 3 please)\nor hit cancel to not be recorded.", "NEW HIGHSCORE", JOptionPane.PLAIN_MESSAGE);
			if(name != null){
				record.addScore(new Score(name, score));
				record.save();
			}
			transfer();
		} else {
			JOptionPane.showMessageDialog(handler, "No new highscore this time!\nKeep Trying!!");
			transfer();
		}
		
	}

	private void transfer(){
		handler.setContentPane(new HighscoreComponent(handler));
		handler.revalidate();
	}
}
