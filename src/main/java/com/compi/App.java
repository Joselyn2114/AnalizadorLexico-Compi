package com.compi;

import picocli.CommandLine;

import java.io.BufferedReader;
import java.io.File;
import java.io.StringReader;
import java.nio.file.Files;
import java.util.*;
import java.util.concurrent.Callable;

@CommandLine.Command(name = "compi", mixinStandardHelpOptions = true,version = "0.0.1",
description = "Simple lexer that recognizes ID, Num and EOF")
public class App implements Callable<Integer>
{
    @CommandLine.Option(names = {"-f","--file"}, description = "File to read", required = false)
    private File file;

       @Override
    public Integer call() throws Exception {

           if(file!=null){
               Map<String, TreeMap<String, List<Integer>>> tokenMap = new HashMap<>();
               int LineNumber = 1;
               BufferedReader bfr = Files.newBufferedReader(file.toPath());
               DemoLexer lexer = new DemoLexer(bfr);
               Token token = lexer.yylex();
               while(token.getTokenType()!= TokenConstant.EOF){
                   if(token.getTokenType()==TokenConstant.NEWLINE){
                       LineNumber++;
                       token = lexer.yylex();
                   }else {
                       tokenMap.putIfAbsent(token.getLexema(), new TreeMap<>());
                       TreeMap<String, List<Integer>> innerMap = tokenMap.get(token.getLexema());

                       innerMap.putIfAbsent(token.getTokenType().name(), new ArrayList<>());
                       List<Integer> lineNumbers = innerMap.get(token.getTokenType().name());
                       lineNumbers.add(LineNumber);
                       //System.out.println(token);
                       token = lexer.yylex();
                   }
               }
               System.out.println("LISTA DE TOKENS Y OCURRENCIAS");
               printHeaders();
               printTokenMap(tokenMap);
           }else {

               Scanner scanner = new Scanner(System.in);
               String input = "";
               while (!input.equals("exit")) {
                   System.out.print("Por favor ingrese la cadena > ");
                   input = scanner.nextLine();
                   if (input.equals("exit")) {
                       break;
                   }
                   DemoLexer demoLexer = new DemoLexer(new StringReader(input));
                   Token token = demoLexer.yylex();
                   System.out.println(token);
               }
           }
           return 0;
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }

    private static void printTokenMap(Map<String, TreeMap<String, List<Integer>>> tokenMap) {

           for (Map.Entry<String, TreeMap<String, List<Integer>>> tokenEntry : tokenMap.entrySet()) {
               String token = tokenEntry.getKey();
               TreeMap<String, List<Integer>> innerMap = tokenEntry.getValue();

               for (Map.Entry<String, List<Integer>> typeEntry : innerMap.entrySet()) {
                   String tokenType = typeEntry.getKey();
                   List<Integer> lineNumbers = typeEntry.getValue();
                   StringBuilder lineInfo = new StringBuilder();
                   Map<Integer, Integer> lineCount = new LinkedHashMap<>();

                   for (Integer lineNumber : lineNumbers) {
                       lineCount.put(lineNumber, lineCount.getOrDefault(lineNumber, 0) + 1);
                   }

                   for (Map.Entry<Integer, Integer> entry : lineCount.entrySet()) {
                       lineInfo.append(entry.getKey());
                       if (entry.getValue() > 1) {
                           lineInfo.append("(").append(entry.getValue()).append(")");
                       }
                       lineInfo.append(", ");

                   }

                   if (lineInfo.length() > 0) {
                       lineInfo.setLength(lineInfo.length() - 2);
                   }

                   System.out.printf("%-20s %-20s %-30s%n", token, tokenType, lineInfo.toString());
               }
           }
    }

    private static void printHeaders() {
        System.out.printf("%-20s %-20s %-30s%n", "Token", "Tipo de Token", "Concurrencias");
        System.out.println("---------------------------------------------------------------");
    }
}