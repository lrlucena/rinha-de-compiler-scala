grammar Rinha;

program: expr ;

expr: 'let' ID '=' expr ';' expr               # let   
    | 'if' '(' expr ')' block 'else' block     # if
    | 'fn' '(' ID (',' ID)* ')' '=>' block     # fun
    | 'print' '(' expr ')'                     # print
    | 'first' '(' expr ')'                     # first
    | 'second' '(' expr ')'                    # second
    | BOOL                                     # bool
    | INT                                      # int
    | STR                                      # str
    | ID                                       # id
    | expr '(' (expr (',' expr)*)? ')'         # call
    | '(' expr ',' expr ')'                    # tuple
    | expr ('*' | '/' | '%'        ) expr      # bin
    | expr ('+' | '-'              ) expr      # bin
    | expr ('<' | '>' | '<=' | '>=') expr      # bin
    | expr ('&&'                   ) expr      # bin
    | expr ('||'                   ) expr      # bin    
    | expr ('==' | '!='            ) expr      # bin
    ;

block: '{' expr '}' ;

INT: DIGIT+ ;
STR: '"' .*? '"' ;
BOOL: 'true' | 'false' ;
ID: ALPHA (ALPHA|DIGIT)*;
Space: [ \t\n\r] -> skip ;

fragment ALPHA : 'a' .. 'z' | 'A' .. 'Z' | '_' ;
fragment DIGIT : '0'..'9' ;