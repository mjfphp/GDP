package com.djz.classes;

import java.util.ArrayList;
import java.util.List;

public class Sections {
    private List<Section> sections;

    public Sections() {
       sections=new ArrayList<Section>();
       sections.add(new Section("Sedour",15));
       sections.add(new Section("moulage",15));
    }

    public List<Section> getAllSections(){
        return sections;
    }
    public void saveSection(Section section){
        sections.add(section);
    }
}
