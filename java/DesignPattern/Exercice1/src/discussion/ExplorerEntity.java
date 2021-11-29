package discussion;

//L'interface pourrait s'appelé VisitorEntity
public interface ExplorerEntity{
	//On pourrait appeler les methode visit
	public void explore(DiscussionGroup dg);
	public void explore(Post p);
}