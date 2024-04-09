package util;

import java.util.UUID;

public class UIDGenerator {
    public static String getId(String prefix) {
        return prefix + ":" + UUID.randomUUID();
    }
}
