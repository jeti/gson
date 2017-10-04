package io.jeti.gson;

import com.google.gson.Gson;
import io.jeti.serialize.Serializer;
import java.io.IOException;

public class GsonSerializer implements Serializer<Object> {

    private final Gson gson = new Gson();

    @Override
    public String toString(Object object) throws IOException {
        return object.getClass().getName() + ":" + gson.toJson(object);
    }

    @Override
    public Object fromString(String string) throws ClassNotFoundException, IOException {
        String[] parts = string.split(":", 2);
        return gson.fromJson(parts[1], Class.forName(parts[0]));
    }
}
