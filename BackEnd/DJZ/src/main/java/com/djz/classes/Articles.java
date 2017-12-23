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

public class Articles {
    private final MongoCollection<Document> articles;

    public Articles(MongoCollection<Document> articles) {
        this.articles = articles;
    }
    public Article findById(String id) {
        Document doc = articles.find(eq("_id", new ObjectId(id))).first();
        return Article(doc);
    }
    private Article Article(Document doc) {
        return new Article(
                doc.get("_id").toString(),
                doc.getString("ref"),
                doc.getString("nom"),
                doc.getString("des"),
                doc.getDouble("prix"),
                doc.getDouble("poids"),
                doc.getString("um")
        );
    }
    public List<Article> getAllArticles(){
        List<Article> allArticles=new ArrayList<>();
        for (Document doc :articles.find()){
            allArticles.add(Article(doc));
        }
        return allArticles;
    }
    public void saveArticle(Article article){
        Document doc=new Document();
        doc.append("ref",article.getRef());
        doc.append("nom",article.getNom());
        doc.append("des",article.getDes());
        doc.append("prix",article.getPrix());
        doc.append("poids",article.getPoids());
        doc.append("um",article.getUm());

        articles.insertOne(doc);
    }
    public void deleteArticle(String id){
        articles.deleteOne(Filters.eq("_id", new ObjectId(id)));
    }
    public void updateArticle(String id, String ref, String nom, String des, Double prix, Double poids, String um){
        articles.updateOne(eq("_id",new ObjectId(id)),
                combine(
                        set("ref",ref),
                        set("nom",nom),
                        set("des",des),
                        set("prix",prix),
                        set("poids",poids),
                        set("um",um)
                )
        );
    }
}
