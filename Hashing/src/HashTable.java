import java.text.MessageFormat;

public class HashTable {

    private String[] LinearTable;
    private int linearSteps;
    private String[] QuadraticTable;
    private int quadraticSteps;

    public HashTable (int size){
        LinearTable = new String [size + (size / 3)]; // table size should be a prime number.
        linearSteps = 0;
        QuadraticTable = new String [size + (size / 3)]; // table size should be a prime number.
        quadraticSteps = 0;
    }

    private int strToInt (String str) {
        int asciiSum = 0;
        char[] letters = str.toCharArray();
        for (char ch : letters) {
            asciiSum += (int) ch;
        }
        return asciiSum;
    }

    private int[] hash (String str) {
        int linearIndex = strToInt(str) % LinearTable.length;
        int quadraticIndex = strToInt(str) % QuadraticTable.length;

        for (int i = 0; LinearTable[linearIndex] != null && i < LinearTable.length; i++) {
            linearIndex = linearRehash(linearIndex, i);
        }
        for (int i = 0; QuadraticTable[quadraticIndex] != null && i < QuadraticTable.length; i++) {
            quadraticIndex = quadraticRehash(quadraticIndex, i);
        }

        int[] indexes = {linearIndex, quadraticIndex};

        return indexes;
    }

    private int[] findHash (String str) {
        int linearIndex = strToInt(str) % LinearTable.length;
        int quadraticIndex = strToInt(str) % QuadraticTable.length;

        for (int i = 0; !LinearTable[linearIndex].equals(str) && i < LinearTable.length; i++) {
            linearIndex = linearRehash(linearIndex, i);
        }
        for (int i = 0; !QuadraticTable[quadraticIndex].equals(str) && i < QuadraticTable.length; i++) {
            quadraticIndex = quadraticRehash(quadraticIndex, i);
        }

        int[] indexes = {linearIndex, quadraticIndex};

        return indexes;
    }

    private int linearRehash (int index, int i) { // linear probing
        linearSteps++;
        return (index + i) % LinearTable.length;
    }

    public int quadraticRehash (int index, int i) { // Quadratic probing
        quadraticSteps++;
        return (index + i^2) % QuadraticTable.length;
    }

    public void insert (String str) {
        int[] indexes = hash(str);

        LinearTable[indexes[0]] = str;
        QuadraticTable[indexes[1]] = str;

    }

    public void search (String str, String arrayType) {
        int[] indexes = findHash(str);

        if (arrayType.equals("linear")) {
            System.out.println(indexes[0]);
            if (LinearTable[indexes[0]].equals(str)) {
                System.out.println("Found: " + str + ": Index: " + indexes[0]);
            } else {
                System.out.println("Not found");
            }
        }
        if (arrayType.equals("quadratic")) {
            if (QuadraticTable[indexes[1]].equals(str)) {
                System.out.println("Found: " + str + ": Index: " + indexes[1]);
            } else {
                System.out.println("Not found");
            }
        }

    }

    public void printLinearTable(boolean excludeNulls) {
        System.out.print("\n");
        System.out.print("[");
        for (int i = 0; i < LinearTable.length; i++) {
            if (excludeNulls && LinearTable[i] == null) continue;
            MessageFormat message = new MessageFormat(", {0}");
            Object[] args = {
                    LinearTable[i]
            };
            System.out.print(message.format(args));
        }
        System.out.print("]");
        System.out.print("\n");
    }

    public void printQuadraticTable(boolean excludeNulls) {
        System.out.print("\n");
        System.out.print("[");
        for (int i = 0; i < QuadraticTable.length; i++) {
            if (excludeNulls && QuadraticTable[i] == null) continue;
            MessageFormat message = new MessageFormat(", {0}");
            Object[] args = {
                    QuadraticTable[i]
            };
            System.out.print(message.format(args));
        }
        System.out.print("]");
        System.out.print("\n");
    }

    public void getCount () {
        System.out.println("Linear Step(s): " + linearSteps);
        System.out.println("Quadratic Step(s): " + quadraticSteps);
    }

}
