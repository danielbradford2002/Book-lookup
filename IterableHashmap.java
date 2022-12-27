import java.util.Iterator;
import java.util.NoSuchElementException;

public class IterableHashmap implements IterableMapADT{
    @Override
    public boolean put(Object key, Object value) {
        return false;
    }

    @Override
    public Object get(Object key) throws NoSuchElementException {
        return null;
    }

    @Override
    public Object remove(Object key) {
        return null;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void clear() {

    }

    @Override
    public Iterator iterator() {
        return null;
    }
}
