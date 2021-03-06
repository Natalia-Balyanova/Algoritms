package src.balyanova.lesson8;

public interface LinkedHashTable<K, V> {

    boolean put (K key, V value);

    V get (K key);

    V remove (K key);

    int size ();

    boolean isEmpty ();

    void display ();

    interface Entry <K, V>{
        K getKey();//ключ менять нельзя
        V getValue();

        void setValue (V value);
    }
}