<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
  <body>
       <form action="city" method="GET">
       <input type="text" name="cityName" placeHolder="Enter city" required>
       <button type="submit">Enter</button>
       </form>

       ${cities}
       ${randomCity}
  </body>
</html>