/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Form;

/**
 *
 * @author phanb
 */
public class Splash {
    public static void main(String[] args) throws InterruptedException{
        SplashScreen sp = new SplashScreen();
        DangNhap dn = new DangNhap();
        for(int i =0;i<=100;i++){
            Thread.sleep(30);
            sp.setVisible(true);
            sp.lblTienDo.setText(Integer.toString(i));
            sp.prbLoad.setValue(i);
            if(i==100){
                sp.setVisible(false);
                dn.setVisible(true);
            }
        }
    }
}
