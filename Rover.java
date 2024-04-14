public class Rover {
    private int x;
    private int y;
    private Direction direction;
    private Grid grid;

    Rover(int x, int y, Direction direction, Grid grid) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.grid = grid;
    }

    public void move() {
        int newX = x;
        int newY = y;

        switch (direction) {
            case NORTH:
                newY++;
                break;
            case SOUTH:
                newY--;
                break;
            case EAST:
                newX++;
                break;
            case WEST:
                newX--;
                break;
        }

        if (isValidMove(newX, newY)) {
            x = newX;
            y = newY;
        } else {
            System.out.println("Obstacle detected! Rover cannot move.");
        }
    }

    public void turnLeft() {
        direction = Direction.values()[(direction.ordinal() + 3) % 4];
    }

    public void turnRight() {
        direction = Direction.values()[(direction.ordinal() + 1) % 4];
    }

    private boolean isValidMove(int newX, int newY) {
        return newX >= 0 && newX < grid.width && newY >= 0 && newY < grid.height &&
                !grid.checkCollision(newX, newY);
    }

    public void reportStatus() {
        System.out.println("Rover is at (" + x + ", " + y + ") facing " + direction + ".");
        if (!grid.checkCollision(x, y)) {
            System.out.println("No obstacles detected.");
        }
    }
}
