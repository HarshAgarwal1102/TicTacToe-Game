# TicTacToe-Game

![TICTAC](https://github.com/king4404/TicTacToe-Game/assets/117922914/70bca25f-a785-42db-841d-19820138c95e)

# Java Swing GUI project for a Tic Tac Toe game with a detailed description of the project :

# Dashboard Screen:
- The application will start with a dashboard screen where players can enter their names.
- The dashboard screen will be created using Java Swing components such as JFrame, JPanel, JLabel, JTextField, and JButton.
- There will be two JLabels for displaying instructions or messages to the players.
- Two JTextFields will be provided for entering the names of Player 1 and Player 2.
- A “Start Game” button will initiate the game and transition to the main game window.
 &nbsp; &nbsp;<img width="768" alt="Screenshot 2023-07-09 at 9 40 20 PM" src="https://github.com/king4404/TicTacToe-Game/assets/117922914/a58b2a98-b542-4570-9684-eac16d95538e">

# GUI Design:
- The GUI will be created using Java Swing components such as JFrame, JPanel, JButton, JLabel, JTextField, etc.
- The main game window will display a 3x5 grid of buttons representing the Tic Tac Toe board.
- Each button will initially be empty and clickable.
- There will be two JTextField components for entering the names of Player 1 and Player 2.
- There will be two additional JTextFields for displaying each player's score.
- Two buttons will be provided: “Reset” to clear the board and start a new game, and “Exit” to close the application.
 &nbsp; &nbsp;<img width="599" alt="Screenshot 2023-07-09 at 9 48 32 PM" src="https://github.com/king4404/TicTacToe-Game/assets/117922914/10359482-3606-42f3-805d-802f12418336">

# Game Logic :
- The game logic will handle the state of the game, and the player moves, and determine the winner.
- The game will be played between two players, typically represented as “X” and “O.”
- Each player will take turns clicking on an empty cell to make their move.
- The game logic will update the button’s label with the current player’s symbol (“X” or “O”).
- After each move, the game logic will check for a winning condition or a draw.
- The game logic will declare the winner if a winning condition is met (e.g., three symbols in a row, column, or diagonal).
- The game logic will also keep track of each player's score.
 &nbsp; &nbsp;<img width="598" alt="Screenshot 2023-07-09 at 9 51 54 PM" src="https://github.com/king4404/TicTacToe-Game/assets/117922914/eb253a0c-9b8c-4523-bef2-02461ec028e0">

# Event Handling:
- Event listeners will be attached to each button to handle player moves.
- When a button is clicked, the event handler will check if the button is empty and it’s the player’s turn.
- If valid, the event handler will update the button’s label and invoke the game logic to handle the move.
- The game logic will then update the game status and check for a winner or draw.
- If there is a winner or a match draw, the game logic will update the player’s score and display it in the respective JTextFields.
  
# Additional Features:
- **Player Names:** Players can enter their names in the Player1 and Player2 JTextField components.
- **Score Calculation:** The game logic will keep track of the score for each player and update the JTextFields below the grid accordingly.
- **Reset Board:** Clicking the “Reset Board” button will clear the board, allowing players to start a new game, and reset the score.
- **Exiting the application:** Clicking the “Exit” button or closing the game window will terminate the application.
  
With these additional features, the updated Tic Tac Toe game GUI project will provide an interactive interface where players can enter their names, keep track of their scores, and enjoy playing the game.
