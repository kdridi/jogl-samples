package com.arykow.opengl.jogl.samples;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.media.opengl.glu.GLU;
import javax.swing.JFrame;

import org.apache.log4j.Logger;

public class App {
	private static final Logger logger = Logger.getLogger(App.class);

	public static void main(String[] args) {
		logger.debug(String.format("setup OpenGL Version 2"));
		GLProfile profile = GLProfile.get(GLProfile.GL2);
		GLCapabilities capabilities = new GLCapabilities(profile);

		logger.debug(String.format("The canvas is the widget that's drawn in the JFrame"));
		GLCanvas glcanvas = new GLCanvas(capabilities);
		glcanvas.addGLEventListener(new Renderer());
		glcanvas.setSize(300, 300);

		JFrame frame = new JFrame("Hello World");
		frame.getContentPane().add(glcanvas);

		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent ev) {
				logger.debug(String.format("shutdown the program on windows close event"));
				System.exit(0);
			}
		});

		frame.setSize(frame.getContentPane().getPreferredSize());
		frame.setVisible(true);
	}

	static class Renderer implements GLEventListener {
		private static final Logger logger = Logger.getLogger(Renderer.class);
		private final GLU glu = new GLU();

		public void display(GLAutoDrawable gLDrawable) {
			logger.debug(String.format("display <- (GLAutoDrawable gLDrawable)"));
			final GL2 gl = gLDrawable.getGL().getGL2();
			gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
			gl.glMatrixMode(GL2.GL_MODELVIEW);
			gl.glLoadIdentity();
			gl.glTranslatef(-1.5f, 0.0f, -6.0f);
			gl.glBegin(GL2.GL_TRIANGLES);
			gl.glVertex3f(0.0f, 1.0f, 0.0f);
			gl.glVertex3f(-1.0f, -1.0f, 0.0f);
			gl.glVertex3f(1.0f, -1.0f, 0.0f);
			gl.glEnd();
			gl.glTranslatef(3.0f, 0.0f, 0.0f);
			gl.glBegin(GL2.GL_QUADS);
			gl.glVertex3f(-1.0f, 1.0f, 0.0f);
			gl.glVertex3f(1.0f, 1.0f, 0.0f);
			gl.glVertex3f(1.0f, -1.0f, 0.0f);
			gl.glVertex3f(-1.0f, -1.0f, 0.0f);
			gl.glEnd();
			gl.glFlush();
			logger.debug(String.format("display -> ()"));
		}

		public void displayChanged(GLAutoDrawable gLDrawable, boolean modeChanged, boolean deviceChanged) {
			logger.debug(String.format("displayChanged <- (GLAutoDrawable gLDrawable, boolean modeChanged = %s, boolean deviceChanged = %s)", (modeChanged ? "true" : "false"), (deviceChanged ? "true" : "false")));
			logger.debug(String.format("displayChanged -> ()"));
		}

		public void init(GLAutoDrawable gLDrawable) {
			logger.debug(String.format("init <- (GLAutoDrawable gLDrawable)"));
			logger.debug(String.format("init -> ()"));

			final GL2 gl = gLDrawable.getGL().getGL2();

			gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
			gl.glShadeModel(GL2.GL_FLAT);
		}

		public void reshape(GLAutoDrawable gLDrawable, int x, int y, int width, int height) {
			if (height <= 0) {
				logger.info("avoid a divide by zero error!");
				height = 1;
			}

			logger.debug(String.format("reshape <- (GLAutoDrawable gLDrawable, int x = %d, int y = %d, int width = %d, int height = %d)", x, y, width, height));
			logger.debug(String.format("reshape -> ()"));
			final GL2 gl = gLDrawable.getGL().getGL2();

			final float h = (float) width / (float) height;
			gl.glViewport(0, 0, width, height);
			gl.glMatrixMode(GL2.GL_PROJECTION);
			gl.glLoadIdentity();
			glu.gluPerspective(45.0f, h, 1.0, 20.0);
		}

		public void dispose(GLAutoDrawable arg0) {
			logger.debug(String.format("dispose <- (GLAutoDrawable gLDrawable)"));
			logger.debug(String.format("dispose -> ()"));
		}
	}

}
