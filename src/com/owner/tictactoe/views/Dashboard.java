package com.owner.tictactoe.views;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.border.LineBorder;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Cursor;

public class Dashboard {

	private JFrame frame;
	private JTextField textField1;
	private JTextField textField2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
			new Dashboard();
	}

	/**
	 * Create the application.
	 */
	public Dashboard() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	public static boolean lengthCheckValidateFullName(String input) {
		return input.length() >= 1;
	}
	
	public void gameStart() {
		String player1 = textField1.getText();
		String player2 = textField2.getText();
		if(!lengthCheckValidateFullName(textField1.getText())) {
			JOptionPane.showMessageDialog(frame, "Invalid Input! Player X must have atleast 1 characters.");
		}
		else if(!lengthCheckValidateFullName(textField2.getText())) {
			JOptionPane.showMessageDialog(frame, "Invalid Input! Player O must have atleast 1 characters.");
		}
		else {
			frame.setVisible(false);
			frame.dispose();
			new UserView(player1, player2);
		}
		
	}
	private void initialize() {
		frame = new JFrame("TicTacToe-Game");
		frame.setBounds(100, 100, 770, 320);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Dashboard.class.getResource("/assets/img.png")));
		lblNewLabel.setBounds(0, 0, 492, 294);
		frame.getContentPane().add(lblNewLabel);
		
		textField1 = new JTextField();
		textField1.setHorizontalAlignment(SwingConstants.CENTER);
		textField1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		textField1.setBorder(new LineBorder(new Color(0, 0, 0)));
		textField1.setBounds(526, 68, 213, 32);
		frame.getContentPane().add(textField1);
		textField1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Player X Name : ");
		lblNewLabel_1.setFont(new Font("Trattatello", Font.PLAIN, 23));
		lblNewLabel_1.setBounds(526, 32, 182, 35);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Player O Name : ");
		lblNewLabel_2.setFont(new Font("Trattatello", Font.PLAIN, 23));
		lblNewLabel_2.setBounds(526, 127, 184, 35);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField2 = new JTextField();
		textField2.setHorizontalAlignment(SwingConstants.CENTER);
		textField2.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		textField2.setBorder(new LineBorder(new Color(0, 0, 0)));
		textField2.setColumns(10);
		textField2.setBounds(526, 163, 213, 32);
		frame.getContentPane().add(textField2);
		
		JButton btnNewButton = new JButton("Start Game");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				gameStart();
			}
		});
		btnNewButton.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		btnNewButton.setBounds(557, 236, 141, 35);
		frame.getContentPane().add(btnNewButton);
		
		frame.setVisible(true);
	}
}
