import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> output = new ArrayList<>();
        int x = this.getSource().getX() + 1;
        int y = this.getSource().getY();
        while(this.getChessComponents()[x][y] instanceof EmptySlotComponent && x<=7 && y<=7 && x>=0 && y>=0){
            output.add(new ChessboardPoint(x,y));
            x++;
        }
        if(x<=7 && y<=7 && x>=0 && y>=0){
            output.add(new ChessboardPoint(x,y));
        }

        x = this.getSource().getX() - 1;
        while(this.getChessComponents()[x][y] instanceof EmptySlotComponent && x<=7 && y<=7 && x>=0 && y>=0){
            output.add(new ChessboardPoint(x,y));
            x--;
        }
        if(x<=7 && y<=7 && x>=0 && y>=0){
            output.add(new ChessboardPoint(x,y));
        }

        x = this.getSource().getX();

        y = this.getSource().getY() + 1;
        while(this.getChessComponents()[x][y] instanceof EmptySlotComponent && x<=7 && y<=7 && x>=0 && y>=0){
            output.add(new ChessboardPoint(x,y));
            y++;
        }
        if(x<=7 && y<=7 && x>=0 && y>=0){
            output.add(new ChessboardPoint(x,y));
        }
        y = this.getSource().getY() - 1;
        while(this.getChessComponents()[x][y] instanceof EmptySlotComponent && x<=7 && y<=7 && x>=0 && y>=0){
            output.add(new ChessboardPoint(x,y));
            y--;
        }
        if(x<=7 && y<=7 && x>=0 && y>=0){
            output.add(new ChessboardPoint(x,y));
        }

        x = this.getSource().getX() + 1;
        y = this.getSource().getY() + 1;
        while(this.getChessComponents()[x][y] instanceof EmptySlotComponent && x<=7 && y<=7 && x>=0 && y>=0){
            output.add(new ChessboardPoint(x,y));
            x++;
            y++;
        }
        if(x<=7 && y<=7 && x>=0 && y>=0){
            output.add(new ChessboardPoint(x,y));
        }
        x = this.getSource().getX() - 1;
        y = this.getSource().getY() + 1;
        while(this.getChessComponents()[x][y] instanceof EmptySlotComponent && x<=7 && y<=7 && x>=0 && y>=0){
            output.add(new ChessboardPoint(x,y));
            x--;
            y++;
        }
        if(x<=7 && y<=7 && x>=0 && y>=0){
            output.add(new ChessboardPoint(x,y));
        }
        x = this.getSource().getX() + 1;
        y = this.getSource().getY() - 1;
        while(this.getChessComponents()[x][y] instanceof EmptySlotComponent && x<=7 && y<=7 && x>=0 && y>=0){
            output.add(new ChessboardPoint(x,y));
            x++;
            y--;
        }
        if(x<=7 && y<=7 && x>=0 && y>=0){
            output.add(new ChessboardPoint(x,y));
        }
        x = this.getSource().getX() - 1;
        y = this.getSource().getY() - 1;
        while(this.getChessComponents()[x][y] instanceof EmptySlotComponent && x<=7 && y<=7 && x>=0 && y>=0){
            output.add(new ChessboardPoint(x,y));
            x--;
            y--;
        }
        if(x<=7 && y<=7 && x>=0 && y>=0){
            output.add(new ChessboardPoint(x,y));
        }
        return output;
    }

}
