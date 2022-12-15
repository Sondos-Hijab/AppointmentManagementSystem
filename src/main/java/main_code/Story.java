package main_code;

public class Story {
	private String storyId;
	private String myStory;

	public Story() {
	}
	public Story(String storyId,String myStory) {
		this.storyId =  storyId;
		this.myStory =  myStory;
	}
	public void setStoryId(String storyId) {
		this.storyId =  storyId;
	}
	public String getStoryId() {
		return storyId;
	}
	public void setStory(String myStory) {
		this.myStory =  myStory;
	}
	public String getStory() {
		return myStory;
	}

}