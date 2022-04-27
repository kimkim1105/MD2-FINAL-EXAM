package Services;

import ReadWrite.ReadWrite;
import model.Contacts;

import java.util.List;
import java.util.Set;

public class Service {
    public static String path = "D:\\java\\GIT\\MODULE 2\\FINALTEST\\src\\data\\contacts.csv";
    public static List<Contacts> contactsList = new ReadWrite<Contacts>().readFromFile(path);
    public void save() {
        new ReadWrite<Contacts>().writeToFile(path,contactsList);
    }
    public void add(Contacts contacts) {
        contactsList.add(contacts);
        save();
    }
    public Contacts searchByphoneNumber(String phoneNumber) {
        for (int i = 0; i < contactsList.size(); i++) {
            if (contactsList.get(i).getPhoneNumber().equals(phoneNumber)){
                System.out.println(contactsList.get(i));
            }
        }
        return null;
    }
    public void editContact(String phoneNumber,String group, String name, String gender,String address, String dateOfBirth, String email){
        for (int i = 0; i < contactsList.size(); i++) {
            if (contactsList.get(i).getPhoneNumber().equals(phoneNumber)){
                contactsList.get(i).setName(name);
                contactsList.get(i).setGroup(group);
                contactsList.get(i).setGender(gender);
                contactsList.get(i).setAddress(address);
                contactsList.get(i).setDateOfBirth(dateOfBirth);
                contactsList.get(i).setEmail(email);
                System.out.println("Ban vua chinh sua "+contactsList.get(i));
            }
        }
        save();
    }
    public void deleteByPhoneNumber(String phoneNumber) {
        for (int i = 0; i < contactsList.size(); i++) {
            if (contactsList.get(i).getPhoneNumber().equals(phoneNumber)){
                System.out.println("Ban vua xoa "+contactsList.get(i));
                contactsList.remove(contactsList.get(i));
            }
        }
        save();
    }
    public List<Contacts> findAll() {
        return contactsList;
    }
    public boolean checkPhone(String phoneNumber){
        for (int i = 0; i < contactsList.size(); i++) {
            if (contactsList.get(i).getPhoneNumber().equals(phoneNumber)){
                return true;
            }
        }
        return false;
    }
}
