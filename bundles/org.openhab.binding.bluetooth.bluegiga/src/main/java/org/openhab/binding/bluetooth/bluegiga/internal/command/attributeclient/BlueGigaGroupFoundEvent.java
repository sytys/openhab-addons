/**
 * Copyright (c) 2010-2022 Contributors to the openHAB project
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.openhab.binding.bluetooth.bluegiga.internal.command.attributeclient;

import java.util.UUID;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.openhab.binding.bluetooth.bluegiga.internal.BlueGigaDeviceResponse;

/**
 * Class to implement the BlueGiga command <b>groupFoundEvent</b>.
 * <p>
 * This event is produced when an attribute group (a service) is found. Typically this event is
 * produced after Read by Group Type command.
 * <p>
 * This class provides methods for processing BlueGiga API commands.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
@NonNullByDefault
public class BlueGigaGroupFoundEvent extends BlueGigaDeviceResponse {
    public static int COMMAND_CLASS = 0x04;
    public static int COMMAND_METHOD = 0x02;

    /**
     * Starting handle
     * <p>
     * BlueGiga API type is <i>uint16</i> - Java type is {@link int}
     */
    private int start;

    /**
     * Ending handle
     * <p>
     * BlueGiga API type is <i>uint16</i> - Java type is {@link int}
     */
    private int end;

    /**
     * UUID of a service. Length is 0 if no services are found.
     * <p>
     * BlueGiga API type is <i>uuid</i> - Java type is {@link UUID}
     */
    private UUID uuid;

    /**
     * Event constructor
     */
    public BlueGigaGroupFoundEvent(int[] inputBuffer) {
        // Super creates deserializer and reads header fields
        super(inputBuffer);

        event = (inputBuffer[0] & 0x80) != 0;

        // Deserialize the fields
        connection = deserializeUInt8();
        start = deserializeUInt16();
        end = deserializeUInt16();
        uuid = deserializeUuid();
    }

    /**
     * Starting handle
     * <p>
     * BlueGiga API type is <i>uint16</i> - Java type is {@link int}
     *
     * @return the current start as {@link int}
     */
    public int getStart() {
        return start;
    }

    /**
     * Ending handle
     * <p>
     * BlueGiga API type is <i>uint16</i> - Java type is {@link int}
     *
     * @return the current end as {@link int}
     */
    public int getEnd() {
        return end;
    }

    /**
     * UUID of a service. Length is 0 if no services are found.
     * <p>
     * BlueGiga API type is <i>uuid</i> - Java type is {@link UUID}
     *
     * @return the current uuid as {@link UUID}
     */
    public UUID getUuid() {
        return uuid;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("BlueGigaGroupFoundEvent [connection=");
        builder.append(connection);
        builder.append(", start=");
        builder.append(start);
        builder.append(", end=");
        builder.append(end);
        builder.append(", uuid=");
        builder.append(uuid);
        builder.append(']');
        return builder.toString();
    }
}
