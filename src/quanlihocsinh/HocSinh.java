/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlihocsinh;

import java.awt.Image;

/**
 *
 * @author User
 */
public class HocSinh {

    private int maHS;
    private String tenHS;
    private float diem;
    private Image hinhAnh;
    private String diaChi;
    private String ghiChu;
    
    
    public HocSinh() {
    }

    public HocSinh(int maHS, String tenHS, float diem, Image hinhAnh, String diaChi, String ghiChu) {
        this.maHS = maHS;
        this.tenHS = tenHS;
        this.diem = diem;
        this.hinhAnh = hinhAnh;
        this.diaChi = diaChi;
        this.ghiChu = ghiChu;
    }

    public int getMaHS() {
        return maHS;
    }

    public void setMaHS(int maHS) {
        this.maHS = maHS;
    }

    public String getTenHS() {
        return tenHS;
    }

    public void setTenHS(String tenHS) {
        this.tenHS = tenHS;
    }

    public float getDiem() {
        return diem;
    }

    public void setDiem(float diem) {
        this.diem = diem;
    }

    public Image getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(Image hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
       
    
    
    
}
