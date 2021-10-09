package services;

import entity.Node;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Heming233
 * @version v1.0
 */

public interface checkService {

    //检查当前状态是否到达目的状态
    public boolean isCompleted(Node node, Node correct);

    //检查当前状态是否有解
    public boolean isSolvable(Node node);

    //检查能否移动
    public int isMovable(int number, int[] position);

    //检查open表里有没有某节点
    public boolean isExist(ArrayList<Node> open, Node node);

   //检查该状态是不是上一个状态的父状态，感觉没必要，暂时放着
    /*   public boolean isParent(ArrayList<Node> close,Node node);*/

}