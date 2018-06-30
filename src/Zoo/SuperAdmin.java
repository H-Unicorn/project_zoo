package Zoo;

import java.io.*;

public class SuperAdmin {

    private String username;
    private String password;
    private String Email;

    public SuperAdmin(){

        String fileName = "admin.bin";

        try {
            FileInputStream fileIs = new FileInputStream(fileName);
            ObjectInputStream is = new ObjectInputStream(fileIs);

            this.username = is.readUTF();
            this.password = is.readUTF();
            this.Email = is.readUTF();

            is.close();

        } catch (FileNotFoundException e){
            e.printStackTrace();

        } catch (IOException e){
            e.printStackTrace();
        }

        System.out.println("Done reading Password!");

    }

    public static void writeAdmin(String us, String p, String em) {


        try {
            FileOutputStream fileOs = new FileOutputStream("admin.bin");
            ObjectOutputStream os = new ObjectOutputStream(fileOs);
            os.reset();

            os.writeUTF(us);
            os.writeUTF(p);
            os.writeUTF(em);

            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("done");


    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return Email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {

        if (email.matches("[a-zA-Z][a-zA-Z0-9]+[@][g][m][a][i][l][.][c][o][m]") ||
                email.matches("[a-zA-Z][a-zA-Z0-9]+[@][y][a][h][o][o][.][c][o][m]")){
            this.Email = email;
        }
    }

}
