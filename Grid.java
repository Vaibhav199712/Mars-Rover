import java.util.ArrayList;
import java.util.List;

public class Grid implements MapComponent {
    public int width;
    public int height;
    int[][] grid;
    public List<MapComponent> components = new ArrayList<>();

    Grid(int width, int height) {
        this.width = width;
        this.height = height;
        grid = new int[width][height];
    }

    public void addObstacle(int x, int y) {
        grid[x][y] = 1;
    }

    public boolean checkCollision(int x, int y) {
        if (grid[x][y] == 1) {
            return true;
        }
        return false;
    }
}
