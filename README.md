# Kafka Schema Registry
Contains basic project for Kafka Schema Registry

## Schema Changes

- When there is an enhancement to change in Data/Schema from the producer side, it affects all the consumers as they are reading to the older schema.
- Creating a new Producer and Consumer with new schema will impact the business as well.
- To overcome this problem , Confluent Kafka have introduced the concept of Avro Schema and to store that schema they have Schema Registry.
- Avro schema is nothing but a contract b/w the producer and consumer, it represents the data that you are going to serialize while producing and deserialize while consuming.
- Once the schema is defined, it can be converted to data object using Maven/Gradle or Avro Plugin and this can be added to Producer and Consumer.
- Producer will be serializing the data with Avro Serializer and Consumer will be deserializing the data with Avro Deserializer.
- When producer is sending with Avro Serializer, it validates the schema and stores in Schema Registry and then produces the message to Kafka Topic.
- When consumer is consuming with Avro Deserializer, it validated the schema from registry and process the messages to data objects.
- Schema Registry provides a way to store, retrieve and evolve the schema in a consistent way, and in future if there’s any change in the schema, it creates a new version and stores in the registry.
- Schema Registry has a capability to support the old schema and the new schema where both Producer and Consumer will not have an impact.
- Schema Registry maintains the history, if there's any field removed or updated it will not impact the producer/consumer but if a new field is added it must have the default value for compatibility.