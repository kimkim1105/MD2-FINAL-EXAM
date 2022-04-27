package ReadWrite;

import model.Contacts;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Struct;
import java.util.ArrayList;
import java.util.List;

public class FileCSV {
    private static final String COMMA = ",";
    private static final String NEWLINE = "\n";
    private static final String path = "D:\\java\\GIT\\MODULE 2\\FINALTEST\\src\\data\\datacontact.csv";
    private static final String HEAD = "So dien thoai,Nhom danh ba,Ho ten,Gioi tinh,Dia chi,Ngay sinh,Email";
    public static void writeToFile(ArrayList<Contacts> contactsArrayList){
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(path);
//            fileWriter.append(HEAD);
//            fileWriter.append(NEWLINE);
            for (Contacts contacts:
                 contactsArrayList) {
                fileWriter.append(contacts.getPhoneNumber());
                fileWriter.append(COMMA);
                fileWriter.append(contacts.getGroup());
                fileWriter.append(COMMA);
                fileWriter.append(contacts.getName());
                fileWriter.append(COMMA);
                fileWriter.append(contacts.getGender());
                fileWriter.append(COMMA);
                fileWriter.append(contacts.getAddress());
                fileWriter.append(COMMA);
                fileWriter.append(contacts.getDateOfBirth());
                fileWriter.append(COMMA);
                fileWriter.append(contacts.getEmail());
                fileWriter.append(NEWLINE);
            }
        }catch (Exception e){
            System.out.println("loi file");
        }finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            }catch (Exception e){
                System.out.println("loi day/dong mơ file");
            }
        }
    }
    public static ArrayList<Contacts> getList(){
        BufferedReader br = null;
        List<Contacts> contactsList = new ArrayList<Contacts>();
        try {
            String line = "";
            br = new BufferedReader(new FileReader(path));
            while((line= br.readLine())!=null){
                String[] splitData = line.split(",");
                Contacts contacts = new Contacts();
                contacts.setPhoneNumber(splitData[0]);
                contacts.setGroup(splitData[1]);
                contacts.setName(splitData[2]);
                contacts.setGender(splitData[3]);
                contacts.setAddress(splitData[4]);
                contacts.setDateOfBirth(splitData[5]);
                contacts.setEmail(splitData[6]);
                contactsList.add(contacts);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return (ArrayList<Contacts>) contactsList;
    }
}
