package services.impl;

import entity.Node;
import services.checkService;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Heming233
 * @version v1.0
 */

public class checkServiceImpl implements checkService {
    @Override
    public boolean isCompleted(Node node, Node correct){
        return Arrays.equals(node.getPosition(),correct.getPosition());
    }

    @Override
    public boolean isSolvable(Node node){
        int reverse=0;
        int[] array=node.getPosition();

        //求一维化的初始状态逆序和
        for(int i=0 ; i<9 ; i++){
            for(int j=0 ; j<i ; j++){
                if(array[j]>array[i]){
                    reverse++;
                }
            }
        }

        //根据题意，目标状态一维化后逆序和为奇数，所以初始状态逆序和为奇数则有解
        if(reverse%2!=0){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean isMovable(int number,int[] position){
        int[][] graph=new int[3][3];
        //int flag=0;//用于确定选定的某个数四周有没有空格的标记
        int n=0,i=0,j=0;

        //将一维数组转移至二维数组
        for(i=0;i<3;i++){
            for(j=0;j<3;j++){
                graph[i][j]=position[n++];
            }
        }
        if(number>=0&&number<=2){
            i=0;
            j=number;
        }
        if(number>=3&&number<=5){
            i=1;
            j=number-3;
        }
        if(number>=6&&number<=8){
            i=2;
            j=number-6;
        }

        //判断position[number]四周有没有空格
        if(graph[i-1][j]==0&&i-1>=0){
            return true;
        }
        if(graph[i+1][j]==0&&i+1<=2){
            return true;
        }
        if(graph[i][j-1]==0&&j-1>=0){
            return true;
        }
        if(graph[i][j+1]==0&&j+1<=2){
            return true;
        }

        return false;
    }

    @Override
    public boolean isExist(ArrayList<Node> open,Node node){
        if(open.contains(node)){
            return true;
        }
        else{
            return false;
        }
    }
}
