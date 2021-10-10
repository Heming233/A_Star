package services.impl;

import entity.Node;
import services.moveService;

import javax.swing.*;
import java.util.ArrayList;

/**
 * @author Heming233
 * @version v1.0
 */

public class moveServiceImpl extends checkServiceImpl implements moveService {
    private Node result=new Node();

    @Override
    public void init(Node node){
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
    public boolean autoSearchRoad(Node node){
        ArrayList<Node> open=new ArrayList<>();//存储未经历的结点
        ArrayList<Node> close=new ArrayList<>();//存储已经历的结点
        int[][] graph=new int[3][3];

        if(!isSolvable(node)){
            JOptionPane.showMessageDialog(null,"该情况无解","无解提示",JOptionPane.WARNING_MESSAGE);
            return false;
        }

        init(node);
        open.add(node);
        while(true){
            if(isCompleted(node,result)){
                JOptionPane.showMessageDialog(null,"已还原标准形式","有解提示",JOptionPane.WARNING_MESSAGE);
                break;
            }
            for(int i=0; i<node.getPosition().length; i++){
                if(isMovable(i,node.getPosition())!=0){
                    Node temp=new Node();
                }
            }
        }

        return true;
    }
}
