package com.djz.classes;

import com.coxautodev.graphql.tools.GraphQLRootResolver;

import java.util.List;

public class Query implements GraphQLRootResolver {
    private final Sections sections;
    private final Params params;

    public Query(Sections sections,Params params) {
        this.params=params;
        this.sections = sections;
    }
    public List<Section> allSections(){
        return sections.getAllSections();
    }
    public List<Param> allParams(){
        return params.getAllSections();
    }
}
