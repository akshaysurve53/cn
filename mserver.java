import java.io.*; 
import java.net.*; 

public class mserver implements Runnable 
 { 
   Socket c; 
   mserver(Socket c) 
 { 
      this.c = c; 
   } 
public static void main(String args[]) throws Exception { 
      ServerSocket ss = new ServerSocket(6666); 
      System.out.println("Listening"); 
       
      while (true) { 
         Socket s = ss.accept(); 
         System.out.println("Connected"); 
         new Thread(new mserver(s)).start(); 
      } 
   } 
   public void run() { 
      try
    {      
      
       
      DataInputStream din=new DataInputStream(c.getInputStream());  
      DataOutputStream dout=new DataOutputStream(c.getOutputStream());  
      BufferedReader br=new BufferedReader(new InputStreamReader(System.in)); 
         
      String str="",str2="";  
      while(!str2.equals("bye"))
       {  
         System.out.print("Client : ");
         str=br.readLine();  
         dout.writeUTF(str);  
         dout.flush();  
         str2=din.readUTF();  
         System.out.println("Server : "+str2); 
       }   
      din.close();
      dout.close();  
       
    }
    catch(Exception e){
      System.out.println(e);} 
   } 

} 
