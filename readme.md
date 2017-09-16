This is an example project that demonstrates the different capabilities in the SDL OData framework.

## Starting the Service
There are several ways to start the OData Service, in this demo we have made this even easier by adding a demo class.

### From Maven
It is quite easy to run the example service from the command line, the example utilises Spring-Boot which allows
running the service using a single packed jar.

In order to run the example, in the cloned git repository execute the following commands:
```bash
git clone repo
cd odata-example
mvn clean install
mvn -f example-service/pom.xml spring-boot:run
```

### From Your favorite IDE
In order to execute the Example service in your IDE, please execute the following the Java Main method in class:
```java
com.sdl.odata.example.service.ServiceContainer
```

## Creating Example Content
The example service by default has Time Series data points, in order to add more example content
in the service the following steps can be used. This also demonstrates how the OData service allows data creation.

In order to create some content the below sample content can be used to post data to the OData Service.
Example command to create Mickey as a Person in the service, using a sample json file:

```bash
curl -i -X POST -d @src/samples/ts01.json http://localhost:8080/ts.svc/Datapoints --header "Content-Type:application/json"
```

The content structure that is posted looks as follows:  
```json
{ "@odata.context" : "http://localhost:8080/example.svc/$metadata#/Datapoints/$entity",
  "@odata.id" : "/Datapoints('5')",
  "id" : "11",
  "tagName" : "TestPost",
  "attribute" : "AttrPost",
  "timeStamp" : 1488490548525,
  "datapoint" : 10,
  "quality"   : 3  
}
```
OData published Time Series service 
http://localhost:8080/ts.svc

```
<service xmlns="http://www.w3.org/2007/app" xmlns:atom="http://www.w3.org/2005/Atom" xmlns:metadata="http://docs.oasis-open.org/odata/ns/metadata" xmlns:base="http://localhost:8080/ts.svc" xmlns:context="http://localhost:8080/ts.svc/$metadata">
<workspace>
<atom:title>SDLExample</atom:title>
<collection href="Datapoints">
<atom:title>Datapoints</atom:title>
</collection>
</workspace>
```
Service Metadata

http://localhost:8080/ts.svc/$metadata
```
<edmx:Edmx xmlns:edmx="http://docs.oasis-open.org/odata/ns/edmx" Version="4.0">
<edmx:DataServices>
<Schema xmlns="http://docs.oasis-open.org/odata/ns/edm" Namespace="SDL.OData.TS">
<EntityType Name="Datapoint">
<Key>
<PropertyRef Name="id"/>
</Key>
<Property Name="id" Type="Edm.String" Nullable="false"/>
<Property Name="tagName" Type="Edm.String" Nullable="false"/>
<Property Name="attribute" Type="Edm.String" Nullable="false"/>
<Property Name="timeStamp" Type="Edm.Int64" Nullable="false"/>
<Property Name="datapoint" Type="Edm.Int32" Nullable="false"/>
<Property Name="quality" Type="Edm.Int32" Nullable="true"/>
</EntityType>
<EntityContainer Name="SDLExample">
<EntitySet Name="Datapoints" EntityType="SDL.OData.TS.Datapoint"/>
</EntityContainer>
</Schema>
</edmx:DataServices>
</edmx:Edmx>
</service>
```
Time Series Data Points

http://localhost:8080/ts.svc/Datapoints

Returns all commited datapoints to the published service
