import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class NativeDictionaryTest {
    NativeDictionary <String> nd = new NativeDictionary<>(11, String.class);

    @org.junit.jupiter.api.Test
    void isKey() {
        for (int i = 0; i < 11; i++) {
            if (i < 5) {
                nd.put(String.valueOf(i) + 5, String.valueOf(i) + "val");
            } else {
                nd.put(String.valueOf(i), String.valueOf(i) + "val");
            }
        }

        for (int i = 0; i < 11; i++) {
            if (i < 5) {
                assertTrue(nd.isKey(String.valueOf(i) + 5));
            } else {
                assertTrue(nd.isKey(String.valueOf(i)));
            }
        }
    }

    @org.junit.jupiter.api.Test
    void put() {
        nd.put("123", "123value");
        nd.put("123", "123valuesTwo");

        nd.isKey("123");
        nd.isKey("321");
    }

    @org.junit.jupiter.api.Test
    void get() {
        nd.put("123", "123value");
        nd.put("123", "123valuesTwo");

        Object o1 = nd.get("123");
        Object o2 = nd.get("321");
    }
}