package Zoo;

import java.io.*;
import java.util.ArrayList;

public class Manager extends Person{

    public static ArrayList<Manager> managers = new ArrayList<Manager>();

    private String Name;
    private String LastName;
    private String Username;
    private String Password;
    private String ID;
    private long phoneNumber;
    private String Address;
    private String eMail;
    private long Salary;

    public Manager() { }

    public Manager(String Name, String LastName, String Username, String Password, String ID, long phoneNumber, String Address, String eMail, long Salary) {

        this.Name = Name;
        this.LastName = LastName;
        this.Username =Username;
        this.Password = Password;
        this.ID = ID;
        this.phoneNumber = phoneNumber;
        this.Address = Address;
        this.eMail = eMail;
        this.Salary = Salary;
    }

    @Override
    public String getName() {

        return Name;
    }

    public String getID() {
        return ID;
    }

    public String getLastName() {
        return LastName;
    }

    public String getUsername() {
        return Username;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return Address;
    }

    public String geteMail() {
        return eMail;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setLastName(String lastName) {
        this.LastName = lastName;
    }

    public void setUsername(String username) {
        this.Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        this.Password = password;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.Address = address;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public void setSalary(long salary) {
        this.Salary = salary;
    }

    public long getSalary() {
        return Salary;
    }


    public static void AddManager() {

        Manager manager = new Manager("Elizabeth", "Cooper", "betti", "BC1234", "01", 22334455,
                "Oak st", "E.Cooper@gmail.com", 12000);

        managers.add(manager);

        manager = new Manager("Jughead", "Jones", "juggi", "JJ1234", "02", 22334466,
                "Riv st", "J.Jones@gmail.com", 15000);

        managers.add(manager);

        manager = new Manager("pully", "Cooper", "pul", "PC1234", "03", 22334466,
                "Riv st", "P.cooper@gmail.com", 10000);

        managers.add(manager);

        manager = new Manager("chyrl", "blosom", "cherry", "CB1234", "04", 223453666,
                "thorn hill", "C.blosom@gmail.com", 10000);

        managers.add(manager);
    }


    public static void AddManager(Manager man){

        managers.add(man);
    }

    public static void writeManager(){


        try{
            File simple = new File("managers.txt");

            if (simple.exists()){
                System.out.println("manager: " + simple.exists());
                simple.delete();
                try {
                    simple.createNewFile();
                } catch (IOException e1){
                    e1.printStackTrace();
                }

            }

            OutputStream os = new FileOutputStream(simple);

            DataOutputStream dos = new DataOutputStream(os);

            dos.flush();
            os.flush();

            System.out.println("***\n save file: ");

            dos.writeInt(managers.size());

            for (int i = 0; i < managers.size(); i++){

                dos.writeUTF(managers.get(i).getName());

                dos.writeUTF(managers.get(i).getLastName());

                dos.writeUTF(managers.get(i).getUsername());

                dos.writeUTF(managers.get(i).getPassword());

                dos.writeUTF(managers.get(i).getID());

                dos.writeLong(managers.get(i).getPhoneNumber());

                dos.writeUTF(managers.get(i).getAddress());

                dos.writeUTF(managers.get(i).geteMail());

                dos.writeLong(managers.get(i).getSalary());

            }
        } catch (Exception e){

            System.out.println(e.getMessage());
        }
    }

    public static void readManager(){

        try {

            InputStream is = new FileInputStream("managers.txt");
            DataInputStream dis = new DataInputStream(is);

            int managerSize = dis.readInt();

            Manager[] managers1 = new Manager[managerSize];

            System.out.println("***\nload file: ");


            for (int i = 0; i < managerSize; i++){

                managers1[i] = new Manager(dis.readUTF(), dis.readUTF(), dis.readUTF(), dis.readUTF(),
                        dis.readUTF(), dis.readLong(), dis.readUTF(), dis.readUTF(), dis.readLong());

                //managers.get i = managers1[]i

                managers.add(managers1[i]);

//                System.out.println(managers.get(i).toString());
                //correct
            }

        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }


    public String toString(){

        return "[" + this.getName() + ", " + this.getLastName() + ": "
                + this.getUsername() + ", " + this.getPassword() + ", " + this.getID()  + ", " + this.getPhoneNumber()
                + ", " + this.getAddress()  + ", " + this.geteMail()  + ", " + this.getSalary() + "]";

    }

}
