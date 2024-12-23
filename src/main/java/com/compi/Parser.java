
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package com.compi;

import java.util.HashMap;
import java.util.ArrayList;
import java_cup.runtime.Symbol;
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
    "\000\037\000\002\002\004\000\002\002\004\000\002\003" +
    "\004\000\002\003\002\000\002\004\003\000\002\004\003" +
    "\000\002\004\004\000\002\006\005\000\002\006\005\000" +
    "\002\006\005\000\002\005\003\000\002\005\003\000\002" +
    "\005\003\000\002\005\007\000\002\011\005\000\002\012" +
    "\004\000\002\012\002\000\002\007\003\000\002\007\005" +
    "\000\002\007\004\000\002\007\003\000\002\007\004\000" +
    "\002\010\005\000\002\010\005\000\002\010\005\000\002" +
    "\010\005\000\002\010\003\000\002\010\003\000\002\010" +
    "\003\000\002\010\003\000\002\010\005" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\067\000\016\003\ufffe\025\ufffe\026\ufffe\027\ufffe\030" +
    "\ufffe\037\ufffe\001\002\000\004\002\071\001\002\000\016" +
    "\003\012\025\006\026\015\027\016\030\010\037\013\001" +
    "\002\000\020\003\ufff7\004\067\025\ufff7\026\ufff7\027\ufff7" +
    "\030\ufff7\037\ufff7\001\002\000\016\003\uffff\025\uffff\026" +
    "\uffff\027\uffff\030\uffff\037\uffff\001\002\000\004\004\024" +
    "\001\002\000\016\003\ufffc\025\ufffc\026\ufffc\027\ufffc\030" +
    "\ufffc\037\ufffc\001\002\000\004\023\023\001\002\000\004" +
    "\002\000\001\002\000\016\003\ufffd\025\ufffd\026\ufffd\027" +
    "\ufffd\030\ufffd\037\ufffd\001\002\000\020\003\ufff6\004\021" +
    "\025\ufff6\026\ufff6\027\ufff6\030\ufff6\037\ufff6\001\002\000" +
    "\020\003\ufff5\004\017\025\ufff5\026\ufff5\027\ufff5\030\ufff5" +
    "\037\ufff5\001\002\000\004\023\020\001\002\000\036\003" +
    "\ufff8\004\ufff8\005\ufff8\006\ufff8\007\ufff8\017\ufff8\021\ufff8" +
    "\022\ufff8\025\ufff8\026\ufff8\027\ufff8\030\ufff8\035\ufff8\037" +
    "\ufff8\001\002\000\004\023\022\001\002\000\036\003\ufff9" +
    "\004\ufff9\005\ufff9\006\ufff9\007\ufff9\017\ufff9\021\ufff9\022" +
    "\ufff9\025\ufff9\026\ufff9\027\ufff9\030\ufff9\035\ufff9\037\ufff9" +
    "\001\002\000\016\003\ufffb\025\ufffb\026\ufffb\027\ufffb\030" +
    "\ufffb\037\ufffb\001\002\000\004\017\025\001\002\000\004" +
    "\020\026\001\002\000\004\021\027\001\002\000\032\003" +
    "\ufff1\004\ufff1\005\ufff1\006\ufff1\007\ufff1\017\ufff1\021\ufff1" +
    "\022\ufff1\025\ufff1\026\ufff1\027\ufff1\035\ufff1\001\002\000" +
    "\016\003\ufff4\025\ufff4\026\ufff4\027\ufff4\030\ufff4\037\ufff4" +
    "\001\002\000\032\003\042\004\040\005\032\006\044\007" +
    "\037\017\035\021\027\022\034\025\033\026\050\027\047" +
    "\035\045\001\002\000\016\012\uffe6\013\uffe6\014\uffe6\015" +
    "\uffe6\020\uffe6\023\uffe6\001\002\000\004\004\067\001\002" +
    "\000\036\003\ufff3\004\ufff3\005\ufff3\006\ufff3\007\ufff3\017" +
    "\ufff3\021\ufff3\022\ufff3\025\ufff3\026\ufff3\027\ufff3\030\ufff3" +
    "\035\ufff3\037\ufff3\001\002\000\014\004\040\005\032\006" +
    "\044\007\037\017\035\001\002\000\032\003\uffed\004\uffed" +
    "\005\uffed\006\uffed\007\uffed\017\uffed\021\uffed\022\uffed\025" +
    "\uffed\026\uffed\027\uffed\035\uffed\001\002\000\016\012\uffe4" +
    "\013\uffe4\014\uffe4\015\uffe4\020\uffe4\023\uffe4\001\002\000" +
    "\016\012\uffe7\013\uffe7\014\uffe7\015\uffe7\020\uffe7\023\uffe7" +
    "\001\002\000\032\003\ufff2\004\ufff2\005\ufff2\006\ufff2\007" +
    "\ufff2\017\ufff2\021\ufff2\022\ufff2\025\ufff2\026\ufff2\027\ufff2" +
    "\035\ufff2\001\002\000\004\023\064\001\002\000\014\012" +
    "\054\013\052\014\053\015\055\023\063\001\002\000\016" +
    "\012\uffe5\013\uffe5\014\uffe5\015\uffe5\020\uffe5\023\uffe5\001" +
    "\002\000\014\004\040\005\032\006\044\007\037\017\035" +
    "\001\002\000\032\003\ufff0\004\ufff0\005\ufff0\006\ufff0\007" +
    "\ufff0\017\ufff0\021\ufff0\022\ufff0\025\ufff0\026\ufff0\027\ufff0" +
    "\035\ufff0\001\002\000\004\004\017\001\002\000\004\004" +
    "\021\001\002\000\014\012\054\013\052\014\053\015\055" +
    "\023\056\001\002\000\014\004\040\005\032\006\044\007" +
    "\037\017\035\001\002\000\014\004\040\005\032\006\044" +
    "\007\037\017\035\001\002\000\014\004\040\005\032\006" +
    "\044\007\037\017\035\001\002\000\014\004\040\005\032" +
    "\006\044\007\037\017\035\001\002\000\032\003\uffef\004" +
    "\uffef\005\uffef\006\uffef\007\uffef\017\uffef\021\uffef\022\uffef" +
    "\025\uffef\026\uffef\027\uffef\035\uffef\001\002\000\016\012" +
    "\uffe8\013\uffe8\014\uffe8\015\uffe8\020\uffe8\023\uffe8\001\002" +
    "\000\016\012\uffeb\013\uffeb\014\053\015\055\020\uffeb\023" +
    "\uffeb\001\002\000\016\012\uffe9\013\uffe9\014\uffe9\015\uffe9" +
    "\020\uffe9\023\uffe9\001\002\000\016\012\uffea\013\uffea\014" +
    "\053\015\055\020\uffea\023\uffea\001\002\000\032\003\uffee" +
    "\004\uffee\005\uffee\006\uffee\007\uffee\017\uffee\021\uffee\022" +
    "\uffee\025\uffee\026\uffee\027\uffee\035\uffee\001\002\000\032" +
    "\003\uffec\004\uffec\005\uffec\006\uffec\007\uffec\017\uffec\021" +
    "\uffec\022\uffec\025\uffec\026\uffec\027\uffec\035\uffec\001\002" +
    "\000\014\012\054\013\052\014\053\015\055\020\066\001" +
    "\002\000\016\012\uffe3\013\uffe3\014\uffe3\015\uffe3\020\uffe3" +
    "\023\uffe3\001\002\000\004\023\070\001\002\000\036\003" +
    "\ufffa\004\ufffa\005\ufffa\006\ufffa\007\ufffa\017\ufffa\021\ufffa" +
    "\022\ufffa\025\ufffa\026\ufffa\027\ufffa\030\ufffa\035\ufffa\037" +
    "\ufffa\001\002\000\004\002\001\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\067\000\006\002\003\003\004\001\001\000\002\001" +
    "\001\000\010\004\006\005\010\006\013\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\004\011" +
    "\027\001\001\000\004\012\030\001\001\000\002\001\001" +
    "\000\012\006\045\007\040\010\042\011\035\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\004" +
    "\010\064\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\004\010\050\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\004\010\061\001\001\000\004\010\060\001" +
    "\001\000\004\010\057\001\001\000\004\010\056\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001" });

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
            semanticErrors.add("Error: Variable '" + id + "' no ha sido declarada.");
        }
    }

    public ArrayList<String> getSyntaxErrors() {
        return syntaxErrors;
    }

    public ArrayList<String> getSemanticErrors() {
        return semanticErrors;
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
          case 2: // declaration_list ::= declaration_list declaration 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("declaration_list",1, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // declaration_list ::= 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("declaration_list",1, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // declaration ::= var_decl 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("declaration",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // declaration ::= func_decl 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("declaration",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // declaration ::= error PUNTO_Y_COMA 
            {
              Object RESULT =null;
		 syntaxErrors.add("Error en declaración."); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("declaration",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // var_decl ::= INT ID PUNTO_Y_COMA 
            {
              Object RESULT =null;
		 declareVariable("id", "int"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("var_decl",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // var_decl ::= FLOAT ID PUNTO_Y_COMA 
            {
              Object RESULT =null;
		 declareVariable("id", "float"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("var_decl",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // var_decl ::= CHAR ID PUNTO_Y_COMA 
            {
              Object RESULT =null;
		 declareVariable("id", "char"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("var_decl",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // func_decl ::= INT 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("func_decl",3, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // func_decl ::= FLOAT 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("func_decl",3, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // func_decl ::= CHAR 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("func_decl",3, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // func_decl ::= VOID ID PARENTESIS_IZQ PARENTESIS_DER block 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("func_decl",3, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-4)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // block ::= LLAVE_IZQ statement_list LLAVE_DER 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("block",7, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // statement_list ::= statement_list statement 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("statement_list",8, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // statement_list ::= 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("statement_list",8, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // statement ::= var_decl 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("statement",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // statement ::= RETURN expr PUNTO_Y_COMA 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("statement",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // statement ::= expr PUNTO_Y_COMA 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("statement",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // statement ::= block 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("statement",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // statement ::= error PUNTO_Y_COMA 
            {
              Object RESULT =null;
		 syntaxErrors.add("Error en sentencia."); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("statement",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // expr ::= expr ADITIVO expr 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // expr ::= expr SUSTRACTIVO expr 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // expr ::= expr MULTIPLICACION expr 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 25: // expr ::= expr DIVISION expr 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 26: // expr ::= ID 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 27: // expr ::= NUM 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 28: // expr ::= CHAR_LITERAL 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 29: // expr ::= STRING 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 30: // expr ::= PARENTESIS_IZQ expr PARENTESIS_DER 
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
