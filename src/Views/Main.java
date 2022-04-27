package Views;

import ReadWrite.FileCSV;
import model.Contacts;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  View contact = new View();
    Scanner scanner = new Scanner(System.in);
    public Main(){
        System.out.println("-----CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ-----");
        System.out.println("Chọn chức năng theo số (để tiếp tục):");
        System.out.println("1. Xem danh sách"+
                "\n2. Thêm mới"+
                "\n3. Cập nhật"+
                "\n4. Xóa"+
                "\n5. Tìm kiếm"+
                "\n6. Đọc từ File"+
                "\n7. Ghi vào File"+
                "\n8. Thoát"+
                "\nChọn chức năng");
        String choose = scanner.nextLine();
        switch (choose){
            case "1":
                contact.showContactList();
                break;
            case "2":
                contact.addContact();
                break;
            case "3":
                contact.editContactByphoneNumber();
                break;
            case "4":
                contact.delete();
                break;
            case "5":
                contact.search();
                break;
            case "6":
                System.out.println("Xac nhan doc du lieu tu file (Y/N)");
                String makeChoose = scanner.nextLine();
                switch (makeChoose){
                    case "Y":
                        FileCSV.getList();
                        break;
                    case "N":
                        new Main();
                        break;
                }
                new Main();
                break;
            case "7":
                System.out.println("Xac nhan ghi du lieu vao file (Y/N)");
                String choose2 = scanner.nextLine();
                switch (choose2){
                    case "Y":
                        FileCSV.writeToFile((ArrayList<Contacts>) contact.contactsList);
                        break;
                    case "N":
                        new Main();
                        break;
                }
                new Main();
                break;
            case "8":
                System.exit(0);
                break;
            default:
                new Main();
                break;
        }
    }
    public static void main(String[] args) {
        new Main();
    }
}
