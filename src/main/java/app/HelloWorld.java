package app;

import Color.Color;
import Coordinates.Coord2d;
import Coordinates.Coord3d;
import Figures.Dot.Dot2d;
import Figures.Line.Line3d;
import Figures.Triangle.Triangle2d;
import Figures.Triangle.Triangle3d;
import org.lwjgl.*;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
import org.lwjgl.system.*;

import java.io.IOException;
import java.nio.*;

import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryStack.*;
import static org.lwjgl.system.MemoryUtil.*;

public class HelloWorld {

    // The window handle
    private long window;

    public void run() throws IOException, InterruptedException {
        System.out.println("Hello LWJGL " + Version.getVersion() + "!");

        init();
        loop();

        // Free the window callbacks and destroy the window
        glfwFreeCallbacks(window);
        glfwDestroyWindow(window);

        // Terminate GLFW and free the error callback
        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }

    private void init() {
        // Setup an error callback. The default implementation
        // will print the error message in System.err.


        GLFWErrorCallback.createPrint(System.err).set();

        // Initialize GLFW. Most GLFW functions will not work before doing this.
        if (!glfwInit())
            throw new IllegalStateException("Unable to initialize GLFW");

        // Configure GLFW
        glfwDefaultWindowHints(); // optional, the current window hints are already the default
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE); // the window will stay hidden after creation
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE); // the window will be resizable

        // Create the window
        window = glfwCreateWindow(800, 600, "Hello World!", NULL, NULL);
        if (window == NULL)
            throw new RuntimeException("Failed to create the GLFW window");

        // Setup a key callback. It will be called every time a key is pressed, repeated or released.
        glfwSetKeyCallback(window, (window, key, scancode, action, mods) -> {
            if (key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE)
                glfwSetWindowShouldClose(window, true); // We will detect this in the rendering loop
        });

        // Get the thread stack and push a new frame
        try (MemoryStack stack = stackPush()) {
            IntBuffer pWidth = stack.mallocInt(1); // int*
            IntBuffer pHeight = stack.mallocInt(1); // int*

            // Get the window size passed to glfwCreateWindow
            glfwGetWindowSize(window, pWidth, pHeight);

            // Get the resolution of the primary monitor
            GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());

            // Center the window
            glfwSetWindowPos(
                    window,
                    (vidmode.width() - pWidth.get(0)) / 2,
                    (vidmode.height() - pHeight.get(0)) / 2
            );
        } // the stack frame is popped automatically

        // Make the OpenGL context current
        glfwMakeContextCurrent(window);
        // Enable v-sync
        glfwSwapInterval(1);

        // Make the window visible
        glfwShowWindow(window);
    }

    private void loop() throws IOException, InterruptedException {
        // This line is critical for LWJGL's interoperation with GLFW's
        // OpenGL context, or any context that is managed externally.
        // LWJGL detects the context that is current in the current thread,
        // creates the GLCapabilities instance and makes the OpenGL
        // bindings available for use.
        GL.createCapabilities();

        glMatrixMode(GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(-800, 800, -600, 600, 500, -500);
//        GL11.glOrtho(1, 1, 1, 1, 1, -1);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);


        // Set the clear color
        glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        glClearDepth(100.0f);
        GL11.glEnable(GL_DEPTH_TEST);
        GL11.glDepthFunc(GL_LEQUAL);
        GL11.glShadeModel(GL_SMOOTH);
        GL11.glHint(GL_PERSPECTIVE_CORRECTION_HINT, GL_NICEST);


        // Run the rendering loop until the user has attempted to close
        // the window or has pressed the ESCAPE key.
        Coord3d A = new Coord3d(-50, -50, -50);
        Coord3d B = new Coord3d(50, -50, -50);
        Coord3d C = new Coord3d(0, 50, 0);
        Coord3d D = new Coord3d(0, 0, 50);

        Color colorA = new Color(255, 0, 0);
        Color colorB = new Color(0, 255, 0);
        Color colorC = new Color(0, 0, 255);
        Color colorD = new Color(255, 0, 255);

        Triangle3d triangle = new Triangle3d(A, B, C, D);
        triangle.setColorA(colorA);
        triangle.setColorB(colorB);
        triangle.setColorC(colorC);
        triangle.setColorD(colorD);

        triangle.setScale(5);


        Line3d line = new Line3d(-50, -50, 5, 50, 50, 0);
        line.setColor(0, 1, 0);
        while (!glfwWindowShouldClose(window)) {
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // clear the framebuffer


            triangle.draw();
//            triangle.getTriangle().glRotatef(3f, 1, 1, 0);
            

            glfwSwapBuffers(window); // swap the color buffers

            // Poll for window events. The key callback above will only be
            // invoked during this call.


            glfwPollEvents();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        new HelloWorld().run();
    }

}