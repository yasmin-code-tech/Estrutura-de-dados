public class App {
    public static void main(String[] args) throws Exception {
        //System.out.println(hashCode("grafia"));
        //System.out.println(hashCode("girafa"));

        HashTable<String, Integer> hering = new HashTable<>(13);
        System.out.println(hashCode("hering"));

        hering.set("Camisa M",654);
        hering.set();
    }

    public static int compression (int hashCode, int N){
        //return hashCode%N;

        return hashCode >= 0? hashCode%hashTable.length : (hashCode*-1)%hashTable.lenght;
    }


// o problema é que palavras diferentes podem usar os mesmos caracteres
    public static int hashCode(String key){
    int hashCode = 0;
    for (int i = 0; i < key.length(); i++){
        hashCode = hashCode<<5 | hashCode>>>27;
        hashCode += key.charAt(i); 
    }

    return hashCode;

}





}


