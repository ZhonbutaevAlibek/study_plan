package com.test;


import java.sql.*;


public class Main {

    public static void main(String args[]){

        try{
            Connection connection = Access.connect();
            Statement st = connection.createStatement();

            // проверка select
            String getAuthors = "SELECT * FROM authors";
            ResultSet rs = st.executeQuery(getAuthors);
            while(rs.next()){
                System.out.println(rs.getString("name"));
            }

//            // проверка добавления записи
//            String addAuthor = "INSERT INTO authors(name) VALUES ('Стивен Кинг')";
//            st.executeUpdate(addAuthor);


//            // проверка на обновление
//            String updateAuthor = "UPDATE authors SET name=? WHERE id=?";
//            PreparedStatement pst = connection.prepareStatement(updateAuthor);
//            pst.setString(1, "Ремарк");
//            pst.setInt(2, 4);
//            pst.executeUpdate();
//
//            ResultSet rst = st.executeQuery(getAuthors);
//            while(rst.next()){
//                System.out.println(rst.getString("name"));
//            }

//            // preparedStatement удаление записи
//            String sql = "DELETE FROM authors WHERE name=?";
//            PreparedStatement pst = connection.prepareStatement(sql);
//            pst.setString(1, "Стивен Кинг");
//            pst.executeUpdate();


            st.close();
        }catch(Exception e){
            System.err.println(e);
        }
    }
}
