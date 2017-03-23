package ru.spbau.mit;

import ru.spbau.mit.Lexems.Lexem;
import ru.spbau.mit.Utils.Lexer;

import java.io.FileReader;
import java.util.ArrayList;

public class Lex {
    public static void main(String argv[]) {
            if (argv.length == 0 || argv.length > 1) {
                System.out.println("Usage : Lexer <inputfile>");
            }
            else {
                try(java.io.FileReader reader = new FileReader(argv[0])) {
                  ArrayList<Lexem> lexems = Lexer.run(reader);
                  for (Lexem lex : lexems) {
                      System.out.println(lex);
                  }
                }
                catch (java.io.FileNotFoundException e) {
                    System.out.println("File not found : \""+argv[0]+"\"");
                }
                catch (java.io.IOException e) {
                    System.out.println("IO error scanning file \""+argv[0]+"\"");
                    System.out.println(e.getMessage());
                }
            }
        }
}
