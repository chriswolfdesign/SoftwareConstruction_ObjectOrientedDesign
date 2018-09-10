package model;

import java.util.List;
import java.util.ArrayList;

public class Topic extends Module {

    private String name;
    // private List<Lecture> lectures = new ArrayList<Lecture>();
    // private List<Topic> topics = new ArrayList<Topic>();
    // private List<Video> videos = new ArrayList<Video>();
    private List<Module> modules = new ArrayList<>();

    public Topic (String name) {
        this.name = name;
    }

    // public void addTopic(Topic t) {
    //     topics.add(t);
    // }
    //
    // public void addLecture(Lecture lecture) {
    //     lectures.add(lecture);
    // }
    //
    // public void addVideo(Video video) {
    //     videos.add(video);
    // }

    public void addModule(Module module) {
        modules.add(module);
    }

    @Override
    public void display(String indentLevel) {
        System.out.println(indentLevel + name);
        // for(Lecture lecture : lectures) {
        //     lecture.display(indentLevel + indentLevel);
        // }
        // for(Topic topic : topics) {
        //     topic.display(indentLevel + indentLevel);
        // }
        // for(Video video : videos) {
        //     video.display(indentLevel + indentLevel);
        // }
        for(Module module : modules) {
            module.display(indentLevel + indentLevel);
        }
    }


}
