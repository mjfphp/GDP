package com.djz.classes;

import com.coxautodev.graphql.tools.GraphQLRootResolver;

class Mutation implements GraphQLRootResolver {
    private Sections sections;
    private Params params;
    private Articles articles;

    public Mutation(Sections sections,Params params,Articles articles)
    {
        this.params=params;
        this.sections=sections;
        this.articles=articles;
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

    // Side Params :
    public Param createParam(int dm, int dh, int ao, int fg, int it, int be, int tfa){
        Param newParam=new Param(dm,dh,ao,fg,it,be,tfa);
        params.saveParam(newParam);
        return newParam;
    }
    public Param deleteParam(String id){
        Param param=params.findById(id);
        params.deleteParam(id);
        return param;
    }
    public Param updateParam(String id, int dm, int dh, int ao, int fg, int it, int be, int tfa){
        Param param=params.findById(id);
        params.updateParam(id,dm,dh,ao,fg,it,be,tfa);
        return param;
    }

    // Side Articles
    public Article createArticle(String ref, String nom, String des, Double prix, Double poids, String um){
        Article newArticle=new Article(ref,nom,des,prix,poids,um);
        articles.saveArticle(newArticle);
        return newArticle;
    }
    public Article deleteArticle(String id){
        Article article=articles.findById(id);
        articles.deleteArticle(id);
        return article;
    }
    public Article updateArticle(String id,String ref, String nom, String des, Double prix, Double poids, String um){
        Article article=articles.findById(id);
        articles.updateArticle(id,ref,nom,des,prix,poids,um);
        return article;
    }
}