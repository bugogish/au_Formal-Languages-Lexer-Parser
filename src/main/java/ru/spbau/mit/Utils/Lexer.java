/* The following code was generated by JFlex 1.4.3 on 3/24/17 1:35 PM */

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

/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 3/24/17 1:35 PM from the specification file
 * <tt>Lang.flex</tt>
 */
public class Lexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\3\1\2\1\0\1\3\1\1\22\0\1\3\1\43\3\0"+
    "\1\42\1\46\1\0\1\35\1\36\1\41\1\11\1\0\1\14\1\10"+
    "\1\4\1\7\11\6\1\0\1\37\1\45\1\40\1\44\2\0\4\5"+
    "\1\12\25\5\4\0\1\5\1\0\1\31\1\32\1\5\1\26\1\21"+
    "\1\16\1\33\1\20\1\15\2\5\1\23\1\5\1\22\1\27\2\5"+
    "\1\30\1\24\1\17\1\34\1\5\1\25\3\5\1\0\1\13\uff83\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\2\2\1\3\1\4\2\5\1\1\1\6"+
    "\1\1\1\7\10\4\1\10\1\11\1\12\1\1\1\13"+
    "\1\14\1\1\1\15\1\16\1\1\1\17\1\5\1\0"+
    "\1\20\1\0\1\21\7\4\1\22\2\4\1\23\1\24"+
    "\1\25\1\26\1\27\2\17\2\5\1\0\3\4\1\30"+
    "\6\4\1\31\1\32\1\33\2\4\1\34\1\4\1\35"+
    "\1\36\1\37\1\40";

  private static int [] zzUnpackAction() {
    int [] result = new int[77];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\47\0\116\0\47\0\165\0\234\0\303\0\352"+
    "\0\u0111\0\47\0\u0138\0\u015f\0\u0186\0\u01ad\0\u01d4\0\u01fb"+
    "\0\u0222\0\u0249\0\u0270\0\u0297\0\47\0\47\0\47\0\u02be"+
    "\0\47\0\47\0\u02e5\0\u030c\0\u0333\0\u035a\0\u0381\0\u03a8"+
    "\0\u03cf\0\47\0\u0111\0\234\0\u03f6\0\u041d\0\u0444\0\u046b"+
    "\0\u0492\0\u04b9\0\u04e0\0\234\0\u0507\0\u052e\0\47\0\47"+
    "\0\47\0\47\0\47\0\u0555\0\47\0\u057c\0\47\0\u05a3"+
    "\0\u05ca\0\u05f1\0\u0618\0\234\0\u063f\0\u0666\0\u068d\0\u06b4"+
    "\0\u06db\0\u0702\0\234\0\234\0\234\0\u0729\0\u0750\0\234"+
    "\0\u0777\0\234\0\234\0\234\0\234";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[77];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\2\4\1\5\1\6\1\7\1\10\1\11"+
    "\1\12\1\6\1\13\1\14\1\15\1\16\1\17\1\6"+
    "\1\20\3\6\1\21\1\22\1\6\1\23\1\6\1\24"+
    "\2\6\1\25\1\26\1\27\1\30\1\31\1\32\1\33"+
    "\1\34\1\35\1\36\51\0\1\4\50\0\1\37\47\0"+
    "\3\6\2\0\1\6\2\0\20\6\20\0\2\7\1\40"+
    "\1\0\2\41\5\0\1\41\35\0\1\40\1\0\2\41"+
    "\5\0\1\41\33\0\2\40\52\0\1\42\41\0\1\7"+
    "\1\10\1\43\43\0\3\6\2\0\1\6\2\0\1\6"+
    "\1\44\16\6\17\0\3\6\2\0\1\6\2\0\14\6"+
    "\1\45\3\6\17\0\3\6\2\0\1\6\2\0\3\6"+
    "\1\46\7\6\1\47\4\6\17\0\3\6\2\0\1\6"+
    "\2\0\5\6\1\50\1\51\11\6\17\0\3\6\2\0"+
    "\1\6\2\0\3\6\1\52\7\6\1\53\4\6\17\0"+
    "\3\6\2\0\1\6\2\0\12\6\1\54\5\6\17\0"+
    "\3\6\2\0\1\6\2\0\4\6\1\55\13\6\17\0"+
    "\3\6\2\0\1\6\2\0\4\6\1\56\13\6\52\0"+
    "\1\57\46\0\1\60\46\0\1\61\46\0\1\62\54\0"+
    "\1\63\1\37\1\64\1\65\44\37\6\0\2\40\2\0"+
    "\2\41\5\0\1\41\33\0\1\66\1\67\1\0\1\70"+
    "\1\0\2\70\37\0\3\6\2\0\1\6\2\0\6\6"+
    "\1\71\11\6\17\0\3\6\2\0\1\6\2\0\4\6"+
    "\1\72\13\6\17\0\3\6\2\0\1\6\2\0\17\6"+
    "\1\73\17\0\3\6\2\0\1\6\2\0\11\6\1\74"+
    "\6\6\17\0\3\6\2\0\1\6\2\0\7\6\1\75"+
    "\10\6\17\0\3\6\2\0\1\6\2\0\1\76\17\6"+
    "\17\0\3\6\2\0\1\6\2\0\1\77\17\6\17\0"+
    "\3\6\2\0\1\6\2\0\14\6\1\100\3\6\17\0"+
    "\3\6\2\0\1\6\2\0\16\6\1\101\1\6\14\0"+
    "\1\65\52\0\2\66\45\0\1\66\1\67\44\0\3\6"+
    "\2\0\1\6\2\0\7\6\1\102\10\6\17\0\3\6"+
    "\2\0\1\6\2\0\5\6\1\103\12\6\17\0\3\6"+
    "\2\0\1\6\2\0\4\6\1\104\13\6\17\0\3\6"+
    "\2\0\1\6\2\0\4\6\1\105\13\6\17\0\3\6"+
    "\2\0\1\6\2\0\6\6\1\106\11\6\17\0\3\6"+
    "\2\0\1\6\2\0\2\6\1\107\15\6\17\0\3\6"+
    "\2\0\1\6\2\0\11\6\1\110\6\6\17\0\3\6"+
    "\2\0\1\6\2\0\1\111\17\6\17\0\3\6\2\0"+
    "\1\6\2\0\4\6\1\112\13\6\17\0\3\6\2\0"+
    "\1\6\2\0\4\6\1\113\13\6\17\0\3\6\2\0"+
    "\1\6\2\0\4\6\1\114\13\6\17\0\3\6\2\0"+
    "\1\6\2\0\5\6\1\115\12\6\12\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[1950];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\1\1\1\11\5\1\1\11\12\1\3\11"+
    "\1\1\2\11\6\1\1\0\1\11\1\0\13\1\5\11"+
    "\1\1\1\11\1\1\1\11\1\0\25\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[77];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
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


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public Lexer(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  public Lexer(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 120) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) throws LexException {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new LexException(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  throws LexException {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public Lexem yylex() throws java.io.IOException, LexException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      for (zzCurrentPosL = zzStartRead; zzCurrentPosL < zzMarkedPosL;
                                                             zzCurrentPosL++) {
        switch (zzBufferL[zzCurrentPosL]) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn++;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 8: 
          { return bracket(LBracket);
          }
        case 33: break;
        case 11: 
          { return operator(Multiplication);
          }
        case 34: break;
        case 4: 
          { return ident(yytext());
          }
        case 35: break;
        case 32: 
          { return keyword(KW_Begin);
          }
        case 36: break;
        case 23: 
          { return operator(And);
          }
        case 37: break;
        case 5: 
          { return numeric(new Double(yytext()));
          }
        case 38: break;
        case 1: 
          { throw new LexException(String.format("Character %s at line %d in position %d was not recognized.", yytext(),
                                                                                            yyline, yycolumn));
          }
        case 39: break;
        case 26: 
          { return bool(true);
          }
        case 40: break;
        case 30: 
          { return keyword(KW_While);
          }
        case 41: break;
        case 24: 
          { return keyword(KW_End);
          }
        case 42: break;
        case 3: 
          { return operator(Division);
          }
        case 43: break;
        case 19: 
          { return operator(Eq);
          }
        case 44: break;
        case 29: 
          { return bool(false);
          }
        case 45: break;
        case 15: 
          { return comment(yytext().substring(2));
          }
        case 46: break;
        case 16: 
          { return operator(Or);
          }
        case 47: break;
        case 7: 
          { return operator(Minus);
          }
        case 48: break;
        case 6: 
          { return operator(Plus);
          }
        case 49: break;
        case 17: 
          { return keyword(KW_If);
          }
        case 50: break;
        case 27: 
          { return keyword(KW_Else);
          }
        case 51: break;
        case 13: 
          { return operator(Greater);
          }
        case 52: break;
        case 21: 
          { return operator(Geq);
          }
        case 53: break;
        case 12: 
          { return operator(Mod);
          }
        case 54: break;
        case 28: 
          { return keyword(KW_Read);
          }
        case 55: break;
        case 22: 
          { return operator(Leq);
          }
        case 56: break;
        case 31: 
          { return keyword(KW_Write);
          }
        case 57: break;
        case 18: 
          { return keyword(KW_Do);
          }
        case 58: break;
        case 10: 
          { return colon();
          }
        case 59: break;
        case 25: 
          { return keyword(KW_Then);
          }
        case 60: break;
        case 14: 
          { return operator(Less);
          }
        case 61: break;
        case 20: 
          { return operator(Neq);
          }
        case 62: break;
        case 2: 
          { 
          }
        case 63: break;
        case 9: 
          { return bracket(RBracket);
          }
        case 64: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            return null;
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
