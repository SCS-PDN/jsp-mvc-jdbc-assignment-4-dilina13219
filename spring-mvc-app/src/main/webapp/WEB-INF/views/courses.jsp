<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Available Courses</title>
</head>
<body>
    <h2>Welcome! Here are the available courses:</h2>
    <table border="1" cellpadding="10">
        <tr>
            <th>Course ID</th>
            <th>Course Name</th>
            <th>Instructor</th>
            <th>Credits</th>
            <th>Action</th>
        </tr>
        
        <c:forEach items="${courses}" var="course">
            <tr>
                <td>${course.id}</td> <td>${course.name}</td>
                <td>${course.instructor}</td>
                <td>${course.credits}</td>
                <td>
                    <form action="${pageContext.request.contextPath}/register/${course.id}" method="POST">
                        <button type="submit">Register</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>