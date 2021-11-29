package discussion;

public class Printer {
	private ExplorerEntity pp;
	private DiscussionGroup dg;
	
	public Printer(DiscussionGroup g, ExplorerEntity censor) {
		pp = censor;
		dg = g;
	}

	public Printer(Post post, ExplorerEntity censor) {
		this(new DiscussionGroup(post), censor);
	}

	public void run() {
		dg.accept(pp);
	}

	public static final void main(String args[]) {
		Post post = new Post("tom", "exercice", "ceci est un exercice facile", 0);
		Printer p = new Printer(post, new CensorShipPrinter());
		post.addAnswer(new Post("Kevin", "réponce", "pd", 1));
		p.run();
		Post post2 = new Post("Kevin", "Insulte", "t'es qu'un con", 0);
		Printer p2 = new Printer(post2, new CensorShipPrinter());
		p2.run();
	}
}