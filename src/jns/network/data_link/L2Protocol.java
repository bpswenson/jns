package jns.network.data_link;

import jns.network.MacAddress;
import jns.network.Packet;
import jns.network.Interface;

public interface L2Protocol {
    ///Build and append a layer 2 header to the specified packet
    void buildDataPDU(MacAddress source, MacAddress dest, Packet pkt);


    ///This member function is called by the higher layer requesting a transfer of data to a peer
    ///Assumes packet has l2 header already appended
    void dataRequest(Packet pkt);

    ///Called when a packet has just been received at the underlying link
    void dataIndication(Packet pkt);

    void setInterface(Interface i);

    //true if the protocol / link is busy processing a packet
    boolean isBusy();



}
