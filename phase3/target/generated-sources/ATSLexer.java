// Generated from src/antlr4/ATS.g4 by ANTLR 4.7.1

    import java.awt.geom.Point2D;
    import java.time.LocalDate;
    import java.util.concurrent.ThreadLocalRandom;
    import java.util.*;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ATSLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, VEICULO=15, STRING=16, 
		DATA=17, DIGIT=18, NUM=19, DECIMAL=20, WS=21;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "VEICULO", "STRING", "DATA", 
		"DIGIT", "NUM", "DECIMAL", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'registar condutor'", "'registar cliente'", "'registar empresa'", 
		"'registar'", "'empresa'", "'login'", "'solicitar'", "'viajar'", "'recusar viagem'", 
		"'logout'", "'('", "','", "')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, "VEICULO", "STRING", "DATA", "DIGIT", "NUM", "DECIMAL", 
		"WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	    UMeR umer;
	    Client client;
	    Driver driver;
	    User user;
	    String key;
	    String cla;
	    Point2D.Double start = new Point2D.Double();
	    int contadormatriculas = 1;
	    int viagens = 0;
	    int logins = 0;
	    int condutor=0;
	    int clientes = 0;
	    int empresas=0;
	    int logout=0;
	    int recusadas = 0;

	    int veic = 0;
	    Vehicle car;
	    Trip trip;
	    ArrayList<Trip> viagensSolicitadas = new ArrayList<Trip>();
	    int contadorfinal;

	    private String unquote(String str) {
	      if (str == null) return null;
	      else {
	        return str.substring(1,str.length()-1);
	      }
	    }

	    private Trip viajar(String key) {
	        Trip remover = null;
	        int stop = 0;

	        for (Trip object: viagensSolicitadas) {
	            if ((object.getDriver().equals(key)) && stop == 0) {
	                remover = object;
	                stop = 1;
	            }
	        }

	        Boolean res = viagensSolicitadas.remove(remover);
	        return remover;
	    }

	    private Trip viajarQualquer() {
	        Trip remover = null;
	        int tam = viagensSolicitadas.size();

	        if (tam > 0){
	            remover= viagensSolicitadas.remove(tam-1);
	        }

	        return remover;
	    }


	public ATSLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ATS.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\27\u00e2\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20"+
		"\6\20\u00a9\n\20\r\20\16\20\u00aa\3\21\3\21\3\21\3\21\7\21\u00b1\n\21"+
		"\f\21\16\21\u00b4\13\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u00be"+
		"\n\22\3\22\3\22\3\22\5\22\u00c3\n\22\3\22\3\22\3\23\3\23\3\24\7\24\u00ca"+
		"\n\24\f\24\16\24\u00cd\13\24\3\25\6\25\u00d0\n\25\r\25\16\25\u00d1\3\25"+
		"\3\25\6\25\u00d6\n\25\r\25\16\25\u00d7\5\25\u00da\n\25\3\26\6\26\u00dd"+
		"\n\26\r\26\16\26\u00de\3\26\3\26\2\2\27\3\3\5\4\7\5\t\6\13\7\r\b\17\t"+
		"\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27"+
		"\3\2\6\4\2C\\c|\4\2$$^^\3\2\62;\5\2\13\f\17\17\"\"\2\u00eb\2\3\3\2\2\2"+
		"\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2"+
		"\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2"+
		"\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2"+
		"\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\3-\3\2\2\2\5/\3\2\2\2\7A\3\2\2\2"+
		"\tR\3\2\2\2\13c\3\2\2\2\rl\3\2\2\2\17t\3\2\2\2\21z\3\2\2\2\23\u0084\3"+
		"\2\2\2\25\u008b\3\2\2\2\27\u009a\3\2\2\2\31\u00a1\3\2\2\2\33\u00a3\3\2"+
		"\2\2\35\u00a5\3\2\2\2\37\u00a8\3\2\2\2!\u00ac\3\2\2\2#\u00b7\3\2\2\2%"+
		"\u00c6\3\2\2\2\'\u00cb\3\2\2\2)\u00cf\3\2\2\2+\u00dc\3\2\2\2-.\7=\2\2"+
		".\4\3\2\2\2/\60\7t\2\2\60\61\7g\2\2\61\62\7i\2\2\62\63\7k\2\2\63\64\7"+
		"u\2\2\64\65\7v\2\2\65\66\7c\2\2\66\67\7t\2\2\678\7\"\2\289\7e\2\29:\7"+
		"q\2\2:;\7p\2\2;<\7f\2\2<=\7w\2\2=>\7v\2\2>?\7q\2\2?@\7t\2\2@\6\3\2\2\2"+
		"AB\7t\2\2BC\7g\2\2CD\7i\2\2DE\7k\2\2EF\7u\2\2FG\7v\2\2GH\7c\2\2HI\7t\2"+
		"\2IJ\7\"\2\2JK\7e\2\2KL\7n\2\2LM\7k\2\2MN\7g\2\2NO\7p\2\2OP\7v\2\2PQ\7"+
		"g\2\2Q\b\3\2\2\2RS\7t\2\2ST\7g\2\2TU\7i\2\2UV\7k\2\2VW\7u\2\2WX\7v\2\2"+
		"XY\7c\2\2YZ\7t\2\2Z[\7\"\2\2[\\\7g\2\2\\]\7o\2\2]^\7r\2\2^_\7t\2\2_`\7"+
		"g\2\2`a\7u\2\2ab\7c\2\2b\n\3\2\2\2cd\7t\2\2de\7g\2\2ef\7i\2\2fg\7k\2\2"+
		"gh\7u\2\2hi\7v\2\2ij\7c\2\2jk\7t\2\2k\f\3\2\2\2lm\7g\2\2mn\7o\2\2no\7"+
		"r\2\2op\7t\2\2pq\7g\2\2qr\7u\2\2rs\7c\2\2s\16\3\2\2\2tu\7n\2\2uv\7q\2"+
		"\2vw\7i\2\2wx\7k\2\2xy\7p\2\2y\20\3\2\2\2z{\7u\2\2{|\7q\2\2|}\7n\2\2}"+
		"~\7k\2\2~\177\7e\2\2\177\u0080\7k\2\2\u0080\u0081\7v\2\2\u0081\u0082\7"+
		"c\2\2\u0082\u0083\7t\2\2\u0083\22\3\2\2\2\u0084\u0085\7x\2\2\u0085\u0086"+
		"\7k\2\2\u0086\u0087\7c\2\2\u0087\u0088\7l\2\2\u0088\u0089\7c\2\2\u0089"+
		"\u008a\7t\2\2\u008a\24\3\2\2\2\u008b\u008c\7t\2\2\u008c\u008d\7g\2\2\u008d"+
		"\u008e\7e\2\2\u008e\u008f\7w\2\2\u008f\u0090\7u\2\2\u0090\u0091\7c\2\2"+
		"\u0091\u0092\7t\2\2\u0092\u0093\7\"\2\2\u0093\u0094\7x\2\2\u0094\u0095"+
		"\7k\2\2\u0095\u0096\7c\2\2\u0096\u0097\7i\2\2\u0097\u0098\7g\2\2\u0098"+
		"\u0099\7o\2\2\u0099\26\3\2\2\2\u009a\u009b\7n\2\2\u009b\u009c\7q\2\2\u009c"+
		"\u009d\7i\2\2\u009d\u009e\7q\2\2\u009e\u009f\7w\2\2\u009f\u00a0\7v\2\2"+
		"\u00a0\30\3\2\2\2\u00a1\u00a2\7*\2\2\u00a2\32\3\2\2\2\u00a3\u00a4\7.\2"+
		"\2\u00a4\34\3\2\2\2\u00a5\u00a6\7+\2\2\u00a6\36\3\2\2\2\u00a7\u00a9\t"+
		"\2\2\2\u00a8\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00a8\3\2\2\2\u00aa"+
		"\u00ab\3\2\2\2\u00ab \3\2\2\2\u00ac\u00b2\7$\2\2\u00ad\u00b1\n\3\2\2\u00ae"+
		"\u00af\7^\2\2\u00af\u00b1\t\3\2\2\u00b0\u00ad\3\2\2\2\u00b0\u00ae\3\2"+
		"\2\2\u00b1\u00b4\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3"+
		"\u00b5\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b5\u00b6\7$\2\2\u00b6\"\3\2\2\2"+
		"\u00b7\u00b8\5%\23\2\u00b8\u00b9\5%\23\2\u00b9\u00ba\5%\23\2\u00ba\u00bb"+
		"\5%\23\2\u00bb\u00bd\7/\2\2\u00bc\u00be\5%\23\2\u00bd\u00bc\3\2\2\2\u00bd"+
		"\u00be\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c0\5%\23\2\u00c0\u00c2\7/"+
		"\2\2\u00c1\u00c3\5%\23\2\u00c2\u00c1\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3"+
		"\u00c4\3\2\2\2\u00c4\u00c5\5%\23\2\u00c5$\3\2\2\2\u00c6\u00c7\t\4\2\2"+
		"\u00c7&\3\2\2\2\u00c8\u00ca\t\4\2\2\u00c9\u00c8\3\2\2\2\u00ca\u00cd\3"+
		"\2\2\2\u00cb\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc(\3\2\2\2\u00cd\u00cb"+
		"\3\2\2\2\u00ce\u00d0\t\4\2\2\u00cf\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1"+
		"\u00cf\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d9\3\2\2\2\u00d3\u00d5\7\60"+
		"\2\2\u00d4\u00d6\t\4\2\2\u00d5\u00d4\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7"+
		"\u00d5\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00da\3\2\2\2\u00d9\u00d3\3\2"+
		"\2\2\u00d9\u00da\3\2\2\2\u00da*\3\2\2\2\u00db\u00dd\t\5\2\2\u00dc\u00db"+
		"\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00dc\3\2\2\2\u00de\u00df\3\2\2\2\u00df"+
		"\u00e0\3\2\2\2\u00e0\u00e1\b\26\2\2\u00e1,\3\2\2\2\r\2\u00aa\u00b0\u00b2"+
		"\u00bd\u00c2\u00cb\u00d1\u00d7\u00d9\u00de\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}