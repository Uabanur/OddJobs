// $ANTLR 3.5.2 modelchecker/parserTS/TransitionSystem.g 2017-04-26 11:13:09

package modelchecker.parserTS;

import modelchecker.astTS.*;
import java.util.LinkedList;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class TransitionSystemParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "P", "S", "WS", "'*'", "','", 
		"'['", "']'", "'{'", "'}'"
	};
	public static final int EOF=-1;
	public static final int T__7=7;
	public static final int T__8=8;
	public static final int T__9=9;
	public static final int T__10=10;
	public static final int T__11=11;
	public static final int T__12=12;
	public static final int P=4;
	public static final int S=5;
	public static final int WS=6;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public TransitionSystemParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public TransitionSystemParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return TransitionSystemParser.tokenNames; }
	@Override public String getGrammarFileName() { return "modelchecker/parserTS/TransitionSystem.g"; }



	// $ANTLR start "system"
	// modelchecker/parserTS/TransitionSystem.g:21:1: system returns [TransitionSystem value] : e= states EOF ;
	public final TransitionSystem system() throws RecognitionException {
		TransitionSystem value = null;


		LinkedList<State> e =null;

		try {
			// modelchecker/parserTS/TransitionSystem.g:22:3: (e= states EOF )
			// modelchecker/parserTS/TransitionSystem.g:22:5: e= states EOF
			{
			pushFollow(FOLLOW_states_in_system48);
			e=states();
			state._fsp--;

			match(input,EOF,FOLLOW_EOF_in_system50); 
			value = new TransitionSystem(e); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return value;
	}
	// $ANTLR end "system"



	// $ANTLR start "states"
	// modelchecker/parserTS/TransitionSystem.g:25:1: states returns [LinkedList<State> value] : (s= state (s= state )* |);
	public final LinkedList<State> states() throws RecognitionException {
		LinkedList<State> value = null;


		State s =null;

		try {
			// modelchecker/parserTS/TransitionSystem.g:26:3: (s= state (s= state )* |)
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==11) ) {
				alt2=1;
			}
			else if ( (LA2_0==EOF) ) {
				alt2=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// modelchecker/parserTS/TransitionSystem.g:26:5: s= state (s= state )*
					{
					pushFollow(FOLLOW_state_in_states72);
					s=state();
					state._fsp--;

					value = new LinkedList<State>(); value.add(s); 
					// modelchecker/parserTS/TransitionSystem.g:27:7: (s= state )*
					loop1:
					while (true) {
						int alt1=2;
						int LA1_0 = input.LA(1);
						if ( (LA1_0==11) ) {
							alt1=1;
						}

						switch (alt1) {
						case 1 :
							// modelchecker/parserTS/TransitionSystem.g:27:8: s= state
							{
							pushFollow(FOLLOW_state_in_states85);
							s=state();
							state._fsp--;

							value.add(s); 
							}
							break;

						default :
							break loop1;
						}
					}

					}
					break;
				case 2 :
					// modelchecker/parserTS/TransitionSystem.g:28:13: 
					{
					value = new LinkedList<State>(); 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return value;
	}
	// $ANTLR end "states"



	// $ANTLR start "state"
	// modelchecker/parserTS/TransitionSystem.g:31:1: state returns [State value] : '{' s= state_info '[' a= atom_props ']' e= edges '}' ;
	public final State state() throws RecognitionException {
		State value = null;


		StateInfo s =null;
		LinkedList<String> a =null;
		LinkedList<Integer> e =null;

		try {
			// modelchecker/parserTS/TransitionSystem.g:32:3: ( '{' s= state_info '[' a= atom_props ']' e= edges '}' )
			// modelchecker/parserTS/TransitionSystem.g:32:6: '{' s= state_info '[' a= atom_props ']' e= edges '}'
			{
			match(input,11,FOLLOW_11_in_state122); 
			pushFollow(FOLLOW_state_info_in_state126);
			s=state_info();
			state._fsp--;

			match(input,9,FOLLOW_9_in_state128); 
			pushFollow(FOLLOW_atom_props_in_state132);
			a=atom_props();
			state._fsp--;

			match(input,10,FOLLOW_10_in_state134); 
			pushFollow(FOLLOW_edges_in_state138);
			e=edges();
			state._fsp--;

			match(input,12,FOLLOW_12_in_state140); 
			value = new State(s, a, e); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return value;
	}
	// $ANTLR end "state"



	// $ANTLR start "state_info"
	// modelchecker/parserTS/TransitionSystem.g:35:1: state_info returns [StateInfo value] : ( S '*' | S );
	public final StateInfo state_info() throws RecognitionException {
		StateInfo value = null;


		Token S1=null;
		Token S2=null;

		try {
			// modelchecker/parserTS/TransitionSystem.g:36:2: ( S '*' | S )
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==S) ) {
				int LA3_1 = input.LA(2);
				if ( (LA3_1==7) ) {
					alt3=1;
				}
				else if ( (LA3_1==9) ) {
					alt3=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 3, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}

			switch (alt3) {
				case 1 :
					// modelchecker/parserTS/TransitionSystem.g:36:5: S '*'
					{
					S1=(Token)match(input,S,FOLLOW_S_in_state_info159); 
					match(input,7,FOLLOW_7_in_state_info161); 
					value = new StateInfo(Integer.parseInt(S1.getText()), true); 
					}
					break;
				case 2 :
					// modelchecker/parserTS/TransitionSystem.g:37:5: S
					{
					S2=(Token)match(input,S,FOLLOW_S_in_state_info171); 
					value = new StateInfo(Integer.parseInt(S2.getText()), false); 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return value;
	}
	// $ANTLR end "state_info"



	// $ANTLR start "atom_props"
	// modelchecker/parserTS/TransitionSystem.g:40:1: atom_props returns [LinkedList<String> value] : (a= atom ( ',' a= atom )* |);
	public final LinkedList<String> atom_props() throws RecognitionException {
		LinkedList<String> value = null;


		String a =null;

		try {
			// modelchecker/parserTS/TransitionSystem.g:41:3: (a= atom ( ',' a= atom )* |)
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==P) ) {
				alt5=1;
			}
			else if ( (LA5_0==10) ) {
				alt5=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}

			switch (alt5) {
				case 1 :
					// modelchecker/parserTS/TransitionSystem.g:41:5: a= atom ( ',' a= atom )*
					{
					pushFollow(FOLLOW_atom_in_atom_props197);
					a=atom();
					state._fsp--;

					value = new LinkedList<String>(); value.add(a); 
					// modelchecker/parserTS/TransitionSystem.g:42:5: ( ',' a= atom )*
					loop4:
					while (true) {
						int alt4=2;
						int LA4_0 = input.LA(1);
						if ( (LA4_0==8) ) {
							alt4=1;
						}

						switch (alt4) {
						case 1 :
							// modelchecker/parserTS/TransitionSystem.g:42:6: ',' a= atom
							{
							match(input,8,FOLLOW_8_in_atom_props209); 
							pushFollow(FOLLOW_atom_in_atom_props213);
							a=atom();
							state._fsp--;

							value.add(a); 
							}
							break;

						default :
							break loop4;
						}
					}

					}
					break;
				case 2 :
					// modelchecker/parserTS/TransitionSystem.g:43:8: 
					{
					value = new LinkedList<String>(); 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return value;
	}
	// $ANTLR end "atom_props"



	// $ANTLR start "atom"
	// modelchecker/parserTS/TransitionSystem.g:46:1: atom returns [String value] : P ;
	public final String atom() throws RecognitionException {
		String value = null;


		Token P3=null;

		try {
			// modelchecker/parserTS/TransitionSystem.g:47:3: ( P )
			// modelchecker/parserTS/TransitionSystem.g:47:5: P
			{
			P3=(Token)match(input,P,FOLLOW_P_in_atom244); 
			value = P3.getText(); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return value;
	}
	// $ANTLR end "atom"



	// $ANTLR start "edges"
	// modelchecker/parserTS/TransitionSystem.g:50:1: edges returns [LinkedList<Integer> value] : (e= edge (e= edge )* |);
	public final LinkedList<Integer> edges() throws RecognitionException {
		LinkedList<Integer> value = null;


		Integer e =null;

		try {
			// modelchecker/parserTS/TransitionSystem.g:51:3: (e= edge (e= edge )* |)
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==S) ) {
				alt7=1;
			}
			else if ( (LA7_0==12) ) {
				alt7=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}

			switch (alt7) {
				case 1 :
					// modelchecker/parserTS/TransitionSystem.g:51:5: e= edge (e= edge )*
					{
					pushFollow(FOLLOW_edge_in_edges266);
					e=edge();
					state._fsp--;

					value = new LinkedList<Integer>(); value.add(e); 
					// modelchecker/parserTS/TransitionSystem.g:52:5: (e= edge )*
					loop6:
					while (true) {
						int alt6=2;
						int LA6_0 = input.LA(1);
						if ( (LA6_0==S) ) {
							alt6=1;
						}

						switch (alt6) {
						case 1 :
							// modelchecker/parserTS/TransitionSystem.g:52:7: e= edge
							{
							pushFollow(FOLLOW_edge_in_edges285);
							e=edge();
							state._fsp--;

							value.add(e); 
							}
							break;

						default :
							break loop6;
						}
					}

					}
					break;
				case 2 :
					// modelchecker/parserTS/TransitionSystem.g:53:19: 
					{
					value = new LinkedList<Integer>(); 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return value;
	}
	// $ANTLR end "edges"



	// $ANTLR start "edge"
	// modelchecker/parserTS/TransitionSystem.g:56:1: edge returns [Integer value] : S ;
	public final Integer edge() throws RecognitionException {
		Integer value = null;


		Token S4=null;

		try {
			// modelchecker/parserTS/TransitionSystem.g:57:3: ( S )
			// modelchecker/parserTS/TransitionSystem.g:57:6: S
			{
			S4=(Token)match(input,S,FOLLOW_S_in_edge333); 
			value = Integer.parseInt(S4.getText()); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return value;
	}
	// $ANTLR end "edge"

	// Delegated rules



	public static final BitSet FOLLOW_states_in_system48 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_system50 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_state_in_states72 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_state_in_states85 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_11_in_state122 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_state_info_in_state126 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_state128 = new BitSet(new long[]{0x0000000000000410L});
	public static final BitSet FOLLOW_atom_props_in_state132 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_10_in_state134 = new BitSet(new long[]{0x0000000000001020L});
	public static final BitSet FOLLOW_edges_in_state138 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_12_in_state140 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_S_in_state_info159 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_7_in_state_info161 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_S_in_state_info171 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atom_in_atom_props197 = new BitSet(new long[]{0x0000000000000102L});
	public static final BitSet FOLLOW_8_in_atom_props209 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_atom_in_atom_props213 = new BitSet(new long[]{0x0000000000000102L});
	public static final BitSet FOLLOW_P_in_atom244 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_edge_in_edges266 = new BitSet(new long[]{0x0000000000000022L});
	public static final BitSet FOLLOW_edge_in_edges285 = new BitSet(new long[]{0x0000000000000022L});
	public static final BitSet FOLLOW_S_in_edge333 = new BitSet(new long[]{0x0000000000000002L});
}
