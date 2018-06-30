package Zoo;

import java.io.*;
import java.util.ArrayList;

public class Visitor extends Person{

    public static ArrayList<Visitor> visitors = new ArrayList<Visitor>();


    private String Name;
    private String LastName;
    private String Username;
    private String Password;
    private String ID;
    private long phoneNumber;
    private int Reputation;
    private String eMail;

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

    public String getPassword() {
        return Password;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public int getReputation() {
        return Reputation;
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

    public void setPassword(String password) {
        this.Password = password;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setReputation(int reputation) {
        this.Reputation = reputation;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public Visitor(String Name, String LastName, String Username, String Password, String ID, long phoneNumber, int Reputation, String eMail){

        this.Name = Name;
        this.LastName = LastName;
        this.Username = Username;
        this.Password = Password;
        this.ID = ID;
        this.phoneNumber = phoneNumber;
        this.Reputation = Reputation;
        this.eMail = eMail;
    }

    public static void AddVisitor(Visitor visi){
        visitors.add(visi);
    }


    public static void addVisitor(){

        Visitor visitor = new Visitor("Sara", "ghanbari", "sara20", "9618", "01", 12154241,
                0, "S.ghanbari@gmail.com");

        visitors.add(visitor);

        visitor = new Visitor("Melody", "hardi", "meli41", "5252", "02", 121515432,
                15, "M.hardi@gmail.com");

        visitors.add(visitor);

        visitor = new Visitor("Ariana", "pala", "omEkolsoom", "ma9866", "03", 54654635,
                20, "A.pala@gmail.com");

        visitors.add(visitor);
    }


    public static void writeVisitor(){


        try{

            File visitor = new File("visitors.txt");

            if (visitor.exists()){
                System.out.println("visitor: " + visitor.exists());
                visitor.delete();
                try {
                    visitor.createNewFile();
                } catch (IOException e1){
                    e1.printStackTrace();
                }

            }

            OutputStream os = new FileOutputStream(visitor);

            DataOutputStream dos = new DataOutputStream(os);

            dos.flush();
            os.flush();

            System.out.println("***\n save file: ");

            dos.writeInt(visitors.size());

            for (int i = 0; i < visitors.size(); i++){

                dos.writeUTF(visitors.get(i).getName());

                dos.writeUTF(visitors.get(i).getLastName());

                dos.writeUTF(visitors.get(i).getUsername());

                dos.writeUTF(visitors.get(i).getPassword());

                dos.writeUTF(visitors.get(i).getID());

                dos.writeLong(visitors.get(i).getPhoneNumber());

                dos.writeInt(visitors.get(i).getReputation());

                dos.writeUTF(visitors.get(i).geteMail());

            }
        } catch (Exception e){

            System.out.println(e.getMessage());
        }
    }


    public static void readVisitor(){

        try {

            InputStream is = new FileInputStream("visitors.txt");

            DataInputStream dis = new DataInputStream(is);

            int visitorSize = dis.readInt();

            Visitor[] visitors1 = new Visitor[visitorSize];

            System.out.println("***\nload file: ");

            for (int i = 0; i < visitorSize; i++){

                visitors1[i] = new Visitor(dis.readUTF(), dis.readUTF(), dis.readUTF(), dis.readUTF(),
                        dis.readUTF(), dis.readLong(), dis.readInt(), dis.readUTF());

                visitors.add(visitors1[i]);

            }

        } catch (Exception e){

            System.out.println(e.getMessage());
        }

    }

    public String toString(){

        return "[" + this.getName() + ", " + this.getLastName() + ": "
                + this.getUsername() + ", " + this.getPassword() + ", " + this.getID()  + ", " + this.getPhoneNumber()
                + ", " + this.getReputation()  + ", " + this.geteMail() + "]";

    }

}
