package com.siliconincorporated.velox.swing.veloxframe;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.siliconincorporated.velox.swing.veloxcomponents.HighscoreComponent;
import com.siliconincorporated.velox.swing.veloxcomponents.QuestionComponent;
import com.siliconincorporated.velox.swing.veloxcomponents.TitleScreenComponent;

public class VeloxFrame extends JFrame{

	public VeloxFrame(){
		this.setTitle("Velox -- Time Trial");
		
		this.setSize(600, 800);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		
		this.setContentPane(new TitleScreenComponent(this));
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}
	
	
}
