lexer grammar LLanguage;
@header {
package ru.spbau.mit.utils;
}
// LEXER

@lexer::members {
    public boolean mismatched_brackets = false;
}

// Keywords

IF            : 'if';
THEN          : 'then';
ELSE          : 'else';
WHILE         : 'while';
DO            : 'do';
READ          : 'read';
WRITE         : 'write';
BEGIN         : 'begin';
END           : 'end';

// Floating-Point Literals
Float
    :   '-'? Integer Fractional? Exponent?
    |   '-'? '.' Digit+ Exponent?
    ;

fragment
Integer
    :   '0'
    |   NonZeroDigit Digits?
    ;

fragment
SignedInteger
    :   Sign? Integer
    ;

fragment
Sign
    :   [+-]
    ;

fragment
Digits
    :   Digit*
    ;

fragment
Digit
    :   '0'
    |   NonZeroDigit
    ;

fragment
NonZeroDigit
    :   [1-9]
    ;

fragment
Exponent
    :   [eE] SignedInteger
    ;

fragment
Fractional
    : '.' Digits
    ;

Boolean
    :   'true'
    |   'false'
    ;

// Separators

LPAREN          : '(';
RPAREN          : ')';
SEMICOLON       : ';';

// Operators

ASSIGN          : ':=';
GT              : '>';
LT              : '<';
EQ              : '==';
LEQ             : '<=';
GEQ             : '>=';
NEQ             : '!=';
AND             : '&&';
OR              : '||';
ADD             : '+';
SUB             : '-';
POW             : '**';
MUL             : '*';
DIV             : '/';
MOD             : '%';


COMMENT
    :   '(*' (COMMENT|ANY_EXCEPT_CLOSE_OR_OPEN)*? '*)' -> channel(HIDDEN)
    ;

fragment
ANY_EXCEPT_CLOSE_OR_OPEN
    :   '*' ~')'
    |  '(' ~'*'
    |   ~[*(]
    ;

LINE_COMMENT
    :   '//' ~[\r\n]* -> channel(HIDDEN)
    ;

// wild hacks to throw exception if brackets in comment were mismatched
ERROR_WHILE_PARSING_ML_COMMENT : '(*' {			throw new LexException(String.format("token recognition error at: %s at line %d in position %d", getText(), getLine(), getCharPositionInLine()));
case -1:
};

// Identifiers

Identifier
    :   [a-zA-Z_][a-zA-Z0-9_]*
    ;

//
// Whitespace and comments
//

WS  :  [ \t\r\n\f]+ -> skip
    ;