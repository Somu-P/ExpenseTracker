<%@ page import="java.sql.*" %>
<%@ page import="util.DbConfig" %>
<%
String user=(String)session.getAttribute("user");
if(user==null){
    response.sendRedirect("login.html");
    return;
}
Connection con =DbConfig.getConnection(application.getRealPath("/WEB-INF/.env"));
if(request.getParameter("title") != null){
    PreparedStatement ps=con.prepareStatement("insert into expenses(username, title, amount) values(?,?,?)");
    ps.setString(1,user);
    ps.setString(2,request.getParameter("title"));
    ps.setInt(3,Integer.parseInt(request.getParameter("amount")));
    ps.executeUpdate();
}
%>
<html>
    <head>
        <title>Dashboard</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <h2> Welcome <%=user%></h2>
        <form action="dashboard.jsp" method="post">
            <input type="text" name="title" placeholder="Expense Title">
            <input type="number" name="amount" placeholder="Amount">
            <input type="submit" value="Add Expense">
        </form> <br>
        <table>
            <tr>
                <th>Expense</th>
                <th>Amount</th>
            </tr>
            <%
            PreparedStatement ps=con.prepareStatement("select * from expenses where username=?");
            ps.setString(1,user);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                %>
                <tr>
                    <td><%=rs.getString(2)%></td>
                    <td><%=rs.getInt(3)%></td>
                </tr>
            <%
        }
            %>
        </table>
    </body>
</html>
