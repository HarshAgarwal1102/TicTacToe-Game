package com.owner.tictactoe.user.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

public class TicTacToeSecondPlayer {
	String orgMessage = "TicTacToe - Second Player";
	private JFrame frmTictactoegame;
	private boolean yourTurn = false;
	//private boolean isXorZero = true;
	
	
	private void recInput() throws IOException {
		String strInput = "";
		while(!strInput.equalsIgnoreCase("exit")) {
			
			
			strInput = input.readUTF();
			if(strInput.length()==0) {
				continue;
			}
			if(strInput.startsWith("Game Over")) {
				titleLabel.setText(strInput);
				return ;
			}
			yourTurn = true;
			titleLabel.setText("Now Your Turn");
			System.out.println("Rec Message "+strInput);
			placeZeroOnScreen(strInput);
		}
	}
	
	private void placeZeroOnScreen(String input) {
		if(input.length()>0) {
			String arr[] = input.split(","); // 5, 0
			int buttonPosition = Integer.parseInt(arr[0]);
			String buttonValue = arr[1];
			switch(buttonPosition) {
			case 1:
				one.setText(buttonValue);
				break;
			case 2:
				two.setText(buttonValue);
				break;
			case 3:
				three.setText(buttonValue);
				break;
			case 4:
				four.setText(buttonValue);
				break;
			case 5:
				five.setText(buttonValue);
				break;
			case 6:
				six.setText(buttonValue);
				break;
			case 7:
				seven.setText(buttonValue);
				break;
			case 8:
				eight.setText(buttonValue);
				break;
			case 9:
				nine.setText(buttonValue);
				break;
				
			}
			
			
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
					TicTacToeSecondPlayer window = new TicTacToeSecondPlayer();
					window.frmTictactoegame.setVisible(true);
					try {
						window.netWorkInit();
						window.recInput();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
	}

	/**
	 * Create the application.
	 */
	public TicTacToeSecondPlayer() {
		initialize();
	}
	
	private void sendX(int buttonPosition, JButton currentButton) {
		if(currentButton.getText().trim().length()==0) {
			if(yourTurn) {
				currentButton.setText("X");
				if(isGameOver()) {
					titleLabel.setText("Game Over SecondPlayer Wins");
					String msg = "Game Over SecondPlayer Wins";
					System.out.println("Message Send "+msg);
					try {
						output.writeUTF(msg);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return ;
				}
				yourTurn = false;
				titleLabel.setText("Now First Player Turns Start , Wait for Your Turn...");
				try {
					String msg = buttonPosition + ","+"X";
					System.out.println("Message Send "+msg);
					output.writeUTF(msg);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					JOptionPane.showMessageDialog(frmTictactoegame, "Some Thing Went Wrong....");
				}
			}
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	JButton one = new JButton("");
	JButton two = new JButton("");
	JButton three = new JButton("");
	JButton four = new JButton("");
	JButton five = new JButton("");
	JButton six = new JButton("");
	JButton seven = new JButton("");
	JButton eight = new JButton("");
	JButton nine = new JButton("");
	Socket socket;
	final String SERVER_IP = "localhost";
	final int PORT = 9001;
	JLabel titleLabel;
	private DataInputStream input;
	private DataOutputStream output;
	private void netWorkInit() throws IOException {
		socket  = new Socket(SERVER_IP, PORT);
		// Waiting for Client...
		titleLabel.setText(orgMessage + " Second Player ready...");
		
		// Client Join
		Timer timer = new Timer(3000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // Clear text or whatever you want
            	titleLabel.setText("TicTacToe - Second Player");
            }
        });
        // start Tick-Tack
        timer.start();
		input = new DataInputStream(socket.getInputStream());
		output = new DataOutputStream(socket.getOutputStream());
	}
	
	private boolean buttonIsNotBlank(JButton currentButton) {
		return currentButton.getText().trim().length()>0;
	}
	
	private boolean isSameRow(JButton first, JButton second, JButton third) {
		if(buttonIsNotBlank(first) && buttonIsNotBlank(second) && buttonIsNotBlank(third)) {
			if(first.getText().equals(second.getText()) && first.getText().equals(third.getText())) {
				return true;
			}
		}
		return false;
	}
	
	private boolean isGameOver() {
		return isSameRow(one, two, three) || isSameRow(four, five, six) || isSameRow(seven, eight, nine)
				|| isSameRow(one, four, seven) || isSameRow(two, five, eight) || isSameRow( three, six, nine)
				|| isSameRow(one, five, nine) || isSameRow( three, five, seven);
	}
	
	private void initialize() {
		frmTictactoegame = new JFrame();
		frmTictactoegame.setResizable(false);
		frmTictactoegame.getContentPane().setBackground(new Color(238, 232, 170));
		frmTictactoegame.getContentPane().setLayout(null);
		
		titleLabel = new JLabel(orgMessage);
		titleLabel.setForeground(new Color(199, 21, 133));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Lucida Grande", Font.BOLD, 22));
		titleLabel.setBounds(45, 32, 764, 65);
		frmTictactoegame.getContentPane().add(titleLabel);
		one.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendX(1,one);
			}
		});
		
		
		one.setOpaque(true);
		one.setBackground(new Color(144, 238, 144));
		one.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		one.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		one.setBounds(74, 140, 184, 77);
		frmTictactoegame.getContentPane().add(one);
		two.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendX(2,two);
			}
		});
		
		
		two.setOpaque(true);
		two.setBackground(new Color(144, 238, 144));
		two.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		two.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		two.setBounds(307, 140, 184, 77);
		frmTictactoegame.getContentPane().add(two);
		three.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendX(3,three);
			}
		});
		
		
		three.setOpaque(true);
		three.setBackground(new Color(144, 238, 144));
		three.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		three.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		three.setBounds(534, 140, 184, 77);
		frmTictactoegame.getContentPane().add(three);
		four.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendX(4,four);
			}
			
		});
		
		
		four.setOpaque(true);
		four.setBackground(new Color(144, 238, 144));
		four.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		four.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		four.setBounds(74, 278, 184, 77);
		frmTictactoegame.getContentPane().add(four);
		five.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendX(5,five);
			}
		});
		
		
		five.setOpaque(true);
		five.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		five.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		five.setBackground(new Color(144, 238, 144));
		five.setBounds(307, 278, 184, 77);
		frmTictactoegame.getContentPane().add(five);
		six.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendX(6,six);
			}
		});
		
		
		six.setOpaque(true);
		six.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		six.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		six.setBackground(new Color(144, 238, 144));
		six.setBounds(534, 278, 184, 77);
		frmTictactoegame.getContentPane().add(six);
		seven.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendX(7,seven);
			}
		});
		
		
		seven.setOpaque(true);
		seven.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		seven.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		seven.setBackground(new Color(144, 238, 144));
		seven.setBounds(74, 400, 184, 77);
		frmTictactoegame.getContentPane().add(seven);
		eight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendX(8,eight);
			}
		});
		
		
		eight.setOpaque(true);
		eight.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		eight.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		eight.setBackground(new Color(144, 238, 144));
		eight.setBounds(307, 400, 184, 77);
		frmTictactoegame.getContentPane().add(eight);
		nine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendX(9,nine);
			}
		});
		
		
		nine.setOpaque(true);
		nine.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		nine.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		nine.setBackground(new Color(144, 238, 144));
		nine.setBounds(534, 400, 184, 77);
		frmTictactoegame.getContentPane().add(nine);
		frmTictactoegame.setTitle("TicTacToe-Game");
		frmTictactoegame.setBounds(100, 100, 815, 574);
		frmTictactoegame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTictactoegame.setLocationRelativeTo(null);
	}
}
