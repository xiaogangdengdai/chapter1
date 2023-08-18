package org.smart4j.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class StreamUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(StreamUtil.class);

    public StreamUtil() {
    }

    public static String getString(InputStream is) {
        StringBuilder sb = new StringBuilder();

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

            String line;
            while((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (Exception var4) {
            LOGGER.error("get string failure", var4);
            throw new RuntimeException(var4);
        }

        return sb.toString();
    }

    public static void copyStream(InputStream inputStream, OutputStream outputStream) {
        try {
            byte[] buffer = new byte[4096];

            int length;
            while((length = inputStream.read(buffer, 0, buffer.length)) != -1) {
                outputStream.write(buffer, 0, length);
            }

            outputStream.flush();
        } catch (Exception var11) {
            LOGGER.error("copy stream failure", var11);
            throw new RuntimeException(var11);
        } finally {
            try {
                inputStream.close();
                outputStream.close();
            } catch (Exception var10) {
                LOGGER.error("close stream failure", var10);
            }

        }
    }
}
