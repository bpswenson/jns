package jns.network;

//FROM https://github.com/wallnerryan/floodlight/blob/master/src/main/java/net/floodlightcontroller/util/MACAddress.java


import java.util.Arrays;

public class MacAddress {
    public static final int MAC_ADDRESS_LENGTH = 6;
    private byte[] _address = new byte[MAC_ADDRESS_LENGTH];

    public MacAddress(byte[] address) {
        _address = Arrays.copyOf(address, MAC_ADDRESS_LENGTH);
    }

    public static MacAddress fromString(String address) {
        String[] elements = address.split(":");
        if(elements.length != MAC_ADDRESS_LENGTH) {
            throw new IllegalArgumentException("Specified MAC Address must contain 12 hex digits seperated pairwise by :'s");
        }

        byte[] addressInBytes = new byte[MAC_ADDRESS_LENGTH];
        for(int i = 0; i < MAC_ADDRESS_LENGTH; i++) {
            String element = elements[i];
            addressInBytes[i] = (byte)Integer.parseInt(element, 16);
        }

        return new MacAddress(addressInBytes);
    }

    public static MacAddress fromBytes(byte[] address) {
        if(address.length != MAC_ADDRESS_LENGTH) {
            throw new IllegalArgumentException("The length is not " + MAC_ADDRESS_LENGTH);
        }

        return new MacAddress(address);
    }

    public static MacAddress fromLong(long address) {
        byte[] addressInBytes = new byte[] {
                (byte)((address >> 40) & 0xff),
                (byte)((address >> 32) & 0xff),
                (byte)((address >> 24) & 0xff),
                (byte)((address >> 16) & 0xff),
                (byte)((address >> 8 ) & 0xff),
                (byte)((address >> 0)  & 0xff)
        };

        return new MacAddress(addressInBytes);
    }

    public int length() {
        return _address.length;
    }

    public byte[] toBytes() {
        return Arrays.copyOf(_address, _address.length);
    }

    public long toLong() {
        long mac = 0;
        for(int i = 0; i < MAC_ADDRESS_LENGTH; i++) {
            long t = (_address[i] & 0xffL) << ((5 - i) * 8);
            mac |= t;
        }
        return mac;
    }

    public boolean isBroadcast() {
        for(byte b : _address) {
            if(b != -1)
                return false;
        }
        return true;
    }

    public boolean isMulticast() {
        if(!isBroadcast()) {
            return false;
        }
        return (_address[0] & 0x01) != 0;
    }

    @Override
    public boolean equals(Object o) {
        if(o == this) {
            return true;
        }

        if(!(o instanceof MacAddress)) {
            return false;
        }

        MacAddress other = (MacAddress)o;
        return Arrays.equals(_address, other._address);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(_address);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(byte b : _address) {
            if(builder.length() > 0) {
                builder.append(":");
            }
            builder.append(String.format("%02X", b & 0xFF));
        }
        return builder.toString();
    }
}
