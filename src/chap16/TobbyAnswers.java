package chap16;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; // what is this class responsible for? remembering a context
// is it important to learn these event classes


import javax.swing.*;

public class TobbyAnswers extends JFrame {
	
	private JButton takeAnswer, giveResponse, begin;
	private JTextField answer, response;
	private String hidden = "";
	private JPanel openPanel;

	public TobbyAnswers()
	{
		takeAnswer = new JButton ("Record Answer");
		giveResponse = new JButton ("Get response");
		begin = new JButton ("Begin");
		answer = new JTextField ("Answer");
		response = new JTextField ("Response");
		
		
		
		
		openPanel = new JPanel ();
		JLabel answerInfo = new JLabel ("Enter your answer");
		openPanel.add(answerInfo);
		openPanel.add(takeAnswer);
		openPanel.add(answer);
		openPanel.add(begin);
		
		JPanel panel = new JPanel ();
		panel.add(new JLabel ("What is your question"));
		panel.add(giveResponse);
		panel.add(response);
		
		takeAnswer.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						hidden = answer.getText();
					}
		
				});
		
		giveResponse.addActionListener(new ActionListener()
		
			{
				public void actionPerformed(ActionEvent e)
				{
					response.setText(hidden);
				}
			});
		
		begin.addActionListener(new BeginListener (this, openPanel));

			
		
		
		this.add(openPanel, BorderLayout.SOUTH);
		this.add(panel);
	}
	

	
	public static void main (String[]args)
	{
		TobbyAnswers frame = new TobbyAnswers ();
		frame.pack();
		frame.setVisible(true);
		frame.setTitle("doneDemo");
		frame.setLocationRelativeTo(null); // Center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void removeFrame(JPanel panel)
	{
		this.remove(panel);
	}
	
}

class BeginListener implements ActionListener
{
	JFrame frame;
	JPanel panel;
	public BeginListener(JFrame frame, JPanel panel)
	{
		this.frame = frame;
		this.panel = panel;
	}
	public void actionPerformed(ActionEvent e)
	{
		frame.remove(panel);
		panel.setVisible(false);
	}
}
