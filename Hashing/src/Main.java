public class Main {

    public static void main(String[] args) {
        HashTable hashtable = new HashTable(50);

        hashtable.insert("BASA");
        hashtable.insert("BASA");
        hashtable.insert("BASA");
        hashtable.insert("BASA");
        hashtable.insert("BASA");
        hashtable.insert("ABC");
        hashtable.insert("AB");
        hashtable.insert("AB");
        hashtable.insert("BAS");
        hashtable.insert("BASsadsadsaA");
        hashtable.insert("asdasdsadq2edq2dqd");
        hashtable.insert("asdasdsadq2edq2dqd");
        hashtable.insert("BASsadsadsaA");
        hashtable.insert("asdsad145102vfdvvfdvdfv");
        hashtable.insert("asdsad145102vfdvvfdvdfv");
        hashtable.insert("asdsad3qd0847");
        hashtable.insert("asdawdwqdq0205");
        hashtable.insert("asdsad213wdsad");
        hashtable.insert("BASAasdsa");
        hashtable.insert("Ssd");
        hashtable.insert("BASA");
        hashtable.insert("BASA");
        hashtable.insert("BASA");
        hashtable.insert("BASA");
        hashtable.insert("BASA");
        hashtable.insert("ABC");
        hashtable.insert("AB");
        hashtable.insert("AB");
        hashtable.insert("BAS");
        hashtable.insert("BASsadsadsaA");
        hashtable.insert("asdasdsadq2edq2dqd");
        hashtable.insert("asdasdsadq2edq2dqd");
        hashtable.insert("BASsadsadsaA");
        hashtable.insert("asdsad145102vfdvvfdvdfv");
        hashtable.insert("asdsad145102vfdvvfdvdfv");
        hashtable.insert("asdsad3qd0847");
        hashtable.insert("asdawdwqdq0205");
        hashtable.insert("asdsad213wdsad");
        hashtable.insert("BASAasdsa");
        hashtable.insert("Ssd");

        hashtable.getCount();

        hashtable.printLinearTable(true);
        hashtable.printQuadraticTable(true);

        hashtable.search("asdsad145102vfdvvfdvdfv", "linear");
        hashtable.search("Ssd", "quadratic");
    }
}
