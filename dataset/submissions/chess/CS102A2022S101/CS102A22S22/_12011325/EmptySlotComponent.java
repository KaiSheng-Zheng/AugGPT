import java.util.ArrayList;
import java.util.List;
public class EmptySlotComponent extends ChessComponent{
    public EmptySlotComponent(ChessboardPoint source){
        this.setSource(source);
        this.setChessColor(ChessColor.NONE);
        this.name = '_';
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}
class KingChessComponent extends ChessComponent {
    private ConcreteChessGame concreteChessGame;
    public KingChessComponent(ChessboardPoint source, ChessColor chessColor,ConcreteChessGame concreteChessGame) {
        this.setSource(source);
        this.setChessColor(chessColor);
        this.concreteChessGame = concreteChessGame;
        if (chessColor == ChessColor.BLACK) {
            this.name = 'K';
        } else if (chessColor == ChessColor.WHITE) {
            this.name = 'k';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> can = new ArrayList<>();
        int x = this.getSource().getX();
        int y = this.getSource().getY();
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y-1; j <= y + 1; j++) {
                if (concreteChessGame.moveChess1(x, y, i, j )){
                    can.add(new ChessboardPoint(i,j));
                }
            }
        }
        return can;
    }
}
class KnightChessComponent extends ChessComponent {
    private ConcreteChessGame concreteChessGame;
    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, ConcreteChessGame concreteChessGame) {
        this.concreteChessGame = concreteChessGame;
        this.setSource(source);
        this.setChessColor(chessColor);
        if (chessColor == ChessColor.BLACK) {
            this.name = 'N';
        } else if (chessColor == ChessColor.WHITE) {
            this.name = 'n';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> can = new ArrayList<>();
        int x = this.getSource().getX();
        int y = this.getSource().getY();
        for (int i = x - 2; i <= x + 2; i++) {
            if (Math.abs(i - x) == 2) {
                if (concreteChessGame.moveChess1(x, y, i, y - 1)) {
                    can.add(new ChessboardPoint(i, y - 1));
                }
                if (concreteChessGame.moveChess1(x, y, i, y + 1)) {
                    can.add(new ChessboardPoint(i, y + 1));
                }
            } else if (Math.abs(i - x) == 1) {
                if (concreteChessGame.moveChess1(x, y, i, y - 2)) {
                    can.add(new ChessboardPoint(i, y - 2));
                } if (concreteChessGame.moveChess1(x, y, i, y + 2)) {
                    can.add(new ChessboardPoint(i, y + 2));
                }
            }
        }
        return can;
    }
}
class PawnChessComponent extends ChessComponent {
    private ConcreteChessGame concreteChessGame;

    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, ConcreteChessGame concreteChessGame) {
        this.setSource(source);
        this.setChessColor(chessColor);
        this.concreteChessGame = concreteChessGame;
        if (chessColor == ChessColor.BLACK) {
            this.name = 'P';
        } else if (chessColor == ChessColor.WHITE) {
            this.name = 'p';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> can = new ArrayList<>();
        int x = this.getSource().getX();
        int y = this.getSource().getY();
        if (this.getChessColor()==ChessColor.BLACK) {
            if (concreteChessGame.moveChess1(x,y,x+1,y-1)){
                if (concreteChessGame.getChess(x+1,y-1).getChessColor()!=ChessColor.NONE){
                    can.add(new ChessboardPoint(x+1,y-1));
                }
            }
            if (concreteChessGame.moveChess1(x,y,x+1,y+1)){
                if (concreteChessGame.getChess(x+1,y+1).getChessColor()!=ChessColor.NONE){
                    can.add(new ChessboardPoint(x+1,y+1));
                }
            }
            if (x==1){
                if (concreteChessGame.getChess(x+1,y).getChessColor()==ChessColor.NONE){
                    can.add(new ChessboardPoint(x+1,y));
                    if (concreteChessGame.getChess(x+2,y).getChessColor()==ChessColor.NONE){
                        can.add(new ChessboardPoint(x+2,y));
                    }
                }
            }else{
                if (concreteChessGame.moveChess1(x,y,x+1,y)){
                    if (concreteChessGame.getChess(x+1,y).getChessColor()==ChessColor.NONE) {
                        can.add(new ChessboardPoint(x + 1, y));
                    }
                }
            }
        } else if (this.getChessColor()==ChessColor.WHITE) {
            if (concreteChessGame.moveChess1(x,y,x-1,y-1)){
                if (concreteChessGame.getChess(x-1,y-1).getChessColor()!=ChessColor.NONE){
                    can.add(new ChessboardPoint(x-1,y-1));
                }
            }
            if (concreteChessGame.moveChess1(x,y,x-1,y+1)){
                if (concreteChessGame.getChess(x-1,y+1).getChessColor()!=ChessColor.NONE){
                    can.add(new ChessboardPoint(x-1,y+1));
                }
            }
            if (x==6){
                if (concreteChessGame.getChess(x-1,y).getChessColor()==ChessColor.NONE){
                    can.add(new ChessboardPoint(x-1,y));
                    if (concreteChessGame.getChess(x-2,y).getChessColor()==ChessColor.NONE){
                        can.add(new ChessboardPoint(x-2,y));
                    }
                }
            }else{
                if (concreteChessGame.moveChess1(x,y,x-1,y)){
                    if (concreteChessGame.getChess(x-1,y).getChessColor()==ChessColor.NONE) {
                        can.add(new ChessboardPoint(x-1, y));
                    }
                }
            }
        }
        return can;
    }
}

class QueenChessComponent extends ChessComponent{
    private ConcreteChessGame concreteChessGame;
    public QueenChessComponent(ChessboardPoint source,ChessColor chessColor,ConcreteChessGame concreteChessGame){
        this.setSource(source);
        this.setChessColor(chessColor);
        this.concreteChessGame = concreteChessGame;
        if (chessColor==ChessColor.BLACK){
            this.name = 'Q';
        }else if (chessColor==ChessColor.WHITE){
            this.name = 'q';
        }
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> can = new ArrayList<>();
        int x = this.getSource().getX();
        int y = this.getSource().getY();
        int []counter = {0,0,0,0,0,0,0,0};
        for (int i=x+1;i<=7;i++) {
            if (concreteChessGame.getChess(i,y).getChessColor()==ChessColor.NONE&&counter[0]==0) {
                can.add(new ChessboardPoint(i, y));
            }else{
                counter[0]=counter[0]+1;
                if (this.getChessColor()!=concreteChessGame.getChess(i,y).getChessColor()&&counter[0]==1){
                    can.add(new ChessboardPoint(i,y));
                }
            }
        }
        for (int i=x-1;i>=0;i--){
            if (concreteChessGame.getChess(i,y).getChessColor()==ChessColor.NONE&&counter[1]==0) {
                can.add(new ChessboardPoint(i, y));
            }else {
                counter[1]=counter[1]+1;
                if (this.getChessColor()!=concreteChessGame.getChess(i,y).getChessColor()&&counter[1]==1){
                    can.add(new ChessboardPoint(i,y));
                }
            }
        }
        for (int i=y+1;i<=7;i++) {
            if (concreteChessGame.getChess(x,i).getChessColor()==ChessColor.NONE&&counter[2]==0) {
                can.add(new ChessboardPoint(x, i));
            }else {
                counter[2]=counter[2]+1;
                if (this.getChessColor()!=concreteChessGame.getChess(x,i).getChessColor()&&counter[2]==1){
                    can.add(new ChessboardPoint(x,i));
                }
            }
        }
        for (int i=y-1;i>=0;i--) {
            if (concreteChessGame.getChess(x,i).getChessColor()==ChessColor.NONE&&counter[3]==0) {
                can.add(new ChessboardPoint(x, i));
            }else {
                counter[3]=counter[3]+1;
                if (this.getChessColor()!=concreteChessGame.getChess(x,i).getChessColor()&&counter[3]==1){
                    can.add(new ChessboardPoint(x,i));
                }
            }
        }
        for (int i=0;i<=7;i++){
            if (concreteChessGame.moveChess2(x, y, x+i, y+i)){
                if (concreteChessGame.getChess(x+i, y+i).getChessColor() == ChessColor.NONE&&counter[4]==0){
                    can.add(new ChessboardPoint(x+i,y+i));
                }else if (counter[4]==0){
                    counter[4] =counter[4]+1;
                    if (this.getChessColor()!=concreteChessGame.getChess(x+i,y+i).getChessColor()){
                        can.add(new ChessboardPoint(x+i,y+i));
                    }
                }
            }
        }
        for (int i=0;i>=-7;i--){
            if (concreteChessGame.moveChess2(x, y, x+i, y+i)){
                if (concreteChessGame.getChess(x+i, y+i).getChessColor() == ChessColor.NONE&&counter[5]==0){
                    can.add(new ChessboardPoint(x+i,y+i));
                }else if (counter[5]==0){
                    counter[5] =counter[5]+1;
                    if (this.getChessColor()!=concreteChessGame.getChess(x+i,y+i).getChessColor()){
                        can.add(new ChessboardPoint(x+i,y+i));
                    }
                }
            }
        }
        for (int i=0;i<=7;i++){
            if (concreteChessGame.moveChess2(x, y, x+i, y-i)){
                if (concreteChessGame.getChess(x+i, y-i).getChessColor() == ChessColor.NONE&&counter[6]==0){
                    can.add(new ChessboardPoint(x+i,y-i));
                }else if (counter[6]==0){
                    counter[6] =counter[6]+1;
                    if (this.getChessColor()!=concreteChessGame.getChess(x+i,y-i).getChessColor()){
                        can.add(new ChessboardPoint(x+i,y-i));
                    }
                }
            }
        }
        for (int i=0;i>=-7;i--){
            if (concreteChessGame.moveChess2(x, y, x+i, y-i)){
                if (concreteChessGame.getChess(x+i, y-i).getChessColor() == ChessColor.NONE&&counter[7]==0){
                    can.add(new ChessboardPoint(x+i,y-i));
                }else if (counter[7]==0){
                    counter[7] =counter[7]+1;
                    if (this.getChessColor()!=concreteChessGame.getChess(x+i,y-i).getChessColor()){
                        can.add(new ChessboardPoint(x+i,y-i));
                    }
                }
            }
        }
        return can;
    }
}
class RookChessComponent extends ChessComponent {
    private ConcreteChessGame concreteChessGame;

    public RookChessComponent(ChessboardPoint source, ChessColor chessColor, ConcreteChessGame concreteChessGame) {
        this.setSource(source);
        this.setChessColor(chessColor);
        this.concreteChessGame = concreteChessGame;
        if (chessColor == ChessColor.BLACK) {
            this.name = 'R';
        } else if (chessColor == ChessColor.WHITE) {
            this.name = 'r';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> can = new ArrayList<>();
        int x = this.getSource().getX();
        int y = this.getSource().getY();
        int[] counter = {0, 0, 0, 0};
        for (int i = x+1; i <= 7; i++) {
            if (concreteChessGame.getChess(i, y).getChessColor() == ChessColor.NONE && counter[0] == 0) {
                can.add(new ChessboardPoint(i, y));
            } else {
                counter[0] = counter[0] + 1;
                if (this.getChessColor() != concreteChessGame.getChess(i, y).getChessColor() && counter[0] == 1) {
                    can.add(new ChessboardPoint(i, y));
                }
            }
        }
        for (int i = x-1; i >= 0; i--) {
            if (concreteChessGame.getChess(i, y).getChessColor() == ChessColor.NONE && counter[1] == 0) {
                can.add(new ChessboardPoint(i, y));
            } else {
                counter[1] = counter[1] + 1;
                if (this.getChessColor() != concreteChessGame.getChess(i, y).getChessColor() && counter[1] == 1) {
                    can.add(new ChessboardPoint(i, y));
                }
            }
        }
        for (int i = y+1; i <= 7; i++) {
            if (concreteChessGame.getChess(x, i).getChessColor() == ChessColor.NONE && counter[2] == 0) {
                can.add(new ChessboardPoint(x, i));
            } else {
                counter[2] = counter[2] + 1;
                if (this.getChessColor() != concreteChessGame.getChess(x, i).getChessColor() && counter[2] == 1) {
                    can.add(new ChessboardPoint(x, i));
                }
            }
        }
        for (int i = y-1; i >= 0; i--) {
            if (concreteChessGame.getChess(x, i).getChessColor() == ChessColor.NONE && counter[3] == 0) {
                can.add(new ChessboardPoint(x, i));
            } else {
                counter[3] = counter[3] + 1;
                if (this.getChessColor() != concreteChessGame.getChess(x, i).getChessColor() && counter[3] == 1) {
                    can.add(new ChessboardPoint(x, i));
                }
            }
        }
        return can;
    }
}
class BishopChessComponent extends ChessComponent{
    private ConcreteChessGame concreteChessGame;
    public BishopChessComponent(ChessboardPoint source,ChessColor chessColor,ConcreteChessGame concreteChessGame){
        this.setSource(source);
        this.setChessColor(chessColor);
        this.concreteChessGame= concreteChessGame;
        if (chessColor==ChessColor.BLACK){
            this.name = 'B';
        }else if (chessColor==ChessColor.WHITE){
            this.name = 'b';
        }
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> can = new ArrayList<>();
        int x = this.getSource().getX();
        int y = this.getSource().getY();
        int []counter = {0,0,0,0};
        for (int i=0;i<=7;i++){
            if (concreteChessGame.moveChess2(x, y, x+i, y+i)){
                if (concreteChessGame.getChess(x+i, y+i).getChessColor() == ChessColor.NONE&&counter[0]==0){
                    can.add(new ChessboardPoint(x+i,y+i));
                }else if (counter[0]==0){
                    counter[0] =counter[0]+1;
                    if (this.getChessColor()!=concreteChessGame.getChess(x+i,y+i).getChessColor()){
                        can.add(new ChessboardPoint(x+i,y+i));
                    }
                }
            }
        }
        for (int i=0;i>=-7;i--){
            if (concreteChessGame.moveChess2(x, y, x+i, y+i)){
                if (concreteChessGame.getChess(x+i, y+i).getChessColor() == ChessColor.NONE&&counter[1]==0){
                    can.add(new ChessboardPoint(x+i,y+i));
                }else if (counter[1]==0){
                    counter[1] =counter[1]+1;
                    if (this.getChessColor()!=concreteChessGame.getChess(x+i,y+i).getChessColor()){
                        can.add(new ChessboardPoint(x+i,y+i));
                    }
                }
            }
        }
        for (int i=0;i<=7;i++){
            if (concreteChessGame.moveChess2(x, y, x+i, y-i)){
                if (concreteChessGame.getChess(x+i, y-i).getChessColor() == ChessColor.NONE&&counter[2]==0){
                    can.add(new ChessboardPoint(x+i,y-i));
                }else if (counter[2]==0){
                    counter[2] =counter[2]+1;
                    if (this.getChessColor()!=concreteChessGame.getChess(x+i,y-i).getChessColor()){
                        can.add(new ChessboardPoint(x+i,y-i));
                    }
                }
            }
        }
        for (int i=0;i>=-7;i--){
            if (concreteChessGame.moveChess2(x, y, x+i, y-i)){
                if (concreteChessGame.getChess(x+i, y-i).getChessColor() == ChessColor.NONE&&counter[3]==0){
                    can.add(new ChessboardPoint(x+i,y-i));
                }else if (counter[3]==0){
                    counter[3] =counter[3]+1;
                    if (this.getChessColor()!=concreteChessGame.getChess(x+i,y-i).getChessColor()){
                        can.add(new ChessboardPoint(x+i,y-i));
                    }
                }
            }
        }
        return can;
    }
}







