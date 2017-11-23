package jns.network.data_link;

import jns.network.*;

public interface MacFrame {
    MacAddress getSourceAddress();
    void setSourceAddress(MacAddress address);
    MacAddress getDestinationAddress();
    void setDestinationAddress(MacAddress address);
}
