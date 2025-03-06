package textFileAnalyzer;

import java.io.*;

public class FileAnalyzer {

    String filePath;

    public FileAnalyzer(String filePath) {
        this.filePath = filePath;
    }

    public void readFile() {
        isFileExist();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error while reading the file: " + e.getMessage());
        }
    }

    public void isFileExist() {
        File file = new File(filePath);
        if (file.exists()) {
            System.out.println("File is exist.");
        } else {
            try {
                if (file.createNewFile()) {
                    System.out.println("File is created successfully!");
                } else {
                    System.out.println("File couldn't created");
                }
            } catch (IOException e) {
                System.out.println("Error creating the file: " + e.getMessage());
            }
        }
    }

    public void analyzeTextFile() {
        isFileExist();
        int countWords = 0;
        int countLines = 0;
        int countCharacter = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                countWords += words.length;
                countLines++;
                countCharacter += line.length();
            }
        } catch (IOException e) {
            System.out.println("Error while reading the file: " + e.getMessage());
        }

        System.out.println("Words count: " + countWords);
        System.out.println("Lines count: " + countLines);
        System.out.println("Character count: " + countCharacter);
    }

    public void searchWord(String specificWord) {
        isFileExist();
        int lineNum = 0;
        boolean flag = false;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                lineNum++;
                if (line.contains(specificWord)) {
                    System.out.println("Word(" + specificWord + ") found at line " + lineNum);
                    flag = true;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (!flag) {
            System.out.println("Word(" + specificWord + ") not found in the file");
        }
    }

}
