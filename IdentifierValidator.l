%{
#include <stdio.h>
%}

%option noyywrap

%%
[a-zA-Z_$][a-zA-Z0-9_$]* {
    // Check if it's a reserved keyword
    if (isReservedKeyword(yytext)) {
        printf("Reserved Keyword: %s\n", yytext);
    } else {
        printf("Valid Identifier: %s\n", yytext);
    }
}

// Define rules for reserved keywords
"abstract"|"assert"|"boolean"|"break"|"byte"|"case"|"catch"|"char"|"class"|"const"|
"continue"|"default"|"do"|"double"|"else"|"enum"|"extends"|"final"|"finally"|"float"|
"for"|"goto"|"if"|"implements"|"import"|"instanceof"|"int"|"interface"|"long"|"native"|
"new"|"package"|"private"|"protected"|"public"|"return"|"short"|"static"|"strictfp"|
"super"|"switch"|"synchronized"|"this"|"throw"|"throws"|"transient"|"try"|"void"|
"volatile"|"while" {
    printf("Reserved Keyword: %s\n", yytext);
}

.|\n {
    printf("Invalid Token: %s\n", yytext);
}
%%

int isReservedKeyword(char* keyword) {
    return (
        !strcmp(keyword, "abstract") || !strcmp(keyword, "assert") || !strcmp(keyword, "boolean") ||
        // Include all other reserved keywords here...
        !strcmp(keyword, "volatile") || !strcmp(keyword, "while")
    );
}

int main(int argc, char** argv) {
    yylex();
    return 0;
}

