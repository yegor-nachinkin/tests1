import java.util.stream.*;
import java.nio.file.Files;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashSet;
import java.io.File;

public class MFiles{
  public static void main(String[] args){
    if(args.length != 1){
      System.out.println("Need file name as argument! Bye-by!");
      System.exit(0);
    }
    // split large file
    try(BufferedReader br = new BufferedReader(new FileReader(args[0]));
        BufferedWriter bw0 = new BufferedWriter(new FileWriter(new File("0.txt")));
        BufferedWriter bw1 = new BufferedWriter(new FileWriter(new File("1.txt")));
	BufferedWriter bw2 = new BufferedWriter(new FileWriter(new File("2.txt")));
	BufferedWriter bw3 = new BufferedWriter(new FileWriter(new File("3.txt")));
	BufferedWriter bw4 = new BufferedWriter(new FileWriter(new File("4.txt")));
	BufferedWriter bw5 = new BufferedWriter(new FileWriter(new File("5.txt")));
	BufferedWriter bw6 = new BufferedWriter(new FileWriter(new File("6.txt")));
	BufferedWriter bw7 = new BufferedWriter(new FileWriter(new File("7.txt")));
	BufferedWriter bw8 = new BufferedWriter(new FileWriter(new File("8.txt")));
	BufferedWriter bw9 = new BufferedWriter(new FileWriter(new File("9.txt")))){
	    String line;
	    while((line = br.readLine()) != null){
	      if(line.startsWith("0")){bw0.write(line); bw0.newLine();}else
              if(line.startsWith("1")){bw1.write(line); bw1.newLine();}else
	      if(line.startsWith("2")){bw2.write(line); bw2.newLine();}else
	      if(line.startsWith("3")){bw3.write(line); bw3.newLine();}else
	      if(line.startsWith("4")){bw4.write(line); bw4.newLine();}else
	      if(line.startsWith("5")){bw5.write(line); bw5.newLine();}else
	      if(line.startsWith("6")){bw6.write(line); bw6.newLine();}else
	      if(line.startsWith("7")){bw7.write(line); bw7.newLine();}else
	      if(line.startsWith("8")){bw8.write(line); bw8.newLine();}else
	      if(line.startsWith("9")){bw9.write(line); bw9.newLine();}
	    }	    
    }catch(IOException e){
       e.printStackTrace();
    }
    // --- split large file
    // count unique IP's in smaller files
    int u = 0;
    for(int i = 0; i < 10; i ++){
    try(Stream<String> stream = Files.lines(Paths.get(String.valueOf(i) + ".txt"))){
            // stream.distinct().collect(Collectors.toList()).forEach(x -> {System.out.println(x);});
	    List<String> l = stream.distinct().collect(Collectors.toList());
	    System.out.println("Unique lines in " + String.valueOf(i) + ".txt : " + String.valueOf(l.size()));
	    u = u + l.size();
    }catch(IOException e){
       e.printStackTrace();
    }  
    }
    // --- count unique IP's in smaller files
    // delete smaller files
    for(int i = 0; i < 10; i ++){
    try{
      new File(String.valueOf(i) + ".txt").delete();
    }catch(SecurityException se){
       se.printStackTrace();
    }   
    }    
    // --- delete smaller files
    System.out.println("Unique lines total: " + String.valueOf(u));    
  }
}
