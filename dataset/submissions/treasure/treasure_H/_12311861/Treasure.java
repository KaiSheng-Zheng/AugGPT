class Treasure {
    private int score;
    private final Position position;
    private int exit;
    public Treasure(int scor, Position positio){
        score=scor;position=positio;exit=1;
    }
    public int getScore(){
        return score;
    }
    public Position getPosition(){
        return position;
    }
    public int getExit(){
        return exit;
    }
    public void setExit(){
        exit=0;
    }
}
