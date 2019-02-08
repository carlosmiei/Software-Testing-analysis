import java.io.IOException;
import java.io.FileNotFoundException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class ATS implements Runnable {
	private UMeR umer;
	private Client client;
	private User user;
	private Driver driver;
	private String key;
	private String cla;
	private Vehicle car;
	private Trip trip;

	public static void main(String[] args) throws InterruptedException {
		ATS ats = new ATS();
		ats.run();
	}

	public ATS() {
		umer = new UMeR();
  	}

	@Override
	public void run() {
		String filename = "log2.txt";
		CharStream input;
		try {
			input = CharStreams.fromFileName(filename);
		} catch (IOException e1) {
			System.err.println("erro: log inválido");
			return;
		}

		ATSLexer lexer = new ATSLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		ATSParser parser = new ATSParser(tokens);

		// Variáveis
		parser.umer = umer;
		parser.client = client;
		parser.user = user;
		parser.driver = driver;
		parser.key = key;
		parser.cla = cla;
		parser.car = car;
		parser.trip = trip;

		// Variáveis
		ParseTree tree = parser.actions();
		//System.out.println("árvore: " + tree.toStringTree(parser));

    	try { // guardar o estado do programa
      		umer.saveUMeR("umerData-tests");
   		} catch (FileNotFoundException e) {
      		System.err.println("ERROR: could not save UMeR data (FileNotFoundException).");
    	} catch (IOException e) {
      		System.err.println("ERROR: could not save UMeR data (IOException).");
    	}
	}
}
