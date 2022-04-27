package Views;

import ReadWrite.FileCSV;
import model.Contacts;
import model.Validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View {
    Scanner scanner = new Scanner(System.in);
    List<Contacts> contactsList = FileCSV.getList();
    public void addContact() {
        String phoneNumber;
        while (true) {
            System.out.println("Nhap so dien thoai");
            phoneNumber = scanner.nextLine();
            if (Validation.isvalid(phoneNumber, Validation.phoneNumber)) {
                break;
            } else {
                System.err.println("sai dinh dang");
                addContact();
            }
        }
        System.out.println("Nhap nhom danh ba");
        String group = scanner.nextLine();
        System.out.println("Nhap ho ten");
        String name = scanner.nextLine();
        System.out.println("Nhap gioi tinh");
        String gender = scanner.nextLine();
        System.out.println("Nhap dia chi");
        String address = scanner.nextLine();
        System.out.println("Nhap ngay sinh");
        String dateOfBirth = scanner.nextLine();
//        System.out.println("Nhap email");
//        String email = scanner.nextLine();
        String email;
        while (true) {
            System.out.println("Nhap email");
            email = scanner.nextLine();
            if (Validation.isvalid(email,Validation.email)){
                break;
            }else {
                System.err.println("sai dinh dang");
            }
        }
        Contacts newcontacts = new Contacts(phoneNumber, group, name, gender, address, dateOfBirth, email);
        contactsList.add(newcontacts);
        FileCSV.writeToFile((ArrayList<Contacts>) contactsList);
        System.out.println(contactsList);
        new Main();
    }
    public void showContactList(){
        List<Contacts> contactsList = FileCSV.getList();
//        System.out.println(contactsList);
        for (Contacts contacts:
             contactsList) {
            System.out.println(contacts.getPhoneNumber()+"\t"+
                    contacts.getGroup()+"\t"+
                    contacts.getName()+"\t"+
                    contacts.getGender()+"\t"+
                    contacts.getAddress()+"\t"+
                    contacts.getDateOfBirth()+"\t"+
                    contacts.getEmail());
        }
        new Main();
    }
    public void editContactByphoneNumber() {
        String phoneNumber;
        while (true) {
            System.out.println("Nhap so dien thoai");
            phoneNumber = scanner.nextLine();
            if (Validation.isvalid(phoneNumber, Validation.phoneNumber)) {
                break;
            } else {
                System.out.println("Nhap lai hoac thoat");
                new Main();
            }
        }
        if (!checkPhone(phoneNumber)){
            new Main();
        }
        System.out.println("Nhap nhom danh ba");
        String group = scanner.nextLine();
        System.out.println("Nhap ho ten");
        String name = scanner.nextLine();
        System.out.println("Nhap gioi tinh");
        String gender = scanner.nextLine();
        System.out.println("Nhap dia chi");
        String address = scanner.nextLine();
        System.out.println("Nhap ngay sinh");
        String dateOfBirth = scanner.nextLine();
//        System.out.println("Nhap email");
//        String email = scanner.nextLine();
        String email;
        while (true) {
            System.out.println("Nhap email");
            email = scanner.nextLine();
            if (Validation.isvalid(email,Validation.email)){
                break;
            }
        }
        editContact(phoneNumber,group,name,gender,address,dateOfBirth,email);
        FileCSV.writeToFile((ArrayList<Contacts>) contactsList);
        new Main();
    }
    public boolean checkPhone(String phoneNumber){
        for (int i = 0; i < contactsList.size(); i++) {
            if (contactsList.get(i).getPhoneNumber().equals(phoneNumber)){
                return true;
            }
        }
        return false;
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
    }
    public void deleteByPhoneNumber(String phoneNumber, ArrayList<Contacts> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPhoneNumber().equals(phoneNumber)){
                System.out.println("Ban vua xoa "+list.get(i));
                list.remove(list.get(i));
            }
        }
    }
    public void delete() {
        String phoneNumber;
        while (true) {
            System.out.println("Nhap so dien thoai");
            phoneNumber = scanner.nextLine();
            if (Validation.isvalid(phoneNumber, Validation.phoneNumber)) {
                break;
            }
        }
        if (!checkPhone(phoneNumber)) {
            System.out.println("So dien thoai khong chinh xac");
            new Main();
        }
        deleteByPhoneNumber(phoneNumber, (ArrayList<Contacts>) contactsList);
        FileCSV.writeToFile((ArrayList<Contacts>) contactsList);
        new Main();
    }
    public Contacts searchByphoneNumber(String phoneNumber) {
        for (int i = 0; i < FileCSV.getList().size(); i++) {
            if (FileCSV.getList().get(i).getPhoneNumber().equals(phoneNumber)){
                System.out.println(FileCSV.getList().get(i).toString());
            }
        }
        return null;
    }
    public Contacts searchByName(String name) {
        for (int i = 0; i < FileCSV.getList().size(); i++) {
            if (FileCSV.getList().get(i).getName().contains(name)){
                System.out.println(FileCSV.getList().get(i).toString());
            }
        }
        return null;
    }
    public void search() {
        System.out.println("1.Timn kiem theo so dien thoai" +
                "\n2. Tim kiem theo ten");
        System.out.println("Nhap lua chon");
        String choose = scanner.nextLine();
        switch (choose) {
            case "1":
                String phoneNumber;
                while (true) {
                    System.out.println("Nhap so dien thoai");
                    phoneNumber = scanner.nextLine();
                    if (Validation.isvalid(phoneNumber, Validation.phoneNumber)) {
                        break;
                    }
                }
                if (!checkPhone(phoneNumber)) {
                    System.out.println("So dien thoai khong chinh xac");
                    new Main();
                }
                searchByphoneNumber(phoneNumber);
                new Main();
                break;
            case "2":
                String name;
                while (true) {
                    System.out.println("Nhap ten");
                    name = scanner.nextLine();
                    searchByName(name);
                    new Main();
                    break;
                }
        }
    }
}
