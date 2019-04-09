##avro-tool for reading the avro files

Linux - `wget http://repo1.maven.org/maven2/org/apache/avro/avro-tools/1.8.2/avro-tools-1.8.2.jar`

Mac - `curl -O http://repo1.maven.org/maven2/org/apache/avro/avro-tools/1.8.2/avro-tools-1.8.2.jar`


#Schema Evolution
1. Backward Compatible 
    - Backward: a backward compatible change is when a **new** schema can be used to read an **old** data
    - We can read old data with the new schema, thanks to a **default** value. In case the field doesn't exist, Avro will use the **default**
    - We want backwards when we want to successfully perform queries (Hive-SQL for example) over old and new data using a new schema 
2. Forward Compatible 
    - Forward: a forward compatible change is when a **old** schema can be used to read **new** data.
    - We can read new data with the old schema, Avro will just **ignore** new fields. Deleting fields without defaults is not forward compatible
    - We want forward compatible when we want to make a data stream envolve without changing our downstream consumers
3. Fully Compatible
    - Full: which is both **backward** and **forward**
    - Only add fields with defaults
    - Only remove fields that have defaults
    - Most of the time we should target full compatibility

### Advice when writing an Avro schema 
1. Make your primary key required
2. Give a default values to all the fields that could be removed in the future
3. Be very careful when using **Enums** as they can't be envole over time
4. Don't rename fields. You can add aliases instead (other names)
5. When envolving a schema, ALWAYS give default values
6. When envolving a schema, NEVER delete a required field
