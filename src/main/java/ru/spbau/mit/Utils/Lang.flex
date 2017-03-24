/* Программы на языке L записываются символами ASCII. Ограничителями строк являются ASCII-символы
   CR, LF или 2 подряд идущих символа: CR LF. Пробельными символами являются символы-ограничители
   строк и символы пробела (SP), табуляции (HT) и перевода страницы (FF). Пробельные символы не имеют
   значения, для них не должно генерироваться лексем.
   Комментарии только однострочные. Комментарием считается суффикс строки до символа-ограничителя
   строк, начинающийся с "//".
   Идентификаторы в языке — произвольная последовательность символов (до первого пробельного симво-
   ла), начинающаяся либо с буквы, либо символа подчеркивания (_), которая не является ключевым словом.
   Ключевые слова языка: if, then, else, while, do, read, write, begin, end
   Литералы языка: числа с плавающей точкой, true, false.
   Операторы языка: +, −, ∗, /, %, ==, !=, >, >=, <, <=, &&, ||
   Разделители языка: (, ), ;
*/

package ru.spbau.mit.Utils;

import java.io.IOException;
import java.util.ArrayList;

import ru.spbau.mit.Lexems.*;
import static ru.spbau.mit.Lexems.LexemType.*;
%%

%public
%class Lexer
%type Lexem
%line
%column
%scanerror LexException

%{
  private Lexem keyword(LexemType type) {
    return new KeyWord(type, yyline, yycolumn, yycolumn + yytext().length() - 1);
  }
  private Lexem bool(boolean value) {
      return new Bool(yyline, yycolumn, yycolumn + yytext().length() - 1, value);
  }
  private Lexem bracket(LexemType type) {
      return new Bracket(type, yyline, yycolumn, yycolumn + yytext().length() - 1);
  }
  private Lexem colon() {
      return new Colon(yyline, yycolumn, yycolumn + yytext().length() - 1);
  }
  private Lexem operator(LexemType type) {
      return new Operator(type, yyline, yycolumn, yycolumn + yytext().length() - 1);
  }
  private Lexem ident(String ident) {
        return new Identifier(yyline, yycolumn, yycolumn + yytext().length() - 1, ident);
  }
  private Lexem numeric(Double value) {
          return new NumericValue(yyline, yycolumn, yycolumn + yytext().length() - 1, value);
  }
  private Lexem comment(String comment) {
          return new Comment(yyline, yycolumn, yycolumn + yytext().length() - 1, comment);
    }

   public static ArrayList<Lexem> run(java.io.Reader reader) throws IOException, LexException {
      Lexer lexer;
      ArrayList<Lexem> lexems = new ArrayList<>();
      lexer = new Lexer(reader);
      while (!lexer.zzAtEOF) {
          Lexem lexem = lexer.yylex();
          if (lexem != null) {
              lexems.add(lexem);
          }
      }
      return lexems;
    }
%}

EndOfLine = \r|\n|\r\n
Space = {EndOfLine}|\t|\f|[ ]

CommentText = [^\r\n]
Comment = "//"{CommentText}*{EndOfLine}?

Identifier = [a-zA-Z_][a-zA-Z0-9_]*

Integer = 0 | [1-9][0-9]*
Fractional = \.[0-9]*
SignedInteger = 0|[+|-]?{Integer}
Exponent = [e|E]{SignedInteger}

DoubleNumber = -?{Integer}{Fractional}?{Exponent}? | -?\.[0-9]+{Exponent}?
%%


<YYINITIAL> {
    "if"              { return keyword(KW_If); }
    "then"            { return keyword(KW_Then); }
    "else"            { return keyword(KW_Else); }
    "while"           { return keyword(KW_While); }
    "do"              { return keyword(KW_Do); }
    "read"            { return keyword(KW_Read); }
    "write"           { return keyword(KW_Write); }
    "begin"           { return keyword(KW_Begin); }
    "end"             { return keyword(KW_End); }

     "true"                          {return bool(true);}
     "false"                         {return bool(false);}

      "("                            { return bracket(LBracket); }
      ")"                            { return bracket(RBracket); }
      ";"                            { return colon(); }

      "=="                           { return operator(Eq); }
      "+"                            { return operator(Plus); }
      "-"                            { return operator(Minus); }
      "*"                            { return operator(Multiplication); }
      "/"                            { return operator(Division); }
      "%"                            { return operator(Mod); }
      "!="                           { return operator(Neq); }
      ">"                            { return operator(Greater); }
      ">="                           { return operator(Geq); }
      "<"                            { return operator(Less); }
      "<="                           { return operator(Leq); }
      "&&"                           { return operator(And); }
      "||"                           { return operator(Or); }

      {DoubleNumber}                 {return numeric(new Double(yytext()));}

      {Comment}                      {return comment(yytext().substring(2));}

      {Space}                        {}

      {Identifier}                   { return ident(yytext()); }
}

[^]                              { throw new LexException(String.format("Character %s at line %d from position %d to %d was not recognized.", yytext(),
                                                                                            yyline, yycolumn, yycolumn + yytext().length() - 1)); }