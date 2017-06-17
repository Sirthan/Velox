package com.siliconincorporated.velox.swing.veloxcomponents;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

import com.siliconincorporated.velox.highscore.HighscoreRecord;
import com.siliconincorporated.velox.highscore.Score;
import com.siliconincorporated.velox.swing.veloxframe.VeloxFrame;
import com.siliconincorporated.velox.util.Util;

public class HighscoreComponent extends JComponent{
	
	private JList<Score> highscoreList;
	
	private JButton done;
	
	private JLabel scoreTitle;
	
	private VeloxFrame handler;
	
	private HighscoreRecord highscoreRecords;
	
	public HighscoreComponent(VeloxFrame parent){	
		highscoreRecords = HighscoreRecord.load();	
		highscoreList = new JList<>(highscoreRecords.getScores());
		highscoreList.setBounds(20, 60, 560, 600);
		highscoreList.setFocusable(false);
		highscoreList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		highscoreList.setLayoutOrientation(JList.VERTICAL);
		highscoreList.setVisibleRowCount(10);
		highscoreList.setFont(Util.HIGHSCORE_LIST_TEXT);
		add(highscoreList);
		
		scoreTitle = new JLabel("Highscores!");
		scoreTitle.setFont(Util.HIGHSCORE_TITLE_TEXT);
		scoreTitle.setBounds(250, 20, 100, 20);
		add(scoreTitle);
		
		done = new JButton();
		done.setText("done");
		done.setBounds(250, 700, 100, 50);
		done.setFont(Util.HIGHSCORE_BUTTON_TEXT);
		done.setFocusable(false);
		done.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				handler.setContentPane(new TitleScreenComponent(handler));
				handler.revalidate();
			}
			
		});
		add(done);
		
		handler = parent;
	}
}
