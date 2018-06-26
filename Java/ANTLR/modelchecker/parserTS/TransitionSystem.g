grammar TransitionSystem;

options {
  language = Java;
}

@header {
package modelchecker.parserTS;

import modelchecker.astTS.*;
import java.util.LinkedList;

}

@lexer::header {
package modelchecker.parserTS;

}


system returns [TransitionSystem value]
  : e=states EOF  {$value = new TransitionSystem(e); }
  ;

states returns [LinkedList<State> value]
  : s=state {$value = new LinkedList<State>(); $value.add(s); }
      (s=state {$value.add(s); } )*
  |         {$value = new LinkedList<State>(); }
  ;

state returns [State value]
  :  '{' s=state_info '[' a=atom_props ']' e=edges '}' {$value = new State(s, a, e); }
  ;

state_info returns [StateInfo value]
 :  S '*'   {$value = new StateInfo(Integer.parseInt($S.getText()), true); }
 |  S       {$value = new StateInfo(Integer.parseInt($S.getText()), false); }
 ;

atom_props returns [LinkedList<String> value]
  : a=atom    {$value = new LinkedList<String>(); $value.add(a); }
    (',' a=atom {$value.add(a); } )*
  |    {$value = new LinkedList<String>(); }
  ;

atom returns [String value]
  : P  {$value = $P.getText(); }
  ;

edges returns [LinkedList<Integer> value]
  : e=edge        {$value = new LinkedList<Integer>(); $value.add(e); }
    ( e=edge      {$value.add(e); } )*
  |               {$value = new LinkedList<Integer>(); }
  ;

edge returns [Integer value]
  :  S    {$value = Integer.parseInt($S.getText()); }
  ;

S : '0'..'9'+ ;
P  : 'a'..'z'+ ;



WS  :   (' '|'\t'|'\r'|'\n')+ { $channel = HIDDEN; } ; 


