package application;

import entity.Node;
import services.impl.moveServiceImpl;

public class Main{
    public static void main(String[] args) {
        Node node=new Node();
        moveServiceImpl.update(node);

    }
}
