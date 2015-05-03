package jto.processing;

import processing.core.PApplet;
import processing.video.Capture;

public class VideoTestSketch extends PApplet {

    private Capture capture;

    public static void main(String[] args) {
        System.setProperty("java.library.path", "/opt/dev/processing-deps/video/macosx64");
        PApplet.main(new String[]{VideoTestSketch.class.getName()});
    }

    @Override
    public void setup() {
        size(1920, 1080);
        String[] cameras = Capture.list();
        for (String cam : cameras) {
            println(cam);
        }

        capture = new Capture(this, width, height, cameras[0]);
    }

    @Override
    public void draw() {
        image(capture.get(), 0, 0);
    }
}
