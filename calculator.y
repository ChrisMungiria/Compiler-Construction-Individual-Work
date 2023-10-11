%{
#include <stdio.h>
%}

%token NUMBER

%%

input: /* empty */
     | input line
     ;

line: '\n'
    | expr '\n'   { printf("Result: %d\n", $1); }
    ;

expr: NUMBER
    | expr '+' expr  { $$ = $1 + $3; }
    | expr '-' expr  { $$ = $1 - $3; }
    | expr '*' expr  { $$ = $1 * $3; }
    | expr '/' expr  { if ($3 != 0) $$ = $1 / $3; else { yyerror("Division by zero"); $$ = 0; } }
    ;

%%

int main() {
    yyparse();
    return 0;
}

void yyerror(const char *s) {
    fprintf(stderr, "Error: %s\n", s);
}

