import java.util.Random;
import java.security.SecureRandom;
public class Player {
    private final int id=suijishu();
    private int score=0;
    private int steps=0;
    private int max=10^10;
    private Position position;
    private Map map;
    private static final String CHARACTERS = "0123456789";
    private static final Random RANDOM = new SecureRandom();

    public static int suijishu() {
        int length = 1000; // 生成的随机数字串的长度
        String numbers = "0123456789"; // 可以包含的数字
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(numbers.length());
            sb.append(numbers.charAt(index));
        }return Integer.parseInt(sb.toString());
    }
    public Player(Map map, Position initialPosition){
        this.map=map;
        this.position=initialPosition;
    }
    public Player(Map map, Position initialPosition, int maxStepAllowed){
        this.map=map;
        this.position=initialPosition;
        this.max=maxStepAllowed;
    }

    public int getId() {
        return id;
    }

    public Position getPosition() {
        return position;
    }

    public int getScore() {
        return score;
    }

    public int getSteps() {
        return steps;
    }
    public boolean move(Direction direction, int steps){
    if (!map.isActive()){
        return false;
    }else if (this.steps==this.max){
            return false;
        }else {
        if (direction==Direction.UP){
            this.position.setCol(this.position.getCol()-steps);
        }if (direction==Direction.DOWN){
            this.position.setCol(this.position.getCol()+steps);
        }if (direction==Direction.LEFT){
            this.position.setCol(this.position.getRow()-steps);
        }if (direction==Direction.RIGHT){
            this.position.setCol(this.position.getCol()+steps);
        }
        if (this.position.getCol()<0){
            this.position.setCol(0);
            return false;
        }else if (this.position.getCol()>this.map.getColumns()-1){
            this.position.setCol(this.map.getColumns()-1);
            return false;
        }else if (this.position.getRow()<0){
            this.position.setRow(0);
            return false;
        }else if (this.position.getRow()>this.map.getRows()-1){
            this.position.setRow(this.map.getRows()-1);
            return false;
        }else {
            return true;
        }
    }
    }public boolean equals(Object player){
        Player p = (Player) player;
        return this.id == p.id;
    }

}