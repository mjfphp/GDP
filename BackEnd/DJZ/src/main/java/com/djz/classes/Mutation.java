package com.djz.classes;

import com.coxautodev.graphql.tools.GraphQLRootResolver;

class Mutation implements GraphQLRootResolver {
    private Sections sections;
    public Mutation(Sections sections){
        this.sections=sections;
    }


    // Side Sections :
    public Section createSection(String intitule,int taux){
        Section newSection=new Section(intitule,taux);
        sections.saveSection(newSection);
        return newSection;
    }
    public Section deleteSection(String id){
        Section section=sections.findById(id);
        sections.deleteSection(id);
        return section;
    }
    public Section updateSection(String id,String intitule,int taux){
        Section section=sections.findById(id);
        sections.updateSection(id,intitule,taux);
        return section;
    }


}