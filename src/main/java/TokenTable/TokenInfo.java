// src/main/java/TokenTable/TokenInfo.java
package TokenTable;

public class TokenInfo {

    @Override
    public String toString() {
        return String.format("%s (line: %d, column: %d)", this.value, this.line, this.column);
    }

    public String value;
    public int line;
    public int column;

    public TokenInfo(String value, int line, int column) {
        this.value = value;
        this.line = line;
        this.column = column;
    }
}
