package com.javaBrains.javaBrains.service.graphl;

import com.javaBrains.javaBrains.service.graphl.DataFetcher.PeopleDataFetcher;
import com.javaBrains.javaBrains.service.graphl.DataFetcher.PersonDataFetcher;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class GraphqlService {

    private GraphQL graphQL;
    private final PeopleDataFetcher peopleDataFetcher;
    private final PersonDataFetcher personDataFetcher;

    public GraphqlService(PeopleDataFetcher peopleDataFetcher, PersonDataFetcher personDataFetcher) {
        this.peopleDataFetcher = peopleDataFetcher;
        this.personDataFetcher = personDataFetcher;
    }


    @PostConstruct
    private void init() throws IOException {
        // fetch schema file from class path
        InputStream schemaStream = Files.newInputStream(Paths.get("src/main/resources/schema.graphqls"));
        // parse scheme file
        TypeDefinitionRegistry registry = new SchemaParser().parse(schemaStream);
        // RunTime wiring
        RuntimeWiring runtimeWiring = buildRunTimeWiring();
        // Graphql schema
        GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(registry, runtimeWiring);
        graphQL = GraphQL.newGraphQL(schema).build();

    }

    private RuntimeWiring buildRunTimeWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type("Query", typeWiring ->
                        typeWiring.dataFetcher("getAllPerson", peopleDataFetcher)
                                .dataFetcher("findPerson", personDataFetcher)
                ).build();
    }

    //provide graphql service
    public GraphQL getGraphQL(){
        return graphQL;
    }


}



