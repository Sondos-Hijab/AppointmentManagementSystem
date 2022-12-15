package main_code;

public class Story {
	private String StoryId;
	private String myStory;

	public Story() {
	}
	public Story(String StoryId,String myStory) {
		this.StoryId =  StoryId;
		this.myStory =  myStory;
	}
	public void setStoryId(String StoryId) {
		this.StoryId =  StoryId;
	}
	public String getStoryId() {
		return StoryId;
	}
	public void setStory(String myStory) {
		this.myStory =  myStory;
	}
	public String getStory() {
		return myStory;
	}

}