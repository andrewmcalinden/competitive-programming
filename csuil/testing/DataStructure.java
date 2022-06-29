public class DataStructure<E> {
    private class O {
        E e;
        O o;

        public O(E e, O o) {
            this.e = e;
            this.o = o;
        }
    }

    O o;
    O t;
    int sz;

    public void add(E e) {
        if (o == null) {
            o = t = new O(e, null);
        } else {
            t = t.o = new O(e, null);
        }
        sz++;
    }

    public E next() {
        return o.e;
    }

    public E remove() {
        E e = next();
        o = o.o;
        sz--;
        return e;
    }

    public boolean isEmpty() {
        return sz == 0;
    }
}
