package com.djz.classes;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;

public class Params {
    private final MongoCollection<Document> params;

    public Params(MongoCollection<Document> params) {
        this.params = params;
    }
    public Param findById(String id) {
        Document doc = params.find(eq("_id", new ObjectId(id))).first();
        return Param(doc);
    }
    private Param Param(Document doc) {
        return new Param(
                doc.get("_id").toString(),
                doc.getInteger("dm"),
                doc.getInteger("dh"),
                doc.getInteger("ao"),
                doc.getInteger("fg"),
                doc.getInteger("it"),
                doc.getInteger("be"),
                doc.getInteger("tfa")
        );
    }
    public List<Param> getAllSections(){
        List<Param> allParams=new ArrayList<>();
        for (Document doc :params.find()){
            allParams.add(Param(doc));
        }
        return allParams;
    }
    public void saveParam(Param param){
        Document doc=new Document();
        doc.append("dm",param.getDm());
        doc.append("dh",param.getDh());
        doc.append("ao",param.getAo());
        doc.append("fg",param.getFg());
        doc.append("it",param.getIt());
        doc.append("be",param.getBe());
        doc.append("tfa",param.getTfa());
        params.insertOne(doc);
    }
    public void deleteParam(String id){
        params.deleteOne(Filters.eq("_id", new ObjectId(id)));
    }
    public void updateParam(String id, int dm, int dh, int ao, int fg, int it, int be, int tfa){
        params.updateOne(eq("_id",new ObjectId(id)),
                combine(
                        set("dm",dm),
                        set("dh",dh),
                        set("ao",ao),
                        set("fg",fg),
                        set("it",it),
                        set("be",be),
                        set("tfa",tfa)
                )
        );
    }
}
