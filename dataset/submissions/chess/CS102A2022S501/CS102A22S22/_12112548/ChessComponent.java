import java.util.ArrayList;
import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source; // Where the chess is
    private ChessColor chessColor; // What's the color
    protected char name; // What's the name

    public ChessboardPoint getSource() {
        return source;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }

    public ChessComponent(){}; //why not abstract?

    public abstract List<ChessboardPoint> canMoveTo();

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}

class KingChessComponent extends ChessComponent {
    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super.setSource(source);
        super.setChessColor(chessColor);
        this.name = name;
    }
    public KingChessComponent(int x,int y){
        ChessboardPoint source = new ChessboardPoint(x,y);
        super.setSource(source);
    }

    public List<ChessboardPoint> canMoveTo() {

        ConcreteChessGame ccGame=new ConcreteChessGame();
        ChessComponent[][] BoardData=ccGame.GetChessBoard();

        ArrayList<ChessboardPoint> list = new ArrayList<>();
        int x = getSource().getX();
        int y = getSource().getY();
        if (getSource().offset(0,-1) != null){
            if (BoardData[x][y-1].getChessColor() != BoardData[x][y].getChessColor()){
                list.add(getSource().offset(0,-1));
            }
        }
        if (getSource().offset(0,1) != null){
            if (BoardData[x][y+1].getChessColor() != BoardData[x][y].getChessColor()){
                list.add(getSource().offset(0,1));
            }
        }
        for (int j = -1;j < 2;j++){
            if (getSource().offset(-1,j) != null){
                if (BoardData[x-1][y+j].getChessColor() != BoardData[x][y].getChessColor()){
                    list.add(getSource().offset(-1,j));
                }
            }
        }
        for (int j = -1;j < 2;j++){
            if (getSource().offset(1,j) != null){
                if (BoardData[x+1][y+j].getChessColor() != BoardData[x][y].getChessColor()){
                    list.add(getSource().offset(1,j));
                }
            }
        }


        return list;
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}


class QueenChessComponent extends ChessComponent {
    public QueenChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super.setSource(source);
        super.setChessColor(chessColor);
        this.name = name;
    }

    public QueenChessComponent(int x,int y){
        ChessboardPoint source = new ChessboardPoint(x,y);
        super.setSource(source);
    }

    public List<ChessboardPoint> canMoveTo() {
     
        ConcreteChessGame ccGame=new ConcreteChessGame();
        ChessComponent[][] BoardData=ccGame.GetChessBoard();

        ArrayList<ChessboardPoint> list = new ArrayList<>();
        int x = getSource().getX();
        int y = getSource().getY();
   
        for (int i = -1;i >= -7;i--){
            if (getSource().offset(i,i) != null){
                if (BoardData[x+i][y+i].name == '_'){
                    list.add(getSource().offset(i,i));
                }
                else{
                    if (BoardData[x+i][y+i].getChessColor() != BoardData[x][y].getChessColor()){
                        list.add(getSource().offset(i,i));
                    }
                    break;
                }
            }
        }
   
        for (int i = -1;i >= -7;i--){
            if (getSource().offset(i,0) != null){
                if (BoardData[x+i][y].name == '_'){
                    list.add(getSource().offset(i,0));
                }
                else{
                    if (BoardData[x+i][y].getChessColor() != BoardData[x][y].getChessColor()){
                        list.add(getSource().offset(i,0));
                    }
                    break;
                }
            }
        }
     
        for (int i = -1;i >= -7;i--) {
            if (getSource().offset(i,-i) != null){
                if (BoardData[x + i][y - i].name == '_') {
                    list.add(getSource().offset(i, -i));
                } else {
                    if (BoardData[x + i][y - i].getChessColor() != BoardData[x][y].getChessColor()) {
                        list.add(getSource().offset(i, -i));
                    }
                    break;
                }
            }
        }
     
        for (int i = -1;i >= -7;i--) {
            if (getSource().offset(-i,i) != null){
                if (BoardData[x - i][y + i].name == '_') {
                    list.add(getSource().offset(-i, i));
                } else {
                    if (BoardData[x - i][y + i].getChessColor() != BoardData[x][y].getChessColor()) {
                        list.add(getSource().offset(-i, i));
                    }
                    break;
                }
            }
        }
 
        for (int i = -1;i >= -7;i--) {
            if (getSource().offset(-i,0) != null){
                if (BoardData[x - i][y].name == '_') {
                    list.add(getSource().offset(-i, 0));
                } else {
                    if (BoardData[x - i][y].getChessColor() != BoardData[x][y].getChessColor()) {
                        list.add(getSource().offset(-i, 0));
                    }
                    break;
                }
            }
        }
  
        for (int i = -1;i >= -7;i--) {
            if (getSource().offset(-i,-i) != null){
                if (BoardData[x - i][y - i].name == '_') {
                    list.add(getSource().offset(-i, -i));
                } else {
                    if (BoardData[x - i][y - i].getChessColor() != BoardData[x][y].getChessColor()) {
                        list.add(getSource().offset(-i, -i));
                    }
                    break;
                }
            }
        }
  
        for (int i = -1;i >= -7;i--) {
            if (getSource().offset(0,i) != null){
                if (BoardData[x][y + i].name == '_') {
                    list.add(getSource().offset(0, i));
                } else {
                    if (BoardData[x][y + i].getChessColor() != BoardData[x][y].getChessColor()) {
                        list.add(getSource().offset(0, i));
                    }
                    break;
                }
            }
        }
    
        for (int i = -1;i >= -7;i--) {
            if (getSource().offset(0,-i) != null){
                if (BoardData[x][y - i].name == '_') {
                    list.add(getSource().offset(0, -i));
                } else {
                    if (BoardData[x][y - i].getChessColor() != BoardData[x][y].getChessColor()) {
                        list.add(getSource().offset(0, -i));
                    }
                    break;
                }
            }
        }

        return list;
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}


class KnightChessComponent extends ChessComponent {
    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super.setSource(source);
        super.setChessColor(chessColor);
        this.name = name;
    }

    public KnightChessComponent(int x,int y){
        ChessboardPoint source = new ChessboardPoint(x,y);
        super.setSource(source);
    }

    public List<ChessboardPoint> canMoveTo() {
        
        ConcreteChessGame ccGame=new ConcreteChessGame();
        ChessComponent[][] BoardData=ccGame.GetChessBoard();

        ArrayList<ChessboardPoint> list = new ArrayList<>();
        int x = getSource().getX();
        int y = getSource().getY();
        for (int i = -2;i < 0;i++){
            if (getSource().offset(i,-(3+i)) != null){
                if (BoardData[x+i][y-(3+i)].getChessColor() != BoardData[x][y].getChessColor()){
                    list.add(getSource().offset(i,-(3+i)));
                }
            }
            if (getSource().offset(i,(3+i)) != null){
                if (BoardData[x+i][y+(3+i)].getChessColor() != BoardData[x][y].getChessColor()){
                    list.add(getSource().offset(i,(3+i)));
                }
            }
        }
        for (int i = 1; i < 3;i++){
            if (getSource().offset(i,-(3-i)) != null){
                if (BoardData[x+i][y-(3-i)].getChessColor() != BoardData[x][y].getChessColor()){
                    list.add(getSource().offset(i,-(3-i)));
                }
            }
            if (getSource().offset(i,(3-i)) != null){
                if (BoardData[x+i][y+(3-i)].getChessColor() != BoardData[x][y].getChessColor()){
                    list.add(getSource().offset(i,(3-i)));
                }
            }
        }

        return list;
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

}


class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(ChessboardPoint source,ChessColor chessColor,char name){
        super.setSource(source);
        super.setChessColor(chessColor);
        this.name = name;
    }

    public BishopChessComponent(int x,int y){
        ChessboardPoint source = new ChessboardPoint(x,y);
        super.setSource(source);
    }

    public List<ChessboardPoint> canMoveTo(){
      
        ConcreteChessGame ccGame=new ConcreteChessGame();
        ChessComponent[][] BoardData=ccGame.GetChessBoard();

        ArrayList<ChessboardPoint> list = new ArrayList<>();
        int x = getSource().getX();
        int y = getSource().getY();
        for (int i = -1;i > -7;i--){
            if (getSource().offset(i,i) != null){
                if (BoardData[x+i][y+i].name == '_'){
                    list.add(getSource().offset(i,i));
                }
                else{
                    if (BoardData[x+i][y+i].getChessColor() != BoardData[x][y].getChessColor()){
                        list.add(getSource().offset(i,i));
                    }
                    break;
                }
            }
        }
        for (int i = -1;i >= -7;i--){
            if (getSource().offset(i,-i) != null){
                if (BoardData[x+i][y-i].name == '_'){
                    list.add(getSource().offset(i,-i));
                }
                else{
                    if (BoardData[x+i][y-i].getChessColor() != BoardData[x][y].getChessColor()){
                        list.add(getSource().offset(i,-i));
                    }
                    break;
                }
            }
        }
        for (int i = 1;i <= 7;i++){
            if (getSource().offset(i,-i) != null){
                if (BoardData[x+i][y-i].name == '_'){
                    list.add(getSource().offset(i,-i));
                }
                else{
                    if (BoardData[x+i][y-i].getChessColor() != BoardData[x][y].getChessColor()){
                        list.add(getSource().offset(i,-i));
                    }
                    break;
                }
            }
        }
        for (int i = 1;i <= 7;i++){
            if (getSource().offset(i,i) != null){
                if (BoardData[x+i][y+i].name == '_'){
                    list.add(getSource().offset(i,i));
                }
                else{
                    if (BoardData[x+i][y+i].getChessColor() != BoardData[x][y].getChessColor()){
                        list.add(getSource().offset(i,i));
                    }
                    break;
                }
            }
        }

        return list;
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}


class RookChessComponent extends ChessComponent {
    public RookChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super.setSource(source);
        super.setChessColor(chessColor);
        this.name = name;
    }

    public RookChessComponent(int x, int y) {
        ChessboardPoint source = new ChessboardPoint(x, y);
        super.setSource(source);
    }

    public List<ChessboardPoint> canMoveTo() {
     
        ConcreteChessGame ccGame=new ConcreteChessGame();
        ChessComponent[][] BoardData=ccGame.GetChessBoard();

        ArrayList<ChessboardPoint> list = new ArrayList<>();
        int x = getSource().getX();
        int y = getSource().getY();
    
        for (int i = -1;i >= -7;i--) {
            if (getSource().offset(0,i) != null){
                if (BoardData[x][y + i].name == '_') {
                    list.add(getSource().offset(0, i));
                } else {
                    if (BoardData[x][y + i].getChessColor() != BoardData[x][y].getChessColor()) {
                        list.add(getSource().offset(0, i));
                    }
                    break;
                }
            }
        }
      
        for (int i = -1;i >= -7;i--) {
            if (getSource().offset(0,-i) != null){
                if (BoardData[x][y - i].name == '_') {
                    list.add(getSource().offset(0, -i));
                } else {
                    if (BoardData[x][y - i].getChessColor() != BoardData[x][y].getChessColor()) {
                        list.add(getSource().offset(0, -i));
                    }
                    break;
                }
            }
        }
 
        for (int i = -1;i >= -7;i--){
            if (getSource().offset(i,0) != null){
                if (BoardData[x+i][y].name == '_'){
                    list.add(getSource().offset(i,0));
                }
                else{
                    if (BoardData[x+i][y].getChessColor() != BoardData[x][y].getChessColor()){
                        list.add(getSource().offset(i,0));
                    }
                    break;
                }
            }
        }
       
        for (int i = -1;i >= -7;i--) {
            if (getSource().offset(-i,0) != null){
                if (BoardData[x - i][y].name == '_') {
                    list.add(getSource().offset(-i, 0));
                } else {
                    if (BoardData[x - i][y].getChessColor() != BoardData[x][y].getChessColor()) {
                        list.add(getSource().offset(-i, 0));
                    }
                    break;
                }
            }
        }

        return list;
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}


class PawnChessComponent extends ChessComponent {
    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super.setSource(source);
        super.setChessColor(chessColor);
        this.name = name;
    }

    public PawnChessComponent(int x,int y){
        ChessboardPoint source = new ChessboardPoint(x,y);
        super.setSource(source);
    }

    public List<ChessboardPoint> canMoveTo() {
       
        ConcreteChessGame ccGame=new ConcreteChessGame();
        ChessComponent[][] BoardData=ccGame.GetChessBoard();

        ArrayList<ChessboardPoint> list = new ArrayList<>();
        int x = getSource().getX();
        int y = getSource().getY();
        if (getChessColor() == ChessColor.BLACK && getSource().getX() == 1) {
            if (getSource().offset(1,0) != null){
                if (BoardData[x + 1][y].name == '_') {
                    list.add(getSource().offset(1, 0));
                    if (getSource().offset(2,0) != null){
                        if (BoardData[x + 2][y].name == '_') {
                            list.add(getSource().offset(2, 0));
                        }
                    }
                }
            }
            for (int i = -1; i < 2; i += 2) {
                if (getSource().offset(1,i) != null){
                    if (BoardData[x + 1][y + i].name != '_' && BoardData[x + 1][y + i].getChessColor() != BoardData[x][y].getChessColor()) {
                        list.add(getSource().offset(1, i));
                    }
                }
            }

        } else if (getChessColor() == ChessColor.BLACK && getSource().getX() != 1) {
            if (getSource().offset(1,0) != null){
                if (BoardData[x + 1][y].name == '_') {
                    list.add(getSource().offset(1, 0));
                }
            }
            for (int i = -1; i < 2; i += 2) {
                if (getSource().offset(1,i) != null){
                    if (BoardData[x + 1][y + i].name != '_' && BoardData[x + 1][y + i].getChessColor() != BoardData[x][y].getChessColor()) {
                        list.add(getSource().offset(1, i));
                    }
                }
            }
        } else if (getChessColor() == ChessColor.WHITE && getSource().getX() == 6) {
            if (getSource().offset(-1,0) != null){
                if (BoardData[x - 1][y].name == '_') {
                    list.add(getSource().offset(-1, 0));
                    if (getSource().offset(-2,0) != null){
                        if (BoardData[x - 2][y].name == '_') {
                            list.add(getSource().offset(-2, 0));
                        }
                    }
                }
            }
            for (int i = -1; i < 2; i += 2) {
                if (getSource().offset(-1,i) != null){
                    if (BoardData[x - 1][y + i].name != '_' && BoardData[x - 1][y + i].getChessColor() != BoardData[x][y].getChessColor()) {
                        list.add(getSource().offset(-1, i));
                    }
                }
            }
        }

        else {
            if (getSource().offset(-1,0) != null){
                if (BoardData[x - 1][y].name == '_') {
                    list.add(getSource().offset(-1, 0));
                }
            }
            for (int i = -1; i < 2; i += 2) {
                if (getSource().offset(-1,i) != null){
                    if (BoardData[x - 1][y + i].name != '_' && BoardData[x - 1][y + i].getChessColor() != BoardData[x][y].getChessColor()) {
                        list.add(getSource().offset(-1, i));
                    }
                }
            }
        }

        return list;
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}

class EmptySlotComponent extends ChessComponent {
    public EmptySlotComponent(ChessboardPoint source,ChessColor chessColor,char name){
        super.setSource(source);
        super.setChessColor(ChessColor.NONE);
        this.name = name;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}