package com.predictionmarketing.convert;




import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConvertData {

public static void main(String[] args) throws Exception {
    final Path path = Paths.get("C:/Users/Chas/workspace/RecommendationEngine/RS/data/");
    final Path txt = path.resolve("./ratingz.txt");
    final Path csv = path.resolve("./ratings.csv");
    try (
            final Stream<String> lines = Files.lines(txt);
            final PrintWriter pw = new PrintWriter(Files.newBufferedWriter(csv, StandardOpenOption.CREATE_NEW))) {
        lines.map((line) -> line.split(",")).
                map((line) -> Stream.of(line).collect(Collectors.joining(","))).
                forEach(pw::println);
    	}
	}	

}
