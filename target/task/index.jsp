<html>
<body>
<h2>Hello World!</h2>
<%request.getRequestDispatcher("/controller?command=show_all_customers_information").forward(request,response);%>
</body>
</html>
