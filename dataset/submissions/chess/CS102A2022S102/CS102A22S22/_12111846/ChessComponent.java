import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class ChessComponent {
    protected ChessboardPoint source;
    protected ChessColor chessColor;
    protected char name;
    protected ChessComponent[][] chessComponents;

    public ChessComponent(){};

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public void setName(char name) {
        this.name = name;
    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    public char getName() {
        return name;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public abstract List<ChessboardPoint> canMoveTo();

    public String toString() {
        return String.valueOf(this.name);
    }

    public void removeSameColor(List<ChessboardPoint> array){
        List<Integer> index = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            ChessColor color = chessComponents[array.get(i).getX()][array.get(i).getY()].chessColor;
            if(color.equals(chessColor)){index.add(i);}
        }
        for (int i = 0; i < index.size(); i++) {
            array.remove(index.get(i)-i);
        }
    }
}

class KingChessComponent extends ChessComponent{
    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> array = new ArrayList<>();
        array.add(source.offset(1,0));
        array.add(source.offset(-1,0));
        array.add(source.offset(0,1));
        array.add(source.offset(0,-1));
        array.add(source.offset(1,1));
        array.add(source.offset(1,-1));
        array.add(source.offset(-1,1));
        array.add(source.offset(-1,-1));
        array.removeAll(Collections.singleton(null));
        removeSameColor(array);
        return array;
    }
}

class QueenChessComponent extends ChessComponent{
    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> array = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            ChessboardPoint point = source.offset(i,0);
            if(point==null)break;
            ChessColor color = chessComponents[point.getX()][point.getY()].getChessColor();
            if(!color.equals(ChessColor.NONE)){
                if(!color.equals(chessComponents[source.getX()][source.getY()].chessColor)){
                    array.add(point);
                }break;
            }else{
                array.add(point);
            }
        }
        for (int i = 1; i <= 8; i++) {
            ChessboardPoint point = source.offset(-i,0);
            if(point==null)break;
            ChessColor color = chessComponents[point.getX()][point.getY()].getChessColor();
            if(!color.equals(ChessColor.NONE)){
                if(!color.equals(chessComponents[source.getX()][source.getY()].chessColor)){
                    array.add(point);
                }break;
            }else{
                array.add(point);
            }
        }
        for (int i = 1; i <= 8; i++) {
            ChessboardPoint point = source.offset(0,i);
            if(point==null)break;
            ChessColor color = chessComponents[point.getX()][point.getY()].getChessColor();
            if(!color.equals(ChessColor.NONE)){
                if(!color.equals(chessComponents[source.getX()][source.getY()].chessColor)){
                    array.add(point);
                }break;
            }else{
                array.add(point);
            }
        }
        for (int i = 1; i <= 8; i++) {
            ChessboardPoint point = source.offset(0,-i);
            if(point==null)break;
            ChessColor color = chessComponents[point.getX()][point.getY()].getChessColor();
            if(!color.equals(ChessColor.NONE)){
                if(!color.equals(chessComponents[source.getX()][source.getY()].chessColor)){
                    array.add(point);
                }break;
            }else{
                array.add(point);
            }
        }
        for (int i = 1; i <= 8; i++) {
            ChessboardPoint point = source.offset(i,i);
            if(point==null)break;
            ChessColor color = chessComponents[point.getX()][point.getY()].getChessColor();
            if(!color.equals(ChessColor.NONE)){
                if(!color.equals(chessComponents[source.getX()][source.getY()].chessColor)){
                    array.add(point);
                }break;
            }else{
                array.add(point);
            }
        }
        for (int i = 1; i <= 8; i++) {
            ChessboardPoint point = source.offset(i,-i);
            if(point==null)break;
            ChessColor color = chessComponents[point.getX()][point.getY()].getChessColor();
            if(!color.equals(ChessColor.NONE)){
                if(!color.equals(chessComponents[source.getX()][source.getY()].chessColor)){
                    array.add(point);
                }break;
            }else{
                array.add(point);
            }
        }
        for (int i = 1; i <= 8; i++) {
            ChessboardPoint point = source.offset(-i,i);
            if(point==null)break;
            ChessColor color = chessComponents[point.getX()][point.getY()].getChessColor();
            if(!color.equals(ChessColor.NONE)){
                if(!color.equals(chessComponents[source.getX()][source.getY()].chessColor)){
                    array.add(point);
                }break;
            }else{
                array.add(point);
            }
        }
        for (int i = 1; i <= 8; i++) {
            ChessboardPoint point = source.offset(-i,-i);
            if(point==null)break;
            ChessColor color = chessComponents[point.getX()][point.getY()].getChessColor();
            if(!color.equals(ChessColor.NONE)){
                if(!color.equals(chessComponents[source.getX()][source.getY()].chessColor)){
                    array.add(point);
                }break;
            }else{
                array.add(point);
            }
        }
        return array;
    }
}

class RookChessComponent extends ChessComponent{
    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> array = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            ChessboardPoint point = source.offset(i,0);
            if(point==null)break;
            ChessColor color = chessComponents[point.getX()][point.getY()].getChessColor();
            if(!color.equals(ChessColor.NONE)){
                if(!color.equals(chessComponents[source.getX()][source.getY()].chessColor)){
                    array.add(point);
                }break;
            }else{
                array.add(point);
            }
        }
        for (int i = 1; i <= 8; i++) {
            ChessboardPoint point = source.offset(-i,0);
            if(point==null)break;
            ChessColor color = chessComponents[point.getX()][point.getY()].getChessColor();
            if(!color.equals(ChessColor.NONE)){
                if(!color.equals(chessComponents[source.getX()][source.getY()].chessColor)){
                    array.add(point);
                }break;
            }else{
                array.add(point);
            }
        }
        for (int i = 1; i <= 8; i++) {
            ChessboardPoint point = source.offset(0,i);
            if(point==null)break;
            ChessColor color = chessComponents[point.getX()][point.getY()].getChessColor();
            if(!color.equals(ChessColor.NONE)){
                if(!color.equals(chessComponents[source.getX()][source.getY()].chessColor)){
                    array.add(point);
                }break;
            }else{
                array.add(point);
            }
        }
        for (int i = 1; i <= 8; i++) {
            ChessboardPoint point = source.offset(0,-i);
            if(point==null)break;
            ChessColor color = chessComponents[point.getX()][point.getY()].getChessColor();
            if(!color.equals(ChessColor.NONE)){
                if(!color.equals(chessComponents[source.getX()][source.getY()].chessColor)){
                    array.add(point);
                }break;
            }else{
                array.add(point);
            }
        }
        return array;
    }
}

class BishopChessComponent extends ChessComponent{
    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> array = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            ChessboardPoint point = source.offset(i,i);
            if(point==null)break;
            ChessColor color = chessComponents[point.getX()][point.getY()].getChessColor();
            if(!color.equals(ChessColor.NONE)){
                if(!color.equals(chessComponents[source.getX()][source.getY()].chessColor)){
                    array.add(point);
                }break;
            }else{
                array.add(point);
            }
        }
        for (int i = 1; i <= 8; i++) {
            ChessboardPoint point = source.offset(i,-i);
            if(point==null)break;
            ChessColor color = chessComponents[point.getX()][point.getY()].getChessColor();
            if(!color.equals(ChessColor.NONE)){
                if(!color.equals(chessComponents[source.getX()][source.getY()].chessColor)){
                    array.add(point);
                }break;
            }else{
                array.add(point);
            }
        }
        for (int i = 1; i <= 8; i++) {
            ChessboardPoint point = source.offset(-i,i);
            if(point==null)break;
            ChessColor color = chessComponents[point.getX()][point.getY()].getChessColor();
            if(!color.equals(ChessColor.NONE)){
                if(!color.equals(chessComponents[source.getX()][source.getY()].chessColor)){
                    array.add(point);
                }break;
            }else{
                array.add(point);
            }
        }
        for (int i = 1; i <= 8; i++) {
            ChessboardPoint point = source.offset(-i,-i);
            if(point==null)break;
            ChessColor color = chessComponents[point.getX()][point.getY()].getChessColor();
            if(!color.equals(ChessColor.NONE)){
                if(!color.equals(chessComponents[source.getX()][source.getY()].chessColor)){
                    array.add(point);
                }break;
            }else{
                array.add(point);
            }
        }
        return array;
    }
}

class KnightChessComponent extends ChessComponent{
    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> array = new ArrayList<>();
        array.add(source.offset(2,1));
        array.add(source.offset(2,-1));
        array.add(source.offset(-2,1));
        array.add(source.offset(-2,-1));
        array.add(source.offset(1,2));
        array.add(source.offset(-1,2));
        array.add(source.offset(1,-2));
        array.add(source.offset(-1,-2));
        array.removeAll(Collections.singleton(null));
        removeSameColor(array);
        return array;
    }
}

class PawnChessComponent extends ChessComponent{
    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> array = new ArrayList<>();
        switch (chessColor){
            case WHITE:
                ChessboardPoint point = source.offset(-1,0);
                if(point != null ){
                    char name = chessComponents[source.getX()-1][source.getY()].getName();
                    if(name - '_' == 0 ){
                        array.add(source.offset(-1,0));
                        if(source.getX() == 6 && chessComponents[source.getX()-2][source.getY()].getName() == '_'){
                        array.add(source.offset(-2,0));
                        }
                    }
                }
                ChessboardPoint point1 = source.offset(-1,-1);
                ChessboardPoint point2 = source.offset(-1,1);
                if(point2 != null){
                    if(chessComponents[source.getX()-1][source.getY()+1].getChessColor().equals(ChessColor.BLACK)){
                        array.add(source.offset(-1,1));
                    }
                }
                if(point1 != null){
                    if(chessComponents[source.getX()-1][source.getY()-1].getChessColor().equals(ChessColor.BLACK)){
                        array.add(source.offset(-1,-1));
                    }
                }break;


            case BLACK:
                ChessboardPoint Point = source.offset(1,0);
                if(Point != null ){
                    char name = chessComponents[source.getX()+1][source.getY()].getName();
                    if(name - '_' == 0){
                        array.add(source.offset(1,0));
                        if(source.getX() == 1 && chessComponents[source.getX()+2][source.getY()].getName()=='_'){
                            array.add(source.offset(2,0));
                        }
                    }
                }
                ChessboardPoint Point1 = source.offset(1,-1);
                ChessboardPoint Point2 = source.offset(1,1);
                if(Point2 != null){
                    if(chessComponents[source.getX()+1][source.getY()+1].getChessColor().equals(ChessColor.WHITE)){
                        array.add(source.offset(1,1));
                    }
                }
                if(Point1 != null){
                    if(chessComponents[source.getX()+1][source.getY()-1].getChessColor().equals(ChessColor.WHITE)){
                        array.add(source.offset(1,-1));
                    }
                }break;
        }

        array.removeAll(Collections.singleton(null));
        return array;
    }
}

class EmptySlotComponent extends ChessComponent{
    public List<ChessboardPoint> canMoveTo(){
        return new ArrayList<>();
    }
}
