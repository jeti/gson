package io.jeti.gson;

import com.google.gson.Gson;
import io.jeti.streams.StreamWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class GsonStreamWriter implements StreamWriter<DataOutputStream, Object> {

    private final Gson gson = new Gson();

    @Override
    public DataOutputStream preLoop(OutputStream outputStream) throws IOException {
        return new DataOutputStream(outputStream);
    }

    @Override
    public void writeOne(DataOutputStream stream, Object objectToWrite) throws IOException {
        stream.writeUTF(objectToWrite.getClass().getName());
        stream.writeUTF(gson.toJson(objectToWrite));
    }
}

