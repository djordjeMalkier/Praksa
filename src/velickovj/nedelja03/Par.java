package velickovj.nedelja03;

public class Par {
    private int x;
    private int y;

    public Par(int x1, int y1) {
        this.x=x1;
        this.y=y1;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "{" +
                 x +
                 y +
                '}';
    }
}
