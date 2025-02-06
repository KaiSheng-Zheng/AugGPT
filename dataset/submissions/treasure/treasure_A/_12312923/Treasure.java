public class Treasure
{
    private final int score;
    private final Position position;
    private boolean notFound;

    public Treasure(int score, Position position) {
        this.score = score;
        this.position = position;
        this.notFound=true;
    }

    public int getScore() {
        return score;
    }

    public Position getPosition() {
        return position;
    }

    public boolean isNotFound() {
        return notFound;
    }

    public void setNotFound(boolean notFound) {
        this.notFound = notFound;
    }
}
