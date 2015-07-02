<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Book List</title>
</head>
<body>

<div>
    <table>
        <caption>Book List</caption>
        <tr>
            <th>Name</th>
            <th>Author</th>
            <th>Publish Year</th>
        </tr>

        <c:forEach items="${books}" var="book" varStatus="index">
            <tr>
                <td>
                    <c:out value="${book.name}"/>
                </td>
                <td>
                    <c:out value="${book.author}"/>
                </td>
                <td>
                    <c:out value="${book.publishYear}"/>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>