package GameEngineCore;

import org.lwjgl.Version;

import GameEnginePackage.managers.EngineManager;
import GameEnginePackage.utils.Consts;

public class Launcher {
	
	private static WindowDisplay display;
	private static TestGame game;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		display = new WindowDisplay(Consts.TITLE, 1280, 720, true);
		game = new TestGame();
		EngineManager engine = new EngineManager();
		try {
			engine.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static WindowDisplay getWindow() {
		// TODO Auto-generated method stub
		return display;
	}
	
	public static TestGame getGame() {
		return game;
	}

}
