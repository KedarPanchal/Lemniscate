import processing.core.*;
// TODO: Add borders
public class Main extends PApplet {
    final int width = 1000;
    final int height = 1000;
    @Override
    public void settings() {
        size(width, height);
    }
    @Override
    public void setup() {
        colorMode(HSB, 360, 100, 100);
        background(255);
        noStroke();
        noLoop();
    }

    @Override
    public void draw() {
        translate(width/2.0f, height/2.0f);
        scale(1, -1);
        Lemniscate lemniscate = new Lemniscate(this.width * 0.5f * (float)Math.sqrt(1.5), 5);
        int[] colors = new int[8];

        for(int i = 0; i < colors.length; i++) {
            colors[i] = (int)random(361);
        }
        for(int x = -width/2; x < width/2; x++) {
            for(int y = -height/2; y < height/2; y++) {
                if(lemniscate.isInsideLemniscate(x, y)) {
                    if(y > 0) {
                        fill(colors[0], 100, 75);
                    } else {
                        fill(colors[1], 100, 75);
                    }
                } else {
                    if(x < 0) {
                        if(y >= 0) {
                            fill(colors[2], 100, 75);
                        } else {
                            if(y > x) {
                                fill(colors[3], 100, 75);
                            } else {
                                fill(colors[4], 100, 75);
                            }
                        }
                    } else {
                        if(y <= 0) {
                            fill(colors[5], 100, 75);
                        } else {
                            if(y > x) {
                                fill(colors[6], 100, 75);
                            } else {
                                fill(colors[7], 100, 75);
                            }
                        }
                    }
                }
                circle(x, y, 1);
            }
        }
        fill(0);
        lemniscate.outline(this);
        stroke(0);
        strokeWeight(lemniscate.strokeWeight);
        line(0, height/2.0f, 0, -height/2.0f);
        line(-width/2.0f, 0, width/2.0f, 0);
    }

    public static void main(String[] args) {
        PApplet.main("Main");
    }
}
