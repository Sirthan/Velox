package com.siliconincorporated.velox.swing.veloxcomponents;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.siliconincorporated.velox.swing.veloxframe.VeloxFrame;
import com.siliconincorporated.velox.util.Util;

public class TitleScreenComponent extends JComponent{

	private JLabel titleText;
	private JLabel subtitleText;
	
	private JButton start;
	private JButton highscores;
	private JButton exit;
	
	private VeloxFrame handler;
	
	public TitleScreenComponent(VeloxFrame parent){
		
		titleText = new JLabel("Velox");
		titleText.setHorizontalAlignment(SwingConstants.CENTER);
		titleText.setFont(new Font("Matura MT Script Capitals", Font.PLAIN, 100));
		titleText.setBounds(0, 0, 600, 100);
		add(titleText);
		
		subtitleText = new JLabel("Time Trial!");
		subtitleText.setFont(new Font("Matura MT Script Capitals", Font.PLAIN, 40));
		subtitleText.setBounds(300, 60, 300, 100);
		add(subtitleText);
		
		start = new JButton("Start!");
		start.setBounds(200, 200, 200, 100);
		start.setFocusable(false);
		start.setFont(Util.TITLE_SCREEN_BUTTON_TEXT);
		start.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				handler.setContentPane(new QuestionComponent(handler));
				handler.revalidate();
			}
			
		});
		add(start);
		
		highscores = new JButton("Highscores!");
		highscores.setBounds(200, 350, 200, 100);
		highscores.setFocusable(false);
		highscores.setFont(Util.TITLE_SCREEN_BUTTON_TEXT);
		highscores.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				handler.setContentPane(new HighscoreComponent(handler));
				handler.revalidate();
			}
			
		});
		add(highscores);
		
		exit = new JButton("Exit!");
		exit.setBounds(200, 500, 200, 100);
		exit.setFocusable(false);
		exit.setFont(Util.TITLE_SCREEN_BUTTON_TEXT);
		exit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				handler.dispose();
				System.exit(0);
			}
			
		});
		add(exit);
		
		handler = parent;
	}
	
}
