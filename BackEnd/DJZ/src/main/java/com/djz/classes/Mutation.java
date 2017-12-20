package com.djz.classes;

import com.coxautodev.graphql.tools.GraphQLRootResolver;

class Mutation implements GraphQLRootResolver {
    private Sections sections;
    public Mutation(Sections sections){
        this.sections=sections;
    }
    public Section createSection(String intitule,int taux){
        Section newSection=new Section(intitule,taux);
        sections.saveSection(newSection);
        return newSection;
    }
}