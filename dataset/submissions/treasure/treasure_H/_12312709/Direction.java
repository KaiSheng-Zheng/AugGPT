public enum Direction {
    UP,DOWN,LEFT,RIGHT;
    int GetId(){
        switch(this){
            case UP:return 0;
            case DOWN:return 1;
            case LEFT:return 2;
            case RIGHT:return 3;
            default:return 0;
        }
    }
}
