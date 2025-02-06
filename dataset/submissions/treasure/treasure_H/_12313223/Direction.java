public enum Direction {
    UP,DOWN,LEFT,RIGHT;
    public int colchange(){
        if(name()== LEFT.name()) return -1;
        if(name()== RIGHT.name()) return 1;
        return 0;
    }
    public int rowchange(){
        if(name()== UP.name()) return -1;
        if(name()== DOWN.name()) return 1;
        return 0;
    }
}
