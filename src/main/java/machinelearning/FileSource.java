package machinelearning;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileSource implements Source {
  private String filePathWithName;

  public FileSource(String filePathWithName) {
    this.filePathWithName = filePathWithName;
  }

  public String getFilePathWithName() {
    return filePathWithName;
  }

  public FileSource setFilePathWithName(String filePathWithName) {
    this.filePathWithName = filePathWithName;
    return this;
  }

  @Override
  public List<Double> read() {
    File file = new File(filePathWithName);
    BufferedReader br = null;
    try {
      br = new BufferedReader(new FileReader(file));
    } catch (FileNotFoundException e) {

    }
    List<Double> doubleList = new ArrayList<>();
    String st;
    while (true) {
      try {
        if (!((st = br.readLine()) != null)) break;
        doubleList.add(Double.parseDouble(st));
      } catch (IOException e) {

      }
    }
    return doubleList;
  }

  @Override
  public int write(Double accuracy) {
    return 0;
  }
}

