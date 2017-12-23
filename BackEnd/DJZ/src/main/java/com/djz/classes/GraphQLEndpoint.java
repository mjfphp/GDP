package com.djz.classes;

    import com.coxautodev.graphql.tools.SchemaParser;
import javax.servlet.annotation.WebServlet;

    import com.mongodb.MongoClient;
    import com.mongodb.client.MongoDatabase;
    import graphql.schema.GraphQLSchema;
    import graphql.servlet.SimpleGraphQLServlet;


    @WebServlet(urlPatterns = "/graphql")
    public class GraphQLEndpoint extends SimpleGraphQLServlet {
        private static final Sections sections;
        private static final Params params;
        private static final Articles articles;
        static {

            MongoDatabase mongo = new MongoClient().getDatabase("gdp");
            sections = new Sections(mongo.getCollection("sections"));
            params = new Params(mongo.getCollection("params"));
            articles = new Articles(mongo.getCollection("articles"));
        }
        public GraphQLEndpoint() {
            super(buildSchema());
        }
        private static GraphQLSchema buildSchema() {
            return (SchemaParser.newParser()
                    .file("schema.graphqls") //parse the schema file created earlier
                    .resolvers(
                            new Query(sections,params,articles),
                            new Mutation(sections,params,articles)
                    )
                    .build()
                    .makeExecutableSchema());
        }
    }

