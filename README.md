# Download

Agar bisa menggunakan library ini tambahankan baris kode di bawah pada build.gradle di dalam folder root project
```gradle
allprojects {
 repositories {
  maven { url 'https://jitpack.io' }
 }
}
```
Kemudian tambahkan dependencis 
```gradle
dependencies {
  compile 'com.github.JonesRandom:SimpleColorPicker:1.0.0'
}
```

# Penggunaan

untuk menggunakan cukup Inisialisasi ColorPicker & Untuk Memanggil bisa Menggunakan Button

```MainActivity.java
/// Inisialisasi DialogPicker
DialogPicker picker = new DialogPicker(this, new DialogPicker.OnColorSelectedListener() {
 @Override
  public void onColor(int ColorInt, String ColorString) {
   // DO Something Stuff With Color
  }
});


/// Memanggil Dialog
Button showDialog = (Button) findViewById(R.id.showDialog);
 showDialog.setOnClickListener(new View.OnClickListener() {
  @Override
   public void onClick(View view) {
    picker.show();
 }
});
```

# Changelog

versi 1.0.0
 - Rilis Pertama
 
# Screenshoot

![SS](https://raw.githubusercontent.com/JonesRandom/SimpleColorPicker/master/Screenshoot/1_re.png)</br>
![SS](https://raw.githubusercontent.com/JonesRandom/SimpleColorPicker/master/Screenshoot/2_re.png)</br>
![SS](https://raw.githubusercontent.com/JonesRandom/SimpleColorPicker/master/Screenshoot/3_re.png)

# LISENSI

SimpleColorPicker by [JonesRandom](https://github.com/JonesRandom) Dengan Lisensi [Apache License 2.0](http://www.apache.org/licenses/LICENSE-2.0).
