
/**
*
* @author Zehra Kumaş zehra.kumas@ogr.sakarya.edu.tr
* @since 25.03.2020
* <p>
* B161210084 1A grubu
* </p>
*/
package kisiolustur;
//gerekli kütüphaneler
import java.util.*; 
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import rastgelekısıuret1.RASTGELEKISIURET1;

public class Kisiolustur {
    //değişkenler
    public static char k;
    public static int sayac=0;
    //dosyanın satır sayısı bulunuyor
    public static int satirsayisi()throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader("Kisiler.txt"));
            int lines = 0;
            while (reader.readLine() != null) lines++;
            reader.close();
            return lines;
    }
    
    public static void main(String[] args) throws IOException {
        RASTGELEKISIURET1 a =new RASTGELEKISIURET1();
        
         //sayaçlar
         int tckimliksayac=0;
         int imeisayac=0;        
         int secim;
         
          do{
             Scanner scan = new Scanner(System.in);
            //kullanıcının karşısına menü geliyor.
           System.out.println();
           System.out.println("1- Rastgele Kişi Üret");
           System.out.println("2- Üretilmiş Dosya Kontrol Et");
           System.out.println("3- Çıkış");
           secim=scan.nextInt();

           switch (secim){
            case 1://eğer kullanıcı menüde 1'i seçerse random kişi üretilir.

                 a.Kisi();
                 sayac++;
                //dosya yazdırma     
               
            
                //dosya yazdırma
                break;

            case 2:
                  //txt dosyasi kelime kelime okunuyor.
           Scanner sc2 = null;
            try {
                sc2 = new Scanner(new File("Kisiler.txt"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();  
            }
            while (sc2.hasNextLine()) {
                    Scanner s2 = new Scanner(sc2.nextLine());
                while (s2.hasNext()) {
                    String s = s2.next();
                    //tc kmilik numarasının doğruluğu kontrol ediliyor.
                 if(s.length()==11)
                 {
                     //char dizisine dönüştürülüyor
                  char [] ch=s.toCharArray();    
 
                    int t1=((Character.getNumericValue(ch[0])+Character.getNumericValue(ch[2])+Character.getNumericValue(ch[4])+Character.getNumericValue(ch[6])+Character.getNumericValue(ch[8]))*7);
                    int t2=Character.getNumericValue(ch[1])+Character.getNumericValue(ch[3])+Character.getNumericValue(ch[5])+Character.getNumericValue(ch[7]);
                    int f1=t1-t2;                    
                    int t3=Character.getNumericValue(ch[0])+Character.getNumericValue(ch[1])+Character.getNumericValue(ch[2])+Character.getNumericValue(ch[3])+Character.getNumericValue(ch[4])+Character.getNumericValue(ch[5])+Character.getNumericValue(ch[6])+Character.getNumericValue(ch[7])+Character.getNumericValue(ch[8])+Character.getNumericValue(ch[9]); 
                    int mod1=f1%10;
                    int mod2=t3%10;
                    int k1=Character.getNumericValue(ch[0]);
                    int k2=Character.getNumericValue(ch[9]);
                    int k3=Character.getNumericValue(ch[10]);
                    //ilk sayının sıfır olmaması ve son iki sayının algoritmaya uygunluğu kontrol ediliyor.
                if(k1!=0 && mod1==k2 && mod2==k3){
                    //if bloğuna girerse sayaç arttırılıyor.
                            tckimliksayac++;   
                    }
                
                    }
                 
                 //imei numaraları kontrol ediliyor.
                 if(s.length()==17)
                 {
                     int t1=0;
                     int t2=0;
                     int t3=0;
                     int deger=0;
                     char [] ch=s.toCharArray(); 
                     for(int i=1;i<16;i+=2)
                     {
                         t1=t1+Character.getNumericValue(ch[i]);
                     }
                      for(int d =2;d<15;d+=2){
                   if(Character.getNumericValue(ch[d])*2>9)
                   {
                        for(int i=1;i<=1;i++){
                            deger=((Character.getNumericValue(ch[d])*2)%10)+1;
                            t2=t2+deger;
                    
                            }
                   }
                   else{
                       t3=t3+Character.getNumericValue(ch[d]);
                   }
               }

                     int mod=t1+t2+(t3*2);
                     if(mod%10==0){
                         imeisayac++;
                     }
                 }
                   
                } 
                
            }
                //eğer dosya boşsa random üretilen kişilerin doğru olup olmadığı yazdırılıyor.
               if(satirsayisi()==0)               
                        {
                            System.out.println("T.C. Kimlik Kontrol");
                            System.out.println(sayac+"         Geçerli");
                            System.out.println("0         Geçersiz");
                            System.out.println("IMEI Kontrol");
                            System.out.println(sayac+"         Geçerli");
                            System.out.println("0         Geçersiz");
                            
                        }
               //farklı dosya içeriği denenirse kontrol ediliyor.
               else{
                       //geçerli ve geçersiz kimlik numaraları sayıları yazdırılıyor.
                System.out.println("T.C. Kimlik Kontrol");
                System.out.println(tckimliksayac+"         Geçerli");
                System.out.println((satirsayisi()-tckimliksayac)+"         Geçersiz");
                System.out.println("IMEI Kontrol");
                System.out.println(imeisayac+"         Geçerli");
                System.out.println((satirsayisi()-imeisayac)+"         Geçersiz");
               }
             
                break;
            
                //kullanıcı menüde 3 seçerse program sonlanıyor.
            case 3:
                break;
             default:
                System.out.println("Çıkış");
       break;
        }
         }while(secim!=3);

    }
    
}
