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
package org.openhab.binding.netatmo.internal.deserialization;

import java.lang.reflect.Type;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.openhab.binding.netatmo.internal.api.data.EventType;
import org.openhab.binding.netatmo.internal.api.data.ModuleType;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

/**
 * Specialized deserializer for push_type field
 *
 * @author Gaël L'hopital - Initial contribution
 */
@NonNullByDefault
class NAPushTypeDeserializer implements JsonDeserializer<NAPushType> {

    @Override
    public @Nullable NAPushType deserialize(JsonElement json, Type clazz, JsonDeserializationContext context)
            throws JsonParseException {
        String string = json.getAsString();
        String[] elements = string.split("-");
        if (elements.length > 1) {
            try {
                ModuleType moduleType = ModuleType.from(elements[0]);
                EventType eventType = EventType.valueOf(elements[1].toUpperCase());

                return new NAPushType(moduleType, eventType);
            } catch (IllegalArgumentException e) {
            }
        }
        throw new JsonParseException("Error deserializing : " + string);
    }
}
