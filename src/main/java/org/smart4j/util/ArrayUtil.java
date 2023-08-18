package org.smart4j.util;

import org.apache.commons.lang3.ArrayUtils;

public final class ArrayUtil {
    public ArrayUtil() {
    }

    public static boolean isNotEmpty(Object[] array) {
        return !ArrayUtils.isEmpty(array);
    }

    public static boolean isEmpty(Object[] array) {
        return ArrayUtils.isEmpty(array);
    }
}