%{
#include "y.tab.h"  // Include YACC header file for token definitions
%}

%%

[0-9]+              { yylval = atoi(yytext); return NUMBER; }
[-+*/\n]            { return yytext[0]; }
[ \t]               ;  // Ignore whitespace
.                   ;

%%

int yywrap() {
    return 1;
}
