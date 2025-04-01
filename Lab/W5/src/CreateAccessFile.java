

import com.healthmarketscience.jackcess.*;

import java.io.File;
import java.io.IOException;

public class CreateAccessFile {
    public static void main(String[] args) {
        try {
            // 1. Tạo file .accdb mới
            File dbFile = new File("E:/students.accdb");
            Database db = DatabaseBuilder.create(Database.FileFormat.V2010, dbFile);

            // 2. Tạo bảng Students
            Table students = new TableBuilder("Students")
                    .addColumn(new ColumnBuilder("MSSV").setType(DataType.TEXT).setLength(20))
                    .addColumn(new ColumnBuilder("HoTen").setType(DataType.TEXT).setLength(100))
                    .addColumn(new ColumnBuilder("NgaySinh").setType(DataType.TEXT).setLength(20))
                    .addColumn(new ColumnBuilder("Lop").setType(DataType.TEXT).setLength(20))
                    .toTable(db);

            // 3. (Tuỳ chọn) Thêm dữ liệu mẫu
            students.addRow("52200033", "Lê Công Tuấn", "2004-03-01", "22050201");
            students.addRow("52200034", "Đoàn Cẩm Thúy", "2004-21-09", "22050201");

            db.close();

            System.out.println("✅ Đã tạo file students.accdb thành công!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}