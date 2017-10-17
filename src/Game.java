
public class Game {

	public static void main(String[] args) {
		Controller controller = new Controller();
		View view = new View(controller, controller);
		view.randomBlocks(5);
		controller.set(view);
	}

}
