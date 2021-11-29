package discussion;

import java.util.ArrayList;
import java.util.Date;

public class Post implements Explorable{
	private String author;
	private Date submissionDate;	// The date when the post was submitted
	private String title;
	private String message;
	private ArrayList<Post> answers;	// The answers for this post
	private int depth;
	
	public Post(String author, String title, String message, int depth){
		this.author = author;
		this.title = title;
		this.message = message;
		this.depth = depth;
		this.answers = new ArrayList<Post>();
	}
	
	public String getAuthor(){
		return author;
	}
	public String getTitle(){
		return title;
	}
	public Date getDate(){
		return submissionDate;
	}
	public String getMessage(){
		return message;
	}
	public void setMessage(String msg){
		message = msg;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	
	public void setAuthor(String author){
		this.author = author;
	}
	
	public void accept(ExplorerEntity ee){
		ee.explore(this);
		for(Post p : answers)
			p.accept(ee);
	}
	
	/**
	 * Get the depth of the post. 
	 * For instance : the answer of an answer of a post which is not an answer will get 2.
	 * @ return The depth of the post.
	 */
	public int getDepth(){
		return depth;
	}
	
	public void addAnswer(Post p)
	{
		answers.add(p);
	}
}
