# Parser
The Parser is a lexical analyser that catches lexical errors .<br/>
Input -> Sequence of tokens produced by the lexer.<br/>
Output ->Analysed Sequence on tokens syntactically cottect.<br/>

## Grammar
```
<prog> -> <statlist> EOF
<statlist> -> <stat> <statlistp>
<statlistp> -> ; <stat> <statlistp> | epsilon
<stat> -> = ID <expr> | print ( <exprlist> ) | read ( ID ) | cond <whenlist> else <stat> | while ( <bexpr> ) <stat> | { <statlist> }
<whenlist> -> <whenitem> <whenlistp> 
<whenlistp> -> <whenitem> <whenlistp> | epsilon
<whenitem> -> when ( <bexpr> ) do <stat> 
<bexpr> -> RELOP <expr> <expr>
<expr> -> + ( <exprlist> ) | * ( <exprlist> ) | - <expr> <expr> | / <expr> <expr> | NUM | ID
<exprlist> -> <expr> <exprlistp>
<exprlistp> -> <expr> <exprlistp> | epsilon
```
