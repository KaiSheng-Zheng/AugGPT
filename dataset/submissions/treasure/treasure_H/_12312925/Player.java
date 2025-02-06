public class Player{
    private static int number;
    private final int id = number;
    private int score;
    private int steps = 0;
    private Position position;
    String maxStepAllowed;
    Map map;
    public Player(Map map, Position initialPosition)
    {
        this.map =map;
        this.position = initialPosition;
        number++;

    }
    public int getId() {
        return id;
    }

    public Player(Map map, Position initialPosition, int maxStepAllowed)
    {
        this.maxStepAllowed = String.valueOf(maxStepAllowed);
        this.map =map;
        this.position = initialPosition;
        number++;
    }
    public boolean move(String direction, int _steps)
    {
        if(Map.isActive()){return false;}
        if(maxStepAllowed!=null) {
            if (Integer.parseInt(maxStepAllowed) > 0) {
                for (int i = 0; i < _steps && Integer.parseInt(maxStepAllowed) > 0; i++) {
                    DirectionOperation(direction);
                    score += map.hasTreasure(position);
                    if(Map.isActive()){return false;}
                    getMaxStepAllowed();
                }
            }
        }
        else
        {
            for (int i = 0; i < _steps; i++)
            {
                DirectionOperation(direction);
                score += map.hasTreasure(position);
                if(Map.isActive()){return false;}
            }
        }
        return true;
    }
    private void DirectionOperation(String direction) {
        switch (direction)
        {
            case "LEFT": if (position.getCol() > 0) {position.setCol(position.getCol() - 1);steps++;}break;
            case "RIGHT": if (position.getCol() < map.columns-1){ position.setCol(position.getCol() + 1);steps++;}break;
            case "UP": if (position.getRow() > 0) {position.setRow(position.getRow() - 1);steps++;}break;
            case "DOWN": if (position.getRow() < map.rows-1) {position.setRow(position.getRow() + 1);steps++;}break;
        }
    }
    public int getSteps()
    {
        return steps;
    }
    public String getMaxStepAllowed()
    {
        maxStepAllowed =String.valueOf(Integer.parseInt(maxStepAllowed) - 1);
        return maxStepAllowed;
    }

    public boolean equals(Object player)
    {
        Player player1 =(Player) player;
        return player1.id == ((Player) player).id;
    }
    @Override
    public String toString()
    {
        return String.format("Player:%s\tposition:(%s,%s)\tscore:%s\tsteps:%s",id+1,position.getRow(),
                position.getCol(),score,steps);
    }

    public Position getPosition() {
        return position;
    }

    public int getScore() {
        return score;
    }
}