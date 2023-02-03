import processing.core.*;

public class Lemniscate {
    public final float petalLength;
    public final int strokeWeight;

    public Lemniscate(float petalLength, int strokeWeight) {
        this.petalLength = petalLength;
        this.strokeWeight = strokeWeight;
    }

    public float computeRadius(float theta) {
        return (float)Math.sqrt(this.petalLength * this.petalLength * Math.sin(2 * theta));
    }

    private float computeRadius(int x, int y) {
        return (float)Math.sqrt(x*x + y*y);
    }

    private float computeRadians(int x, int y) {
        final float theta = (float)Math.acos(x / computeRadius(x, y));
        if(y < 0) {
            return (float)(2 * Math.PI - theta);
        }
        return theta;
    }

    public boolean isInsideLemniscate(int x, int y) {
        final float r = computeRadius(x, y);
        final float theta = computeRadians(x, y);
        return r <= computeRadius(theta);
    }

    public void outline(PApplet drawer) {
        drawer.fill(0);
        for(float deg = 0; deg < 360; deg += 0.001f) {
            final float radians = PApplet.radians(deg);
            final float r = computeRadius(radians);
            final float x = r * (float)Math.cos(radians);
            final float y = r * (float)Math.sin(radians);
            drawer.circle(x, y, this.strokeWeight);
        }
    }
}
