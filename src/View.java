
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * A view for the snake puzzle game. This class handles showing the snake game
 * to the end user.
 * 
 * @author Jason Skinner, Haiden Skinner
 */
@SuppressWarnings("serial")
public class View extends JFrame implements ActionListener, KeyListener {

	// This takes care of the constants so there are no magic numbers or constants
	// in code.
	// **************************************************************************
	public static final String GAME_NAME = "Haiden's Dash";
	public static final String NEW_GAME = "NEW GAME";
	public static final String MENU_NAME = "GAME";
	public static final String MENU_HELP = "HELP";
	public static final String HIGH_SCORE = "HIGH SCORES...";
	public static final String EXIT = "EXIT";
	public static final int GAME_WIDTH = 40;
	public static final int GAME_HEIGHT = 25;
	// **************************************************************************

	// This takes care of the grid of labels which represent the grid that the snake
	// will traverse in game.
	public JLabel[][] labels;

	// This represents the locations of the food locations and the poison locations,
	// respectively.
	public static final ArrayList<RowCol> foodLocation = new ArrayList<RowCol>();
	public static final ArrayList<RowCol> dieLocation = new ArrayList<RowCol>();
	public int height = 13;
	public int LEFT_POSITION= 10;
	File file = new File("boy.jpg");
	ImageIcon img = new ImageIcon(file.getAbsolutePath().toString());

	public View() {
		super(GAME_NAME);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.makeMenu();
		try {
			this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("images/Snake_BG.png")))));
		} catch (IOException e) {
		}
		;
		this.getContentPane().setLayout(new GridLayout(GAME_HEIGHT, GAME_WIDTH));
		this.addKeyListener(this);
		this.makeLabels();
		this.setResizable(true);
		this.getContentPane().setBackground(Color.WHITE);
		this.setVisible(true);
		this.pack();

	}

	private void makeMenu() {
		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);
		JMenu menu = new JMenu();
		menu.setText(View.MENU_NAME);
		JMenu menu2 = new JMenu();
		menu2.setText(View.MENU_HELP);
		JMenuItem helps = new JMenuItem();
		helps.setText(MENU_HELP);
		helps.setActionCommand(MENU_HELP);
		helps.addActionListener(this);
		JMenuItem newGame = new JMenuItem();
		newGame.setText(View.NEW_GAME);
		newGame.setActionCommand(View.NEW_GAME);
		newGame.addActionListener(this);
		JMenuItem highScores = new JMenuItem();
		highScores.setText(View.HIGH_SCORE);
		highScores.setActionCommand(View.HIGH_SCORE);
		highScores.addActionListener(this);
		JMenuItem exit = new JMenuItem();
		exit.setText(View.EXIT);
		exit.setActionCommand(View.EXIT);
		exit.addActionListener(this);
		menuBar.add(menu);
		menuBar.add(menu2);
		menu2.add(helps);
		menu.add(newGame);
		menu.add(highScores);
		menu.add(exit);
	}

	private void makeLabels() {
		this.labels = new JLabel[GAME_HEIGHT][GAME_WIDTH];
		for (int i = 0; i < GAME_HEIGHT; i++) {
			for (int j = 0; j < GAME_WIDTH; j++) {
				JLabel b = new JLabel(" ");
				b.setForeground(Color.BLACK);
				b.setBackground(Color.WHITE);
				b.setPreferredSize(new Dimension(20, 20));// set the preferred
															// size of b
				b.setVisible(true);
				labels[i][j] = b;

				add(b);

			}
		}

		labels[height][LEFT_POSITION].setBackground(Color.ORANGE);
		labels[height][LEFT_POSITION].setOpaque(true);
		labels[height][LEFT_POSITION].setVisible(true);
		labels[height][LEFT_POSITION].setIcon(img);
	}

	public void jump(int direction) {
		int i = height;

		if (height + direction < 0 || height + direction == GAME_HEIGHT) {

		} else {
			labels[i][LEFT_POSITION].setBackground(Color.BLACK);
			labels[i][LEFT_POSITION].setOpaque(false);
			labels[i][LEFT_POSITION].setVisible(false);

			height = height + direction;
			i = height;

			labels[i][LEFT_POSITION].setBackground(Color.ORANGE);
			labels[i][LEFT_POSITION].setOpaque(true);
			labels[i][LEFT_POSITION].setVisible(true);
			labels[i][LEFT_POSITION].setIcon(img);
		}
	}

	public static void main(String[] args) {
		new View();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getKeyCode() == 38) {  //FLY UP
			jump(-1);
		}
		if (arg0.getKeyCode() == 40) {  //FLY DOWN
			jump(1);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals(EXIT)) {
			this.dispose();
		}
	}
}
