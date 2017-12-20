package com.djz.classes;

import com.mongodb.client.MongoCollection;

import java.util.ArrayList;

import com.mongodb.client.model.Filters;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import java.util.List;
import org.bson.Document;
import org.jetbrains.annotations.NotNull;

import static com.mongodb.client.model.Filters.eq;


public class Sections {
    private final MongoCollection<Document> sections;

    public Sections(MongoCollection<Document> sections) {
          this.sections=sections;
    }

    public Section findById(String id) {
        Document doc = sections.find(eq("_id", new ObjectId(id))).first();
        return Section(doc);
    }

    private Section Section(Document doc) {
        return new Section(
                doc.get("_id").toString(),
                doc.getString("intitule"),
                doc.getInteger("taux"));
    }

    public List<Section> getAllSections(){
        List<Section> allSections=new ArrayList<>();
        for (Document doc :sections.find()){
            allSections.add(Section(doc));
        }
        return allSections;
    }

    public void saveSection(Section section){
        Document doc=new Document();
        doc.append("intitule",section.getIntitule());
        doc.append("taux",section.getTaux());
        sections.insertOne(doc);
    }
   public void deleteSection(String id){
        sections.deleteOne(Filters.eq("_id", new ObjectId(id)));
   }
}
