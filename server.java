import java.io.*;  
import java.net.*;  
public class server {  
   public static void main(String []args){  
    try{  
        ServerSocket ss=new ServerSocket(6666);  
        Socket s=ss.accept();                            //establishes connection   
        DataInputStream din=new DataInputStream(s.getInputStream());  
        DataOutputStream dout=new DataOutputStream(s.getOutputStream());
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        
        String str="",str2="";  
        while(!str.equals("bye"))
        {  
          str=din.readUTF();  
          System.out.println("Client : "+str);
          System.out.print("Server : ");  
          str2=br.readLine();  
          dout.writeUTF(str2);  
          dout.flush();  
        }  
       din.close();
       dout.close();
       s.close();  
       ss.close();  
    }
    catch(Exception e){
        System.out.println(e);}  
   }  
}  
