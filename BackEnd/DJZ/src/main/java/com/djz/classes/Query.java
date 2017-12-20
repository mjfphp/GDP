package com.djz.classes;

import com.coxautodev.graphql.tools.GraphQLRootResolver;

import java.util.List;

public class Query implements GraphQLRootResolver {
    private final Sections sections;

    public Query(Sections sections) {
        this.sections = sections;
    }
    public List<Section> allSections(){
        return sections.getAllSections();
    }
}
