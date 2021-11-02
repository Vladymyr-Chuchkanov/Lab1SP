import java.io.*;
import java.util.*;
public class Main {
    public static void main (String args[]){
        ArrayList<ListElems> List0 = new ArrayList<ListElems>();
        HashSet<String> AllWords = new HashSet<String>();
        for (int i = 0; i < 31; i++) {
            ListElems e = new ListElems();
            e.number=i;
            e.El0= new ArrayList<>();
            List0.add(e);
        }
        

        try(FileReader reader = new FileReader("note3.txt"))
        {
            int lengthCheck=0;
            String regCheck = "A-Za-z";
            String word0="";
            int numLength =0;
            int c;
            int CheckSkip=0;
            while((c=reader.read())!=-1){
                if(CheckSkip==1){
                    if(Character.toString(c).matches("[a-zA-Z]"))
                    {
                        continue;
                    }else{
                        CheckSkip=0;
                    }
                }
                if(Character.toString(c).matches("[a-zA-Z]")&&lengthCheck<30){
                    word0+=Character.toString(c);
                    lengthCheck++;
                    if(!Character.toString(c).matches("A|E|Y|U|O|I|a|e|y|u|i|o")){
                        numLength++;
                    }
                }else{
                    if(lengthCheck>0&&!AllWords.contains(word0)){
                        AllWords.add(word0);
                        List0.get(numLength).El0.add(word0);
                    }
                    if(lengthCheck==30){
                        CheckSkip=1;
                    }
                    numLength=0;
                    lengthCheck=0;
                    word0="";
                }
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        for (int i=0;i<31;i++){
            System.out.println("Слова з "+String.valueOf(i)+" приголосними літерами:");
            ListElems temp =  List0.get(i);
            for(int y=0;y<temp.GetElList().toArray().length;y++){
               System.out.print(temp.GetElList().get(y));
               System.out.print(' ');
            }
            System.out.println();
            System.out.println();
        }
    }
}
