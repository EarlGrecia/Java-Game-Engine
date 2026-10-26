package GameEngineCore;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWErrorCallback;

public class GraphicsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 GLFWErrorCallback.createPrint(System.err).set();

	        if (!GLFW.glfwInit()) {
	            throw new IllegalStateException("GLFW failed to initialize");
	        }

	        // Optional: print supported OpenGL version
	        long window = GLFW.glfwCreateWindow(100, 100, "Test", 0, 0);
	        if (window == 0) {
	            System.err.println("Failed to create GLFW window — possible graphics config error");
	        } else {
	            System.out.println("GLFW window created successfully!");
	        }

	        GLFW.glfwTerminate();
	}

}
