package services.impl;

import entity.Node;
import services.moveService;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Heming233
 * @version v1.0
 */

public class moveServiceImpl extends checkServiceImpl implements moveService {
    private Node result=new Node();

    @Override
    public void update(Node node){
        int temp=0;
        result.setPosition(new int[]{1,2,3,8,0,4,7,6,5});
        for(int i=0; i<9; i++){
            if(node.getPosition()[i]!=result.getPosition()[i]){
                temp++;
            }
        }
        node.setMisPosition(temp);
        if(node.getParent()==null){
            node.setDepth(0);
        }
        else{
            node.setDepth(node.getParent().getDepth()+1);
        }
        node.setEvaluation(node.getDepth()+node.getMisPosition());
    }


    @Override
    public boolean moveByHand(Node node,int number){
        switch (isMovable(number,node.getPosition())){
            case 0:return false;
            case 1:
        }
        return true;
    }

    @Override
    public int[] toOne(int[][] old){
        int[] newArray=new int[9];
        int n=0;

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                newArray[n++]=old[i][j];
            }
        }

        return  newArray;
    }

    @Override
    public int[][] toTwo(int[] old){
        int[][] newArray=new int[3][3];
        int n=0;

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                newArray[i][j]=old[n++];
            }
        }

        return newArray;
    }

    @Override
    public boolean autoSearchRoad(Node node){
        ArrayList<Node> open=new ArrayList<>();//存储未经历的结点
        ArrayList<Node> close=new ArrayList<>();//存储已经历的结点
        int[][] graph=new int[3][3];
        int x=0,y=0;

        if(!isSolvable(node)){
            JOptionPane.showMessageDialog(null,"该情况无解","无解提示",JOptionPane.WARNING_MESSAGE);
            return false;
        }

        open.add(node);
        while(true){
            if(isCompleted(node,result)){
                JOptionPane.showMessageDialog(null,"已还原标准形式","有解提示",JOptionPane.WARNING_MESSAGE);
                break;
            }

            /**
             * 遍历棋盘内所有数字，找到预估值最小的那一步
             */
            for(int i=0; i<node.getPosition().length; i++){
                if(isMovable(i,node.getPosition())!=0){
                    Node temp=new Node();
                    temp.setEvaluation(node.getEvaluation());
                    temp.setMisPosition(node.getMisPosition());
                    temp.setDepth(node.getDepth());
                    temp.setParent(node.getParent());

                    graph=toTwo(node.getPosition());
                    if(i>=0&&i<=2){
                        x=0;
                        y=i;
                    }
                    else if(i>=3&&i<=5){
                        x=1;
                        y=i-3;
                    }
                    else if(i>=6){
                        x=2;
                        y=i-6;
                    }
                    switch (isMovable(i,node.getPosition())){
                        case 1:graph[x-1][y]=graph[x][y];
                                graph[x][y]=0;
                                break;
                        case 2:graph[x++][y]=graph[x][y];
                                graph[x][y]=0;
                                break;
                        case 3:graph[x][y--]=graph[x][y];
                                graph[x][y]=0;
                                break;
                        case 4:graph[x][y++]=graph[x][y];
                                graph[x][y]=0;
                                break;
                    }
                    temp.setPosition(toOne(graph));
                    update(temp);
                    open.add(temp);
                }
            }

            /**
             * 将open表里的预期值最小的结点转入close
             */
            Iterator<Node> it=open.iterator();
            Node min=it.next();
            while(it.hasNext()){
                min=it.next().getEvaluation()<min.getEvaluation()?it.next():min;
            }
            close.add(min);
            open.remove(min);
        }

        return true;
    }
}
