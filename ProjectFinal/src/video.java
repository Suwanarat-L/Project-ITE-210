public class video {
    String title;
    String channel;
    String day;

    public video(String title, String channel, String day){
        this.title = title;
        this.channel = channel;
        this.day = day;
    }

    public String getTitle(){
        return this.title;
    }

    public String getChannel(){
        return this.channel;
    }

    public String getDay(){
        return this.day;
    }

    @Override
    public String toString() {
        return "[" + day + "]" + " Title: " + title + " | Channel: " + channel;
    }
}
