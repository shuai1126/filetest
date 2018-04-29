package filetest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;


public class filetest {

    private List<String> list = new ArrayList<String>();
    private String temp;

    public static void main(String[] args) {
        filetest fileTest = new filetest();
        fileTest.readFile("E:/work/a.txt");
        fileTest.printFile("E:/work/b.txt");
        System.out.println(fileTest.list);
    }

    public void readFile(String fileName) {
        try {
            FileReader fileReader = new FileReader(new File(fileName));
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((temp = bufferedReader.readLine()) != null) {
                list.add(temp);
            }
            bufferedReader.close();
            fileReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printFile(String fileName) {

        try {
            FileWriter fileWriter = new FileWriter(new File(fileName));
            BufferedWriter bufWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < list.size(); i++) {
                bufWriter.write(list.get(i), 0, 5);//读取前5个字符
                bufWriter.newLine();
            }
            bufWriter.close();
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}