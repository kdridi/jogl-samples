package com.arykow.opengl.jogl.samples;

import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.media.opengl.glu.GLU;

import org.apache.log4j.Logger;

import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.KeyListener;
import com.jogamp.newt.event.WindowAdapter;
import com.jogamp.newt.event.WindowEvent;
import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.util.FPSAnimator;

public class Cube {

	public static class SquareElement {
		public float length = 1.0f;

		public float positionX = 0.0f;
		public float positionY = 0.0f;
		public float positionZ = 0.0f;

		private double angleValue = 0.0f;
		private float angleX = 0.0f;
		private float angleY = 0.0f;
		private float angleZ = 0.0f;

		public SquareElement cloneSquare() {
			SquareElement result = new SquareElement();
			result.length = length;
			result.positionX = positionX;
			result.positionY = positionY;
			result.positionZ = positionZ;
			result.angleValue = angleValue;
			result.angleX = angleX;
			result.angleY = angleY;
			result.angleZ = angleZ;
			return result;
		}

		public void draw(GL2 gl) {
			gl.glPushMatrix();
			gl.glTranslatef(positionX, positionY, positionZ);
			gl.glRotated(0.0f - angleValue, angleX, angleY, angleZ);
			gl.glBegin(GL2.GL_QUADS);
			{
				// HAUT
				gl.glColor3f(0.0f, 1.0f, 0.0f);
				gl.glVertex3f(0 + length, 0 + length, 0 - length);
				gl.glVertex3f(0 - length, 0 + length, 0 - length);
				gl.glVertex3f(0 - length, 0 + length, 0 + length);
				gl.glVertex3f(0 + length, 0 + length, 0 + length);
				// BAS
				gl.glColor3f(1.0f, 0.5f, 0.0f);
				gl.glVertex3f(0 + length, 0 - length, 0 + length);
				gl.glVertex3f(0 - length, 0 - length, 0 + length);
				gl.glVertex3f(0 - length, 0 - length, 0 - length);
				gl.glVertex3f(0 + length, 0 - length, 0 - length);
				// AVANT
				gl.glColor3f(1.0f, 0.0f, 0.0f);
				gl.glVertex3f(0 + length, 0 + length, 0 + length);
				gl.glVertex3f(0 - length, 0 + length, 0 + length);
				gl.glVertex3f(0 - length, 0 - length, 0 + length);
				gl.glVertex3f(0 + length, 0 - length, 0 + length);
				// ARRIERE
				gl.glColor3f(1.0f, 1.0f, 0.0f);
				gl.glVertex3f(0 + length, 0 - length, 0 - length);
				gl.glVertex3f(0 - length, 0 - length, 0 - length);
				gl.glVertex3f(0 - length, 0 + length, 0 - length);
				gl.glVertex3f(0 + length, 0 + length, 0 - length);
				// GAUCHE
				gl.glColor3f(0.0f, 0.0f, 1.0f);
				gl.glVertex3f(0 - length, 0 + length, 0 + length);
				gl.glVertex3f(0 - length, 0 + length, 0 - length);
				gl.glVertex3f(0 - length, 0 - length, 0 - length);
				gl.glVertex3f(0 - length, 0 - length, 0 + length);
				// DROIRE
				gl.glColor3f(1.0f, 0.0f, 1.0f);
				gl.glVertex3f(0 + length, 0 + length, 0 - length);
				gl.glVertex3f(0 + length, 0 + length, 0 + length);
				gl.glVertex3f(0 + length, 0 - length, 0 + length);
				gl.glVertex3f(0 + length, 0 - length, 0 - length);
			}
			gl.glEnd();
			gl.glPopMatrix();
		}
	}

	public static class TriangleElement {
		public float length = 1.0f;

		public float positionX = 0.0f;
		public float positionY = 0.0f;
		public float positionZ = 0.0f;

		private double angleValue = 0.0f;
		private float angleX = 0.0f;
		private float angleY = 0.0f;
		private float angleZ = 0.0f;

		public void draw(GL2 gl) {
			gl.glPushMatrix();
			gl.glTranslatef(positionX, positionY, positionZ);
			gl.glRotated(0.0f - angleValue, angleX, angleY, angleZ);
			gl.glBegin(GL2.GL_TRIANGLES);
			{
				gl.glColor3f(1.0f, 0.0f, 0.0f);
				gl.glVertex3f(0.0f, 0 + length, 0.0f);
				gl.glColor3f(0.0f, 1.0f, 0.0f);
				gl.glVertex3f(0 - length, 0 - length, 0 + length);
				gl.glColor3f(0.0f, 0.0f, 1.0f);
				gl.glVertex3f(0 + length, 0 - length, 0 + length);
				gl.glColor3f(1.0f, 0.0f, 0.0f);
				gl.glVertex3f(0.0f, 0 + length, 0.0f);
				gl.glColor3f(0.0f, 0.0f, 1.0f);
				gl.glVertex3f(0 + length, 0 - length, 0 + length);
				gl.glColor3f(0.0f, 1.0f, 0.0f);
				gl.glVertex3f(0 + length, 0 - length, 0 - length);
				gl.glColor3f(1.0f, 0.0f, 0.0f);
				gl.glVertex3f(0.0f, 0 + length, 0.0f);
				gl.glColor3f(0.0f, 1.0f, 0.0f);
				gl.glVertex3f(0 + length, 0 - length, 0 - length);
				gl.glColor3f(0.0f, 0.0f, 1.0f);
				gl.glVertex3f(0 - length, 0 - length, 0 - length);
				gl.glColor3f(1.0f, 0.0f, 0.0f);
				gl.glVertex3f(0.0f, 0 + length, 0.0f);
				gl.glColor3f(0.0f, 0.0f, 1.0f);
				gl.glVertex3f(0 - length, 0 - length, 0 - length);
				gl.glColor3f(0.0f, 1.0f, 0.0f);
				gl.glVertex3f(0 - length, 0 - length, 0 + length);
			}
			gl.glEnd();
			gl.glPopMatrix();
		}
	}

	private static final Logger logger = Logger.getLogger(Cube.class);

	static FPSAnimator animator = null;

	public static void main(String[] args) {
		logger.debug(String.format("setup OpenGL Version 2"));
		GLProfile profile = GLProfile.get(GLProfile.GL2);
		GLCapabilities capabilities = new GLCapabilities(profile);

		Renderer renderer = new Renderer();

		logger.debug(String.format("The canvas is the widget that's drawn in the JFrame"));

		GLWindow window = GLWindow.create(capabilities);
		window.addGLEventListener(renderer);
		window.addKeyListener(renderer);
		window.setSize(300, 300);
		window.setVisible(true);
		window.setTitle("Nehe Lesson 05");
		window.addWindowListener(new WindowAdapter() {
			public void windowDestroyed(WindowEvent arg0) {
				logger.debug(String.format("shutdown the program on windows close event"));
				finish();
			}
		});

		animator = new FPSAnimator(window, 60, true);
		animator.start();
	}

	private static void finish() {
		animator.stop();
		System.exit(0);
	}

	static class Renderer implements GLEventListener, KeyListener {
		private static final Logger logger = Logger.getLogger(Renderer.class);
		private final GLU glu = new GLU();
		private float rquadSpeed = 150f;
		private float rtriSpeed = 200f;
		private long time;
		private TriangleElement triangle;
		private SquareElement square;

		public void init(GLAutoDrawable gLDrawable) {
			logger.debug(String.format("init <- (GLAutoDrawable gLDrawable)"));
			final GL2 gl = gLDrawable.getGL().getGL2();

			gl.glShadeModel(GL2.GL_SMOOTH);
			gl.glClearColor(0.0f, 0.0f, 0.0f, 0.5f);
			gl.glClearDepth(1.0f);
			gl.glEnable(GL2.GL_DEPTH_TEST);
			gl.glDepthFunc(GL2.GL_LEQUAL);
			gl.glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_NICEST);

			time = System.currentTimeMillis();

			logger.debug(String.format("init -> ()"));

			triangle = new TriangleElement();
			triangle.positionX = -1.5f;
			triangle.positionY = 0.0f;
			triangle.positionZ = -6.0f;
			triangle.angleValue = 0.0f;
			triangle.angleX = 0.0f;
			triangle.angleY = 1.0f;
			triangle.angleZ = 0.0f;

			square = new SquareElement();
			square.positionX = 1.5f;
			square.positionY = 0.0f;
			square.positionZ = -6.0f;
			square.angleValue = 0.0f;
			square.angleX = 1.0f;
			square.angleY = 1.0f;
			square.angleZ = 1.0f;
		}

		public void display(GLAutoDrawable gLDrawable) {
			logger.debug(String.format("display <- (GLAutoDrawable gLDrawable)"));
			final GL2 gl = gLDrawable.getGL().getGL2();

			long time = System.currentTimeMillis();
			double delay = ((double) (time - this.time)) / 1000.0f;
			delay = 0;

			gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
			gl.glMatrixMode(GL2.GL_MODELVIEW);
			gl.glLoadIdentity();
			{
				gl.glTranslated(Math.sin(5 * delay), 0, Math.cos(5 * delay));
			}
			{
				triangle.angleValue = rtriSpeed * delay;
				triangle.draw(gl);
			}
			{
				square.angleValue = rquadSpeed * delay;
				square.draw(gl);
			}
			gl.glFlush();

			logger.debug(String.format("display -> ()"));
		}

		public void displayChanged(GLAutoDrawable gLDrawable, boolean modeChanged, boolean deviceChanged) {
			logger.debug(String.format("displayChanged <- (GLAutoDrawable gLDrawable, boolean modeChanged = %s, boolean deviceChanged = %s)", (modeChanged ? "true" : "false"), (deviceChanged ? "true" : "false")));
			logger.debug(String.format("displayChanged -> ()"));
		}

		public void reshape(GLAutoDrawable gLDrawable, int x, int y, int width, int height) {
			if (height <= 0) {
				logger.info("avoid a divide by zero error!");
				height = 1;
			}

			logger.debug(String.format("reshape <- (GLAutoDrawable gLDrawable, int x = %d, int y = %d, int width = %d, int height = %d)", x, y, width, height));
			final GL2 gl = gLDrawable.getGL().getGL2();

			gl.glViewport(0, 0, width, height);

			final float ratio = (float) width / (float) height;
			gl.glMatrixMode(GL2.GL_PROJECTION);
			gl.glLoadIdentity();
			glu.gluPerspective(45.0f, ratio, 1.0, 20.0);
			logger.debug(String.format("reshape -> ()"));
		}

		public void dispose(GLAutoDrawable gLDrawable) {
			logger.debug(String.format("dispose <- (GLAutoDrawable gLDrawable)"));
			logger.debug(String.format("dispose -> ()"));
		}

		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
				finish();
			}
		}

		public void keyReleased(KeyEvent e) {
		}

		public void keyTyped(KeyEvent e) {
		}
	}

}
