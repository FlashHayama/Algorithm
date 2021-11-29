package discussion;

public class CensorShipPrinter implements ExplorerEntity {

    private String[] censorWord = {"fdp","connard","con","merde","pd","enculer"};

    private void shift(int depth) {
		int i = 0;
		while(i< depth){
			System.out.print("\t");
			i++;
		}
	}

    @Override
    public void explore(DiscussionGroup dg) {
        
    }

    @Override
    public void explore(Post p) {
        shift(p.getDepth());
		System.out.println(p.getTitle() + " (" + p.getAuthor() + ")");
		shift(p.getDepth());
		System.out.println(p.getMessage().replaceAll(String.join("|", censorWord), "***"));
    }
    
}
