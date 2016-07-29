package org.algohub.engine.serde;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.algohub.engine.type.TypeNode;

class LongNodeDeserializer implements NodeDeserializer {

    @Override
    public Object deserialize(TypeNode type, JsonNode jsonNode) {
        final ArrayNode elements = (ArrayNode) jsonNode;
        final TypeNode elementType = type.getElementType();

        final long[] javaArray = new long[elements.size()];
        for (int i = 0; i < elements.size(); ++i) {
            javaArray[i] = (Long) Deserializer.fromJson(elementType, elements.get(i));
        }
        return javaArray;
    }
}