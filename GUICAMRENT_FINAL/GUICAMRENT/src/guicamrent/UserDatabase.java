package guicamrent;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * ตัวกลางอ่าน/เขียนไฟล์ Database (users.txt)
 * รูปแบบ 1 บรรทัดต่อ 1 ผู้ใช้:  username,password,phone,email
 */
public class UserDatabase {

    public static final String FILE_NAME = "data/user.csv";

    private UserDatabase() {
    }

    /** true ถ้ามี username นี้อยู่ใน Database แล้ว */
    public static boolean userExists(String username) {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return false;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] d = line.split(",", -1);
                if (d.length >= 2 && d[0].trim().equals(username)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /** true ถ้า username + password ตรงกับที่เคยสมัครไว้ */
    public static boolean checkLogin(String username, String password) {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return false;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] d = line.split(",", -1);
                if (d.length >= 2
                        && d[0].trim().equals(username)
                        && d[1].trim().equals(password)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /** เพิ่มผู้ใช้ใหม่ต่อท้ายไฟล์ คืน true ถ้าเขียนสำเร็จ */
    public static boolean saveUser(String username, String password, String phone, String email) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(username + "," + password + "," + phone + "," + email);
            writer.newLine();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
