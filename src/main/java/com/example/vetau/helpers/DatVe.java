package com.example.vetau.helpers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DatVe {

    static Scanner input_Diemdi = new Scanner(System.in);
    static Scanner input_Diemden = new Scanner(System.in);
    public static void Dat_Ve() throws SQLException {
        Connection connection = Database.connectionDB();
        String query = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ResultSet resultSet1 = null;

        System.out.print("Địa điểm đi   ");
        //String Dia_diem_di = input_Diemdi.nextLine();
        String  Dia_diem_di = "Hà Nội";
        System.out.println();
        System.out.print("Đia điểm đến   ");
        //String Dia_diem_den = input_Diemden.nextLine();
        String Dia_diem_den = "Đà Nẵng";
        System.out.println();
        query = "SELECT *\n" +
                "FROM\n" +
                "(\n" +
                "SELECT \tc.ID_Chuyentau,\n" +
                "\t\tc.ID_Gadi, g1.Ten_Gatau AS TenGaDi, g1.Dia_diem as Diadiem_di ,\n" +
                "\t\tc.ID_Gaden, g2.Ten_Gatau AS TenGaDen, g2.Dia_diem as Diadiem_den,\n" +
                "        c.Ngay_di,\n" +
                "        c.Ngay_den\n" +
                "\t\t\n" +
                "FROM chuyen_tau c\n" +
                "JOIN ga_tau g1 ON c.ID_Gadi = g1.ID_Gatau\n" +
                "JOIN ga_tau g2 ON c.ID_Gaden = g2.ID_Gatau\n" +
                ") as ChitietChuyen_tau\n" +
                "WHERE Diadiem_di = ? AND " +
                " Diadiem_den = ? ";
        preparedStatement =connection.prepareStatement(query);
        preparedStatement.setString(1,Dia_diem_di);
        preparedStatement.setString(2,Dia_diem_den);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next())
        {
            System.out.println(resultSet.getString("ID_Chuyentau")+"\t"+
                    resultSet.getString("Diadiem_di")+ "\t"+
                    resultSet.getString("Diadiem_den")+ "\t" +
                    resultSet.getDate("Ngay_di"));
        }
    }

    public static void main(String[] args) throws SQLException {
        Dat_Ve();
    }




}
