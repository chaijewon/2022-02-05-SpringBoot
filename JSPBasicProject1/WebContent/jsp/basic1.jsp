<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.*,com.it.dao.*"%>
<%--
      JSP = Java+HTML
            Java : ������ �б� (MySQL,Webũ�Ѹ�(����))  
            HTML : �о�� �����͸� �������� ��� 
                                  ���������� �ν�(HTML,XML)
                                  �ڹٿ� HTML�� �и� 
      1. ������ 
         page : jsp�� ���� ���� (���� �Ѱ��� ���� ����)
                1) ��ȯ (���� Ÿ��) => �������� �����Ҷ� ���� ���� ���� 
                   HTML / XML / JSON => {Ű:��,Ű:��....} = �ڹٽ�ũ��Ʈ�� ��ü ���� 
                                ------ �Ľ� ���� ȣȯ���� ���� 
                   contentType="text/html;charset=EUC-KR" => UTF-8
                   contentType="text/xml;charset=EUC-KR"
                   contentType="text/plain;charset=EUC-KR"
                2) �ڹٶ��̺귯�� �߰� 
                   <%@ page import="java.util.*,java.io.*"%>
                   <%@ page import="java.util.*"%>
                   <%@ page import="java.io.*"%>
                3) ���������� ��� 
                   <%@ page errorPage="�̵��� ������"%>
                4) ��¹��� => 8kb => 16kb buffer
         taglib : �±׷� �ڹ� ���̺귯���� ���� 
                  <%
                      if(���ǹ�)
                      {
                  %>
                          HTML
                  <%    }
                      else
                      {
                  %>
                          HTML
                  <%    }
                  %>
                  
                  <c:if test="">
                    HTML
                  </c:if>
                  <c:if test="">
                    HTML
                  </c:if>
         include : JSP�ȿ� �ٸ� JSP�� �߰� => ������ 
      2. ��ũ��Ʈ 
                 �ڹ� �ڵ�
            = ��ũ��Ʈ�� : �Ϲ� �ڹ� �ҽ� => �������� , �޼ҵ� ȣ�� , ��� , ����ó��
                        <%
                            int a=10.... 
                                                  ���� �ڹٿ� ����   ; 
                            //
                            /* */ 
                        %> 
            = ����� : �޼ҵ� , �������  
                        <%!
                        
                        %> ====> ���󵵰� ���� 
            = ǥ���� : System.out.println()
                     <%= %>
                     
             a.jsp 
             ------
             public class a_jsp extends HttpServlet
             {
                <%! %>
                public void _jspInit()
                {
                    web.xml�� ������ ������ �о� �´� 
                }
                public void _jspDestory()
                {
                    System.gc() ==> ���ΰ�ħ , ȭ���̵� 
                }
                public void _jspService()
                {
                    ==> JSP 
                    <% %>
                    <%= %>
                }
             }
      3. ���尴ü
      4. �׼��±� 
      5. EL (ǥ����)
      6. JSTL (�±׶��̺귯��) 
      7. MVC 
 --%>
<%
    String strPage=request.getParameter("page");
    // ù�������� ����ڰ� ������ �� ���� 
    // ����Ʈ ������ ����� 
    if(strPage==null)
    	strPage="1";
    
    // ���� ������ ���� 
    int curpage=Integer.parseInt(strPage); // ���������� ��ȯ 
    // ���� �������� �ش�Ǵ� �����͸� �޴´� 
    SeoulDAO dao=SeoulDAO.newInstance();
    ArrayList<SeoulLocationVO> list=dao.seoulLocationData(curpage);
    // �������� �ޱ� 
    int totalpage=dao.locationTotalPage();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
  margin-top: 50px;
  /* 
     height: 1000px;
     border:1px solid red; 
     ctrl+shift+/ ctrl+shift+\
  */
}
.row{
   margin: 0px auto;
   width:1024px;
}
h1 {
   text-align: center
}
</style>
</head>
<body>
   <div class="container">
     <h1>���� ���</h1>
     <hr>
     <div class="row">
       <%
           for(SeoulLocationVO vo:list)
           {
        %>
               <div class="col-md-4">
			    <div class="thumbnail">
			      <a href="#">
			        <img src="<%=vo.getPoster() %>" alt="Lights" style="width:310px;height:250px">
			        <div class="caption">
			          <p><%=vo.getTitle() %></p>
			        </div>
			      </a>
			    </div>
			  </div>
        <%
           }
        %>
     </div>
     <div class="row">
       <div class="text-center">
         <a href="basic1.jsp?page=<%=curpage>1?curpage-1:curpage %>" class="btn btn-sm btn-danger">����</a>
         <%=curpage %> page / <%=totalpage %> pages
         <a href="basic1.jsp?page=<%=curpage<totalpage?curpage+1:curpage %>" class="btn btn-sm btn-danger">����</a>
       </div>
     </div>
   </div>
</body>
</html>









