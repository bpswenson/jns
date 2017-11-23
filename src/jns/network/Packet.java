package jns.network;

import java.util.Stack;

public class Packet {
    public int getSize() {
        int size = 0;
        for(PacketHeader hdr : _arrayList) {
            size += hdr.getSize();
        }

        return size;
    }

    public void pushHeader(PacketHeader hdr) {
        _arrayList.push(hdr);
    }

    public PacketHeader popHeader() {
        return _arrayList.pop();
    }

    public PacketHeader peekHeader() {
        return _arrayList.peek();
    }

    private Stack<PacketHeader> _arrayList = new Stack<>();
    private int _size = 0;
}
