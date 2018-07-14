package com.lti.sdd.service.controller;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.lti.sdd.service.controller.vo.DataFlow;

import scala.Tuple2;

@RestController
public class JsonController {
	 @PostMapping("/updateJson")
		public String postCustomer(@RequestBody String json) {
		 Gson gson = new Gson(); 
		 DataFlow dataFlow = gson.fromJson(json, DataFlow.class);
		 System.out.println(json);
		 System.out.println(dataFlow);
		 //runSparkWordCount_Test();
		 readDB();
			return "ok";
		}
		// @PostMapping("/runSparkDemo")
		 public String runSparkWordCount_Test() {
			 String inputFile = "/Users/298930/Documents/apache-cassandra-3.10/NOTICE.txt";
				//To set HADOOP_HOME.
				//System.setProperty("hadoop.home.dir", "c://hadoop//");
				//Initialize Spark Context
				JavaSparkContext sc = new JavaSparkContext(new SparkConf().setAppName("wordCount").setMaster("local[4]"));
				// Load data from Input File.
				JavaRDD<String> input = sc.textFile(inputFile);
				// Split up into words.
				JavaPairRDD<String, Integer> counts = input.flatMap(line -> Arrays.asList(line.split(" ")).iterator())
						.mapToPair(word -> new Tuple2<>(word, 1)).reduceByKey((a, b) -> a + b);
				System.out.println(counts.collect());
				sc.stop();
				sc.close();
			 return "OK";
		 }
		 
		 public void readDB() {
			    Map<String, String> options = new HashMap<String, String>();
			    
			    options.put("url","jdbc:mysql://localhost:3306/testdatabase?user=root&password=root");
			    options.put("dbtable", "user");
			    JavaSparkContext sc = new JavaSparkContext(new SparkConf().setAppName("DBConnection").setMaster("local[*]"));
			    SQLContext sqlContext = new org.apache.spark.sql.SQLContext(sc);
			    // DataFrame jdbcDF = sqlContext.load("jdbc", options).cache();
			    Dataset<Row> jdbcDF = sqlContext.jdbc(options.get("url"),options.get("dbtable"));
			    System.out.println("Data------------------->" + jdbcDF.toJSON().first());
			    Row[] rows = (Row[]) jdbcDF.collect();
			    System.out.println("Without Filter \n ------------------------------------------------- ");
			    for (Row row2 : rows) {
			        System.out.println(row2.toString());
			    }
			    System.out.println("Filter Data\n ------------------------------------------------- ");
			    //jdbcDF = jdbcDF.select("email","first_name").where(jdbcDF.col("route_id").$less$eq(3));
			    jdbcDF = jdbcDF.select("email","first_name");
			    rows = (Row[]) jdbcDF.collect();
			    for (Row row2 : rows) {
			        System.out.println(row2.toString());
			    }
			}
}
	