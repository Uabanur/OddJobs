// $ANTLR 3.5.2 modelchecker/parserF/FormulaChecker.g 2017-04-26 11:13:08

package modelchecker.parserF;
import modelchecker.astF.*; 

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class FormulaCheckerParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "AP", "WS", "'AG['", "'AND['", 
		"'AX['", "'EF['", "'EX['", "'NOT['", "'TT'", "']'", "']['"
	};
	public static final int EOF=-1;
	public static final int T__6=6;
	public static final int T__7=7;
	public static final int T__8=8;
	public static final int T__9=9;
	public static final int T__10=10;
	public static final int T__11=11;
	public static final int T__12=12;
	public static final int T__13=13;
	public static final int T__14=14;
	public static final int AP=4;
	public static final int WS=5;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public FormulaCheckerParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public FormulaCheckerParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return FormulaCheckerParser.tokenNames; }
	@Override public String getGrammarFileName() { return "modelchecker/parserF/FormulaChecker.g"; }



	// $ANTLR start "formula"
	// modelchecker/parserF/FormulaChecker.g:12:1: formula returns [Formula value] : p= phi EOF ;
	public final Formula formula() throws RecognitionException {
		Formula value = null;


		Phi p =null;

		try {
			// modelchecker/parserF/FormulaChecker.g:13:2: (p= phi EOF )
			// modelchecker/parserF/FormulaChecker.g:13:4: p= phi EOF
			{
			pushFollow(FOLLOW_phi_in_formula44);
			p=phi();
			state._fsp--;

			match(input,EOF,FOLLOW_EOF_in_formula47); 
			value = new Formula(p); 
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
	// $ANTLR end "formula"



	// $ANTLR start "phi"
	// modelchecker/parserF/FormulaChecker.g:15:1: phi returns [Phi value] : ( 'TT' | AP | 'EX[' ex= phi ']' | 'EF[' ef= phi ']' | 'AX[' ax= phi ']' | 'AG[' ag= phi ']' | 'NOT[' not= phi ']' | 'AND[' a1= phi '][' a2= phi ']' );
	public final Phi phi() throws RecognitionException {
		Phi value = null;


		Token AP1=null;
		Phi ex =null;
		Phi ef =null;
		Phi ax =null;
		Phi ag =null;
		Phi not =null;
		Phi a1 =null;
		Phi a2 =null;

		try {
			// modelchecker/parserF/FormulaChecker.g:16:2: ( 'TT' | AP | 'EX[' ex= phi ']' | 'EF[' ef= phi ']' | 'AX[' ax= phi ']' | 'AG[' ag= phi ']' | 'NOT[' not= phi ']' | 'AND[' a1= phi '][' a2= phi ']' )
			int alt1=8;
			switch ( input.LA(1) ) {
			case 12:
				{
				alt1=1;
				}
				break;
			case AP:
				{
				alt1=2;
				}
				break;
			case 10:
				{
				alt1=3;
				}
				break;
			case 9:
				{
				alt1=4;
				}
				break;
			case 8:
				{
				alt1=5;
				}
				break;
			case 6:
				{
				alt1=6;
				}
				break;
			case 11:
				{
				alt1=7;
				}
				break;
			case 7:
				{
				alt1=8;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}
			switch (alt1) {
				case 1 :
					// modelchecker/parserF/FormulaChecker.g:16:4: 'TT'
					{
					match(input,12,FOLLOW_12_in_phi64); 
					value = new Phi("tt"); 
					}
					break;
				case 2 :
					// modelchecker/parserF/FormulaChecker.g:17:5: AP
					{
					AP1=(Token)match(input,AP,FOLLOW_AP_in_phi73); 
					value = new Phi(AP1.getText()); 
					}
					break;
				case 3 :
					// modelchecker/parserF/FormulaChecker.g:18:4: 'EX[' ex= phi ']'
					{
					match(input,10,FOLLOW_10_in_phi81); 
					pushFollow(FOLLOW_phi_in_phi84);
					ex=phi();
					state._fsp--;

					match(input,13,FOLLOW_13_in_phi85); 
					value = new EXPhi(ex); 
					}
					break;
				case 4 :
					// modelchecker/parserF/FormulaChecker.g:19:4: 'EF[' ef= phi ']'
					{
					match(input,9,FOLLOW_9_in_phi93); 
					pushFollow(FOLLOW_phi_in_phi96);
					ef=phi();
					state._fsp--;

					match(input,13,FOLLOW_13_in_phi97); 
					value = new EFPhi(ef); 
					}
					break;
				case 5 :
					// modelchecker/parserF/FormulaChecker.g:20:4: 'AX[' ax= phi ']'
					{
					match(input,8,FOLLOW_8_in_phi105); 
					pushFollow(FOLLOW_phi_in_phi108);
					ax=phi();
					state._fsp--;

					match(input,13,FOLLOW_13_in_phi109); 
					value = new AXPhi(ax); 
					}
					break;
				case 6 :
					// modelchecker/parserF/FormulaChecker.g:21:4: 'AG[' ag= phi ']'
					{
					match(input,6,FOLLOW_6_in_phi117); 
					pushFollow(FOLLOW_phi_in_phi120);
					ag=phi();
					state._fsp--;

					match(input,13,FOLLOW_13_in_phi121); 
					value = new AGPhi(ag); 
					}
					break;
				case 7 :
					// modelchecker/parserF/FormulaChecker.g:22:4: 'NOT[' not= phi ']'
					{
					match(input,11,FOLLOW_11_in_phi129); 
					pushFollow(FOLLOW_phi_in_phi132);
					not=phi();
					state._fsp--;

					match(input,13,FOLLOW_13_in_phi133); 
					value = new NOTPhi(not); 
					}
					break;
				case 8 :
					// modelchecker/parserF/FormulaChecker.g:23:4: 'AND[' a1= phi '][' a2= phi ']'
					{
					match(input,7,FOLLOW_7_in_phi141); 
					pushFollow(FOLLOW_phi_in_phi144);
					a1=phi();
					state._fsp--;

					match(input,14,FOLLOW_14_in_phi145); 
					pushFollow(FOLLOW_phi_in_phi148);
					a2=phi();
					state._fsp--;

					match(input,13,FOLLOW_13_in_phi149); 
					value = new ANDPhi(a1, a2); 
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
	// $ANTLR end "phi"

	// Delegated rules



	public static final BitSet FOLLOW_phi_in_formula44 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_formula47 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_phi64 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_AP_in_phi73 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_10_in_phi81 = new BitSet(new long[]{0x0000000000001FD0L});
	public static final BitSet FOLLOW_phi_in_phi84 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_phi85 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_9_in_phi93 = new BitSet(new long[]{0x0000000000001FD0L});
	public static final BitSet FOLLOW_phi_in_phi96 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_phi97 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_8_in_phi105 = new BitSet(new long[]{0x0000000000001FD0L});
	public static final BitSet FOLLOW_phi_in_phi108 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_phi109 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_6_in_phi117 = new BitSet(new long[]{0x0000000000001FD0L});
	public static final BitSet FOLLOW_phi_in_phi120 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_phi121 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_11_in_phi129 = new BitSet(new long[]{0x0000000000001FD0L});
	public static final BitSet FOLLOW_phi_in_phi132 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_phi133 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_7_in_phi141 = new BitSet(new long[]{0x0000000000001FD0L});
	public static final BitSet FOLLOW_phi_in_phi144 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_14_in_phi145 = new BitSet(new long[]{0x0000000000001FD0L});
	public static final BitSet FOLLOW_phi_in_phi148 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_phi149 = new BitSet(new long[]{0x0000000000000002L});
}
