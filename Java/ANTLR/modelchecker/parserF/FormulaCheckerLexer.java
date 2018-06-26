// $ANTLR 3.5.2 modelchecker/parserF/FormulaChecker.g 2017-04-26 11:13:08

package modelchecker.parserF; 

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class FormulaCheckerLexer extends Lexer {
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
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public FormulaCheckerLexer() {} 
	public FormulaCheckerLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public FormulaCheckerLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "modelchecker/parserF/FormulaChecker.g"; }

	// $ANTLR start "T__6"
	public final void mT__6() throws RecognitionException {
		try {
			int _type = T__6;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// modelchecker/parserF/FormulaChecker.g:10:6: ( 'AG[' )
			// modelchecker/parserF/FormulaChecker.g:10:8: 'AG['
			{
			match("AG["); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__6"

	// $ANTLR start "T__7"
	public final void mT__7() throws RecognitionException {
		try {
			int _type = T__7;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// modelchecker/parserF/FormulaChecker.g:11:6: ( 'AND[' )
			// modelchecker/parserF/FormulaChecker.g:11:8: 'AND['
			{
			match("AND["); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__7"

	// $ANTLR start "T__8"
	public final void mT__8() throws RecognitionException {
		try {
			int _type = T__8;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// modelchecker/parserF/FormulaChecker.g:12:6: ( 'AX[' )
			// modelchecker/parserF/FormulaChecker.g:12:8: 'AX['
			{
			match("AX["); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__8"

	// $ANTLR start "T__9"
	public final void mT__9() throws RecognitionException {
		try {
			int _type = T__9;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// modelchecker/parserF/FormulaChecker.g:13:6: ( 'EF[' )
			// modelchecker/parserF/FormulaChecker.g:13:8: 'EF['
			{
			match("EF["); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__9"

	// $ANTLR start "T__10"
	public final void mT__10() throws RecognitionException {
		try {
			int _type = T__10;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// modelchecker/parserF/FormulaChecker.g:14:7: ( 'EX[' )
			// modelchecker/parserF/FormulaChecker.g:14:9: 'EX['
			{
			match("EX["); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__10"

	// $ANTLR start "T__11"
	public final void mT__11() throws RecognitionException {
		try {
			int _type = T__11;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// modelchecker/parserF/FormulaChecker.g:15:7: ( 'NOT[' )
			// modelchecker/parserF/FormulaChecker.g:15:9: 'NOT['
			{
			match("NOT["); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__11"

	// $ANTLR start "T__12"
	public final void mT__12() throws RecognitionException {
		try {
			int _type = T__12;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// modelchecker/parserF/FormulaChecker.g:16:7: ( 'TT' )
			// modelchecker/parserF/FormulaChecker.g:16:9: 'TT'
			{
			match("TT"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__12"

	// $ANTLR start "T__13"
	public final void mT__13() throws RecognitionException {
		try {
			int _type = T__13;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// modelchecker/parserF/FormulaChecker.g:17:7: ( ']' )
			// modelchecker/parserF/FormulaChecker.g:17:9: ']'
			{
			match(']'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__13"

	// $ANTLR start "T__14"
	public final void mT__14() throws RecognitionException {
		try {
			int _type = T__14;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// modelchecker/parserF/FormulaChecker.g:18:7: ( '][' )
			// modelchecker/parserF/FormulaChecker.g:18:9: ']['
			{
			match("]["); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__14"

	// $ANTLR start "AP"
	public final void mAP() throws RecognitionException {
		try {
			int _type = AP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// modelchecker/parserF/FormulaChecker.g:25:5: ( ( 'a' .. 'z' )+ )
			// modelchecker/parserF/FormulaChecker.g:25:7: ( 'a' .. 'z' )+
			{
			// modelchecker/parserF/FormulaChecker.g:25:7: ( 'a' .. 'z' )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// modelchecker/parserF/FormulaChecker.g:
					{
					if ( (input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt1 >= 1 ) break loop1;
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "AP"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// modelchecker/parserF/FormulaChecker.g:26:5: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
			// modelchecker/parserF/FormulaChecker.g:26:9: ( ' ' | '\\t' | '\\r' | '\\n' )+
			{
			// modelchecker/parserF/FormulaChecker.g:26:9: ( ' ' | '\\t' | '\\r' | '\\n' )+
			int cnt2=0;
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( ((LA2_0 >= '\t' && LA2_0 <= '\n')||LA2_0=='\r'||LA2_0==' ') ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// modelchecker/parserF/FormulaChecker.g:
					{
					if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt2 >= 1 ) break loop2;
					EarlyExitException eee = new EarlyExitException(2, input);
					throw eee;
				}
				cnt2++;
			}

			 _channel = HIDDEN; 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WS"

	@Override
	public void mTokens() throws RecognitionException {
		// modelchecker/parserF/FormulaChecker.g:1:8: ( T__6 | T__7 | T__8 | T__9 | T__10 | T__11 | T__12 | T__13 | T__14 | AP | WS )
		int alt3=11;
		switch ( input.LA(1) ) {
		case 'A':
			{
			switch ( input.LA(2) ) {
			case 'G':
				{
				alt3=1;
				}
				break;
			case 'N':
				{
				alt3=2;
				}
				break;
			case 'X':
				{
				alt3=3;
				}
				break;
			default:
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
			break;
		case 'E':
			{
			int LA3_2 = input.LA(2);
			if ( (LA3_2=='F') ) {
				alt3=4;
			}
			else if ( (LA3_2=='X') ) {
				alt3=5;
			}

			else {
				int nvaeMark = input.mark();
				try {
					input.consume();
					NoViableAltException nvae =
						new NoViableAltException("", 3, 2, input);
					throw nvae;
				} finally {
					input.rewind(nvaeMark);
				}
			}

			}
			break;
		case 'N':
			{
			alt3=6;
			}
			break;
		case 'T':
			{
			alt3=7;
			}
			break;
		case ']':
			{
			int LA3_5 = input.LA(2);
			if ( (LA3_5=='[') ) {
				alt3=9;
			}

			else {
				alt3=8;
			}

			}
			break;
		case 'a':
		case 'b':
		case 'c':
		case 'd':
		case 'e':
		case 'f':
		case 'g':
		case 'h':
		case 'i':
		case 'j':
		case 'k':
		case 'l':
		case 'm':
		case 'n':
		case 'o':
		case 'p':
		case 'q':
		case 'r':
		case 's':
		case 't':
		case 'u':
		case 'v':
		case 'w':
		case 'x':
		case 'y':
		case 'z':
			{
			alt3=10;
			}
			break;
		case '\t':
		case '\n':
		case '\r':
		case ' ':
			{
			alt3=11;
			}
			break;
		default:
			NoViableAltException nvae =
				new NoViableAltException("", 3, 0, input);
			throw nvae;
		}
		switch (alt3) {
			case 1 :
				// modelchecker/parserF/FormulaChecker.g:1:10: T__6
				{
				mT__6(); 

				}
				break;
			case 2 :
				// modelchecker/parserF/FormulaChecker.g:1:15: T__7
				{
				mT__7(); 

				}
				break;
			case 3 :
				// modelchecker/parserF/FormulaChecker.g:1:20: T__8
				{
				mT__8(); 

				}
				break;
			case 4 :
				// modelchecker/parserF/FormulaChecker.g:1:25: T__9
				{
				mT__9(); 

				}
				break;
			case 5 :
				// modelchecker/parserF/FormulaChecker.g:1:30: T__10
				{
				mT__10(); 

				}
				break;
			case 6 :
				// modelchecker/parserF/FormulaChecker.g:1:36: T__11
				{
				mT__11(); 

				}
				break;
			case 7 :
				// modelchecker/parserF/FormulaChecker.g:1:42: T__12
				{
				mT__12(); 

				}
				break;
			case 8 :
				// modelchecker/parserF/FormulaChecker.g:1:48: T__13
				{
				mT__13(); 

				}
				break;
			case 9 :
				// modelchecker/parserF/FormulaChecker.g:1:54: T__14
				{
				mT__14(); 

				}
				break;
			case 10 :
				// modelchecker/parserF/FormulaChecker.g:1:60: AP
				{
				mAP(); 

				}
				break;
			case 11 :
				// modelchecker/parserF/FormulaChecker.g:1:63: WS
				{
				mWS(); 

				}
				break;

		}
	}



}
