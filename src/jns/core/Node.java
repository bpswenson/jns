package jns.core;

import java.util.HashMap;

public class Node {



    public void setLocation(float x, float y) {
        _xLoc = x;
        _yLoc = y;
    }

    public void addNodeItem(NodeItem item) {
        _nodeItems.put(item.getHash(), item);
    }

    public NodeItem peekNodeItem(String hash) {
        return _nodeItems.get(hash);
    }


    private HashMap<String, NodeItem> _nodeItems = new HashMap<>();
    private float _xLoc = 0;
    private float _yLoc = 0;
}
