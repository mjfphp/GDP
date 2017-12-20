package com.djz.classes;

    import com.coxautodev.graphql.tools.SchemaParser;
import javax.servlet.annotation.WebServlet;

    import graphql.schema.GraphQLSchema;
    import graphql.servlet.SimpleGraphQLServlet;


    @WebServlet(urlPatterns = "/graphql")
    public class GraphQLEndpoint extends SimpleGraphQLServlet {
        public GraphQLEndpoint() {
            super(buildSchema());
        }
        private static GraphQLSchema buildSchema() {
            Sections sections=new Sections();

            return (SchemaParser.newParser()
                    .file("schema.graphqls") //parse the schema file created earlier
                    .resolvers(new Query(sections))
                    .build()
                    .makeExecutableSchema());
        }
    }

