package discussion;

public class PrettyPrinter implements ExplorerEntity{
	public PrettyPrinter(){}
	
	private void shift(int depth) {
		int i = 0;
		while(i< depth){
			System.out.print("\t");
			i++;
		}
	}
	
	public void explore(DiscussionGroup dg){	
	}
	
	public void explore(Post p){
		shift(p.getDepth());
		System.out.println(p.getTitle() + " (" + p.getAuthor() + ")");
		shift(p.getDepth());
		System.out.println(p.getMessage());
	}
}