
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package com.compi;

import java.util.HashMap;
import java.util.ArrayList;
import java_cup.runtime.Symbol;
import TokenTable.TokenInfo;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class Parser extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return sym.class;
}

  /** Default constructor. */
  @Deprecated
  public Parser() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public Parser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public Parser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\047\000\002\002\004\000\002\002\004\000\002\002" +
    "\004\000\002\003\004\000\002\003\002\000\002\004\003" +
    "\000\002\004\003\000\002\004\004\000\002\006\005\000" +
    "\002\006\005\000\002\005\007\000\002\005\010\000\002" +
    "\013\003\000\002\013\003\000\002\013\003\000\002\013" +
    "\003\000\002\013\003\000\002\011\005\000\002\011\006" +
    "\000\002\012\004\000\002\012\002\000\002\007\003\000" +
    "\002\007\005\000\002\007\004\000\002\007\003\000\002" +
    "\007\007\000\002\007\011\000\002\007\007\000\002\007" +
    "\013\000\002\007\004\000\002\010\005\000\002\010\005" +
    "\000\002\010\005\000\002\010\005\000\002\010\003\000" +
    "\002\010\003\000\002\010\003\000\002\010\003\000\002" +
    "\010\005" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\116\000\016\003\ufffd\025\ufffd\026\ufffd\027\ufffd\030" +
    "\ufffd\037\ufffd\001\002\000\004\002\120\001\002\000\016" +
    "\003\012\025\006\026\017\027\016\030\010\037\014\001" +
    "\002\000\006\003\ufff5\004\ufff5\001\002\000\016\003\ufffe" +
    "\025\ufffe\026\ufffe\027\ufffe\030\ufffe\037\ufffe\001\002\000" +
    "\006\003\ufff2\004\ufff2\001\002\000\016\003\ufffb\025\ufffb" +
    "\026\ufffb\027\ufffb\030\ufffb\037\ufffb\001\002\000\012\002" +
    "\uffff\003\ufff1\004\ufff1\023\117\001\002\000\006\003\021" +
    "\004\020\001\002\000\004\002\000\001\002\000\016\003" +
    "\ufffc\025\ufffc\026\ufffc\027\ufffc\030\ufffc\037\ufffc\001\002" +
    "\000\006\003\ufff3\004\ufff3\001\002\000\006\003\ufff4\004" +
    "\ufff4\001\002\000\006\017\023\023\024\001\002\000\004" +
    "\023\022\001\002\000\046\003\ufff8\004\ufff8\005\ufff8\006" +
    "\ufff8\007\ufff8\017\ufff8\021\ufff8\022\ufff8\025\ufff8\026\ufff8" +
    "\027\ufff8\030\ufff8\031\ufff8\032\ufff8\033\ufff8\034\ufff8\035" +
    "\ufff8\037\ufff8\001\002\000\006\003\025\020\026\001\002" +
    "\000\046\003\ufff9\004\ufff9\005\ufff9\006\ufff9\007\ufff9\017" +
    "\ufff9\021\ufff9\022\ufff9\025\ufff9\026\ufff9\027\ufff9\030\ufff9" +
    "\031\ufff9\032\ufff9\033\ufff9\034\ufff9\035\ufff9\037\ufff9\001" +
    "\002\000\004\020\115\001\002\000\004\021\027\001\002" +
    "\000\042\003\uffed\004\uffed\005\uffed\006\uffed\007\uffed\017" +
    "\uffed\021\uffed\022\uffed\025\uffed\026\uffed\027\uffed\030\uffed" +
    "\031\uffed\033\uffed\034\uffed\035\uffed\001\002\000\016\003" +
    "\ufff7\025\ufff7\026\ufff7\027\ufff7\030\ufff7\037\ufff7\001\002" +
    "\000\042\003\047\004\042\005\044\006\046\007\045\017" +
    "\041\021\027\022\050\025\006\026\017\027\016\030\010" +
    "\031\037\033\035\034\051\035\036\001\002\000\042\003" +
    "\uffee\004\uffee\005\uffee\006\uffee\007\uffee\017\uffee\021\uffee" +
    "\022\uffee\025\uffee\026\uffee\027\uffee\030\uffee\031\uffee\033" +
    "\uffee\034\uffee\035\uffee\001\002\000\014\012\056\013\054" +
    "\014\055\015\057\023\114\001\002\000\006\003\021\004" +
    "\113\001\002\000\004\017\107\001\002\000\014\004\042" +
    "\005\044\006\046\007\045\017\041\001\002\000\004\017" +
    "\077\001\002\000\044\003\uffe9\004\uffe9\005\uffe9\006\uffe9" +
    "\007\uffe9\017\uffe9\021\uffe9\022\uffe9\025\uffe9\026\uffe9\027" +
    "\uffe9\030\uffe9\031\uffe9\032\uffe9\033\uffe9\034\uffe9\035\uffe9" +
    "\001\002\000\014\004\042\005\044\006\046\007\045\017" +
    "\041\001\002\000\016\012\uffdf\013\uffdf\014\uffdf\015\uffdf" +
    "\020\uffdf\023\uffdf\001\002\000\044\003\uffec\004\uffec\005" +
    "\uffec\006\uffec\007\uffec\017\uffec\021\uffec\022\uffec\025\uffec" +
    "\026\uffec\027\uffec\030\uffec\031\uffec\032\uffec\033\uffec\034" +
    "\uffec\035\uffec\001\002\000\016\012\uffde\013\uffde\014\uffde" +
    "\015\uffde\020\uffde\023\uffde\001\002\000\016\012\uffdc\013" +
    "\uffdc\014\uffdc\015\uffdc\020\uffdc\023\uffdc\001\002\000\016" +
    "\012\uffdd\013\uffdd\014\uffdd\015\uffdd\020\uffdd\023\uffdd\001" +
    "\002\000\012\003\ufff1\004\ufff1\022\074\023\067\001\002" +
    "\000\046\003\ufff0\004\ufff0\005\ufff0\006\ufff0\007\ufff0\017" +
    "\ufff0\021\ufff0\022\ufff0\025\ufff0\026\ufff0\027\ufff0\030\ufff0" +
    "\031\ufff0\032\ufff0\033\ufff0\034\ufff0\035\ufff0\037\ufff0\001" +
    "\002\000\004\017\052\001\002\000\014\004\042\005\044" +
    "\006\046\007\045\017\041\001\002\000\014\012\056\013" +
    "\054\014\055\015\057\023\060\001\002\000\014\004\042" +
    "\005\044\006\046\007\045\017\041\001\002\000\014\004" +
    "\042\005\044\006\046\007\045\017\041\001\002\000\014" +
    "\004\042\005\044\006\046\007\045\017\041\001\002\000" +
    "\014\004\042\005\044\006\046\007\045\017\041\001\002" +
    "\000\014\004\042\005\044\006\046\007\045\017\041\001" +
    "\002\000\014\012\056\013\054\014\055\015\057\023\062" +
    "\001\002\000\014\004\042\005\044\006\046\007\045\017" +
    "\041\001\002\000\014\012\056\013\054\014\055\015\057" +
    "\020\064\001\002\000\040\003\066\004\042\005\044\006" +
    "\046\007\045\017\041\021\027\025\006\026\017\027\016" +
    "\030\010\031\037\033\035\034\051\035\036\001\002\000" +
    "\044\003\uffe5\004\uffe5\005\uffe5\006\uffe5\007\uffe5\017\uffe5" +
    "\021\uffe5\022\uffe5\025\uffe5\026\uffe5\027\uffe5\030\uffe5\031" +
    "\uffe5\032\uffe5\033\uffe5\034\uffe5\035\uffe5\001\002\000\010" +
    "\003\ufff1\004\ufff1\023\067\001\002\000\044\003\uffe4\004" +
    "\uffe4\005\uffe4\006\uffe4\007\uffe4\017\uffe4\021\uffe4\022\uffe4" +
    "\025\uffe4\026\uffe4\027\uffe4\030\uffe4\031\uffe4\032\uffe4\033" +
    "\uffe4\034\uffe4\035\uffe4\001\002\000\016\012\uffe0\013\uffe0" +
    "\014\uffe0\015\uffe0\020\uffe0\023\uffe0\001\002\000\016\012" +
    "\uffe3\013\uffe3\014\055\015\057\020\uffe3\023\uffe3\001\002" +
    "\000\016\012\uffe1\013\uffe1\014\uffe1\015\uffe1\020\uffe1\023" +
    "\uffe1\001\002\000\016\012\uffe2\013\uffe2\014\055\015\057" +
    "\020\uffe2\023\uffe2\001\002\000\046\003\uffef\004\uffef\005" +
    "\uffef\006\uffef\007\uffef\017\uffef\021\uffef\022\uffef\025\uffef" +
    "\026\uffef\027\uffef\030\uffef\031\uffef\032\uffef\033\uffef\034" +
    "\uffef\035\uffef\037\uffef\001\002\000\014\012\056\013\054" +
    "\014\055\015\057\020\076\001\002\000\016\012\uffdb\013" +
    "\uffdb\014\uffdb\015\uffdb\020\uffdb\023\uffdb\001\002\000\014" +
    "\004\042\005\044\006\046\007\045\017\041\001\002\000" +
    "\014\012\056\013\054\014\055\015\057\020\101\001\002" +
    "\000\040\003\066\004\042\005\044\006\046\007\045\017" +
    "\041\021\027\025\006\026\017\027\016\030\010\031\037" +
    "\033\035\034\051\035\036\001\002\000\044\003\uffe8\004" +
    "\uffe8\005\uffe8\006\uffe8\007\uffe8\017\uffe8\021\uffe8\022\uffe8" +
    "\025\uffe8\026\uffe8\027\uffe8\030\uffe8\031\uffe8\032\uffe8\033" +
    "\uffe8\034\uffe8\035\uffe8\001\002\000\040\003\066\004\042" +
    "\005\044\006\046\007\045\017\041\021\027\025\006\026" +
    "\017\027\016\030\010\031\037\033\035\034\051\035\036" +
    "\001\002\000\044\003\uffe7\004\uffe7\005\uffe7\006\uffe7\007" +
    "\uffe7\017\uffe7\021\uffe7\022\uffe7\025\uffe7\026\uffe7\027\uffe7" +
    "\030\uffe7\031\uffe7\032\uffe7\033\uffe7\034\uffe7\035\uffe7\001" +
    "\002\000\014\012\056\013\054\014\055\015\057\023\106" +
    "\001\002\000\044\003\uffeb\004\uffeb\005\uffeb\006\uffeb\007" +
    "\uffeb\017\uffeb\021\uffeb\022\uffeb\025\uffeb\026\uffeb\027\uffeb" +
    "\030\uffeb\031\uffeb\032\uffeb\033\uffeb\034\uffeb\035\uffeb\001" +
    "\002\000\014\004\042\005\044\006\046\007\045\017\041" +
    "\001\002\000\014\012\056\013\054\014\055\015\057\020" +
    "\111\001\002\000\040\003\066\004\042\005\044\006\046" +
    "\007\045\017\041\021\027\025\006\026\017\027\016\030" +
    "\010\031\037\033\035\034\051\035\036\001\002\000\044" +
    "\003\uffe6\004\uffe6\005\uffe6\006\uffe6\007\uffe6\017\uffe6\021" +
    "\uffe6\022\uffe6\025\uffe6\026\uffe6\027\uffe6\030\uffe6\031\uffe6" +
    "\032\uffe6\033\uffe6\034\uffe6\035\uffe6\001\002\000\004\023" +
    "\024\001\002\000\044\003\uffea\004\uffea\005\uffea\006\uffea" +
    "\007\uffea\017\uffea\021\uffea\022\uffea\025\uffea\026\uffea\027" +
    "\uffea\030\uffea\031\uffea\032\uffea\033\uffea\034\uffea\035\uffea" +
    "\001\002\000\004\021\027\001\002\000\016\003\ufff6\025" +
    "\ufff6\026\ufff6\027\ufff6\030\ufff6\037\ufff6\001\002\000\016" +
    "\003\ufffa\025\ufffa\026\ufffa\027\ufffa\030\ufffa\037\ufffa\001" +
    "\002\000\004\002\001\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\116\000\006\002\003\003\004\001\001\000\002\001" +
    "\001\000\012\004\006\005\010\006\014\013\012\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\004\011\027\001\001\000\004\012\030\001\001\000\002" +
    "\001\001\000\014\006\042\007\031\010\032\011\037\013" +
    "\033\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\004\010\104\001\001\000" +
    "\002\001\001\000\002\001\001\000\004\010\074\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\004\010\052\001\001\000" +
    "\002\001\001\000\004\010\072\001\001\000\004\010\071" +
    "\001\001\000\004\010\070\001\001\000\004\010\067\001" +
    "\001\000\004\010\060\001\001\000\002\001\001\000\004" +
    "\010\062\001\001\000\002\001\001\000\014\006\042\007" +
    "\064\010\032\011\037\013\033\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\004\010" +
    "\077\001\001\000\002\001\001\000\014\006\042\007\101" +
    "\010\032\011\037\013\033\001\001\000\002\001\001\000" +
    "\014\006\042\007\103\010\032\011\037\013\033\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\004\010\107\001\001\000\002\001\001\000\014\006\042" +
    "\007\111\010\032\011\037\013\033\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\004\011\115" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$Parser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$Parser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$Parser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}



    public ArrayList<String> syntaxErrors = new ArrayList<>();
    public ArrayList<String> semanticErrors = new ArrayList<>();

    private HashMap<String, String> symbolTable = new HashMap<>();

    private void declareVariable(String id, String type) {
        if (symbolTable.containsKey(id)) {
            semanticErrors.add("Error: Variable '" + id + "' ya ha sido declarada.");
        } else {
            symbolTable.put(id, type);
        }
    }

    private void checkVariable(String id) {
        if (!symbolTable.containsKey(id)) {
            syntaxErrors.add("Error: Variable '" + id + "' no ha sido declarada.");
        }
    }

    public ArrayList<String> getSyntaxErrors() {
        return syntaxErrors;
    }

    public ArrayList<String> getSemanticErrors() {
        return semanticErrors;
    }

    public void report_error(String message, Object info) {
        if (info instanceof Symbol) {
            Symbol sym = (Symbol) info;
            TokenInfo tokenInfo = (TokenInfo) sym.value;
            syntaxErrors.add(String.format("Syntax Error: %s near token '%s' at line %d, column %d",
                    message, tokenInfo.value, tokenInfo.line, tokenInfo.column));
        } else {
            syntaxErrors.add("Syntax Error: " + message);
        }
    }



/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$Parser$actions {
  private final Parser parser;

  /** Constructor */
  CUP$Parser$actions(Parser parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$Parser$do_action_part00000000(
    int                        CUP$Parser$act_num,
    java_cup.runtime.lr_parser CUP$Parser$parser,
    java.util.Stack            CUP$Parser$stack,
    int                        CUP$Parser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$Parser$result;

      /* select the action based on the action number */
      switch (CUP$Parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= program EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		RESULT = start_val;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$Parser$parser.done_parsing();
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // program ::= declaration_list END 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("program",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // program ::= declaration_list error 
            {
              Object RESULT =null;
		 report_error("Error: programa incompleto o declaración incorrecta", parser.scan()); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("program",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // declaration_list ::= declaration_list declaration 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("declaration_list",1, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // declaration_list ::= 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("declaration_list",1, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // declaration ::= var_decl 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("declaration",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // declaration ::= func_decl 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("declaration",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // declaration ::= error PUNTO_Y_COMA 
            {
              Object RESULT =null;
		 report_error("Error: declaración inválida", parser.scan()); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("declaration",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // var_decl ::= tipo ID PUNTO_Y_COMA 
            {
              Object RESULT =null;
		 declareVariable("id", "tipo"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("var_decl",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // var_decl ::= tipo error PUNTO_Y_COMA 
            {
              Object RESULT =null;
		 report_error("Error: declaración de variable incompleta", parser.scan()); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("var_decl",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // func_decl ::= tipo ID PARENTESIS_IZQ PARENTESIS_DER block 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("func_decl",3, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-4)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // func_decl ::= tipo ID PARENTESIS_IZQ error PARENTESIS_DER block 
            {
              Object RESULT =null;
		 report_error("Error: declaración de función inválida", parser.scan()); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("func_decl",3, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-5)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // tipo ::= INT 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("tipo",9, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // tipo ::= FLOAT 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("tipo",9, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // tipo ::= CHAR 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("tipo",9, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // tipo ::= VOID 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("tipo",9, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // tipo ::= error 
            {
              Object RESULT =null;
		 report_error("Error: tipo inválido", parser.scan()); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("tipo",9, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // block ::= LLAVE_IZQ statement_list LLAVE_DER 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("block",7, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // block ::= LLAVE_IZQ statement_list error LLAVE_DER 
            {
              Object RESULT =null;
		 report_error("Error: bloque de código inválido", parser.scan()); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("block",7, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // statement_list ::= statement_list statement 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("statement_list",8, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // statement_list ::= 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("statement_list",8, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // statement ::= var_decl 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("statement",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // statement ::= RETURN expr PUNTO_Y_COMA 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("statement",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // statement ::= expr PUNTO_Y_COMA 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("statement",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // statement ::= block 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("statement",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 25: // statement ::= IF PARENTESIS_IZQ expr PARENTESIS_DER statement 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("statement",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-4)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 26: // statement ::= IF PARENTESIS_IZQ expr PARENTESIS_DER statement ELSE statement 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("statement",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-6)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 27: // statement ::= WHILE PARENTESIS_IZQ expr PARENTESIS_DER statement 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("statement",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-4)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 28: // statement ::= FOR PARENTESIS_IZQ expr PUNTO_Y_COMA expr PUNTO_Y_COMA expr PARENTESIS_DER statement 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("statement",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-8)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 29: // statement ::= error PUNTO_Y_COMA 
            {
              Object RESULT =null;
		 report_error("Error en sentencia: declaración o expresión esperada", parser.scan()); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("statement",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 30: // expr ::= expr ADITIVO expr 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 31: // expr ::= expr SUSTRACTIVO expr 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 32: // expr ::= expr MULTIPLICACION expr 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 33: // expr ::= expr DIVISION expr 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 34: // expr ::= ID 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 35: // expr ::= NUM 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 36: // expr ::= CHAR_LITERAL 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 37: // expr ::= STRING 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 38: // expr ::= PARENTESIS_IZQ expr PARENTESIS_DER 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$Parser$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$Parser$do_action(
    int                        CUP$Parser$act_num,
    java_cup.runtime.lr_parser CUP$Parser$parser,
    java.util.Stack            CUP$Parser$stack,
    int                        CUP$Parser$top)
    throws java.lang.Exception
    {
              return CUP$Parser$do_action_part00000000(
                               CUP$Parser$act_num,
                               CUP$Parser$parser,
                               CUP$Parser$stack,
                               CUP$Parser$top);
    }
}

}
