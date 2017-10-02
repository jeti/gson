package io.jeti.gson;

import com.google.gson.Gson;
import io.jeti.streams.StreamReader;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class GsonStreamReader implements StreamReader<DataInputStream, Object> {

    private final boolean buffered;
    private static final boolean bufferedDefault = true;
    private final Gson gson = new Gson();

    public GsonStreamReader() {
        this(bufferedDefault);
    }

    public GsonStreamReader(boolean buffered) {
        this.buffered = buffered;
    }

    @Override
    public DataInputStream preLoop(InputStream inputStream) throws IOException {
        if (buffered) {
            BufferedInputStream bis = new BufferedInputStream(inputStream);
            return new DataInputStream(bis);
        } else {
            return new DataInputStream(inputStream);
        }
    }

    @Override
    public Object readOne(DataInputStream stream) throws IOException, ClassNotFoundException {
        String className = stream.readUTF();
        String json = stream.readUTF();
        return gson.fromJson(json, Class.forName(className));
    }
}
