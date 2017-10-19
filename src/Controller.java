

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;


/*
 * 
 * @author Jason Skinner, Haiden Skinner
 *
 */
public class Controller implements ActionListener, KeyListener {

	private View view;

	/**
	 * Initializes the controller so that it has no model and no view.
	 */
	public Controller() {
		this.view = null;
	}

	/**
	 * Set the model and view for this controller.
	 * 
	 * @param model the model
	 * @param view the view
	 */
	public void set(View view) {
		this.view = view;
	}

	/**
	 * 
	 * This is an implementation of the method from the ActionListener interface. It
	 * is used in order to respond to the user clicking a button or menu item in the view.
	 * 
	 * @param e the action event to respond to.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		
		if (action.equals(View.EXIT)) {

			int check = JOptionPane.showOptionDialog(view, "Do you want to exit?", action, 0, 0, null, null, "EXIT");

			if (check == 0) {
				this.view.dispose();
			}

			//If the player asks for help, then instructions are displayed in a dialog box.
		} else if (action.equals(View.MENU_HELP)) {
			JOptionPane.showMessageDialog(view, "USE F2 to start new game. Use SpaceBar to pause!");
			// Show Help

		} else {

			this.view.dispose();
		}
	}

	@Override
	/**
	 * Handles the button presses of the use across their keyboard. 
	 * Depending on which button is pressed, the according method in the model is
	 * called to handle an action associated with that button.
	 * @param e the value representing the button pressed on the keyboard.
	 */
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == 38) {  //FLY UP
			view.jump(-1);
		}
		if (e.getKeyCode() == 40) {  //FLY DOWN
			view.jump(1);
		}
		if (e.getKeyCode()!=38 && e.getKeyCode()!= 40) {
			view.moveBlocks();
		}
	}

	@Override
	/**
	 * An empty method, used for handling keyReleased events.
	 */
	public void keyReleased(KeyEvent e) {

	}

	@Override
	/**
	 * An empty method, used for handling keyTyped events.
	 */
	public void keyTyped(KeyEvent arg0) {

	}

}