package mirzad.zadaci;

import java.util.ArrayList;

public class Putanja {
    private ArrayList<int[]> putanja;
    private int count;

    public Putanja(){
        putanja = new ArrayList<>();
        count = 0;
    }

    public ArrayList<int[]> getPutanja() {
        return putanja;
    }

    public void setPutanja(ArrayList<int[]> putanja) {
        this.putanja = putanja;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
