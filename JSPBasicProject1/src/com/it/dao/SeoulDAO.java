package com.it.dao;
import java.util.*;
import java.sql.*;
public class SeoulDAO {
   // MySQL ���� ��ü
   private Connection conn;
   // MySQL�� SQL������ �ۼ��� 
   private PreparedStatement ps;
   // MySQL �ּ�  => com.mysql.cj.jdbc.Driver
   private final String URL="jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC";
   private static SeoulDAO dao;
   // 1. ����̹� ��� => MySql���� => 1���� ���� 
   public SeoulDAO()
   {
	   try
	   {
		   Class.forName("com.mysql.cj.jdbc.Driver");
	   }catch(Exception ex){}
   }
   // 2. �̱��� : �޸𸮿� �Ѱ��� ������ => ���� => static 
   public static SeoulDAO newInstance()
   {
	   if(dao==null)
		   dao=new SeoulDAO();
	   return dao;
   }
   // 3. MySQL���� 
   public void getConnection()
   {
	   try
	   {
		   conn=DriverManager.getConnection(URL,"root","happy");
		   // conn  root/happy
	   }catch(Exception ex) {}
   }
   // 4. MySql���� ���� 
   public void disConnection()
   {
	   try
	   {
		   if(ps!=null) ps.close();
		   if(conn!=null) conn.close();
		   // /quit
	   }catch(Exception ex) {}
   }
   ////////////////////////// ~DAO�� �ʼ� ���� 
   // ��� ���� => ��� ��� 
   public ArrayList<SeoulLocationVO> seoulLocationData(int page)
   {
	   ArrayList<SeoulLocationVO> list=new ArrayList<SeoulLocationVO>();
	   try
	   {
		   // ���������� ����ÿ� �ҽ� 
		   // 1. ���� 
		   getConnection();
		   // 2. SQL���� ���� => MYSQL�� ������ ���� 
		   String sql="SELECT no,poster,name "
				     +"FROM seoul_location "
				     +"limit ?,?";
		   // limit ������ġ , ����  => 0,10 ==> 11,10
		   // 3. MYSQL�� ���� 
		   ps=conn.prepareStatement(sql);
		   // 4. ?�� ���� ä��� 
		   int rowSize=12;
		   int start=(rowSize*page)-rowSize;
		   // 1page = 0
		   // 2page = 12
		   ps.setInt(1, start);
		   ps.setInt(2, rowSize);
		   // 5. �����Ŀ� ������� ������ �´� 
		   ResultSet rs=ps.executeQuery();
		   while(rs.next()) // Ŀ���� ��ġ�� ù��° ��� ��ġ ==> previous()
		   {
			   // ���پ� �о�´� 
			   SeoulLocationVO vo=new SeoulLocationVO();
			   vo.setNo(rs.getInt(1));
			   vo.setPoster(rs.getString(2));
			   vo.setTitle(rs.getString(3));
			   
			   list.add(vo);
		   }
		   rs.close();
	   }catch(Exception ex)
	   {
		   // ���� Ȯ�� 
		   ex.printStackTrace(); // ���� ��ġ ���  => getMessage() : ���� ���븸 ��� 
	   }
	   finally
	   {
		   // MySQL �ݱ�
		   disConnection();
	   }
	   return list;
   }
   // �������� ���ϱ� 
   public int locationTotalPage()
   {
	   int total=0;
	   try
	   {
		   //1. ����
		   getConnection();
		   //2. SQL���� 
		   String sql="SELECT CEIL(COUNT(*)/12.0) FROM seoul_location";
		   ps=conn.prepareStatement(sql);
		   ResultSet rs=ps.executeQuery();
		   rs.next();
		   total=rs.getInt(1);
		   rs.close();
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   disConnection();
	   }
	   return total;
   }
}




