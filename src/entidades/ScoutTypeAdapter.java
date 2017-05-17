package entidades;

import java.io.IOException;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

public class ScoutTypeAdapter extends TypeAdapter<Scout> {
	@Override
    public Scout read(JsonReader reader) throws IOException {
        // the first token is the start object
        JsonToken token = reader.peek();
        Scout dataset = new Scout();
        if (token.equals(JsonToken.BEGIN_OBJECT)) {
            reader.beginObject();
            while (!reader.peek().equals(JsonToken.END_OBJECT)) {
                if (reader.peek().equals(JsonToken.NAME)) {
                    if (reader.nextName().equals("acao"))
                        dataset.setAcao(reader.nextString());
                    else
                        reader.skipValue();
 
                }
            }
            reader.endObject();
 
        }
        return dataset;
    }
 
    @Override
    public void write(JsonWriter out, Scout value) throws IOException {
 
    }
	
}
