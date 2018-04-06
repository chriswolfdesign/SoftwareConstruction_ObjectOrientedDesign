package model;

import model.media.AbstractMedia;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class iPod implements Iterable<AbstractMedia>{

    private String name;
    private List<AbstractMedia> files;

    public iPod(String name) {
        this.name = name;
        files = new ArrayList<>();
    }

    // getters
    public String getName() { return name; }

    public void addFile(AbstractMedia file) {
        if(!files.contains(file))
            files.add(file);
    }

    @Override
    public Iterator iterator() {
        return files.iterator();
    }
}