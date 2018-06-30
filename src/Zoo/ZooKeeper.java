package Zoo;

import java.util.ArrayList;

public class ZooKeeper extends Person{

    public static ArrayList<ZooKeeper> zooKeepers = new ArrayList<ZooKeeper>();

    String Name;
    String LastName;
    String Username;
    String Password;
    String ID;
    long phoneNumber;
    String Address;
    String eMail;
//    String Department;

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

    public String getPassword() {
        return Password;
    }

    //    public String getDepartment() {
//        return Department;
//    }

    public void setName(String name) {
        Name = name;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public void setPassword(String password) {
        Password = password;
    }

    //    public void setDepartment(String department) {
//        Department = department;
//    }


    public ZooKeeper(String Name, String LastName, String Username, String Password, String ID, long phoneNumber, String Address, String eMail){
        this.Name = Name;
        this.LastName = LastName;
        this.Username = Username;
        this.Password = Password;
        this.ID = ID;
        this.phoneNumber = phoneNumber;
        this.Address = Address;
        this.eMail = eMail;
    }

    public static void AddZooKeeper(ZooKeeper zooKee){
        zooKeepers.add(zooKee);
    }
}
