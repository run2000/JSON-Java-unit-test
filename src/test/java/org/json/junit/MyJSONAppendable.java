package org.json.junit;

import org.json.JSONAppendable;
import org.json.JSONException;
import org.json.util.Latin1AppendableOutputStream;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Base64;

/**
 * Tests the JSONAppendable interface using Java 8's Base64.Encoder class
 * as a source of appendable data.
 */
public class MyJSONAppendable implements JSONAppendable {

    @Override
    public void appendJSON(Appendable appender) throws IOException, JSONException {
        Base64.Encoder enc = Base64.getEncoder();
        StringBuilder sb = new StringBuilder();

        sb.append('"');
        try (OutputStream os = enc.wrap(new Latin1AppendableOutputStream().with(sb))) {
            try (InputStream is = this.getClass().getResourceAsStream("/jsonpointer-testdoc.json")) {
                byte[] buff = new byte[1024];
                int count = is.read(buff);
                while(count >= 0) {
                    os.write(buff, 0, count);
                    count = is.read(buff);
                }
            }
        }
        sb.append('"');
        appender.append(sb);
    }
}
