package Views;

import java.util.Scanner;

public class Main {
    ContactView contactView = new ContactView();
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
                contactView.showAll();
                break;
            case "2":
                contactView.addContact();
                break;
            case "3":
                contactView.editContactByphoneNumber();
                break;
            case "4":
                contactView.delete();
                break;
            case "5":
                contactView.search();
                break;
            case "6":
                new Main();
                break;
            case "7":
                new Main();
                break;
            case "8":
                System.exit(0);
                break;
        }
    }
    public static void main(String[] args) {
        new Main();
    }
}
