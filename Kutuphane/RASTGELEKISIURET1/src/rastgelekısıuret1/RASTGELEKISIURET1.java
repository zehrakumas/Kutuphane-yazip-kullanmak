
/**
*
* @author Zehra Kumaş zehra.kumas@ogr.sakarya.edu.tr
* @since 25.03.2020
* <p>
* B161210084 1A grubu
* </p>
*/
package rastgelekısıuret1;
import java.io.*;//dosya okuma işlemi için gerekli kütüphane
import java.util.ArrayList;
import java.util.Scanner;

//rastgele kişiyi oluşturan sınıf
public class RASTGELEKISIURET1 {
    public void Kisi(){
    KimlikNo a=new KimlikNo();
    a.kimlik();
    RastgeleKisi b=new RastgeleKisi();
    b.dosyaislemi();
    Yas c=new Yas();
    c.yas();
    Telefon d=new Telefon();
    d.telefon();
    IMEINo e=new IMEINo();
    e.imei();
    
    }

}
    

//rastgeleliği sağlayan sınıf
class Rastgele{
    private long seed; //başlangıç durumu
    private final long mask = 0xffffffffffffL; //gelen sayılardan negatif olanları almamak için tanımlandı.
    
    public Rastgele() {
	this(System.nanoTime()); //başlangıç durumunu sistemin nano saniyesine bağımlı olarak değişken olması sağlanıyor.
    }

    private Rastgele(long seed) {
        this.seed = seed; //constructor çalıştıktan sonra buraya gelerek sistemin nano saniyesini başlangıç sayısına eşitliyor.
    }
     
    public int nextInt(int n) { //parametre olarak verilen aralık kadar sayı üretimi gerçekleştiriliyor.
	long x = (seed = seed * 0x5deece66dL + 11L) & mask; //mantığına göre sayı üretip mask ile negatif sayıları saf dışı bırakıyor.
        int random = (int)(n * (x * 3.552713678800500929355621337890625e-15)); //random sayı  
	return random;
        //System.out.println("random: "+random);
        
    }
  
}
//rasgele kişi ismi çekilen sınıf
class RastgeleKisi{
    public void dosyaislemi(){
        Rastgele a=new Rastgele();
          //dosya okuma işlemi ile verilen txt dosyasını okuyoruz ve random bir isim buluyoruz.
    String text = "";
    int lineNumber;
    try {
      FileReader readfile = new FileReader("random_isimler.txt");
      BufferedReader readbuffer = new BufferedReader(readfile);
      //
      
      
      for (lineNumber = 0; lineNumber < 3000; lineNumber++) {
         
           if (lineNumber == (a.nextInt(2999)+1))
           {
               text = readbuffer.readLine();
           }
           else if(lineNumber == (a.nextInt(1000)+1))
           {
               text = readbuffer.readLine();
           }
           else if(lineNumber == (a.nextInt(500)+1))
           {
               text = readbuffer.readLine();
           }
           else{
               readbuffer.readLine();
           }
          
      }
    }
     catch (IOException e) {
      e.printStackTrace();
    }
    System.out.print(text);
    System.out.print(" ");
   

     }
}

//kisinin yası rastgele atanıyor
class Yas{
    //kişinin random 0-100 arasında yaşı atanıyor.
     public void yas(){
         Rastgele b=new Rastgele();
         System.out.print(b.nextInt(99)+1);
         System.out.print(" ");
      //  return(b.nextInt(99)+1);
     }
}
//rastgele oluşturulan tckimlik sınıfı
class KimlikNo{
    //rastgele tckimlik numarası üretiliyor.
    public void kimlik()
    {
        Rastgele a=new Rastgele();
        ArrayList<Integer>liste=new ArrayList<>();
        liste.add(a.nextInt(9)+1);
            for (int i=0;i<8;i++)
        {
           // System.out.print(a.nextInt(10));
            liste.add(a.nextInt(10));
            
        }
        //üretilen tckimlik numarasının çift haneleri kopyalanıyor
        int t1=0;
        Object[] liste2 = liste.toArray();//dizi kopyası al
	       for(int d =0;d<9;d+=2){
	    	 //  System.out.println(liste2[d]);
                   t1=t1+((int)liste2[d]);
               }
        //üretilen tckimlik numarasının tek haneleri kopyalanıyor.
        int t2=0;
        Object[] liste3 = liste.toArray();//dizi kopyası al
	       for(int d =1;d<8;d+=2){
	    	 //  System.out.println(liste3[d]);
                   t2=t2+((int)liste3[d]);
	       }
               
        //burada tckimlik numarasaının 10 ve 11. haneleri önceki hanelere göre hesaplanıyor.
        int f;
        int y;
        f=((t1*7)-t2)%10;
        y=(f+t1+t2)%10;
        
         liste.add(9,f);
         liste.add(10,y);
        
     
        //ekrana yazdırıyoruz.
         for (int kimlik : liste) {
            System.out.print(kimlik);                
        }
         System.out.print(" ");
       
       
    }
}
//
//random telefon numarası oluşturuluyor
     class Telefon{
         //telefon numarası oluşturuyoruz.
     public void telefon()
     {
       Rastgele a=new Rastgele();
         //türkiyede bunlardan herhangi biriyle başlıyor numaralar
         String [] telefonNo={"0501", "0505", "0506", "0507", "0551", "0552", "0553", "0554", "0555", "0559",
                           "0530", "0531", "0532", "0533", "0534", "0535", "0536", "0537", "0538", "0539", 
                           "0561", "0540", "0541", "0542", "0543", "0544", "0545", "0546", "0547", "0548", "0549"};
         int kacinciEleman = a.nextInt(telefonNo.length);
        
         
        // Üretilen sayıyı dizinin indis değerine verip yazdırıyoruz.
        System.out.print(telefonNo[kacinciEleman]);
        for(int i=0;i<7;i++)
         {
             System.out.print(a.nextInt(9));
         }
        System.out.print(" ");
     }
     }

//IMEI oluşturuluyor
    class IMEINo
    {
        //İMEİ numarası hesaplanıyor.
      ///////////
     public void imei(){
        ArrayList<Integer>liste4=new ArrayList<>();      
            Rastgele r=new Rastgele();
        
            for(int i=0;i<14;i++){
               liste4.add( r.nextInt(9));
            }
           
            int t1=0;
            int t3=0;
            int deger=0;
        Object[] liste2 = liste4.toArray();//dizi kopyası al
	       for(int d =1;d<14;d+=2){
	    	 //  System.out.println(liste2[d]);
                   
                   if((int)liste2[d]*2>9)
                   {
                        for(int i=1;i<=1;i++){
                            deger=((((int)liste2[d])*2)%10)+1;
                            t3=t3+deger;
                           // liste2[d]=liste2[d]/10;
                           
                            }
                   }
                   else{
                       t1=t1+((int)liste2[d]);
                   }
               }
                
               int t2=0;
               Object[] liste3 = liste4.toArray();//dizi kopyası al
	       for(int d =0;d<14;d+=2){
	    	 //  System.out.println(liste2[d]);
                   t2=t2+((int)liste3[d]);
               }
               
               int f=((t1*2)+t2+t3)%10;//imei numarasının son hanesi önceki hanelere göre hesaplandı.
       
               System.out.print("(");
                        for (int imei : liste4) {
                                    System.out.print(imei);                
                                }
                        System.out.print(10-f);
                        System.out.print(")");
                        System.out.println();                    
                        
    }
    } 



    


