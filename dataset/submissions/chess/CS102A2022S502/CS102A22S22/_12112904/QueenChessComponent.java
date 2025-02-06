import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    public QueenChessComponent(ChessboardPoint source,ChessColor chessColor,char name){
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
            int i1=0;
            int j1=0;
            int i2=1;
            int j2=1;
            while (i1<=dxmax&&j1<=dymax){
                while (i2<i1&&j2<j1){
                    if(!(c[getSource().getX()+i2][getSource().getY()+j2] instanceof EmptySlotComponent)){
                        block++;
                        break;
                    }
                    i2++;
                    j2++;
                }
                i2=1;
                j2=1;
                if(block==0&&!Character.isLowerCase(c[getSource().getX()+i1][getSource().getY()+j1].getName())){
                    a.add(getSource().offset(i1,j1));
                }
                i1++;
                j1++;
                block=0;
            }


            i1=0;
            j1=0;
            i2=-1;
            j2=-1;
            while (i1>=dxmin&&j1>=dymin){
                while (i2>i1&&j2>j1){
                    if(!(c[getSource().getX()+i2][getSource().getY()+j2] instanceof EmptySlotComponent)){
                        block++;
                        break;
                    }
                    i2--;
                    j2--;
                }
                i2=-1;
                j2=-1;
                if(block==0&&!Character.isLowerCase(c[getSource().getX()+i1][getSource().getY()+j1].getName())){
                    a.add(getSource().offset(i1,j1));
                }
                i1--;
                j1--;
                block=0;
            }


            i1=0;
            j1=0;
            i2=1;
            j2=-1;
            while (i1<=dxmax&&j1>=dymin){
                while (i2<i1&&j2>j1){
                    if(!(c[getSource().getX()+i2][getSource().getY()+j2] instanceof EmptySlotComponent)){
                        block++;
                        break;
                    }
                    i2++;
                    j2--;
                }
                i2=1;
                j2=-1;
                if(block==0&&!Character.isLowerCase(c[getSource().getX()+i1][getSource().getY()+j1].getName())){
                    a.add(getSource().offset(i1,j1));
                }
                i1++;
                j1--;
                block=0;
            }


            i1=0;
            j1=0;
            i2=-1;
            j2=1;
            while (i1>=dxmin&&j1<=dymax){
                while (i2>i1&&j2<j1){
                    if(!(c[getSource().getX()+i2][getSource().getY()+j2] instanceof EmptySlotComponent)){
                        block++;
                        break;
                    }
                    i2--;
                    j2++;
                }
                i2=-1;
                j2=1;
                if(block==0&&!Character.isLowerCase(c[getSource().getX()+i1][getSource().getY()+j1].getName())){
                    a.add(getSource().offset(i1,j1));
                }
                i1--;
                j1++;
                block=0;
            }
        }else {

            int i1=0;
            int j1=0;
            int i2=1;
            int j2=1;
            while (i1<=dxmax&&j1<=dymax){
                while (i2<i1&&j2<j1){
                    if(!(c[getSource().getX()+i2][getSource().getY()+j2] instanceof EmptySlotComponent)){
                        block++;
                        break;
                    }
                    i2++;
                    j2++;
                }
                i2=1;
                j2=1;
                if(block==0&&!Character.isUpperCase(c[getSource().getX()+i1][getSource().getY()+j1].getName())){
                    a.add(getSource().offset(i1,j1));
                }
                i1++;
                j1++;
                block=0;
            }


            i1=0;
            j1=0;
            i2=-1;
            j2=-1;
            while (i1>=dxmin&&j1>=dymin){
                while (i2>i1&&j2>j1){
                    if(!(c[getSource().getX()+i2][getSource().getY()+j2] instanceof EmptySlotComponent)){
                        block++;
                        break;
                    }
                    i2--;
                    j2--;
                }
                i2=-1;
                j2=-1;
                if(block==0&&!Character.isUpperCase(c[getSource().getX()+i1][getSource().getY()+j1].getName())){
                    a.add(getSource().offset(i1,j1));
                }
                i1--;
                j1--;
                block=0;
            }


            i1=0;
            j1=0;
            i2=1;
            j2=-1;
            while (i1<=dxmax&&j1>=dymin){
                while (i2<i1&&j2>j1){
                    if(!(c[getSource().getX()+i2][getSource().getY()+j2] instanceof EmptySlotComponent)){
                        block++;
                        break;
                    }
                    i2++;
                    j2--;
                }
                i2=1;
                j2=-1;
                if(block==0&&!Character.isUpperCase(c[getSource().getX()+i1][getSource().getY()+j1].getName())){
                    a.add(getSource().offset(i1,j1));
                }
                i1++;
                j1--;
                block=0;
            }


            i1=0;
            j1=0;
            i2=-1;
            j2=1;
            while (i1>=dxmin&&j1<=dymax){
                while (i2>i1&&j2<j1){
                    if(!(c[getSource().getX()+i2][getSource().getY()+j2] instanceof EmptySlotComponent)){
                        block++;
                        break;
                    }
                    i2--;
                    j2++;
                }
                i2=-1;
                j2=1;
                if(block==0&&!Character.isUpperCase(c[getSource().getX()+i1][getSource().getY()+j1].getName())){
                    a.add(getSource().offset(i1,j1));
                }
                i1--;
                j1++;
            }
        }

        block=0;

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
