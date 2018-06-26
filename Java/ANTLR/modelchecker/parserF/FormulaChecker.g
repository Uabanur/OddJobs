grammar FormulaChecker;

options { language = Java; }

@header {
package modelchecker.parserF;
import modelchecker.astF.*; }

@lexer::header {
package modelchecker.parserF; }

formula returns [Formula value]
	: p=phi  EOF  {$value = new Formula(p); } ;

phi returns [Phi value]
	: 'TT' 	{$value = new Phi("tt"); }
	|  AP 	{$value = new Phi($AP.getText()); }
	| 'EX['ex=phi']' 	{$value = new EXPhi(ex); }
	| 'EF['ef=phi']' 	{$value = new EFPhi(ef); }
	| 'AX['ax=phi']' 	{$value = new AXPhi(ax); }
	| 'AG['ag=phi']' 	{$value = new AGPhi(ag); }
	| 'NOT['not=phi']' 	{$value = new NOTPhi(not); }
	| 'AND['a1=phi']['a2=phi']' {$value = new ANDPhi(a1, a2); } ;

AP  : 'a'..'z'+ ;
WS  :   (' '|'\t'|'\r'|'\n')+ { $channel = HIDDEN; } ; 
