package mauseth.generator.util;

import mauseth.generator.util.exception.FileHandlingException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileHandling {


    // Requirement: File I/O
    public static void writeContentsToFile(String contents, String filename, boolean appendFile) throws FileHandlingException {

        try (PrintWriter dataOutput = new PrintWriter(
                new FileOutputStream(filename, appendFile)
        )) {
            dataOutput.println(contents);
        } catch (FileNotFoundException e) {
            throw new FileHandlingException("Cannot locate file: " + filename, e);
        }

    }

    public static List<String> readContentsOfFile(String filename) throws FileHandlingException {
        List<String> contentsOfFile = new ArrayList<>();

        try (Scanner inboundFile = new Scanner(new File(filename))) {
            while (inboundFile.hasNextLine()) {
                String lineOfText = inboundFile.nextLine();
                contentsOfFile.add(lineOfText);
            }
        } catch (FileNotFoundException e) {
            throw new FileHandlingException("Cannot locate file: " + filename, e);
        }


        return contentsOfFile;
    }

}
