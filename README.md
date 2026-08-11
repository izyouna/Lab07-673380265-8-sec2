# Lab 07 - Software Design (Section 2)

## 📄 รายงานประจำปฏิบัติการ (Lab Report)
- **ลิงก์รายงาน:** [Google Drive Report](https://drive.google.com/file/d/1IWO71H91Ga5iYMnbPzS7uTIXdIojTdjV/view?usp=sharing)

---

## 📌 ภาพรวมโครงการ (Project Overview)
โปรเจกต์นี้เป็นงานปฏิบัติการ **Lab 07** สำหรับวิชา Software Design (Section 2) พัฒนาด้วย **Java (Spring Boot 4)** โดยมีการประยุกต์ใช้ **Strategy Design Pattern** ในการคำนวณส่วนลดสินค้า (Discount Strategies):
- `NoDiscountStrategy`
- `SeasonalSaleStrategy`
- `StudentDiscountStrategy`

---

## 📁โครงสร้างโปรเจกต์ (Project Structure)
```
Lab07-673380265-8-sec2/
├── demo/
│   ├── src/
│   │   └── main/java/com/example/demo/
│   │       ├── controller/
│   │       ├── model/
│   │       ├── repository/
│   │       ├── service/
│   │       └── strategy/
│   ├── pom.xml
│   └── mvnw
└── README.md
```

---

## 🚀 วิธีการรันโปรเจกต์ (How to Run)
1. เข้าไปที่ไดเรกทอรี `demo`:
   ```bash
   cd demo
   ```
2. รันแอปพลิเคชันผ่าน Maven Wrapper:
   ```bash
   ./mvnw spring-boot:run
   ```
