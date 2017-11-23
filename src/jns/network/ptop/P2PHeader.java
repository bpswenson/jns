package jns.network.ptop;

import jns.network.PacketHeader;

public class P2PHeader implements PacketHeader {

    public int getSize() {
        return 2;
    }

    @Override
    public String toString() {
        String value;
        switch(_protocol) {
            case 0x0021:
                value = "IP (0x0021)";
                break;
            case 0x0057:
                value = "IPv6 (0x0057)";
                break;
            default:
                value = "Unknown";
                break;
        }
        return "Point-to-Point Protocol: " + value;
    }

    public void setProtocol(short p) {
        _protocol = p;
    }

    public short getProtocol() {
        return _protocol;
    }

    private short _protocol;
}
