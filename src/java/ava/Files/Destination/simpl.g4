grammar simpl;

program : 'program' id fundef* body
        ;

fundef	: 'define' id '('param (',' param)*')' ('->' TYPE id)? body
	;

param 	: TYPE 'array'? id
	;

TYPE	: 'boolean'
	| 'integer'
	;

id 	: LETTER (LETTER | DIGIT)*
	;

body	: 'begin' vardecl* statements 'end'
	;

vardecl	: TYPE 'array'? id (',' id)* ';'
	;

statements : 'relax'
	| statement (';' statement)*
	;

statement : assign
	| 'leave'
	| xif
	| input
	| output
	| xwhile
	;

assign	: name (':=' (expr | 'array' simple))?
	;	

xif	: 'if' expr 'then' statements ('elsif' expr 'then statements')* ('else' statements)? 'end'
	;

xwhile 	: 'while' expr 'do' statements 'end'
	;

input	: 'read' name
	;

output	: 'write' (STRING | expr) ('.' (STRING | expr))*
	;

name 	: id ('[' simple ']' | '('name (',' name)* ')' | '('DIGIT (',' DIGIT)* ')')?
	;

expr 	: simple (RELOP simple)?
	;

RELOP 	: '='
	| '#'
	| '>'
	| '<'
	| '<='
	| '>='
	;

simple : '-'? term (ADDOP term)*
	;

term	: factor (MULOP factor)*
	;

MULOP	: '*'
	| '/'
	| '%'
	| 'and'
	;

ADDOP	: '+'
	| '-'
	| 'or'
	;

factor 	: num
	| name
	| '(' expr ')'
	| 'not' factor
	| 'true'
	| 'false'
	;

num	: (DIGIT)+
	;

STRING 	: '"' (ESC | .)*? '"'
	;

ESC	: '\\"' 
	| '\\\\'
	;

LETTER	: [a-zA-Z]+
	;

DIGIT	: [0-9]+
	;

WS	: [ \t\r\n]+ -> skip
	;


