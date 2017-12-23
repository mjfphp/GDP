package com.djz.classes;

import com.coxautodev.graphql.tools.GraphQLRootResolver;

import java.util.List;

public class Query implements GraphQLRootResolver {
    private final Sections sections;
    private final Params params;
    private final Articles articles;

    public Query(Sections sections,Params params,Articles articles) {
        this.params=params;
        this.sections = sections;
        this.articles = articles;
    }
    public List<Section> allSections(){
        return sections.getAllSections();
    }
    public List<Param> allParams(){
        return params.getAllSections();
    }
    public List<Article> allArticles(){
        return articles.getAllArticles();
    }
}
