/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlihocsinh;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Main {

    /**
     * @param args the command line arguments
     */
 
    
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here

        
        System.out.println("\t\t\tMENU\n");
        System.out.println("\t1.Thêm học sinh");
        System.out.println("\t2.Cập nhật thông tin học sinh");
        System.out.println("\t3.Xóa học sinh");
        System.out.println("\t4.Xem danh sách học sinh:");
            System.out.println("\t\t4.1.Mã học sinh tăng dần");
            System.out.println("\t\t4.2.Điểm tăng dần");
        
                
            
            HocSinh hocsinh=new HocSinh();
            hocsinh=Menu.themHS();
            
        ArrayList<HocSinh> listHocSinh=new ArrayList<>();
        listHocSinh.add(hocsinh);
       // Menu.exportToCSV(listHocSinh);
        Menu.importFromCSV(listHocSinh);
        
        
              //  Menu.xoaHs(listHocSinh, 1);
              //  Menu.Show(listHocSinh);
        DataOutputStream dos=new DataOutputStream(new FileOutputStream(new File ("abbb.txt")));
        for(HocSinh hs:listHocSinh)
        {
            dos.writeInt(hs.getMaHS());
            dos.writeUTF(hs.getTenHS());
            dos.writeFloat(hs.getDiem());
            dos.writeUTF(hs.getDiaChi());
            dos.writeUTF(hs.getGhiChu());
            dos.writeUTF("\n");
        }
        
        //dos.writeUTF("10");
       // dos.writeInt(199);
        
    }
    
}
