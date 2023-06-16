package com.owner.tictactoe.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class UserView {

	private JFrame frmTictactoegame;
	private JTextField xCount;
	private JTextField oCount;
	private JFrame frame;
	private int xCount1 = 0;
	private int currCountx = 0;
	private int oCount1 = 0;
	private int currCounto = 0;
	private String startGame = "X";
	private int b[] = new int[9];
	private boolean[] clicked = new boolean[9];
	
	private int i =0;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the application.
	 */
	public UserView(String Player1, String Player2) {
		String player1 = Player1;
		String player2 = Player2;
		initialize(player1, player2);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void game(int m, JButton btn, String player1, String player2) {
		
			btn.setText(startGame);
			if(startGame.equalsIgnoreCase("X")) {
				btn.setForeground(Color.RED);
				b[m] = 1;
				System.out.println("b["+m+"] = "+b[m]);
			}
			else {
				btn.setForeground(Color.blue);
				b[m] = 2;
				System.out.println("b["+m+"] = "+b[m]);
			}
			choosePlayer();
			i++;
			winningGame(player1, player2);
	}
	
	private void checko(String player2) {
		if(currCounto == oCount1) {
			oCount1++;
			oCount.setText(String.valueOf(oCount1));
			JOptionPane.showMessageDialog(frame, player2+" Wins","Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
			Arrays.fill(clicked, true);
			currCounto = oCount1;
		}
	}
	private void checkx(String player1) {
		if(currCountx == xCount1) {
			xCount1++;
			xCount.setText(String.valueOf(xCount1));
			JOptionPane.showMessageDialog(frame, player1+" Wins","Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
			Arrays.fill(clicked, true);
			currCountx = xCount1;
		}
	}
	private void choosePlayer() {
		if(startGame.equalsIgnoreCase("X")){
			startGame = "O";
		}
		else {
			startGame = "X";
		}
	}
	
	private void winningGame(String player1, String player2) {
		
		// for Player X
		
		if (b[0] == 1 && b[1] == 1 && b[2] == 1 || b[3] == 1 && b[4] == 1 && b[5] == 1 || b[6] == 1 && b[7] == 1 && b[8] == 1 ||
                b[0] == 1 && b[3] == 1 && b[6] == 1 || b[1] == 1 && b[4] == 1 && b[7] == 1 || b[2] == 1 && b[5] == 1 && b[8] == 1 ||
                b[0] == 1 && b[4] == 1 && b[8] == 1 || b[2] == 1 && b[4] == 1 && b[6] == 1) {
			checkx(player1);
		}
		
		// for Player O
		
		if (b[0] == 2 && b[1] == 2 && b[2] == 2 || b[3] == 2 && b[4] == 2 && b[5] == 2 || b[6] == 2 && b[7] == 2 && b[8] == 2 ||
                b[0] == 2 && b[3] == 2 && b[6] == 2 || b[1] == 2 && b[4] == 2 && b[7] == 2 || b[2] == 2 && b[5] == 2 && b[8] == 2 ||
                b[0] == 2 && b[4] == 2 && b[8] == 2 || b[2] == 2 && b[4] == 2 && b[6] == 2) {
			checko(player2);
		}
			
		else if(i==9) {
			JOptionPane.showMessageDialog(frame, "Match Draw!!","Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	
	
	public void initialize(String player1, String player2) {
		frmTictactoegame = new JFrame();
		
		frmTictactoegame.setTitle("TicTacToe-Game");
		frmTictactoegame.setBounds(100, 100, 600, 400);
		frmTictactoegame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTictactoegame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		frmTictactoegame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(3, 5, 2, 2));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0),2));
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JButton btn1 = new JButton("");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!clicked[0]) {
					game(0, btn1, player1, player2);
					clicked[0] = true;
				}
				
			}
		});
		btn1.setBackground(new Color(125, 179, 255));
		btn1.setFont(new Font("Lucida Grande", Font.BOLD, 80));
		panel_1.add(btn1, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0),2));
		panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JButton btn2 = new JButton("");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!clicked[1]) {
					game(1, btn2, player1, player2);
					clicked[1] = true;
				}
				
			}
		});
		btn2.setFont(new Font("Lucida Grande", Font.BOLD, 80));
		panel_2.add(btn2, BorderLayout.CENTER);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0),2));
		panel.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JButton btn3 = new JButton("");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!clicked[2]) {
					game(2, btn3, player1, player2);
					clicked[2] = true;
				}
				
			}
		});
		btn3.setFont(new Font("Lucida Grande", Font.BOLD, 80));
		panel_3.add(btn3, BorderLayout.CENTER);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel(player1);
		lblNewLabel.setFont(new Font("Trattatello", Font.PLAIN, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel, BorderLayout.CENTER);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		xCount = new JTextField();
		xCount.setFont(new Font("Lucida Grande", Font.BOLD, 35));
		xCount.setHorizontalAlignment(SwingConstants.CENTER);
		xCount.setText("0");
		panel_5.add(xCount, BorderLayout.CENTER);
		xCount.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0),2));
		panel.add(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JButton btn4 = new JButton("");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!clicked[3]) {
					game(3, btn4, player1, player2);
					clicked[3] = true;
				}
				
			}
		});
		btn4.setFont(new Font("Lucida Grande", Font.BOLD, 80));
		panel_6.add(btn4, BorderLayout.CENTER);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new LineBorder(new Color(0, 0, 0),2));
		panel.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		JButton btn5 = new JButton("");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!clicked[4]) {
					game(4, btn5, player1, player2);
					clicked[4] = true;
				}
				
			}
		});
		btn5.setFont(new Font("Lucida Grande", Font.BOLD, 80));
		panel_7.add(btn5, BorderLayout.CENTER);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new LineBorder(new Color(0, 0, 0),2));
		panel.add(panel_8);
		panel_8.setLayout(new BorderLayout(0, 0));
		
		JButton btn6 = new JButton("");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!clicked[5]) {
					game(5, btn6, player1, player2);
					clicked[5] = true;
				}
				
			}
		});
		btn6.setFont(new Font("Lucida Grande", Font.BOLD, 80));
		panel_8.add(btn6, BorderLayout.CENTER);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_9);
		panel_9.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel(player2);
		lblNewLabel_1.setFont(new Font("Trattatello", Font.PLAIN, 23));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_9.add(lblNewLabel_1, BorderLayout.CENTER);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_10);
		panel_10.setLayout(new BorderLayout(0, 0));
		
		oCount = new JTextField();
		oCount.setFont(new Font("Lucida Grande", Font.BOLD, 35));
		oCount.setText("0");
		oCount.setHorizontalAlignment(SwingConstants.CENTER);
		panel_10.add(oCount, BorderLayout.CENTER);
		oCount.setColumns(10);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBorder(new LineBorder(new Color(0, 0, 0),2));
		panel.add(panel_11);
		panel_11.setLayout(new BorderLayout(0, 0));
		
		JButton btn7 = new JButton("");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!clicked[6]) {
					game(6, btn7, player1, player2);
					clicked[6] = true;
				}
			
			}
		});
		btn7.setFont(new Font("Lucida Grande", Font.BOLD, 80));
		panel_11.add(btn7, BorderLayout.CENTER);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBorder(new LineBorder(new Color(0, 0, 0),2));
		panel.add(panel_12);
		panel_12.setLayout(new BorderLayout(0, 0));
		
		JButton btn8 = new JButton("");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!clicked[7]) {
					game(7, btn8, player1, player2);
					clicked[7] = true;
				}
				
			}
		});
		btn8.setFont(new Font("Lucida Grande", Font.BOLD, 80));
		panel_12.add(btn8, BorderLayout.CENTER);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBorder(new LineBorder(new Color(0, 0, 0),2));
		panel.add(panel_13);
		panel_13.setLayout(new BorderLayout(0, 0));
		
		JButton btn9 = new JButton("");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!clicked[8]) {
					game(8, btn9, player1, player2);
					clicked[8] = true;
				}
				
			}
		});
		btn9.setFont(new Font("Lucida Grande", Font.BOLD, 80));
		panel_13.add(btn9, BorderLayout.CENTER);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_14);
		panel_14.setLayout(new BorderLayout(0, 0));
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				startGame = "X";
			
				btn1.setText("");
				btn2.setText("");
				btn3.setText("");
				btn4.setText("");
				btn5.setText("");
				btn6.setText("");
				btn7.setText("");
				btn8.setText("");
				btn9.setText("");
				
				Arrays.fill(b, 0);
				
				i=0;
				
				Arrays.fill(clicked, false);
			}
		});
		btnReset.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		panel_14.add(btnReset, BorderLayout.CENTER);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_15);
		panel_15.setLayout(new BorderLayout(0, 0));
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frame, "Confirm You Want To Exit?", "Tic Tac Toe", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		btnExit.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		panel_15.add(btnExit, BorderLayout.CENTER);
		
		JMenuBar menuBar = new JMenuBar();
		frmTictactoegame.setJMenuBar(menuBar);
		
		JMenu nameMenu = new JMenu("Name");
		menuBar.add(nameMenu);
		
		JMenuItem chaneNameMenu = new JMenuItem("Change Players Name");
		nameMenu.add(chaneNameMenu);
		chaneNameMenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frmTictactoegame.setVisible(false);
				frmTictactoegame.dispose();
				new Dashboard();
			}
		});
	
		frmTictactoegame.setVisible(true);
	}
}
