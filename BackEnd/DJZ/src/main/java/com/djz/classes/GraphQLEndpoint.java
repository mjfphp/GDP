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
        static {

            MongoDatabase mongo = new MongoClient().getDatabase("gdp");
            sections = new Sections(mongo.getCollection("sections"));
            params = new Params(mongo.getCollection("params"));
        }
        public GraphQLEndpoint() {
            super(buildSchema());
        }
        private static GraphQLSchema buildSchema() {
            return (SchemaParser.newParser()
                    .file("schema.graphqls") //parse the schema file created earlier
                    .resolvers(
                            new Query(sections,params),
                            new Mutation(sections,params)
                    )
                    .build()
                    .makeExecutableSchema());
        }
    }

