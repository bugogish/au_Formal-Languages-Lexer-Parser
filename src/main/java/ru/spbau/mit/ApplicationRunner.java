package ru.spbau.mit;

import java.util.ArrayList;
import java.util.List;

public class ApplicationRunner {
    private static boolean filter;
    public static void main(String[] args) {
        List<String> inputFiles = new ArrayList<>();
        try {
            if (args.length > 0 ) {
                for (String arg : args) {
                    if (arg.equals("-filter")) {
                        filter = true;
                    }
                    if (arg.charAt(0) != '-') {
                        inputFiles.add(arg);
                    }
                }
                LexerRunner runner = new LexerRunner(filter);
                for (String f : inputFiles) {
                    runner.parseFile(f);
                }
            }
            else {
                System.err.println("Usage : ./run.sh <file> [-filter]");
            }
        }
        catch(Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
