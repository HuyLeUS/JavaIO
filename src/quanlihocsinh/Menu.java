/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlihocsinh;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Menu {
    private static final String FILE_HEADER = "Mahs,Tenhs,Diem,Diachi,Ghichu";
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    
   
    
    public static HocSinh themHS()
    {
        int maHS;
        String tenHS,diaChi,ghiChu;
        float diem;
        Image hinhAnh;
        HocSinh hocsinh=new HocSinh();
        Scanner sc=new Scanner(System.in);
        
        System.out.println("Nhập mã học sinh:");
        maHS=sc.nextInt();
        hocsinh.setMaHS(maHS);
        sc.nextLine();
        
        System.out.println("Nhập tên học sinh:");
        tenHS=sc.nextLine();
        hocsinh.setTenHS(tenHS);
       // sc.nextLine();
        
        System.out.println("Nhap diem:");
        diem=sc.nextFloat();
        hocsinh.setDiem(diem);
        sc.nextLine();
        
        System.out.println("nhap dia chi:");
        diaChi=sc.nextLine();
        hocsinh.setDiaChi(diaChi);
     //   sc.nextLine();
        
        System.out.println("them ghi chu:");
        ghiChu=sc.nextLine();
        hocsinh.setGhiChu(ghiChu);
        
        return hocsinh;
        
    }
    
    
    public static void Show(ArrayList<HocSinh> hocSinh)
    {
        int index=0;
        
        for(HocSinh hs:hocSinh)
        {
            System.out.println("Mã học sinh:"+hs.getMaHS());
            System.out.println("Ten Hoc Sinh:"+hs.getTenHS().toString());
            System.out.println("Điểm:"+hs.getDiem());
            System.out.println("Địa chỉ:"+hs.getDiaChi().toString());
            System.out.println("Ghi chú:"+hs.getGhiChu().toString());
        }
    }
   
    public static void xoaHs(ArrayList<HocSinh> hocsinh, int maHS)
    {
        int flag=0;
        for(HocSinh hs:hocsinh)
        {
            if(hs.getMaHS()==maHS)
            {
                flag=1;
                hocsinh.remove(hs);
                break;
            }
            
        }
        if(flag==0)
        {
            System.out.println("sinh viên không có trong danh sách!!");
        }
    }
    
    public static void updateHS(ArrayList<HocSinh> hocsinh,int maHS)
    {
        
    }
    public static void exportToCSV(ArrayList<HocSinh> hocSinhs) throws IOException
    {
        
        FileWriter fW=null;
        String fileName="output.csv";
        try{
            fW=new FileWriter(fileName);
            fW.append(FILE_HEADER);
            fW.append(NEW_LINE_SEPARATOR);
            for(HocSinh hs:hocSinhs)
                {
                    fW.append(String.valueOf(hs.getMaHS()));
                    fW.append(COMMA_DELIMITER);
                    fW.append(hs.getTenHS());
                    fW.append(COMMA_DELIMITER);
                    fW.append(String.valueOf(hs.getDiem()));
                    fW.append(COMMA_DELIMITER);
                    fW.append(hs.getDiaChi());
                    fW.append(COMMA_DELIMITER);
                    fW.append(hs.getGhiChu());
                    fW.append(NEW_LINE_SEPARATOR); 
                }
            System.out.println("CSV file was created successfully !!!");
            }   
        catch(IOException ioe)
            {
                System.out.println("Error in CsvFileWriter !!!");
            }
        finally {
            try {
                fW.flush();
                fW.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
        
    }
    }
    public static void importFromCSV(ArrayList<HocSinh> hocSinhs) throws FileNotFoundException, IOException
    {
        BufferedReader bR=null;
        try{
            String line;
            bR=new BufferedReader(new FileReader("output.csv"));
            while(true)
            {
                line = bR.readLine();
                if(line==null)
                {
                    break;
                }   
                printHocsinh(parseCsvLine(line));
                System.out.println("Import CSV successfully !!!");
            }
        }catch(IOException ioe)
        {
                ioe.printStackTrace();
                System.out.println("could not import from CSV file!!");
        }finally{
            try{
                if(bR!=null)
                {
                    bR.close();
                }
            }catch(IOException ioe)
            {
                ioe.printStackTrace();
            }
        }
       
                
    }
    
    private static void printHocsinh(ArrayList<String> hocSinhs) {
        System.out.println(
                "Students [maHS= "
                + hocSinhs.get(0) 
                + ", TenHS= " + hocSinhs.get(1) 
                + " , Diem=" + hocSinhs.get(2) 
                + ",Dia chi="+hocSinhs.get(3)
                +",Ghi chu="+hocSinhs.get(4)+"]");
    }
    private static ArrayList<String> parseCsvLine(String line) {
      ArrayList<String> res=new ArrayList<String>();
      if (line != null) {
            String[] splitData = line.split(COMMA_DELIMITER);
            for (int i = 0; i < splitData.length; i++) {
                res.add(splitData[i]);
            }
        }
        return res;
    }

    
}
