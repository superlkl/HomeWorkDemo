package com.example.mythirddemo.util;

import com.example.mythirddemo.MyApplication;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import static android.content.Context.MODE_PRIVATE;

public class IOUtil {
    /*
    封装储存读取用户手机号，密码和网名的方法
     */
    public static void saveUserPhone(String inputText) {
        try {
            FileOutputStream outputStream = MyApplication.getContext().openFileOutput("dataPhone", MODE_PRIVATE);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
            writer.write(inputText);
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void saveUserPassword(String inputText) {
        try {
            FileOutputStream outputStream =MyApplication.getContext().openFileOutput("dataPassword", MODE_PRIVATE);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
            writer.write(inputText);
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void saveNickName(String inputText) {
        try {
            FileOutputStream outputStream =MyApplication.getContext().openFileOutput("dataNickName", MODE_PRIVATE);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
            writer.write(inputText);
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void saveUserId(String inputText) {
        try {
            FileOutputStream outputStream =MyApplication.getContext().openFileOutput("dataUserId", MODE_PRIVATE);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
            writer.write(inputText);
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String restoreUserPhone() {
            StringBuilder content = new StringBuilder();
            try {
            FileInputStream inputStream = MyApplication.getContext().openFileInput("dataPhone");
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    public static String restoreUserPassword() {
        StringBuilder content = new StringBuilder();
        try {
            FileInputStream inputStream = MyApplication.getContext().openFileInput("dataPassword");
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }
    public static String restoreNickName() {
        StringBuilder content = new StringBuilder();
        try {
            FileInputStream inputStream = MyApplication.getContext().openFileInput("dataNickName");
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }
    public static String restoreUserId() {
        StringBuilder content = new StringBuilder();
        try {
            FileInputStream inputStream = MyApplication.getContext().openFileInput("dataUserId");
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

}
