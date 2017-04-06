grammar LLanguage;

@header {
package ru.spbau.mit.utils;
}

program : statement (SEMICOLON statement)*;

statement
    : KSKIP
    | assignment
    | WRITE LPAREN expression RPAREN
    | READ LPAREN Id RPAREN
    | WHILE LPAREN expression RPAREN DO block
    | IF LPAREN expression RPAREN THEN block ELSE block;

block
    : BEGIN statement (SEMICOLON statement)* END
    | statement
    ;

assignment
    : Id ':=' expression;

expression
    : multexpr // priority 6
    | addexpr // priority 5
    | compexpr // priority 4
    | eqexpr // priority 3
    | andexpr // priority 2
    | orexpr // priority 1
    ;

andexpr
    : eqexpr
    | andexpr AND eqexpr
    ;

orexpr
    : addexpr
    | orexpr OR addexpr
    ;

eqexpr
    : compexpr
    | eqexpr EQ compexpr
    | eqexpr NEQ compexpr
    ;

compexpr
    : addexpr
    | compexpr LT addexpr
    | compexpr LEQ addexpr
    | compexpr GT addexpr
    | compexpr GEQ addexpr
    ;

addexpr
    : multexpr
    | addexpr ADD multexpr
    | addexpr SUB multexpr
    ;

multexpr
    : atomexpr (MUL multexpr)*
    | atomexpr (DIV multexpr)*
    | atomexpr (MOD multexpr)*
    ;

atomexpr
    : Id
    | Float
    | LPAREN expression RPAREN
    | Boolean
    ;


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
KSKIP          : 'skip';

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
    :   ~[*(]
    |   '*' {_input.LA(1) != ')'}?
    |   '(' {_input.LA(1) != '*'}?
    ;


LINE_COMMENT
    :   '//' ~[\r\n]* -> channel(HIDDEN)
    ;

// wild hacks to throw exception if brackets in comment were mismatched
ERROR_WHILE_PARSING_ML_COMMENT : '(*' {throw new LexException(String.format("token recognition error at: %s at line %d in position %d", getText(), getLine(), getCharPositionInLine()));
case -1:
};

ERROR_WHILE_PARSING_COMMENT : '*)' {throw new LexException(String.format("token recognition error at: %s at line %d in position %d", getText(), getLine(), getCharPositionInLine()));
case -1:
};

// Identifiers

Id
    :   [a-zA-Z_][a-zA-Z0-9_]*
    ;

// Whitespace

WS  :  [ \t\r\n\f]+ -> skip
    ;

