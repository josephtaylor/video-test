package jto.processing;

import processing.core.PApplet;
import processing.video.Capture;

public class VideoTestSketch extends PApplet {

    private Capture capture;

    public static void main(String[] args) {
		// better idea to specify these as VM args
		// included here for simplicity
        System.setProperty("jna.library.path", "C:\\dev\\processing-deps\\video\\windows64");
        System.setProperty("gstreamer.library.path", "C:\\dev\\processing-deps\\video\\windows64");
        System.setProperty("gstreamer.plugin.path", "C:\\dev\\processing-deps\\video\\windows64\\plugins");

		for (String name : System.getProperties().stringPropertyNames()) {
			String prop = System.getProperty(name);
			println(name + ":\t" + prop);
		}

        PApplet.main(new String[] { VideoTestSketch.class.getName() });
    }

    @Override
    public void setup() {
        size(640, 480);
        String[] cameras = Capture.list();
        for (String cam : cameras) {
            println(cam);
        }

		// my camera is at index 1. Change it to be the camera you need.
        capture = new Capture(this, width, height, cameras[1]);
		capture.start();
    }

    @Override
    public void draw() {
		if (capture.available()) {
			capture.read();
		}
        image(capture.get(), 0, 0);
    }
}
