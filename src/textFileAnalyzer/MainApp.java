package textFileAnalyzer;

public class MainApp {
    public static void main(String[] args) {
        FileAnalyzer fileAnalyzer=new FileAnalyzer("C:\\Users\\HP\\IdeaProjects\\codetasks\\DataSet\\anyData2.txt");
        System.out.println("-----------");
        fileAnalyzer.readFile();
        System.out.println("-----------");
        fileAnalyzer.analyzeTextFile();
        System.out.println("-----------");
        fileAnalyzer.searchWord("NIO");

    }
}
