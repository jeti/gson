package io.jeti.gson;

import com.google.gson.Gson;
import io.jeti.streams.Sink;
import io.jeti.streams.StreamReader;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class GsonStreamReaderSink implements StreamReader<DataInputStream, Object> {

    private final Gson           gson;
    private final Sink           sink;
    private final boolean        buffered;
    private static final boolean bufferedDefault = true;

    public GsonStreamReaderSink(Sink sink) {
        this(sink, bufferedDefault);
    }

    public GsonStreamReaderSink(Sink sink, boolean buffered) {
        if (sink == null) {
            throw new NullPointerException("The sink cannot be null");
        }
        this.gson = new Gson();
        this.sink = sink;
        this.buffered = buffered;
    }

    @Override
    public DataInputStream preLoop(InputStream inputStream) throws IOException {
        if (buffered) {
            return new DataInputStream(new BufferedInputStream(inputStream));
        } else {
            return new DataInputStream(inputStream);
        }
    }

    @Override
    public Object readOne(DataInputStream stream) throws IOException, ClassNotFoundException {
        String className = stream.readUTF();
        String json = stream.readUTF();
        Object obj = gson.fromJson(json, Class.forName(className));
        sink.process(obj);
        return obj;
    }
}
