/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.Packet
 */
package botnet.auth.jigokusense.event.events;

import botnet.auth.jigokusense.event.Event;
import net.minecraft.network.Packet;

public class NetworkPacketEvent
extends Event {
    public Packet m_Packet;

    public NetworkPacketEvent(Packet p_Packet) {
        this.m_Packet = p_Packet;
    }

    public Packet GetPacket() {
        return this.m_Packet;
    }

    public Packet getPacket() {
        return this.m_Packet;
    }
}

