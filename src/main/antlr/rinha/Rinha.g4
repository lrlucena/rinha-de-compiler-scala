grammar Rinha;

program: expr ;

expr: 'let' ID '=' expr ';' expr               # let   
    | 'if' '(' expr ')' block 'else' block     # if
    | 'fn' '(' ID (',' ID)* ')' '=>' block     # fun
    | 'print' '(' expr ')'                     # print
    | 'first' '(' expr ')'                     # first
    | 'second' '(' expr ')'                    # second
    | expr '(' expr (',' expr)* ')'            # call
    | INT                                      # int
    | STR                                      # str
    | BOOL                                     # bool
    | INT                                      # int
    | ID                                       # id
    | '(' expr ',' expr ')'                    # tuple
    | expr ('*' | '/' | '%'        ) expr      # bin
    | expr ('+' | '-'              ) expr      # bin
    | expr ('<' | '>' | '<=' | '>=') expr      # bin
    | expr ('&&'                   ) expr      # bin
    | expr ('||'                   ) expr      # bin    
    | expr ('==' | '!='            ) expr      # bin
    ;

block: '{' expr '}' ;

INT: ('0'..'9')+ ;
ID: ('a'..'z')+;
STR: '"' .*? '"' ;
BOOL: ('true' | 'false') ;
Space: [ \t\n\r] -> skip ;
