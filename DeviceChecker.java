import java.io.*;
import java.util.*;
public class DeviceChecker
{
    static String phoneKey="RZ8MC047VMJ";//This should be the code of your device. Find out by running adb devices
    public static boolean isConnected()throws Exception
    { 
        Process ec=Runtime.getRuntime().exec("cmd /c adb devices  > dev.txt");
        ec.waitFor();
        FileReader file=new FileReader("dev.txt");
        BufferedReader br=new BufferedReader(file);
        String text="";
        String dev="";
        int i=0;
        while((text=br.readLine())!=null)
        {
            i++;
            dev=dev+text+"\r";
        }
        br.close();
        int devc=0;
        for (i=0;i<dev.length();i++)
        {
            try{
                String k=(dev.substring(i,i+phoneKey.length()));
                if (k.equalsIgnoreCase(phoneKey))

                {
                    return true;

                }
            } catch(Exception e)
            {}

        }

        return false;    
    }
}