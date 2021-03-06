package it.polimi.middleware.kafka_pipeline;

import it.polimi.middleware.kafka_pipeline.common.Config;
import it.polimi.middleware.kafka_pipeline.parser.Parser;
import it.polimi.middleware.kafka_pipeline.threads.JobManager;
import it.polimi.middleware.kafka_pipeline.topics.TopicsManager;

import java.util.*;

public class MainJobManager {

    public static void main(String[] args) {

        if (args.length != 2) {
            System.out.println("Usage: java -jar <path_to_jar> <config_file_path> <pipeline_file_path>");
            System.exit(-1);
        }

        String config_path = args[0];
        String pipeline_path = args[1];

        Config.CONFIG_FILE = config_path;
        Config.PIPELINE_FILE = pipeline_path;

        // Parse global configurations
        new Parser();
        Parser.parseConfig();
        Config.printConfiguration();

        new JobManager().start();
    }
}
