// src/main/java/TokenTable/TokenRecord.java
package TokenTable;

import java.util.HashMap;

public class TokenRecord {
    private final int errorId;
    private final String token;
    private final String tokenType;
    private final HashMap<Integer, Integer> lineOccurrence;

    public TokenRecord(int errorId, String token, String tokenType, int line) {
        this.errorId = errorId;
        this.token = token;
        this.tokenType = tokenType;
        this.lineOccurrence = new HashMap<>();
        this.lineOccurrence.put(line, 1);
    }

    public void addNewOccurrence(int line) {
        this.lineOccurrence.put(line, this.lineOccurrence.getOrDefault(line, 0) + 1);
    }

    public int getErrorId() {
        return errorId;
    }

    public String getToken() {
        return token;
    }

    public String getTokenType() {
        return tokenType;
    }

    public HashMap<Integer, Integer> getLineOccurrence() {
        return lineOccurrence;
    }

    public String getLineOccurrenceString() {
        StringBuilder lineOccurrenceString = new StringBuilder();
        for (int line : lineOccurrence.keySet()) {
            lineOccurrenceString.append(line).append(" (").append(lineOccurrence.get(line)).append("), ");
        }
        return lineOccurrenceString.toString();
    }

    public void printRecord(String format) {
        System.out.format(format, errorId, token, tokenType, getLineOccurrenceString());
    }
}
