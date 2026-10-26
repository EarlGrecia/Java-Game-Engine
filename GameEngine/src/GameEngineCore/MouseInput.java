package GameEnginePackage;

import org.joml.Vector2d;
import org.joml.Vector2f;
import org.lwjgl.glfw.GLFW;

public class MouseInput {
	private final Vector2d previousPos;
	private final Vector2d currentPos;
	private WindowDisplay display = Launcher.getWindow();
	
	private final Vector2f displayVec;
	
	private boolean inWindow = false;
	private boolean leftButtonPress = false;
	private boolean rightButtonPress = false;
	private boolean middleButtonPress = false;
	
	public MouseInput() {
		previousPos = new Vector2d(-1, -1);
		currentPos = new Vector2d(0, 0);
		displayVec = new Vector2f(); 
	}
	
	public void init() {
		GLFW.glfwSetCursorPosCallback(display.getWindow(), 
				(window, xpos, ypos)->{
			currentPos.x = xpos;
			currentPos.y = ypos;
		});
		
		GLFW.glfwSetCursorEnterCallback(display.getWindow(), 
				(window, entered) -> {
					inWindow = entered;
				});
		
		GLFW.glfwSetMouseButtonCallback(display.getWindow(), 
				(window, button, action, mode) -> {
			leftButtonPress = button 
					== GLFW.GLFW_MOUSE_BUTTON_1 && action == GLFW.GLFW_PRESS;
			rightButtonPress = button
					== GLFW.GLFW_MOUSE_BUTTON_2 && action == GLFW.GLFW_PRESS;
			middleButtonPress = button
					== GLFW.GLFW_MOUSE_BUTTON_3 && action == GLFW.GLFW_PRESS;
		});
	}
	
	public void input() {
		displayVec.x = 0;
		displayVec.y = 0;
		if(previousPos.x > 0 && previousPos.y > 0 && inWindow) {
			double x = currentPos.x - previousPos.x;
			double y = currentPos.y - previousPos.y;
			boolean rotateX = x!=0;
			boolean rotateY = y!=0;
			if(rotateX) {
				displayVec.y = (float)x;
			}
			
			if(rotateY) {
				displayVec.x = (float)y;
			}
		}
		previousPos.x = currentPos.x;
		previousPos.y = currentPos.y;
	}

	public boolean isLeftButtonPress() {
		return leftButtonPress;
	}

	public boolean isRightButtonPress() {
		return rightButtonPress;
	}
	
	public boolean isMiddleButtonPress() {
		return middleButtonPress;
	}

	public Vector2f getDisplayVec() {
		return displayVec;
	}
}
