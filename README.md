# Employee-Be
1.Download Repository ini dengan nama Employee-Be
2.Di dalam folder Employee-Be terdapat file sql dengan nama `db_employees.sql`
3.Buat sebuah database di Postgres dengan nama `db_employees`
4.Salin isi `db_employees.sql` ke dalam Query Tools pada Postgres dan Execute
5.Ubah isi `Application.Properties` pada line 3 dan 4 sesuaikan dengan Username dan Password yang digunakan pada postgre
6.Jika sudah maka tahap selanjutnya yaitu menjalankan project `Employee-Be`
  a. Pada eclips dengan cara klik kiri pada file `EmployeeBeApplication.java` lalu pilih `Run As > Java Application`
  b. atau menggunakan perintah `mvn spring-boot:run` pada console dengan directory yang sudah disesuaikan
7.tunggu beberapa saat untuk proses compilenya
8.Kemudian buka browser dan kunjungi `http://localhost:8080/home` maka akan tampil tulisan `Welcome` 
