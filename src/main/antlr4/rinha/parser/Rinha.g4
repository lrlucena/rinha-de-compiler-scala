grammar Rinha;

program: expr ;

expr: 'let' ID '=' expr ';' expr               # let   
    | 'if' '(' expr ')' block 'else' block     # if
    | 'fn' '(' params ')' '=>' block           # fun
    | expr '(' exprs ')'                       # call
    | 'print' expr                             # print
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
    | '-' expr                                 # una
    | '!' expr                                 # una
    | '(' expr ')'                             # par
    ;

block: expr | '{' expr '}' ;
params: ID (',' ID)* ;
exprs: expr (',' expr)* ;

INT: ('0'..'9')+ ;
ID: ('a'..'z')+; 
STR: '"' .*? '"' ;
BOOL: ('true' | 'false') ;
Space: [ \t\n\r] -> skip ;
