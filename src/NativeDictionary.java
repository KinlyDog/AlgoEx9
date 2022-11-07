import java.lang.reflect.Array;

public class NativeDictionary<T> {
    public int size;
    public String[] slots;
    public T[] values;

    public NativeDictionary(int size, Class clazz) {
        this.size = size;
        slots = new String[this.size];
        values = (T[]) Array.newInstance(clazz, this.size);
    }

    public int hashFun(String key) {
        int len = key.getBytes().length;
        return len % size;
    }

    public int seekSlot(String value) {
        int ind = hashFun(value);

        for (int i = 0; i < size; i++, ind++) {
            if (ind >= size) {
                ind -= size;
            }

            if (slots[ind] == null) {
                return ind;
            }
        }

        return -1;
    }

    public int find(String key) {
        int ind = hashFun(key);

        for (int i = 0; i < size; i++, ind++) {
            if (ind >= size) {
                ind -= size;
            }

            if (slots[ind] == null) {
                return -1;
            }

            if (slots[ind].equals(key)) {
                return ind;
            }
        }

        return -1;
    }

    public boolean isKey(String key) {
        return find(key) != -1;
    }

    public void put(String key, T value) {
        int ind = seekSlot(key);

        if (ind != -1) {
            slots[ind] = key;
            values[ind] = value;
        }
    }

    public T get(String key) {
        int ind = find(key);

        if (ind == -1) {
            return null;
        }

        return values[ind];
    }
}
