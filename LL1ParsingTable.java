import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LL1ParsingTable {

    public static void main(String[] args) {
        // Define the LL(1) parsing table for the given grammar
        // A hashmap can be used as it stores data as key-value pairs, this makes retrieval of the values more effecient than using nested for loops
        Map<String, Map<String, String>> ll1Table = new HashMap<>();

        // Add table entries based on the grammar
        // Example entries 
        addTableEntry(ll1Table, "S", "a", "AaB");
        addTableEntry(ll1Table, "A", "a", "aA");
        addTableEntry(ll1Table, "A", "ε", "ε");
        addTableEntry(ll1Table, "B", "b", "bB");
        addTableEntry(ll1Table, "B", "ε", "ε");

        // Print the LL(1) parsing table
        System.out.println("LL(1) Parsing Table:");
        for (String nonTerminal : ll1Table.keySet()) {
            System.out.print(nonTerminal + ": ");
            for (String terminal : ll1Table.get(nonTerminal).keySet()) {
                System.out.print(terminal + " -> " + ll1Table.get(nonTerminal).get(terminal) + ", ");
            }
            System.out.println();
        }
    }

    // Helper method to add entries to the LL(1) parsing table
    private static void addTableEntry(Map<String, Map<String, String>> table, String nonTerminal, String terminal, String production) {
        table.putIfAbsent(nonTerminal, new HashMap<>());
        table.get(nonTerminal).put(terminal, production);
    }
}
