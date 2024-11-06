// src/main/java/TokenTable/TokenTable.java
package TokenTable;

import java.util.ArrayList;
import java.util.List;

public class TokenTable {
    private final List<TokenRecord> tokenRecords;

    public TokenTable() {
        this.tokenRecords = new ArrayList<>();
    }

    public void addTokenRecord(int errorId, String token, String tokenType, int line) {
        for (TokenRecord record : tokenRecords) {
            if (record.getErrorId() == errorId && record.getToken().equals(token)) {
                record.addNewOccurrence(line);
                return;
            }
        }
        tokenRecords.add(new TokenRecord(errorId, token, tokenType, line));
    }

    public void printTable() {
        String format = "| %-20s | %-16s | %-12s | %-64s |%n";
        System.out.format("+----------------------+------------------+--------------+------------------------------------------------------------------+%n");
        System.out.format("| Token ID             | Token            | Token Type   | Lines                                                            |%n");
        System.out.format("+----------------------+------------------+--------------+------------------------------------------------------------------+%n");
        for (TokenRecord record : tokenRecords) {
            record.printRecord(format);
        }
        System.out.format("+----------------------+------------------+--------------+------------------------------------------------------------------+%n");
    }
}
