package com.company.controller;

import java.io.File;
import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.dom4j.datatype.SchemaParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.model.Adress;
import com.company.model.Person;
import com.company.repository.PersonRepository;
import com.company.service.PersonService;

import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.DataFetcher;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.TypeDefinitionRegistry;

@RestController
 @RequestMapping("/api") 
public class Controller {

	@Autowired
	private PersonService service;

	@Autowired
	private PersonRepository repo;

	private GraphQL graphQL;

	@Value("classpath:Person.graphql")
	org.springframework.core.io.Resource schemaResource;

	@PostConstruct
	public void loadSchema() throws IOException {

		// get the schema
		File schema = schemaResource.getFile();
		// Parse schema
		TypeDefinitionRegistry typeDefinitionRegistry = new graphql.schema.idl.SchemaParser().parse(schema);
		RuntimeWiring runtimeWiring = buildRuntimeWiring();
		GraphQLSchema graphQLSchema = new SchemaGenerator().makeExecutableSchema(typeDefinitionRegistry, runtimeWiring);
		graphQL = GraphQL.newGraphQL(graphQLSchema).build();

	}

	private RuntimeWiring buildRuntimeWiring() {

		DataFetcher<Person> fetcher1 = data -> {
			return repo.findByName(data.getArgument("name"));
		};

		DataFetcher<Person> fetcher2 = data -> {
			return repo.findByPersonId(data.getArgument("id"));
		};
		
		DataFetcher<Person> fetcher3 = data -> {
			return repo.findAdressById(data.getArgument("id"));
		};

		return RuntimeWiring.newRuntimeWiring().type("Query", typeWriting -> typeWriting
				.dataFetcher("getByName", fetcher).dataFetcher("getPersonById", fetcher2).dataFetcher("getAddresById", fetcher3).build());

	}

	@PostMapping("/addPerson")
	public Person create(@RequestBody Person person) {
		return service.add(person);

	}

	@PostMapping("/addAdress")
	public Person create(@RequestBody Adress adress) {
		return service.addAdress(adress);

	}

	@GetMapping("/getByName")
	public Person get(@PathVariable String name) {

		return service.getInfo(name);

	}

	@PostMapping("/getPersonByEmail")
	public ResponseEntity<Object> getByName(@RequestBody String query) {
		ExecutionResult result = graphQL.execute(query);
		return new ResponseEntity<Object>(result, HttpStatus.OK);

	}

	@PostMapping("/getPersonById")
	public ResponseEntity<Object> getById(@RequestBody String query) {
		ExecutionResult result = graphQL.execute(query);
		return new ResponseEntity<Object>(result, HttpStatus.OK);

	}

	@PostMapping("/getAdressById")
	public ResponseEntity<Object> getAdressById(@RequestBody String query) {
		ExecutionResult result = graphQL.execute(query);
		return new ResponseEntity<Object>(result, HttpStatus.OK);

	}

}
