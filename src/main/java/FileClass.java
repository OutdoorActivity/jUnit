import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FileClass {

    public static void main(String[] args) throws IOException {
        FileClass fileClass = new FileClass();
        Stream<String> stringStream = fileClass.readFileStream(args[0]);
        List<String> stringList = fileClass.readFile(stringStream);

        fileClass.parseFile(stringList).forEach(System.out::println);
    }

    public Stream<String> readFileStream(String filename) throws IOException {
        return Files.lines(Path.of(filename));
    }

    public String parseValue(Integer a) {
        if (a % 3 == 0 && a % 5 == 0) {
            return "FizzBuzz";
        }
        if (a % 3 == 0) {
            return "Fizz";
        } else if (a % 5 == 0) {
            return "Buzz";
        }
        return a.toString();
    }

    public List<String> parseFile(List<String> stringStream) {
        List<String> list = new ArrayList<>();
        stringStream.forEach(s -> list.add(parseValue(Integer.parseInt(s))));
        return list;
    }

    public List<String> readFile(Stream<String> stringStream) {
        List<String> list = new ArrayList<>();
        stringStream.forEach(s -> {
            try {
                Integer.parseInt(s);
                list.add(s);
            } catch (NumberFormatException e) {
                System.out.println(s + " not a number");
            }

        });
        return list;
    }
}

