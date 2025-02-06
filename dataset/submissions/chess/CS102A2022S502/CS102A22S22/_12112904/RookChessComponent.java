import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{

    public RookChessComponent(ChessboardPoint source,ChessColor chessColor,char name){
        super(source,chessColor,name);
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> a=new ArrayList<>();
        ChessComponent[][] c=super.getChessComponents();
        int block=0;
        int dymin=-super.getSource().getY();
        int dymax=7-super.getSource().getY();
        int dxmin=-super.getSource().getX();
        int dxmax=7-super.getSource().getX();
        if(super.getChessColor()==ChessColor.WHITE){

            for(int i=dymin;i<0;i++){
                if(i!=-1){
                for(int j=-1;j>i;j--){
                    if(!(c[getSource().getX()][getSource().getY()+j] instanceof EmptySlotComponent)){
                        block++;
                        break;
                    }
                }
                if(block==0&&!Character.isLowerCase(c[getSource().getX()][getSource().getY()+i].getName())){
                a.add(super.getSource().offset(0,i));
                }
                }else {
                    if(!Character.isLowerCase(c[getSource().getX()][getSource().getY()+i].getName())){
                        a.add(super.getSource().offset(0,i));
                    }
                }
                block=0;
            }


            for(int i=dymax;i>0;i--){
                if(i!=1){
                for(int j=1;j<i;j++){
                    if(!(c[getSource().getX()][getSource().getY()+j] instanceof EmptySlotComponent)){
                        block++;
                        break;
                    }
                }
                if(block==0&&!Character.isLowerCase(c[getSource().getX()][getSource().getY()+i].getName())){
                a.add(super.getSource().offset(0,i));
                }
                }else {
                    if(!Character.isLowerCase(c[getSource().getX()][getSource().getY()+i].getName())){
                        a.add(super.getSource().offset(0,i));
                    }
                }
                block=0;
            }


            for(int i=dxmin;i<0;i++){
                if(i!=-1){
                for(int j=-1;j>i;j--){
                    if(!(c[getSource().getX()+j][getSource().getY()] instanceof EmptySlotComponent)){
                        block++;
                        break;
                    }
                }
                if(block==0&&!Character.isLowerCase(c[getSource().getX()+i][getSource().getY()].getName())){
                a.add(super.getSource().offset(i,0));
                }
                }else {
                    if(!Character.isLowerCase(c[getSource().getX()+i][getSource().getY()].getName())){
                        a.add(super.getSource().offset(i,0));
                    }
                }
                block=0;
            }


            for(int i=dxmax;i>0;i--){
                if(i!=1){
                for(int j=1;j<i;j++){
                    if(!(c[getSource().getX()+j][getSource().getY()] instanceof EmptySlotComponent)){
                        block++;
                        break;
                    }
                }
                if(block==0&&!Character.isLowerCase(c[getSource().getX()+i][getSource().getY()].getName())){
                a.add(super.getSource().offset(i,0));
                }
                }else {
                    if(!Character.isLowerCase(c[getSource().getX()+i][getSource().getY()].getName())){
                        a.add(super.getSource().offset(i,0));
                    }
                }
                block=0;
            }
        }else {

            for(int i=dymin;i<0;i++){
                if(i!=-1){
                    for(int j=-1;j>i;j--){
                        if(!(c[getSource().getX()][getSource().getY()+j] instanceof EmptySlotComponent)){
                            block++;
                            break;
                        }
                    }
                    if(block==0&&!Character.isUpperCase(c[getSource().getX()][getSource().getY()+i].getName())){
                        a.add(super.getSource().offset(0,i));
                    }
                }else {
                    if(!Character.isUpperCase(c[getSource().getX()][getSource().getY()+i].getName())){
                        a.add(super.getSource().offset(0,i));
                    }
                }
                block=0;
            }


            for(int i=dymax;i>0;i--){
                if(i!=1){
                    for(int j=1;j<i;j++){
                        if(!(c[getSource().getX()][getSource().getY()+j] instanceof EmptySlotComponent)){
                            block++;
                            break;
                        }
                    }
                    if(block==0&&!Character.isUpperCase(c[getSource().getX()][getSource().getY()+i].getName())){
                        a.add(super.getSource().offset(0,i));
                    }
                }else {
                    if(!Character.isUpperCase(c[getSource().getX()][getSource().getY()+i].getName())){
                        a.add(super.getSource().offset(0,i));
                    }
                }
                block=0;
            }


            for(int i=dxmin;i<0;i++){
                if(i!=-1){
                    for(int j=-1;j>i;j--){
                        if(!(c[getSource().getX()+j][getSource().getY()] instanceof EmptySlotComponent)){
                            block++;
                            break;
                        }
                    }
                    if(block==0&&!Character.isUpperCase(c[getSource().getX()+i][getSource().getY()].getName())){
                        a.add(super.getSource().offset(i,0));
                    }
                }else {
                    if(!Character.isUpperCase(c[getSource().getX()+i][getSource().getY()].getName())){
                        a.add(super.getSource().offset(i,0));
                    }
                }
                block=0;
            }


            for(int i=dxmax;i>0;i--){
                if(i!=1){
                    for(int j=1;j<i;j++){
                        if(!(c[getSource().getX()+j][getSource().getY()] instanceof EmptySlotComponent)){
                            block++;
                            break;
                        }
                    }
                    if(block==0&&!Character.isUpperCase(c[getSource().getX()+i][getSource().getY()].getName())){
                        a.add(super.getSource().offset(i,0));
                    }
                }else {
                    if(!Character.isUpperCase(c[getSource().getX()+i][getSource().getY()].getName())){
                        a.add(super.getSource().offset(i,0));
                    }
                }
                block=0;
            }
        }
        return a;
    }
}