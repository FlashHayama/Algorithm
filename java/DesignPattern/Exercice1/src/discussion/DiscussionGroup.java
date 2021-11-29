package discussion;

import java.util.ArrayList;

public class DiscussionGroup implements Explorable{
	private ArrayList<Post> posts;
	
	public DiscussionGroup(){
		posts = new ArrayList<Post>();
	}
	
	public DiscussionGroup(Post p){
		this();
		addPost(p);
	}
	
	public void accept(ExplorerEntity ee){
		ee.explore(this);
		for(Post p : posts)
			p.accept(ee);
	}
	
	public void addPost(Post p)
	{
		posts.add(p);
	}
}
