
executeQuery 와 executeUpdate 의 차이점

executeQuery 는 resultSet 을 만드는 sql문에서 사용합니다.
주로 SELECT 문을 수행할때 사용 됩니다


executeUpdate 는 INSERT 나 UPDATE와 같은 쿼리문에서 사용됩니다

Can not issue data manipulation statements with executeQuery().
update, insert, delete문을 사용할때 executeUpdate()로 전송하지 않았을 경우 발생한다.


executeUpdate() 리턴값은 쿼리를 전송해서 변화한 행의 객수를 나타낸다.






