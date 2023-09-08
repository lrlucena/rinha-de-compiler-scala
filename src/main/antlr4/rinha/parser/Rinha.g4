grammar Rinha;

program: expr;

expr: 'let' ID '=' expr ';' expr                  # let
    | 'if' expr '{' expr '}' 'else' '{' expr '}'  # if
    | 'fn' '(' ID* ')' '=>' '{' expr '}'          # fun
    | 'call' expr '(' expr* ')'                   # fun
    | 'print' expr                                # print
    | INT                                         # int
    | STR                                         # str
    | BOOL                                        # bool
    | '(' expr ',' expr ')'                       # tuple
    | INT                                         # int
    | ID                                          # id
    | expr ('*' | '/' | '%'        ) expr         # bin
    | expr ('+' | '-'              ) expr         # bin
    | expr ('<' | '>' | '<=' | '>=') expr         # bin
    | expr ('&&'                   ) expr         # bin
    | expr ('||'                   ) expr         # bin    
    | expr ('==' | '!='            ) expr         # bin
    | '(' expr ')'                                # par
    ;

INT: ('0'..'9')+ ;
ID: ('a'..'z')+;
STR: '"' .*? '"';
BOOL: ('true' | 'false');
Space: [ \t\n\r] -> skip;
