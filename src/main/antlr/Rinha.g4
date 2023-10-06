grammar Rinha;

program: expr;

expr: 'print' '(' expr ')'                     # print
    | 'first' '(' expr ')'                     # first
    | 'second' '(' expr ')'                    # second
    | expr '(' (expr (',' expr)*)? ')'         # call
    | '(' expr ',' expr ')'                    # tuple
    | expr ('*' | '/' | '%'        ) expr      # bin
    | expr ('+' | '-'              ) expr      # bin
    | expr ('<' | '>' | '<=' | '>=') expr      # bin
    | expr ('&&'                   ) expr      # bin
    | expr ('||'                   ) expr      # bin    
    | expr ('==' | '!='            ) expr      # bin
    | '(' expr ')'                             # block
    | '{' expr '}'                             # block
    | BOOL                                     # bool
    | INT                                      # int
    | STR                                      # str
    | ID                                       # id
    | 'if' '(' expr ')' expr 'else' expr       # if
    | 'fn' '(' (ID (',' ID)*)? ')' '=>' expr   # fun
    | 'let' ID '=' expr ';' expr               # let
    ;

INT: DIGIT+ ;
STR: '"' .*? '"' ;
BOOL: 'true' | 'false' ;
ID: ALPHA (ALPHA|DIGIT)*;
Space: [ \t\n\r] -> skip ;
COMMENT : '//' .*? '\r'? '\n' -> skip ;

fragment ALPHA : 'a' .. 'z' | 'A' .. 'Z' | '_' ;
fragment DIGIT : '0'..'9' ;