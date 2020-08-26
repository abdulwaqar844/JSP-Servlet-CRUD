package dao;
import java.sql.*;
import entity.login;
import java.sql.ResultSet;
import util.DBConnectionUtil;


public class LoginDAOimp implements LoginDAO{

    @Override
    public String loginvalid(login lg) {
        String status =null;
    try{
        String sql= "SELECT * FROM `logininfo` WHERE email=? AND password=?";
        Connection connection = DBConnectionUtil.openConnection();
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setString(1, lg.getEmail());
        prepareStatement.setString(2, lg.getPassword());
        ResultSet resultset = prepareStatement.executeQuery();
        
        if(resultset.next()){
        return "true";
        }else
        {
         return "fasle";
        }
    }catch(Exception e){
}
    
    return "error";
    }

}