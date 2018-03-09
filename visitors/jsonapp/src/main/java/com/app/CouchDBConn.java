package com.app;

import com.couchbase.client.java.*;
import com.couchbase.client.java.document.*;
import com.couchbase.client.java.document.json.*;
import com.couchbase.client.java.query.*;
import com.couchbase.client.java.env.*;
import com.couchbase.client.core.env.*;
//import com.couchbase.client.*;
//import com.couchbase.client.core.utils.*;
import com.couchbase.client.java.ConnectionString;

public class CouchDBConn{

    public static void main(String [] args) {
      try
      {
        System.out.println("Step 1");
        // Initialize the Connection
        Cluster cluster = com.couchbase.client.java.CouchbaseCluster.create("172.17.0.3");
//        CouchbaseEnvironment env = DefaultCouchbaseEnvironment.builder()
//                 .connectTimeout(10000)
//                 .build();
        System.out.println("Step 2");
        cluster.authenticate("cbuser", "saiganCB99");
//        Cluster cluster = CouchbaseCluster.create(env, "localhost:8091");
        System.out.println("Step 3");
        Bucket bucket = cluster.openBucket("visitors");
        System.out.println("Step 4");

        // Create a JSON Document
        JsonObject visitor = JsonObject.create()
            .put("email", "Sri_vidhu@hotmail.com")
            .put("fname", "Sri")
            .put("lname", "Subramanian")
            .put("interests", JsonArray.from("Watching Movie", "Listen to Music"));

        // Store the Document
        bucket.upsert(JsonDocument.create("Sri_vidhu@hotmail.com", visitor));

        // Load the Document and print it
        // Prints Content and Metadata of the stored Document
        System.out.println(bucket.get("Sri_vidhu@hotmail.com").content());

        // Create a N1QL Primary Index (but ignore if it exists)
        System.out.println("BucketManager : " + bucket.bucketManager());
        //bucket.bucketManager.createN1qlPrimaryIndex(true, false);

        // Perform a N1QL Query
        N1qlQueryResult result = bucket.query(
            N1qlQuery.parameterized("SELECT name FROM visitors WHERE $1 IN interests",
            JsonArray.from("Volunteer"))
        );

        // Print each found Row
        for (N1qlQueryRow row : result) {
            // Prints {"name":"Visitor"}
            System.out.println(row);
        }
      }
      catch (Exception ex)
      {
         ex.printStackTrace();
      }
    }
}
