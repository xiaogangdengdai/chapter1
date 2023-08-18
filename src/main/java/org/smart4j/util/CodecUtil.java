package org.smart4j.util;

import java.net.URLDecoder;
import java.net.URLEncoder;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class CodecUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(CodecUtil.class);

    public CodecUtil() {
    }

    public static String encodeURL(String source) {
        try {
            String target = URLEncoder.encode(source, "UTF-8");
            return target;
        } catch (Exception var3) {
            LOGGER.error("encode url failure", var3);
            throw new RuntimeException(var3);
        }
    }

    public static String decodeURL(String source) {
        try {
            String target = URLDecoder.decode(source, "UTF-8");
            return target;
        } catch (Exception var3) {
            LOGGER.error("decode url failure", var3);
            throw new RuntimeException(var3);
        }
    }

    public static String md5(String source) {
        return DigestUtils.md5Hex(source);
    }
}
