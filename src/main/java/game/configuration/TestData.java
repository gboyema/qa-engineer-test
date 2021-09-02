package game.configuration;

public class TestData {
    public int[] items;

    public TestData(int... items) {
        this.items = items;
    }

    public int get(int x) {
        return items[x];
    }
}
