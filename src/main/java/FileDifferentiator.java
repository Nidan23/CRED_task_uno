import service.FileService;

import java.io.IOException;
import java.util.Scanner;

public class FileDifferentiator {

    public static void main(String[] args) throws IOException {
        FileService fileService = FileService.getInstance();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write your file path");
        String filePath = scanner.nextLine();
        System.out.println(fileService.validateFile(filePath));
    }
}
