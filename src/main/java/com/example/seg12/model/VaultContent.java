package com.example.seg12.model;

import com.example.seg12.model.Vault;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class VaultContent {

    static String folder = "data";
    static String path = "data/data.txt";
    static String path2 = "data/pass.txt";
    static String content;
    static String password;

    ArrayList<Vault> vaultContent;

    public VaultContent() {
        vaultContent = new ArrayList<>();
    }

    public ArrayList<Vault> getContent() {
        return vaultContent;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String pass){
        this.password = pass;
    }

    public void setContent(ArrayList<Vault> vaultContent) {
        this.vaultContent = vaultContent;
    }

    public void save() throws IOException {
        File file = new File(path);
        FileOutputStream fos = new FileOutputStream(file);
        String data = "";
        for (int i = 0; i < vaultContent.size(); i++) {
            data += vaultContent.get(i).getContent() + "\n";
        }

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
        writer.write(data);
        writer.flush();
        fos.close();
    }
    public void savePassword() throws IOException {
        File file = new File(path2);
        FileOutputStream fos = new FileOutputStream(file);
        for (int i = 0; i < vaultContent.size(); i++) {
            password = vaultContent.get(i).getPassword();
        }
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
        writer.write(password);
        writer.flush();
        fos.close();
    }

    public void load() throws IOException {
        File file = new File(path);
        if (file.exists()) {
            FileInputStream fis = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            String content = "";
            String line = "";
            while ((line = reader.readLine()) != null) {

                //System.out.println(line);
                String arr = line;
                this.content = line;//= line.split(":");
                //System.out.println(arr);
                vaultContent.add(
                        new Vault(arr)
                );
                content += line + "\n";
            }
            //System.out.println(vaultContent.size());
        }else{
            File f = new File(folder);
            if(!f.exists()){
                f.mkdirs();
            }
            file.createNewFile();
        }
    }
    public void loadPassword() throws IOException {
        File file = new File(path2);
        if (file.exists()) {
            FileInputStream fis = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            String content = "";
            String line = "";
            while ((line = reader.readLine()) != null) {
                //System.out.println(line);
                String arr = line;
                this.password = line;//= line.split(":");
                //System.out.println(arr);
            }
            //System.out.println(vaultContent.size());
        }else{
            File f = new File(folder);
            if(!f.exists()){
                f.mkdirs();
            }
            file.createNewFile();
        }
    }

    public void show() {
        for (Vault s : vaultContent) {
            System.out.println(s.getContent());
        }
    }
}
